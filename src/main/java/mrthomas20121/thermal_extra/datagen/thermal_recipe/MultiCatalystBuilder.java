package mrthomas20121.thermal_extra.datagen.thermal_recipe;

import cofh.thermal.lib.util.recipes.ThermalCatalyst;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MultiCatalystBuilder {

    private final Map<ResourceLocation, CatalystBuilder<?>> catalystBuilders = new HashMap<>();

    private Ingredient i;

    private float primary = 1f;
    private float secondary = 1f;
    private float energy = 1f;
    private float minChance = 1f;
    private float useChance = 1f;

    public MultiCatalystBuilder ingredient(Ingredient ingredient) {
        this.i = ingredient;
        return this;
    }

    public MultiCatalystBuilder ingredient(ItemStack item) {
        return ingredient(Ingredient.of(item));
    }

    public MultiCatalystBuilder ingredient(Item item) {
        return ingredient(Ingredient.of(item));
    }

    public MultiCatalystBuilder ingredient(TagKey<Item> tag) {
        return ingredient(Ingredient.of(tag));
    }

    public MultiCatalystBuilder primaryMod(float mod) {
        this.primary = mod;
        return this;
    }

    public MultiCatalystBuilder secondaryMod(float mod) {
        this.secondary = mod;
        return this;
    }

    public MultiCatalystBuilder energyMod(float mod) {
        this.energy = mod;
        return this;
    }

    public MultiCatalystBuilder minChanceMod(float mod) {
        this.minChance = mod;
        return this;
    }

    public MultiCatalystBuilder useChanceMod(float mod) {
        this.useChance = mod;
        return this;
    }

    public <T extends ThermalCatalyst> MultiCatalystBuilder addCatalyst(ResourceLocation id, CatalystBuilder<T> catalystBuilder) {
        this.catalystBuilders.put(id, catalystBuilder
                .ingredient(i)
                .primaryMod(this.primary)
                .secondaryMod(this.secondary)
                .energyMod(this.energy)
                .minChanceMod(this.minChance)
                .useChanceMod(this.useChance)
        );
        return this;
    }

    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        for(Map.Entry<ResourceLocation, CatalystBuilder<?>> entry: catalystBuilders.entrySet()) {
            entry.getValue().save(finishedRecipeConsumer, entry.getKey());
        }
    }
}
