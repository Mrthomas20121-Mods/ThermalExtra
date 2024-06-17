package mrthomas20121.thermal_extra.block.entity;

import cofh.core.util.helpers.FluidHelper;
import cofh.lib.common.fluid.FluidStorageCoFH;
import cofh.lib.common.inventory.ItemStorageCoFH;
import cofh.thermal.core.common.config.ThermalCoreConfig;
import cofh.thermal.lib.common.block.entity.MachineBlockEntity;
import mrthomas20121.thermal_extra.init.ThermalExtraBlockEntities;
import mrthomas20121.thermal_extra.inventory.machine.MachineEndothermicDehydratorMenu;
import mrthomas20121.thermal_extra.recipe.EndothermicDehydratorRecipeManager;
import mrthomas20121.thermal_extra.recipe.MetalInfuserRecipeManager;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;

import static cofh.lib.api.StorageGroup.*;
import static cofh.lib.util.Constants.*;

public class MachineEndothermicDehydratorBlockEntity extends MachineBlockEntity {

    protected ItemStorageCoFH inputSlot = new ItemStorageCoFH(item -> filter.valid(item) && EndothermicDehydratorRecipeManager.instance().validItem(item));
    protected FluidStorageCoFH inputTank = new FluidStorageCoFH(TANK_MEDIUM, fluid -> filter.valid(fluid) && EndothermicDehydratorRecipeManager.instance().validFluid(fluid));
    protected FluidStorageCoFH outputTank = new FluidStorageCoFH(TANK_MEDIUM);

    public MachineEndothermicDehydratorBlockEntity(BlockPos pos, BlockState state) {

        super(ThermalExtraBlockEntities.ENDOTHERMIC_DEHYDRATOR.get(), pos, state);

        inventory.addSlots(OUTPUT, 6);
        inventory.addSlot(chargeSlot, INTERNAL);

        inventory.addSlot(inputSlot, INPUT);

        tankInv.addTank(inputTank, INPUT);
        tankInv.addTank(outputTank, OUTPUT);

        renderFluid = new FluidStack(Fluids.WATER, BUCKET_VOLUME);

        addAugmentSlots(ThermalCoreConfig.machineAugments);
        initHandlers();
    }

    @Override
    protected int getBaseProcessTick() {

        return EndothermicDehydratorRecipeManager.instance().getBasePower();
    }

    @Override
    protected boolean cacheRecipe() {

        curRecipe = EndothermicDehydratorRecipeManager.instance().getRecipe(this);
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

        return new MachineEndothermicDehydratorMenu(i, level, worldPosition, inventory, player);
    }

    // region OPTIMIZATION
    @Override
    protected boolean validateInputs() {

        if (!cacheRecipe()) {
            return false;
        }
        return inputTank.getAmount() >= fluidInputCounts.get(0);
    }
    // endregion


}
