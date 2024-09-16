package mrthomas20121.thermal_extra.data;

import cofh.thermal.lib.util.references.ThermalTags;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import mrthomas20121.thermal_extra.init.ThermalExtraTags;
import mrthomas20121.thermal_extra.item.ToolSetObject;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
//import slimeknights.tconstruct.common.TinkerTags;

public class ExtraTagGen {

    public static class EntityTags extends EntityTypeTagsProvider {

        public EntityTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(pOutput, pProvider, ThermalExtra.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {

            tag(ThermalExtraTags.EntityTypes.ENDER_MOBS).add(EntityType.ENDERMAN, EntityType.ENDER_DRAGON, EntityType.ENDERMITE, EntityType.SHULKER);
        }
    }

    public static class FluidTags extends FluidTagsProvider {

        public FluidTags(PackOutput gen, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
            super(gen, completableFuture, ThermalExtra.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(ThermalExtraTags.Fluids.SOUL_INFUSED).add(ThermalExtraFluids.MOLTEN_SOUL_INFUSED.still().get());
            tag(ThermalExtraTags.Fluids.SHELLITE).add(ThermalExtraFluids.MOLTEN_SHELLITE.still().get());
            tag(ThermalExtraTags.Fluids.TWINITE).add(ThermalExtraFluids.MOLTEN_TWINITE.still().get());
            tag(ThermalExtraTags.Fluids.DRAGONSTEEL).add(ThermalExtraFluids.MOLTEN_DRAGONSTEEL.still().get());
            tag(ThermalExtraTags.Fluids.ABYSSAL).add(ThermalExtraFluids.MOLTEN_ABYSSAL.still().get());

            //tag();
        }
    }

    public static class ItemTags extends ItemTagsProvider {

        public ItemTags(PackOutput gen, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagsProvider.TagLookup<Block>> blocks, @Nullable ExistingFileHelper existingFileHelper) {
            super(gen, completableFuture, blocks, ThermalExtra.MOD_ID, existingFileHelper);
        }

        @Override
        @SuppressWarnings("unchecked")
        protected void addTags(HolderLookup.Provider provider) {

            tag(ThermalTags.Items.MACHINE_CASTS).add(ThermalExtraItems.CHILLER_PLATE_CAST.get());

            tag(Tags.Items.INGOTS).add(
                    ThermalExtraItems.SOUL_INFUSED_INGOT.get(),
                    ThermalExtraItems.SHELLITE_INGOT.get(),
                    ThermalExtraItems.TWINITE_INGOT.get(),
                    ThermalExtraItems.DRAGONSTEEL_INGOT.get(),
                    ThermalExtraItems.ABYSSAL_INGOT.get()
            );

            tag(Tags.Items.NUGGETS).add(
                    ThermalExtraItems.SOUL_INFUSED_NUGGET.get(),
                    ThermalExtraItems.SHELLITE_NUGGET.get(),
                    ThermalExtraItems.TWINITE_NUGGET.get(),
                    ThermalExtraItems.DRAGONSTEEL_NUGGET.get(),
                    ThermalExtraItems.ABYSSAL_NUGGET.get()
            );

            tag(ThermalExtraTags.Items.GEARS).add(
                    ThermalExtraItems.SOUL_INFUSED_GEAR.get(),
                    ThermalExtraItems.SHELLITE_GEAR.get(),
                    ThermalExtraItems.TWINITE_GEAR.get(),
                    ThermalExtraItems.DRAGONSTEEL_GEAR.get(),
                    ThermalExtraItems.ABYSSAL_GEAR.get()
            );

            tag(ThermalExtraTags.Items.COINS).add(
                    ThermalExtraItems.SOUL_INFUSED_COIN.get(),
                    ThermalExtraItems.SHELLITE_COIN.get(),
                    ThermalExtraItems.TWINITE_COIN.get(),
                    ThermalExtraItems.DRAGONSTEEL_COIN.get(),
                    ThermalExtraItems.ABYSSAL_COIN.get()
            );

            tag(ThermalExtraTags.Items.PLATES).add(
                    ThermalExtraItems.SOUL_INFUSED_PLATE.get(),
                    ThermalExtraItems.SHELLITE_PLATE.get(),
                    ThermalExtraItems.TWINITE_PLATE.get(),
                    ThermalExtraItems.DRAGONSTEEL_PLATE.get(),
                    ThermalExtraItems.ABYSSAL_PLATE.get()
            );

            tag(Tags.Items.DUSTS).add(
                    ThermalExtraItems.SOUL_INFUSED_DUST.get(),
                    ThermalExtraItems.SHELLITE_DUST.get(),
                    ThermalExtraItems.TWINITE_DUST.get(),
                    ThermalExtraItems.DRAGONSTEEL_DUST.get(),
                    ThermalExtraItems.ABYSSAL_DUST.get(),
                    ThermalExtraItems.AMETHYST_DUST.get(),
                    ThermalExtraItems.ANCIENT_DUST.get(),
                    ThermalExtraItems.OBSIDIAN_DUST.get(),
                    ThermalExtraItems.ARCANE_GOLD_DUST.get(),
                    ThermalExtraItems.ZINC_DUST.get()
            );

            tag(ThermalExtraTags.Items.DUSTS_ARCANE_GOLD).add(ThermalExtraItems.ARCANE_GOLD_DUST.get());
            tag(ThermalExtraTags.Items.DUSTS_ZINC).add(ThermalExtraItems.ZINC_DUST.get());
            tag(ThermalExtraTags.Items.DUSTS_OBSIDIAN).add(ThermalExtraItems.OBSIDIAN_DUST.get());
            tag(ThermalExtraTags.Items.DUSTS_SOUL_SAND).add(ThermalExtraItems.SOUL_SAND_DUST.get());
            tag(ThermalExtraTags.Items.DUSTS_AMETHYST).add(ThermalExtraItems.AMETHYST_DUST.get());

            tag(ThermalExtraTags.Items.SIGNALUM_REPAIR_MATERIAL).addOptionalTag(new ResourceLocation("forge:ingots/signalum"));
            tag(ThermalExtraTags.Items.LUMIUM_REPAIR_MATERIAL).addOptionalTag(new ResourceLocation("forge:ingots/lumium"));
            tag(ThermalExtraTags.Items.ENDERIUM_REPAIR_MATERIAL).addOptionalTag(new ResourceLocation("forge:ingots/enderium"));

            tag(ThermalExtraTags.Items.SOUL_INFUSED_INGOT).add(ThermalExtraItems.SOUL_INFUSED_INGOT.get());
            tag(ThermalExtraTags.Items.SOUL_INFUSED_NUGGET).add(ThermalExtraItems.SOUL_INFUSED_NUGGET.get());
            tag(ThermalExtraTags.Items.SOUL_INFUSED_DUST).add(ThermalExtraItems.SOUL_INFUSED_DUST.get());
            tag(ThermalExtraTags.Items.SOUL_INFUSED_GEAR).add(ThermalExtraItems.SOUL_INFUSED_GEAR.get());
            tag(ThermalExtraTags.Items.SOUL_INFUSED_PLATE).add(ThermalExtraItems.SOUL_INFUSED_PLATE.get());
            tag(ThermalExtraTags.Items.SOUL_INFUSED_COIN).add(ThermalExtraItems.SOUL_INFUSED_COIN.get());
            tag(ThermalExtraTags.Items.SOUL_INFUSED_REPAIR_MATERIAL).addTag(ThermalExtraTags.Items.SOUL_INFUSED_INGOT);

            tag(ThermalExtraTags.Items.SHELLITE_INGOT).add(ThermalExtraItems.SHELLITE_INGOT.get());
            tag(ThermalExtraTags.Items.SHELLITE_NUGGET).add(ThermalExtraItems.SHELLITE_NUGGET.get());
            tag(ThermalExtraTags.Items.SHELLITE_DUST).add(ThermalExtraItems.SHELLITE_DUST.get());
            tag(ThermalExtraTags.Items.SHELLITE_GEAR).add(ThermalExtraItems.SHELLITE_GEAR.get());
            tag(ThermalExtraTags.Items.SHELLITE_PLATE).add(ThermalExtraItems.SHELLITE_PLATE.get());
            tag(ThermalExtraTags.Items.SHELLITE_COIN).add(ThermalExtraItems.SHELLITE_COIN.get());
            tag(ThermalExtraTags.Items.SHELLITE_REPAIR_MATERIAL).addTag(ThermalExtraTags.Items.SHELLITE_INGOT);

            tag(ThermalExtraTags.Items.TWINITE_INGOT).add(ThermalExtraItems.TWINITE_INGOT.get());
            tag(ThermalExtraTags.Items.TWINITE_NUGGET).add(ThermalExtraItems.TWINITE_NUGGET.get());
            tag(ThermalExtraTags.Items.TWINITE_DUST).add(ThermalExtraItems.TWINITE_DUST.get());
            tag(ThermalExtraTags.Items.TWINITE_GEAR).add(ThermalExtraItems.TWINITE_GEAR.get());
            tag(ThermalExtraTags.Items.TWINITE_PLATE).add(ThermalExtraItems.TWINITE_PLATE.get());
            tag(ThermalExtraTags.Items.TWINITE_COIN).add(ThermalExtraItems.TWINITE_COIN.get());
            tag(ThermalExtraTags.Items.TWINITE_REPAIR_MATERIAL).addTag(ThermalExtraTags.Items.TWINITE_INGOT);

            tag(ThermalExtraTags.Items.DRAGONSTEEL_INGOT).add(ThermalExtraItems.DRAGONSTEEL_INGOT.get());
            tag(ThermalExtraTags.Items.DRAGONSTEEL_NUGGET).add(ThermalExtraItems.DRAGONSTEEL_NUGGET.get());
            tag(ThermalExtraTags.Items.DRAGONSTEEL_DUST).add(ThermalExtraItems.DRAGONSTEEL_DUST.get());
            tag(ThermalExtraTags.Items.DRAGONSTEEL_GEAR).add(ThermalExtraItems.DRAGONSTEEL_GEAR.get());
            tag(ThermalExtraTags.Items.DRAGONSTEEL_PLATE).add(ThermalExtraItems.DRAGONSTEEL_PLATE.get());
            tag(ThermalExtraTags.Items.DRAGONSTEEL_COIN).add(ThermalExtraItems.DRAGONSTEEL_COIN.get());
            tag(ThermalExtraTags.Items.DRAGONSTEEL_REPAIR_MATERIAL).addTag(ThermalExtraTags.Items.DRAGONSTEEL_INGOT);

            tag(ThermalExtraTags.Items.ABYSSAL_INGOT).add(ThermalExtraItems.ABYSSAL_INGOT.get());
            tag(ThermalExtraTags.Items.ABYSSAL_NUGGET).add(ThermalExtraItems.ABYSSAL_NUGGET.get());
            tag(ThermalExtraTags.Items.ABYSSAL_DUST).add(ThermalExtraItems.ABYSSAL_DUST.get());
            tag(ThermalExtraTags.Items.ABYSSAL_GEAR).add(ThermalExtraItems.ABYSSAL_GEAR.get());
            tag(ThermalExtraTags.Items.ABYSSAL_PLATE).add(ThermalExtraItems.ABYSSAL_PLATE.get());
            tag(ThermalExtraTags.Items.ABYSSAL_COIN).add(ThermalExtraItems.ABYSSAL_COIN.get());
            tag(ThermalExtraTags.Items.ABYSSAL_REPAIR_MATERIAL).addTag(ThermalExtraTags.Items.ABYSSAL_INGOT);

            tag(net.minecraft.tags.ItemTags.PIGLIN_LOVED).add(
                    ThermalExtraItems.LUMIUM_SET.helmet().get(),
                    ThermalExtraItems.LUMIUM_SET.chestplate().get(),
                    ThermalExtraItems.LUMIUM_SET.leggings().get(),
                    ThermalExtraItems.LUMIUM_SET.boots().get()
            );

            tag(Tags.Items.TOOLS).addTags(
                    ThermalExtraTags.Items.ABYSSAL_TOOLS,
                    ThermalExtraTags.Items.DRAGONSTEEL_TOOLS,
                    ThermalExtraTags.Items.TWINITE_TOOLS,
                    ThermalExtraTags.Items.SHELLITE_TOOLS,
                    ThermalExtraTags.Items.SOUL_INFUSED_TOOLS,
                    ThermalExtraTags.Items.ENDERIUM_TOOLS,
                    ThermalExtraTags.Items.LUMIUM_TOOLS,
                    ThermalExtraTags.Items.SIGNALUM_TOOLS
            );

            toolsetTags(ThermalExtraItems.SIGNALUM_SET, ThermalExtraTags.Items.SIGNALUM_TOOLS, ThermalExtraTags.Items.SIGNALUM_ARMOR);
            toolsetTags(ThermalExtraItems.LUMIUM_SET, ThermalExtraTags.Items.LUMIUM_TOOLS, ThermalExtraTags.Items.LUMIUM_ARMOR);
            toolsetTags(ThermalExtraItems.ENDERIUM_SET, ThermalExtraTags.Items.ENDERIUM_TOOLS, ThermalExtraTags.Items.ENDERIUM_ARMOR);

            toolsetTags(ThermalExtraItems.SOUL_INFUSED_SET, ThermalExtraTags.Items.SOUL_INFUSED_TOOLS, ThermalExtraTags.Items.SOUL_INFUSED_ARMOR);
            toolsetTags(ThermalExtraItems.SHELLITE_SET, ThermalExtraTags.Items.SHELLITE_TOOLS, ThermalExtraTags.Items.SHELLITE_ARMOR);
            toolsetTags(ThermalExtraItems.TWINITE_SET, ThermalExtraTags.Items.TWINITE_TOOLS, ThermalExtraTags.Items.TWINITE_ARMOR);
            toolsetTags(ThermalExtraItems.DRAGONSTEEL_SET, ThermalExtraTags.Items.DRAGONSTEEL_TOOLS, ThermalExtraTags.Items.DRAGONSTEEL_ARMOR);
            toolsetTags(ThermalExtraItems.ABYSSAL_SET, ThermalExtraTags.Items.ABYSSAL_TOOLS, ThermalExtraTags.Items.ABYSSAL_ARMOR);

            tag(ThermalTags.Items.MACHINE_DIES).add(ThermalExtraItems.PRESS_ROD_DIE.get());

            tag(Tags.Items.RODS).add(
                    ThermalExtraItems.COPPER_ROD.get(),
                    ThermalExtraItems.IRON_ROD.get(),
                    ThermalExtraItems.GOLD_ROD.get(),
                    ThermalExtraItems.DIAMOND_ROD.get(),
                    ThermalExtraItems.EMERALD_ROD.get(),
                    ThermalExtraItems.NETHERITE_ROD.get(),
                    ThermalExtraItems.LEAD_ROD.get(),
                    ThermalExtraItems.TIN_ROD.get(),
                    ThermalExtraItems.SILVER_ROD.get(),
                    ThermalExtraItems.NICKEL_ROD.get(),
                    ThermalExtraItems.BRONZE_ROD.get(),
                    ThermalExtraItems.ELECTRUM_ROD.get(),
                    ThermalExtraItems.CONSTANTAN_ROD.get(),
                    ThermalExtraItems.INVAR_ROD.get(),
                    ThermalExtraItems.SIGNALUM_ROD.get(),
                    ThermalExtraItems.LUMIUM_ROD.get(),
                    ThermalExtraItems.ENDERIUM_ROD.get(),
                    ThermalExtraItems.SOUL_INFUSED_ROD.get(),
                    ThermalExtraItems.SHELLITE_ROD.get(),
                    ThermalExtraItems.TWINITE_ROD.get(),
                    ThermalExtraItems.DRAGONSTEEL_ROD.get(),
                    ThermalExtraItems.ABYSSAL_ROD.get()
            );

            tag(ThermalExtraTags.Items.RODS_COPPER).add(ThermalExtraItems.COPPER_ROD.get());
            tag(ThermalExtraTags.Items.RODS_IRON).add(ThermalExtraItems.IRON_ROD.get());
            tag(ThermalExtraTags.Items.RODS_GOLD).add(ThermalExtraItems.GOLD_ROD.get());
            tag(ThermalExtraTags.Items.RODS_DIAMOND).add(ThermalExtraItems.DIAMOND_ROD.get());
            tag(ThermalExtraTags.Items.RODS_EMERALD).add(ThermalExtraItems.EMERALD_ROD.get());
            tag(ThermalExtraTags.Items.RODS_NETHERITE).add(ThermalExtraItems.NETHERITE_ROD.get());

            tag(ThermalExtraTags.Items.RODS_LEAD).add(ThermalExtraItems.LEAD_ROD.get());
            tag(ThermalExtraTags.Items.RODS_TIN).add(ThermalExtraItems.TIN_ROD.get());
            tag(ThermalExtraTags.Items.RODS_SILVER).add(ThermalExtraItems.SILVER_ROD.get());
            tag(ThermalExtraTags.Items.RODS_NICKEL).add(ThermalExtraItems.NICKEL_ROD.get());
            tag(ThermalExtraTags.Items.RODS_BRONZE).add(ThermalExtraItems.BRONZE_ROD.get());
            tag(ThermalExtraTags.Items.RODS_ELECTRUM).add(ThermalExtraItems.ELECTRUM_ROD.get());
            tag(ThermalExtraTags.Items.RODS_CONSTANTAN).add(ThermalExtraItems.CONSTANTAN_ROD.get());
            tag(ThermalExtraTags.Items.RODS_INVAR).add(ThermalExtraItems.INVAR_ROD.get());

            tag(ThermalExtraTags.Items.RODS_SIGNALUM).add(ThermalExtraItems.SIGNALUM_ROD.get());
            tag(ThermalExtraTags.Items.RODS_LUMIUM).add(ThermalExtraItems.LUMIUM_ROD.get());
            tag(ThermalExtraTags.Items.RODS_ENDERIUM).add(ThermalExtraItems.ENDERIUM_ROD.get());
            tag(ThermalExtraTags.Items.RODS_SOUL_INFUSED).add(ThermalExtraItems.SOUL_INFUSED_ROD.get());
            tag(ThermalExtraTags.Items.RODS_SHELLITE).add(ThermalExtraItems.SHELLITE_ROD.get());
            tag(ThermalExtraTags.Items.RODS_TWINITE).add(ThermalExtraItems.TWINITE_ROD.get());
            tag(ThermalExtraTags.Items.RODS_DRAGONSTEEL).add(ThermalExtraItems.DRAGONSTEEL_ROD.get());
            tag(ThermalExtraTags.Items.RODS_ABYSSAL).add(ThermalExtraItems.ABYSSAL_ROD.get());

            tag(Tags.Items.STORAGE_BLOCKS).add(
                    ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get().asItem(),
                    ThermalExtraBlocks.SHELLITE_BLOCK.get().asItem(),
                    ThermalExtraBlocks.TWINITE_BLOCK.get().asItem(),
                    ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get().asItem(),
                    ThermalExtraBlocks.ABYSSAL_BLOCK.get().asItem()
            );

//            tag(TinkerTags.Items.ANVIL_METAL).add(
//                    ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get().asItem(),
//                    ThermalExtraBlocks.SHELLITE_BLOCK.get().asItem(),
//                    ThermalExtraBlocks.TWINITE_BLOCK.get().asItem(),
//                    ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get().asItem()
//            );

            tag(ThermalTags.Items.HARDENED_GLASS).add(
                    ThermalExtraBlocks.SOUL_INFUSED_GLASS.get().asItem(),
                    ThermalExtraBlocks.SHELLITE_GLASS.get().asItem(),
                    ThermalExtraBlocks.TWINITE_GLASS.get().asItem(),
                    ThermalExtraBlocks.DRAGONSTEEL_GLASS.get().asItem(),
                    ThermalExtraBlocks.ABYSSAL_GLASS.get().asItem()
            );

            tag(ThermalExtraTags.Items.STORAGE_BLOCKS_SOUL_INFUSED).add(ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get().asItem());
            tag(ThermalExtraTags.Items.STORAGE_BLOCKS_SHELLITE).add(ThermalExtraBlocks.SHELLITE_BLOCK.get().asItem());
            tag(ThermalExtraTags.Items.STORAGE_BLOCKS_TWINITE).add(ThermalExtraBlocks.TWINITE_BLOCK.get().asItem());
            tag(ThermalExtraTags.Items.STORAGE_BLOCKS_DRAGONSTEEL).add(ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get().asItem());
            tag(ThermalExtraTags.Items.STORAGE_BLOCKS_ABYSSAL).add(ThermalExtraBlocks.ABYSSAL_BLOCK.get().asItem());
        }

        private void toolsetTags(ToolSetObject set, TagKey<Item> tool, TagKey<Item> armor) {
            tag(tool).add(
                    set.axe().get(),
                    set.pickaxe().get(),
                    set.shovel().get(),
                    set.hoe().get(),
                    set.sword().get(),
                    set.excavator().get(),
                    set.hammer().get(),
                    set.knife().get(),
                    set.sickle().get()
            );

            tag(armor).add(
                    set.helmet().get(),
                    set.chestplate().get(),
                    set.leggings().get(),
                    set.boots().get()
            );
        }
    }

    public static class BlockTags extends BlockTagsProvider {

        public BlockTags(PackOutput gen, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
            super(gen, completableFuture, ThermalExtra.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {

            tag(ThermalTags.Blocks.HARDENED_GLASS).add(
                    ThermalExtraBlocks.SOUL_INFUSED_GLASS.get(),
                    ThermalExtraBlocks.SHELLITE_GLASS.get(),
                    ThermalExtraBlocks.TWINITE_GLASS.get(),
                    ThermalExtraBlocks.DRAGONSTEEL_GLASS.get(),
                    ThermalExtraBlocks.ABYSSAL_GLASS.get()
            );

            tag(Tags.Blocks.GLASS).add(
                    ThermalExtraBlocks.SOUL_INFUSED_GLASS.get(),
                    ThermalExtraBlocks.SHELLITE_GLASS.get(),
                    ThermalExtraBlocks.TWINITE_GLASS.get(),
                    ThermalExtraBlocks.DRAGONSTEEL_GLASS.get(),
                    ThermalExtraBlocks.ABYSSAL_GLASS.get()
            );

//            tag(TinkerTags.Blocks.ANVIL_METAL).add(
//                    ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get(),
//                    ThermalExtraBlocks.SHELLITE_BLOCK.get(),
//                    ThermalExtraBlocks.TWINITE_BLOCK.get(),
//                    ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get()
//            );

            tag(Tags.Blocks.STORAGE_BLOCKS).add(
                    ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get(),
                    ThermalExtraBlocks.SHELLITE_BLOCK.get(),
                    ThermalExtraBlocks.TWINITE_BLOCK.get(),
                    ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get(),
                    ThermalExtraBlocks.ABYSSAL_BLOCK.get()
            );

            tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(
                    ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get(),
                    ThermalExtraBlocks.SHELLITE_BLOCK.get(),
                    ThermalExtraBlocks.TWINITE_BLOCK.get(),
                    ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get(),
                    ThermalExtraBlocks.ABYSSAL_BLOCK.get()
            );

            tag(ThermalExtraTags.Blocks.SOUL_INFUSED_BLOCK).add(ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get());
            tag(ThermalExtraTags.Blocks.SHELLITE_BLOCK).add(ThermalExtraBlocks.SHELLITE_BLOCK.get());
            tag(ThermalExtraTags.Blocks.TWINITE_BLOCK).add(ThermalExtraBlocks.TWINITE_BLOCK.get());
            tag(ThermalExtraTags.Blocks.DRAGONSTEEL_BLOCK).add(ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get());
            tag(ThermalExtraTags.Blocks.ABYSSAL_BLOCK).add(ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get());

            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(
                    ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get(),
                    ThermalExtraBlocks.SHELLITE_BLOCK.get(),
                    ThermalExtraBlocks.TWINITE_BLOCK.get(),
                    ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get(),
                    ThermalExtraBlocks.SOUL_INFUSED_GLASS.get(),
                    ThermalExtraBlocks.SHELLITE_GLASS.get(),
                    ThermalExtraBlocks.TWINITE_GLASS.get(),
                    ThermalExtraBlocks.DRAGONSTEEL_GLASS.get(),
                    ThermalExtraBlocks.ABYSSAL_BLOCK.get(),
                    ThermalExtraBlocks.DYNAMO_COLD.get(),
                    ThermalExtraBlocks.BLOCKS.get("device_lava_gen"),
                    ThermalExtraBlocks.BLOCKS.get("component_assembly"),
                    ThermalExtraBlocks.BLOCKS.get("endothermic_dehydrator"),
                    ThermalExtraBlocks.BLOCKS.get("nitratic_igniter"),
                    ThermalExtraBlocks.BLOCKS.get("advanced_refinery"),
                    ThermalExtraBlocks.BLOCKS.get("fluid_mixer")
            );
        }
    }
}
