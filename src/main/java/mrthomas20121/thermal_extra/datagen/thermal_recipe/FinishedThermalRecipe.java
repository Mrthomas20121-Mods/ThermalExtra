package mrthomas20121.thermal_extra.datagen.thermal_recipe;

import cofh.lib.common.fluid.FluidIngredient;
import cofh.lib.util.recipes.RecipeJsonUtils;
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

public record FinishedThermalRecipe<T extends ThermalRecipe>(RecipeSerializer<T> recipeSerializer, ResourceLocation id, int energy, float xp, List<Ingredient> inputItems, List<FluidIngredient> inputFluids, List<ItemStack> outputItems, List<Float> outputItemChances, List<FluidStack> outputFluids) implements FinishedRecipe {

    @Override
    public void serializeRecipeData(@NotNull JsonObject jsonObject) {
        JsonObject object = new JsonObject();
        JsonArray output = new JsonArray();
        JsonArray ingredients = new JsonArray();
        this.inputItems.forEach(ingredient -> ingredients.add(ingredient.toJson()));
        this.inputFluids.forEach(ingredient -> ingredients.add(ingredient.toJson()));
        object.add("ingredients", ingredients);

        for(int i = 0; i<this.outputItems.size(); i++) {
            float chance = this.outputItemChances.get(i);
            ItemStack itemStack = this.outputItems.get(i);
            JsonObject stack = new JsonObject();
            stack.addProperty("item", ForgeRegistries.ITEMS.getKey(itemStack.getItem()).toString());
            stack.addProperty("count", itemStack.getCount());
            if(chance > 0) {
                stack.addProperty("chance", chance);
            }
            output.add(stack);
        }
        this.outputFluids.forEach(fluidStack -> {
            Fluid fluid = fluidStack.getFluid();
            int amount = fluidStack.getAmount();
            JsonObject obj = new JsonObject();
            obj.addProperty("fluid", ForgeRegistries.FLUIDS.getKey(fluid).toString());
            obj.addProperty("amount", amount);
            output.add(obj);
        });

        jsonObject.add("ingredients", ingredients);
        jsonObject.add("result", output);

        jsonObject.addProperty("energy", energy);
        if(xp > 0) {
            jsonObject.addProperty("experience", xp);
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
