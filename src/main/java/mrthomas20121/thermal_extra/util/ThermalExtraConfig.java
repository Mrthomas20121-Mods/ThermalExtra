package mrthomas20121.thermal_extra.util;

import cofh.core.common.config.IBaseConfig;
import cofh.thermal.core.util.managers.machine.FurnaceRecipeManager;
import mrthomas20121.thermal_extra.recipe.*;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.function.Supplier;

public class ThermalExtraConfig implements IBaseConfig {

    private Supplier<Integer> dynamoColdPower;
    private Supplier<Integer> machineAdvancedRefineryPower;
    private Supplier<Integer> machineComponentAssemblyPower;
    private Supplier<Integer> machineEndothermicDehydratorPower;
    private Supplier<Integer> machineFluidMixerPower;
    private Supplier<Integer> machineNitraticIgniterPower;

    @Override
    public void apply(ForgeConfigSpec.Builder builder) {
        builder.push("Dynamos");

        builder.push("Stirling");

        dynamoColdPower = builder
                .comment("This sets the base power generation (RF/t) for the Cold Dynamo.")
                .defineInRange("Base Power", ColdFuelManager.instance().getBasePower(), ColdFuelManager.instance().getMinPower(), ColdFuelManager.instance().getMaxPower());

        builder.pop();

        builder.pop();

        builder.push("Machines");

        builder.push("Advanced Refinery");

        machineAdvancedRefineryPower = builder
                .comment("This sets the base power consumption (RF/t) for the Advanced Refinery.")
                .defineInRange("Base Power", AdvancedRefineryRecipeManager.instance().getBasePower(), AdvancedRefineryRecipeManager.instance().getMinPower(), AdvancedRefineryRecipeManager.instance().getMaxPower());

        builder.pop();

        builder.push("Component Assembly");

        machineComponentAssemblyPower = builder
                .comment("This sets the base power consumption (RF/t) for the Component Assembly.")
                .defineInRange("Base Power", ComponentAssemblyRecipeManager.instance().getBasePower(), ComponentAssemblyRecipeManager.instance().getMinPower(), ComponentAssemblyRecipeManager.instance().getMaxPower());

        builder.pop();

        builder.push("Endothermic Dehydrator");

        machineEndothermicDehydratorPower = builder
                .comment("This sets the base power consumption (RF/t) for the Endothermic Dehydrator.")
                .defineInRange("Base Power", EndothermicDehydratorRecipeManager.instance().getBasePower(), EndothermicDehydratorRecipeManager.instance().getMinPower(), EndothermicDehydratorRecipeManager.instance().getMaxPower());

        builder.pop();

        builder.push("Fluid Mixer");

        machineFluidMixerPower = builder
                .comment("This sets the base power consumption (RF/t) for the Fluid Mixer.")
                .defineInRange("Base Power", FluidMixerRecipeManager.instance().getBasePower(), FluidMixerRecipeManager.instance().getMinPower(), FluidMixerRecipeManager.instance().getMaxPower());

        builder.pop();

        builder.push("Nitratic Igniter");

        machineNitraticIgniterPower = builder
                .comment("This sets the base power consumption (RF/t) for the Nitratic Igniter.")
                .defineInRange("Base Power", NitraticIgniterRecipeManager.instance().getBasePower(), NitraticIgniterRecipeManager.instance().getMinPower(), NitraticIgniterRecipeManager.instance().getMaxPower());

        builder.pop();
    }

    @Override
    public void refresh() {
        if (dynamoColdPower != null) {
            ColdFuelManager.instance().setBasePower(dynamoColdPower.get());
        }

        if (machineAdvancedRefineryPower != null) {
            AdvancedRefineryRecipeManager.instance().setBasePower(machineAdvancedRefineryPower.get());
        }

        if (machineComponentAssemblyPower != null) {
            ComponentAssemblyRecipeManager.instance().setBasePower(machineComponentAssemblyPower.get());
        }

        if (machineEndothermicDehydratorPower != null) {
            EndothermicDehydratorRecipeManager.instance().setBasePower(machineEndothermicDehydratorPower.get());
        }

        if (machineFluidMixerPower != null) {
            FluidMixerRecipeManager.instance().setBasePower(machineFluidMixerPower.get());
        }

        if (machineNitraticIgniterPower != null) {
            NitraticIgniterRecipeManager.instance().setBasePower(machineNitraticIgniterPower.get());
        }
    }
}
