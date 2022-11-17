package mrthomas20121.thermal_extra.datagen;

import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.fluid.FluidThermalExtra;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import slimeknights.mantle.recipe.helper.ItemOutput;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.library.data.recipe.ICommonRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class TinkerRecipeDatagen extends RecipeProvider  implements IConditionBuilder, IMaterialRecipeHelper, IToolRecipeHelper, ISmelteryRecipeHelper, ICommonRecipeHelper {

    public TinkerRecipeDatagen(DataGenerator gen) {
        super(gen);
    }

    @Nonnull
    @Override
    public String getModId() {
        return ThermalExtra.MOD_ID;
    }

    @Override
    protected void buildCraftingRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {
        String meltingFolder = "compat/tconstruct/melting/";
        String castingFolder = "compat/tconstruct/casting/";

        metalMelting(withCondition(consumer, modLoaded("tconstruct")), ThermalExtraFluids.soul_infused.getStillFluid().get(), "soul_infused", false, true, meltingFolder, false);
        metalMelting(withCondition(consumer, modLoaded("tconstruct")), ThermalExtraFluids.shellite.getStillFluid().get(), "shellite", false, true, meltingFolder, false);
        metalMelting(withCondition(consumer, modLoaded("tconstruct")), ThermalExtraFluids.twinite.getStillFluid().get(), "twinite", false, true, meltingFolder, false);
        metalMelting(withCondition(consumer, modLoaded("tconstruct")), ThermalExtraFluids.dragonsteel.getStillFluid().get(), "dragonsteel", false, true, meltingFolder, false);

        metalTagCasting(withCondition(consumer, modLoaded("tconstruct")), ThermalExtraFluids.soul_infused, "soul_infused", castingFolder, false);
        metalTagCasting(withCondition(consumer, modLoaded("tconstruct")), ThermalExtraFluids.shellite, "dragon_enderium", castingFolder, false);
        metalTagCasting(withCondition(consumer, modLoaded("tconstruct")), ThermalExtraFluids.twinite, "drownium", castingFolder, false);
        metalTagCasting(withCondition(consumer, modLoaded("tconstruct")), ThermalExtraFluids.dragonsteel, "dragonsteel", castingFolder, false);
    }

    private  void metalTagCasting(Consumer<FinishedRecipe> consumer, FluidThermalExtra fluid, String name, String folder, boolean forceStandard) {
        // nugget and ingot
        tagCasting(consumer, fluid, FluidValues.NUGGET, TinkerSmeltery.nuggetCast, "nuggets/" + name, folder + name + "/nugget", !forceStandard);
        tagCasting(consumer, fluid, FluidValues.INGOT, TinkerSmeltery.ingotCast, "ingots/" + name, folder + name + "/ingot", !forceStandard);
        tagCasting(consumer, fluid, FluidValues.INGOT, TinkerSmeltery.plateCast, "plates/" + name, folder + name + "/plate", true);
        tagCasting(consumer, fluid, FluidValues.INGOT * 4, TinkerSmeltery.gearCast, "gears/" + name, folder + name + "/gear", true);
        tagCasting(consumer, fluid, FluidValues.NUGGET * 3, TinkerSmeltery.coinCast, "coins/" + name, folder + name + "/coin", true);
        tagCasting(consumer, fluid, FluidValues.INGOT / 2, TinkerSmeltery.rodCast, "rods/" + name, folder + name + "/rod", true);
        tagCasting(consumer, fluid, FluidValues.INGOT / 2, TinkerSmeltery.wireCast, "wires/" + name, folder + name + "/wire", true);
        // block
        TagKey<Item> block = getItemTag("forge", "storage_blocks/" + name);
        Consumer<FinishedRecipe> wrapped = forceStandard ? consumer : withCondition(consumer, tagCondition("storage_blocks/" + name));
        ItemCastingRecipeBuilder.basinRecipe(block)
                .setFluidAndTime(fluid.getStillFluid().get(), fluid.getFluidTag(), FluidValues.METAL_BLOCK)
                .save(wrapped, modResource(folder + name + "/block"));
    }

    private void tagCasting(Consumer<FinishedRecipe> consumer, FluidThermalExtra fluid, int amount, CastItemObject cast, String tagName, String recipeName, boolean optional) {
        if (optional) {
            consumer = withCondition(consumer, tagCondition(tagName));
        }
        castingWithCast(consumer, fluid, amount, cast, ItemOutput.fromTag(getItemTag("forge", tagName), 1), recipeName);
    }

    private void castingWithCast(Consumer<FinishedRecipe> consumer, FluidThermalExtra fluid, int amount, CastItemObject cast, ItemOutput output, String location) {
        ItemCastingRecipeBuilder.tableRecipe(output)
                .setFluidAndTime(fluid.getStillFluid().get(), fluid.getFluidTag(), amount)
                .setCast(cast.getMultiUseTag(), false)
                .save(consumer, modResource(location + "_gold_cast"));
        ItemCastingRecipeBuilder.tableRecipe(output)
                .setFluidAndTime(fluid.getStillFluid().get(), fluid.getFluidTag(), amount)
                .setCast(cast.getSingleUseTag(), true)
                .save(consumer, modResource(location + "_sand_cast"));
    }
}
