package mrthomas20121.thermal_extra.recipe;

import cofh.core.util.helpers.FluidHelper;
import cofh.lib.api.fluid.IFluidStackHolder;
import cofh.lib.api.inventory.IItemStackHolder;
import cofh.lib.util.crafting.ComparableItemStack;
import cofh.thermal.core.common.item.SlotSealItem;
import cofh.thermal.lib.util.managers.AbstractManager;
import cofh.thermal.lib.util.managers.IRecipeManager;
import cofh.thermal.lib.util.recipes.IThermalInventory;
import cofh.thermal.lib.util.recipes.ThermalRecipe;
import cofh.thermal.lib.util.recipes.internal.IMachineRecipe;
import cofh.thermal.lib.util.recipes.internal.SimpleMachineRecipe;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.init.ThermalExtraRecipeTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.*;

import static java.util.Arrays.asList;

public class DryingTankRecipeManager extends AbstractManager implements IRecipeManager {

    private static final DryingTankRecipeManager INSTANCE = new DryingTankRecipeManager();
    protected static final int DEFAULT_ENERGY = 4000;

    protected Map<Integer, IMachineRecipe> recipeMap = new Object2ObjectOpenHashMap<>();
    protected Set<Fluid> validFluids = new ObjectOpenHashSet<>();
    protected Set<ComparableItemStack> validItems = new ObjectOpenHashSet<>();

    protected int maxOutputItems;
    protected int maxOutputFluids;

    public static DryingTankRecipeManager instance() {

        return INSTANCE;
    }

    private DryingTankRecipeManager() {

        super(DEFAULT_ENERGY);
        this.maxOutputItems = 1;
        this.maxOutputFluids = 0;
    }

    public boolean validItem(ItemStack item) {

        return validItems.contains(makeComparable(item));
    }

    public boolean validFluid(FluidStack fluid) {

        return validFluids.contains(fluid.getFluid());
    }

    protected void clear() {

        recipeMap.clear();
        validFluids.clear();
        validItems.clear();
    }

    // region RECIPES
    protected IMachineRecipe getRecipe(List<? extends IItemStackHolder> inputSlots, List<? extends IFluidStackHolder> inputTanks) {

        if (inputTanks.isEmpty() || inputTanks.get(0).isEmpty()) {
            return null;
        }

        FluidStack inputFluid = inputTanks.get(0).getFluidStack();
        return recipeMap.get(FluidHelper.fluidHashcode(inputFluid));
    }

    public void addRecipe(ThermalRecipe recipe) {

        if(!recipe.getInputItems().isEmpty()) {
            ThermalExtra.LOGGER.error("Drying Tank recipe cannot have input items!");
        }
        if(!recipe.getOutputFluids().isEmpty()) {
            ThermalExtra.LOGGER.error("Drying Tank recipe cannot have output fluids!");
        }

        if (recipe.getInputFluids().isEmpty()) {
            return;
        }
        for (FluidStack fluidInput : recipe.getInputFluids().get(0).getFluids()) {
            addRecipe(recipe.getEnergy(), recipe.getXp(), Collections.emptyList(), Collections.singletonList(fluidInput), recipe.getOutputItems(), recipe.getOutputItemChances(), Collections.emptyList());
        }
    }

    protected IMachineRecipe addRecipe(int energy, float experience, List<ItemStack> inputItems, List<FluidStack> inputFluids, List<ItemStack> outputItems, List<Float> chance, List<FluidStack> outputFluids) {

        if (inputFluids.isEmpty() || outputItems.isEmpty() || outputItems.size() > maxOutputItems || energy <= 0) {
            return null;
        }
        FluidStack input = inputFluids.get(0);
        if (input.isEmpty()) {
            return null;
        }
        for (ItemStack stack : outputItems) {
            if (stack.isEmpty()) {
                return null;
            }
        }
        energy = (int) (energy * getDefaultScale());

        SimpleMachineRecipe recipe = new SimpleMachineRecipe(energy, experience, inputItems, inputFluids, outputItems, chance, outputFluids);
        recipeMap.put(FluidHelper.fluidHashcode(input), recipe);
        return recipe;
    }
    // endregion

    // region IRecipeManager
    @Override
    public IMachineRecipe getRecipe(IThermalInventory inventory) {

        return getRecipe(inventory.inputSlots(), inventory.inputTanks());
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
        var recipes = recipeManager.getAllRecipesFor(ThermalExtraRecipeTypes.DRYING_TANK.get());
        for (var entry : recipes) {
            addRecipe(entry);
        }
    }
    // endregion
}
