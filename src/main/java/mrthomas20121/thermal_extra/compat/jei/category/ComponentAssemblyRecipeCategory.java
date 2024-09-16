package mrthomas20121.thermal_extra.compat.jei.category;

import cofh.core.util.helpers.RenderHelper;
import cofh.lib.common.fluid.FluidIngredient;
import cofh.thermal.lib.compat.jei.Drawables;
import cofh.thermal.lib.compat.jei.ThermalRecipeCategory;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mrthomas20121.thermal_extra.client.screens.machine.MachineAdvancedRefineryScreen;
import mrthomas20121.thermal_extra.client.screens.machine.MachineComponentAssemblyScreen;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.recipe.AdvancedRefineryRecipe;
import mrthomas20121.thermal_extra.recipe.AdvancedRefineryRecipeManager;
import mrthomas20121.thermal_extra.recipe.ComponentAssemblyRecipe;
import mrthomas20121.thermal_extra.recipe.ComponentAssemblyRecipeManager;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.List;

import static cofh.core.util.helpers.ItemHelper.cloneStack;
import static cofh.lib.util.Constants.TANK_MEDIUM;
import static cofh.lib.util.Constants.TANK_SMALL;
import static cofh.lib.util.helpers.StringHelper.getTextComponent;
import static cofh.thermal.core.compat.jei.TCoreJeiPlugin.*;

public class ComponentAssemblyRecipeCategory extends ThermalRecipeCategory<ComponentAssemblyRecipe> {

    protected IDrawableStatic tankInput;
    protected IDrawableStatic tankOutput;

    protected IDrawableStatic inputOverlay;
    protected IDrawableStatic outputOverlay;

    public ComponentAssemblyRecipeCategory(IGuiHelper guiHelper, ItemStack icon, RecipeType<ComponentAssemblyRecipe> type) {

        super(guiHelper, icon, type);
        energyMod = () -> ComponentAssemblyRecipeManager.instance().getDefaultScale();

        background = guiHelper.drawableBuilder(MachineComponentAssemblyScreen.TEXTURE, 26, 11, 128, 62)
                .addPadding(0, 0, 16, 24)
                .build();
        name = getTextComponent(ThermalExtraBlocks.BLOCKS.get("component_assembly").getDescriptionId());

        progressBackground = Drawables.getDrawables(guiHelper).getProgress(Drawables.PROGRESS_ARROW);
        progressFluidBackground = Drawables.getDrawables(guiHelper).getProgressFill(Drawables.PROGRESS_ARROW_FLUID);

        tankInput = Drawables.getDrawables(guiHelper).getTank(Drawables.TANK_MEDIUM);
        tankOutput = Drawables.getDrawables(guiHelper).getTank(Drawables.TANK_MEDIUM);

        inputOverlay = Drawables.getDrawables(guiHelper).getTankOverlay(Drawables.TANK_MEDIUM);
        outputOverlay = Drawables.getDrawables(guiHelper).getTankOverlay(Drawables.TANK_MEDIUM);

        progress = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getProgressFill(Drawables.PROGRESS_ARROW), 200, IDrawableAnimated.StartDirection.LEFT, false);
        progressFluid = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getProgress(Drawables.PROGRESS_ARROW_FLUID), 200, IDrawableAnimated.StartDirection.LEFT, true);
    }

    @Override
    public RecipeType<ComponentAssemblyRecipe> getRecipeType() {

        return type;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ComponentAssemblyRecipe recipe, IFocusGroup focuses) {

        List<FluidIngredient> inputFluids = recipe.getInputFluids();
        List<Ingredient> inputs = recipe.getInputItems();
        List<ItemStack> outputs = new ArrayList<>(recipe.getOutputItems().size());
        List<FluidStack> outputFluids = recipe.getOutputFluids();

        for (ItemStack stack : recipe.getOutputItems()) {
            outputs.add(cloneStack(stack));
        }
        for (int i = 0; i < outputs.size(); ++i) {
            float chance = recipe.getOutputItemChances().get(i);
            if (chance > 1.0F) {
                outputs.get(i).setCount((int) chance);
            }
        }

        IRecipeSlotBuilder inputSlot1 = builder.addSlot(RecipeIngredientRole.INPUT, 52, 6);
        IRecipeSlotBuilder inputSlot3 = builder.addSlot(RecipeIngredientRole.INPUT, 52, 24);
        IRecipeSlotBuilder inputSlot5 = builder.addSlot(RecipeIngredientRole.INPUT, 52, 42);
        IRecipeSlotBuilder inputSlot2 = builder.addSlot(RecipeIngredientRole.INPUT, 70, 6);
        IRecipeSlotBuilder inputSlot4 = builder.addSlot(RecipeIngredientRole.INPUT, 70, 24);
        IRecipeSlotBuilder inputSlot6 = builder.addSlot(RecipeIngredientRole.INPUT, 70, 42);

        if (!inputs.isEmpty()) {
            inputSlot1.addIngredients(inputs.get(0));
            if(inputs.size() >= 2) {
                inputSlot2.addIngredients(inputs.get(1));
            }
            if(inputs.size() >= 3) {
                inputSlot3.addIngredients(inputs.get(2));
            }
            if(inputs.size() >= 4) {
                inputSlot4.addIngredients(inputs.get(3));
            }
            if(inputs.size() >= 5) {
                inputSlot5.addIngredients(inputs.get(4));
            }
            if(inputs.size() >= 6) {
                inputSlot6.addIngredients(inputs.get(5));
            }
        }

        IRecipeSlotBuilder outputSlot = builder.addSlot(RecipeIngredientRole.OUTPUT, 120, 24);

        if(!outputs.isEmpty()) {
            outputSlot.addItemStack(outputs.get(0))
                    .addTooltipCallback(defaultOutputTooltip(recipe.getOutputItemChances().get(0)));
        }

        builder.addSlot(RecipeIngredientRole.INPUT, 29, 11)
                .addIngredients(ForgeTypes.FLUID_STACK, inputFluids.size() == 0 ? List.of(FluidStack.EMPTY): List.of(inputFluids.get(0).getFluids()))
                .setFluidRenderer(tankSize(TANK_MEDIUM), false, 16, 40)
                .setOverlay(inputOverlay, 0, 0)
                .addTooltipCallback(defaultFluidTooltip());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 152, 11)
                .addIngredients(ForgeTypes.FLUID_STACK, outputFluids.isEmpty() ? List.of(FluidStack.EMPTY) : List.of(outputFluids.get(0)))
                .setFluidRenderer(tankSize(TANK_MEDIUM), false, 16, 40)
                .setOverlay(outputOverlay, 0, 0)
                .addTooltipCallback(defaultFluidTooltip());
    }

    @Override
    public void draw(ComponentAssemblyRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {

        super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);

        progressBackground.draw(guiGraphics, 88, 22);
        tankInput.draw(guiGraphics, 28, 10);
        tankOutput.draw(guiGraphics, 151, 10);

        if (!recipe.getInputFluids().isEmpty()) {
            RenderHelper.drawFluid(guiGraphics, 88, 24, recipe.getInputFluids().get(0).getFluids()[0], 24, 16);
            progressFluidBackground.draw(guiGraphics, 88, 24);
            progressFluid.draw(guiGraphics, 88, 24);
        } else {
            progress.draw(guiGraphics, 88, 23);
        }
    }

}
