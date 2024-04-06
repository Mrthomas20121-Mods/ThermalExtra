package mrthomas20121.thermal_extra.compat.jei.category;

import cofh.thermal.expansion.client.gui.dynamo.DynamoStirlingScreen;
import cofh.thermal.lib.compat.jei.Drawables;
import cofh.thermal.lib.compat.jei.ThermalFuelCategory;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.recipe.ColdFuel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

import static cofh.lib.util.helpers.StringHelper.getTextComponent;

public class ColdFuelCategory extends ThermalFuelCategory<ColdFuel> {

    public ColdFuelCategory(IGuiHelper guiHelper, ItemStack icon, RecipeType<ColdFuel> type) {

        super(guiHelper, icon, type);

        background = guiHelper.drawableBuilder(DynamoStirlingScreen.TEXTURE, 26, 11, 70, 62)
                .addPadding(0, 0, 16, 78)
                .build();
        name = getTextComponent(ThermalExtraBlocks.DYNAMO_COLD.get().getDescriptionId());

        durationBackground = Drawables.getDrawables(guiHelper).getScale(Drawables.SCALE_FLAME);
        duration = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getScaleFill(Drawables.SCALE_FLAME), 400, IDrawableAnimated.StartDirection.TOP, true);
    }

    @Override
    public RecipeType<ColdFuel> getRecipeType() {

        return type;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ColdFuel fuel, IFocusGroup focuses) {

        List<Ingredient> inputs = fuel.getInputItems();

        builder.addSlot(RecipeIngredientRole.INPUT, 34, 24)
                .addIngredients(inputs.get(0));
    }

}
