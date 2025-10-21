package mrthomas20121.thermal_extra.block.entity;

import cofh.core.util.helpers.AugmentDataHelper;
import cofh.lib.api.block.IHarvestable;
import cofh.lib.api.block.entity.IAreaEffectTile;
import cofh.lib.api.block.entity.ITickableTile;
import cofh.lib.common.energy.EnergyStorageCoFH;
import cofh.lib.common.inventory.ItemStorageCoFH;
import cofh.thermal.core.common.config.ThermalCoreConfig;
import cofh.thermal.lib.common.block.entity.AugmentableBlockEntity;
import cofh.thermal.lib.util.ThermalEnergyHelper;
import mrthomas20121.thermal_extra.init.ThermalExtraBlockEntities;
import mrthomas20121.thermal_extra.inventory.device.DeviceHarvesterMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.util.FakePlayerFactory;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static cofh.core.util.helpers.AugmentableHelper.getAttributeMod;
import static cofh.core.util.helpers.AugmentableHelper.getAttributeModWithDefault;
import static cofh.lib.api.StorageGroup.INTERNAL;
import static cofh.lib.util.constants.NBTTags.*;
import static cofh.thermal.lib.util.ThermalAugmentRules.createAllowValidator;

public class DeviceHarvesterBlockEntity extends AugmentableBlockEntity implements ITickableTile.IServerTickable, IAreaEffectTile {

    public static boolean shouldReplant = true;

    public static final BiPredicate<ItemStack, List<ItemStack>> AUG_VALIDATOR = createAllowValidator(TAG_AUGMENT_TYPE_RF, TAG_AUGMENT_TYPE_AREA_EFFECT, TAG_AUGMENT_TYPE_UPGRADE);

    protected static final int BASE_PROCESS_MAX = 4000;

    protected ItemStorageCoFH chargeSlot = new ItemStorageCoFH(1, ThermalEnergyHelper::hasEnergyHandlerCap);

    public static boolean canHarvestNetherWart = true;

    protected static final int RADIUS = 2;
    protected int radius = RADIUS;
    protected AABB area;

    protected int process;
    protected int processMax = BASE_PROCESS_MAX * radius * radius;
    protected int processTick = getBaseProcessTick() / 4 * radius;

    public DeviceHarvesterBlockEntity(BlockPos pos, BlockState state) {

        super(ThermalExtraBlockEntities.HARVESTER.get(), pos, state);
        energyStorage = new EnergyStorageCoFH(BASE_ENERGY, BASE_ENERGY / 50);

        inventory.addSlot(chargeSlot, INTERNAL);

        addAugmentSlots(ThermalCoreConfig.deviceAugments);
        initHandlers();
    }

    @Override
    public void tickServer() {

        boolean curActive = isActive;
        if (isActive) {
            if (energyStorage.getEnergyStored() >= processTick) {
                process += processTick;
                energyStorage.modify(-processTick);
                if (process >= processMax) {
                    process -= processMax;
                    BlockPos.betweenClosedStream(worldPosition.offset(-radius, -2, -radius), worldPosition.offset(radius, 1, radius))
                            .forEach(this::dropBlock);
                }
            } else {
                isActive = false;
            }
        } else if (redstoneControl.getState() && energyStorage.getEnergyStored() >= processTick) {
            isActive = true;
        }
        updateActiveState(curActive);
        chargeEnergy();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {

        return new DeviceHarvesterMenu(i, level, worldPosition, inventory, player);
    }

    // region GUI
    @Override
    public int getCurSpeed() {

        return isActive ? processTick : 0;
    }

    @Override
    public int getScaledProgress(int scale) {

        if (!isActive || processMax <= 0 || process <= 0) {
            return 0;
        }
        return scale * Math.min(process, processMax) / processMax;
    }
    // endregion

    // region NETWORK
    @Override
    public FriendlyByteBuf getGuiPacket(FriendlyByteBuf buffer) {

        super.getGuiPacket(buffer);

        buffer.writeInt(process);
        buffer.writeInt(processMax);
        buffer.writeInt(processTick);

        return buffer;
    }

    @Override
    public void handleGuiPacket(FriendlyByteBuf buffer) {

        super.handleGuiPacket(buffer);

        process = buffer.readInt();
        processMax = buffer.readInt();
        processTick = buffer.readInt();
    }
    // endregion

    // region NBT
    @Override
    public void load(CompoundTag nbt) {

        super.load(nbt);

        process = nbt.getInt(TAG_PROCESS);
        processMax = nbt.getInt(TAG_PROCESS_MAX);
        processTick = nbt.getInt(TAG_PROCESS_TICK);
    }

    @Override
    public void saveAdditional(CompoundTag nbt) {

        super.saveAdditional(nbt);

        nbt.putInt(TAG_PROCESS, process);
        nbt.putInt(TAG_PROCESS_MAX, processMax);
        nbt.putInt(TAG_PROCESS_TICK, processTick);
    }
    // endregion

    // region HELPERS
    public int getRadius() {

        return radius;
    }

    protected void dropBlock(BlockPos pos) {
        BlockState state = this.level.getBlockState(pos);
        Block block = state.getBlock();

        Player player = FakePlayerFactory.getMinecraft((ServerLevel) this.level);

        // IHarvestables are smart! They handle their own replanting.
        if (block instanceof IHarvestable harvestable) {
            if (harvestable.canHarvest(state)) {
                harvestable.harvest(this.level, pos, state, player, shouldReplant);
                return;
            }
        }

        boolean seedDrop = false;

        if (block instanceof CropBlock crop) {
            BlockPos below = pos.below();
            BlockState belowState = this.level.getBlockState(below);

            shouldReplant &= belowState.getBlock().canSustainPlant(belowState, this.level, below, Direction.UP, crop);

            if (crop.isMaxAge(state)) {
                if (!this.level.isClientSide) {
                    List<ItemStack> drops = Block.getDrops(state, (ServerLevel) this.level, pos, null, player, player.getMainHandItem());
                    Item seedItem = crop.getCloneItemStack(this.level, pos, state).getItem();
                    for (ItemStack drop : drops) {
                        if (shouldReplant && !seedDrop) {
                            if (drop.getItem() == seedItem) {
                                drop.shrink(1);
                                seedDrop = true;
                            }
                        }
                        if (!drop.isEmpty()) {
                            Containers.dropItemStack(this.level, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, drop);
                        }
                    }
                    this.level.destroyBlock(pos, false, player);
                    if (seedDrop) {
                        this.level.setBlock(pos, crop.getStateForAge(0), 3);
                    }
                }
            }
        } else if (block instanceof NetherWartBlock crop && canHarvestNetherWart) {
            BlockPos below = pos.below();
            BlockState belowState = this.level.getBlockState(below);

            shouldReplant &= belowState.getBlock().canSustainPlant(belowState, this.level, below, Direction.UP, crop);

            if (state.getValue(NetherWartBlock.AGE) >= 3) {
                if (!this.level.isClientSide) {
                    List<ItemStack> drops = Block.getDrops(state, (ServerLevel) this.level, pos, null, player, player.getMainHandItem());
                    Item seedItem = crop.getCloneItemStack(this.level, pos, state).getItem();
                    for (ItemStack drop : drops) {
                        if (shouldReplant && !seedDrop) {
                            if (drop.getItem() == seedItem) {
                                drop.shrink(1);
                                seedDrop = true;
                            }
                        }
                        if (!drop.isEmpty()) {
                            Containers.dropItemStack(this.level, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, drop);
                        }
                    }
                    this.level.destroyBlock(pos, false, player);
                    if (seedDrop) {
                        this.level.setBlock(pos, crop.defaultBlockState(), 3);
                    }
                }
            }
        } else if (block instanceof CocoaBlock crop) {
            shouldReplant &= crop.canSurvive(state, this.level, pos);

            if (state.getValue(CocoaBlock.AGE) >= 2) {
                if (!this.level.isClientSide) {
                    Direction facing = state.getValue(CocoaBlock.FACING);
                    List<ItemStack> drops = Block.getDrops(state, (ServerLevel) this.level, pos, null, player, player.getMainHandItem());
                    Item seedItem = new ItemStack(crop).getItem();
                    for (ItemStack drop : drops) {
                        if (shouldReplant && !seedDrop) {
                            if (drop.getItem() == seedItem) {
                                drop.shrink(1);
                                seedDrop = true;
                            }
                        }
                        if (!drop.isEmpty()) {
                            Containers.dropItemStack(this.level, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, drop);
                        }
                    }
                    this.level.destroyBlock(pos, false, player);
                    if (seedDrop) {
                        this.level.setBlock(pos, crop.defaultBlockState().setValue(CocoaBlock.FACING, facing), 3);
                    }
                }
            }
        }
    }

    protected void chargeEnergy() {

        if (!chargeSlot.isEmpty()) {
            chargeSlot.getItemStack()
                    .getCapability(ThermalEnergyHelper.getBaseEnergySystem(), null)
                    .ifPresent(c -> energyStorage.receiveEnergy(c.extractEnergy(Math.min(energyStorage.getMaxReceive(), energyStorage.getSpace()), false), false));
        }
    }
    // endregion

    // region AUGMENTS
    @Override
    protected Predicate<ItemStack> augValidator() {

        return item -> AugmentDataHelper.hasAugmentData(item) && AUG_VALIDATOR.test(item, getAugmentsAsList());
    }

    @Override
    protected void resetAttributes() {

        super.resetAttributes();

        radius = RADIUS;
    }

    @Override
    protected void setAttributesFromAugment(CompoundTag augmentData) {

        super.setAttributesFromAugment(augmentData);

        radius += (int) getAttributeMod(augmentData, TAG_AUGMENT_RADIUS);
    }

    @Override
    protected void finalizeAttributes(Map<Enchantment, Integer> enchantmentMap) {

        super.finalizeAttributes(enchantmentMap);
        float baseMod = getAttributeModWithDefault(augmentNBT, TAG_AUGMENT_BASE_MOD, 1.0F);

        processMax = BASE_PROCESS_MAX * (1 + radius);
        processTick = Math.round(getBaseProcessTick() * baseMod);
        area = null;
    }

    //@Override
    public boolean hasFilterSlot() {

        return false;
    }
    // endregion

    // region IAreaEffectTile
    @Override
    public AABB getArea() {

        if (area == null) {
            area = new AABB(worldPosition.offset(-radius, -1, -radius), worldPosition.offset(1 + radius, 1, 1 + radius));
        }
        return area;
    }

    @Override
    public int getColor() {

        return isActive ? 0x78E86F : 0x555555;
    }
    // endregion
}
