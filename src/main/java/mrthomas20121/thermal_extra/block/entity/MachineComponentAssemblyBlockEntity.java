package mrthomas20121.thermal_extra.block.entity;

import cofh.core.util.helpers.FluidHelper;
import cofh.lib.client.sounds.ConditionalSoundInstance;
import cofh.lib.common.fluid.FluidStorageCoFH;
import cofh.lib.common.inventory.ItemStorageCoFH;
import cofh.thermal.core.common.config.ThermalCoreConfig;
import cofh.thermal.core.common.item.SlotSealItem;
import cofh.thermal.lib.common.block.entity.MachineBlockEntity;
import mrthomas20121.thermal_extra.init.ThermalExtraBlockEntities;
import mrthomas20121.thermal_extra.inventory.machine.MachineComponentAssemblyMenu;
import mrthomas20121.thermal_extra.recipe.ComponentAssemblyRecipeManager;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;

import static cofh.core.util.helpers.ItemHelper.itemsEqual;
import static cofh.lib.api.StorageGroup.*;
import static cofh.lib.util.Constants.BUCKET_VOLUME;
import static cofh.lib.util.Constants.TANK_MEDIUM;
import static cofh.thermal.expansion.init.registries.TExpSounds.SOUND_MACHINE_CRUCIBLE;

public class MachineComponentAssemblyBlockEntity extends MachineBlockEntity {

    protected ItemStorageCoFH[] inputSlots = new ItemStorageCoFH[6];
    protected ItemStorageCoFH outputSlot = new ItemStorageCoFH();
    protected FluidStorageCoFH inputTank = new FluidStorageCoFH(TANK_MEDIUM, fluid -> filter.valid(fluid) && ComponentAssemblyRecipeManager.instance().validFluid(fluid));
    protected FluidStorageCoFH outputTank = new FluidStorageCoFH(TANK_MEDIUM);

    public MachineComponentAssemblyBlockEntity(BlockPos pos, BlockState state) {

        super(ThermalExtraBlockEntities.COMPONENT_ASSEMBLY.get(), pos, state);

        inputSlots[0] = new ItemStorageCoFH(item -> item.getItem() instanceof SlotSealItem || filter.valid(item) && ComponentAssemblyRecipeManager.instance().validItem(item) && !itemsEqual(item, inputSlots[1].getItemStack()) && !itemsEqual(item, inputSlots[2].getItemStack()) && !itemsEqual(item, inputSlots[3].getItemStack()) && !itemsEqual(item, inputSlots[4].getItemStack()) && !itemsEqual(item, inputSlots[5].getItemStack()));
        inputSlots[1] = new ItemStorageCoFH(item -> item.getItem() instanceof SlotSealItem || filter.valid(item) && ComponentAssemblyRecipeManager.instance().validItem(item) && !itemsEqual(item, inputSlots[0].getItemStack()) && !itemsEqual(item, inputSlots[2].getItemStack()) && !itemsEqual(item, inputSlots[3].getItemStack()) && !itemsEqual(item, inputSlots[4].getItemStack()) && !itemsEqual(item, inputSlots[5].getItemStack()));
        inputSlots[2] = new ItemStorageCoFH(item -> item.getItem() instanceof SlotSealItem || filter.valid(item) && ComponentAssemblyRecipeManager.instance().validItem(item) && !itemsEqual(item, inputSlots[0].getItemStack()) && !itemsEqual(item, inputSlots[1].getItemStack()) && !itemsEqual(item, inputSlots[3].getItemStack()) && !itemsEqual(item, inputSlots[4].getItemStack()) && !itemsEqual(item, inputSlots[5].getItemStack()));
        inputSlots[3] = new ItemStorageCoFH(item -> item.getItem() instanceof SlotSealItem || filter.valid(item) && ComponentAssemblyRecipeManager.instance().validItem(item) && !itemsEqual(item, inputSlots[0].getItemStack()) && !itemsEqual(item, inputSlots[1].getItemStack()) && !itemsEqual(item, inputSlots[2].getItemStack()) && !itemsEqual(item, inputSlots[4].getItemStack()) && !itemsEqual(item, inputSlots[5].getItemStack()));
        inputSlots[4] = new ItemStorageCoFH(item -> item.getItem() instanceof SlotSealItem || filter.valid(item) && ComponentAssemblyRecipeManager.instance().validItem(item) && !itemsEqual(item, inputSlots[0].getItemStack()) && !itemsEqual(item, inputSlots[1].getItemStack()) && !itemsEqual(item, inputSlots[2].getItemStack()) && !itemsEqual(item, inputSlots[3].getItemStack()) && !itemsEqual(item, inputSlots[5].getItemStack()));
        inputSlots[5] = new ItemStorageCoFH(item -> item.getItem() instanceof SlotSealItem || filter.valid(item) && ComponentAssemblyRecipeManager.instance().validItem(item) && !itemsEqual(item, inputSlots[0].getItemStack()) && !itemsEqual(item, inputSlots[1].getItemStack()) && !itemsEqual(item, inputSlots[2].getItemStack()) && !itemsEqual(item, inputSlots[3].getItemStack()) && !itemsEqual(item, inputSlots[4].getItemStack()));

        for(int i = 0; i < 6; ++i) {
            inventory.addSlot(inputSlots[i], INPUT);
        }

        tankInv.addTank(inputTank, INPUT);
        inventory.addSlot(outputSlot, OUTPUT);
        tankInv.addTank(outputTank, OUTPUT);
        inventory.addSlot(chargeSlot, INTERNAL);

        renderFluid = new FluidStack(Fluids.WATER, BUCKET_VOLUME);

        addAugmentSlots(ThermalCoreConfig.machineAugments);
        initHandlers();
    }

    @Override
    protected int getBaseProcessTick() {
        return ComponentAssemblyRecipeManager.instance().getBasePower();
    }

    @Override
    protected boolean cacheRecipe() {

        curRecipe = ComponentAssemblyRecipeManager.instance().getRecipe(this);
        if (curRecipe != null) {
            itemInputCounts = curRecipe.getInputItemCounts(this);
            fluidInputCounts = curRecipe.getInputFluidCounts(this);
        }
        return curRecipe != null;
    }

    @Override
    protected boolean cacheRenderFluid() {

        if (curRecipe == null) {
            return false;
        }
        if (inputTank.isEmpty()) {
            // This should definitely never happen, but who knows.
            return false;
        }
        FluidStack prevFluid = renderFluid;
        renderFluid = new FluidStack(inputTank.getFluidStack(), BUCKET_VOLUME);
        return !FluidHelper.fluidsEqual(renderFluid, prevFluid);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {

        return new MachineComponentAssemblyMenu(i, level, worldPosition, inventory, player);
    }

    @Override
    protected Object getSound() {

        return new ConditionalSoundInstance(SOUND_MACHINE_CRUCIBLE.get(), SoundSource.AMBIENT, this, () -> !remove && isActive);
    }

}