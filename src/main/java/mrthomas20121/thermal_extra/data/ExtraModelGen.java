package mrthomas20121.thermal_extra.data;

import cofh.lib.init.data.ItemModelProviderCoFH;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ExtraModelGen extends ItemModelProviderCoFH {

    public ExtraModelGen(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, ThermalExtra.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        itemModel(ThermalExtraItems.beef_jerky);
        itemModel(ThermalExtraItems.chicken_jerky);
        itemModel(ThermalExtraItems.cod_jerky);
        itemModel(ThermalExtraItems.mutton_jerky);
        itemModel(ThermalExtraItems.pork_jerky);
        itemModel(ThermalExtraItems.rabbit_jerky);
        itemModel(ThermalExtraItems.salmon_jerky);

        itemModel(ThermalExtraItems.copper_ore_chunk);
        itemModel(ThermalExtraItems.iron_ore_chunk);
        itemModel(ThermalExtraItems.gold_ore_chunk);
        itemModel(ThermalExtraItems.tin_ore_chunk);
        itemModel(ThermalExtraItems.lead_ore_chunk);
        itemModel(ThermalExtraItems.silver_ore_chunk);
        itemModel(ThermalExtraItems.nickel_ore_chunk);
        itemModel(ThermalExtraItems.aluminum_ore_chunk);
        itemModel(ThermalExtraItems.uranium_ore_chunk);
        itemModel(ThermalExtraItems.osmium_ore_chunk);
        itemModel(ThermalExtraItems.arcane_gold_ore_chunk);
        itemModel(ThermalExtraItems.zinc_ore_chunk);

        itemModel(ThermalExtraItems.dragon_steel_gear);
        itemModel(ThermalExtraItems.dragon_steel_ingot);
        itemModel(ThermalExtraItems.dragon_steel_dust);
        itemModel(ThermalExtraItems.dragon_steel_nugget);

        itemModel(ThermalExtraItems.soul_infused_ingot);
        itemModel(ThermalExtraItems.soul_infused_gear);
        itemModel(ThermalExtraItems.soul_infused_dust);
        itemModel(ThermalExtraItems.soul_infused_nugget);

        itemModel(ThermalExtraItems.shellite_ingot);
        itemModel(ThermalExtraItems.shellite_gear);
        itemModel(ThermalExtraItems.shellite_dust);
        itemModel(ThermalExtraItems.shellite_nugget);

        itemModel(ThermalExtraItems.twinite_ingot);
        itemModel(ThermalExtraItems.twinite_gear);
        itemModel(ThermalExtraItems.twinite_dust);
        itemModel(ThermalExtraItems.twinite_nugget);

        itemModel(ThermalExtraItems.soul_sand_dust);
        itemModel(ThermalExtraItems.amethyst_dust);
        itemModel(ThermalExtraItems.sticky_ball);
        itemModel(ThermalExtraItems.chiller_plate_cast);

        itemModel(ThermalExtraItems.av_item_filter_augment);

        itemModel(ThermalExtraItems.area_radius_augment_1);
        itemModel(ThermalExtraItems.area_radius_augment_2);
        itemModel(ThermalExtraItems.area_radius_augment_3);
        itemModel(ThermalExtraItems.area_radius_augment_4);

        itemModel(ThermalExtraItems.potion_amplifier_augment_1);
        itemModel(ThermalExtraItems.potion_amplifier_augment_2);
        itemModel(ThermalExtraItems.potion_amplifier_augment_3);
        itemModel(ThermalExtraItems.potion_amplifier_augment_4);
        itemModel(ThermalExtraItems.potion_amplifier_augment_5);

        itemModel(ThermalExtraItems.potion_duration_augment_1);
        itemModel(ThermalExtraItems.potion_duration_augment_2);
        itemModel(ThermalExtraItems.potion_duration_augment_3);
        itemModel(ThermalExtraItems.potion_duration_augment_4);
        itemModel(ThermalExtraItems.potion_duration_augment_5);

        itemModel(ThermalExtraItems.rf_coil_augment_1);
        itemModel(ThermalExtraItems.rf_coil_augment_2);
        itemModel(ThermalExtraItems.rf_coil_augment_3);
        itemModel(ThermalExtraItems.rf_coil_augment_4);
        itemModel(ThermalExtraItems.rf_coil_augment_5);

        itemModel(ThermalExtraItems.rf_coil_storage_augment_1);
        itemModel(ThermalExtraItems.rf_coil_storage_augment_2);
        itemModel(ThermalExtraItems.rf_coil_storage_augment_3);
        itemModel(ThermalExtraItems.rf_coil_storage_augment_4);
        itemModel(ThermalExtraItems.rf_coil_storage_augment_5);

        itemModel(ThermalExtraItems.rf_coil_xfer_augment_1);
        itemModel(ThermalExtraItems.rf_coil_xfer_augment_2);
        itemModel(ThermalExtraItems.rf_coil_xfer_augment_3);
        itemModel(ThermalExtraItems.rf_coil_xfer_augment_4);
        itemModel(ThermalExtraItems.rf_coil_xfer_augment_5);

        itemModel(ThermalExtraItems.tank_augment_1);
        itemModel(ThermalExtraItems.tank_augment_2);
        itemModel(ThermalExtraItems.tank_augment_3);
        itemModel(ThermalExtraItems.tank_augment_4);
        itemModel(ThermalExtraItems.tank_augment_5);
        itemModel(ThermalExtraItems.tank_augment_6);

        itemModel(ThermalExtraItems.machine_speed_augment_1);
        itemModel(ThermalExtraItems.machine_speed_augment_2);
        itemModel(ThermalExtraItems.machine_speed_augment_3);
        itemModel(ThermalExtraItems.machine_speed_augment_4);

        itemModel(ThermalExtraItems.machine_catalyst_augment_1);
        itemModel(ThermalExtraItems.machine_catalyst_augment_2);
        itemModel(ThermalExtraItems.machine_catalyst_augment_3);

        itemModel(ThermalExtraItems.machine_efficiency_augment_1);
        itemModel(ThermalExtraItems.machine_efficiency_augment_2);
        itemModel(ThermalExtraItems.machine_efficiency_augment_3);
        itemModel(ThermalExtraItems.machine_efficiency_augment_4);

        itemModel(ThermalExtraItems.machine_output_augment_1);
        itemModel(ThermalExtraItems.machine_output_augment_2);
        itemModel(ThermalExtraItems.machine_output_augment_3);

        itemModel(ThermalExtraItems.dynamo_fuel_augment_1);
        itemModel(ThermalExtraItems.dynamo_fuel_augment_2);
        itemModel(ThermalExtraItems.dynamo_fuel_augment_3);
        itemModel(ThermalExtraItems.dynamo_fuel_augment_4);

        itemModel(ThermalExtraItems.dynamo_output_augment_1);
        itemModel(ThermalExtraItems.dynamo_output_augment_2);
        itemModel(ThermalExtraItems.dynamo_output_augment_3);
        itemModel(ThermalExtraItems.dynamo_output_augment_4);

        itemModel(ThermalExtraFluids.crystallized_sunflower_oil.getBucket());
        itemModel(ThermalExtraFluids.sunflower_oil.getBucket());
        itemModel(ThermalExtraFluids.crystallized_sunflower_oil.getBucket());
        itemModel(ThermalExtraFluids.refined_sunflower_oil.getBucket());
        itemModel(ThermalExtraFluids.soul_infused.getBucket());
        itemModel(ThermalExtraFluids.shellite.getBucket());
        itemModel(ThermalExtraFluids.twinite.getBucket());
        itemModel(ThermalExtraFluids.dragonsteel.getBucket());
        itemModel(ThermalExtraFluids.flux_infused_oil.getBucket());
        itemModel(ThermalExtraFluids.flux_diesel.getBucket());
        itemModel(ThermalExtraFluids.biodiesel.getBucket());
        itemModel(ThermalExtraFluids.liquid_biomass.getBucket());
        itemModel(ThermalExtraFluids.polyolefin.getBucket());
        itemModel(ThermalExtraFluids.super_biodiesel.getBucket());

        itemModel(ThermalExtraFluids.raw_aluminum.getBucket());
        itemModel(ThermalExtraFluids.raw_arcane_gold.getBucket());
        itemModel(ThermalExtraFluids.raw_copper.getBucket());
        itemModel(ThermalExtraFluids.raw_gold.getBucket());
        itemModel(ThermalExtraFluids.raw_iron.getBucket());
        itemModel(ThermalExtraFluids.raw_lead.getBucket());
        itemModel(ThermalExtraFluids.raw_nickel.getBucket());
        itemModel(ThermalExtraFluids.raw_osmium.getBucket());
        itemModel(ThermalExtraFluids.raw_silver.getBucket());
        itemModel(ThermalExtraFluids.raw_tin.getBucket());
        itemModel(ThermalExtraFluids.raw_uranium.getBucket());
        itemModel(ThermalExtraFluids.raw_zinc.getBucket());

        blockItem(ThermalExtraBlocks.DYNAMO_COLD);
    }

    public void itemModel(RegistryObject<? extends Item> registryObject) {
        this.itemModel(registryObject, "item/generated");
    }

    public void itemModel(RegistryObject<? extends Item> registryObject, String model) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath());
        singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLocation);
    }
}
