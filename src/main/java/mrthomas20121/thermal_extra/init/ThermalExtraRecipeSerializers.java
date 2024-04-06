package mrthomas20121.thermal_extra.init;

import cofh.lib.util.DeferredRegisterCoFH;
import cofh.thermal.lib.util.recipes.DynamoFuelSerializer;
import cofh.thermal.lib.util.recipes.MachineCatalystSerializer;
import cofh.thermal.lib.util.recipes.MachineRecipeSerializer;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.recipe.*;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ThermalExtraRecipeSerializers {

    public static final DeferredRegisterCoFH<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegisterCoFH.create(ForgeRegistries.RECIPE_SERIALIZERS, ThermalExtra.MOD_ID);

    public static final RegistryObject<DynamoFuelSerializer<ColdFuel>> COLD_FUEL_SERIALIZER = RECIPE_SERIALIZERS.register("cold_fuel", () -> new DynamoFuelSerializer<>(ColdFuel::new, ColdFuelManager.instance().getDefaultEnergy(), ColdFuelManager.MIN_ENERGY, ColdFuelManager.MAX_ENERGY));
    public static final RegistryObject<MachineRecipeSerializer<MetalInfuserRecipe>> METAl_INFUSER_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("metal_infuser", () -> new MachineRecipeSerializer<>(MetalInfuserRecipe::new, MetalInfuserRecipeManager.instance().getDefaultEnergy()));
    public static final RegistryObject<MachineRecipeSerializer<AdvancedRefineryRecipe>> ADVANCED_REFINERY_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("advanced_refinery", () -> new MachineRecipeSerializer<>(AdvancedRefineryRecipe::new, AdvancedRefineryRecipeManager.instance().getDefaultEnergy()));
    public static final RegistryObject<MachineRecipeSerializer<FluidMixerRecipe>> FLUID_MIXER_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("fluid_mixer", () -> new MachineRecipeSerializer<>(FluidMixerRecipe::new, FluidMixerRecipeManager.instance().getDefaultEnergy()));
    public static final RegistryObject<MachineRecipeSerializer<NitraticIgniterRecipe>> NITRATIC_IGNITER_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("nitratic_igniter", () -> new MachineRecipeSerializer<>(NitraticIgniterRecipe::new, NitraticIgniterRecipeManager.instance().getDefaultEnergy()));
    public static final RegistryObject<MachineCatalystSerializer<NitraticIgniterCatalyst>> NITRATIC_IGNITER_CATALYST_SERIALIZER = RECIPE_SERIALIZERS.register("nitratic_igniter_catalyst", () -> new MachineCatalystSerializer<>(NitraticIgniterCatalyst::new));
    public static final RegistryObject<MachineRecipeSerializer<ComponentAssemblyRecipe>> COMPONENT_ASSEMBLY_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("component_assembly", () -> new MachineRecipeSerializer<>(ComponentAssemblyRecipe::new, ComponentAssemblyRecipeManager.instance().getDefaultEnergy()));

}
