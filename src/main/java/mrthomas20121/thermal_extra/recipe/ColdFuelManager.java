package mrthomas20121.thermal_extra.recipe;

import cofh.thermal.lib.util.managers.SingleItemFuelManager;
import cofh.thermal.lib.util.recipes.internal.IDynamoFuel;
import mrthomas20121.thermal_extra.init.ThermalExtraRecipeTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import static cofh.thermal.core.init.registries.TCoreRecipeTypes.NUMISMATIC_FUEL;


public class ColdFuelManager extends SingleItemFuelManager {

    private static final ColdFuelManager INSTANCE = new ColdFuelManager();
    protected static final int DEFAULT_ENERGY = 16000;

    public static ColdFuelManager instance() {

        return INSTANCE;
    }

    private ColdFuelManager() {

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
        var recipes = recipeManager.byType(ThermalExtraRecipeTypes.COLD_FUEL.get());
        for (var entry : recipes.entrySet()) {
            addFuel(entry.getValue());
        }
    }
    // endregion
}
