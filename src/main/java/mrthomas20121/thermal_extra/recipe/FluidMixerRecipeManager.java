package mrthomas20121.thermal_extra.recipe;

import cofh.core.util.helpers.FluidHelper;
import cofh.lib.api.fluid.IFluidStackHolder;
import cofh.lib.common.fluid.FluidIngredient;
import cofh.lib.common.fluid.FluidStackHolder;
import cofh.lib.util.crafting.ComparableItemStack;
import cofh.thermal.lib.util.managers.AbstractManager;
import cofh.thermal.lib.util.managers.IRecipeManager;
import cofh.thermal.lib.util.recipes.IThermalInventory;
import cofh.thermal.lib.util.recipes.ThermalRecipe;
import cofh.thermal.lib.util.recipes.internal.IMachineRecipe;
import cofh.thermal.lib.util.recipes.internal.SimpleMachineRecipe;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.init.ThermalExtraRecipeTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.*;

public class FluidMixerRecipeManager extends AbstractManager implements IRecipeManager {

    private static final FluidMixerRecipeManager INSTANCE = new FluidMixerRecipeManager();
    protected static final int DEFAULT_ENERGY = 6000;

    protected Map<Integer, IMachineRecipe> recipeMap = new Object2ObjectOpenHashMap<>();
    protected Set<Fluid> validFluids = new ObjectOpenHashSet<>();
    protected Set<ComparableItemStack> validItems = new ObjectOpenHashSet<>();

    protected int maxOutputItems;
    protected int maxOutputFluids;

    public static FluidMixerRecipeManager instance() {

        return INSTANCE;
    }

    private FluidMixerRecipeManager() {

        super(DEFAULT_ENERGY);
        this.maxOutputItems = 0;
        this.maxOutputFluids = 2;
    }

    protected void clear() {

        recipeMap.clear();
        validFluids.clear();
        validItems.clear();
    }

    // region RECIPES
    public boolean validRecipe(FluidStack input) {

        return validFluids.contains(input.getFluid());
    }

    protected IMachineRecipe getRecipe(FluidStack input1, FluidStack input2) {
        return getRecipe(List.of(new FluidStackHolder(input1), new FluidStackHolder(input2)));
    }

    protected IMachineRecipe getRecipe(List<? extends IFluidStackHolder> inputTanks) {

        if (inputTanks.isEmpty() || inputTanks.get(0).isEmpty() || inputTanks.get(1).isEmpty()) {
            return null;
        }
        FluidStack inputFluid1 = inputTanks.get(0).getFluidStack();
        FluidStack inputFluid2 = inputTanks.get(1).getFluidStack();
        return recipeMap.get(getHashCode(inputFluid1, inputFluid2));
    }

    public void addRecipe(ThermalRecipe recipe) {

        if (recipe.getInputFluids().isEmpty()) {
            return;
        }

        FluidIngredient ingredient1 = recipe.getInputFluids().get(0);
        FluidIngredient ingredient2 = recipe.getInputFluids().get(1);
        FluidStack[] fluids1 = ingredient1.getFluids();
        FluidStack[] fluids2 = ingredient2.getFluids();
        if(fluids1.length == fluids2.length) {
            for(int i = 0; i<fluids1.length; i++) {
                FluidStack fluidStack1 = fluids1[i];
                FluidStack fluidStack2 = fluids2[i];
                Fluid fluid1 = fluidStack1.getFluid();
                Fluid fluid2 = fluidStack2.getFluid();
                validFluids.add(fluid1);
                validFluids.add(fluid2);
                addRecipe(recipe.getEnergy(), recipe.getXp(), Collections.emptyList(), List.of(fluidStack1, fluidStack2), Collections.emptyList(), Collections.emptyList(), recipe.getOutputFluids());
            }
        }
        else if(fluids1.length > fluids2.length) {
            for (FluidStack fluidStack1 : fluids1) {
                for (FluidStack fluidStack2 : fluids2) {
                    Fluid fluid1 = fluidStack1.getFluid();
                    Fluid fluid2 = fluidStack2.getFluid();
                    validFluids.add(fluid1);
                    validFluids.add(fluid2);
                    addRecipe(recipe.getEnergy(), recipe.getXp(), Collections.emptyList(), List.of(fluidStack1, fluidStack2), Collections.emptyList(), Collections.emptyList(), recipe.getOutputFluids());
                }
            }
        }
        else {
            for (FluidStack fluidStack2 : fluids2) {
                for (FluidStack fluidStack1 : fluids1) {
                    Fluid fluid1 = fluidStack1.getFluid();
                    Fluid fluid2 = fluidStack2.getFluid();
                    validFluids.add(fluid1);
                    validFluids.add(fluid2);
                    addRecipe(recipe.getEnergy(), recipe.getXp(), Collections.emptyList(), List.of(fluidStack1, fluidStack2), Collections.emptyList(), Collections.emptyList(), recipe.getOutputFluids());
                }
            }
        }
    }

    protected IMachineRecipe addRecipe(int energy, float experience, List<ItemStack> inputItems, List<FluidStack> inputFluids, List<ItemStack> outputItems, List<Float> chance, List<FluidStack> outputFluids) {

        if (inputFluids.isEmpty() || outputItems.isEmpty() && outputFluids.isEmpty() || outputItems.size() > maxOutputItems || outputFluids.size() > maxOutputFluids || energy <= 0) {
            return null;
        }
        FluidStack input1 = inputFluids.get(0);
        FluidStack input2 = inputFluids.get(1);
        if (input1.isEmpty() || input2.isEmpty()) {
            return null;
        }

        for (FluidStack stack : outputFluids) {
            if (stack.isEmpty()) {
                return null;
            }
        }
        energy = (int) (energy * getDefaultScale());

        SimpleMachineRecipe recipe = new SimpleMachineRecipe(energy, experience, inputItems, inputFluids, outputItems, chance, outputFluids);
        recipeMap.put(getHashCode(input1, input2), recipe);
        return recipe;
    }

    private int getHashCode(FluidStack fluid1, FluidStack fluid2) {
        return FluidHelper.fluidHashcode(fluid1)+FluidHelper.fluidHashcode(fluid2);
    }

    // endregion

    // region IRecipeManager
    @Override
    public IMachineRecipe getRecipe(IThermalInventory inventory) {

        return getRecipe(inventory.inputTanks());
    }

    @Override
    public List<IMachineRecipe> getRecipeList() {

        return new ArrayList<>(recipeMap.values());
    }
    // endregion

    // region IManager
    @Override
    public void refresh(RecipeManager recipeManager) {

        clear();
        var recipes = recipeManager.getAllRecipesFor(ThermalExtraRecipeTypes.FLUID_MIXER.get());
        for (var entry : recipes) {
            addRecipe(entry);
        }
    }
    // endregion
}
