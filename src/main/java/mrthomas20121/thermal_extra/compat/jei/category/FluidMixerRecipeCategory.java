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
import mrthomas20121.thermal_extra.client.screens.machine.MachineFluidMixerScreen;
import mrthomas20121.thermal_extra.client.screens.machine.MachineMetalInfuserScreen;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.recipe.FluidMixerRecipe;
import mrthomas20121.thermal_extra.recipe.FluidMixerRecipeManager;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

import static cofh.lib.util.Constants.TANK_MEDIUM;
import static cofh.lib.util.helpers.StringHelper.getTextComponent;
import static cofh.thermal.core.compat.jei.TCoreJeiPlugin.*;

public class FluidMixerRecipeCategory extends ThermalRecipeCategory<FluidMixerRecipe> {

    protected IDrawableStatic tankBackground;

    protected IDrawableStatic tankInputA;
    protected IDrawableStatic tankInputB;
    protected IDrawableStatic tankOutputC;
    protected IDrawableStatic tankOutputD;

    protected IDrawableStatic tankOverlayA;
    protected IDrawableStatic tankOverlayB;
    protected IDrawableStatic tankOverlayD;
    protected IDrawableStatic tankOverlayC;

    public FluidMixerRecipeCategory(IGuiHelper guiHelper, ItemStack icon, RecipeType<FluidMixerRecipe> type) {

        super(guiHelper, icon, type);
        energyMod = () -> FluidMixerRecipeManager.instance().getDefaultScale();

        background = guiHelper.drawableBuilder(MachineFluidMixerScreen.TEXTURE, 26, 11, 124, 62)
                .addPadding(0, 0, 16, 24)
                .build();
        name = getTextComponent(ThermalExtraBlocks.BLOCKS.get("fluid_mixer").getDescriptionId());

        progressBackground = Drawables.getDrawables(guiHelper).getProgress(Drawables.PROGRESS_DROP);
        progressFluidBackground = Drawables.getDrawables(guiHelper).getProgressFill(Drawables.PROGRESS_DROP);
        speedBackground = Drawables.getDrawables(guiHelper).getScale(Drawables.SCALE_FLAME);

        tankInputA = Drawables.getDrawables(guiHelper).getTank(Drawables.TANK_MEDIUM);
        tankOverlayA = Drawables.getDrawables(guiHelper).getTankOverlay(Drawables.TANK_MEDIUM);

        tankInputB = Drawables.getDrawables(guiHelper).getTank(Drawables.TANK_MEDIUM);
        tankOverlayB = Drawables.getDrawables(guiHelper).getTankOverlay(Drawables.TANK_MEDIUM);

        tankOutputC = Drawables.getDrawables(guiHelper).getTank(Drawables.TANK_MEDIUM);
        tankOverlayC = Drawables.getDrawables(guiHelper).getTankOverlay(Drawables.TANK_MEDIUM);

        tankOutputD = Drawables.getDrawables(guiHelper).getTank(Drawables.TANK_MEDIUM);
        tankOverlayD = Drawables.getDrawables(guiHelper).getTankOverlay(Drawables.TANK_MEDIUM);

        progress = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getProgressFill(Drawables.PROGRESS_DROP), 200, IDrawableAnimated.StartDirection.LEFT, false);
        progressFluid = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getProgress(Drawables.PROGRESS_DROP), 200, IDrawableAnimated.StartDirection.LEFT, true);
        speed = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getScaleFill(Drawables.SCALE_FLAME), 400, IDrawableAnimated.StartDirection.TOP, true);
    }

    @Override
    public RecipeType<FluidMixerRecipe> getRecipeType() {

        return type;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FluidMixerRecipe recipe, IFocusGroup focuses) {

        List<FluidIngredient> inputFluids = recipe.getInputFluids();
        List<FluidStack> outputFluids = recipe.getOutputFluids();

        builder.addSlot(RecipeIngredientRole.INPUT, 25, 11)
                .addIngredients(ForgeTypes.FLUID_STACK, List.of(inputFluids.get(0).getFluids()))
                .setFluidRenderer(tankSize(TANK_MEDIUM), false, 16, 40)
                .setOverlay(tankOverlayA, 0, 0)
                .addTooltipCallback(defaultFluidTooltip());

        builder.addSlot(RecipeIngredientRole.INPUT, 52, 11)
                .addIngredients(ForgeTypes.FLUID_STACK, List.of(inputFluids.get(1).getFluids()))
                .setFluidRenderer(tankSize(TANK_MEDIUM), false, 16, 40)
                .setOverlay(tankOverlayB, 0, 0)
                .addTooltipCallback(defaultFluidTooltip());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 115, 11)
                .addFluidStack(outputFluids.get(0).getFluid(), outputFluids.get(0).getAmount())
                .setFluidRenderer(tankSize(TANK_MEDIUM), false, 16, 40)
                .setOverlay(tankOverlayC, 0, 0)
                .addTooltipCallback(defaultFluidTooltip());

        boolean bool = outputFluids.size() == 2;
        IRecipeSlotBuilder b = builder.addSlot(RecipeIngredientRole.OUTPUT, 142, 11)
                .setFluidRenderer(tankSize(TANK_MEDIUM), false, 16, 40)
                .setOverlay(tankOverlayD, 0, 0)
                .addTooltipCallback(defaultFluidTooltip());
        if(bool) {
            b.addFluidStack(outputFluids.get(1).getFluid(), outputFluids.get(1).getAmount());
        }
    }

    @Override
    public void draw(FluidMixerRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {

        super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);

        progressBackground.draw(guiGraphics, 78, 24);
        tankInputA.draw(guiGraphics, 24, 10);
        tankInputB.draw(guiGraphics, 51, 10);
        tankOutputC.draw(guiGraphics, 114, 10);
        tankOutputD.draw(guiGraphics, 141, 10);
        speedBackground.draw(guiGraphics, 52, 34);

        RenderHelper.drawFluid(guiGraphics, 78, 24, recipe.getInputFluids().get(0).getFluids()[0], 24, 16);
        progressFluidBackground.draw(guiGraphics, 78, 24);
        progressFluid.draw(guiGraphics, 78, 24);

        speed.draw(guiGraphics, 52, 34);
    }

}
