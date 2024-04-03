package mrthomas20121.thermal_extra.recipe;

import cofh.thermal.lib.util.recipes.ThermalCatalyst;
import mrthomas20121.thermal_extra.init.ThermalExtraRecipeSerializers;
import mrthomas20121.thermal_extra.init.ThermalExtraRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import javax.annotation.Nonnull;

import static cofh.thermal.core.init.registries.TCoreRecipeSerializers.SMELTER_CATALYST_SERIALIZER;
import static cofh.thermal.core.init.registries.TCoreRecipeTypes.SMELTER_CATALYST;

public class NitraticIgniterCatalyst extends ThermalCatalyst {

    public NitraticIgniterCatalyst(ResourceLocation recipeId, Ingredient ingredient, float primaryMod, float secondaryMod, float energyMod, float minChance, float useChance) {

        super(recipeId, ingredient, primaryMod, secondaryMod, energyMod, minChance, useChance);
    }

    @Nonnull
    @Override
    public RecipeSerializer<?> getSerializer() {

        return ThermalExtraRecipeSerializers.NITRATIC_IGNITER_CATALYST_SERIALIZER.get();
    }

    @Nonnull
    @Override
    public RecipeType<?> getType() {

        return ThermalExtraRecipeTypes.NITRATIC_IGNITER_CATALYST.get();
    }

}
