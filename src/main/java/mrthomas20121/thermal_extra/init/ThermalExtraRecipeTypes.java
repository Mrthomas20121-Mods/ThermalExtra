package mrthomas20121.thermal_extra.init;

import cofh.lib.util.DeferredRegisterCoFH;
import cofh.lib.util.recipes.SerializableRecipeType;
import cofh.thermal.core.util.recipes.machine.ChillerRecipe;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.recipe.ColdFuel;
import mrthomas20121.thermal_extra.recipe.MetalInfuserRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ThermalExtraRecipeTypes {


    public static final DeferredRegisterCoFH<RecipeType<?>> RECIPE_TYPES = DeferredRegisterCoFH.create(ForgeRegistries.RECIPE_TYPES, ThermalExtra.MOD_ID);

    public static final RegistryObject<SerializableRecipeType<ColdFuel>> COLD_FUEL = RECIPE_TYPES.register("cold_fuel", () -> new SerializableRecipeType<>(ThermalExtra.MOD_ID, "cold_fuel"));
    public static final RegistryObject<SerializableRecipeType<MetalInfuserRecipe>> METAL_INFUSER = RECIPE_TYPES.register("metal_infuser", () -> new SerializableRecipeType<>(ThermalExtra.MOD_ID, "metal_infuser"));
}
