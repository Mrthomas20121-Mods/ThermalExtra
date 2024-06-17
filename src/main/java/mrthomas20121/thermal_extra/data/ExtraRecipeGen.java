package mrthomas20121.thermal_extra.data;

import cofh.lib.common.fluid.FluidIngredient;
import cofh.lib.init.data.RecipeProviderCoFH;
import cofh.lib.init.tags.ItemTagsCoFH;
import cofh.lib.util.DeferredRegisterCoFH;
import cofh.lib.util.crafting.IngredientWithCount;
import cofh.thermal.core.ThermalCore;
import cofh.thermal.core.init.registries.TCoreFluids;
import cofh.thermal.lib.util.ThermalIDs;
import cofh.thermal.lib.util.references.ThermalTags;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.data.thermal_recipe.ThermalBuilder;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import mrthomas20121.thermal_extra.init.ThermalExtraTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
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

import javax.annotation.Nonnull;
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PAPER, 2)
                .requires(ThermalExtraItems.sticky_ball.get())
                .requires(ThermalExtraItems.sticky_ball.get())
                .requires(ThermalExtraItems.sticky_ball.get())
                .unlockedBy("has_sticky_ball", has(ThermalExtraItems.sticky_ball.get()))
                .save(consumer, new ResourceLocation("thermal_extra:sticky_ball_to_paper"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ThermalExtraItems.soul_infused_dust.get(), 2)
                .requires(ThermalExtraTags.Items.SOUL_SAND_DUST)
                .requires(ThermalExtraTags.Items.SOUL_SAND_DUST)
                .requires(ThermalExtraTags.Items.SOUL_SAND_DUST)
                .requires(ItemTagsCoFH.DUSTS_APATITE)
                .requires(ItemTagsCoFH.DUSTS_INVAR)
                .requires(ItemTagsCoFH.DUSTS_INVAR)
                .unlockedBy("has_apatite_dust", has(ItemTagsCoFH.DUSTS_APATITE))
                .unlockedBy("has_invar_dust", has(ItemTagsCoFH.DUSTS_INVAR))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ThermalExtraItems.shellite_dust.get(), 2)
                .requires(Items.SHULKER_SHELL)
                .requires(Items.SHULKER_SHELL)
                .requires(Items.SHULKER_SHELL)
                .requires(ItemTagsCoFH.DUSTS_APATITE)
                .requires(ItemTagsCoFH.DUSTS_BRONZE)
                .requires(ItemTagsCoFH.DUSTS_BRONZE)
                .unlockedBy("has_apatite_dust", has(ItemTagsCoFH.DUSTS_APATITE))
                .unlockedBy("has_bronze_dust", has(ItemTagsCoFH.DUSTS_BRONZE))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ThermalExtraItems.twinite_dust.get(), 2)
                .requires(ThermalExtraTags.Items.DUSTS_AMETHYST)
                .requires(ThermalExtraTags.Items.DUSTS_AMETHYST)
                .requires(ThermalExtraTags.Items.DUSTS_AMETHYST)
                .requires(ItemTagsCoFH.DUSTS_APATITE)
                .requires(ItemTagsCoFH.DUSTS_ENDERIUM)
                .requires(ItemTagsCoFH.DUSTS_ENDERIUM)
                .unlockedBy("has_apatite_dust", has(ItemTagsCoFH.DUSTS_APATITE))
                .unlockedBy("has_bronze_dust", has(ItemTagsCoFH.DUSTS_BRONZE))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ThermalExtraItems.dragon_steel_dust.get(), 2)
                .requires(Items.DRAGON_BREATH)
                .requires(Items.DRAGON_BREATH)
                .requires(Items.DRAGON_BREATH)
                .requires(ItemTagsCoFH.DUSTS_APATITE)
                .requires(ItemTagsCoFH.DUSTS_APATITE)
                .requires(ItemTagsCoFH.DUSTS_NETHERITE)
                .unlockedBy("has_netherite_dust", has(ItemTagsCoFH.DUSTS_NETHERITE))
                .unlockedBy("has_apatite_dust", has(ItemTagsCoFH.DUSTS_APATITE))
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

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ThermalExtraItems.chiller_plate_cast.get())
                .define('P', ItemTagsCoFH.PLATES_BRONZE)
                .pattern(" P ")
                .pattern("PPP")
                .pattern(" P ")
                .unlockedBy("has_bronze_plate", has(ItemTagsCoFH.PLATES_BRONZE))
                .save(consumer, this.modid + ":crafting/chiller_plate_cast");

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
                .define('F', ITEMS.get(ThermalIDs.ID_FLUID_CELL_FRAME))
                .pattern(" I ")
                .pattern("FMF")
                .pattern("GIG")
                .unlockedBy("has_machine_frame", has(ThermalCore.ITEMS.get(ThermalIDs.ID_MACHINE_FRAME)))
                .save(consumer, this.modid + ":crafting/fluid_fixer");

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ThermalExtraBlocks.ADVANCED_REFINERY.get())
                .define('G', ItemTagsCoFH.GEARS_ENDERIUM)
                .define('I', ThermalExtraTags.Items.SOUL_INFUSED_INGOT)
                .define('M', ITEMS.get(ThermalIDs.ID_MACHINE_REFINERY))
                .define('F', ITEMS.get(ThermalIDs.ID_FLUID_CELL_FRAME))
                .pattern(" I ")
                .pattern("GMG")
                .pattern("FFF")
                .unlockedBy("has_"+ThermalIDs.ID_MACHINE_REFINERY, has(ThermalCore.ITEMS.get(ThermalIDs.ID_MACHINE_REFINERY)))
                .save(consumer, this.modid + ":crafting/advanced_refinery");

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ThermalExtraBlocks.COMPONENT_ASSEMBLY.get())
                .define('G', ItemTagsCoFH.GEARS_CONSTANTAN)
                .define('I', ThermalExtraTags.Items.DRAGONSTEEL_INGOT)
                .define('M', ITEMS.get(ThermalIDs.ID_MACHINE_FRAME))
                .define('F', ITEMS.get(ThermalIDs.ID_FLUID_CELL_FRAME))
                .pattern(" I ")
                .pattern("FMF")
                .pattern("GIG")
                .unlockedBy("has_machine_frame", has(ThermalCore.ITEMS.get(ThermalIDs.ID_MACHINE_FRAME)))
                .save(consumer, this.modid + ":crafting/component_assembly");

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ThermalExtraBlocks.LAVA_GEN.get())
                .define('N', Tags.Items.INGOTS_IRON)
                .define('R', ThermalCore.ITEMS.get("redstone_servo"))
                .define('I', ThermalExtraTags.Items.SOUL_INFUSED_INGOT)
                .define('M', Items.BUCKET)
                .define('G', Blocks.WARPED_WART_BLOCK)
                .pattern("INI")
                .pattern("GMG")
                .pattern("IRI")
                .unlockedBy("has_redstone_servo", has(ThermalCore.ITEMS.get("redstone_servo")))
                .save(consumer, this.modid + ":crafting/device_lava_gen");

        this.generateTypeRecipes(ThermalExtraItems.ITEMS, consumer, "soul_infused");
        this.generateTypeRecipes(ThermalExtraItems.ITEMS, consumer, "shellite");
        this.generateTypeRecipes(ThermalExtraItems.ITEMS, consumer, "twinite");
        this.generateTypeRecipes(ThermalExtraItems.ITEMS, consumer, "dragonsteel");

        this.generateSmeltingAndBlastingRecipes(ThermalExtraItems.ITEMS, consumer, "soul_infused", 1f);
        this.generateSmeltingAndBlastingRecipes(ThermalExtraItems.ITEMS, consumer, "shellite", 1f);
        this.generateSmeltingAndBlastingRecipes(ThermalExtraItems.ITEMS, consumer, "twinite", 1f);
        this.generateSmeltingAndBlastingRecipes(ThermalExtraItems.ITEMS, consumer, "dragonsteel", 1f);

        generateAugmentRecipes(consumer);

        generateMachineRecipes(consumer);
    }

    public void generateMachineRecipes(@NotNull Consumer<FinishedRecipe> consumer) {

        ThermalBuilder.drying_tank()
                .input(new FluidStack(Fluids.LAVA, 1000))
                .output(ThermalBuilder.ChanceItemStack.of(new ItemStack(Items.BLAZE_POWDER), 0.25f))
                .output(ThermalBuilder.ChanceItemStack.of(new ItemStack(Items.FLINT), 0.25f))
                .output(ThermalBuilder.ChanceItemStack.of(new ItemStack(Items.MAGMA_CREAM), 0.1f))
                .save(consumer, modLoc("machine/drying_tank/lava"));

        ThermalBuilder.nitratic_igniter_catalyst()
                .ingredient(Blocks.TNT.asItem())
                .primaryMod(1.01f)
                .secondaryMod(1.01f)
                .energyMod(1.1f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/tnt"));

        ThermalBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_NUKE_TNT).asItem())
                .primaryMod(5f)
                .secondaryMod(5f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/nuke_tnt"));

        ThermalBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_EARTH_TNT).asItem())
                .primaryMod(2f)
                .secondaryMod(3f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/earth_tnt"));

        ThermalBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_ENDER_TNT).asItem())
                .primaryMod(3f)
                .secondaryMod(2f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/ender_tnt"));

        ThermalBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_FIRE_TNT).asItem())
                .primaryMod(3f)
                .secondaryMod(3f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/fire_tnt"));

        ThermalBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_GLOWSTONE_TNT).asItem())
                .primaryMod(1.1f)
                .secondaryMod(5f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/glowstone_tnt"));

        ThermalBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_ICE_TNT).asItem())
                .primaryMod(1.9f)
                .secondaryMod(0.1f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/ice_tnt"));

        ThermalBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_LIGHTNING_TNT).asItem())
                .primaryMod(4f)
                .secondaryMod(0.1f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/lightning_tnt"));

        ThermalBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_PHYTO_TNT).asItem())
                .primaryMod(2.5f)
                .secondaryMod(2.5f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/phyto_tnt"));

        ThermalBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_REDSTONE_TNT).asItem())
                .primaryMod(2.5f)
                .secondaryMod(2.5f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/redstone_tnt"));

        ThermalBuilder.nitratic_igniter_catalyst()
                .ingredient(BLOCKS.get(ThermalIDs.ID_SLIME_TNT).asItem())
                .primaryMod(3.1f)
                .secondaryMod(2.1f)
                .energyMod(1.5f)
                .useChanceMod(1f)
                .save(consumer, new ResourceLocation("thermal_extra:machine/nitratic_igniter/catalyst/slime_tnt"));

        ThermalBuilder.blastChiller()
                .energy(30000)
                .input(FluidIngredient.of(new FluidStack(ThermalExtraFluids.polyolefin.still().get(), 1000)))
                .input(ThermalExtraItems.chiller_plate_cast.get())
                .output(ThermalExtraItems.polyolefin_plate.get())
                .save(consumer, "thermal_extra:machine/chiller/polyolefin");

        ThermalBuilder.component_assembly()
                .energy(5000)
                .input(new FluidStack(TCoreFluids.REDSTONE_FLUID.get(), 50))
                .input(Tags.Items.INGOTS_IRON)
                .output(ThermalCore.ITEMS.get("redstone_servo"))
                .save(consumer, "thermal_extra:machine/component_assembly/redstone_servo");
        ThermalBuilder.component_assembly()
                .energy(5000)
                .input(new FluidStack(TCoreFluids.ENDER_FLUID.get(), 50))
                .input(ThermalExtraTags.Items.SHELLITE_INGOT)
                .input(ItemTagsCoFH.INGOTS_BRONZE)
                .output(ThermalExtraItems.twinite_ingot.get())
                .save(consumer, "thermal_extra:machine/component_assembly/twinite_ingot");

        ThermalBuilder.metal_infuser()
                .energy(15000)
                .input(FluidIngredient.of(new FluidStack(TCoreFluids.ENDER_FLUID.get(), 1000)))
                .input(Items.NETHERITE_INGOT)
                .output(ThermalExtraItems.dragon_steel_ingot.get())
                .save(consumer, "thermal_extra:machine/metal_infuser/dragon_steel");

        ThermalBuilder.nitratic_igniter()
                .energy(10000)
                .input(Ingredient.of(new ItemStack(Items.SHULKER_SHELL, 2)))
                .input(Ingredient.of(ItemTagsCoFH.INGOTS_ENDERIUM))
                .output(ThermalExtraItems.shellite_ingot.get())
                .chance()
                .save(consumer, "thermal_extra:machine/nitratic_igniter/shellite_ingot");

        ThermalBuilder.nitratic_igniter()
                .energy(10000)
                .input(Ingredient.of(ThermalExtraTags.Items.SHELLITE_DUST))
                .input(Ingredient.of(ItemTagsCoFH.DUSTS_NETHERITE))
                .output(ThermalExtraItems.twinite_dust.get())
                .chance()
                .save(consumer, "thermal_extra:machine/nitratic_igniter/twinite_dust");

        TagKey<Item> rawAluminum = forgeTag("raw_materials/aluminum");
        TagKey<Item> rawUranium = forgeTag("raw_materials/uranium");
        TagKey<Item> rawOsmium = forgeTag("raw_materials/osmium");
        TagKey<Item> rawZinc = forgeTag("raw_materials/zinc");
        TagKey<Item> rawArcaneGold = forgeTag("raw_materials/arcane_gold");

        nitraticOre(consumer, "copper", Tags.Items.RAW_MATERIALS_COPPER, ThermalExtraItems.copper_ore_chunk, ThermalExtraItems.gold_ore_chunk);
        nitraticOre(consumer, "iron", Tags.Items.RAW_MATERIALS_IRON, ThermalExtraItems.iron_ore_chunk, ThermalExtraItems.nickel_ore_chunk);
        nitraticOre(consumer, "gold", Tags.Items.RAW_MATERIALS_GOLD, ThermalExtraItems.gold_ore_chunk, ThermalExtraItems.copper_ore_chunk);
        nitraticOre(consumer, "tin", ItemTagsCoFH.RAW_MATERIALS_TIN, ThermalExtraItems.tin_ore_chunk, ITEMS.getSup("apatite"));
        nitraticOre(consumer, "lead", ItemTagsCoFH.RAW_MATERIALS_LEAD, ThermalExtraItems.lead_ore_chunk, ThermalExtraItems.silver_ore_chunk);
        nitraticOre(consumer, "silver", ItemTagsCoFH.RAW_MATERIALS_SILVER, ThermalExtraItems.silver_ore_chunk, ThermalExtraItems.lead_ore_chunk);
        nitraticOre(consumer, "nickel", ItemTagsCoFH.RAW_MATERIALS_NICKEL, ThermalExtraItems.nickel_ore_chunk, ThermalExtraItems.iron_ore_chunk);
        nitraticOre(withConditions(consumer).addCondition(new NotCondition(new TagEmptyCondition("forge:raw_materials/aluminum"))), "aluminum", rawAluminum, ThermalExtraItems.aluminum_ore_chunk, ThermalExtraItems.iron_ore_chunk);
        nitraticOre(withConditions(consumer).addCondition(new NotCondition(new TagEmptyCondition("forge:raw_materials/uranium"))), "uranium", rawUranium, ThermalExtraItems.uranium_ore_chunk);
        nitraticOre(withConditions(consumer).addCondition(new NotCondition(new TagEmptyCondition("forge:raw_materials/osmium"))), "osmium", rawOsmium, ThermalExtraItems.osmium_ore_chunk);
        nitraticOre(withConditions(consumer).addCondition(new NotCondition(new TagEmptyCondition("forge:raw_materials/arcane_gold"))), "arcane_gold", rawOsmium, ThermalExtraItems.arcane_gold_ore_chunk);
        nitraticOre(withConditions(consumer).addCondition(new NotCondition(new TagEmptyCondition("forge:raw_materials/zinc"))), "zinc", rawOsmium, ThermalExtraItems.zinc_ore_chunk);

        ThermalBuilder.metal_infuser()
                .energy(15000)
                .input(FluidIngredient.of(new FluidStack(TCoreFluids.ENDER_FLUID.get(), 1000)))
                .input(ThermalExtraItems.tank_augment_5.get())
                .output(ThermalExtraItems.tank_augment_6.get())
                .save(consumer, "thermal_extra:machine/metal_infuser/dragon_steel_tank_augment");

        ThermalBuilder.advanced_refinery()
                .input(new FluidStack(ThermalExtraFluids.liquid_biomass.still().get(), 2000))
                .output(new ThermalBuilder.ChanceItemStack(new ItemStack(Items.BONE_MEAL), 0.2f, false))
                .output(new ThermalBuilder.ChanceItemStack(new ItemStack(ITEMS.get("compost")), 0.1f, false))
                .output(new FluidStack(ThermalExtraFluids.biodiesel.still().get(), 1000))
                .save(consumer, "thermal_extra:machine/advanced_refinery/biodiesel");

        ThermalBuilder.fluid_mixer()
                .energy(10000)
                .input(TCoreFluids.REDSTONE_FLUID.get(), 1000)
                .input(TCoreFluids.CRUDE_OIL_FLUID.get(), 1000)
                .output(new FluidStack(ThermalExtraFluids.flux_infused_oil.still().get(), 1000))
                .save(consumer, "thermal_extra:machine/fluid_mixer/flux_infused_oil");

        ThermalBuilder.fluid_mixer()
                .input(FluidIngredient.of(ThermalTags.Fluids.LATEX, 1000))
                .input(TCoreFluids.CREOSOTE_FLUID.get(), 1000)
                .output(ThermalExtraFluids.polyolefin.still().get(), 1000)
                .output(TCoreFluids.RESIN_FLUID.get(), 500)
                .save(consumer, "thermal_extra:machine/fluid_mixer/polyolefin");

        ThermalBuilder.fluid_mixer()
                .input(ThermalExtraFluids.biodiesel.getStillFluid().get(), 1000)
                .input(TCoreFluids.SYRUP_FLUID.get(), 1000)
                .output(new FluidStack(ThermalExtraFluids.super_biodiesel.still().get(), 1000))
                .save(consumer, "thermal_extra:machine/fluid_mixer/super_biodiesel");
    }



    public void generateAugmentRecipes(@NotNull Consumer<FinishedRecipe> consumer) {

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

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, result)
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

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, result)
                .define('G', ItemTagsCoFH.NUGGETS_ENDERIUM)
                .define('X', part)
                .pattern(" G ")
                .pattern("GXG")
                .pattern(" G ")
                .unlockedBy("has_item_filter_augment", has(part))
                .save(withConditions(consumer).flag(FLAG_UPGRADE_AUGMENTS), this.modid + ":" + folder + "/" + name(result));
    }

    public void nitraticOre(Consumer<FinishedRecipe> consumer, String oreName, TagKey<Item> tagKey, Supplier<Item> mainOreChunk, Supplier<Item> secondaryOreChunk) {
        ThermalBuilder.nitratic_igniter()
                .energy(12000)
                .input(Ingredient.of(tagKey))
                .output(new ThermalBuilder.ChanceItemStack(new ItemStack(mainOreChunk.get(), 3), 1.25f, true))
                .output(new ThermalBuilder.ChanceItemStack(new ItemStack(mainOreChunk.get(), 1), 0.55f, false))
                .output(new ThermalBuilder.ChanceItemStack(new ItemStack(secondaryOreChunk.get(), 1), 0.25f, false))
                .exp(1.1f)
                .save(consumer, "thermal_extra:machine/nitratic_igniter/raw_" + oreName);
    }

    public void nitraticOre(Consumer<FinishedRecipe> consumer, String oreName, TagKey<Item> tagKey, Supplier<Item> mainOreChunk) {
        ThermalBuilder.nitratic_igniter()
                .energy(12000)
                .input(Ingredient.of(tagKey))
                .output(new ThermalBuilder.ChanceItemStack(new ItemStack(mainOreChunk.get(), 3), 1.25f, true))
                .output(new ThermalBuilder.ChanceItemStack(new ItemStack(mainOreChunk.get(), 1), 0.65f, false))
                .exp(1.1f)
                .save(consumer, "thermal_extra:machine/nitratic_igniter/raw_" + oreName);
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

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, result)
                .define('G', ThermalExtraTags.Items.SOUL_INFUSED_PLATE)
                .define('I', ItemTagsCoFH.DUSTS_QUARTZ)
                .define('X', part)
                .pattern(" I ")
                .pattern("GXG")
                .pattern(" I ")
                .unlockedBy("has_"+name, has(part))
                .save(withConditions(consumer).flag(flag), this.modid + ":" + folder + "/" + name(result));

        result = ThermalExtraItems.ITEMS.get(name+"_2");
        part = ThermalExtraItems.ITEMS.get(name+"_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, result)
                .define('G', ItemTagsCoFH.PLATES_ENDERIUM)
                .define('I', ItemTagsCoFH.DUSTS_DIAMOND)
                .define('X', part)
                .pattern(" I ")
                .pattern("GXG")
                .pattern(" I ")
                .unlockedBy("has_"+name+"_1", has(part))
                .save(withConditions(consumer).flag(flag), this.modid + ":" + folder + "/" + name(result));

        result = ThermalExtraItems.ITEMS.get(name+"_3");
        part = ThermalExtraItems.ITEMS.get(name+"_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, result)
                .define('G', ThermalExtraTags.Items.SHELLITE_PLATE)
                .define('I', ItemTagsCoFH.DUSTS_ENDER_PEARL)
                .define('X', part)
                .pattern(" I ")
                .pattern("GXG")
                .pattern(" I ")
                .unlockedBy("has_"+name+"_1", has(part))
                .save(withConditions(consumer).flag(flag), this.modid + ":" + folder + "/" + name(result));

        if(forth) {

            result = ThermalExtraItems.ITEMS.get(name+"_4");
            part = ThermalExtraItems.ITEMS.get(name+"_3");

            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, result)
                    .define('G', ThermalExtraTags.Items.TWINITE_PLATE)
                    .define('I', ItemTagsCoFH.DUSTS_SIGNALUM)
                    .define('X', part)
                    .pattern(" I ")
                    .pattern("GXG")
                    .pattern(" I ")
                    .unlockedBy("has_"+name+"_3", has(part))
                    .save(withConditions(consumer).flag(flag), this.modid + ":" + folder + "/" + name(result));
            if(fifth) {

                result = ThermalExtraItems.ITEMS.get(name+"_5");
                part = ThermalExtraItems.ITEMS.get(name+"_4");

                ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, result)
                        .define('G', ThermalExtraTags.Items.DRAGONSTEEL_PLATE)
                        .define('I', ItemTagsCoFH.DUSTS_NETHERITE)
                        .define('X', part)
                        .pattern(" I ")
                        .pattern("GXG")
                        .pattern(" I ")
                        .unlockedBy("has_"+name+"_4", has(part))
                        .save(withConditions(consumer).flag(flag), this.modid + ":" + folder + "/" + name(result));
            }
        }
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

            ThermalBuilder.press()
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

            ThermalBuilder.press()
                    .input(new IngredientWithCount(Ingredient.of(gemTag), 4))
                    .input(Ingredient.of(ITEMS.get("press_gear_die")))
                    .output(gear)
                    .save(consumer, "thermal_extra:machine/press/"+type+"_gear");
        }
    }

    private ResourceLocation loc(String name) {
        return new ResourceLocation(this.modLoc(name));
    }

    private String modLoc(String name) {
        return ThermalExtra.MOD_ID+":"+name;
    }
}
