package mrthomas20121.thermal_extra.data;

import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import mrthomas20121.thermal_extra.item.ToolSetObject;
import mrthomas20121.thermal_extra.item.augment.EnumAugment;
import mrthomas20121.thermal_extra.item.augment.ExtraAugmentType;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public class ExtraLangGen extends LanguageProvider {

    public ExtraLangGen(PackOutput gen) {
        super(gen, ThermalExtra.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        add("info.thermal_extra.item_filter", "Advanced Item Filter");
        add("info.thermal_extra.dynamo_frost.0", "Generate RF from Cold Items.");
        add("block.thermal_extra.dynamo_frost.keyword", "blizz cube snow ice packed blue cold frost frozen engine generator");
        add("info.thermal_extra.machine_metal_infuser.0", "Convert a metallic item into another by putting it in a fluid.");
        add("info.thermal_extra.machine_nitratic_igniter.0", "Create an Item by exploding other items together.");
        add("info.thermal_extra.machine_fluid_mixer.0", "Mix fluids together to create other fluids");
        add("info.thermal_extra.require_catalyst", "Catalyst is required.");
        add("info.thermal_extra.lava_gen.0", "Magmatic Accumulator generate Lava if it has 2 or more adjacent lava blocks.");
        add("info.thermal_extra.lava_gen_nether.0", "Generate more Lava in the nether.");
        add("info.thermal_extra.endothermic_dehydrator.0", "Evaporate a fluid into items.");

        add("upgrade.thermal_extra.augment_upgrade", "Augment Upgrade");
        add("item.thermal_extra.smithing_template.augment_upgrade.additions_slot_description", "Add Metal Ingot");
        add("item.thermal_extra.smithing_template.augment_upgrade.applies_to", "Thermal Augments");
        add("item.thermal_extra.smithing_template.augment_upgrade.base_slot_description", "Add any augment");
        add("item.thermal_extra.smithing_template.augment_upgrade.ingredients", "Metal Gears");

        // creative tabs
        add("creative_tab.thermal_extra.resources", "Thermal Extra: Resources");
        add("creative_tab.thermal_extra.augments", "Thermal Extra: Augments");
        add("creative_tab.thermal_extra.machines", "Thermal Extra: Machines");

        // fluids and buckets
        add("fluid_type.thermal_extra.soul_infused", "Molten Soul Infused");
        add("fluid_type.thermal_extra.shellite", "Molten Shellite");
        add("fluid_type.thermal_extra.twinite", "Molten Twinite");
        add("fluid_type.thermal_extra.dragonsteel", "Molten Dragonsteel");
        add("fluid_type.thermal_extra.abyssal", "Molten Abyssal");
        add("fluid_type.thermal_extra.sunflower_oil", "Sunflower Oil");
        add("fluid_type.thermal_extra.crystallized_sunflower_oil", "Crystallized Sunflower Oil");
        add("fluid_type.thermal_extra.refined_sunflower_oil", "Refined Sunflower Oil");
        add("fluid_type.thermal_extra.flux_infused_oil", "Flux Infused Oil");
        add("fluid_type.thermal_extra.diesel", "Diesel");
        add("fluid_type.thermal_extra.polyolefin", "Polyolefin");
        add("fluid_type.thermal_extra.raw_aluminum", "Molten Raw Aluminum");
        add("fluid_type.thermal_extra.raw_arcane_gold", "Molten Raw Arcane Gold");
        add("fluid_type.thermal_extra.raw_copper", "Molten Raw Copper");
        add("fluid_type.thermal_extra.raw_gold", "Molten Raw Gold");
        add("fluid_type.thermal_extra.raw_iron", "Molten Raw Iron");
        add("fluid_type.thermal_extra.raw_lead", "Molten Raw Lead");
        add("fluid_type.thermal_extra.raw_nickel", "Molten Raw Nickel");
        add("fluid_type.thermal_extra.raw_osmium", "Molten Raw Osmium");
        add("fluid_type.thermal_extra.raw_silver", "Molten Raw Silver");
        add("fluid_type.thermal_extra.raw_tin", "Molten Raw Tin");
        add("fluid_type.thermal_extra.raw_uranium", "Molten Raw Uranium");
        add("fluid_type.thermal_extra.raw_zinc", "Molten Raw Zinc");

        addItem(ThermalExtraFluids.MOLTEN_SOUL_INFUSED.getBucket(), "Molten Soul Infused Bucket");
        addItem(ThermalExtraFluids.MOLTEN_SHELLITE.getBucket(), "Molten Shellite Bucket");
        addItem(ThermalExtraFluids.MOLTEN_TWINITE.getBucket(), "Molten Twinite Bucket");
        addItem(ThermalExtraFluids.MOLTEN_DRAGONSTEEL.getBucket(), "Molten Dragonsteel Bucket");
        addItem(ThermalExtraFluids.MOLTEN_ABYSSAL.getBucket(), "Molten Abyssal Bucket");
        addItem(ThermalExtraFluids.SUNFLOWER_OIL.getBucket(), "Sunflower Oil Bucket");
        addItem(ThermalExtraFluids.CRYSTALLIZED_SUNFLOWER_OIL.getBucket(), "Crystallized Sunflower Oil Bucket");
        addItem(ThermalExtraFluids.FLUX_INFUSED_OIL.getBucket(), "Flux Infused Oil Bucket");
        addItem(ThermalExtraFluids.REFINED_SUNFLOWER_OIL.getBucket(), "Refined Sunflower Oil Bucket");
        addItem(ThermalExtraFluids.DIESEL.getBucket(), "Flux Diesel Bucket");
        addItem(ThermalExtraFluids.POLYOLEFIN.getBucket(), "Polyolefin Bucket");

        addItem(ThermalExtraFluids.RAW_ALUMINUM.getBucket(), "Raw Aluminum Bucket");
        addItem(ThermalExtraFluids.RAW_ARCANE_GOLD.getBucket(), "Raw Arcane Gold Bucket");
        addItem(ThermalExtraFluids.RAW_COPPER.getBucket(), "Raw Copper Bucket");
        addItem(ThermalExtraFluids.RAW_GOLD.getBucket(), "Raw Gold Bucket");
        addItem(ThermalExtraFluids.RAW_IRON.getBucket(), "Raw Iron Bucket");
        addItem(ThermalExtraFluids.RAW_LEAD.getBucket(), "Raw Lead Bucket");
        addItem(ThermalExtraFluids.RAW_NICKEL.getBucket(), "Raw Nickel Bucket");
        addItem(ThermalExtraFluids.RAW_OSMIUM.getBucket(), "Raw Osmium Bucket");
        addItem(ThermalExtraFluids.RAW_SILVER.getBucket(), "Raw Silver Bucket");
        addItem(ThermalExtraFluids.RAW_TIN.getBucket(), "Raw Tin Bucket");
        addItem(ThermalExtraFluids.RAW_URANIUM.getBucket(), "Raw Uranium Bucket");
        addItem(ThermalExtraFluids.RAW_ZINC.getBucket(), "Raw Zinc Bucket");

        addItem(ThermalExtraItems.AUGMENT_TEMPLATE, "Smithing Template");

        for(EnumAugment e: EnumAugment.values()) {
            for(ExtraAugmentType type: ExtraAugmentType.VALUES) {
                addItem(ThermalExtraItems.AUGMENTS.get(e).get(type), capitalize(type.name().toLowerCase(Locale.ROOT))+ " " + e.getName());
            }
        }

        // items and blocks
        addBlock(ThermalExtraBlocks.DYNAMO_COLD, "Frost Dynamo");
        addBlock(ThermalExtraBlocks.BLOCKS.getSup("advanced_refinery"), "Adv Refinery");
        addBlock(ThermalExtraBlocks.BLOCKS.getSup("nitratic_igniter"), "Nitratic Igniter");
        addBlock(ThermalExtraBlocks.BLOCKS.getSup("fluid_mixer"), "Fluid Mixer");
        addBlock(ThermalExtraBlocks.BLOCKS.getSup("component_assembly"), "Component Assembly");
        addBlock(ThermalExtraBlocks.BLOCKS.getSup("endothermic_dehydrator"), "Endothermic Dehydrator");
        addBlock(ThermalExtraBlocks.BLOCKS.getSup("device_lava_gen"), "Magmatic Accumulator");

        // jerky
        addItem(ThermalExtraItems.BEEF_JERKY, "Beef Jerky");
        addItem(ThermalExtraItems.CHICKEN_JERKY, "Chicken Jerky");
        addItem(ThermalExtraItems.COD_JERKY, "Cod Jerky");
        addItem(ThermalExtraItems.MUTTON_JERKY, "Mutton Jerky");
        addItem(ThermalExtraItems.PORK_JERKY, "Pork Jerky");
        addItem(ThermalExtraItems.RABBIT_JERKY, "Rabbit Jerky");
        addItem(ThermalExtraItems.SALMON_JERKY, "Salmon Jerky");

        // ore chunks
        addItem(ThermalExtraItems.COPPER_ORE_CHUNK, "Copper Ore Chunk");
        addItem(ThermalExtraItems.IRON_ORE_CHUNK, "Iron Ore Chunk");
        addItem(ThermalExtraItems.GOLD_ORE_CHUNK, "Gold Ore Chunk");
        addItem(ThermalExtraItems.TIN_ORE_CHUNK, "Tin Ore Chunk");
        addItem(ThermalExtraItems.LEAD_ORE_CHUNK, "Lead Ore Chunk");
        addItem(ThermalExtraItems.SILVER_ORE_CHUNK, "Silver Ore Chunk");
        addItem(ThermalExtraItems.NICKEL_ORE_CHUNK, "Nickel Ore Chunk");
        addItem(ThermalExtraItems.ALUMINUM_ORE_CHUNK, "Aluminum Ore Chunk");
        addItem(ThermalExtraItems.URANIUM_ORE_CHUNK, "Uranium Ore Chunk");
        addItem(ThermalExtraItems.OSMIUM_ORE_CHUNK, "Osmium Ore Chunk");
        addItem(ThermalExtraItems.ARCANE_GOLD_ORE_CHUNK, "Arcane Gold Ore Chunk");
        addItem(ThermalExtraItems.ZINC_ORE_CHUNK, "Zinc Ore Chunk");

        addItem(ThermalExtraItems.ARCANE_GOLD_DUST, "Arcane Gold Dust");
        addItem(ThermalExtraItems.ZINC_DUST, "Zinc Dust");
        addItem(ThermalExtraItems.ANCIENT_DUST, "Ancient Dust");
        addItem(ThermalExtraItems.OBSIDIAN_DUST, "Obsidian Dust");
        addItem(ThermalExtraItems.AMETHYST_DUST, "Amethyst Dust");
        addItem(ThermalExtraItems.SOUL_SAND_DUST, "Soul Sand Dust");
        addItem(ThermalExtraItems.STICKY_BALL, "Sticky Ball");
        addItem(ThermalExtraItems.CHILLER_PLATE_CAST, "Plate Cast");
        addItem(ThermalExtraItems.POLYOLEFIN_PLATE, "Polyolefin Plate");

        addItem(ThermalExtraItems.COPPER_ROD, "Copper Rod");
        addItem(ThermalExtraItems.IRON_ROD, "Iron Rod");
        addItem(ThermalExtraItems.GOLD_ROD, "Gold Rod");
        addItem(ThermalExtraItems.DIAMOND_ROD, "Diamond Rod");
        addItem(ThermalExtraItems.NETHERITE_ROD, "Netherite Rod");
        addItem(ThermalExtraItems.EMERALD_ROD, "Emerald Rod");
        addItem(ThermalExtraItems.LEAD_ROD, "Lead Rod");
        addItem(ThermalExtraItems.TIN_ROD, "Tin Rod");
        addItem(ThermalExtraItems.SILVER_ROD, "Silver Rod");
        addItem(ThermalExtraItems.NICKEL_ROD, "Nickel Rod");
        addItem(ThermalExtraItems.BRONZE_ROD, "Bronze Rod");
        addItem(ThermalExtraItems.ELECTRUM_ROD, "Electrum Rod");
        addItem(ThermalExtraItems.CONSTANTAN_ROD, "Constantan Rod");
        addItem(ThermalExtraItems.INVAR_ROD, "Invar Rod");
        addItem(ThermalExtraItems.SIGNALUM_ROD, "Signalum Rod");
        addItem(ThermalExtraItems.LUMIUM_ROD, "Lumium Rod");
        addItem(ThermalExtraItems.ENDERIUM_ROD, "Enderium Rod");

        addTool(ThermalExtraItems.SIGNALUM_SET, "Signalum");
        addTool(ThermalExtraItems.LUMIUM_SET, "Lumium");
        addTool(ThermalExtraItems.ENDERIUM_SET, "Enderium");

        addBlock(ThermalExtraBlocks.SOUL_INFUSED_BLOCK, "Soul Infused Block");
        addBlock(ThermalExtraBlocks.SOUL_INFUSED_GLASS, "Soul Infused Glass");
        addItem(ThermalExtraItems.SOUL_INFUSED_INGOT, "Soul Infused ingot");
        addItem(ThermalExtraItems.SOUL_INFUSED_DUST, "Soul Infused dust");
        addItem(ThermalExtraItems.SOUL_INFUSED_COIN, "Soul Infused Coin");
        addItem(ThermalExtraItems.SOUL_INFUSED_GEAR, "Soul Infused Gear");
        addItem(ThermalExtraItems.SOUL_INFUSED_PLATE, "Soul Infused Plate");
        addItem(ThermalExtraItems.SOUL_INFUSED_NUGGET, "Soul Infused nugget");
        addItem(ThermalExtraItems.SOUL_INFUSED_ROD, "Soul Infused Rod");
        addTool(ThermalExtraItems.SOUL_INFUSED_SET, "Soul Infused");

        addBlock(ThermalExtraBlocks.SHELLITE_BLOCK, "Shellite Block");
        addBlock(ThermalExtraBlocks.SHELLITE_GLASS, "Shellite Glass");
        addItem(ThermalExtraItems.SHELLITE_INGOT, "Shellite ingot");
        addItem(ThermalExtraItems.SHELLITE_DUST, "Shellite dust");
        addItem(ThermalExtraItems.SHELLITE_COIN, "Shellite Coin");
        addItem(ThermalExtraItems.SHELLITE_GEAR, "Shellite Gear");
        addItem(ThermalExtraItems.SHELLITE_PLATE, "Shellite Plate");
        addItem(ThermalExtraItems.SHELLITE_NUGGET, "Shellite nugget");
        addItem(ThermalExtraItems.SHELLITE_ROD, "Shellite Rod");
        addTool(ThermalExtraItems.SHELLITE_SET, "Shellite");

        addBlock(ThermalExtraBlocks.TWINITE_BLOCK, "Twinite Block");
        addBlock(ThermalExtraBlocks.TWINITE_GLASS, "Twinite Glass");
        addItem(ThermalExtraItems.TWINITE_INGOT, "Twinite ingot");
        addItem(ThermalExtraItems.TWINITE_DUST, "Twinite dust");
        addItem(ThermalExtraItems.TWINITE_COIN, "Twinite Coin");
        addItem(ThermalExtraItems.TWINITE_GEAR, "Twinite Gear");
        addItem(ThermalExtraItems.TWINITE_PLATE, "Twinite Plate");
        addItem(ThermalExtraItems.TWINITE_NUGGET, "Twinite nugget");
        addItem(ThermalExtraItems.TWINITE_ROD, "Twinite Rod");
        addTool(ThermalExtraItems.TWINITE_SET, "Twinite");

        addBlock(ThermalExtraBlocks.DRAGONSTEEL_BLOCK, "Dragonsteel Block");
        addBlock(ThermalExtraBlocks.DRAGONSTEEL_GLASS, "Dragonsteel Glass");
        addItem(ThermalExtraItems.DRAGONSTEEL_INGOT, "Dragonsteel ingot");
        addItem(ThermalExtraItems.DRAGONSTEEL_DUST, "Dragonsteel dust");
        addItem(ThermalExtraItems.DRAGONSTEEL_COIN, "Dragonsteel Coin");
        addItem(ThermalExtraItems.DRAGONSTEEL_GEAR, "Dragonsteel Gear");
        addItem(ThermalExtraItems.DRAGONSTEEL_PLATE, "Dragonsteel Plate");
        addItem(ThermalExtraItems.DRAGONSTEEL_NUGGET, "Dragonsteel nugget");
        addItem(ThermalExtraItems.DRAGONSTEEL_ROD, "Dragonsteel Rod");
        addTool(ThermalExtraItems.DRAGONSTEEL_SET, "Dragonsteel");

        addBlock(ThermalExtraBlocks.ABYSSAL_BLOCK, "Abyssal Block");
        addBlock(ThermalExtraBlocks.ABYSSAL_GLASS, "Abyssal Glass");
        addItem(ThermalExtraItems.ABYSSAL_INGOT, "Abyssal ingot");
        addItem(ThermalExtraItems.ABYSSAL_DUST, "Abyssal dust");
        addItem(ThermalExtraItems.ABYSSAL_COIN, "Abyssal Coin");
        addItem(ThermalExtraItems.ABYSSAL_GEAR, "Abyssal Gear");
        addItem(ThermalExtraItems.ABYSSAL_PLATE, "Abyssal Plate");
        addItem(ThermalExtraItems.ABYSSAL_NUGGET, "Abyssal nugget");
        addItem(ThermalExtraItems.ABYSSAL_ROD, "Abyssal Rod");
        addTool(ThermalExtraItems.ABYSSAL_SET, "Abyssal");

        addItem(ThermalExtraItems.PRESS_ROD_DIE, "Rod Die");

        // augments
        addItem(ThermalExtraItems.INTEGRAL_COMPONENT, "Dragonsteel Integral Component");
        addItem(ThermalExtraItems.ABYSSAL_INTEGRAL_COMPONENT, "Abyssal Integral Component");
        add("thermal_extra.augment.upgrade", "Improves base attributes. Other augments may be more effective as a result.");

        addItem(ThermalExtraItems.AV_ITEM_FILTER_AUGMENT, "Advanced Item Filter Augment");
    }

    private void addTool(ToolSetObject toolSet, String metalName) {
        addItem(toolSet.axe(), metalName+ " Axe");
        addItem(toolSet.pickaxe(), metalName+ " Pickaxe");
        addItem(toolSet.shovel(), metalName+ " Shovel");
        addItem(toolSet.hoe(), metalName+ " Hoe");
        addItem(toolSet.sword(), metalName+ " Sword");
        addItem(toolSet.excavator(), metalName+ " Exacavator");
        addItem(toolSet.hammer(), metalName+ " Hammer");
        addItem(toolSet.knife(), metalName+ " Knife");
        addItem(toolSet.sickle(), metalName+ " Sickle");
        addItem(toolSet.helmet(), metalName+ " Helmet");
        addItem(toolSet.chestplate(), metalName+ " Chestplate");
        addItem(toolSet.leggings(), metalName+ " Leggings");
        addItem(toolSet.boots(), metalName+ " Boots");
    }

    public String capitalize(String input) {
        if(input.contains("_")) {
            String[] split = input.split("_");
            StringBuilder output = new StringBuilder();
            for(String s : split) {
                output.append(StringUtils.capitalize(s));
                output.append(" ");
            }
            return output.toString().trim();
        }
        return StringUtils.capitalize(input);
    }
}
