package mrthomas20121.thermal_extra.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.client.screens.DynamoFrostScreen;
import mrthomas20121.thermal_extra.client.screens.machine.MachineAdvancedRefineryScreen;
import mrthomas20121.thermal_extra.client.screens.machine.MachineFluidMixerScreen;
import mrthomas20121.thermal_extra.client.screens.machine.MachineMetalInfuserScreen;
import mrthomas20121.thermal_extra.client.screens.machine.MachineNitraticIgniterScreen;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.init.ThermalExtraRecipeTypes;
import mrthomas20121.thermal_extra.recipe.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class ThermalExtraPlugin implements IModPlugin {

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(ThermalExtra.MOD_ID, "extra");
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        RecipeManager recipeManager = getRecipeManager();
        if (recipeManager == null) {
            // TODO: Log an error.
            return;
        }

        registration.addRecipes(COLD_FUEL_TYPE, recipeManager.getAllRecipesFor(ThermalExtraRecipeTypes.COLD_FUEL.get()));
        registration.addRecipes(METAL_INFUSER_TYPE, recipeManager.getAllRecipesFor(ThermalExtraRecipeTypes.METAL_INFUSER.get()));
        registration.addRecipes(ADVANCED_REFINERY_TYPE, recipeManager.getAllRecipesFor(ThermalExtraRecipeTypes.ADVANCED_REFINERY.get()));
        registration.addRecipes(NITRATIC_IGNITER_TYPE, recipeManager.getAllRecipesFor(ThermalExtraRecipeTypes.NITRATIC_IGNITER.get()));
        registration.addRecipes(NITRATIC_IGNITER_CATALYST_TYPE, recipeManager.getAllRecipesFor(ThermalExtraRecipeTypes.NITRATIC_IGNITER_CATALYST.get()));
        registration.addRecipes(FLUID_MIXER_TYPE, recipeManager.getAllRecipesFor(ThermalExtraRecipeTypes.FLUID_MIXER.get()));
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new ColdFuelCategory(registration.getJeiHelpers().getGuiHelper(), new ItemStack(ThermalExtraBlocks.DYNAMO_COLD.get()), COLD_FUEL_TYPE));
        registration.addRecipeCategories(new MetalInfuserRecipeCategory(registration.getJeiHelpers().getGuiHelper(), new ItemStack(ThermalExtraBlocks.METAl_INFUSER.get()), METAL_INFUSER_TYPE));
        registration.addRecipeCategories(new AdvancedRefineryRecipeCategory(registration.getJeiHelpers().getGuiHelper(), new ItemStack(ThermalExtraBlocks.ADVANCED_REFINERY.get()), ADVANCED_REFINERY_TYPE));
        registration.addRecipeCategories(new NitraticIgniterRecipeCategory(registration.getJeiHelpers().getGuiHelper(), new ItemStack(ThermalExtraBlocks.NITRATIC_IGNITER.get()), NITRATIC_IGNITER_TYPE));
        registration.addRecipeCategories(new NitraticIgniterCatalystCategory(registration.getJeiHelpers().getGuiHelper(), new ItemStack(Blocks.TNT), NITRATIC_IGNITER_CATALYST_TYPE));
        registration.addRecipeCategories(new FluidMixerRecipeCategory(registration.getJeiHelpers().getGuiHelper(), new ItemStack(ThermalExtraBlocks.FLUID_MIXER.get()), FLUID_MIXER_TYPE));
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        int progressY = 35;
        int progressW = 24;
        int progressH = 16;

        registration.addRecipeClickArea(DynamoFrostScreen.class, 80, progressY, progressH, progressH, COLD_FUEL_TYPE);
        registration.addRecipeClickArea(MachineMetalInfuserScreen.class, 88, progressY, progressW, progressH, METAL_INFUSER_TYPE);
        registration.addRecipeClickArea(MachineAdvancedRefineryScreen.class, 65, progressY, progressW, progressH, ADVANCED_REFINERY_TYPE);
        registration.addRecipeClickArea(MachineNitraticIgniterScreen.class, 94, progressY, progressW, progressH, NITRATIC_IGNITER_TYPE);
        registration.addRecipeClickArea(MachineFluidMixerScreen.class, 80, progressY, progressW, progressH, FLUID_MIXER_TYPE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ThermalExtraBlocks.DYNAMO_COLD.get()), COLD_FUEL_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ThermalExtraBlocks.METAl_INFUSER.get()), METAL_INFUSER_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ThermalExtraBlocks.ADVANCED_REFINERY.get()), ADVANCED_REFINERY_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ThermalExtraBlocks.NITRATIC_IGNITER.get()), NITRATIC_IGNITER_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ThermalExtraBlocks.NITRATIC_IGNITER.get()), NITRATIC_IGNITER_CATALYST_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ThermalExtraBlocks.FLUID_MIXER.get()), FLUID_MIXER_TYPE);
    }

    private RecipeManager getRecipeManager() {

        RecipeManager recipeManager = null;
        ClientLevel level = Minecraft.getInstance().level;
        if (level != null) {
            recipeManager = level.getRecipeManager();
        }
        return recipeManager;
    }

    public static final RecipeType<ColdFuel> COLD_FUEL_TYPE = new RecipeType<>(ThermalExtraRecipeTypes.COLD_FUEL.getId(), ColdFuel.class);
    public static final RecipeType<MetalInfuserRecipe> METAL_INFUSER_TYPE = new RecipeType<>(ThermalExtraRecipeTypes.METAL_INFUSER.getId(), MetalInfuserRecipe.class);
    public static final RecipeType<FluidMixerRecipe> FLUID_MIXER_TYPE = new RecipeType<>(ThermalExtraRecipeTypes.FLUID_MIXER.getId(), FluidMixerRecipe.class);
    public static final RecipeType<AdvancedRefineryRecipe> ADVANCED_REFINERY_TYPE = new RecipeType<>(ThermalExtraRecipeTypes.ADVANCED_REFINERY.getId(), AdvancedRefineryRecipe.class);
    public static final RecipeType<NitraticIgniterRecipe> NITRATIC_IGNITER_TYPE = new RecipeType<>(ThermalExtraRecipeTypes.NITRATIC_IGNITER.getId(), NitraticIgniterRecipe.class);
    public static final RecipeType<NitraticIgniterCatalyst> NITRATIC_IGNITER_CATALYST_TYPE = new RecipeType<>(ThermalExtraRecipeTypes.NITRATIC_IGNITER_CATALYST.getId(), NitraticIgniterCatalyst.class);
}
