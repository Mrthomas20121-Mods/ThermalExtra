package mrthomas20121.thermal_extra.init;

import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.item.ToolSetObject;
import mrthomas20121.thermal_extra.item.augment.EnumAugment;
import mrthomas20121.thermal_extra.item.augment.ExtraAugmentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ThermalExtraCreativeTabs {
    public static DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ThermalExtra.MOD_ID);

    private static void addToolSet(ToolSetObject set, CreativeModeTab.Output output) {
        output.acceptAll(set.getALLItems().stream().map(obj -> obj.get().asItem()).map(ItemStack::new).toList());
    }

    public static RegistryObject<CreativeModeTab> tab_augments = CREATIVE_TABS.register("augments", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ThermalExtraItems.INTEGRAL_COMPONENT.get()))
            .title(Component.translatable("creative_tab.thermal_extra.augments"))
            .displayItems((feature, output) -> {
                output.accept(ThermalExtraItems.ABYSSAL_INTEGRAL_COMPONENT.get());
                output.accept(ThermalExtraItems.INTEGRAL_COMPONENT.get());

                output.accept(ThermalExtraItems.AV_ITEM_FILTER_AUGMENT.get());

                for(EnumAugment e: EnumAugment.values()) {
                    for(ExtraAugmentType type: ExtraAugmentType.VALUES) {
                        output.accept(ThermalExtraItems.AUGMENTS.get(e).get(type).get());
                    }
                }

            })
            .build()
    );

    public static RegistryObject<CreativeModeTab> tab_machines = CREATIVE_TABS.register("machines", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ThermalExtraItems.DYNAMO_COLD.get()))
            .title(Component.translatable("creative_tab.thermal_extra.machines"))
            .displayItems((feature, output) -> {
                output.accept(ThermalExtraBlocks.LAVA_GEN.get());
                output.accept(ThermalExtraBlocks.DYNAMO_COLD.get());
                output.accept(ThermalExtraBlocks.ADVANCED_REFINERY.get());
                output.accept(ThermalExtraBlocks.NITRATIC_IGNITER.get());
                output.accept(ThermalExtraBlocks.FLUID_MIXER.get());
                output.accept(ThermalExtraBlocks.COMPONENT_ASSEMBLY.get());
                output.accept(ThermalExtraBlocks.ENDOTHERMIC_DEHYDRATOR.get());
            })
            .build()
    );

    public static RegistryObject<CreativeModeTab> tab_resources = CREATIVE_TABS.register("resources", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ThermalExtraItems.AMETHYST_DUST.get()))
            .title(Component.translatable("creative_tab.thermal_extra.resources"))
            .displayItems((feature, output) -> {

                output.accept(ThermalExtraItems.BEEF_JERKY.get());
                output.accept(ThermalExtraItems.CHICKEN_JERKY.get());
                output.accept(ThermalExtraItems.COD_JERKY.get());
                output.accept(ThermalExtraItems.MUTTON_JERKY.get());
                output.accept(ThermalExtraItems.PORK_JERKY.get());
                output.accept(ThermalExtraItems.RABBIT_JERKY.get());
                output.accept(ThermalExtraItems.SALMON_JERKY.get());

                output.accept(ThermalExtraItems.COPPER_ORE_CHUNK.get());
                output.accept(ThermalExtraItems.IRON_ORE_CHUNK.get());
                output.accept(ThermalExtraItems.GOLD_ORE_CHUNK.get());
                output.accept(ThermalExtraItems.TIN_ORE_CHUNK.get());
                output.accept(ThermalExtraItems.LEAD_ORE_CHUNK.get());
                output.accept(ThermalExtraItems.SILVER_ORE_CHUNK.get());
                output.accept(ThermalExtraItems.NICKEL_ORE_CHUNK.get());
                output.accept(ThermalExtraItems.ALUMINUM_ORE_CHUNK.get());
                output.accept(ThermalExtraItems.URANIUM_ORE_CHUNK.get());
                output.accept(ThermalExtraItems.OSMIUM_ORE_CHUNK.get());
                output.accept(ThermalExtraItems.ARCANE_GOLD_ORE_CHUNK.get());
                output.accept(ThermalExtraItems.ZINC_ORE_CHUNK.get());

                output.accept(ThermalExtraItems.ANCIENT_DUST.get());
                output.accept(ThermalExtraItems.OBSIDIAN_DUST.get());
                output.accept(ThermalExtraItems.AMETHYST_DUST.get());
                output.accept(ThermalExtraItems.SOUL_SAND_DUST.get());
                output.accept(ThermalExtraItems.STICKY_BALL.get());
                output.accept(ThermalExtraItems.CHILLER_PLATE_CAST.get());

                output.accept(ThermalExtraItems.SOUL_INFUSED_ROD.get());
                output.accept(ThermalExtraItems.TWINITE_ROD.get());
                output.accept(ThermalExtraItems.SHELLITE_ROD.get());
                output.accept(ThermalExtraItems.DRAGONSTEEL_ROD.get());
                output.accept(ThermalExtraItems.ABYSSAL_ROD.get());
                output.accept(ThermalExtraItems.COPPER_ROD.get());
                output.accept(ThermalExtraItems.IRON_ROD.get());
                output.accept(ThermalExtraItems.GOLD_ROD.get());
                output.accept(ThermalExtraItems.DIAMOND_ROD.get());
                output.accept(ThermalExtraItems.EMERALD_ROD.get());
                output.accept(ThermalExtraItems.NETHERITE_ROD.get());
                output.accept(ThermalExtraItems.LEAD_ROD.get());
                output.accept(ThermalExtraItems.TIN_ROD.get());
                output.accept(ThermalExtraItems.SILVER_ROD.get());
                output.accept(ThermalExtraItems.NICKEL_ROD.get());
                output.accept(ThermalExtraItems.BRONZE_ROD.get());
                output.accept(ThermalExtraItems.ELECTRUM_ROD.get());
                output.accept(ThermalExtraItems.CONSTANTAN_ROD.get());
                output.accept(ThermalExtraItems.INVAR_ROD.get());
                output.accept(ThermalExtraItems.SIGNALUM_ROD.get());
                output.accept(ThermalExtraItems.LUMIUM_ROD.get());
                output.accept(ThermalExtraItems.ENDERIUM_ROD.get());

                addToolSet(ThermalExtraItems.SIGNALUM_SET, output);
                addToolSet(ThermalExtraItems.LUMIUM_SET, output);
                addToolSet(ThermalExtraItems.ENDERIUM_SET, output);

                // metal resources
                output.accept(ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get());
                output.accept(ThermalExtraBlocks.SOUL_INFUSED_GLASS.get());
                output.accept(ThermalExtraItems.SOUL_INFUSED_INGOT.get());
                output.accept(ThermalExtraItems.SOUL_INFUSED_NUGGET.get());
                output.accept(ThermalExtraItems.SOUL_INFUSED_DUST.get());
                output.accept(ThermalExtraItems.SOUL_INFUSED_PLATE.get());
                output.accept(ThermalExtraItems.SOUL_INFUSED_GEAR.get());
                addToolSet(ThermalExtraItems.SOUL_INFUSED_SET, output);

                output.accept(ThermalExtraBlocks.SHELLITE_BLOCK.get());
                output.accept(ThermalExtraBlocks.SHELLITE_GLASS.get());
                output.accept(ThermalExtraItems.SHELLITE_INGOT.get());
                output.accept(ThermalExtraItems.SHELLITE_NUGGET.get());
                output.accept(ThermalExtraItems.SHELLITE_DUST.get());
                output.accept(ThermalExtraItems.SHELLITE_PLATE.get());
                output.accept(ThermalExtraItems.SHELLITE_GEAR.get());
                addToolSet(ThermalExtraItems.SHELLITE_SET, output);

                output.accept(ThermalExtraBlocks.TWINITE_BLOCK.get());
                output.accept(ThermalExtraBlocks.TWINITE_GLASS.get());
                output.accept(ThermalExtraItems.TWINITE_INGOT.get());
                output.accept(ThermalExtraItems.TWINITE_NUGGET.get());
                output.accept(ThermalExtraItems.TWINITE_DUST.get());
                output.accept(ThermalExtraItems.TWINITE_PLATE.get());
                output.accept(ThermalExtraItems.TWINITE_GEAR.get());
                addToolSet(ThermalExtraItems.TWINITE_SET, output);

                output.accept(ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get());
                output.accept(ThermalExtraBlocks.DRAGONSTEEL_GLASS.get());
                output.accept(ThermalExtraItems.DRAGONSTEEL_INGOT.get());
                output.accept(ThermalExtraItems.DRAGONSTEEL_NUGGET.get());
                output.accept(ThermalExtraItems.DRAGONSTEEL_DUST.get());
                output.accept(ThermalExtraItems.DRAGONSTEEL_PLATE.get());
                output.accept(ThermalExtraItems.DRAGONSTEEL_GEAR.get());
                addToolSet(ThermalExtraItems.DRAGONSTEEL_SET, output);

                output.accept(ThermalExtraBlocks.ABYSSAL_BLOCK.get());
                output.accept(ThermalExtraBlocks.ABYSSAL_GLASS.get());
                output.accept(ThermalExtraItems.ABYSSAL_INGOT.get());
                output.accept(ThermalExtraItems.ABYSSAL_NUGGET.get());
                output.accept(ThermalExtraItems.ABYSSAL_DUST.get());
                output.accept(ThermalExtraItems.ABYSSAL_PLATE.get());
                output.accept(ThermalExtraItems.ABYSSAL_GEAR.get());
                addToolSet(ThermalExtraItems.ABYSSAL_SET, output);

                output.accept(ThermalExtraFluids.POLYOLEFIN.getBucket().get());
                output.accept(ThermalExtraFluids.FLUX_INFUSED_OIL.getBucket().get());
                output.accept(ThermalExtraFluids.DIESEL.getBucket().get());
                output.accept(ThermalExtraFluids.MOLTEN_DRAGONSTEEL.getBucket().get());
                output.accept(ThermalExtraFluids.MOLTEN_TWINITE.getBucket().get());
                output.accept(ThermalExtraFluids.MOLTEN_SHELLITE.getBucket().get());
                output.accept(ThermalExtraFluids.MOLTEN_SOUL_INFUSED.getBucket().get());
                output.accept(ThermalExtraFluids.SUNFLOWER_OIL.getBucket().get());
                output.accept(ThermalExtraFluids.CRYSTALLIZED_SUNFLOWER_OIL.getBucket().get());
                output.accept(ThermalExtraFluids.REFINED_SUNFLOWER_OIL.getBucket().get());

                output.accept(ThermalExtraFluids.RAW_ALUMINUM.getBucket().get());
                output.accept(ThermalExtraFluids.RAW_ARCANE_GOLD.getBucket().get());
                output.accept(ThermalExtraFluids.RAW_COPPER.getBucket().get());
                output.accept(ThermalExtraFluids.RAW_GOLD.getBucket().get());
                output.accept(ThermalExtraFluids.RAW_IRON.getBucket().get());
                output.accept(ThermalExtraFluids.RAW_LEAD.getBucket().get());
                output.accept(ThermalExtraFluids.RAW_NICKEL.getBucket().get());
                output.accept(ThermalExtraFluids.RAW_OSMIUM.getBucket().get());
                output.accept(ThermalExtraFluids.RAW_SILVER.getBucket().get());
                output.accept(ThermalExtraFluids.RAW_TIN.getBucket().get());
                output.accept(ThermalExtraFluids.RAW_URANIUM.getBucket().get());
                output.accept(ThermalExtraFluids.RAW_ZINC.getBucket().get());

                output.accept(ThermalExtraItems.ARCANE_GOLD_DUST.get());
                output.accept(ThermalExtraItems.ZINC_DUST.get());
                output.accept(ThermalExtraItems.AUGMENT_TEMPLATE.get());
            })
            .build()
    );
}
