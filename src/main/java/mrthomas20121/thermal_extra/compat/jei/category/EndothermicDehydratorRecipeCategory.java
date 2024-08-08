package mrthomas20121.thermal_extra.compat.jei.category;

import cofh.core.util.helpers.RenderHelper;
import cofh.lib.common.fluid.FluidIngredient;
import cofh.thermal.lib.compat.jei.Drawables;
import cofh.thermal.lib.compat.jei.ThermalRecipeCategory;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mrthomas20121.thermal_extra.client.screens.machine.MachineEndothermicDehydratorScreen;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.recipe.EndothermicDehydratorRecipe;
import mrthomas20121.thermal_extra.recipe.EndothermicDehydratorRecipeManager;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

import static cofh.lib.util.Constants.TANK_MEDIUM;
import static cofh.lib.util.helpers.StringHelper.getTextComponent;
import static cofh.thermal.core.compat.jei.TCoreJeiPlugin.*;

public class EndothermicDehydratorRecipeCategory extends ThermalRecipeCategory<EndothermicDehydratorRecipe> {

    protected IDrawableStatic tankBackground;
    protected IDrawableStatic tankOverlay;

    protected IDrawableStatic outputTankBackground;
    protected IDrawableStatic outputTankOverlay;

    public EndothermicDehydratorRecipeCategory(IGuiHelper guiHelper, ItemStack icon, RecipeType<EndothermicDehydratorRecipe> type) {

        super(guiHelper, icon, type);
        energyMod = () -> EndothermicDehydratorRecipeManager.instance().getDefaultScale();

        background = guiHelper.drawableBuilder(MachineEndothermicDehydratorScreen.TEXTURE, 26, 11, 134, 62)
                .addPadding(0, 0, 16, 24)
                .build();
        name = getTextComponent(ThermalExtraBlocks.BLOCKS.get("endothermic_dehydrator").getDescriptionId());

        progressBackground = Drawables.getDrawables(guiHelper).getProgress(Drawables.PROGRESS_ARROW);
        progressFluidBackground = Drawables.getDrawables(guiHelper).getProgressFill(Drawables.PROGRESS_ARROW_FLUID);
        speedBackground = Drawables.getDrawables(guiHelper).getScale(Drawables.SCALE_COMPACT);

        tankBackground = Drawables.getDrawables(guiHelper).getTank(Drawables.TANK_MEDIUM);
        tankOverlay = Drawables.getDrawables(guiHelper).getTankOverlay(Drawables.TANK_MEDIUM);
        outputTankBackground = Drawables.getDrawables(guiHelper).getTank(Drawables.TANK_MEDIUM);
        outputTankOverlay = Drawables.getDrawables(guiHelper).getTankOverlay(Drawables.TANK_MEDIUM);

        progress = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getProgressFill(Drawables.PROGRESS_ARROW), 200, IDrawableAnimated.StartDirection.LEFT, false);
        progressFluid = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getProgress(Drawables.PROGRESS_ARROW_FLUID), 200, IDrawableAnimated.StartDirection.LEFT, true);
        speed = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getScaleFill(Drawables.SCALE_COMPACT), 400, IDrawableAnimated.StartDirection.TOP, true);
    }

    @Override
    public RecipeType<EndothermicDehydratorRecipe> getRecipeType() {

        return type;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, EndothermicDehydratorRecipe recipe, IFocusGroup focuses) {

        List<Ingredient> inputs = recipe.getInputItems();
        List<FluidIngredient> inputFluids = recipe.getInputFluids();
        List<ItemStack> outputs = recipe.getOutputItems();
        List<FluidStack> outputFluids = recipe.getOutputFluids();

        if(!inputs.isEmpty()) {
            builder.addSlot(RecipeIngredientRole.INPUT, 52, 15)
                    .addIngredients(inputs.get(0));
        }

        int size = outputs.size();
        if(size >= 1) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 6)
                    .addItemStack(outputs.get(0))
                    .addTooltipCallback(defaultOutputTooltip(recipe.getOutputItemChances().get(0)));
        }
        if(size >= 2) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 24)
                    .addItemStack(outputs.get(1))
                    .addTooltipCallback(defaultOutputTooltip(recipe.getOutputItemChances().get(1)));
        }
        if(size >= 3) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 42)
                    .addItemStack(outputs.get(2))
                    .addTooltipCallback(defaultOutputTooltip(recipe.getOutputItemChances().get(2)));
        }
        if(size >= 4) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 126, 6)
                    .addItemStack(outputs.get(3))
                    .addTooltipCallback(defaultOutputTooltip(recipe.getOutputItemChances().get(3)));
        }
        if(size >= 5) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 126, 24)
                    .addItemStack(outputs.get(4))
                    .addTooltipCallback(defaultOutputTooltip(recipe.getOutputItemChances().get(4)));
        }
        if(size >= 6) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 126, 42)
                    .addItemStack(outputs.get(5))
                    .addTooltipCallback(defaultOutputTooltip(recipe.getOutputItemChances().get(5)));
        }

        builder.addSlot(RecipeIngredientRole.INPUT, 25, 11)
                .addIngredients(ForgeTypes.FLUID_STACK, inputFluids.isEmpty() ? List.of(): List.of(inputFluids.get(0).getFluids()))
                .setFluidRenderer(tankSize(TANK_MEDIUM), false, 16, 40)
                .setOverlay(tankOverlay, 0, 0)
                .addTooltipCallback(defaultFluidTooltip());

        if(outputFluids.isEmpty()) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 155, 11)
                    .setFluidRenderer(tankSize(TANK_MEDIUM), false, 16, 40)
                    .setOverlay(outputTankOverlay, 0, 0)
                    .addTooltipCallback(defaultFluidTooltip());
        }
        else {
            FluidStack out = outputFluids.get(0);
            builder.addSlot(RecipeIngredientRole.OUTPUT, 155, 11)
                    .addFluidStack(out.getFluid(), out.getAmount(), out.getTag())
                    .setFluidRenderer(tankSize(TANK_MEDIUM), false, 16, 40)
                    .setOverlay(outputTankOverlay, 0, 0)
                    .addTooltipCallback(defaultFluidTooltip());
        }
    }

    @Override
    public void draw(EndothermicDehydratorRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {

        super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);

        progressBackground.draw(guiGraphics, 78, 24);
        tankBackground.draw(guiGraphics, 24, 10);
        outputTankBackground.draw(guiGraphics, 154, 10);
        speedBackground.draw(guiGraphics, 52, 34);

        if (!recipe.getInputFluids().isEmpty()) {
            RenderHelper.drawFluid(guiGraphics, 78, 24, recipe.getInputFluids().get(0).getFluids()[0], 24, 16);
            progressFluidBackground.draw(guiGraphics, 78, 24);
            progressFluid.draw(guiGraphics, 78, 24);
        } else {
            progress.draw(guiGraphics, 78, 24);
        }
        speed.draw(guiGraphics, 52, 34);
    }

}
