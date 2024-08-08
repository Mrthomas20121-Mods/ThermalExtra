package mrthomas20121.thermal_extra.data.thermal_recipe;

import cofh.lib.common.fluid.FluidIngredient;
import cofh.thermal.core.init.registries.TCoreRecipeSerializers;
import cofh.thermal.core.util.recipes.dynamo.*;
import cofh.thermal.lib.util.recipes.DynamoFuelSerializer;
import cofh.thermal.lib.util.recipes.ThermalFuel;
import com.google.gson.JsonObject;
import mrthomas20121.thermal_extra.init.ThermalExtraRecipeSerializers;
import mrthomas20121.thermal_extra.recipe.ColdFuel;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

import static cofh.lib.util.recipes.RecipeJsonUtils.*;

public class DynamoRecipeBuilder<T extends ThermalFuel> {

    public static DynamoRecipeBuilder<ColdFuel> cold() {
        return new DynamoRecipeBuilder<>(ThermalExtraRecipeSerializers.COLD_FUEL_SERIALIZER.get());
    }

    public static DynamoRecipeBuilder<NumismaticFuel> numismatic() {
        return new DynamoRecipeBuilder<>(TCoreRecipeSerializers.NUMISMATIC_FUEL_SERIALIZER.get());
    }

    public static DynamoRecipeBuilder<MagmaticFuel> magmatic() {
        return new DynamoRecipeBuilder<>(TCoreRecipeSerializers.MAGMATIC_FUEL_SERIALIZER.get());
    }

    public static DynamoRecipeBuilder<CompressionFuel> compression() {
        return new DynamoRecipeBuilder<>(TCoreRecipeSerializers.COMPRESSION_FUEL_SERIALIZER.get());
    }

    public static DynamoRecipeBuilder<GourmandFuel> gourmand() {
        return new DynamoRecipeBuilder<>(TCoreRecipeSerializers.GOURMAND_FUEL_SERIALIZER.get());
    }

    public static DynamoRecipeBuilder<StirlingFuel> stirling() {
        return new DynamoRecipeBuilder<>(TCoreRecipeSerializers.STIRLING_FUEL_SERIALIZER.get());
    }

    public static DynamoRecipeBuilder<LapidaryFuel> lapidary() {
        return new DynamoRecipeBuilder<>(TCoreRecipeSerializers.LAPIDARY_FUEL_SERIALIZER.get());
    }

    public static DynamoRecipeBuilder<DisenchantmentFuel> disenchantment() {
        return new DynamoRecipeBuilder<>(TCoreRecipeSerializers.DISENCHANTMENT_FUEL_SERIALIZER.get());
    }

    private final DynamoFuelSerializer<T> fuelSerializer;
    private Ingredient i = Ingredient.EMPTY;
    private FluidIngredient fluidIngredient = FluidIngredient.EMPTY;
    private int e = 5000;
    private float energy_mod = 0;

    public DynamoRecipeBuilder(DynamoFuelSerializer<T> fuelSerializer) {

        this.fuelSerializer = fuelSerializer;
    }

    public DynamoRecipeBuilder<T> fluid(FluidStack fluid) {
        this.fluidIngredient = FluidIngredient.of(fluid);
        return this;
    }

    public DynamoRecipeBuilder<T> ingredient(TagKey<Item> i) {
        this.i = Ingredient.of(i);
        return this;
    }

    public DynamoRecipeBuilder<T> ingredient(Item i) {
        this.i = Ingredient.of(i);
        return this;
    }

    public DynamoRecipeBuilder<T> ingredient(Block i) {
        this.i = Ingredient.of(i);
        return this;
    }

    public DynamoRecipeBuilder<T> ingredient(Ingredient i) {
        this.i = i;
        return this;
    }

    public DynamoRecipeBuilder<T> energy(int e) {
        this.e = e;
        return this;
    }

    public DynamoRecipeBuilder<T> energyMod(float mod) {
        this.energy_mod = mod;
        return this;
    }

    public void build(Consumer<FinishedRecipe> consumer, String recipeName) {
        consumer.accept(new FinishedDynamoRecipe<>(this.fuelSerializer, new ResourceLocation(recipeName), this.i, this.e, this.energy_mod));
    }

    public void buildFluid(Consumer<FinishedRecipe> consumer, String recipeName) {
        consumer.accept(new FinishedFluidDynamoRecipe<>(this.fuelSerializer, new ResourceLocation(recipeName), this.fluidIngredient, this.e, this.energy_mod));
    }

    private record FinishedFluidDynamoRecipe<T extends ThermalFuel>(DynamoFuelSerializer<T> fuelSerializer, ResourceLocation id, FluidIngredient ingredient, int energy, float energy_mod) implements FinishedRecipe {
        @Override
        public void serializeRecipeData(JsonObject pJson) {
            pJson.add(INGREDIENT, this.ingredient.toJson());
            pJson.addProperty(ENERGY, this.energy);

            if(energy_mod > 0) {
                pJson.addProperty(ENERGY_MOD, this.energy_mod);
            }
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return this.fuelSerializer;
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

    private record FinishedDynamoRecipe<T extends ThermalFuel>(DynamoFuelSerializer<T> fuelSerializer, ResourceLocation id, Ingredient ingredient, int energy, float energy_mod) implements FinishedRecipe {
        @Override
        public void serializeRecipeData(JsonObject pJson) {
            pJson.add(INGREDIENT, this.ingredient.toJson());
            pJson.addProperty(ENERGY, this.energy);

            if(energy_mod > 0) {
                pJson.addProperty(ENERGY_MOD, this.energy_mod);
            }
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return this.fuelSerializer;
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
}
