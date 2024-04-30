package mrthomas20121.thermal_extra.data.thermal_recipe;

import cofh.lib.common.fluid.FluidIngredient;
import cofh.lib.util.crafting.IngredientWithCount;
import cofh.thermal.core.init.registries.TCoreRecipeSerializers;
import cofh.thermal.core.util.recipes.machine.*;
import cofh.thermal.lib.util.recipes.ThermalRecipe;
import mrthomas20121.thermal_extra.init.ThermalExtraRecipeSerializers;
import mrthomas20121.thermal_extra.recipe.*;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static cofh.lib.util.Constants.BASE_CHANCE_LOCKED;

public class ThermalBuilder<T extends ThermalRecipe> {

    public static ThermalBuilder<PressRecipe> press() {
        return new ThermalBuilder<>(TCoreRecipeSerializers.PRESS_RECIPE_SERIALIZER.get());
    }

    public static ThermalBuilder<ChillerRecipe> blastChiller() {
        return new ThermalBuilder<>(TCoreRecipeSerializers.CHILLER_RECIPE_SERIALIZER.get());
    }

    public static ThermalBuilder<SmelterRecipe> smelter() {
        return new ThermalBuilder<>(TCoreRecipeSerializers.SMELTER_RECIPE_SERIALIZER.get());
    }

    public static ThermalBuilder<FurnaceRecipe> furnace() {
        return new ThermalBuilder<>(TCoreRecipeSerializers.FURNACE_RECIPE_SERIALIZER.get());
    }

    public static ThermalBuilder<SawmillRecipe> sawmill() {
        return new ThermalBuilder<>(TCoreRecipeSerializers.SAWMILL_RECIPE_SERIALIZER.get());
    }

    public static ThermalBuilder<PulverizerRecipe> pulverizer() {
        return new ThermalBuilder<>(TCoreRecipeSerializers.PULVERIZER_RECIPE_SERIALIZER.get());
    }

    public static ThermalBuilder<MetalInfuserRecipe> metal_infuser() {
        return new ThermalBuilder<>(ThermalExtraRecipeSerializers.METAl_INFUSER_RECIPE_SERIALIZER.get());
    }

    public static ThermalBuilder<FluidMixerRecipe> fluid_mixer() {
        return new ThermalBuilder<>(ThermalExtraRecipeSerializers.FLUID_MIXER_RECIPE_SERIALIZER.get());
    }

    public static ThermalBuilder<DryingTankRecipe> drying_tank() {
        return new ThermalBuilder<>(ThermalExtraRecipeSerializers.DRYING_TANK_RECIPE_SERIALIZER.get()).chance();
    }

    public static ThermalBuilder<ComponentAssemblyRecipe> component_assembly() {
        return new ThermalBuilder<>(ThermalExtraRecipeSerializers.COMPONENT_ASSEMBLY_RECIPE_SERIALIZER.get()).chance();
    }

    public static ThermalBuilder<NitraticIgniterRecipe> nitratic_igniter() {
        return new ThermalBuilder<>(ThermalExtraRecipeSerializers.NITRATIC_IGNITER_RECIPE_SERIALIZER.get()).chance();
    }

    public static CatalystBuilder<NitraticIgniterCatalyst> nitratic_igniter_catalyst() {
        return new CatalystBuilder<>(ThermalExtraRecipeSerializers.NITRATIC_IGNITER_CATALYST_SERIALIZER.get());
    }

    public static ThermalBuilder<AdvancedRefineryRecipe> advanced_refinery() {
        return new ThermalBuilder<>(ThermalExtraRecipeSerializers.ADVANCED_REFINERY_RECIPE_SERIALIZER.get());
    }

    public static CatalystBuilder<PulverizerCatalyst> pulverizerCatalyst() {
        return new CatalystBuilder<>(TCoreRecipeSerializers.PULVERIZER_CATALYST_SERIALIZER.get());
    }

    public static CatalystBuilder<InsolatorCatalyst> insolatorCatalyst() {
        return new CatalystBuilder<>(TCoreRecipeSerializers.INSOLATOR_CATALYST_SERIALIZER.get());
    }

    public static CatalystBuilder<SmelterCatalyst> smelterCatalyst() {
        return new CatalystBuilder<>(TCoreRecipeSerializers.SMELTER_CATALYST_SERIALIZER.get());
    }

    public static MultiCatalystBuilder multiCatalyst() {
        return new MultiCatalystBuilder();
    }

    private final RecipeSerializer<T> recipeSerializer;
    private int energy = 4000;
    private float xp = 0f;
    private final List<Ingredient> inputItems = new ArrayList<>();
    private final List<FluidIngredient> inputFluids = new ArrayList<>();
    private final List<ItemStack> outputItems = new ArrayList<>();
    private final List<Float> outputItemChances = new ArrayList<>();
    private final List<Boolean> locked = new ArrayList<>();
    private final List<FluidStack> outputFluids = new ArrayList<>();
    private boolean chance = false;

    public ThermalBuilder(RecipeSerializer<T> recipeSerializer) {
        this.recipeSerializer = recipeSerializer;
    }

    public ThermalBuilder<T> chance() {
        this.chance = true;
        return this;
    }

    public ThermalBuilder<T> input(Ingredient ingredient) {
        this.inputItems.add(ingredient);
        return this;
    }

    public ThermalBuilder<T> input(ItemStack stack) {
        this.input(Ingredient.of(stack));
        return this;
    }

    public ThermalBuilder<T> input(Item item) {
        this.input(Ingredient.of(item));
        return this;
    }

    public ThermalBuilder<T> input(TagKey<Item> tag) {
        this.input(Ingredient.of(tag));
        return this;
    }

    public ThermalBuilder<T> input(TagKey<Item> tag, int amount) {
        this.input(new IngredientWithCount(Ingredient.of(tag), amount));
        return this;
    }

    public ThermalBuilder<T> input(FluidIngredient ingredient) {
        this.inputFluids.add(ingredient);
        return this;
    }

    public ThermalBuilder<T> input(Fluid fluid, int amount) {
        this.input(FluidIngredient.of(new FluidStack(fluid, amount)));
        return this;
    }

    public ThermalBuilder<T> input(int amount, TagKey<Fluid> tag) {
        this.input(FluidIngredient.of(tag, amount));
        return this;
    }

    public ThermalBuilder<T> input(FluidStack fluidStack) {
        this.input(FluidIngredient.of(fluidStack));
        return this;
    }

    public ThermalBuilder<T> output(FluidStack fluidStack) {
        this.outputFluids.add(fluidStack);
        return this;
    }

    public ThermalBuilder<T> output(Fluid fluid, int amount) {
        this.output(new FluidStack(fluid, amount));
        return this;
    }

    public ThermalBuilder<T> output(ItemStack itemStack) {
        this.outputItems.add(itemStack);
        this.outputItemChances.add(BASE_CHANCE_LOCKED);
        this.locked.add(false);
        return this;
    }

    public ThermalBuilder<T> output(Item item) {
        this.output(new ItemStack(item));
        return this;
    }

    public ThermalBuilder<T> output(ChanceItemStack itemStack) {
        this.outputItems.add(itemStack.stack());
        this.outputItemChances.add(itemStack.chance());
        this.locked.add(itemStack.locked());
        return this;
    }

    public ThermalBuilder<T> energy(int e) {
        this.energy = e;
        return this;
    }

    public ThermalBuilder<T> exp(float e) {
        this.xp = e;
        return this;
    }

    private void save(Consumer<FinishedRecipe> finishedRecipeConsumer, ResourceLocation recipeId) {
        finishedRecipeConsumer.accept(new FinishedThermalRecipe<T>(this.recipeSerializer, recipeId, this.energy, this.xp, this.inputItems, this.inputFluids, this.outputItems, this.outputItemChances, this.outputFluids, this.locked, chance));
    }

    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer, String recipeId) {
        this.save(finishedRecipeConsumer, new ResourceLocation(recipeId));
    }

    public record ChanceItemStack(ItemStack stack, float chance, boolean locked) {
        public static ChanceItemStack of(ItemStack stack) {
            return new ChanceItemStack(stack, BASE_CHANCE_LOCKED, false);
        }
        public static ChanceItemStack of(Item stack) {
            return new ChanceItemStack(new ItemStack(stack), BASE_CHANCE_LOCKED, false);
        }
    }
}
