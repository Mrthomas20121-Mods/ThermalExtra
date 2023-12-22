package mrthomas20121.thermal_extra.init;

import mrthomas20121.thermal_extra.ThermalExtra;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class ThermalExtraTags {

    public static class Fluids {
        private static TagKey<Fluid> create(String name) {
            return TagKey.create(Registries.FLUID, new ResourceLocation(name));
        }

        public static TagKey<Fluid> SOUL_INFUSED = ThermalExtraFluids.soul_infused.getFluidTag();
        public static TagKey<Fluid> SHELLITE = ThermalExtraFluids.shellite.getFluidTag();
        public static TagKey<Fluid> TWINITE = ThermalExtraFluids.twinite.getFluidTag();
        public static TagKey<Fluid> DRAGONSTEEL = ThermalExtraFluids.dragonsteel.getFluidTag();
    }

    public static class Blocks {

        private static TagKey<Block> create(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(name));
        }

        public static TagKey<Block> SOUL_INFUSED_BLOCK = create("forge:storage_blocks/soul_infused");
        public static TagKey<Block> SHELLITE_BLOCK = create("forge:storage_blocks/shellite");
        public static TagKey<Block> TWINITE_BLOCK = create("forge:storage_blocks/twinite");
        public static TagKey<Block> DRAGONSTEEL_BLOCK = create("forge:storage_blocks/dragonsteel");
    }

    public static class Items {

        private static TagKey<Item> create(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(name));
        }

        public static TagKey<Item> GEARS = create("forge:gears");
        public static TagKey<Item> COINS = create("forge:coins");
        public static TagKey<Item> PLATES = create("forge:plates");

        public static TagKey<Item> SOUL_SAND_DUST = create("forge:dusts/soul_sand");
        public static TagKey<Item> DUSTS_AMETHYST = create("forge:dusts/amethyst");

        public static TagKey<Item> SOUL_INFUSED_BLOCK = create("forge:storage_blocks/soul_infused");
        public static TagKey<Item> SHELLITE_BLOCK = create("forge:storage_blocks/shellite");
        public static TagKey<Item> TWINITE_BLOCK = create("forge:storage_blocks/twinite");
        public static TagKey<Item> DRAGONSTEEL_BLOCK = create("forge:storage_blocks/dragonsteel");

        public static TagKey<Item> SOUL_INFUSED_INGOT = create("forge:ingots/soul_infused");
        public static TagKey<Item> SOUL_INFUSED_GEAR = create("forge:gears/soul_infused");
        public static TagKey<Item> SOUL_INFUSED_NUGGET = create("forge:nuggets/soul_infused");
        public static TagKey<Item> SOUL_INFUSED_COIN = create("forge:coins/soul_infused");
        public static TagKey<Item> SOUL_INFUSED_PLATE = create("forge:plates/soul_infused");
        public static TagKey<Item> SOUL_INFUSED_DUST = create("forge:dusts/soul_infused");

        public static TagKey<Item> DRAGONSTEEL_INGOT = create("forge:ingots/dragonsteel");
        public static TagKey<Item> DRAGONSTEEL_GEAR = create("forge:gears/dragonsteel");
        public static TagKey<Item> DRAGONSTEEL_NUGGET = create("forge:nuggets/dragonsteel");
        public static TagKey<Item> DRAGONSTEEL_COIN = create("forge:coins/dragonsteel");
        public static TagKey<Item> DRAGONSTEEL_PLATE = create("forge:plates/dragonsteel");
        public static TagKey<Item> DRAGONSTEEL_DUST = create("forge:dusts/dragonsteel");

        public static TagKey<Item> SHELLITE_INGOT = create("forge:ingots/shellite");
        public static TagKey<Item> SHELLITE_GEAR = create("forge:gears/shellite");
        public static TagKey<Item> SHELLITE_NUGGET = create("forge:nuggets/shellite");
        public static TagKey<Item> SHELLITE_COIN = create("forge:coins/shellite");
        public static TagKey<Item> SHELLITE_PLATE = create("forge:plates/shellite");
        public static TagKey<Item> SHELLITE_DUST = create("forge:dusts/shellite");

        public static TagKey<Item> TWINITE_INGOT = create("forge:ingots/twinite");
        public static TagKey<Item> TWINITE_GEAR = create("forge:gears/twinite");
        public static TagKey<Item> TWINITE_NUGGET = create("forge:nuggets/twinite");
        public static TagKey<Item> TWINITE_COIN = create("forge:coins/twinite");
        public static TagKey<Item> TWINITE_PLATE = create("forge:plates/twinite");
        public static TagKey<Item> TWINITE_DUST = create("forge:dusts/twinite");
    }
}
