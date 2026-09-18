package mrthomas20121.thermal_extra.recipe;

import cofh.thermal.lib.util.managers.SingleItemFuelManager;
import cofh.thermal.lib.util.recipes.internal.IDynamoFuel;
import mrthomas20121.thermal_extra.init.ThermalExtraRecipeTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

public class TerraceousFuelManager extends SingleItemFuelManager {

    private static final TerraceousFuelManager INSTANCE = new TerraceousFuelManager();
    protected static final int DEFAULT_ENERGY = 16000;

    public static TerraceousFuelManager instance() {

        return INSTANCE;
    }

    private TerraceousFuelManager() {

        super(DEFAULT_ENERGY);
    }

    public int getEnergy(ItemStack stack) {

        IDynamoFuel fuel = getFuel(stack);
        return fuel != null ? fuel.getEnergy() : 0;
    }

    // region IManager
    @Override
    public void refresh(RecipeManager recipeManager) {

        clear();
        var recipes = recipeManager.getAllRecipesFor(ThermalExtraRecipeTypes.TERRACEOUS_FUEL.get());
        if(!recipes.isEmpty()) {
            for (var entry : recipes) {
                addFuel(entry);
            }
        }
    }
    // endregion
}
