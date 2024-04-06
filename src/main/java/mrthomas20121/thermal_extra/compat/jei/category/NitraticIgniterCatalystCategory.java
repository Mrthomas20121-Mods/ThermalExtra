package mrthomas20121.thermal_extra.compat.jei.category;


import cofh.thermal.lib.compat.jei.ThermalCatalystCategory;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.recipe.NitraticIgniterCatalyst;
import net.minecraft.world.item.ItemStack;

import static cofh.lib.util.helpers.StringHelper.getTextComponent;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.lib.util.ThermalIDs.ID_MACHINE_SMELTER;

public class NitraticIgniterCatalystCategory extends ThermalCatalystCategory<NitraticIgniterCatalyst> {

    public NitraticIgniterCatalystCategory(IGuiHelper guiHelper, ItemStack icon, RecipeType<NitraticIgniterCatalyst> type) {

        super(guiHelper, icon, type);

        name = getTextComponent(ThermalExtraBlocks.BLOCKS.get("nitratic_igniter").getDescriptionId()).append(": ").append(getTextComponent("info.thermal.catalysts"));
    }

    @Override
    public RecipeType<NitraticIgniterCatalyst> getRecipeType() {

        return type;
    }

}
