package mrthomas20121.thermal_extra.init;

import cofh.lib.util.DeferredRegisterCoFH;
import cofh.thermal.core.util.managers.machine.PressRecipeManager;
import cofh.thermal.core.util.recipes.machine.PressRecipe;
import cofh.thermal.lib.util.recipes.MachineRecipeSerializer;
import mrthomas20121.thermal_extra.ThermalExtra;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ThermalExtraRecipeTypes {

    public static final DeferredRegisterCoFH<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegisterCoFH.create(ForgeRegistries.RECIPE_SERIALIZERS, ThermalExtra.MOD_ID);

    //public static RegistryObject<RecipeSerializer<?>> FLUID_INFUSER = RECIPE_SERIALIZERS.register("fluid_infuser", () -> new MachineRecipeSerializer<>(PressRecipe::new, PressRecipeManager.instance().getDefaultEnergy()));
}
