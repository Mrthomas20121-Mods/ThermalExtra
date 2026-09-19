package mrthomas20121.thermal_extra.util;

import cofh.core.common.config.IBaseConfig;
import mrthomas20121.thermal_extra.block.entity.DeviceHarvesterBlockEntity;
import mrthomas20121.thermal_extra.recipe.*;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.function.Supplier;

public class ThermalExtraConfig implements IBaseConfig {

    private Supplier<Boolean> harvesterNetherWart;

    private Supplier<Boolean> harvesterReplantBlock;

    private Supplier<Integer> dynamoColdPower;
    private Supplier<Integer> dynamoTerraceousPower;
    private Supplier<Integer> machineAdvancedRefineryPower;
    private Supplier<Integer> machineComponentAssemblyPower;
    private Supplier<Integer> machineEndothermicDehydratorPower;
    private Supplier<Integer> machineFluidMixerPower;
    private Supplier<Integer> machineNitraticIgniterPower;

    @Override
    public void apply(ForgeConfigSpec.Builder builder) {
        builder.push("Devices");

        builder.push("Harvester");

        harvesterNetherWart = builder
                .comment("Should Nether Wart be harvestable by the Harvester?")
                .define("Nether Wart Harvest", true);

        harvesterReplantBlock = builder
                .comment("Should the Harvester replant blocks?")
                .define("Replant", true);

        builder.pop();

        builder.pop();

        builder.push("Dynamos");

        builder.push("Cold Dynamo");

        dynamoColdPower = builder
                .comment("This sets the base power generation (RF/t) for the Cold Dynamo.")
                .defineInRange("Base Power", ColdFuelManager.instance().getBasePower(), ColdFuelManager.instance().getMinPower(), ColdFuelManager.instance().getMaxPower());

        builder.pop();

        builder.push("Terraceous Dynamo");

        dynamoTerraceousPower = builder
                .comment("This sets the base power generation (RF/t) for the Terraceous Dynamo.")
                .defineInRange("Base Power", TerraceousFuelManager.instance().getBasePower(), TerraceousFuelManager.instance().getMinPower(), TerraceousFuelManager.instance().getMaxPower());

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

        builder.pop();
    }

    @Override
    public void refresh() {

        if(harvesterNetherWart != null) {
            DeviceHarvesterBlockEntity.canHarvestNetherWart = harvesterNetherWart.get();
        }

        if(harvesterReplantBlock != null) {
            DeviceHarvesterBlockEntity.shouldReplant = harvesterReplantBlock.get();
        }

        if (dynamoColdPower != null) {
            ColdFuelManager.instance().setBasePower(dynamoColdPower.get());
        }

        if (dynamoTerraceousPower != null) {
            TerraceousFuelManager.instance().setBasePower(dynamoTerraceousPower.get());
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
