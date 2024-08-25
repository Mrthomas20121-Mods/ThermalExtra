package mrthomas20121.thermal_extra.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class ThermalExtraTags {

    public static class EntityTypes {

        public static TagKey<EntityType<?>> ENDER_MOBS = tag("forge:ender_mobs");

        private static TagKey<EntityType<?>> tag(String name)
        {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(name));
        }
    }

    public static class Fluids {
        private static TagKey<Fluid> create(String name) {
            return TagKey.create(Registries.FLUID, new ResourceLocation(name));
        }

        public static TagKey<Fluid> SOUL_INFUSED = ThermalExtraFluids.MOLTEN_SOUL_INFUSED.getFluidTag();
        public static TagKey<Fluid> SHELLITE = ThermalExtraFluids.MOLTEN_SHELLITE.getFluidTag();
        public static TagKey<Fluid> TWINITE = ThermalExtraFluids.MOLTEN_TWINITE.getFluidTag();
        public static TagKey<Fluid> DRAGONSTEEL = ThermalExtraFluids.MOLTEN_DRAGONSTEEL.getFluidTag();
        public static TagKey<Fluid> ABYSSAL = ThermalExtraFluids.MOLTEN_ABYSSAL.getFluidTag();
    }

    public static class Blocks {

        private static TagKey<Block> create(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(name));
        }

        public static TagKey<Block> SOUL_INFUSED_BLOCK = create("forge:storage_blocks/soul_infused");
        public static TagKey<Block> SHELLITE_BLOCK = create("forge:storage_blocks/shellite");
        public static TagKey<Block> TWINITE_BLOCK = create("forge:storage_blocks/twinite");
        public static TagKey<Block> DRAGONSTEEL_BLOCK = create("forge:storage_blocks/dragonsteel");
        public static TagKey<Block> ABYSSAL_BLOCK = create("forge:storage_blocks/abyssal");

        public static TagKey<Block> MACHINES = create("thermal_extra:machines");

        public static TagKey<Block> NEEDS_SIGNALUM_TOOLS = create("thermal_extra:needs_signalum_tools");
        public static TagKey<Block> NEEDS_LUMIUM_TOOLS = create("thermal_extra:needs_lumium_tools");
        public static TagKey<Block> NEEDS_ENDERIUM_TOOLS = create("thermal_extra:needs_enderium_tools");
        public static TagKey<Block> NEEDS_ABYSSAL_TOOLS = create("thermal_extra:needs_abyssal_tools");
        public static TagKey<Block> NEEDS_SOUL_INFUSED_TOOLS = create("thermal_extra:needs_soul_infused_tools");
        public static TagKey<Block> NEEDS_DRAGONSTEEL_TOOLS = create("thermal_extra:needs_dragonsteel_tools");
        public static TagKey<Block> NEEDS_SHELLITE_TOOLS = create("thermal_extra:needs_shellite_tools");
        public static TagKey<Block> NEEDS_TWINITE_TOOLS = create("thermal_extra:needs_twinite_tools");
    }

    public static class Items {

        private static TagKey<Item> create(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(name));
        }

        public static TagKey<Item> RAW_MATERIALS_ALUMINUM = create("forge:raw_materials/aluminum");
        public static TagKey<Item> RAW_MATERIALS_ARCANE_GOLD = create("forge:raw_materials/arcane_gold");
        public static TagKey<Item> RAW_MATERIALS_URANIUM = create("forge:raw_materials/uranium");
        public static TagKey<Item> RAW_MATERIALS_OSMIUM = create("forge:raw_materials/osmium");
        public static TagKey<Item> RAW_MATERIALS_ZINC = create("forge:raw_materials/zinc");

        public static TagKey<Item> DUSTS_OBSIDIAN = create("forge:dusts/obsidian");

        public static TagKey<Item> SIGNALUM_ARMOR = create("forge:armors/signalum");
        public static TagKey<Item> LUMIUM_ARMOR = create("forge:armors/lumium");
        public static TagKey<Item> ENDERIUM_ARMOR = create("forge:armors/enderium");
        public static TagKey<Item> ABYSSAL_ARMOR = create("forge:armors/abyssal");
        public static TagKey<Item> SOUL_INFUSED_ARMOR = create("forge:armors/soul_infused");
        public static TagKey<Item> SHELLITE_ARMOR = create("forge:armors/shellite");
        public static TagKey<Item> TWINITE_ARMOR = create("forge:armors/twinite");
        public static TagKey<Item> DRAGONSTEEL_ARMOR = create("forge:armors/dragonsteel");

        public static TagKey<Item> SIGNALUM_TOOLS = create("forge:tools/signalum");
        public static TagKey<Item> LUMIUM_TOOLS = create("forge:tools/lumium");
        public static TagKey<Item> ENDERIUM_TOOLS = create("forge:tools/enderium");
        public static TagKey<Item> ABYSSAL_TOOLS = create("forge:tools/abyssal");
        public static TagKey<Item> SOUL_INFUSED_TOOLS = create("forge:tools/soul_infused");
        public static TagKey<Item> SHELLITE_TOOLS = create("forge:tools/shellite");
        public static TagKey<Item> TWINITE_TOOLS = create("forge:tools/twinite");
        public static TagKey<Item> DRAGONSTEEL_TOOLS = create("forge:tools/dragonsteel");

        public static TagKey<Item> GEARS = create("forge:gears");
        public static TagKey<Item> COINS = create("forge:coins");
        public static TagKey<Item> PLATES = create("forge:plates");

        public static TagKey<Item> DUSTS_ZINC = create("forge:dusts/zinc");
        public static TagKey<Item> DUSTS_ARCANE_GOLD = create("forge:dusts/arcane_gold");
        public static TagKey<Item> DUSTS_SOUL_SAND = create("forge:dusts/soul_sand");
        public static TagKey<Item> DUSTS_AMETHYST = create("forge:dusts/amethyst");

        public static TagKey<Item> STORAGE_BLOCKS_SOUL_INFUSED = create("forge:storage_blocks/soul_infused");
        public static TagKey<Item> STORAGE_BLOCKS_TWINITE = create("forge:storage_blocks/twinite");
        public static TagKey<Item> STORAGE_BLOCKS_SHELLITE = create("forge:storage_blocks/shellite");
        public static TagKey<Item> STORAGE_BLOCKS_DRAGONSTEEL = create("forge:storage_blocks/dragonsteel");
        public static TagKey<Item> STORAGE_BLOCKS_ABYSSAL = create("forge:storage_blocks/abyssal");

        // rods
        public static TagKey<Item> RODS_COPPER = create("forge:rods/copper");
        public static TagKey<Item> RODS_IRON = create("forge:rods/iron");
        public static TagKey<Item> RODS_GOLD = create("forge:rods/gold");
        public static TagKey<Item> RODS_DIAMOND = create("forge:rods/diamond");
        public static TagKey<Item> RODS_EMERALD = create("forge:rods/emerald");

        public static TagKey<Item> RODS_LEAD = create("forge:rods/lead");
        public static TagKey<Item> RODS_TIN = create("forge:rods/tin");
        public static TagKey<Item> RODS_SILVER = create("forge:rods/silver");
        public static TagKey<Item> RODS_NICKEL = create("forge:rods/nickel");
        public static TagKey<Item> RODS_BRONZE = create("forge:rods/bronze");
        public static TagKey<Item> RODS_ELECTRUM = create("forge:rods/electrum");
        public static TagKey<Item> RODS_CONSTANTAN = create("forge:rods/constantan");
        public static TagKey<Item> RODS_INVAR = create("forge:rods/invar");
        public static TagKey<Item> RODS_NETHERITE = create("forge:rods/netherite");
        public static TagKey<Item> RODS_SIGNALUM = create("forge:rods/signalum");
        public static TagKey<Item> RODS_LUMIUM = create("forge:rods/lumium");
        public static TagKey<Item> RODS_ENDERIUM = create("forge:rods/enderium");
        public static TagKey<Item> RODS_ABYSSAL = create("forge:rods/abyssal");
        public static TagKey<Item> RODS_SOUL_INFUSED = create("forge:rods/soul_infused");
        public static TagKey<Item> RODS_SHELLITE = create("forge:rods/shellite");
        public static TagKey<Item> RODS_TWINITE = create("forge:rods/twinite");
        public static TagKey<Item> RODS_DRAGONSTEEL = create("forge:rods/dragonsteel");

        public static TagKey<Item> ABYSSAL_INGOT = create("forge:ingots/abyssal");
        public static TagKey<Item> ABYSSAL_GEAR = create("forge:gears/abyssal");
        public static TagKey<Item> ABYSSAL_NUGGET = create("forge:nuggets/abyssal");
        public static TagKey<Item> ABYSSAL_COIN = create("forge:coins/abyssal");
        public static TagKey<Item> ABYSSAL_PLATE = create("forge:plates/abyssal");
        public static TagKey<Item> ABYSSAL_DUST = create("forge:dusts/abyssal");

        public static TagKey<Item> SIGNALUM_REPAIR_MATERIAL = create("thermal_extra:signalum_repair_material");
        public static TagKey<Item> LUMIUM_REPAIR_MATERIAL = create("thermal_extra:lumium_repair_material");
        public static TagKey<Item> ENDERIUM_REPAIR_MATERIAL = create("thermal_extra:enderium_repair_material");
        public static TagKey<Item> SOUL_INFUSED_REPAIR_MATERIAL = create("thermal_extra:soul_infused_repair_material");
        public static TagKey<Item> SHELLITE_REPAIR_MATERIAL = create("thermal_extra:shellite_repair_material");
        public static TagKey<Item> TWINITE_REPAIR_MATERIAL = create("thermal_extra:twinite_repair_material");
        public static TagKey<Item> DRAGONSTEEL_REPAIR_MATERIAL = create("thermal_extra:dragonsteel_repair_material");
        public static TagKey<Item> ABYSSAL_REPAIR_MATERIAL = create("thermal_extra:abyssal_repair_material");

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
