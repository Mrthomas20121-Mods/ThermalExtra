package mrthomas20121.thermal_extra.init;

import cofh.core.item.ItemCoFH;
import cofh.lib.util.helpers.AugmentDataHelper;
import cofh.thermal.lib.item.AugmentItem;
import mrthomas20121.thermal_extra.item.CustomArmorItem;
import mrthomas20121.thermal_extra.item.CustomAugmentItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

import static cofh.lib.util.constants.NBTTags.*;
import static cofh.thermal.lib.common.ThermalFlags.*;

@Mod.EventBusSubscriber(modid = mrthomas20121.thermal_extra.ThermalExtra.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ThermalExtraItems {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, mrthomas20121.thermal_extra.ThermalExtra.MOD_ID);

    public static ItemGroup group = new ItemGroup("thermal_extra") {
        @Nonnull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(dragon_breath_plating.get());
        }
    };

    public static final RegistryObject<Item> dragon_breath_plating = ITEMS.register("dragon_breath_plating", ThermalExtraItems::register);
    public static final RegistryObject<Item> dragon_bronze_helmet = ITEMS.register("dragon_bronze_helmet", () -> new CustomArmorItem(ThermalArmorMaterial.DRAGON_BRONZE, EquipmentSlotType.HEAD, (new Item.Properties()).tab(group)));
    public static final RegistryObject<Item> dragon_bronze_chestplate = ITEMS.register("dragon_bronze_chestplate", () -> new CustomArmorItem(ThermalArmorMaterial.DRAGON_BRONZE, EquipmentSlotType.CHEST, (new Item.Properties()).tab(group)));
    public static final RegistryObject<Item> dragon_bronze_leggings = ITEMS.register("dragon_bronze_leggings", () -> new CustomArmorItem(ThermalArmorMaterial.DRAGON_BRONZE, EquipmentSlotType.LEGS, (new Item.Properties()).tab(group)));
    public static final RegistryObject<Item> dragon_bronze_boots = ITEMS.register("dragon_bronze_boots", () -> new CustomArmorItem(ThermalArmorMaterial.DRAGON_BRONZE, EquipmentSlotType.FEET, (new Item.Properties()).tab(group)));
    public static final RegistryObject<Item> dragon_bronze_ingot = ITEMS.register("dragon_bronze_ingot", ThermalExtraItems::register);
    public static final RegistryObject<Item> dragon_bronze_nugget = ITEMS.register("dragon_bronze_nugget", ThermalExtraItems::register);
    public static final RegistryObject<Item> dragon_bronze_dust = ITEMS.register("dragon_bronze_dust", ThermalExtraItems::register);
    public static final RegistryObject<Item> dragon_bronze_plate = ITEMS.register("dragon_bronze_plate", ThermalExtraItems::register);
    public static final RegistryObject<Item> dragon_bronze_gear = ITEMS.register("dragon_bronze_gear", ThermalExtraItems::register);
    public static final RegistryObject<Item> dragon_bronze_coin = ITEMS.register("dragon_bronze_coin", ThermalExtraItems::register);
    public static final RegistryObject<Item> dragon_enderium_ingot = ITEMS.register("dragon_enderium_ingot", ThermalExtraItems::register);
    public static final RegistryObject<Item> dragon_enderium_nugget = ITEMS.register("dragon_enderium_nugget", ThermalExtraItems::register);
    public static final RegistryObject<Item> dragon_enderium_dust = ITEMS.register("dragon_enderium_dust", ThermalExtraItems::register);
    public static final RegistryObject<Item> dragon_enderium_plate = ITEMS.register("dragon_enderium_plate", ThermalExtraItems::register);
    public static final RegistryObject<Item> dragon_enderium_gear = ITEMS.register("dragon_enderium_gear", ThermalExtraItems::register);
    public static final RegistryObject<Item> dragon_enderium_coin = ITEMS.register("dragon_enderium_coin", ThermalExtraItems::register);
    public static final RegistryObject<Item> vukaium_ingot = ITEMS.register("vukaium_ingot", ThermalExtraItems::register);
    public static final RegistryObject<Item> vukaium_nugget = ITEMS.register("vukaium_nugget", ThermalExtraItems::register);
    public static final RegistryObject<Item> vukaium_dust = ITEMS.register("vukaium_dust", ThermalExtraItems::register);
    public static final RegistryObject<Item> vukaium_plate = ITEMS.register("vukaium_plate", ThermalExtraItems::register);
    public static final RegistryObject<Item> vukaium_gear = ITEMS.register("vukaium_gear", ThermalExtraItems::register);
    public static final RegistryObject<Item> vukaium_coin = ITEMS.register("vukaium_coin", ThermalExtraItems::register);
    public static final RegistryObject<Item> nebulium_ingot = ITEMS.register("nebulium_ingot", ThermalExtraItems::registerEndMaterial);
    public static final RegistryObject<Item> nebulium_nugget = ITEMS.register("nebulium_nugget", ThermalExtraItems::registerEndMaterial);
    public static final RegistryObject<Item> nebulium_dust = ITEMS.register("nebulium_dust", ThermalExtraItems::registerEndMaterial);
    public static final RegistryObject<Item> nebulium_plate = ITEMS.register("nebulium_plate", ThermalExtraItems::registerEndMaterial);
    public static final RegistryObject<Item> nebulium_gear = ITEMS.register("nebulium_gear", ThermalExtraItems::registerEndMaterial);
    public static final RegistryObject<Item> nebulium_coin = ITEMS.register("nebulium_coin", ThermalExtraItems::registerEndMaterial);
    public static final RegistryObject<Item> nectium_ingot = ITEMS.register("nectium_ingot", ThermalExtraItems::register);
    public static final RegistryObject<Item> nectium_nugget = ITEMS.register("nectium_nugget", ThermalExtraItems::register);
    public static final RegistryObject<Item> nectium_dust = ITEMS.register("nectium_dust", ThermalExtraItems::register);
    public static final RegistryObject<Item> nectium_plate = ITEMS.register("nectium_plate", ThermalExtraItems::register);
    public static final RegistryObject<Item> nectium_gear = ITEMS.register("nectium_gear", ThermalExtraItems::register);
    public static final RegistryObject<Item> nectium_coin = ITEMS.register("nectium_coin", ThermalExtraItems::register);
    public static final RegistryObject<Item> polarium_ingot = ITEMS.register("polarium_ingot", ThermalExtraItems::register);
    public static final RegistryObject<Item> polarium_nugget = ITEMS.register("polarium_nugget", ThermalExtraItems::register);
    public static final RegistryObject<Item> polarium_dust = ITEMS.register("polarium_dust", ThermalExtraItems::register);
    public static final RegistryObject<Item> polarium_plate = ITEMS.register("polarium_plate", ThermalExtraItems::register);
    public static final RegistryObject<Item> polarium_gear = ITEMS.register("polarium_gear", ThermalExtraItems::register);
    public static final RegistryObject<Item> polarium_coin = ITEMS.register("polarium_coin", ThermalExtraItems::register);
    public static final RegistryObject<Item> zauvium_ingot = ITEMS.register("zauvium_ingot", ThermalExtraItems::registerNetherMaterial);
    public static final RegistryObject<Item> zauvium_nugget = ITEMS.register("zauvium_nugget", ThermalExtraItems::registerNetherMaterial);
    public static final RegistryObject<Item> zauvium_dust = ITEMS.register("zauvium_dust", ThermalExtraItems::registerNetherMaterial);
    public static final RegistryObject<Item> zauvium_plate = ITEMS.register("zauvium_plate", ThermalExtraItems::registerNetherMaterial);
    public static final RegistryObject<Item> zauvium_gear = ITEMS.register("zauvium_gear", ThermalExtraItems::registerNetherMaterial);
    public static final RegistryObject<Item> zauvium_coin = ITEMS.register("zauvium_coin", ThermalExtraItems::registerNetherMaterial);
    public static final RegistryObject<Item> drownium_ingot = ITEMS.register("drownium_ingot", ThermalExtraItems::register);
    public static final RegistryObject<Item> drownium_nugget = ITEMS.register("drownium_nugget", ThermalExtraItems::register);
    public static final RegistryObject<Item> drownium_dust = ITEMS.register("drownium_dust", ThermalExtraItems::register);
    public static final RegistryObject<Item> drownium_plate = ITEMS.register("drownium_plate", ThermalExtraItems::register);
    public static final RegistryObject<Item> drownium_gear = ITEMS.register("drownium_gear", ThermalExtraItems::register);
    public static final RegistryObject<Item> drownium_coin = ITEMS.register("drownium_coin", ThermalExtraItems::register);

    public static final RegistryObject<Item> cactus_soup = ITEMS.register("cactus_soup", ()-> new SoupItem((new Item.Properties()).stacksTo(1).tab(ThermalExtraItems.group).food(Foods.cactus_stew)));

    // augments
    public static final RegistryObject<ItemCoFH> dragon_integral_component = ITEMS.register("dragon_integral_component", () -> new CustomAugmentItem(new Item.Properties().tab(group).rarity(Rarity.RARE),
            AugmentDataHelper.builder()
                    .type(TAG_AUGMENT_TYPE_UPGRADE)
                    .mod(TAG_AUGMENT_BASE_MOD, 4.5F)
                    .build()).setShowInGroups(getFlag(FLAG_UPGRADE_AUGMENTS)));

    public static final RegistryObject<ItemCoFH> end_speed_augment = ITEMS.register("end_speed_augment", () -> new CustomAugmentItem(new Item.Properties().tab(group).rarity(Rarity.RARE),
            AugmentDataHelper.builder()
                    .type(TAG_AUGMENT_TYPE_MACHINE)
                    .mod(TAG_AUGMENT_MACHINE_POWER, 1.2F)
                    .mod(TAG_AUGMENT_MACHINE_ENERGY, 1.5F)
                    .build()).setShowInGroups(getFlag(FLAG_MACHINE_AUGMENTS)));

    public static final RegistryObject<ItemCoFH> ender_rf_coil_augment = ITEMS.register("ender_rf_coil_augment", () -> new AugmentItem(new Item.Properties().tab(group).rarity(Rarity.RARE),
            AugmentDataHelper.builder()
                    .type(TAG_AUGMENT_TYPE_RF)
                    .mod(TAG_AUGMENT_RF_XFER, 8.0F)
                    .mod(TAG_AUGMENT_RF_STORAGE, 0.3F)
                    .build()).setShowInGroups(getFlag(FLAG_STORAGE_AUGMENTS)));

    public static final RegistryObject<ItemCoFH> nether_fluid_tank_augment = ITEMS.register("nether_fluid_tank_augment", () -> new AugmentItem(new Item.Properties().tab(group).rarity(Rarity.UNCOMMON),
            AugmentDataHelper.builder()
                    .type(TAG_AUGMENT_TYPE_FLUID)
                    .mod(TAG_AUGMENT_FLUID_STORAGE, 10.0F)
                    .build()).setShowInGroups(getFlag(FLAG_STORAGE_AUGMENTS)));

    public static final RegistryObject<ItemCoFH> end_fluid_tank_augment = ITEMS.register("end_fluid_tank_augment", () -> new AugmentItem(new Item.Properties().tab(group).rarity(Rarity.RARE),
                AugmentDataHelper.builder()
                        .type(TAG_AUGMENT_TYPE_FLUID)
                        .mod(TAG_AUGMENT_FLUID_STORAGE, 16.0F)
                        .build()).setShowInGroups(getFlag(FLAG_STORAGE_AUGMENTS)));

    public static Item register() {
        return new Item(new Item.Properties().tab(group));
    }

    public static Item registerNetherMaterial() {
        return new Item(new Item.Properties().tab(group).rarity(Rarity.UNCOMMON));
    }

    public static Item registerEndMaterial() {
        return new Item(new Item.Properties().tab(group).rarity(Rarity.RARE));
    }
}
