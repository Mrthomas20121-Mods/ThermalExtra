package mrthomas20121.thermal_extra.init;

import cofh.lib.util.DeferredRegisterCoFH;
import cofh.thermal.lib.util.recipes.DynamoFuelSerializer;
import cofh.thermal.lib.util.recipes.MachineRecipeSerializer;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.recipe.ColdFuel;
import mrthomas20121.thermal_extra.recipe.ColdFuelManager;
import mrthomas20121.thermal_extra.recipe.MetalInfuserRecipe;
import mrthomas20121.thermal_extra.recipe.MetalInfuserRecipeManager;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ThermalExtraRecipeSerializers {

    public static final DeferredRegisterCoFH<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegisterCoFH.create(ForgeRegistries.RECIPE_SERIALIZERS, ThermalExtra.MOD_ID);

    public static final RegistryObject<DynamoFuelSerializer<ColdFuel>> COLD_FUEL_SERIALIZER = RECIPE_SERIALIZERS.register("cold_fuel", () -> new DynamoFuelSerializer<>(ColdFuel::new, ColdFuelManager.instance().getDefaultEnergy(), ColdFuelManager.MIN_ENERGY, ColdFuelManager.MAX_ENERGY));
    public static final RegistryObject<MachineRecipeSerializer<MetalInfuserRecipe>> CHILLER_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("metal_infuser", () -> new MachineRecipeSerializer<>(MetalInfuserRecipe::new, MetalInfuserRecipeManager.instance().getDefaultEnergy()));
}
