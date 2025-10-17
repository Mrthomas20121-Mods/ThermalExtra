package mrthomas20121.thermal_extra.recipe;

import cofh.lib.api.fluid.IFluidStackHolder;
import cofh.lib.api.inventory.IItemStackHolder;
import cofh.lib.util.crafting.ComparableItemStack;
import cofh.thermal.lib.util.managers.AbstractManager;
import cofh.thermal.lib.util.managers.IRecipeManager;
import cofh.thermal.lib.util.recipes.IThermalInventory;
import cofh.thermal.lib.util.recipes.ThermalRecipe;
import cofh.thermal.lib.util.recipes.internal.IMachineRecipe;
import cofh.thermal.lib.util.recipes.internal.SimpleMachineRecipe;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import mrthomas20121.thermal_extra.init.ThermalExtraRecipeTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.*;

import static java.util.Arrays.asList;

public class ComponentAssemblyRecipeManager extends AbstractManager implements IRecipeManager {

    private static final ComponentAssemblyRecipeManager INSTANCE = new ComponentAssemblyRecipeManager();
    protected static final int DEFAULT_ENERGY = 6000;

    protected Map<RecipeMapWrapper, IMachineRecipe> recipeMap = new Object2ObjectOpenHashMap<>();
    protected Set<Fluid> validFluids = new ObjectOpenHashSet<>();
    protected Set<ComparableItemStack> validItems = new ObjectOpenHashSet<>();

    protected int maxOutputItems;
    protected int maxOutputFluids;
    protected int maxInputItems;

    public static ComponentAssemblyRecipeManager instance() {

        return INSTANCE;
    }

    private ComponentAssemblyRecipeManager() {

        super(DEFAULT_ENERGY);
        this.maxOutputItems = 1;
        this.maxOutputFluids = 1;
        this.maxInputItems = 6;
    }

    public void addRecipe(ThermalRecipe recipe) {

        if(!recipe.getInputFluids().isEmpty()) {

            switch (recipe.getInputItems().size()) {
                case 1 -> {
                    for (ItemStack firstInput : recipe.getInputItems().get(0).getItems()) {
                        for(FluidStack fluidStack: recipe.getInputFluids().get(0).getFluids()) {
                            addRecipe(recipe.getEnergy(), recipe.getXp(), Collections.singletonList(firstInput), Collections.singletonList(fluidStack), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                        }
                    }
                }
                case 2 -> {
                    for (ItemStack firstInput : recipe.getInputItems().get(0).getItems()) {
                        for (ItemStack secondInput : recipe.getInputItems().get(1).getItems()) {
                            for(FluidStack fluidStack: recipe.getInputFluids().get(0).getFluids()) {
                                addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput), Collections.singletonList(fluidStack), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                            }
                        }
                    }
                }
                case 3 -> {
                    for (ItemStack firstInput : recipe.getInputItems().get(0).getItems()) {
                        for (ItemStack secondInput : recipe.getInputItems().get(1).getItems()) {
                            for (ItemStack thirdInput : recipe.getInputItems().get(2).getItems()) {
                                for(FluidStack fluidStack: recipe.getInputFluids().get(0).getFluids()) {
                                    addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput, thirdInput), Collections.singletonList(fluidStack), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                                }
                            }
                        }
                    }
                }
                case 4 -> {
                    for (ItemStack firstInput : recipe.getInputItems().get(0).getItems()) {
                        for (ItemStack secondInput : recipe.getInputItems().get(1).getItems()) {
                            for (ItemStack thirdInput : recipe.getInputItems().get(2).getItems()) {
                                for (ItemStack forthInput : recipe.getInputItems().get(3).getItems()) {
                                    for(FluidStack fluidStack: recipe.getInputFluids().get(0).getFluids()) {
                                        addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput, thirdInput, forthInput), Collections.singletonList(fluidStack), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                                    }
                                }
                            }
                        }
                    }
                }
                case 5 -> {
                    for (ItemStack firstInput : recipe.getInputItems().get(0).getItems()) {
                        for (ItemStack secondInput : recipe.getInputItems().get(1).getItems()) {
                            for (ItemStack thirdInput : recipe.getInputItems().get(2).getItems()) {
                                for (ItemStack forthInput : recipe.getInputItems().get(3).getItems()) {
                                    for (ItemStack firthInput : recipe.getInputItems().get(4).getItems()) {
                                        for(FluidStack fluidStack: recipe.getInputFluids().get(0).getFluids()) {
                                            addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput, thirdInput, forthInput, firthInput), Collections.singletonList(fluidStack), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                case 6 -> {
                    for (ItemStack firstInput : recipe.getInputItems().get(0).getItems()) {
                        for (ItemStack secondInput : recipe.getInputItems().get(1).getItems()) {
                            for (ItemStack thirdInput : recipe.getInputItems().get(2).getItems()) {
                                for (ItemStack forthInput : recipe.getInputItems().get(3).getItems()) {
                                    for (ItemStack firthInput : recipe.getInputItems().get(4).getItems()) {
                                        for (ItemStack sixthInput : recipe.getInputItems().get(5).getItems()) {
                                            for(FluidStack fluidStack: recipe.getInputFluids().get(0).getFluids()) {
                                                addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput, thirdInput, forthInput, firthInput, sixthInput), Collections.singletonList(fluidStack), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            switch (recipe.getInputItems().size()) {
                case 1 -> {
                    for (ItemStack firstInput : recipe.getInputItems().get(0).getItems()) {
                        addRecipe(recipe.getEnergy(), recipe.getXp(), Collections.singletonList(firstInput), Collections.emptyList(), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                    }
                }
                case 2 -> {
                    for (ItemStack firstInput : recipe.getInputItems().get(0).getItems()) {
                        for (ItemStack secondInput : recipe.getInputItems().get(1).getItems()) {
                            addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput), Collections.emptyList(), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                        }
                    }
                }
                case 3 -> {
                    for (ItemStack firstInput : recipe.getInputItems().get(0).getItems()) {
                        for (ItemStack secondInput : recipe.getInputItems().get(1).getItems()) {
                            for (ItemStack thirdInput : recipe.getInputItems().get(2).getItems()) {
                                addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput, thirdInput), Collections.emptyList(), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                            }
                        }
                    }
                }
                case 4 -> {
                    for (ItemStack firstInput : recipe.getInputItems().get(0).getItems()) {
                        for (ItemStack secondInput : recipe.getInputItems().get(1).getItems()) {
                            for (ItemStack thirdInput : recipe.getInputItems().get(2).getItems()) {
                                for (ItemStack forthInput : recipe.getInputItems().get(3).getItems()) {
                                    addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput, thirdInput, forthInput), Collections.emptyList(), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                                }
                            }
                        }
                    }
                }
                case 5 -> {
                    for (ItemStack firstInput : recipe.getInputItems().get(0).getItems()) {
                        for (ItemStack secondInput : recipe.getInputItems().get(1).getItems()) {
                            for (ItemStack thirdInput : recipe.getInputItems().get(2).getItems()) {
                                for (ItemStack forthInput : recipe.getInputItems().get(3).getItems()) {
                                    for (ItemStack firthInput : recipe.getInputItems().get(4).getItems()) {
                                        addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput, thirdInput, forthInput, firthInput), Collections.emptyList(), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                                    }
                                }
                            }
                        }
                    }
                }
                case 6 -> {
                    for (ItemStack firstInput : recipe.getInputItems().get(0).getItems()) {
                        for (ItemStack secondInput : recipe.getInputItems().get(1).getItems()) {
                            for (ItemStack thirdInput : recipe.getInputItems().get(2).getItems()) {
                                for (ItemStack forthInput : recipe.getInputItems().get(3).getItems()) {
                                    for (ItemStack firthInput : recipe.getInputItems().get(4).getItems()) {
                                        for (ItemStack sixthInput : recipe.getInputItems().get(5).getItems()) {
                                            addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput, thirdInput, forthInput, firthInput, sixthInput), Collections.emptyList(), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean validItem(ItemStack item) {

        return validItems.contains(makeNBTComparable(item));
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

        if (inputSlots.isEmpty() && inputTanks.isEmpty() || inputSlots.get(0).isEmpty() && inputTanks.get(0).isEmpty() || inputSlots.isEmpty()) {
            return null;
        }
        List<ComparableItemStack> convertedItems = new ArrayList<>(maxInputItems);
        for (int i = 0; i < maxInputItems; ++i) {
            if (!inputSlots.get(i).isEmpty()) {
                ComparableItemStack compStack = makeComparable(inputSlots.get(i).getItemStack());
                convertedItems.add(compStack);
            }
        }

        if((inputTanks.isEmpty() || inputTanks.get(0).isEmpty()) && convertedItems.isEmpty()) {
            return null;
        }

        if (convertedItems.isEmpty()) {
            return null;
        }
        IMachineRecipe ret = inputTanks.isEmpty() || inputTanks.get(0).isEmpty() ? recipeMap.get(new RecipeMapWrapper(convertedItems)) : recipeMap.get(new RecipeMapWrapper(convertedItems, inputTanks.get(0).getFluidStack()));

        if (ret == null) {
            convertedItems.clear();
            for (int i = 0; i < maxInputItems; ++i) {
                if (!inputSlots.get(i).isEmpty()) {
                    ComparableItemStack compStack = makeComparable(inputSlots.get(i).getItemStack());
                    convertedItems.add(compStack);
                }
            }
            if (convertedItems.isEmpty()) {
                return null;
            }
            ret = inputTanks.isEmpty() || inputTanks.get(0).isEmpty() ? recipeMap.get(new RecipeMapWrapper(convertedItems)) : recipeMap.get(new RecipeMapWrapper(convertedItems, inputTanks.get(0).getFluidStack()));
        }
        return ret;
    }

    protected IMachineRecipe addRecipe(int energy, float experience, List<ItemStack> inputItems, List<FluidStack> inputFluids, List<ItemStack> outputItems, List<Float> chance, List<FluidStack> outputFluids) {

        if(inputItems.isEmpty()) {
            // cannot be empty
            return null;
        }

        if (inputItems.size() > maxInputItems || outputItems.size() > maxOutputItems || outputFluids.size() > maxOutputFluids || energy <= 0) {
            return null;
        }
        for (ItemStack stack : inputItems) {
            if (stack.isEmpty()) {
                return null;
            }
        }
        for (ItemStack stack : outputItems) {
            if (stack.isEmpty()) {
                return null;
            }
        }

        FluidStack fluidStack = FluidStack.EMPTY;

        List<ComparableItemStack> convertedItems = new ArrayList<>(inputItems.size());
        for (ItemStack stack : inputItems) {
            if (!inputItems.isEmpty()) {
                ComparableItemStack compStack = makeNBTComparable(stack);
                validItems.add(compStack);
                convertedItems.add(compStack);
            }
        }

        if(!inputFluids.isEmpty()) {
            FluidStack inputFluid = inputFluids.get(0);
            if (inputFluid.isEmpty()) {
                return null;
            }
            validFluids.add(inputFluid.getFluid());
            fluidStack = inputFluid;
        }

        energy = (int) (energy * getDefaultScale());

        SimpleMachineRecipe recipe = new SimpleMachineRecipe(energy, experience, inputItems, inputFluids, outputItems, chance, outputFluids);
        recipeMap.put(fluidStack.isEmpty() ? new RecipeMapWrapper(convertedItems): new RecipeMapWrapper(convertedItems, fluidStack), recipe);
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
        var recipes = recipeManager.getAllRecipesFor(ThermalExtraRecipeTypes.COMPONENT_ASSEMBLY.get());
        for (var entry : recipes) {
            addRecipe(entry);
        }
    }
    // endregion

}
