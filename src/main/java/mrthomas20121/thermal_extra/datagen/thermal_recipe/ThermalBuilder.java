package mrthomas20121.thermal_extra.datagen.thermal_recipe;

import cofh.core.common.item.IAugmentableItem;
import cofh.thermal.core.init.registries.TCoreRecipeSerializers;
import cofh.thermal.core.util.recipes.machine.*;

public class ThermalBuilder {

    public static ThermalRecipeBuilder<SmelterRecipe> smelter() {
        return new ThermalRecipeBuilder<>(TCoreRecipeSerializers.SMELTER_RECIPE_SERIALIZER.get());
    }

    public static ThermalRecipeBuilder<FurnaceRecipe> furnace() {
        return new ThermalRecipeBuilder<>(TCoreRecipeSerializers.FURNACE_RECIPE_SERIALIZER.get());
    }

    public static ThermalRecipeBuilder<SawmillRecipe> sawmill() {
        return new ThermalRecipeBuilder<>(TCoreRecipeSerializers.SAWMILL_RECIPE_SERIALIZER.get());
    }

    public static ThermalRecipeBuilder<PulverizerRecipe> pulverizer() {
        return new ThermalRecipeBuilder<>(TCoreRecipeSerializers.PULVERIZER_RECIPE_SERIALIZER.get());
    }

    public static CatalystBuilder<PulverizerCatalyst> pulverizerCatalyst() {
        return new CatalystBuilder<>(TCoreRecipeSerializers.PULVERIZER_CATALYST_SERIALIZER.get());
    }

    public static CatalystBuilder<InsolatorCatalyst> insolatorCatalyst() {
        return new CatalystBuilder<>(TCoreRecipeSerializers.INSOLATOR_CATALYST_SERIALIZER.get());
    }

    public static CatalystBuilder<SmelterCatalyst> smelterCatalyst() {
        return new CatalystBuilder<>(TCoreRecipeSerializers.SMELTER_CATALYST_SERIALIZER.get());
    }

    public static MultiCatalystBuilder multiCatalyst() {
        return new MultiCatalystBuilder();
    }


}
