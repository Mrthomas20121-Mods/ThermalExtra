package mrthomas20121.thermal_extra.datagen;

import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ExtraLangGen extends LanguageProvider {

    public ExtraLangGen(PackOutput gen) {
        super(gen, ThermalExtra.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        add("info.thermal_extra.item_filter", "Advanced Item Filter");
        add("info.thermal_extra.dynamo_frost.0", "Generate RF from Cold Items.");
        add("block.thermal_extra.dynamo_frost.keyword", "blizz cube snow ice packed blue cold frost frozen engine generator");
        add("info.thermal_extra.machine_metal_infuser", "Convert a metallic item into another by putting it in a fluid.");
        add("info.thermal_extra.machine_nitratic_igniter", "Create an Item by exploding other items together.");
        add("info.thermal_extra.machine_fluid_mixer", "Mix fluids together to create other fluids");
        add("info.thermal_extra.require_catalyst", "Catalyst is required.");
        add("info.thermal_extra.lava_gen", "Magmatic Accumulator generate Lava if it has 2 or more adjacent lava blocks.");
        add("info.thermal_extra.lava_gen_nether", "Magmatic Accumulator only works in the nether.");

        // creative tabs
        add("creative_tab.thermal_extra.resources", "Thermal Extra: Resources");
        add("creative_tab.thermal_extra.augments", "Thermal Extra: Augments");
        add("creative_tab.thermal_extra.machines", "Thermal Extra: Machines");

        // fluids and buckets
        add("fluid_type.thermal_extra.soul_infused", "Molten Soul Infused");
        add("fluid_type.thermal_extra.shellite", "Molten Shellite");
        add("fluid_type.thermal_extra.twinite", "Molten Twinite");
        add("fluid_type.thermal_extra.dragonsteel", "Molten Dragonsteel");
        add("fluid_type.thermal_extra.sunflower_oil", "Sunflower Oil");
        add("fluid_type.thermal_extra.crystallized_sunflower_oil", "Crystallized Sunflower Oil");
        add("fluid_type.thermal_extra.refined_sunflower_oil", "Refined Sunflower Oil");
        add("fluid_type.thermal_extra.flux_infused_oil", "Flux Infused Oil");
        add("fluid_type.thermal_extra.flux_diesel", "Flux Diesel");
        add("fluid_type.thermal_extra.biodiesel", "Biodiesel");
        add("fluid_type.thermal_extra.liquid_biomass", "Liquid Biomass");
        add("fluid_type.thermal_extra.polyolefin", "Polyolefin");
        add("fluid_type.thermal_extra.super_biodiesel", "Super Biodiesel");
        addItem(ThermalExtraFluids.soul_infused.getBucket(), "Molten Soul Infused Bucket");
        addItem(ThermalExtraFluids.shellite.getBucket(), "Molten Shellite Bucket");
        addItem(ThermalExtraFluids.twinite.getBucket(), "Molten Twinite Bucket");
        addItem(ThermalExtraFluids.dragonsteel.getBucket(), "Molten Dragonsteel Bucket");
        addItem(ThermalExtraFluids.sunflower_oil.getBucket(), "Sunflower Oil Bucket");
        addItem(ThermalExtraFluids.crystallized_sunflower_oil.getBucket(), "Crystallized Sunflower Oil Bucket");
        addItem(ThermalExtraFluids.flux_infused_oil.getBucket(), "Flux Infused Oil Bucket");
        addItem(ThermalExtraFluids.refined_sunflower_oil.getBucket(), "Refined Sunflower Oil Bucket");
        addItem(ThermalExtraFluids.flux_diesel.getBucket(), "Flux Diesel Bucket");
        addItem(ThermalExtraFluids.biodiesel.getBucket(), "Biodiesel Bucket");
        addItem(ThermalExtraFluids.liquid_biomass.getBucket(), "Liquid Biomass Bucket");
        addItem(ThermalExtraFluids.polyolefin.getBucket(), "Polyolefin Bucket");
        addItem(ThermalExtraFluids.super_biodiesel.getBucket(), "Super Biodiesel Bucket");

        // items and blocks
        addBlock(ThermalExtraBlocks.DYNAMO_COLD, "Frost Dynamo");
        addBlock(ThermalExtraBlocks.BLOCKS.getSup("metal_infuser"), "Metal Infuser");
        addBlock(ThermalExtraBlocks.BLOCKS.getSup("advanced_refinery"), "Adv Refinery");
        addBlock(ThermalExtraBlocks.BLOCKS.getSup("nitratic_igniter"), "Nitratic Igniter");
        addBlock(ThermalExtraBlocks.BLOCKS.getSup("fluid_mixer"), "Fluid Mixer");
        addBlock(ThermalExtraBlocks.BLOCKS.getSup("component_assembly"), "Component Assembly");
        addBlock(ThermalExtraBlocks.BLOCKS.getSup("device_lava_gen"), "Magmatic Accumulator");

        // ore chunks
        addItem(ThermalExtraItems.copper_ore_chunk, "Copper Ore Chunk");
        addItem(ThermalExtraItems.iron_ore_chunk, "Iron Ore Chunk");
        addItem(ThermalExtraItems.gold_ore_chunk, "Gold Ore Chunk");
        addItem(ThermalExtraItems.tin_ore_chunk, "Tin Ore Chunk");
        addItem(ThermalExtraItems.lead_ore_chunk, "Lead Ore Chunk");
        addItem(ThermalExtraItems.silver_ore_chunk, "Silver Ore Chunk");
        addItem(ThermalExtraItems.nickel_ore_chunk, "Nickel Ore Chunk");

        addItem(ThermalExtraItems.amethyst_dust, "Amethyst Dust");
        addItem(ThermalExtraItems.soul_sand_dust, "Soul Sand Dust");
        addItem(ThermalExtraItems.sticky_ball, "Sticky Ball");
        addItem(ThermalExtraItems.chiller_plate_cast, "Plate Cast");
        addItem(ThermalExtraItems.polyolefin_plate, "Polyolefin Plate");

        addBlock(ThermalExtraBlocks.SOUL_INFUSED_BLOCK, "Soul Infused Block");
        addBlock(ThermalExtraBlocks.SOUL_INFUSED_GLASS, "Soul Infused Glass");
        addItem(ThermalExtraItems.soul_infused_ingot, "Soul Infused ingot");
        addItem(ThermalExtraItems.soul_infused_dust, "Soul Infused dust");
        addItem(ThermalExtraItems.soul_infused_coin, "Soul Infused Coin");
        addItem(ThermalExtraItems.soul_infused_gear, "Soul Infused Gear");
        addItem(ThermalExtraItems.soul_infused_plate, "Soul Infused Plate");
        addItem(ThermalExtraItems.soul_infused_nugget, "Soul Infused nugget");

        addBlock(ThermalExtraBlocks.SHELLITE_BLOCK, "Shellite Block");
        addBlock(ThermalExtraBlocks.SHELLITE_GLASS, "Shellite Glass");
        addItem(ThermalExtraItems.shellite_ingot, "Shellite ingot");
        addItem(ThermalExtraItems.shellite_dust, "Shellite dust");
        addItem(ThermalExtraItems.shellite_coin, "Shellite Coin");
        addItem(ThermalExtraItems.shellite_gear, "Shellite Gear");
        addItem(ThermalExtraItems.shellite_plate, "Shellite Plate");
        addItem(ThermalExtraItems.shellite_nugget, "Shellite nugget");

        addBlock(ThermalExtraBlocks.TWINITE_BLOCK, "Twinite Block");
        addBlock(ThermalExtraBlocks.TWINITE_GLASS, "Twinite Glass");
        addItem(ThermalExtraItems.twinite_ingot, "Twinite ingot");
        addItem(ThermalExtraItems.twinite_dust, "Twinite dust");
        addItem(ThermalExtraItems.twinite_coin, "Twinite Coin");
        addItem(ThermalExtraItems.twinite_gear, "Twinite Gear");
        addItem(ThermalExtraItems.twinite_plate, "Twinite Plate");
        addItem(ThermalExtraItems.twinite_nugget, "Twinite nugget");

        addBlock(ThermalExtraBlocks.DRAGONSTEEL_BLOCK, "Dragonsteel Block");
        addBlock(ThermalExtraBlocks.DRAGONSTEEL_GLASS, "Dragonsteel Glass");
        addItem(ThermalExtraItems.dragon_steel_ingot, "Dragonsteel ingot");
        addItem(ThermalExtraItems.dragon_steel_dust, "Dragonsteel dust");
        addItem(ThermalExtraItems.dragon_steel_coin, "Dragonsteel Coin");
        addItem(ThermalExtraItems.dragon_steel_gear, "Dragonsteel Gear");
        addItem(ThermalExtraItems.dragon_steel_plate, "Dragonsteel Plate");
        addItem(ThermalExtraItems.dragon_steel_nugget, "Dragonsteel nugget");

        // augments
        addItem(ThermalExtraItems.integral_component, "Draconic Integral Component");
        add("thermal_extra.augment.upgrade", "Improves base attributes. Other augments may be more effective as a result.");

        addItem(ThermalExtraItems.av_item_filter_augment, "Advanced Item Filter Augment");

        addItem(ThermalExtraItems.area_radius_augment_1, "Soul Infused Radial Enhancement");
        addItem(ThermalExtraItems.area_radius_augment_2, "Enderium Radial Enhancement");
        addItem(ThermalExtraItems.area_radius_augment_3, "Shellite Radial Enhancement");
        addItem(ThermalExtraItems.area_radius_augment_4, "Twinite Radial Enhancement");

        addItem(ThermalExtraItems.potion_amplifier_augment_1, "Soul Infused Alchemical Amplifier");
        addItem(ThermalExtraItems.potion_amplifier_augment_2, "Enderium Alchemical Amplifier");
        addItem(ThermalExtraItems.potion_amplifier_augment_3, "Shellite Alchemical Amplifier");
        addItem(ThermalExtraItems.potion_amplifier_augment_4, "Twinite Alchemical Amplifier");
        addItem(ThermalExtraItems.potion_amplifier_augment_5, "Dragonsteel Alchemical Amplifier");

        addItem(ThermalExtraItems.potion_duration_augment_1, "Soul Infused Alchemical Extender");
        addItem(ThermalExtraItems.potion_duration_augment_2, "Enderium Alchemical Extender");
        addItem(ThermalExtraItems.potion_duration_augment_3, "Shellite Alchemical Extender");
        addItem(ThermalExtraItems.potion_duration_augment_4, "Twinite Alchemical Extender");
        addItem(ThermalExtraItems.potion_duration_augment_5, "Dragonsteel Alchemical Extender");

        addItem(ThermalExtraItems.dynamo_fuel_augment_1, "Soul Infused Multi Cycle Injectors");
        addItem(ThermalExtraItems.dynamo_fuel_augment_2, "Enderium Multi Cycle Injectors");
        addItem(ThermalExtraItems.dynamo_fuel_augment_3, "Shellite Multi Cycle Injectors");
        addItem(ThermalExtraItems.dynamo_fuel_augment_4, "Twinite Multi Cycle Injectors");

        addItem(ThermalExtraItems.dynamo_output_augment_1, "Soul Infused Auxiliary Reaction Chamber");
        addItem(ThermalExtraItems.dynamo_output_augment_2, "Enderium Auxiliary Reaction Chamber");
        addItem(ThermalExtraItems.dynamo_output_augment_3, "Shellite Auxiliary Reaction Chamber");
        addItem(ThermalExtraItems.dynamo_output_augment_4, "Twinite Auxiliary Reaction Chamber");

        addItem(ThermalExtraItems.machine_output_augment_1, "Soul Infused Auxiliary Process Sieve");
        addItem(ThermalExtraItems.machine_output_augment_2, "Enderium Auxiliary Process Sieve");
        addItem(ThermalExtraItems.machine_output_augment_3, "Shellite Auxiliary Process Sieve");

        addItem(ThermalExtraItems.machine_catalyst_augment_1, "Soul Infused Catalytic Relamation Chamber");
        addItem(ThermalExtraItems.machine_catalyst_augment_2, "Enderium Catalytic Relamation Chamber");
        addItem(ThermalExtraItems.machine_catalyst_augment_3, "Shellite Catalytic Relamation Chamber");

        addItem(ThermalExtraItems.machine_efficiency_augment_1, "Soul Infused Flux Efficiency");
        addItem(ThermalExtraItems.machine_efficiency_augment_2, "Enderium Flux Efficiency");
        addItem(ThermalExtraItems.machine_efficiency_augment_3, "Shellite Flux Efficiency");
        addItem(ThermalExtraItems.machine_efficiency_augment_4, "Twinite Flux Efficiency");

        addItem(ThermalExtraItems.machine_speed_augment_1, "Soul Infused Flux Linkage Amplifier");
        addItem(ThermalExtraItems.machine_speed_augment_2, "Enderium Flux Linkage Amplifier");
        addItem(ThermalExtraItems.machine_speed_augment_3, "Shellite Flux Linkage Amplifier");
        addItem(ThermalExtraItems.machine_speed_augment_4, "Twinite Flux Linkage Amplifier");

        addItem(ThermalExtraItems.tank_augment_1, "Soul Infused Expanded Tank Construction");
        addItem(ThermalExtraItems.tank_augment_2, "Enderium Expanded Tank Construction");
        addItem(ThermalExtraItems.tank_augment_3, "Shellite Expanded Tank Construction");
        addItem(ThermalExtraItems.tank_augment_4, "Twinite Expanded Tank Construction");
        addItem(ThermalExtraItems.tank_augment_5, "Dragonsteel Expanded Tank Construction");
        addItem(ThermalExtraItems.tank_augment_6, "Dragonsteel-Infused Expanded Tank Construction");

        addItem(ThermalExtraItems.rf_coil_augment_1, "Soul Infused Expanded RF Coil");
        addItem(ThermalExtraItems.rf_coil_augment_2, "Enderium Expanded RF Coil");
        addItem(ThermalExtraItems.rf_coil_augment_3, "Shellite Expanded RF Coil");
        addItem(ThermalExtraItems.rf_coil_augment_4, "Twinite Expanded RF Coil");
        addItem(ThermalExtraItems.rf_coil_augment_5, "Dragonsteel Expanded RF Coil");

        addItem(ThermalExtraItems.rf_coil_storage_augment_1, "Soul Infused Stabilized RF Coil");
        addItem(ThermalExtraItems.rf_coil_storage_augment_2, "Enderium Stabilized RF Coil");
        addItem(ThermalExtraItems.rf_coil_storage_augment_3, "Shellite Stabilized RF Coil");
        addItem(ThermalExtraItems.rf_coil_storage_augment_4, "Twinite Stabilized RF Coil");
        addItem(ThermalExtraItems.rf_coil_storage_augment_5, "Dragonsteel Stabilized RF Coil");

        addItem(ThermalExtraItems.rf_coil_xfer_augment_1, "Soul Infused High-Flux RF Coil");
        addItem(ThermalExtraItems.rf_coil_xfer_augment_2, "Enderium High-Flux RF Coil");
        addItem(ThermalExtraItems.rf_coil_xfer_augment_3, "Shellite High-Flux RF Coil");
        addItem(ThermalExtraItems.rf_coil_xfer_augment_4, "Twinite High-Flux RF Coil");
        addItem(ThermalExtraItems.rf_coil_xfer_augment_5, "Dragonsteel High-Flux RF Coil");
    }
}
