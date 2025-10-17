package mrthomas20121.thermal_extra.recipe;

import cofh.lib.common.fluid.FluidIngredient;
import cofh.lib.util.crafting.ComparableItemStack;
import cofh.thermal.lib.util.recipes.internal.BaseMachineRecipe;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluid;

import java.util.List;
import java.util.Set;

public class ComponentAssemblyMasterRecipe extends BaseMachineRecipe {

    protected final Set<ComparableItemStack> validItems = new ObjectOpenHashSet<>();
    protected Set<Fluid> validFluids = new ObjectOpenHashSet<>();

    protected final List<Ingredient> ingredients;
    protected final List<FluidIngredient> fluidIngredients;

    public ComponentAssemblyMasterRecipe(ComponentAssemblyRecipe recipe, RegistryAccess registryAccess) {
        super(recipe.getEnergy(), recipe.getXp());

        this.ingredients = recipe.getInputItems();
        this.fluidIngredients = recipe.getInputFluids();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<FluidIngredient> getFluidIngredients() {
        return fluidIngredients;
    }
}
