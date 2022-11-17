package mrthomas20121.thermal_extra.datagen;

import cofh.lib.data.RecipeProviderCoFH;
import cofh.lib.tags.ItemTagsCoFH;
import cofh.thermal.core.ThermalCore;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import mrthomas20121.thermal_extra.init.ThermalExtraTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

import static cofh.thermal.lib.common.ThermalFlags.*;

public class ExtraRecipeGen extends RecipeProviderCoFH {

    public ExtraRecipeGen(DataGenerator generatorIn) {
        super(generatorIn, ThermalExtra.MOD_ID);
    }

    @Override
    protected void buildCraftingRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {

        ShapelessRecipeBuilder.shapeless(ThermalExtraItems.soul_infused_dust.get(), 2)
                .requires(ThermalExtraTags.Items.SOUL_SAND_DUST)
                .requires(ThermalExtraTags.Items.SOUL_SAND_DUST)
                .requires(ThermalExtraTags.Items.SOUL_SAND_DUST)
                .requires(ItemTagsCoFH.DUSTS_APATITE)
                .requires(ItemTagsCoFH.DUSTS_INVAR)
                .requires(ItemTagsCoFH.DUSTS_INVAR)
                .unlockedBy("has_apatite_dust", has(ItemTagsCoFH.DUSTS_APATITE))
                .unlockedBy("has_invar_dust", has(ItemTagsCoFH.DUSTS_INVAR))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ThermalExtraItems.shellite_dust.get(), 2)
                .requires(Items.SHULKER_SHELL)
                .requires(Items.SHULKER_SHELL)
                .requires(Items.SHULKER_SHELL)
                .requires(ItemTagsCoFH.DUSTS_APATITE)
                .requires(ItemTagsCoFH.DUSTS_BRONZE)
                .requires(ItemTagsCoFH.DUSTS_BRONZE)
                .unlockedBy("has_apatite_dust", has(ItemTagsCoFH.DUSTS_APATITE))
                .unlockedBy("has_bronze_dust", has(ItemTagsCoFH.DUSTS_BRONZE))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ThermalExtraItems.twinite_dust.get(), 2)
                .requires(ThermalExtraTags.Items.DUSTS_AMETHYST)
                .requires(ThermalExtraTags.Items.DUSTS_AMETHYST)
                .requires(ThermalExtraTags.Items.DUSTS_AMETHYST)
                .requires(ItemTagsCoFH.DUSTS_APATITE)
                .requires(ItemTagsCoFH.DUSTS_ENDERIUM)
                .requires(ItemTagsCoFH.DUSTS_ENDERIUM)
                .unlockedBy("has_apatite_dust", has(ItemTagsCoFH.DUSTS_APATITE))
                .unlockedBy("has_bronze_dust", has(ItemTagsCoFH.DUSTS_BRONZE))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ThermalExtraItems.dragon_steel_dust.get(), 2)
                .requires(Items.DRAGON_BREATH)
                .requires(Items.DRAGON_BREATH)
                .requires(Items.DRAGON_BREATH)
                .requires(ItemTagsCoFH.DUSTS_APATITE)
                .requires(ItemTagsCoFH.DUSTS_APATITE)
                .requires(ItemTagsCoFH.DUSTS_NETHERITE)
                .unlockedBy("has_netherite_dust", has(ItemTagsCoFH.DUSTS_NETHERITE))
                .unlockedBy("has_apatite_dust", has(ItemTagsCoFH.DUSTS_APATITE))
                .save(consumer);

        Block glass = ThermalCore.BLOCKS.get("obsidian_glass");

        ShapelessRecipeBuilder.shapeless(ThermalExtraBlocks.SOUL_INFUSED_GLASS.get(), 2)
                .requires(glass)
                .requires(glass)
                .requires(fromTags(ThermalExtraTags.Items.SOUL_INFUSED_INGOT, ThermalExtraTags.Items.SOUL_INFUSED_DUST))
                .requires(Items.FIRE_CHARGE)
                .unlockedBy("has_obsidian_glass", has(glass))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ThermalExtraBlocks.SHELLITE_GLASS.get(), 2)
                .requires(glass)
                .requires(glass)
                .requires(fromTags(ThermalExtraTags.Items.SHELLITE_INGOT, ThermalExtraTags.Items.SHELLITE_DUST))
                .requires(Items.FIRE_CHARGE)
                .unlockedBy("has_obsidian_glass", has(glass))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ThermalExtraBlocks.TWINITE_GLASS.get(), 2)
                .requires(glass)
                .requires(glass)
                .requires(fromTags(ThermalExtraTags.Items.TWINITE_INGOT, ThermalExtraTags.Items.TWINITE_DUST))
                .requires(Items.FIRE_CHARGE)
                .unlockedBy("has_obsidian_glass", has(glass))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ThermalExtraBlocks.DRAGONSTEEL_GLASS.get(), 2)
                .requires(glass)
                .requires(glass)
                .requires(fromTags(ThermalExtraTags.Items.DRAGONSTEEL_INGOT, ThermalExtraTags.Items.DRAGONSTEEL_DUST))
                .requires(Items.FIRE_CHARGE)
                .unlockedBy("has_obsidian_glass", has(glass))
                .save(consumer);

        this.generateTypeRecipes(ThermalExtraItems.ITEMS, consumer, "soul_infused");
        this.generateTypeRecipes(ThermalExtraItems.ITEMS, consumer, "shellite");
        this.generateTypeRecipes(ThermalExtraItems.ITEMS, consumer, "twinite");
        this.generateTypeRecipes(ThermalExtraItems.ITEMS, consumer, "dragonsteel");

        this.generateSmeltingAndBlastingRecipes(ThermalExtraItems.ITEMS, consumer, "soul_infused", 1f);
        this.generateSmeltingAndBlastingRecipes(ThermalExtraItems.ITEMS, consumer, "shellite", 1f);
        this.generateSmeltingAndBlastingRecipes(ThermalExtraItems.ITEMS, consumer, "twinite", 1f);
        this.generateSmeltingAndBlastingRecipes(ThermalExtraItems.ITEMS, consumer, "dragonsteel", 1f);

        generateAugmentRecipes(consumer);
    }

    public void generateAugmentRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {

        augmentRecipe(consumer, "area_radius_augment", FLAG_AREA_AUGMENTS, true);
        augmentRecipe(consumer, "potion_amplifier_augment", FLAG_POTION_AUGMENTS, true, true);
        augmentRecipe(consumer, "potion_duration_augment", FLAG_POTION_AUGMENTS, true, true);
        augmentRecipe(consumer, "rf_coil_augment", FLAG_STORAGE_AUGMENTS, true, true);
        augmentRecipe(consumer, "rf_coil_xfer_augment", FLAG_STORAGE_AUGMENTS, true, true);
        augmentRecipe(consumer, "rf_coil_storage_augment", FLAG_STORAGE_AUGMENTS, true, true);
        augmentRecipe(consumer, "fluid_tank_augment", FLAG_STORAGE_AUGMENTS, true, true);
        augmentRecipe(consumer, "machine_speed_augment", FLAG_MACHINE_AUGMENTS, true);
        augmentRecipe(consumer, "machine_efficiency_augment", FLAG_MACHINE_AUGMENTS, true);
        augmentRecipe(consumer, "machine_output_augment", FLAG_MACHINE_AUGMENTS);
        augmentRecipe(consumer, "machine_catalyst_augment", FLAG_MACHINE_AUGMENTS);
        augmentRecipe(consumer, "dynamo_fuel_augment", FLAG_DYNAMO_AUGMENTS, true);
        augmentRecipe(consumer, "dynamo_output_augment", FLAG_DYNAMO_AUGMENTS, true);

        String folder = "augments";

        Item result = ThermalExtraItems.integral_component.get();
        Item part = ThermalCore.ITEMS.get("upgrade_augment_3");

        ShapedRecipeBuilder.shaped(result)
                .define('G', ThermalExtraTags.Items.DRAGONSTEEL_GEAR)
                .define('I', ItemTagsCoFH.DUSTS_NETHERITE)
                .define('X', part)
                .pattern("IGI")
                .pattern("GXG")
                .pattern("IGI")
                .unlockedBy("has_upgrade_augment_3", has(part))
                .save(withConditions(consumer).flag(FLAG_UPGRADE_AUGMENTS), this.modid + ":" + folder + "/" + name(result));

        result = ThermalExtraItems.av_item_filter_augment.get();
        part = ThermalCore.ITEMS.get("item_filter_augment");

        ShapedRecipeBuilder.shaped(result)
                .define('G', ItemTagsCoFH.GEARS_ENDERIUM)
                .define('I', ItemTagsCoFH.DUSTS_APATITE)
                .define('X', part)
                .pattern("IGI")
                .pattern("GXG")
                .pattern("IGI")
                .unlockedBy("has_item_filter_augment", has(part))
                .save(withConditions(consumer).flag(FLAG_UPGRADE_AUGMENTS), this.modid + ":" + folder + "/" + name(result));
    }

    public void augmentRecipe(@Nonnull Consumer<FinishedRecipe> consumer, String name, String flag) {
        augmentRecipe(consumer, name, flag, false);
    }

    public void augmentRecipe(@Nonnull Consumer<FinishedRecipe> consumer, String name, String flag, boolean forth) {
        augmentRecipe(consumer, name, flag, forth, false);
    }

    public void augmentRecipe(@Nonnull Consumer<FinishedRecipe> consumer, String name, String flag, boolean forth, boolean fifth) {
        String folder = "augments";

        Item result = ThermalExtraItems.ITEMS.get(name+"_1");
        Item part = ThermalCore.ITEMS.get(name);

        ShapedRecipeBuilder.shaped(result)
                .define('G', ThermalExtraTags.Items.DRAGONSTEEL_GEAR)
                .define('I', ItemTagsCoFH.DUSTS_NETHERITE)
                .define('X', part)
                .pattern("IGI")
                .pattern("GXG")
                .pattern("IGI")
                .unlockedBy("has_"+name, has(part))
                .save(withConditions(consumer).flag(flag), this.modid + ":" + folder + "/" + name(result));

        result = ThermalExtraItems.ITEMS.get(name+"_2");
        part = ThermalExtraItems.ITEMS.get(name+"_1");

        ShapedRecipeBuilder.shaped(result)
                .define('G', ItemTagsCoFH.GEARS_ENDERIUM)
                .define('I', ItemTagsCoFH.DUSTS_APATITE)
                .define('X', part)
                .pattern("IGI")
                .pattern("GXG")
                .pattern("IGI")
                .unlockedBy("has_"+name+"_1", has(part))
                .save(withConditions(consumer).flag(flag), this.modid + ":" + folder + "/" + name(result));

        result = ThermalExtraItems.ITEMS.get(name+"_3");
        part = ThermalExtraItems.ITEMS.get(name+"_2");

        ShapedRecipeBuilder.shaped(result)
                .define('G', ThermalExtraTags.Items.SHELLITE_GEAR)
                .define('I', ItemTagsCoFH.DUSTS_NITER)
                .define('X', part)
                .pattern("IGI")
                .pattern("GXG")
                .pattern("IGI")
                .unlockedBy("has_"+name+"_1", has(part))
                .save(withConditions(consumer).flag(flag), this.modid + ":" + folder + "/" + name(result));

        if(forth) {

            result = ThermalExtraItems.ITEMS.get(name+"_4");
            part = ThermalExtraItems.ITEMS.get(name+"_3");

            ShapedRecipeBuilder.shaped(result)
                    .define('G', ThermalExtraTags.Items.TWINITE_GEAR)
                    .define('I', ItemTagsCoFH.DUSTS_QUARTZ)
                    .define('X', part)
                    .pattern("IGI")
                    .pattern("GXG")
                    .pattern("IGI")
                    .unlockedBy("has_"+name+"_3", has(part))
                    .save(withConditions(consumer).flag(flag), this.modid + ":" + folder + "/" + name(result));
            if(fifth) {

                result = ThermalExtraItems.ITEMS.get(name+"_5");
                part = ThermalExtraItems.ITEMS.get(name+"_4");

                ShapedRecipeBuilder.shaped(result)
                        .define('G', ThermalExtraTags.Items.DRAGONSTEEL_GEAR)
                        .define('I', ItemTagsCoFH.DUSTS_NETHERITE)
                        .define('X', part)
                        .pattern("IGI")
                        .pattern("GXG")
                        .pattern("IGI")
                        .unlockedBy("has_"+name+"_4", has(part))
                        .save(withConditions(consumer).flag(flag), this.modid + ":" + folder + "/" + name(result));
            }
        }
    }
}
