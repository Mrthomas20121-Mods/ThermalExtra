package mrthomas20121.thermal_extra.block.entity;

import cofh.core.util.helpers.FluidHelper;
import cofh.lib.common.fluid.FluidStorageCoFH;
import cofh.thermal.core.common.config.ThermalCoreConfig;
import cofh.thermal.lib.common.block.entity.MachineBlockEntity;
import mrthomas20121.thermal_extra.init.ThermalExtraBlockEntities;
import mrthomas20121.thermal_extra.inventory.machine.MachineFluidMixerMenu;
import mrthomas20121.thermal_extra.recipe.FluidMixerRecipeManager;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;

import static cofh.lib.api.StorageGroup.*;
import static cofh.lib.util.Constants.BUCKET_VOLUME;
import static cofh.lib.util.Constants.TANK_MEDIUM;

public class MachineFluidMixerBlockEntity extends MachineBlockEntity {

    protected FluidStorageCoFH inputTank1 = new FluidStorageCoFH(TANK_MEDIUM, fluid -> filter.valid(fluid) && FluidMixerRecipeManager.instance().validRecipe(fluid));
    protected FluidStorageCoFH inputTank2 = new FluidStorageCoFH(TANK_MEDIUM, fluid -> filter.valid(fluid) && FluidMixerRecipeManager.instance().validRecipe(fluid));
    protected FluidStorageCoFH outputTankA = new FluidStorageCoFH(TANK_MEDIUM);
    protected FluidStorageCoFH outputTankB = new FluidStorageCoFH(TANK_MEDIUM);

    public MachineFluidMixerBlockEntity(BlockPos pos, BlockState state) {

        super(ThermalExtraBlockEntities.FLUID_MIXER.get(), pos, state);

        inventory.addSlot(chargeSlot, INTERNAL);

        tankInv.addTank(inputTank1, INPUT);
        tankInv.addTank(inputTank2, INPUT);
        tankInv.addTank(outputTankA, OUTPUT);
        tankInv.addTank(outputTankB, OUTPUT);

        renderFluid = new FluidStack(Fluids.WATER, BUCKET_VOLUME);

        addAugmentSlots(ThermalCoreConfig.machineAugments);
        initHandlers();
    }

    @Override
    protected int getBaseProcessTick() {

        return FluidMixerRecipeManager.instance().getBasePower();
    }

    @Override
    protected boolean cacheRecipe() {

        curRecipe = FluidMixerRecipeManager.instance().getRecipe(this);
        if (curRecipe != null) {
            fluidInputCounts = curRecipe.getInputFluidCounts(this);
        }
        return curRecipe != null;
    }

    @Override
    protected boolean cacheRenderFluid() {

        if (curRecipe == null) {
            return false;
        }
        if (inputTank1.isEmpty()) {
            // This should definitely never happen, but who knows.
            return false;
        }
        FluidStack prevFluid = renderFluid;
        renderFluid = new FluidStack(inputTank1.getFluidStack(), BUCKET_VOLUME);
        return !FluidHelper.fluidsEqual(renderFluid, prevFluid);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {

        return new MachineFluidMixerMenu(i, level, worldPosition, inventory, player);
    }

    // region OPTIMIZATION
    @Override
    protected boolean validateInputs() {

        if (!cacheRecipe()) {
            return false;
        }
        return inputTank1.getAmount() >= fluidInputCounts.get(0) && inputTank2.getAmount() >= fluidInputCounts.get(1);
    }
    // endregion
}
