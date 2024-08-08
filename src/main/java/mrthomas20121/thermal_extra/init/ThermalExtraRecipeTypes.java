package mrthomas20121.thermal_extra.init;

import cofh.lib.util.DeferredRegisterCoFH;
import cofh.lib.util.recipes.SerializableRecipeType;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.recipe.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ThermalExtraRecipeTypes {


    public static final DeferredRegisterCoFH<RecipeType<?>> RECIPE_TYPES = DeferredRegisterCoFH.create(ForgeRegistries.RECIPE_TYPES, ThermalExtra.MOD_ID);

    public static final RegistryObject<SerializableRecipeType<ColdFuel>> COLD_FUEL = RECIPE_TYPES.register("cold_fuel", () -> new SerializableRecipeType<>(ThermalExtra.MOD_ID, "cold_fuel"));
    public static final RegistryObject<SerializableRecipeType<AdvancedRefineryRecipe>> ADVANCED_REFINERY = RECIPE_TYPES.register("advanced_refinery", () -> new SerializableRecipeType<>(ThermalExtra.MOD_ID, "advanced_refinery"));
    public static final RegistryObject<SerializableRecipeType<FluidMixerRecipe>> FLUID_MIXER = RECIPE_TYPES.register("fluid_mixer", () -> new SerializableRecipeType<>(ThermalExtra.MOD_ID, "fluid_mixer"));
    public static final RegistryObject<SerializableRecipeType<NitraticIgniterRecipe>> NITRATIC_IGNITER = RECIPE_TYPES.register("nitratic_igniter", () -> new SerializableRecipeType<>(ThermalExtra.MOD_ID, "nitratic_igniter"));
    public static final RegistryObject<SerializableRecipeType<NitraticIgniterCatalyst>> NITRATIC_IGNITER_CATALYST = RECIPE_TYPES.register("nitratic_igniter_cataylyst", () -> new SerializableRecipeType<>(ThermalExtra.MOD_ID, "nitratic_igniter_catalyst"));
    public static final RegistryObject<SerializableRecipeType<ComponentAssemblyRecipe>> COMPONENT_ASSEMBLY = RECIPE_TYPES.register("component_assembly", () -> new SerializableRecipeType<>(ThermalExtra.MOD_ID, "component_assembly"));
    public static final RegistryObject<SerializableRecipeType<EndothermicDehydratorRecipe>> ENDOTHERMIC_DEHYDRATOR = RECIPE_TYPES.register("endothermic_dehydrator", () -> new SerializableRecipeType<>(ThermalExtra.MOD_ID, "endothermic_dehydrator"));


}
