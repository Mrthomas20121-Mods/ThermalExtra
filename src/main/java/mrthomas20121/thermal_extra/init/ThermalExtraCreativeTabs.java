package mrthomas20121.thermal_extra.init;

import mrthomas20121.thermal_extra.ThermalExtra;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ThermalExtraCreativeTabs {
    public static DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ThermalExtra.MOD_ID);

    public static RegistryObject<CreativeModeTab> tab_augments = CREATIVE_TABS.register("augments", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ThermalExtraItems.integral_component.get()))
            .title(Component.translatable("creative_tab.thermal_extra.augment"))
            .displayItems((feature, output) -> {
                output.accept(ThermalExtraItems.integral_component.get());

                output.accept(ThermalExtraItems.av_item_filter_augment.get());

                output.accept(ThermalExtraItems.area_radius_augment_1.get());
                output.accept(ThermalExtraItems.area_radius_augment_2.get());
                output.accept(ThermalExtraItems.area_radius_augment_3.get());
                output.accept(ThermalExtraItems.area_radius_augment_4.get());

                output.accept(ThermalExtraItems.tank_augment_1.get());
                output.accept(ThermalExtraItems.tank_augment_2.get());
                output.accept(ThermalExtraItems.tank_augment_3.get());
                output.accept(ThermalExtraItems.tank_augment_4.get());
                output.accept(ThermalExtraItems.tank_augment_5.get());
                output.accept(ThermalExtraItems.tank_augment_6.get());

                output.accept(ThermalExtraItems.potion_amplifier_augment_1.get());
                output.accept(ThermalExtraItems.potion_amplifier_augment_2.get());
                output.accept(ThermalExtraItems.potion_amplifier_augment_3.get());
                output.accept(ThermalExtraItems.potion_amplifier_augment_4.get());
                output.accept(ThermalExtraItems.potion_amplifier_augment_5.get());

                output.accept(ThermalExtraItems.potion_duration_augment_1.get());
                output.accept(ThermalExtraItems.potion_duration_augment_2.get());
                output.accept(ThermalExtraItems.potion_duration_augment_3.get());
                output.accept(ThermalExtraItems.potion_duration_augment_4.get());
                output.accept(ThermalExtraItems.potion_duration_augment_5.get());

                output.accept(ThermalExtraItems.rf_coil_augment_1.get());
                output.accept(ThermalExtraItems.rf_coil_augment_2.get());
                output.accept(ThermalExtraItems.rf_coil_augment_3.get());
                output.accept(ThermalExtraItems.rf_coil_augment_4.get());
                output.accept(ThermalExtraItems.rf_coil_augment_5.get());

                output.accept(ThermalExtraItems.rf_coil_storage_augment_1.get());
                output.accept(ThermalExtraItems.rf_coil_storage_augment_2.get());
                output.accept(ThermalExtraItems.rf_coil_storage_augment_3.get());
                output.accept(ThermalExtraItems.rf_coil_storage_augment_4.get());
                output.accept(ThermalExtraItems.rf_coil_storage_augment_5.get());

                output.accept(ThermalExtraItems.rf_coil_xfer_augment_1.get());
                output.accept(ThermalExtraItems.rf_coil_xfer_augment_2.get());
                output.accept(ThermalExtraItems.rf_coil_xfer_augment_3.get());
                output.accept(ThermalExtraItems.rf_coil_xfer_augment_4.get());
                output.accept(ThermalExtraItems.rf_coil_xfer_augment_5.get());

                output.accept(ThermalExtraItems.machine_speed_augment_1.get());
                output.accept(ThermalExtraItems.machine_speed_augment_2.get());
                output.accept(ThermalExtraItems.machine_speed_augment_3.get());
                output.accept(ThermalExtraItems.machine_speed_augment_4.get());

                output.accept(ThermalExtraItems.machine_efficiency_augment_1.get());
                output.accept(ThermalExtraItems.machine_efficiency_augment_2.get());
                output.accept(ThermalExtraItems.machine_efficiency_augment_3.get());
                output.accept(ThermalExtraItems.machine_efficiency_augment_4.get());

                output.accept(ThermalExtraItems.machine_output_augment_1.get());
                output.accept(ThermalExtraItems.machine_output_augment_2.get());
                output.accept(ThermalExtraItems.machine_output_augment_3.get());

                output.accept(ThermalExtraItems.machine_catalyst_augment_1.get());
                output.accept(ThermalExtraItems.machine_catalyst_augment_2.get());
                output.accept(ThermalExtraItems.machine_catalyst_augment_3.get());

                output.accept(ThermalExtraItems.dynamo_fuel_augment_1.get());
                output.accept(ThermalExtraItems.dynamo_fuel_augment_2.get());
                output.accept(ThermalExtraItems.dynamo_fuel_augment_3.get());
                output.accept(ThermalExtraItems.dynamo_fuel_augment_4.get());

                output.accept(ThermalExtraItems.dynamo_output_augment_1.get());
                output.accept(ThermalExtraItems.dynamo_output_augment_2.get());
                output.accept(ThermalExtraItems.dynamo_output_augment_3.get());
                output.accept(ThermalExtraItems.dynamo_output_augment_4.get());
            })
            .build()
    );

    public static RegistryObject<CreativeModeTab> tab_resources = CREATIVE_TABS.register("resources", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ThermalExtraItems.amethyst_dust.get()))
            .title(Component.translatable("creative_tab.thermal_extra.resources"))
            .displayItems((feature, output) -> {
                output.accept(ThermalExtraItems.amethyst_dust.get());
                output.accept(ThermalExtraItems.soul_sand_dust.get());
                output.accept(ThermalExtraItems.sticky_ball.get());

                // metal resources
                output.accept(ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get());
                output.accept(ThermalExtraBlocks.SOUL_INFUSED_GLASS.get());
                output.accept(ThermalExtraItems.soul_infused_ingot.get());
                output.accept(ThermalExtraItems.soul_infused_nugget.get());
                output.accept(ThermalExtraItems.soul_infused_dust.get());
                output.accept(ThermalExtraItems.soul_infused_plate.get());
                output.accept(ThermalExtraItems.soul_infused_gear.get());

                output.accept(ThermalExtraBlocks.SHELLITE_BLOCK.get());
                output.accept(ThermalExtraBlocks.SHELLITE_GLASS.get());
                output.accept(ThermalExtraItems.shellite_ingot.get());
                output.accept(ThermalExtraItems.shellite_nugget.get());
                output.accept(ThermalExtraItems.shellite_dust.get());
                output.accept(ThermalExtraItems.shellite_plate.get());
                output.accept(ThermalExtraItems.shellite_gear.get());

                output.accept(ThermalExtraBlocks.TWINITE_BLOCK.get());
                output.accept(ThermalExtraBlocks.TWINITE_GLASS.get());
                output.accept(ThermalExtraItems.twinite_ingot.get());
                output.accept(ThermalExtraItems.twinite_nugget.get());
                output.accept(ThermalExtraItems.twinite_dust.get());
                output.accept(ThermalExtraItems.twinite_plate.get());
                output.accept(ThermalExtraItems.twinite_gear.get());

                output.accept(ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get());
                output.accept(ThermalExtraBlocks.DRAGONSTEEL_GLASS.get());
                output.accept(ThermalExtraItems.dragon_steel_ingot.get());
                output.accept(ThermalExtraItems.dragon_steel_nugget.get());
                output.accept(ThermalExtraItems.dragon_steel_dust.get());
                output.accept(ThermalExtraItems.dragon_steel_plate.get());
                output.accept(ThermalExtraItems.dragon_steel_gear.get());
            })
            .build()
    );
}
