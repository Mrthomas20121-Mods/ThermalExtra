package mrthomas20121.thermal_extra.block.entity;

import cofh.lib.client.sounds.ConditionalSoundInstance;
import cofh.lib.common.inventory.ItemStorageCoFH;
import cofh.lib.util.helpers.MathHelper;
import cofh.thermal.core.common.config.ThermalCoreConfig;
import cofh.thermal.core.common.item.SlotSealItem;
import cofh.thermal.lib.common.block.entity.MachineBlockEntity;
import mrthomas20121.thermal_extra.init.ThermalExtraBlockEntities;
import mrthomas20121.thermal_extra.inventory.machine.MachineNitraticIgniterMenu;
import mrthomas20121.thermal_extra.recipe.NitraticIgniterRecipeManager;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

import static cofh.core.util.helpers.AugmentableHelper.getAttributeMod;
import static cofh.core.util.helpers.ItemHelper.itemsEqual;
import static cofh.core.util.helpers.ItemHelper.itemsEqualWithTags;
import static cofh.lib.api.StorageGroup.*;
import static cofh.lib.util.constants.NBTTags.TAG_AUGMENT_FEATURE_CYCLE_PROCESS;
import static cofh.thermal.expansion.init.registries.TExpSounds.SOUND_MACHINE_SMELTER;

public class MachineNitraticIgniterBlockEntity extends MachineBlockEntity {

    protected ItemStorageCoFH[] inputSlots = new ItemStorageCoFH[3];
    protected ItemStorageCoFH catalystSlot = new ItemStorageCoFH(item -> item.getItem() instanceof SlotSealItem || NitraticIgniterRecipeManager.instance().validCatalyst(item) && !itemsEqual(item, inputSlots[0].getItemStack()) && !itemsEqual(item, inputSlots[1].getItemStack()) && !itemsEqual(item, inputSlots[2].getItemStack()));

    public MachineNitraticIgniterBlockEntity(BlockPos pos, BlockState state) {

        super(ThermalExtraBlockEntities.NITRATIC_IGNITER.get(), pos, state);



        inputSlots[0] = new ItemStorageCoFH(item -> item.getItem() instanceof SlotSealItem || filter.valid(item) && NitraticIgniterRecipeManager.instance().validItem(item) && !itemsEqual(item, inputSlots[1].getItemStack()) && !itemsEqual(item, inputSlots[2].getItemStack()) && !itemsEqual(item, catalystSlot.getItemStack()));
        inputSlots[1] = new ItemStorageCoFH(item -> item.getItem() instanceof SlotSealItem || filter.valid(item) && NitraticIgniterRecipeManager.instance().validItem(item) && !itemsEqual(item, inputSlots[0].getItemStack()) && !itemsEqual(item, inputSlots[2].getItemStack()) && !itemsEqual(item, catalystSlot.getItemStack()));
        inputSlots[2] = new ItemStorageCoFH(item -> item.getItem() instanceof SlotSealItem || filter.valid(item) && NitraticIgniterRecipeManager.instance().validItem(item) && !itemsEqual(item, inputSlots[0].getItemStack()) && !itemsEqual(item, inputSlots[1].getItemStack()) && !itemsEqual(item, catalystSlot.getItemStack()));

        for (int i = 0; i < 3; ++i) {
            inventory.addSlot(inputSlots[i], INPUT);
        }
        inventory.addSlot(catalystSlot, CATALYST);
        inventory.addSlots(OUTPUT, 4);
        inventory.addSlot(chargeSlot, INTERNAL);

        addAugmentSlots(ThermalCoreConfig.machineAugments);
        initHandlers();
    }

    @Override
    protected int getBaseProcessTick() {

        return NitraticIgniterRecipeManager.instance().getBasePower();
    }

    @Override
    protected boolean cacheRecipe() {

        curRecipe = NitraticIgniterRecipeManager.instance().getRecipe(this);
        curCatalyst = NitraticIgniterRecipeManager.instance().getCatalyst(catalystSlot);
        if (curRecipe != null) {
            itemInputCounts = curRecipe.getInputItemCounts(this);
        }
        return curRecipe != null && curCatalyst != null;
    }

    @Override
    protected void resolveInputs() {

        // Input Items
        for (int i = 0; i < 3; ++i) {
            inputSlots[i].modify(-itemInputCounts.get(i));
        }
        if (cyclicProcessingFeature && !catalystSlot.isEmpty() && !catalystSlot.isFull()) {
            ItemStack catalyst = catalystSlot.getItemStack();
            for (ItemStorageCoFH slot : outputSlots()) {
                if (itemsEqualWithTags(slot.getItemStack(), catalyst)) {
                    slot.modify(-1);
                    catalystSlot.modify(1);
                    break;
                }
            }
        }
        int decrement = itemInputCounts.size() > 3 ? itemInputCounts.get(3) : 0;
        if (decrement > 0) {
            if (catalystSlot.getItemStack().isDamageableItem()) {
                if (catalystSlot.getItemStack().hurt(decrement, MathHelper.RANDOM, null)) {
                    catalystSlot.modify(-1);
                }
            } else {
                catalystSlot.modify(-decrement);
            }
        }
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {

        return new MachineNitraticIgniterMenu(i, level, worldPosition, inventory, player);
    }

    @Override
    protected Object getSound() {

        return new ConditionalSoundInstance(SOUND_MACHINE_SMELTER.get(), SoundSource.AMBIENT, this, () -> !remove && isActive);
    }

    // region OPTIMIZATION
    @Override
    protected boolean validateInputs() {

        if (!cacheRecipe()) {
            return false;
        }
        List<? extends ItemStorageCoFH> slotInputs = inputSlots();
        for (int i = 0; i < slotInputs.size() && i < itemInputCounts.size(); ++i) {
            int inputCount = itemInputCounts.get(i);
            if (slotInputs.get(i).getItemStack().getCount() < inputCount) {
                return false;
            }
        }
        return true;
    }
    // endregion

    // region AUGMENTS
    protected boolean cyclicProcessingFeature = false;

    @Override
    protected void resetAttributes() {

        super.resetAttributes();

        cyclicProcessingFeature = false;
    }

    @Override
    protected void setAttributesFromAugment(CompoundTag augmentData) {

        super.setAttributesFromAugment(augmentData);

        cyclicProcessingFeature |= getAttributeMod(augmentData, TAG_AUGMENT_FEATURE_CYCLE_PROCESS) > 0;
    }
    // endregion
}
