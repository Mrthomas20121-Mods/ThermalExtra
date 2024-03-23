package mrthomas20121.thermal_extra.datagen.thermal_recipe;

import cofh.thermal.lib.util.recipes.ThermalCatalyst;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Consumer;

public class CatalystBuilder<T extends ThermalCatalyst> {

    private final RecipeSerializer<T> catalystId;
    private Ingredient i;
    private float primary = 1f;
    private float secondary = 1f;
    private float energy = 1f;
    private float minChance = 1f;
    private float useChance = 1f;

    public CatalystBuilder(RecipeSerializer<T> catalystId) {
        this.catalystId = catalystId;
    }

    public CatalystBuilder<T> ingredient(Ingredient ingredient) {
        this.i = ingredient;
        return this;
    }

    public CatalystBuilder<T> ingredient(TagKey<Item> tagKey) {
        return ingredient(Ingredient.of(tagKey));
    }

    public CatalystBuilder<T> ingredient(ItemStack stack) {
        return ingredient(Ingredient.of(stack));
    }

    public CatalystBuilder<T> ingredient(Item stack) {
        this.i = Ingredient.of(stack);
        return this;
    }

    public CatalystBuilder<T> primaryMod(float mod) {
        this.primary = mod;
        return this;
    }

    public CatalystBuilder<T> secondaryMod(float mod) {
        this.secondary = mod;
        return this;
    }

    public CatalystBuilder<T> energyMod(float mod) {
        this.energy = mod;
        return this;
    }

    public CatalystBuilder<T> minChanceMod(float mod) {
        this.minChance = mod;
        return this;
    }

    public CatalystBuilder<T> useChanceMod(float mod) {
        this.useChance = mod;
        return this;
    }

    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer, ResourceLocation recipeId) {
        finishedRecipeConsumer.accept(new FinishedThermalCatalyst<T>(this.catalystId, recipeId, this.i, this.primary, this.secondary, this.energy, this.minChance, this.useChance));
    }
}
