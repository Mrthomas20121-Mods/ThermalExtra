package mrthomas20121.thermal_extra;

import net.minecraftforge.common.ForgeConfigSpec;

public final class ThermalExtraConfig {
    public static final ForgeConfigSpec COMMON;

    public static final ForgeConfigSpec.DoubleValue DRAGON_COMPONENT_MULTIPLIER;

    public static final ForgeConfigSpec.DoubleValue END_SPEED_AUGMENT_POWER_MULTIPLIER;
    public static final ForgeConfigSpec.DoubleValue END_SPEED_AUGMENT_ENERGY_MULTIPLIER;

    public static final ForgeConfigSpec.DoubleValue ENDER_RF_COIL_AUGMENT_CAPACITY_MULTIPLIER;
    public static final ForgeConfigSpec.DoubleValue ENDER_RF_COIL_AUGMENT_TRANSFER_MULTIPLIER;

    public static final ForgeConfigSpec.DoubleValue NETHER_FLUID_TANK_AUGMENT_CAPACITY_MULTIPLIER;

    public static final ForgeConfigSpec.DoubleValue END_FLUID_TANK_AUGMENT_CAPACITY_MULTIPLIER;

    static {
        final ForgeConfigSpec.Builder common = new ForgeConfigSpec.Builder();

        common.comment("Augments configuration options").push("Augments");
        DRAGON_COMPONENT_MULTIPLIER = common
                .comment("The Machine Scale Multiplier provided by Dragon Integral Component")
                .translation("configGui.thermalextra.dragon_component")
                .defineInRange("augmentDragonComponentPowerMulti", 4.5F, 0.0F, 10.0F);
        END_SPEED_AUGMENT_POWER_MULTIPLIER = common
                .comment("The End Speed Augments 'Machine Power' Multiplier, affects processing speed.")
                .translation("configGui.thermalextra.end_speed_power")
                .defineInRange("augmentEndSpeedPowerMulti", 1.2F, 0.0F, 10.0F);
        END_SPEED_AUGMENT_ENERGY_MULTIPLIER = common
                .comment("The End Speed Augments 'Energy Cost' Multiplier, affects machine RF drain.")
                .translation("configGui.thermalextra.end_speed_energy")
                .defineInRange("augmentEndSpeedEnergyMulti", 1.15F, 0.0F, 100.0F);
        ENDER_RF_COIL_AUGMENT_CAPACITY_MULTIPLIER = common
                .comment("The Ender RF Coil Augments 'Capacity' Multiplier.")
                .translation("configGui.thermalextra.rf_coil_capacity")
                .defineInRange("augmentRFCoilCapacityMulti", 1.5F, 0.0F, 100.0F);
        ENDER_RF_COIL_AUGMENT_TRANSFER_MULTIPLIER = common
                .comment("The Ender RF Coil Augments 'Transfer Speed' Multiplier.")
                .translation("configGui.thermalextra.rf_coil_transfer")
                .defineInRange("augmentRFCoilTransferMulti", 8.0F, 0.0F, 100.0F);
        NETHER_FLUID_TANK_AUGMENT_CAPACITY_MULTIPLIER = common
                .comment("The Nether Fluid Tank Augments 'Capacity' Multiplier.")
                .translation("configGui.thermalextra.nether_fluid_tank_capacity")
                .defineInRange("augmentNetherFluidTankCapacityMulti", 8F, 0.0F, 256.0F);
        END_FLUID_TANK_AUGMENT_CAPACITY_MULTIPLIER = common
                .comment("The End Fluid Tank Augments 'Capacity' Multiplier.")
                .translation("configGui.thermalextra.end_fluid_tank_capacity")
                .defineInRange("augmentEndFluidTankCapacityMulti", 12F, 0.0F, 512.0F);
        common.pop();

        COMMON = common.build();
    }
}
