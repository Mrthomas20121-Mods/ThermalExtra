package mrthomas20121.thermal_extra.data;

import cofh.lib.init.data.ItemModelProviderCoFH;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import mrthomas20121.thermal_extra.item.ToolSetObject;
import mrthomas20121.thermal_extra.item.augment.EnumAugment;
import mrthomas20121.thermal_extra.item.augment.ExtraAugmentType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;

public class ExtraModelGen extends ItemModelProviderCoFH {

    public ExtraModelGen(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, ThermalExtra.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        itemModel(ThermalExtraItems.BEEF_JERKY);
        itemModel(ThermalExtraItems.CHICKEN_JERKY);
        itemModel(ThermalExtraItems.COD_JERKY);
        itemModel(ThermalExtraItems.MUTTON_JERKY);
        itemModel(ThermalExtraItems.PORK_JERKY);
        itemModel(ThermalExtraItems.RABBIT_JERKY);
        itemModel(ThermalExtraItems.SALMON_JERKY);
        itemModel(ThermalExtraItems.AUGMENT_TEMPLATE);

        itemModel(ThermalExtraItems.ANCIENT_DUST);
        itemModel(ThermalExtraItems.OBSIDIAN_DUST);
        itemModel(ThermalExtraItems.PRESS_ROD_DIE);

        itemModel(ThermalExtraItems.SOUL_INFUSED_ROD);
        itemModel(ThermalExtraItems.TWINITE_ROD);
        itemModel(ThermalExtraItems.SHELLITE_ROD);
        itemModel(ThermalExtraItems.DRAGONSTEEL_ROD);
        itemModel(ThermalExtraItems.ABYSSAL_ROD);
        itemModel(ThermalExtraItems.COPPER_ROD);
        itemModel(ThermalExtraItems.IRON_ROD);
        itemModel(ThermalExtraItems.GOLD_ROD);
        itemModel(ThermalExtraItems.DIAMOND_ROD);
        itemModel(ThermalExtraItems.EMERALD_ROD);
        itemModel(ThermalExtraItems.NETHERITE_ROD);
        itemModel(ThermalExtraItems.LEAD_ROD);
        itemModel(ThermalExtraItems.TIN_ROD);
        itemModel(ThermalExtraItems.SILVER_ROD);
        itemModel(ThermalExtraItems.NICKEL_ROD);
        itemModel(ThermalExtraItems.BRONZE_ROD);
        itemModel(ThermalExtraItems.ELECTRUM_ROD);
        itemModel(ThermalExtraItems.CONSTANTAN_ROD);
        itemModel(ThermalExtraItems.INVAR_ROD);
        itemModel(ThermalExtraItems.SIGNALUM_ROD);
        itemModel(ThermalExtraItems.LUMIUM_ROD);
        itemModel(ThermalExtraItems.ENDERIUM_ROD);

        itemModel(ThermalExtraItems.COPPER_ORE_CHUNK);
        itemModel(ThermalExtraItems.IRON_ORE_CHUNK);
        itemModel(ThermalExtraItems.GOLD_ORE_CHUNK);
        itemModel(ThermalExtraItems.TIN_ORE_CHUNK);
        itemModel(ThermalExtraItems.LEAD_ORE_CHUNK);
        itemModel(ThermalExtraItems.SILVER_ORE_CHUNK);
        itemModel(ThermalExtraItems.NICKEL_ORE_CHUNK);
        itemModel(ThermalExtraItems.ALUMINUM_ORE_CHUNK);
        itemModel(ThermalExtraItems.URANIUM_ORE_CHUNK);
        itemModel(ThermalExtraItems.OSMIUM_ORE_CHUNK);
        itemModel(ThermalExtraItems.ARCANE_GOLD_ORE_CHUNK);
        itemModel(ThermalExtraItems.ZINC_ORE_CHUNK);

        for(EnumAugment e: EnumAugment.values()) {
            for (ExtraAugmentType type : ExtraAugmentType.VALUES) {
                itemModel(ThermalExtraItems.AUGMENTS.get(e).get(type),
                        new ResourceLocation(ThermalExtra.MOD_ID, "item/%s/%s".formatted(type.name().toLowerCase(Locale.ROOT), e.name().toLowerCase(Locale.ROOT))));
            }
        }

        toolset(ThermalExtraItems.SIGNALUM_SET);
        toolset(ThermalExtraItems.LUMIUM_SET);
        toolset(ThermalExtraItems.ENDERIUM_SET);

        itemModel(ThermalExtraItems.SOUL_INFUSED_INGOT);
        itemModel(ThermalExtraItems.SOUL_INFUSED_GEAR);
        itemModel(ThermalExtraItems.SOUL_INFUSED_DUST);
        itemModel(ThermalExtraItems.SOUL_INFUSED_NUGGET);
        toolset(ThermalExtraItems.SOUL_INFUSED_SET);

        itemModel(ThermalExtraItems.SHELLITE_INGOT);
        itemModel(ThermalExtraItems.SHELLITE_GEAR);
        itemModel(ThermalExtraItems.SHELLITE_DUST);
        itemModel(ThermalExtraItems.SHELLITE_NUGGET);
        toolset(ThermalExtraItems.SHELLITE_SET);

        itemModel(ThermalExtraItems.TWINITE_INGOT);
        itemModel(ThermalExtraItems.TWINITE_GEAR);
        itemModel(ThermalExtraItems.TWINITE_DUST);
        itemModel(ThermalExtraItems.TWINITE_NUGGET);
        toolset(ThermalExtraItems.TWINITE_SET);

        itemModel(ThermalExtraItems.DRAGONSTEEL_GEAR);
        itemModel(ThermalExtraItems.DRAGONSTEEL_INGOT);
        itemModel(ThermalExtraItems.DRAGONSTEEL_DUST);
        itemModel(ThermalExtraItems.DRAGONSTEEL_NUGGET);
        toolset(ThermalExtraItems.DRAGONSTEEL_SET);

        itemModel(ThermalExtraItems.ABYSSAL_GEAR);
        itemModel(ThermalExtraItems.ABYSSAL_INGOT);
        itemModel(ThermalExtraItems.ABYSSAL_DUST);
        itemModel(ThermalExtraItems.ABYSSAL_NUGGET);
        toolset(ThermalExtraItems.ABYSSAL_SET);

        itemModel(ThermalExtraItems.ARCANE_GOLD_DUST);
        itemModel(ThermalExtraItems.ZINC_DUST);
        itemModel(ThermalExtraItems.SOUL_SAND_DUST);
        itemModel(ThermalExtraItems.AMETHYST_DUST);
        itemModel(ThermalExtraItems.STICKY_BALL);
        itemModel(ThermalExtraItems.CHILLER_PLATE_CAST);

        itemModel(ThermalExtraItems.AV_ITEM_FILTER_AUGMENT);

        itemModel(ThermalExtraFluids.CRYSTALLIZED_SUNFLOWER_OIL.getBucket());
        itemModel(ThermalExtraFluids.SUNFLOWER_OIL.getBucket());
        itemModel(ThermalExtraFluids.CRYSTALLIZED_SUNFLOWER_OIL.getBucket());
        itemModel(ThermalExtraFluids.REFINED_SUNFLOWER_OIL.getBucket());
        itemModel(ThermalExtraFluids.MOLTEN_ABYSSAL.getBucket());
        itemModel(ThermalExtraFluids.MOLTEN_SOUL_INFUSED.getBucket());
        itemModel(ThermalExtraFluids.MOLTEN_SHELLITE.getBucket());
        itemModel(ThermalExtraFluids.MOLTEN_TWINITE.getBucket());
        itemModel(ThermalExtraFluids.MOLTEN_DRAGONSTEEL.getBucket());
        itemModel(ThermalExtraFluids.FLUX_INFUSED_OIL.getBucket());
        itemModel(ThermalExtraFluids.DIESEL.getBucket());
        itemModel(ThermalExtraFluids.POLYOLEFIN.getBucket());

        itemModel(ThermalExtraFluids.RAW_ALUMINUM.getBucket());
        itemModel(ThermalExtraFluids.RAW_ARCANE_GOLD.getBucket());
        itemModel(ThermalExtraFluids.RAW_COPPER.getBucket());
        itemModel(ThermalExtraFluids.RAW_GOLD.getBucket());
        itemModel(ThermalExtraFluids.RAW_IRON.getBucket());
        itemModel(ThermalExtraFluids.RAW_LEAD.getBucket());
        itemModel(ThermalExtraFluids.RAW_NICKEL.getBucket());
        itemModel(ThermalExtraFluids.RAW_OSMIUM.getBucket());
        itemModel(ThermalExtraFluids.RAW_SILVER.getBucket());
        itemModel(ThermalExtraFluids.RAW_TIN.getBucket());
        itemModel(ThermalExtraFluids.RAW_URANIUM.getBucket());
        itemModel(ThermalExtraFluids.RAW_ZINC.getBucket());

        blockItem(ThermalExtraBlocks.DYNAMO_COLD);
    }

    private void toolset(ToolSetObject set) {
        handheld(set.axe());
        handheld(set.pickaxe());
        handheld(set.shovel());
        handheld(set.hoe());
        handheld(set.sword());
        handheld(set.excavator());
        handheld(set.hammer());
        handheld(set.knife());
        handheld(set.sickle());
        generated(set.helmet());
        generated(set.chestplate());
        generated(set.leggings());
        generated(set.boots());
    }

    public void itemModel(RegistryObject<? extends Item> registryObject) {
        this.itemModel(registryObject, "item/generated");
    }

    private void itemModel(RegistryObject<? extends Item> registryObject, String model) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath());
        singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLocation);
    }

    public void itemModel(RegistryObject<? extends Item> registryObject, ResourceLocation textureLoc) {
        this.itemModel(registryObject, "item/generated", textureLoc);
    }

    private void itemModel(RegistryObject<? extends Item> registryObject, String model, ResourceLocation textureLoc) {
        ResourceLocation id = registryObject.getId();
        singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLoc);
    }
}
