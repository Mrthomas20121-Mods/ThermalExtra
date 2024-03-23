package mrthomas20121.thermal_extra.datagen.thermal_recipe;

import cofh.lib.common.fluid.FluidIngredient;
import cofh.thermal.lib.util.recipes.ThermalCatalyst;
import cofh.thermal.lib.util.recipes.ThermalRecipe;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static cofh.lib.util.recipes.RecipeJsonUtils.*;

public record FinishedThermalCatalyst<T extends ThermalCatalyst>(RecipeSerializer<T> recipeSerializer, ResourceLocation id, Ingredient ingredient, float primaryMod, float secondaryMod, float energyMod, float minChance, float useChance) implements FinishedRecipe {

    @Override
    public void serializeRecipeData(@NotNull JsonObject object) {
        object.add(INGREDIENT, ingredient.toJson());

        float defaultValue = 1.0F;

        if(this.primaryMod != defaultValue) {
            object.addProperty(PRIMARY_MOD, this.primaryMod);
        }

        if(this.secondaryMod != defaultValue) {
            object.addProperty(SECONDARY_MOD, this.secondaryMod);
        }

        if(this.primaryMod != defaultValue) {
            object.addProperty(ENERGY_MOD, this.energyMod);
        }

        if(this.minChance != defaultValue) {
            object.addProperty(MIN_CHANCE, this.minChance);
        }

        if(this.useChance != defaultValue) {
            object.addProperty(USE_CHANCE, this.useChance);
        }
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return this.id;
    }

    @Override
    public @NotNull RecipeSerializer<T> getType() {
        return this.recipeSerializer;
    }

    @Nullable
    @Override
    public JsonObject serializeAdvancement() {
        return null;
    }

    @Nullable
    @Override
    public ResourceLocation getAdvancementId() {
        return null;
    }
}
