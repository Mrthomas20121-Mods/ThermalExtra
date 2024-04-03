package mrthomas20121.thermal_extra.compat.jei;

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
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.recipe.AdvancedRefineryRecipe;
import mrthomas20121.thermal_extra.recipe.AdvancedRefineryRecipeManager;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static cofh.core.util.helpers.ItemHelper.cloneStack;
import static cofh.lib.util.Constants.TANK_MEDIUM;
import static cofh.lib.util.Constants.TANK_SMALL;
import static cofh.lib.util.helpers.StringHelper.getTextComponent;
import static cofh.thermal.core.compat.jei.TCoreJeiPlugin.*;

public class AdvancedRefineryRecipeCategory extends ThermalRecipeCategory<AdvancedRefineryRecipe> {

    protected IDrawableStatic tankInput;
    protected IDrawableStatic tankOutputA;
    protected IDrawableStatic tankOutputB;
    protected IDrawableStatic tankOutputC;

    protected IDrawableStatic inputOverlay;
    protected IDrawableStatic outputOverlayA;
    protected IDrawableStatic outputOverlayB;
    protected IDrawableStatic outputOverlayC;

    public AdvancedRefineryRecipeCategory(IGuiHelper guiHelper, ItemStack icon, RecipeType<AdvancedRefineryRecipe> type) {

        super(guiHelper, icon, type);
        energyMod = () -> AdvancedRefineryRecipeManager.instance().getDefaultScale();

        background = guiHelper.drawableBuilder(MachineAdvancedRefineryScreen.TEXTURE, 26, 11, 124, 62)
                .addPadding(0, 0, 16, 24)
                .build();
        name = getTextComponent(ThermalExtraBlocks.BLOCKS.get("advanced_refinery").getDescriptionId());

        progressBackground = Drawables.getDrawables(guiHelper).getProgress(Drawables.PROGRESS_DROP);
        progressFluidBackground = Drawables.getDrawables(guiHelper).getProgressFill(Drawables.PROGRESS_DROP);
        speedBackground = Drawables.getDrawables(guiHelper).getScale(Drawables.SCALE_FLAME);

        tankInput = Drawables.getDrawables(guiHelper).getTank(Drawables.TANK_SMALL);
        tankOutputA = Drawables.getDrawables(guiHelper).getTank(Drawables.TANK_MEDIUM);
        tankOutputB = Drawables.getDrawables(guiHelper).getTank(Drawables.TANK_MEDIUM);
        tankOutputC = Drawables.getDrawables(guiHelper).getTank(Drawables.TANK_MEDIUM);

        inputOverlay = Drawables.getDrawables(guiHelper).getTankOverlay(Drawables.TANK_SMALL);
        outputOverlayA = Drawables.getDrawables(guiHelper).getTankOverlay(Drawables.TANK_MEDIUM);
        outputOverlayB = Drawables.getDrawables(guiHelper).getTankOverlay(Drawables.TANK_MEDIUM);
        outputOverlayC = Drawables.getDrawables(guiHelper).getTankOverlay(Drawables.TANK_MEDIUM);

        progress = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getProgressFill(Drawables.PROGRESS_DROP), 200, IDrawableAnimated.StartDirection.LEFT, false);
        progressFluid = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getProgress(Drawables.PROGRESS_DROP), 200, IDrawableAnimated.StartDirection.LEFT, true);
        speed = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getScaleFill(Drawables.SCALE_FLAME), 400, IDrawableAnimated.StartDirection.TOP, true);
    }

    @Override
    public RecipeType<AdvancedRefineryRecipe> getRecipeType() {

        return type;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, AdvancedRefineryRecipe recipe, IFocusGroup focuses) {

        List<FluidIngredient> inputFluids = recipe.getInputFluids();
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
        IRecipeSlotBuilder outputSlot = builder.addSlot(RecipeIngredientRole.OUTPUT, 90, 6);
        IRecipeSlotBuilder outputSlot2 = builder.addSlot(RecipeIngredientRole.OUTPUT, 90, 24);
        IRecipeSlotBuilder outputSlot3 = builder.addSlot(RecipeIngredientRole.OUTPUT, 90, 42);
        if (!outputs.isEmpty()) {
            outputSlot.addItemStack(outputs.get(0))
                    .addTooltipCallback(defaultOutputTooltip(recipe.getOutputItemChances().get(0)));
            if(outputs.size() == 2) {
                outputSlot2.addItemStack(outputs.get(1))
                        .addTooltipCallback(defaultOutputTooltip(recipe.getOutputItemChances().get(1)));
            }
            if(outputs.size() == 3) {
                outputSlot3.addItemStack(outputs.get(2))
                        .addTooltipCallback(defaultOutputTooltip(recipe.getOutputItemChances().get(2)));
            }
        }

        builder.addSlot(RecipeIngredientRole.INPUT, 29, 6)
                .addIngredients(ForgeTypes.FLUID_STACK, List.of(inputFluids.get(0).getFluids()))
                .setFluidRenderer(tankSize(TANK_SMALL), false, 16, 32)
                .setOverlay(inputOverlay, 0, 0)
                .addTooltipCallback(defaultFluidTooltip());

        if(!outputFluids.isEmpty()) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 111, 12)
                    .addIngredients(ForgeTypes.FLUID_STACK, List.of(outputFluids.get(0)))
                    .setFluidRenderer(tankSize(TANK_MEDIUM), false, 16, 40)
                    .setOverlay(outputOverlayA, 0, 0)
                    .addTooltipCallback(defaultFluidTooltip());

            IRecipeSlotBuilder slotBuilder1 = builder.addSlot(RecipeIngredientRole.OUTPUT, 129, 12)
                    .setFluidRenderer(tankSize(TANK_MEDIUM), false, 16, 40)
                    .setOverlay(outputOverlayB, 0, 0)
                    .addTooltipCallback(defaultFluidTooltip());

            if(outputFluids.size() == 2) {
                slotBuilder1.addIngredients(ForgeTypes.FLUID_STACK, List.of(outputFluids.get(1)));
            }
            IRecipeSlotBuilder slotBuilder2 = builder.addSlot(RecipeIngredientRole.OUTPUT, 147, 12)
                    .setFluidRenderer(tankSize(TANK_MEDIUM), false, 16, 40)
                    .setOverlay(outputOverlayC, 0, 0)
                    .addTooltipCallback(defaultFluidTooltip());
            if(outputFluids.size() == 3) {
                slotBuilder2.addIngredients(ForgeTypes.FLUID_STACK, List.of(outputFluids.get(2)));
            }
        }
    }

    @Override
    public void draw(AdvancedRefineryRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {

        super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);

        progressBackground.draw(guiGraphics, 57, 22);
        tankInput.draw(guiGraphics, 28, 5);
        tankOutputA.draw(guiGraphics, 110, 11);
        tankOutputB.draw(guiGraphics, 128, 11);
        tankOutputC.draw(guiGraphics, 146, 11);
        speedBackground.draw(guiGraphics, 29, 40);

        if (!recipe.getInputFluids().isEmpty()) {
            RenderHelper.drawFluid(guiGraphics, 57, 22, recipe.getInputFluids().get(0).getFluids()[0], 24, 16);
            progressFluidBackground.draw(guiGraphics, 57, 22);
            progressFluid.draw(guiGraphics, 57, 22);
        } else {
            progress.draw(guiGraphics, 57, 22);
        }
        speed.draw(guiGraphics, 29, 40);
    }

}
