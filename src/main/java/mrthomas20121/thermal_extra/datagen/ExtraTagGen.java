package mrthomas20121.thermal_extra.datagen;

import cofh.thermal.lib.util.references.ThermalTags;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import mrthomas20121.thermal_extra.init.ThermalExtraTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.common.TinkerTags;

public class ExtraTagGen {

    public static class FluidTags extends FluidTagsProvider {

        public FluidTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
            super(gen, ThermalExtra.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags() {
            tag(ThermalExtraTags.Fluids.SOUL_INFUSED).add(ThermalExtraFluids.soul_infused.still().get());
            tag(ThermalExtraTags.Fluids.SHELLITE).add(ThermalExtraFluids.shellite.still().get());
            tag(ThermalExtraTags.Fluids.TWINITE).add(ThermalExtraFluids.twinite.still().get());
            tag(ThermalExtraTags.Fluids.DRAGONSTEEL).add(ThermalExtraFluids.dragonsteel.still().get());
        }
    }

    public static class ItemTags extends ItemTagsProvider {

        public ItemTags(DataGenerator gen, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(gen, blockTagsProvider, ThermalExtra.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags() {

            tag(Tags.Items.INGOTS).add(
                    ThermalExtraItems.soul_infused_ingot.get(),
                    ThermalExtraItems.twinite_ingot.get(),
                    ThermalExtraItems.twinite_ingot.get(),
                    ThermalExtraItems.dragon_steel_ingot.get()
            );

            tag(Tags.Items.NUGGETS).add(
                    ThermalExtraItems.soul_infused_nugget.get(),
                    ThermalExtraItems.twinite_nugget.get(),
                    ThermalExtraItems.twinite_nugget.get(),
                    ThermalExtraItems.dragon_steel_nugget.get()
            );

            tag(ThermalExtraTags.Items.GEARS).add(
                    ThermalExtraItems.soul_infused_gear.get(),
                    ThermalExtraItems.twinite_gear.get(),
                    ThermalExtraItems.twinite_gear.get(),
                    ThermalExtraItems.dragon_steel_gear.get()
            );

            tag(ThermalExtraTags.Items.COINS).add(
                    ThermalExtraItems.soul_infused_coin.get(),
                    ThermalExtraItems.twinite_coin.get(),
                    ThermalExtraItems.twinite_coin.get(),
                    ThermalExtraItems.dragon_steel_coin.get()
            );

            tag(ThermalExtraTags.Items.PLATES).add(
                    ThermalExtraItems.soul_infused_plate.get(),
                    ThermalExtraItems.twinite_plate.get(),
                    ThermalExtraItems.twinite_plate.get(),
                    ThermalExtraItems.dragon_steel_plate.get()
            );

            tag(Tags.Items.DUSTS).add(
                    ThermalExtraItems.soul_infused_dust.get(),
                    ThermalExtraItems.twinite_dust.get(),
                    ThermalExtraItems.twinite_dust.get(),
                    ThermalExtraItems.dragon_steel_dust.get()
            );

            tag(ThermalExtraTags.Items.SOUL_SAND_DUST).add(ThermalExtraItems.soul_sand_dust.get());
            tag(ThermalExtraTags.Items.DUSTS_AMETHYST).add(ThermalExtraItems.amethyst_dust.get());

            tag(ThermalExtraTags.Items.SOUL_INFUSED_INGOT).add(ThermalExtraItems.soul_infused_ingot.get());
            tag(ThermalExtraTags.Items.SOUL_INFUSED_NUGGET).add(ThermalExtraItems.soul_infused_nugget.get());
            tag(ThermalExtraTags.Items.SOUL_INFUSED_DUST).add(ThermalExtraItems.soul_infused_dust.get());
            tag(ThermalExtraTags.Items.SOUL_INFUSED_GEAR).add(ThermalExtraItems.soul_infused_gear.get());
            tag(ThermalExtraTags.Items.SOUL_INFUSED_PLATE).add(ThermalExtraItems.soul_infused_plate.get());
            tag(ThermalExtraTags.Items.SOUL_INFUSED_COIN).add(ThermalExtraItems.soul_infused_coin.get());

            tag(ThermalExtraTags.Items.SHELLITE_INGOT).add(ThermalExtraItems.shellite_ingot.get());
            tag(ThermalExtraTags.Items.SHELLITE_NUGGET).add(ThermalExtraItems.shellite_nugget.get());
            tag(ThermalExtraTags.Items.SHELLITE_DUST).add(ThermalExtraItems.shellite_dust.get());
            tag(ThermalExtraTags.Items.SHELLITE_GEAR).add(ThermalExtraItems.shellite_gear.get());
            tag(ThermalExtraTags.Items.SHELLITE_PLATE).add(ThermalExtraItems.shellite_plate.get());
            tag(ThermalExtraTags.Items.SHELLITE_COIN).add(ThermalExtraItems.shellite_coin.get());

            tag(ThermalExtraTags.Items.TWINITE_INGOT).add(ThermalExtraItems.twinite_ingot.get());
            tag(ThermalExtraTags.Items.TWINITE_NUGGET).add(ThermalExtraItems.twinite_nugget.get());
            tag(ThermalExtraTags.Items.TWINITE_DUST).add(ThermalExtraItems.twinite_dust.get());
            tag(ThermalExtraTags.Items.TWINITE_GEAR).add(ThermalExtraItems.twinite_gear.get());
            tag(ThermalExtraTags.Items.TWINITE_PLATE).add(ThermalExtraItems.twinite_plate.get());
            tag(ThermalExtraTags.Items.TWINITE_COIN).add(ThermalExtraItems.twinite_coin.get());

            tag(ThermalExtraTags.Items.DRAGONSTEEL_INGOT).add(ThermalExtraItems.dragon_steel_ingot.get());
            tag(ThermalExtraTags.Items.DRAGONSTEEL_NUGGET).add(ThermalExtraItems.dragon_steel_nugget.get());
            tag(ThermalExtraTags.Items.DRAGONSTEEL_DUST).add(ThermalExtraItems.dragon_steel_dust.get());
            tag(ThermalExtraTags.Items.DRAGONSTEEL_GEAR).add(ThermalExtraItems.dragon_steel_gear.get());
            tag(ThermalExtraTags.Items.DRAGONSTEEL_PLATE).add(ThermalExtraItems.dragon_steel_plate.get());
            tag(ThermalExtraTags.Items.DRAGONSTEEL_COIN).add(ThermalExtraItems.dragon_steel_coin.get());



            tag(Tags.Items.STORAGE_BLOCKS).add(
                    ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get().asItem(),
                    ThermalExtraBlocks.SHELLITE_BLOCK.get().asItem(),
                    ThermalExtraBlocks.TWINITE_BLOCK.get().asItem(),
                    ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get().asItem()
            );

            tag(TinkerTags.Items.ANVIL_METAL).add(
                    ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get().asItem(),
                    ThermalExtraBlocks.SHELLITE_BLOCK.get().asItem(),
                    ThermalExtraBlocks.TWINITE_BLOCK.get().asItem(),
                    ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get().asItem()
            );

            tag(ThermalTags.Items.HARDENED_GLASS).add(
                    ThermalExtraBlocks.SOUL_INFUSED_GLASS.get().asItem(),
                    ThermalExtraBlocks.SHELLITE_GLASS.get().asItem(),
                    ThermalExtraBlocks.TWINITE_GLASS.get().asItem(),
                    ThermalExtraBlocks.DRAGONSTEEL_GLASS.get().asItem()
            );

            tag(ThermalExtraTags.Items.SOUL_INFUSED_BLOCK).add(ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get().asItem());
            tag(ThermalExtraTags.Items.SHELLITE_BLOCK).add(ThermalExtraBlocks.SHELLITE_BLOCK.get().asItem());
            tag(ThermalExtraTags.Items.TWINITE_BLOCK).add(ThermalExtraBlocks.TWINITE_BLOCK.get().asItem());
            tag(ThermalExtraTags.Items.DRAGONSTEEL_BLOCK).add(ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get().asItem());
        }
    }

    public static class BlockTags extends BlockTagsProvider {

        public BlockTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
            super(gen, ThermalExtra.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags() {

            tag(ThermalTags.Blocks.HARDENED_GLASS).add(
                    ThermalExtraBlocks.SOUL_INFUSED_GLASS.get(),
                    ThermalExtraBlocks.SHELLITE_GLASS.get(),
                    ThermalExtraBlocks.TWINITE_GLASS.get(),
                    ThermalExtraBlocks.DRAGONSTEEL_GLASS.get()
            );

            tag(TinkerTags.Blocks.ANVIL_METAL).add(
                    ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get(),
                    ThermalExtraBlocks.SHELLITE_BLOCK.get(),
                    ThermalExtraBlocks.TWINITE_BLOCK.get(),
                    ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get()
            );

            tag(Tags.Blocks.STORAGE_BLOCKS).add(
                    ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get(),
                    ThermalExtraBlocks.SHELLITE_BLOCK.get(),
                    ThermalExtraBlocks.TWINITE_BLOCK.get(),
                    ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get()
            );

            tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(
                    ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get(),
                    ThermalExtraBlocks.SHELLITE_BLOCK.get(),
                    ThermalExtraBlocks.TWINITE_BLOCK.get(),
                    ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get()
            );

            tag(ThermalExtraTags.Blocks.SOUL_INFUSED_BLOCK).add(ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get());
            tag(ThermalExtraTags.Blocks.SHELLITE_BLOCK).add(ThermalExtraBlocks.SHELLITE_BLOCK.get());
            tag(ThermalExtraTags.Blocks.TWINITE_BLOCK).add(ThermalExtraBlocks.TWINITE_BLOCK.get());
            tag(ThermalExtraTags.Blocks.DRAGONSTEEL_BLOCK).add(ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get());
        }
    }
}
