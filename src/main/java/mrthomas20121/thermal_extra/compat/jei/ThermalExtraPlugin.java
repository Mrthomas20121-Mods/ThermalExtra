package mrthomas20121.thermal_extra.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.client.screens.DynamoFrostScreen;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.init.ThermalExtraRecipeTypes;
import mrthomas20121.thermal_extra.recipe.ColdFuel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class ThermalExtraPlugin implements IModPlugin {

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(ThermalExtra.MOD_ID, "extra");
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        RecipeManager recipeManager = getRecipeManager();
        if (recipeManager == null) {
            // TODO: Log an error.
            return;
        }

        registration.addRecipes(COLD_FUEL_TYPE, recipeManager.getAllRecipesFor(ThermalExtraRecipeTypes.COLD_FUEL.get()));
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new ColdFuelCategory(registration.getJeiHelpers().getGuiHelper(), new ItemStack(ThermalExtraBlocks.DYNAMO_COLD.get()), COLD_FUEL_TYPE));
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        int progressY = 35;
        int progressW = 24;
        int progressH = 16;

        registration.addRecipeClickArea(DynamoFrostScreen.class, 80, progressY, progressH, progressH, COLD_FUEL_TYPE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ThermalExtraBlocks.DYNAMO_COLD.get()), COLD_FUEL_TYPE);
    }

    private RecipeManager getRecipeManager() {

        RecipeManager recipeManager = null;
        ClientLevel level = Minecraft.getInstance().level;
        if (level != null) {
            recipeManager = level.getRecipeManager();
        }
        return recipeManager;
    }

    public static final RecipeType<ColdFuel> COLD_FUEL_TYPE = new RecipeType<>(ThermalExtraRecipeTypes.COLD_FUEL.getId(), ColdFuel.class);
}
