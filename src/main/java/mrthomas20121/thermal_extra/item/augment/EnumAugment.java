package mrthomas20121.thermal_extra.item.augment;

import cofh.lib.util.DeferredRegisterCoFH;
import cofh.thermal.lib.common.item.AugmentItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiConsumer;

import static cofh.lib.util.constants.NBTTags.*;

public enum EnumAugment {

    RF_COIL_AUGMENT(TAG_AUGMENT_TYPE_RF, "Expanded RF Coil", (valueMap, map) -> {
        valueMap.put(TAG_AUGMENT_RF_STORAGE, 4f);
        map.put(TAG_AUGMENT_RF_STORAGE, 4f);
        valueMap.put(TAG_AUGMENT_RF_XFER, 4f);
        map.put(TAG_AUGMENT_RF_XFER, 4f);
    }),
    RF_COIL_STORAGE_AUGMENT(TAG_AUGMENT_TYPE_RF, "Stabilized RF Coil", (valueMap, map) -> {
        valueMap.put(TAG_AUGMENT_RF_STORAGE, 6f);
        map.put(TAG_AUGMENT_RF_STORAGE, 4f);
        valueMap.put(TAG_AUGMENT_RF_XFER, 2f);
        map.put(TAG_AUGMENT_RF_XFER, 2f);
    }),
    RF_COIL_XFER_AUGMENT(TAG_AUGMENT_TYPE_RF, "High-Flux RF Coil", (valueMap, map) -> {
        valueMap.put(TAG_AUGMENT_RF_STORAGE, 2f);
        map.put(TAG_AUGMENT_RF_STORAGE, 2f);
        valueMap.put(TAG_AUGMENT_RF_XFER, 6f);
        map.put(TAG_AUGMENT_RF_XFER, 4f);
    }),
    FLUID_TANK_AUGMENT(TAG_AUGMENT_TYPE_FLUID, "Expanded Tank Construction", (valueMap, map) -> {
        valueMap.put(TAG_AUGMENT_FLUID_STORAGE, 4f);
        map.put(TAG_AUGMENT_FLUID_STORAGE, 4f);
    }),
    MACHINE_SPEED_AUGMENT(TAG_AUGMENT_TYPE_MACHINE, "Flux Linkage Amplifier", (valueMap, map) -> {
        valueMap.put(TAG_AUGMENT_MACHINE_POWER, 1f);
        map.put(TAG_AUGMENT_MACHINE_POWER, 0.05f);
        valueMap.put(TAG_AUGMENT_MACHINE_ENERGY, 1f);
        map.put(TAG_AUGMENT_MACHINE_ENERGY, 0.05f);
    }),
    MACHINE_EFFICIENCY_AUGMENT(TAG_AUGMENT_TYPE_MACHINE, "Flux Efficiency", (valueMap, map) -> {
        valueMap.put(TAG_AUGMENT_MACHINE_SPEED, -0.12f);
        map.put(TAG_AUGMENT_MACHINE_SPEED, 0f);
        valueMap.put(TAG_AUGMENT_MACHINE_ENERGY, 0.9f);
        map.put(TAG_AUGMENT_MACHINE_ENERGY, -0.1f);
    }),
    MACHINE_OUTPUT_AUGMENT(TAG_AUGMENT_TYPE_MACHINE, "Auxiliary Process Sieve", (valueMap, map) -> {
        valueMap.put(TAG_AUGMENT_MACHINE_SECONDARY, 0.15f);
        map.put(TAG_AUGMENT_MACHINE_SECONDARY, 0.05f);
        valueMap.put(TAG_AUGMENT_MACHINE_ENERGY, 1.30f);
        map.put(TAG_AUGMENT_MACHINE_ENERGY, 0f);
    }),
    MACHINE_CATALYST_AUGMENT(TAG_AUGMENT_TYPE_MACHINE, "Catalytic Reclamation Chamber", (valueMap, map) -> {
        valueMap.put(TAG_AUGMENT_MACHINE_CATALYST, 0.80f);
        map.put(TAG_AUGMENT_MACHINE_CATALYST, 0.02f);
        valueMap.put(TAG_AUGMENT_MACHINE_ENERGY, 1.25f);
        map.put(TAG_AUGMENT_MACHINE_ENERGY, 0f);
    }),
    DYNAMO_OUTPUT_AUGMENT(TAG_AUGMENT_TYPE_DYNAMO, "Auxiliary Reaction Chamber", (valueMap, map) -> {
        valueMap.put(TAG_AUGMENT_DYNAMO_ENERGY, 0.9f);
        map.put(TAG_AUGMENT_DYNAMO_ENERGY, 0f);
        valueMap.put(TAG_AUGMENT_DYNAMO_POWER, 1f);
        map.put(TAG_AUGMENT_DYNAMO_POWER, 0.05f);
    }),
    DYNAMO_FUEL_AUGMENT(TAG_AUGMENT_TYPE_DYNAMO, "Multi Cycle Injectors", (valueMap, map) -> {
        valueMap.put(TAG_AUGMENT_DYNAMO_ENERGY, 1.1f);
        map.put(TAG_AUGMENT_DYNAMO_ENERGY, 0.02f);
    }),
    POTION_AMPLIFIER_AUGMENT(TAG_AUGMENT_TYPE_POTION, "Alchemical Amplifier", (valueMap, map) -> {
        valueMap.put(TAG_AUGMENT_POTION_AMPLIFIER, 1f);
        map.put(TAG_AUGMENT_POTION_AMPLIFIER, 0f);
        valueMap.put(TAG_AUGMENT_POTION_DURATION, -0.25f);
        map.put(TAG_AUGMENT_POTION_DURATION, -0.05f);
    }),
    POTION_DURATION_AUGMENT(TAG_AUGMENT_TYPE_POTION, "Alchemical Extender", (valueMap, map) -> {
        valueMap.put(TAG_AUGMENT_POTION_DURATION, 1f);
        map.put(TAG_AUGMENT_POTION_DURATION, 0.1f);
    }),
    AREA_RADIUS_AUGMENT(TAG_AUGMENT_TYPE_AREA_EFFECT, "Radial Enhancement", (valueMap, map) -> {
        valueMap.put(TAG_AUGMENT_RADIUS, 1f);
        map.put(TAG_AUGMENT_RADIUS, 1f);
    });

    private final Map<String, Float> defaultValueMap = new HashMap<>();
    private final Map<String, Float> mapIncrement = new HashMap<>();
    private final String type;
    private final String name;

    EnumAugment(String type, String name, BiConsumer<Map<String, Float>, Map<String, Float>> consumer) {
        this.type = type;
        this.name = name;
        consumer.accept(this.defaultValueMap, mapIncrement);
    }

    public RegistryObject<AugmentItem> build(ExtraAugmentType augmentType, DeferredRegisterCoFH<Item> registry) {
        ExtraAugment builder = ExtraAugment.builder(registry).type(this.type).rarity(augmentType.getRarity());

        for(Map.Entry<String, Float> entry: defaultValueMap.entrySet()) {
            float value = entry.getValue();
            float increment = mapIncrement.get(entry.getKey());
            float finalValue = value+(increment*augmentType.getTier());
            builder.mod(entry.getKey(), finalValue);
        }

        return builder.build(augmentType.name().toLowerCase(Locale.ROOT)+"_"+this.name().toLowerCase(Locale.ROOT));
    }

    public String getName() {
        return name;
    }
}
