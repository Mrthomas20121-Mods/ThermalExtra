package mrthomas20121.thermal_extra.datagen.thermal_recipe;

import cofh.lib.common.fluid.FluidIngredient;
import cofh.thermal.lib.util.recipes.ThermalRecipe;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static cofh.lib.util.Constants.BASE_CHANCE_LOCKED;

public class ThermalRecipeBuilder<T extends ThermalRecipe> {


    private RecipeSerializer<T> recipeSerializer = null;
    private int energy = 4000;
    private float xp = 0f;
    private final List<Ingredient> inputItems = new ArrayList<>();
    private final List<FluidIngredient> inputFluids = new ArrayList<>();
    private final List<ItemStack> outputItems = new ArrayList<>();
    private final List<Float> outputItemChances = new ArrayList<>();
    private final List<FluidStack> outputFluids = new ArrayList<>();

    public ThermalRecipeBuilder(RecipeSerializer<T> recipeSerializer) {
        this.recipeSerializer = recipeSerializer;
    }

    public ThermalRecipeBuilder<T> withInputItems(List<Ingredient> ingredients) {
        this.inputItems.addAll(ingredients);
        return this;
    }

    public ThermalRecipeBuilder<T> withInputItems(Ingredient... ingredients) {
        this.withInputItems(Arrays.stream(ingredients).toList());
        return this;
    }

    public ThermalRecipeBuilder<T> withInputItems(ItemStack... ingredients) {
        this.withInputItems(Arrays.stream(ingredients).map(Ingredient::of).toList());
        return this;
    }

    public ThermalRecipeBuilder<T> withInputItems(Item... ingredients) {
        this.withInputItems(Arrays.stream(ingredients).map(Ingredient::of).toList());
        return this;
    }

    public ThermalRecipeBuilder<T> energy(int e) {
        this.energy = e;
        return this;
    }

    public ThermalRecipeBuilder<T> exp(float e) {
        this.xp = e;
        return this;
    }

    public ThermalRecipeBuilder<T> withInputFluids(FluidIngredient... ingredients) {
        this.inputFluids.addAll(Arrays.stream(ingredients).toList());
        return this;
    }

    public ThermalRecipeBuilder<T> withOutputItems(ChanceItemStack... items) {
        Arrays.stream(items).forEach(chanceItem -> {
            this.outputItems.add(chanceItem.stack);
            this.outputItemChances.add(chanceItem.chance);
        });
        return this;
    }

    public ThermalRecipeBuilder<T> withOutputItems(ItemStack... items) {
        Arrays.stream(items).map(ChanceItemStack::of).forEach(chanceItem -> {
            this.outputItems.add(chanceItem.stack);
            this.outputItemChances.add(chanceItem.chance);
        });
        return this;
    }

    public ThermalRecipeBuilder<T> withOutputItems(Item... items) {
        Arrays.stream(items).map(ChanceItemStack::of).forEach(chanceItem -> {
            this.outputItems.add(chanceItem.stack);
            this.outputItemChances.add(chanceItem.chance);
        });
        return this;
    }

    public ThermalRecipeBuilder<T> withOutputFluids(FluidStack... ingredients) {
        this.outputFluids.addAll(Arrays.stream(ingredients).toList());
        return this;
    }

    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer, ResourceLocation recipeId) {
        finishedRecipeConsumer.accept(new FinishedThermalRecipe<T>(this.recipeSerializer, recipeId, this.energy, this.xp, this.inputItems, this.inputFluids, this.outputItems, this.outputItemChances, this.outputFluids));
    }

    public record ChanceItemStack(ItemStack stack, float chance) {
        public static ChanceItemStack of(ItemStack stack) {
            return new ChanceItemStack(stack, BASE_CHANCE_LOCKED);
        }
        public static ChanceItemStack of(Item stack) {
            return new ChanceItemStack(new ItemStack(stack), BASE_CHANCE_LOCKED);
        }
    }
}
