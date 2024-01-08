package mrthomas20121.thermal_extra.init;

import cofh.lib.util.DeferredRegisterCoFH;
import cofh.lib.util.recipes.SerializableRecipeType;
import cofh.thermal.lib.util.recipes.DynamoFuelSerializer;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.recipe.ColdFuel;
import mrthomas20121.thermal_extra.recipe.ColdFuelManager;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ThermalExtraRecipeTypes {


    public static final DeferredRegisterCoFH<RecipeType<?>> RECIPE_TYPES = DeferredRegisterCoFH.create(ForgeRegistries.RECIPE_TYPES, ThermalExtra.MOD_ID);

    public static final RegistryObject<SerializableRecipeType<ColdFuel>> COLD_FUEL = RECIPE_TYPES.register("cold_fuel", () -> new SerializableRecipeType<>(ThermalExtra.MOD_ID, "cold_fuel"));
}
