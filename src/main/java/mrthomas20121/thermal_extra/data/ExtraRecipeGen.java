package mrthomas20121.thermal_extra.data;

import cofh.lib.common.fluid.FluidIngredient;
import cofh.lib.init.data.RecipeProviderCoFH;
import cofh.lib.init.tags.ItemTagsCoFH;
import cofh.lib.util.DeferredRegisterCoFH;
import cofh.lib.util.crafting.IngredientWithCount;
import cofh.lib.util.flags.TagExistsRecipeCondition;
import cofh.thermal.core.ThermalCore;
import cofh.thermal.core.init.registries.TCoreFluids;
import cofh.thermal.lib.util.ThermalIDs;
import cofh.thermal.lib.util.references.ThermalTags;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.data.thermal_recipe.DynamoRecipeBuilder;
import mrthomas20121.thermal_extra.data.thermal_recipe.MachineRecipeBuilder;
import mrthomas20121.thermal_extra.fluid.FluidThermalExtra;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import mrthomas20121.thermal_extra.init.ThermalExtraTags;
import mrthomas20121.thermal_extra.item.augment.EnumAugment;
import mrthomas20121.thermal_extra.item.augment.ExtraAugmentType;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.NotCondition;
import net.minecraftforge.common.crafting.conditions.TagEmptyCondition;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.lib.util.ThermalFlags.*;

public class ExtraRecipeGen extends RecipeProviderCoFH {

    public ExtraRecipeGen(PackOutput generatorIn) {
        super(generatorIn, ThermalExtra.MOD_ID);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {

        generateFullToolSet("signalum", "signalum_ingot", ItemTagsCoFH.INGOTS_SIGNALUM, ThermalExtraTags.Items.RODS_SIGNALUM, ItemTagsCoFH.STORAGE_BLOCKS_SIGNALUM, consumer);
        generateFullToolSet("lumium", "lumium_ingot", ItemTagsCoFH.INGOTS_LUMIUM, ThermalExtraTags.Items.RODS_LUMIUM, ItemTagsCoFH.STORAGE_BLOCKS_LUMIUM, consumer);
        generateFullToolSet("enderium", "enderium_ingot", ItemTagsCoFH.INGOTS_ENDERIUM, ThermalExtraTags.Items.RODS_ENDERIUM, ItemTagsCoFH.STORAGE_BLOCKS_ENDERIUM, consumer);
        generateFullToolSet("soul_infused", "soul_infused_ingot", ThermalExtraTags.Items.SOUL_INFUSED_INGOT, ThermalExtraTags.Items.RODS_SOUL_INFUSED, ThermalExtraTags.Items.STORAGE_BLOCKS_SOUL_INFUSED, consumer);
        generateFullToolSet("twinite", "twinite_ingot", ThermalExtraTags.Items.TWINITE_INGOT, ThermalExtraTags.Items.RODS_TWINITE, ThermalExtraTags.Items.STORAGE_BLOCKS_TWINITE, consumer);
        generateFullToolSet("shellite", "shellite_ingot", ThermalExtraTags.Items.SHELLITE_INGOT, ThermalExtraTags.Items.RODS_SHELLITE, ThermalExtraTags.Items.STORAGE_BLOCKS_SHELLITE, consumer);
        generateFullToolSet("dragonsteel", "dragonsteel_ingot", ThermalExtraTags.Items.DRAGONSTEEL_INGOT, ThermalExtraTags.Items.RODS_DRAGONSTEEL, ThermalExtraTags.Items.STORAGE_BLOCKS_DRAGONSTEEL, consumer);
        generateFullToolSet("abyssal", "abyssal_ingot", ThermalExtraTags.Items.ABYSSAL_INGOT, ThermalExtraTags.Items.RODS_ABYSSAL, ThermalExtraTags.Items.STORAGE_BLOCKS_ABYSSAL, consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PAPER, 2)
                .requires(ThermalExtraItems.STICKY_BALL.get())
                .requires(ThermalExtraItems.STICKY_BALL.get())
                .requires(ThermalExtraItems.STICKY_BALL.get())
                .unlockedBy("has_sticky_ball", has(ThermalExtraItems.STICKY_BALL.get()))
                .save(consumer, new ResourceLocation("thermal_extra:sticky_ball_to_paper"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ThermalExtraItems.SOUL_INFUSED_DUST.get(), 2)
                .requires(ThermalExtraTags.Items.DUSTS_SOUL_SAND)
                .requires(ThermalExtraTags.Items.DUSTS_SOUL_SAND)
                .requires(ItemTagsCoFH.DUSTS_IRON)
                .requires(ItemTagsCoFH.DUSTS_COPPER)
                .unlockedBy("has_soul_sand", has(ThermalExtraTags.Items.DUSTS_SOUL_SAND))
                .unlockedBy("has_copper_dust", has(ItemTagsCoFH.DUSTS_COPPER))
                .unlockedBy("has_iron_dust", has(ItemTagsCoFH.DUSTS_IRON))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ThermalExtraItems.TWINITE_DUST.get(), 2)
                .requires(ItemTagsCoFH.DUSTS_TIN)
                .requires(ItemTagsCoFH.DUSTS_TIN)
                .requires(Items.BLAZE_POWDER)
                .requires(ThermalExtraTags.Items.DUSTS_OBSIDIAN)
                .unlockedBy("has_blaze_powder", has(Items.BLAZE_POWDER))
                .unlockedBy("has_obsidian_dust", has(Items.OBSIDIAN))
                .unlockedBy("has_tin_dust", has(ItemTagsCoFH.DUSTS_TIN))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ThermalExtraItems.SHELLITE_DUST.get(), 2)
                .requires(Items.SHULKER_SHELL)
                .requires(Items.SHULKER_SHELL)
                .requires(ItemTagsCoFH.DUSTS_LEAD)
                .requires(ItemTagsCoFH.DUSTS_NICKEL)
                .unlockedBy("has_shulker_shell", has(Items.SHULKER_SHELL))
                .unlockedBy("has_lead_dust", has(ItemTagsCoFH.DUSTS_LEAD))
                .unlockedBy("has_nickel_dust", has(ItemTagsCoFH.DUSTS_NICKEL))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ThermalExtraItems.DRAGONSTEEL_DUST.get(), 2)
                .requires(ThermalExtraItems.ANCIENT_DUST.get())
                .requires(ThermalExtraItems.ANCIENT_DUST.get())
                .requires(Items.NETHERITE_SCRAP)
                .requires(ItemTagsCoFH.DUSTS_ENDER_PEARL)
                .unlockedBy("has_ancient_dust", has(ThermalExtraItems.ANCIENT_DUST.get()))
                .unlockedBy("has_netherite_scrap", has(Items.NETHERITE_SCRAP))
                .unlockedBy("has_nickel_dust", has(ItemTagsCoFH.DUSTS_NICKEL))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ThermalExtraItems.ABYSSAL_DUST.get(), 2)
                .requires(ItemTagsCoFH.DUSTS_DIAMOND)
                .requires(ItemTagsCoFH.DUSTS_DIAMOND)
                .requires(Items.NETHERITE_SCRAP)
                .requires(Items.ECHO_SHARD)
                .unlockedBy("has_nickel_dust", has(ItemTagsCoFH.DUSTS_NICKEL))
                .unlockedBy("has_netherite_scrap", has(Items.NETHERITE_SCRAP))
                .unlockedBy("has_echo_shard", has(Items.ECHO_SHARD))
                .save(consumer);

        Block glass = BLOCKS.get("obsidian_glass");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ThermalExtraBlocks.SOUL_INFUSED_GLASS.get(), 2)
                .requires(glass)
                .requires(glass)
                .requires(fromTags(ThermalExtraTags.Items.SOUL_INFUSED_INGOT, ThermalExtraTags.Items.SOUL_INFUSED_DUST))
                .requires(Items.FIRE_CHARGE)
                .unlockedBy("has_obsidian_glass", has(glass))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ThermalExtraBlocks.SHELLITE_GLASS.get(), 2)
                .requires(glass)
                .requires(glass)
                .requires(fromTags(ThermalExtraTags.Items.SHELLITE_INGOT, ThermalExtraTags.Items.SHELLITE_DUST))
                .requires(Items.FIRE_CHARGE)
                .unlockedBy("has_obsidian_glass", has(glass))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ThermalExtraBlocks.TWINITE_GLASS.get(), 2)
                .requires(glass)
                .requires(glass)
                .requires(fromTags(ThermalExtraTags.Items.TWINITE_INGOT, ThermalExtraTags.Items.TWINITE_DUST))
                .requires(Items.FIRE_CHARGE)
                .unlockedBy("has_obsidian_glass", has(glass))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ThermalExtraBlocks.DRAGONSTEEL_GLASS.get(), 2)
                .requires(glass)
                .requires(glass)
                .requires(fromTags(ThermalExtraTags.Items.DRAGONSTEEL_INGOT, ThermalExtraTags.Items.DRAGONSTEEL_DUST))
                .requires(Items.FIRE_CHARGE)
                .unlockedBy("has_obsidian_glass", has(glass))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ThermalExtraBlocks.ABYSSAL_GLASS.get(), 2)
                .requires(glass)
                .requires(glass)
                .requires(fromTags(ThermalExtraTags.Items.ABYSSAL_INGOT, ThermalExtraTags.Items.ABYSSAL_DUST))
                .requires(Items.FIRE_CHARGE)
                .unlockedBy("has_obsidian_glass", has(glass))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ThermalExtraItems.PRESS_ROD_DIE.get())
                .define('P', ItemTagsCoFH.INGOTS_INVAR)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern(" P ")
                .pattern("PSP")
                .pattern(" P ")
                .unlockedBy("has_invar_ingot", has(ItemTagsCoFH.INGOTS_INVAR))
                .save(consumer, this.modid + ":crafting/rod_die");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ThermalExtraItems.CHILLER_PLATE_CAST.get())
                .define('P', ItemTagsCoFH.PLATES_BRONZE)
                .pattern(" P ")
                .pattern("PPP")
                .pattern(" P ")
                .unlockedBy("has_bronze_plate", has(ItemTagsCoFH.PLATES_BRONZE))
                .save(consumer, this.modid + ":crafting/chiller_plate_cast");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ThermalExtraItems.AUGMENT_TEMPLATE.get())
                .define('R', ITEMS.get("rf_coil"))
                .define('I', ItemTagsCoFH.PLATES_INVAR)
                .pattern(" I ")
                .pattern("IRI")
                .pattern(" I ")
                .unlockedBy("has_rf_coil", has(ITEMS.get("rf_coil")))
                .unlockedBy("has_invar_plate", has(ItemTagsCoFH.PLATES_INVAR))
                .save(consumer, this.modid + ":crafting/augment_smithing_templte");

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ThermalExtraBlocks.DYNAMO_COLD.get())
                .define('R', ITEMS.get("rf_coil"))
                .define('G', ItemTagsCoFH.GEARS_INVAR)
                .define('I', ItemTagsCoFH.INGOTS_SILVER)
                .define('D', ThermalExtraTags.Items.DUSTS_AMETHYST)
                .define('E', Tags.Items.DUSTS_REDSTONE)
                .pattern(" R ")
                .pattern("IGI")
                .pattern("DED")
                .unlockedBy("has_rf_coil", has(ITEMS.get("rf_coil")))
                .save(consumer, this.modid + ":crafting/dynamo_frost");

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ThermalExtraBlocks.FLUID_MIXER.get())
                .define('G', ItemTagsCoFH.GEARS_CONSTANTAN)
                .define('I', ThermalExtraTags.Items.SOUL_INFUSED_INGOT)
                .define('M', ITEMS.get(ThermalIDs.ID_MACHINE_FRAME))
                .define('H', ThermalTags.Items.HARDENED_GLASS)
                .define('R', ITEMS.get("rf_coil"))
                .pattern(" I ")
                .pattern("HMH")
                .pattern("GRG")
                .unlockedBy("has_machine_frame", has(ThermalCore.ITEMS.get(ThermalIDs.ID_MACHINE_FRAME)))
                .save(consumer, this.modid + ":crafting/fluid_mixer");

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ThermalExtraBlocks.ADVANCED_REFINERY.get())
                .define('G', ItemTagsCoFH.GEARS_ELECTRUM)
                .define('I', ThermalExtraTags.Items.TWINITE_INGOT)
                .define('M', ITEMS.get(ThermalIDs.ID_MACHINE_REFINERY))
                .define('H', ThermalTags.Items.HARDENED_GLASS)
                .define('R', ITEMS.get("rf_coil"))
                .pattern(" I ")
                .pattern("HMH")
                .pattern("GRG")
                .unlockedBy("has_"+ThermalIDs.ID_MACHINE_REFINERY, has(ThermalCore.ITEMS.get(ThermalIDs.ID_MACHINE_REFINERY)))
                .save(consumer, this.modid + ":crafting/advanced_refinery");

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ThermalExtraBlocks.COMPONENT_ASSEMBLY.get())
                .define('I', ThermalExtraItems.POLYOLEFIN_PLATE.get())
                .define('G', ItemTagsCoFH.GEARS_ENDERIUM)
                .define('M', ITEMS.get(ThermalIDs.ID_MACHINE_FRAME))
                .define('H', ThermalTags.Items.HARDENED_GLASS)
                .define('R', ITEMS.get("rf_coil"))
                .pattern(" I ")
                .pattern("HMH")
                .pattern("GRG")
                .unlockedBy("has_machine_frame", has(ThermalCore.ITEMS.get(ThermalIDs.ID_MACHINE_FRAME)))
                .save(consumer, this.modid + ":crafting/component_assembly");

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ThermalExtraBlocks.ENDOTHERMIC_DEHYDRATOR.get())
                .define('G', ThermalTags.Items.HARDENED_GLASS)
                .define('I', ThermalExtraTags.Items.TWINITE_INGOT)
                .define('M', ITEMS.get(ThermalIDs.ID_MACHINE_FRAME))
                .define('E', ItemTagsCoFH.GEARS_LUMIUM)
                .define('R', ITEMS.get("rf_coil"))
                .pattern(" I ")
                .pattern("GMG")
                .pattern("ERE")
                .unlockedBy("has_machine_frame", has(ThermalCore.ITEMS.get(ThermalIDs.ID_MACHINE_FRAME)))
                .save(consumer, this.modid + ":crafting/endothermic_dehydrator");

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ThermalExtraBlocks.NITRATIC_IGNITER.get())
                .define('O', ThermalExtraItems.POLYOLEFIN_PLATE.get())
                .define('I', ThermalExtraTags.Items.RODS_TWINITE)
                .define('M', ITEMS.get(ThermalIDs.ID_MACHINE_FRAME))
                .define('E', ItemTagsCoFH.GEARS_SIGNALUM)
                .define('R', ITEMS.get("rf_coil"))
                .pattern(" I ")
                .pattern("OMO")
                .pattern("ERE")
                .unlockedBy("has_machine_frame", has(ThermalCore.ITEMS.get(ThermalIDs.ID_MACHINE_FRAME)))
                .save(consumer, this.modid + ":crafting/nitratic_igniter");

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ThermalExtraBlocks.LAVA_GEN.get())
                .define('N', Tags.Items.INGOTS_IRON)
                .define('R', ThermalCore.ITEMS.get("redstone_servo"))
                .define('I', ThermalExtraTags.Items.RODS_SOUL_INFUSED)
                .define('M', Items.BUCKET)
                .define('G', Blocks.WARPED_WART_BLOCK)
                .pattern("INI")
                .pattern("GMG")
                .pattern("IRI")
                .unlockedBy("has_redstone_servo", has(ThermalCore.ITEMS.get("redstone_servo")))
                .save(consumer, this.modid + ":crafting/device_lava_gen");

        Map<String, TagKey<Item>> materials = of(new String[] {
                "copper",
                "iron",
                "gold",
                "netherite",
                "lead",
                "tin",
                "silver",
                "nickel",
                "bronze",
                "electrum",
                "constantan",
                "invar",
                "signalum",
                "lumium",
                "enderium",
                "soul_infused",
                "twinite",
                "shellite",
                "dragonsteel",
                "abyssal"
        },
                Tags.Items.INGOTS_COPPER,
                Tags.Items.INGOTS_IRON,
                Tags.Items.INGOTS_GOLD,
                Tags.Items.INGOTS_NETHERITE,
                ItemTagsCoFH.INGOTS_LEAD,
                ItemTagsCoFH.INGOTS_TIN,
                ItemTagsCoFH.INGOTS_SILVER,
                ItemTagsCoFH.INGOTS_NICKEL,
                ItemTagsCoFH.INGOTS_BRONZE,
                ItemTagsCoFH.INGOTS_ELECTRUM,
                ItemTagsCoFH.INGOTS_CONSTANTAN,
                ItemTagsCoFH.INGOTS_INVAR,
                ItemTagsCoFH.INGOTS_SIGNALUM,
                ItemTagsCoFH.INGOTS_LUMIUM,
                ItemTagsCoFH.INGOTS_ENDERIUM,
                ThermalExtraTags.Items.SOUL_INFUSED_INGOT,
                ThermalExtraTags.Items.TWINITE_INGOT,
                ThermalExtraTags.Items.SHELLITE_INGOT,
                ThermalExtraTags.Items.DRAGONSTEEL_INGOT,
                ThermalExtraTags.Items.ABYSSAL_INGOT
        );

        materials.forEach((key, value) -> rodRecipe("crafting/"+key+"_rod", key, value, consumer));

        this.generateTypeRecipes(ThermalExtraItems.ITEMS, consumer, "soul_infused");
        this.generateTypeRecipes(ThermalExtraItems.ITEMS, consumer, "shellite");
        this.generateTypeRecipes(ThermalExtraItems.ITEMS, consumer, "twinite");
        this.generateTypeRecipes(ThermalExtraItems.ITEMS, consumer, "dragonsteel");
        this.generateTypeRecipes(ThermalExtraItems.ITEMS, consumer, "abyssal");

        this.generateSmeltingAndBlastingRecipes(ThermalExtraItems.ITEMS, consumer, "soul_infused", 1f);
        this.generateSmeltingAndBlastingRecipes(ThermalExtraItems.ITEMS, consumer, "shellite", 1f);
        this.generateSmeltingAndBlastingRecipes(ThermalExtraItems.ITEMS, consumer, "twinite", 1f);
        this.generateSmeltingAndBlastingRecipes(ThermalExtraItems.ITEMS, consumer, "dragonsteel", 1f);
        this.generateSmeltingAndBlastingRecipes(ThermalExtraItems.ITEMS, consumer, "abyssal", 1f);

        generateAugmentRecipes(consumer);
        generateMachineRecipes(consumer);
    }

    public void generateMachineRecipes(@NotNull Consumer<FinishedRecipe> consumer) {

        MachineRecipeBuilder.crystallizer()
                .energy(10000)
                .input(Fluids.WATER, 1000)
                .input(ThermalExtraItems.ANCIENT_DUST.get())
                .output(ThermalExtraItems.ANCIENT_DUST.get(), 2)
                .save(consumer, "thermal_extra:machine/crystallizer/ancient_dust");

        MachineRecipeBuilder.pulverizer()
                .energy(7000)
                .input(Tags.Items.GEMS_AMETHYST)
                .output(ThermalExtraItems.AMETHYST_DUST.get())
                .save(consumer, "thermal_extra:machine/pulverizer/amethyst_dust");

        MachineRecipeBuilder.pulverizer()
                .energy(7000)
                .input(Tags.Items.OBSIDIAN)
                .output(ThermalExtraItems.OBSIDIAN_DUST.get())
                .save(consumer, "thermal_extra:machine/pulverizer/obsidian_dust");

        MachineRecipeBuilder.pulverizer()
                .energy(50000)
                .input(Items.DRAGON_HEAD)
                .output(ThermalExtraItems.ANCIENT_DUST.get())
                .save(consumer, "thermal_extra:machine/pulverizer/ancient_dust");

        MachineRecipeBuilder.pulverizer()
                .energy(50000)
                .input(ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .output(ThermalExtraItems.SOUL_SAND_DUST.get())
                .save(consumer, "thermal_extra:machine/pulverizer/soul_sand_dust");

        MachineRecipeBuilder.pulverizer()
                .energy(5000)
                .input(ThermalExtraTags.Items.SOUL_INFUSED_DUST)
                .output(ThermalExtraItems.SOUL_INFUSED_DUST.get())
                .save(consumer, modLoc("machine/pulverizer/soul_infused_dust"));

        MachineRecipeBuilder.pulverizer()
                .energy(5000)
                .input(ThermalExtraTags.Items.TWINITE_DUST)
                .output(ThermalExtraItems.TWINITE_DUST.get())
                .save(consumer, modLoc("machine/pulverizer/twinite_dust"));

        MachineRecipeBuilder.pulverizer()
                .energy(5000)
                .input(ThermalExtraTags.Items.SHELLITE_DUST)
                .output(ThermalExtraItems.SHELLITE_DUST.get())
                .save(consumer, modLoc("machine/pulverizer/shellite_dust"));

        MachineRecipeBuilder.pulverizer()
                .energy(5000)
                .input(ThermalExtraTags.Items.DRAGONSTEEL_DUST)
                .output(ThermalExtraItems.DRAGONSTEEL_DUST.get())
                .save(consumer, modLoc("machine/pulverizer/dragonsteel_dust"));

        MachineRecipeBuilder.pulverizer()
                .energy(5000)
                .input(ThermalExtraTags.Items.ABYSSAL_DUST)
                .output(ThermalExtraItems.ABYSSAL_DUST.get())
                .save(consumer, modLoc("machine/pulverizer/abyssal_dust"));

        Item ingotCast = ITEMS.get("chiller_ingot_cast");

        MachineRecipeBuilder.blastChiller()
                .input(ThermalExtraFluids.RAW_COPPER.getStillFluid().get(), 90)
                .input(ingotCast)
                .output(Items.COPPER_INGOT)
                .energy(10000)
                .save(consumer, modLoc("machine/chiller/raw_copper"));

        MachineRecipeBuilder.blastChiller()
                .input(ThermalExtraFluids.RAW_GOLD.getStillFluid().get(), 90)
                .input(ingotCast)
                .output(Items.GOLD_INGOT)
                .energy(10000)
                .save(consumer, modLoc("machine/chiller/raw_gold"));

        MachineRecipeBuilder.blastChiller()
                .input(ThermalExtraFluids.RAW_IRON.getStillFluid().get(), 90)
                .input(ingotCast)
                .output(Items.IRON_INGOT)
                .energy(10000)
                .save(consumer, modLoc("machine/chiller/raw_iron"));

        MachineRecipeBuilder.blastChiller()
                .input(ThermalExtraFluids.RAW_LEAD.getStillFluid().get(), 90)
                .input(ingotCast)
                .output(ITEMS.get("lead_ingot"))
                .energy(10000)
                .save(consumer, modLoc("machine/chiller/raw_lead"));

        MachineRecipeBuilder.blastChiller()
                .input(ThermalExtraFluids.RAW_TIN.getStillFluid().get(), 90)
                .input(ingotCast)
                .output(ITEMS.get("tin_ingot"))
                .energy(10000)
                .save(consumer, modLoc("machine/chiller/raw_tin"));

        MachineRecipeBuilder.blastChiller()
                .input(ThermalExtraFluids.RAW_NICKEL.getStillFluid().get(), 90)
                .input(ingotCast)
                .output(ITEMS.get("nickel_ingot"))
                .energy(10000)
                .save(consumer, modLoc("machine/chiller/raw_nickel"));

        MachineRecipeBuilder.blastChiller()
                .input(ThermalExtraFluids.RAW_SILVER.getStillFluid().get(), 90)
                .input(ingotCast)
                .output(ITEMS.get("silver_ingot"))
                .energy(10000)
                .save(consumer, modLoc("machine/chiller/raw_silver"));

        MachineRecipeBuilder.press()
                .energy(6000)
                .input(Items.SUNFLOWER)
                .output(ThermalExtraFluids.SUNFLOWER_OIL.still().get(), 100)
                .save(consumer, "thermal_extra:machine/press/sunflower");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(Tags.Items.INGOTS_COPPER)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.COPPER_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/copper_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(Tags.Items.INGOTS_IRON)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.IRON_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/iron_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(Tags.Items.INGOTS_GOLD)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.GOLD_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/gold_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(Tags.Items.GEMS_DIAMOND)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.DIAMOND_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/diamond_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(Tags.Items.GEMS_EMERALD)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.EMERALD_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/emerald_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(Tags.Items.INGOTS_NETHERITE)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.NETHERITE_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/netherite_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ItemTagsCoFH.INGOTS_TIN)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.TIN_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/tin_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ItemTagsCoFH.INGOTS_LEAD)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.LEAD_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/lead_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ItemTagsCoFH.INGOTS_SILVER)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.SILVER_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/silver_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ItemTagsCoFH.INGOTS_NICKEL)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.NICKEL_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/nickel_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ItemTagsCoFH.INGOTS_BRONZE)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.BRONZE_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/bronze_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ItemTagsCoFH.INGOTS_CONSTANTAN)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.CONSTANTAN_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/constantan_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ItemTagsCoFH.INGOTS_ELECTRUM)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.ELECTRUM_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/electrum_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ItemTagsCoFH.INGOTS_INVAR)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.INVAR_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/invar_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ItemTagsCoFH.INGOTS_SIGNALUM)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.SIGNALUM_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/signalum_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ItemTagsCoFH.INGOTS_LUMIUM)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.LUMIUM_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/lumium_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ItemTagsCoFH.INGOTS_ENDERIUM)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.ENDERIUM_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/enderium_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ThermalExtraTags.Items.SOUL_INFUSED_INGOT)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.SOUL_INFUSED_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/soul_infused_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ThermalExtraTags.Items.TWINITE_INGOT)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.TWINITE_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/twinite_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ThermalExtraTags.Items.SHELLITE_INGOT)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.SHELLITE_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/shellite_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ThermalExtraTags.Items.DRAGONSTEEL_INGOT)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.DRAGONSTEEL_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/dragonsteel_rod");

        MachineRecipeBuilder.press()
                .energy(9000)
                .input(ThermalExtraTags.Items.ABYSSAL_INGOT)
                .input(ThermalExtraItems.PRESS_ROD_DIE.get())
                .output(ThermalExtraItems.ABYSSAL_ROD.get(), 2)
                .save(consumer, "thermal_extra:machine/press/abyssal_rod");

        MachineRecipeBuilder.press()
                .energy(3000)
                .input(ThermalExtraTags.Items.SOUL_INFUSED_INGOT)
                .output(ThermalExtraItems.SOUL_INFUSED_PLATE.get())
                .save(consumer, modLoc("machine/press/soul_infused_plate"));

        MachineRecipeBuilder.press()
                .energy(3000)
                .input(ThermalExtraTags.Items.TWINITE_INGOT)
                .output(ThermalExtraItems.TWINITE_PLATE.get())
                .save(consumer, modLoc("machine/press/twinite_plate"));

        MachineRecipeBuilder.press()
                .energy(3000)
                .input(ThermalExtraTags.Items.SHELLITE_INGOT)
                .output(ThermalExtraItems.SHELLITE_PLATE.get())
                .save(consumer, modLoc("machine/press/shellite_plate"));

        MachineRecipeBuilder.press()
                .energy(3000)
                .input(ThermalExtraTags.Items.DRAGONSTEEL_INGOT)
                .output(ThermalExtraItems.DRAGONSTEEL_PLATE.get())
                .save(consumer, modLoc("machine/press/dragonsteel_plate"));

        MachineRecipeBuilder.press()
                .energy(3000)
                .input(ThermalExtraTags.Items.ABYSSAL_INGOT)
                .output(ThermalExtraItems.ABYSSAL_PLATE.get())
                .save(consumer, modLoc("machine/press/abyssal_plate"));

        MachineRecipeBuilder.press()
                .energy(3000)
                .input(ThermalExtraTags.Items.SOUL_INFUSED_INGOT)
                .input(ITEMS.get("press_coin_die"))
                .output(ThermalExtraItems.SOUL_INFUSED_COIN.get(), 3)
                .save(consumer, modLoc("machine/press/soul_infused_coin"));
        MachineRecipeBuilder.press()
                .energy(3000)
                .input(ThermalExtraTags.Items.SOUL_INFUSED_NUGGET)
                .input(ITEMS.get("press_coin_die"))
                .output(ThermalExtraItems.SOUL_INFUSED_COIN.get(), 1)
                .save(consumer, modLoc("machine/press/soul_infused_nugget_to_coin"));

        MachineRecipeBuilder.press()
                .energy(3000)
                .input(ThermalExtraTags.Items.TWINITE_INGOT)
                .input(ITEMS.get("press_coin_die"))
                .output(ThermalExtraItems.TWINITE_COIN.get(), 3)
                .save(consumer, modLoc("machine/press/twinite_coin"));
        MachineRecipeBuilder.press()
                .energy(3000)
                .input(ThermalExtraTags.Items.TWINITE_NUGGET)
                .input(ITEMS.get("press_coin_die"))
                .output(ThermalExtraItems.TWINITE_COIN.get(), 1)
                .save(consumer, modLoc("machine/press/twinite_nugget_to_coin"));

        MachineRecipeBuilder.press()
                .energy(3000)
                .input(ThermalExtraTags.Items.SHELLITE_INGOT)
                .input(ITEMS.get("press_coin_die"))
                .output(ThermalExtraItems.SHELLITE_COIN.get(), 3)
                .save(consumer, modLoc("machine/press/shellite_coin"));
        MachineRecipeBuilder.press()
                .energy(3000)
                .input(ThermalExtraTags.Items.SHELLITE_NUGGET)
                .input(ITEMS.get("press_coin_die"))
                .output(ThermalExtraItems.SHELLITE_COIN.get(), 1)
                .save(consumer, modLoc("machine/press/shellite_nugget_to_coin"));

        MachineRecipeBuilder.press()
                .energy(3000)
                .input(ThermalExtraTags.Items.DRAGONSTEEL_INGOT)
                .input(ITEMS.get("press_coin_die"))
                .output(ThermalExtraItems.DRAGONSTEEL_COIN.get(), 3)
                .save(consumer, modLoc("machine/press/dragonsteel_coin"));
        MachineRecipeBuilder.press()
                .energy(3000)
                .input(ThermalExtraTags.Items.DRAGONSTEEL_NUGGET)
                .input(ITEMS.get("press_coin_die"))
                .output(ThermalExtraItems.DRAGONSTEEL_COIN.get(), 1)
                .save(consumer, modLoc("machine/press/dragonsteel_nugget_to_coin"));

        MachineRecipeBuilder.press()
                .energy(3000)
                .input(ThermalExtraTags.Items.TWINITE_INGOT)
                .input(ITEMS.get("press_coin_die"))
                .output(ThermalExtraItems.TWINITE_COIN.get(), 3)
                .save(consumer, modLoc("machine/press/abyssal_coin"));
        MachineRecipeBuilder.press()
                .energy(3000)
                .input(ThermalExtraTags.Items.ABYSSAL_NUGGET)
                .input(ITEMS.get("press_coin_die"))
                .output(ThermalExtraItems.ABYSSAL_COIN.get(), 1)
                .save(consumer, modLoc("machine/press/abyssal_nugget_to_coin"));

        MachineRecipeBuilder.endothermic_dehydrator()
                .energy(100000)
                .input(new FluidStack(Fluids.LAVA, 1000))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(Items.BLAZE_POWDER), 0.25f))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(Items.FLINT), 0.25f))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(Items.MAGMA_CREAM), 0.1f))
                .save(consumer, modLoc("machine/endothermic_dehydrator/lava"));

        MachineRecipeBuilder.endothermic_dehydrator()
                .energy(100000)
                .input(new FluidStack(ThermalExtraFluids.RAW_COPPER.still().get(), 90))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("copper_dust"), 2), 1.25f, true))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("copper_dust")), 0.50f))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("gold_dust")), 0.15f))
                .save(consumer, modLoc("machine/endothermic_dehydrator/raw_copper"));

        MachineRecipeBuilder.endothermic_dehydrator()
                .energy(100000)
                .input(new FluidStack(ThermalExtraFluids.RAW_GOLD.still().get(), 90))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("gold_dust"), 2), 1.25f, true))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("gold_dust")), 0.50f))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("copper_dust")), 0.15f))
                .save(consumer, modLoc("machine/endothermic_dehydrator/raw_gold"));

        MachineRecipeBuilder.endothermic_dehydrator()
                .energy(100000)
                .input(new FluidStack(ThermalExtraFluids.RAW_IRON.still().get(), 90))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("iron_dust"), 2), 1.25f, true))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("iron_dust")), 0.50f))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("nickel_dust")), 0.15f))
                .save(consumer, modLoc("machine/endothermic_dehydrator/raw_iron"));

        MachineRecipeBuilder.endothermic_dehydrator()
                .energy(100000)
                .input(new FluidStack(ThermalExtraFluids.RAW_LEAD.still().get(), 90))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("lead_dust"), 2), 1.25f, true))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("lead_dust")), 0.50f))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("silver_dust")), 0.15f))
                .save(consumer, modLoc("machine/endothermic_dehydrator/raw_lead"));

        MachineRecipeBuilder.endothermic_dehydrator()
                .energy(100000)
                .input(new FluidStack(ThermalExtraFluids.RAW_NICKEL.still().get(), 90))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("nickel_dust"), 2), 1.25f, true))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("nickel_dust")), 0.50f))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("iron_dust")), 0.15f))
                .save(consumer, modLoc("machine/endothermic_dehydrator/raw_nickel"));

        MachineRecipeBuilder.endothermic_dehydrator()
                .energy(100000)
                .input(new FluidStack(ThermalExtraFluids.RAW_SILVER.still().get(), 90))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("silver_dust"), 2), 1.25f, true))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("silver_dust")), 0.50f))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("lead_dust")), 0.15f))
                .save(consumer, modLoc("machine/endothermic_dehydrator/raw_silver"));

        MachineRecipeBuilder.endothermic_dehydrator()
                .energy(100000)
                .input(new FluidStack(ThermalExtraFluids.RAW_TIN.still().get(), 90))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("tin_dust"), 2), 1.25f, true))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("tin_dust")), 0.50f))
                .output(MachineRecipeBuilder.ChanceItemStack.of(new ItemStack(ITEMS.get("apatite")), 0.15f))
                .save(consumer, modLoc("machine/endothermic_dehydrator/raw_tin"));

        MachineRecipeBuilder.endothermic_dehydrator_no_chance()
                .input(Items.COOKED_BEEF)
                .output(ThermalExtraItems.BEEF_JERKY.get())
                .save(consumer, modLoc("machine/endothermic_dehydrator/beef_jerky"));

        MachineRecipeBuilder.endothermic_dehydrator_no_chance()
                .input(Items.COOKED_CHICKEN)
                .output(ThermalExtraItems.CHICKEN_JERKY.get())
                .save(consumer, modLoc("machine/endothermic_dehydrator/chicken_jerky"));

        MachineRecipeBuilder.endothermic_dehydrator_no_chance()
                .input(Items.COOKED_COD)
                .output(ThermalExtraItems.COD_JERKY.get())
                .save(consumer, modLoc("machine/endothermic_dehydrator/cod_jerky"));

        MachineRecipeBuilder.endothermic_dehydrator_no_chance()
                .input(Items.COOKED_MUTTON)
                .output(ThermalExtraItems.MUTTON_JERKY.get())
                .save(consumer, modLoc("machine/endothermic_dehydrator/mutton_jerky"));

        MachineRecipeBuilder.endothermic_dehydrator_no_chance()
                .input(Items.COOKED_PORKCHOP)
                .output(ThermalExtraItems.PORK_JERKY.get())
                .save(consumer, modLoc("machine/endothermic_dehydrator/pork_jerky"));

        MachineRecipeBuilder.endothermic_dehydrator_no_chance()
                .input(Items.COOKED_RABBIT)
                .output(ThermalExtraItems.RABBIT_JERKY.get())
                .save(consumer, modLoc("machine/endothermic_dehydrator/rabbit_jerky"));

        MachineRecipeBuilder.endothermic_dehydrator_no_chance()
                .input(Items.COOKED_SALMON)
                .output(ThermalExtraItems.SALMON_JERKY.get())
                .save(consumer, modLoc("machine/endothermic_dehydrator/salmon_jerky"));

        MachineRecipeBuilder.nitratic_igniter_catalyst()
                .ingredient(Blocks.TNT.asItem())
                .primaryMod(1.01f)
                .secondaryMod(1.01f)
                .energyMod(1.1f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/tnt"));

        MachineRecipeBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_NUKE_TNT).asItem())
                .primaryMod(5f)
                .secondaryMod(5f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/nuke_tnt"));

        MachineRecipeBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_EARTH_TNT).asItem())
                .primaryMod(2f)
                .secondaryMod(3f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/earth_tnt"));

        MachineRecipeBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_ENDER_TNT).asItem())
                .primaryMod(3f)
                .secondaryMod(2f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/ender_tnt"));

        MachineRecipeBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_FIRE_TNT).asItem())
                .primaryMod(3f)
                .secondaryMod(3f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/fire_tnt"));

        MachineRecipeBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_GLOWSTONE_TNT).asItem())
                .primaryMod(1.1f)
                .secondaryMod(5f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/glowstone_tnt"));

        MachineRecipeBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_ICE_TNT).asItem())
                .primaryMod(1.9f)
                .secondaryMod(0.1f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/ice_tnt"));

        MachineRecipeBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_LIGHTNING_TNT).asItem())
                .primaryMod(4f)
                .secondaryMod(0.1f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/lightning_tnt"));

        MachineRecipeBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_PHYTO_TNT).asItem())
                .primaryMod(2.5f)
                .secondaryMod(2.5f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/phyto_tnt"));

        MachineRecipeBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_REDSTONE_TNT).asItem())
                .primaryMod(2.5f)
                .secondaryMod(2.5f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/redstone_tnt"));

        MachineRecipeBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_SLIME_TNT).asItem())
                .primaryMod(3.1f)
                .secondaryMod(2.1f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/slime_tnt"));

        MachineRecipeBuilder.blastChiller()
                .energy(30000)
                .input(FluidIngredient.of(new FluidStack(ThermalExtraFluids.POLYOLEFIN.still().get(), 1000)))
                .input(ThermalExtraItems.CHILLER_PLATE_CAST.get())
                .output(ThermalExtraItems.POLYOLEFIN_PLATE.get())
                .save(consumer, "thermal_extra:machine/chiller/polyolefin");

        MachineRecipeBuilder.smelter()
                .input(ThermalExtraTags.Items.DUSTS_SOUL_SAND, 2)
                .input(Tags.Items.INGOTS_IRON)
                .input(Tags.Items.INGOTS_COPPER)
                .output(ThermalExtraItems.SOUL_INFUSED_INGOT.get())
                .save(consumer, modLoc("machine/smelter/soul_infused_ingot"));

        MachineRecipeBuilder.smelter()
                .input(ThermalExtraTags.Items.SOUL_INFUSED_DUST)
                .output(ThermalExtraItems.SOUL_INFUSED_INGOT.get())
                .save(consumer, modLoc("machine/smelter/soul_infused_ingot_from_dust"));

        MachineRecipeBuilder.smelter()
                .input(ItemTagsCoFH.INGOTS_TIN, 2)
                .input(Tags.Items.RODS_BLAZE)
                .input(Tags.Items.OBSIDIAN)
                .output(ThermalExtraItems.TWINITE_INGOT.get())
                .save(consumer, modLoc("machine/smelter/twinite_ingot"));

        MachineRecipeBuilder.smelter()
                .input(ThermalExtraTags.Items.TWINITE_DUST)
                .output(ThermalExtraItems.TWINITE_INGOT.get())
                .save(consumer, modLoc("machine/smelter/twinite_ingot_from_dust"));

        MachineRecipeBuilder.smelter()
                .input(Items.SHULKER_SHELL, 2)
                .input(ItemTagsCoFH.INGOTS_LEAD)
                .input(ItemTagsCoFH.INGOTS_NICKEL)
                .output(ThermalExtraItems.SHELLITE_INGOT.get())
                .save(consumer, modLoc("machine/smelter/shellite_ingot"));

        MachineRecipeBuilder.smelter()
                .input(ThermalExtraTags.Items.SHELLITE_DUST)
                .output(ThermalExtraItems.SHELLITE_INGOT.get())
                .save(consumer, modLoc("machine/smelter/shellite_ingot_from_dust"));

        MachineRecipeBuilder.smelter()
                .input(ThermalExtraItems.ANCIENT_DUST.get(), 2)
                .input(Items.NETHERITE_SCRAP)
                .input(ItemTagsCoFH.INGOTS_NICKEL)
            .output(ThermalExtraItems.DRAGONSTEEL_INGOT.get())
                .save(consumer, modLoc("machine/smelter/dragonsteel_ingot"));

        MachineRecipeBuilder.smelter()
                .input(ThermalExtraTags.Items.DRAGONSTEEL_DUST)
                .output(ThermalExtraItems.DRAGONSTEEL_INGOT.get())
                .save(consumer, modLoc("machine/smelter/dragonsteel_ingot_from_dust"));

        MachineRecipeBuilder.smelter()
                .input(ItemTagsCoFH.DUSTS_DIAMOND, 2)
                .input(Items.NETHERITE_SCRAP)
                .input(Items.ECHO_SHARD)
                .output(ThermalExtraItems.ABYSSAL_INGOT.get())
                .save(consumer, modLoc("machine/smelter/abyssal_ingot"));

        MachineRecipeBuilder.smelter()
                .input(ThermalExtraTags.Items.ABYSSAL_DUST)
                .output(ThermalExtraItems.ABYSSAL_INGOT.get())
                .save(consumer, modLoc("machine/smelter/abyssal_ingot_from_dust"));

        MachineRecipeBuilder.component_assembly()
                .energy(5000)
                .input(new FluidStack(TCoreFluids.REDSTONE_FLUID.get(), 50))
                .input(Tags.Items.INGOTS_IRON)
                .output(ThermalCore.ITEMS.get("redstone_servo"))
                .save(consumer, "thermal_extra:machine/component_assembly/redstone_servo");
        MachineRecipeBuilder.component_assembly()
                .energy(5000)
                .input(new FluidStack(TCoreFluids.ENDER_FLUID.get(), 50))
                .input(ThermalExtraTags.Items.SHELLITE_INGOT)
                .input(ItemTagsCoFH.INGOTS_BRONZE)
                .output(ThermalExtraItems.TWINITE_INGOT.get())
                .save(consumer, "thermal_extra:machine/component_assembly/twinite_ingot");

        TagKey<Item> rawAluminum = forgeTag("raw_materials/aluminum");
        TagKey<Item> rawUranium = forgeTag("raw_materials/uranium");
        TagKey<Item> rawOsmium = forgeTag("raw_materials/osmium");
        TagKey<Item> rawZinc = forgeTag("raw_materials/zinc");
        TagKey<Item> rawArcaneGold = forgeTag("raw_materials/arcane_gold");

        nitraticOre(consumer, "copper", Tags.Items.RAW_MATERIALS_COPPER, ThermalExtraItems.COPPER_ORE_CHUNK, ThermalExtraItems.GOLD_ORE_CHUNK);
        nitraticOre(consumer, "iron", Tags.Items.RAW_MATERIALS_IRON, ThermalExtraItems.IRON_ORE_CHUNK, ThermalExtraItems.NICKEL_ORE_CHUNK);
        nitraticOre(consumer, "gold", Tags.Items.RAW_MATERIALS_GOLD, ThermalExtraItems.GOLD_ORE_CHUNK, ThermalExtraItems.COPPER_ORE_CHUNK);
        nitraticOre(consumer, "tin", ItemTagsCoFH.RAW_MATERIALS_TIN, ThermalExtraItems.TIN_ORE_CHUNK, ITEMS.getSup("apatite"));
        nitraticOre(consumer, "lead", ItemTagsCoFH.RAW_MATERIALS_LEAD, ThermalExtraItems.LEAD_ORE_CHUNK, ThermalExtraItems.SILVER_ORE_CHUNK);
        nitraticOre(consumer, "silver", ItemTagsCoFH.RAW_MATERIALS_SILVER, ThermalExtraItems.SILVER_ORE_CHUNK, ThermalExtraItems.LEAD_ORE_CHUNK);
        nitraticOre(consumer, "nickel", ItemTagsCoFH.RAW_MATERIALS_NICKEL, ThermalExtraItems.NICKEL_ORE_CHUNK, ThermalExtraItems.IRON_ORE_CHUNK);
        nitraticOre(withConditions(consumer).addCondition(new NotCondition(new TagEmptyCondition("forge:raw_materials/aluminum"))), "aluminum", rawAluminum, ThermalExtraItems.ALUMINUM_ORE_CHUNK, ThermalExtraItems.IRON_ORE_CHUNK);
        nitraticOre(withConditions(consumer).addCondition(new NotCondition(new TagEmptyCondition("forge:raw_materials/uranium"))), "uranium", rawUranium, ThermalExtraItems.URANIUM_ORE_CHUNK);
        nitraticOre(withConditions(consumer).addCondition(new NotCondition(new TagEmptyCondition("forge:raw_materials/osmium"))), "osmium", rawOsmium, ThermalExtraItems.OSMIUM_ORE_CHUNK);
        nitraticOre(withConditions(consumer).addCondition(new NotCondition(new TagEmptyCondition("forge:raw_materials/arcane_gold"))), "arcane_gold", rawArcaneGold, ThermalExtraItems.ARCANE_GOLD_ORE_CHUNK);
        nitraticOre(withConditions(consumer).addCondition(new NotCondition(new TagEmptyCondition("forge:raw_materials/zinc"))), "zinc", rawZinc, ThermalExtraItems.ZINC_ORE_CHUNK);

        MachineRecipeBuilder.advanced_refinery()
                .input(new FluidStack(ThermalExtraFluids.CRYSTALLIZED_SUNFLOWER_OIL.still().get(), 200))
                .output(new MachineRecipeBuilder.ChanceItemStack(new ItemStack(ITEMS.get("compost")), 0.1f, false))
                .output(new FluidStack(ThermalExtraFluids.REFINED_SUNFLOWER_OIL.still().get(), 100))
                .save(consumer, "thermal_extra:machine/advanced_refinery/refined_sunflower_oil");

        MachineRecipeBuilder.refinery()
                .input(new FluidStack(ThermalExtraFluids.FLUX_INFUSED_OIL.still().get(), 100))
                .output(new MachineRecipeBuilder.ChanceItemStack(new ItemStack(ITEMS.get("bitumen")), 0.1f, false))
                .output(new FluidStack(TCoreFluids.HEAVY_OIL_FLUID.get(), 100))
                .output(new FluidStack(TCoreFluids.LIGHT_OIL_FLUID.get(), 100))
                .save(consumer, "thermal_extra:machine/refinery/flux_infused_oil");

        MachineRecipeBuilder.advanced_refinery()
                .input(new FluidStack(ThermalExtraFluids.FLUX_INFUSED_OIL.still().get(), 100))
                .output(new MachineRecipeBuilder.ChanceItemStack(new ItemStack(ITEMS.get("bitumen")), 0.15f, false))
                .output(new FluidStack(TCoreFluids.HEAVY_OIL_FLUID.get(), 150))
                .output(new FluidStack(TCoreFluids.LIGHT_OIL_FLUID.get(), 150))
                .save(consumer, "thermal_extra:machine/advanced_refinery/flux_infused_oil");

        MachineRecipeBuilder.advanced_refinery()
                .input(new FluidStack(TCoreFluids.HEAVY_OIL_FLUID.get(), 100))
                .output(new MachineRecipeBuilder.ChanceItemStack(new ItemStack(ITEMS.get("tar")), 0.15f, false))
                .output(new FluidStack(ThermalExtraFluids.DIESEL.still().get(), 80))
                .save(consumer, "thermal_extra:machine/advanced_refinery/heavy_oil");

        MachineRecipeBuilder.advanced_refinery()
                .input(new FluidStack(TCoreFluids.LIGHT_OIL_FLUID.get(), 100))
                .output(new MachineRecipeBuilder.ChanceItemStack(new ItemStack(ITEMS.get("sulfur_dust")), 0.25f, false))
                .output(new FluidStack(ThermalExtraFluids.DIESEL.still().get(), 80))
                .save(consumer, "thermal_extra:machine/advanced_refinery/light_oil");

        MachineRecipeBuilder.fluid_mixer()
                .energy(10000)
                .input(TCoreFluids.REDSTONE_FLUID.get(), 100)
                .input(TCoreFluids.CRUDE_OIL_FLUID.get(), 100)
                .output(new FluidStack(ThermalExtraFluids.FLUX_INFUSED_OIL.still().get(), 100))
                .save(consumer, "thermal_extra:machine/fluid_mixer/flux_infused_oil");

        MachineRecipeBuilder.fluid_mixer()
                .input(FluidIngredient.of(ThermalTags.Fluids.LATEX, 1000))
                .input(TCoreFluids.GLOWSTONE_FLUID.get(), 1000)
                .energy(15000)
                .output(ThermalExtraFluids.POLYOLEFIN.still().get(), 1000)
                .save(consumer, "thermal_extra:machine/fluid_mixer/polyolefin");

        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_ALUMINUM, 120, rawAluminum, "raw_aluminum");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_ARCANE_GOLD, 120, rawArcaneGold, "raw_arcane_gold");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_COPPER, 120, Tags.Items.RAW_MATERIALS_COPPER, "raw_copper");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_GOLD, 120, Tags.Items.RAW_MATERIALS_GOLD, "raw_gold");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_IRON, 120, Tags.Items.RAW_MATERIALS_IRON, "raw_iron");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_LEAD, 120, ItemTagsCoFH.RAW_MATERIALS_LEAD, "raw_lead");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_NICKEL, 120, ItemTagsCoFH.RAW_MATERIALS_NICKEL, "raw_nickel");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_OSMIUM, 120, rawOsmium, "raw_osmium");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_SILVER, 120, ItemTagsCoFH.RAW_MATERIALS_SILVER, "raw_silver");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_TIN, 120, ItemTagsCoFH.RAW_MATERIALS_TIN, "raw_tin");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_URANIUM, 120, rawUranium, "raw_uranium");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_ZINC, 120, rawZinc, "raw_zinc");

        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_ALUMINUM, 90, ThermalExtraItems.ALUMINUM_ORE_CHUNK.get(), "raw_aluminum_from_chunk");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_ARCANE_GOLD, 90, ThermalExtraItems.ARCANE_GOLD_ORE_CHUNK.get(), "raw_arcane_gold_from_chunk");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_COPPER, 90, ThermalExtraItems.COPPER_ORE_CHUNK.get(), "raw_copper_from_chunk");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_GOLD, 90, ThermalExtraItems.GOLD_ORE_CHUNK.get(), "raw_gold_from_chunk");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_IRON, 90, ThermalExtraItems.IRON_ORE_CHUNK.get(), "raw_iron_from_chunk");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_LEAD, 90, ThermalExtraItems.LEAD_ORE_CHUNK.get(), "raw_lead_from_chunk");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_NICKEL, 90, ThermalExtraItems.NICKEL_ORE_CHUNK.get(), "raw_nickel_from_chunk");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_OSMIUM, 90, ThermalExtraItems.OSMIUM_ORE_CHUNK.get(), "raw_osmium_from_chunk");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_SILVER, 90, ThermalExtraItems.SILVER_ORE_CHUNK.get(), "raw_silver_from_chunk");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_TIN, 90, ThermalExtraItems.TIN_ORE_CHUNK.get(), "raw_tin_from_chunk");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_URANIUM, 90, ThermalExtraItems.URANIUM_ORE_CHUNK.get(), "raw_uranium_from_chunk");
        crucibleRecipe(consumer, 8000, ThermalExtraFluids.RAW_ZINC, 90, ThermalExtraItems.ZINC_ORE_CHUNK.get(), "raw_zinc_from_chunk");

        DynamoRecipeBuilder.cold().ingredient(Items.SNOWBALL).energy(1000).build(consumer, "thermal_extra:fuels/cold/snowball");
        DynamoRecipeBuilder.cold().ingredient(Items.SNOW).energy(1000).build(consumer, "thermal_extra:fuels/cold/snow");
        DynamoRecipeBuilder.cold().ingredient(Items.SNOW_BLOCK).energy(5000).build(consumer, "thermal_extra:fuels/cold/snow_block");
        DynamoRecipeBuilder.cold().ingredient(Items.ICE).energy(5000).build(consumer, "thermal_extra:fuels/cold/ice");
        DynamoRecipeBuilder.cold().ingredient(Items.PACKED_ICE).energy(45000).build(consumer, "thermal_extra:fuels/cold/packed_ice");
        DynamoRecipeBuilder.cold().ingredient(Items.BLUE_ICE).energy(45000).build(consumer, "thermal_extra:fuels/cold/blue_ice");
        DynamoRecipeBuilder.cold().ingredient(Items.POWDER_SNOW_BUCKET).energy(80000).build(consumer, "thermal_extra:fuels/cold/powder_snow_bucket");
        DynamoRecipeBuilder.cold().ingredient(ITEMS.get("blizz_rod")).energy(120000).build(consumer, "thermal_extra:fuels/cold/blizz_cube");
        DynamoRecipeBuilder.cold().ingredient(ITEMS.get("blizz_powder")).energy(120000).build(consumer, "thermal_extra:fuels/cold/blizz_powder");

        DynamoRecipeBuilder.numismatic()
                .ingredient(ThermalExtraTags.Items.SOUL_INFUSED_COIN)
                .energy(50000)
                .build(consumer, "thermal_extra:fuels/numismatic/soul_infused_coin");
        DynamoRecipeBuilder.numismatic()
                .ingredient(ThermalExtraTags.Items.TWINITE_COIN)
                .energy(60000)
                .build(consumer, "thermal_extra:fuels/numismatic/twinite_coin");
        DynamoRecipeBuilder.numismatic()
                .ingredient(ThermalExtraTags.Items.SHELLITE_COIN)
                .energy(100000)
                .build(consumer, "thermal_extra:fuels/numismatic/shellite_coin");
        DynamoRecipeBuilder.numismatic()
                .ingredient(ThermalExtraTags.Items.DRAGONSTEEL_COIN)
                .energy(100000)
                .build(consumer, "thermal_extra:fuels/numismatic/dragonsteel_coin");
        DynamoRecipeBuilder.numismatic()
                .ingredient(ThermalExtraTags.Items.ABYSSAL_COIN)
                .energy(150000)
                .build(consumer, "thermal_extra:fuels/numismatic/abyssal_coin");

        DynamoRecipeBuilder.compression()
                .fluid(new FluidStack(ThermalExtraFluids.CRYSTALLIZED_SUNFLOWER_OIL.still().get(), 1000))
                .energy(100000)
                .buildFluid(consumer, "thermal_extra:fuels/compression/crystallized_sunflower_oil");

        DynamoRecipeBuilder.compression()
                .fluid(new FluidStack(ThermalExtraFluids.SUNFLOWER_OIL.still().get(), 1000))
                .energy(30000)
                .buildFluid(consumer, "thermal_extra:fuels/compression/sunflower_oil");

        DynamoRecipeBuilder.compression()
                .fluid(new FluidStack(ThermalExtraFluids.REFINED_SUNFLOWER_OIL.still().get(), 1000))
                .energy(1000000)
                .buildFluid(consumer, "thermal_extra:fuels/compression/refined_sunflower_oil");

        DynamoRecipeBuilder.compression()
                .fluid(new FluidStack(ThermalExtraFluids.DIESEL.still().get(), 1000))
                .energy(2000000)
                .buildFluid(consumer, "thermal_extra:fuels/compression/diesel");

    }

    public void generateAugmentRecipes(@NotNull Consumer<FinishedRecipe> consumer) {

        for(EnumAugment e: EnumAugment.values()) {
            for (ExtraAugmentType type : ExtraAugmentType.VALUES) {
                augmentSmithing(consumer, getAugmentItem(e, type), RecipeCategory.MISC, ThermalExtraItems.AUGMENTS.get(e).get(type).get(), ThermalExtraItems.ITEMS.get(type.name().toLowerCase(Locale.ROOT)+"_gear"));
            }
        }

        augmentSmithing(consumer, ITEMS.get("item_filter_augment"), RecipeCategory.MISC, ThermalExtraItems.AV_ITEM_FILTER_AUGMENT.get(), ThermalExtraItems.SHELLITE_GEAR.get());

        Item part = ThermalCore.ITEMS.get("upgrade_augment_3");

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ThermalExtraItems.INTEGRAL_COMPONENT.get())
                .define('G', ThermalExtraTags.Items.DRAGONSTEEL_GEAR)
                .define('I', ThermalExtraItems.ANCIENT_DUST.get())
                .define('X', part)
                .pattern("IGI")
                .pattern("GXG")
                .pattern("IGI")
                .unlockedBy("has_upgrade_augment_3", has(part))
                .save(withConditions(consumer).flag(FLAG_UPGRADE_AUGMENTS), modLoc("crafting/dragonsteel_integral_component"));

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ThermalExtraItems.ABYSSAL_INTEGRAL_COMPONENT.get())
                .define('G', ThermalExtraTags.Items.ABYSSAL_GEAR)
                .define('I', ThermalExtraItems.ANCIENT_DUST.get())
                .define('X', ThermalExtraItems.INTEGRAL_COMPONENT.get())
                .pattern("IGI")
                .pattern("GXG")
                .pattern("IGI")
                .unlockedBy("has_dragonsteel_upgrade_augment", has(ThermalExtraItems.INTEGRAL_COMPONENT.get()))
                .save(withConditions(consumer).flag(FLAG_UPGRADE_AUGMENTS), modLoc("crafting/abyssal_integral_component"));
    }

    public void nitraticOre(Consumer<FinishedRecipe> consumer, String oreName, TagKey<Item> tagKey, Supplier<Item> mainOreChunk, Supplier<Item> secondaryOreChunk) {
        MachineRecipeBuilder.nitratic_igniter()
                .energy(12000)
                .input(Ingredient.of(tagKey))
                .output(new MachineRecipeBuilder.ChanceItemStack(new ItemStack(mainOreChunk.get(), 3), 1.25f, true))
                .output(new MachineRecipeBuilder.ChanceItemStack(new ItemStack(mainOreChunk.get(), 1), 0.55f, false))
                .output(new MachineRecipeBuilder.ChanceItemStack(new ItemStack(secondaryOreChunk.get(), 1), 0.25f, false))
                .exp(1.1f)
                .save(consumer, "thermal_extra:machine/nitratic_igniter/raw_" + oreName);
    }

    public void nitraticOre(Consumer<FinishedRecipe> consumer, String oreName, TagKey<Item> tagKey, Supplier<Item> mainOreChunk) {
        MachineRecipeBuilder.nitratic_igniter()
                .energy(12000)
                .input(Ingredient.of(tagKey))
                .output(new MachineRecipeBuilder.ChanceItemStack(new ItemStack(mainOreChunk.get(), 3), 1.25f, true))
                .output(new MachineRecipeBuilder.ChanceItemStack(new ItemStack(mainOreChunk.get(), 1), 0.65f, false))
                .exp(1.1f)
                .save(consumer, "thermal_extra:machine/nitratic_igniter/raw_" + oreName);
    }

    public ConditionalRecipeConsumer tagExists(Consumer<FinishedRecipe> consumer, TagKey<Item> tag) {
        return withConditions(consumer).tagExists(tag);
    }

    private Item getAugmentItem(EnumAugment e, ExtraAugmentType type) {

        String name = e.name().toLowerCase(Locale.ROOT);
        switch (type) {
            case ABYSSAL -> {
                return ThermalExtraItems.AUGMENTS.get(e).get(ExtraAugmentType.DRAGONSTEEL).get();
            }
            case DRAGONSTEEL -> {
                return ThermalExtraItems.AUGMENTS.get(e).get(ExtraAugmentType.SHELLITE).get();
            }
            case SHELLITE -> {
                return ThermalExtraItems.AUGMENTS.get(e).get(ExtraAugmentType.TWINITE).get();
            }
            case TWINITE -> {
                return ThermalExtraItems.AUGMENTS.get(e).get(ExtraAugmentType.SOUL_INFUSED).get();
            }
            default -> {
                return ITEMS.get(name);
            }
        }
    }

    protected static void augmentSmithing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem, Item ingot) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ThermalExtraItems.AUGMENT_TEMPLATE.get()), Ingredient.of(pIngredientItem), Ingredient.of(ingot), pCategory, pResultItem).unlocks(getHasName(ingot), has(Items.NETHERITE_INGOT)).save(pFinishedRecipeConsumer, "thermal_extra:crafting/augment/"+getItemName(pResultItem) + "_smithing");
    }
    
    public void crucibleRecipe(Consumer<FinishedRecipe> consumer, int energy, FluidThermalExtra fluid, int amount, Ingredient input, String name) {
        MachineRecipeBuilder.crucible()
                .input(input)
                .output(fluid.getStillFluid().get(), amount)
                .energy(energy)
                .save(consumer, modLoc("machine/crucible/"+name));
    }

    public void crucibleRecipe(Consumer<FinishedRecipe> consumer, int energy, FluidThermalExtra fluid, int amount, TagKey<Item> input, String name) {
        this.crucibleRecipe(tagExists(consumer, input), energy, fluid, amount, Ingredient.of(input), name);
    }

    public void crucibleRecipe(Consumer<FinishedRecipe> consumer, int energy, FluidThermalExtra fluid, int amount, Item input, String name) {
        this.crucibleRecipe(consumer, energy, fluid, amount, Ingredient.of(input), name);
    }

    @Override
    protected void generateGearRecipe(DeferredRegisterCoFH<Item> reg, Consumer<FinishedRecipe> consumer, String type) {

        Item gear = reg.get(type + "_gear");
        if (gear == null) {
            return;
        }
        Item ingot = reg.get(type + "_ingot");
        Item gem = reg.get(type);

        TagKey<Item> ingotTag = forgeTag("ingots/" + type);
        TagKey<Item> gemTag = forgeTag("gems/" + type);

        if (ingot != null) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, gear)
                    .define('#', ingotTag)
                    .define('i', Tags.Items.NUGGETS_IRON)
                    .pattern(" # ")
                    .pattern("#i#")
                    .pattern(" # ")
                    .unlockedBy("has_" + name(ingot), has(ingotTag))
                    .save(consumer, this.modid + ":parts/" + name(gear));

            MachineRecipeBuilder.press()
                    .input(new IngredientWithCount(Ingredient.of(ingotTag), 4))
                    .input(Ingredient.of(ITEMS.get("press_gear_die")))
                    .output(gear)
                    .save(consumer, "thermal_extra:machine/press/"+type+"_gear");
        }
        if (gem != null) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, gear)
                    .define('#', gemTag)
                    .define('i', Tags.Items.NUGGETS_IRON)
                    .pattern(" # ")
                    .pattern("#i#")
                    .pattern(" # ")
                    .unlockedBy("has_" + name(gem), has(gemTag))
                    .save(consumer, this.modid + ":parts/" + name(gear));

            MachineRecipeBuilder.press()
                    .input(new IngredientWithCount(Ingredient.of(gemTag), 4))
                    .input(Ingredient.of(ITEMS.get("press_gear_die")))
                    .output(gear)
                    .save(consumer, "thermal_extra:machine/press/"+type+"_gear");
        }
    }

    private void rodRecipe(String recipeName, String itemName, TagKey<Item> ingot, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, ThermalExtraItems.ITEMS.get(itemName+"_rod"), 2)
                .pattern("I")
                .pattern("I")
                .define('I', ingot)
                .unlockedBy("has_"+itemName+"_ingot", has(ingot))
                .save(consumer, modLoc(recipeName));
    }

    @SafeVarargs
    private Map<String, TagKey<Item>> of(String[] keys, TagKey<Item>... values) {
        Map<String, TagKey<Item>> map = new HashMap<>();

        for(int i = 0; i<values.length; i++) {
            map.put(keys[i], values[i]);
        }

        return map;
    }

    private void generateFullToolSet(String prefix, String itemName, TagKey<Item> ingotTag, TagKey<Item> rodTag, TagKey<Item> storage, Consumer<FinishedRecipe> consumer) {

        generateArmorSet(prefix, itemName, ingotTag, consumer);
        generateStandardToolSet(prefix, itemName, ingotTag, rodTag, consumer);
        generateExtraToolSet(prefix, itemName, ingotTag, rodTag, storage, consumer);
    }

    private void generateStandardToolSet(String prefix, String itemName, TagKey<Item> ingotTag, TagKey<Item> rodTag, Consumer<FinishedRecipe> consumer) {

        var reg = ThermalExtraItems.ITEMS;

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, reg.get(prefix + "_shovel"))
                .define('#', rodTag)
                .define('X', ingotTag)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_" + itemName, has(ingotTag))
                .save(withConditions(consumer)
                        // .addCondition(new FlagRecipeCondition(manager, prefix + "_tools"))
                        .addCondition(new TagExistsRecipeCondition(ingotTag.location()))
                );

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, reg.get(prefix + "_pickaxe"))
                .define('#', rodTag)
                .define('X', ingotTag)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_" + itemName, has(ingotTag))
                .save(withConditions(consumer)
                        // .addCondition(new FlagRecipeCondition(manager, prefix + "_tools"))
                        .addCondition(new TagExistsRecipeCondition(ingotTag.location()))
                );

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, reg.get(prefix + "_axe"))
                .define('#', rodTag)
                .define('X', ingotTag)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("has_" + itemName, has(ingotTag))
                .save(withConditions(consumer)
                        // .addCondition(new FlagRecipeCondition(manager, prefix + "_tools"))
                        .addCondition(new TagExistsRecipeCondition(ingotTag.location()))
                );

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, reg.get(prefix + "_hoe"))
                .define('#', rodTag)
                .define('X', ingotTag)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .unlockedBy("has_" + itemName, has(ingotTag))
                .save(withConditions(consumer)
                        // .addCondition(new FlagRecipeCondition(manager, prefix + "_tools"))
                        .addCondition(new TagExistsRecipeCondition(ingotTag.location()))
                );

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, reg.get(prefix + "_sword"))
                .define('#', rodTag)
                .define('X', ingotTag)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_" + itemName, has(ingotTag))
                .save(withConditions(consumer)
                        // .addCondition(new FlagRecipeCondition(manager, prefix + "_tools"))
                        .addCondition(new TagExistsRecipeCondition(ingotTag.location()))
                );
    }

    private void generateExtraToolSet(String prefix, String itemName, TagKey<Item> ingotTag, TagKey<Item> rodTag, TagKey<Item> storage, Consumer<FinishedRecipe> consumer) {

        var reg = ThermalExtraItems.ITEMS;

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, reg.get(prefix + "_excavator"))
                .define('#', rodTag)
                .define('X', ingotTag)
                .define('Y', storage)
                .pattern(" Y ")
                .pattern("X#X")
                .pattern(" # ")
                .unlockedBy("has_" + itemName, has(ingotTag))
                .save(withConditions(consumer)
                        // .addCondition(new FlagRecipeCondition(manager, prefix + "_tools"))
                        .addCondition(new TagExistsRecipeCondition(ingotTag.location()))
                );

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, reg.get(prefix + "_hammer"))
                .define('#', rodTag)
                .define('X', ingotTag)
                .define('Y', storage)
                .pattern("XYX")
                .pattern("X#X")
                .pattern(" # ")
                .unlockedBy("has_" + itemName, has(ingotTag))
                .save(withConditions(consumer)
                        // .addCondition(new FlagRecipeCondition(manager, prefix + "_tools"))
                        .addCondition(new TagExistsRecipeCondition(ingotTag.location()))
                );

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, reg.get(prefix + "_sickle"))
                .define('#', rodTag)
                .define('X', ingotTag)
                .pattern(" X ")
                .pattern("  X")
                .pattern("#X ")
                .unlockedBy("has_" + itemName, has(ingotTag))
                .save(withConditions(consumer)
                        // .addCondition(new FlagRecipeCondition(manager, prefix + "_tools"))
                        .addCondition(new TagExistsRecipeCondition(ingotTag.location()))
                );

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, reg.get(prefix + "_knife"))
                .define('#', rodTag)
                .define('X', ingotTag)
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_" + itemName, has(ingotTag))
                .save(withConditions(consumer)
                        // .addCondition(new FlagRecipeCondition(manager, prefix + "_tools"))
                        .addCondition(new TagExistsRecipeCondition(ingotTag.location()))
                );
    }

    private void generateArmorSet(String prefix, String itemName, TagKey<Item> tag, Consumer<FinishedRecipe> consumer) {

        var reg = ThermalExtraItems.ITEMS;

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, reg.get(prefix + "_helmet"))
                .define('X', tag)
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy("has_" + itemName, has(tag))
                .save(withConditions(consumer)
                        // .addCondition(new FlagRecipeCondition(manager, prefix + "_armor"))
                        .addCondition(new TagExistsRecipeCondition(tag.location()))
                );

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, reg.get(prefix + "_chestplate"))
                .define('X', tag)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy("has_" + itemName, has(tag))
                .save(withConditions(consumer)
                        // .addCondition(new FlagRecipeCondition(manager, prefix + "_armor"))
                        .addCondition(new TagExistsRecipeCondition(tag.location()))
                );

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, reg.get(prefix + "_leggings"))
                .define('X', tag)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("has_" + itemName, has(tag))
                .save(withConditions(consumer)
                        // .addCondition(new FlagRecipeCondition(manager, prefix + "_armor"))
                        .addCondition(new TagExistsRecipeCondition(tag.location()))
                );

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, reg.get(prefix + "_boots"))
                .define('X', tag)
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("has_" + itemName, has(tag))
                .save(withConditions(consumer)
                        // .addCondition(new FlagRecipeCondition(manager, prefix + "_armor"))
                        .addCondition(new TagExistsRecipeCondition(tag.location()))
                );
    }

    private ResourceLocation loc(String name) {
        return new ResourceLocation(this.modLoc(name));
    }

    private String modLoc(String name) {
        return ThermalExtra.MOD_ID+":"+name;
    }
}
