package mrthomas20121.thermal_extra;

import cofh.core.item.BlockItemCoFH;
import cofh.core.item.ItemCoFH;
import cofh.lib.util.helpers.AugmentDataHelper;
import mrthomas20121.thermal_extra.item.CustomAugmentItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;

import javax.annotation.Nonnull;

import static cofh.lib.util.constants.NBTTags.*;
import static cofh.thermal.lib.common.ThermalFlags.*;

@Mod.EventBusSubscriber(modid = ThermalExtra.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegistry {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(Item.class, ThermalExtra.MOD_ID);

    public static ItemGroup group = new ItemGroup("thermal_extra") {
        @Nonnull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(dragon_breath_plating.get());
        }
    };

    public static final RegistryObject<Item> dynamo_ender_item = ITEMS.register("dynamo_ender", ItemRegistry::register);
    public static final RegistryObject<Item> dragon_enderium_ingot = ITEMS.register("dragon_enderium_ingot", ItemRegistry::register);
    public static final RegistryObject<Item> dragon_enderium_dust = ITEMS.register("dragon_enderium_dust", ItemRegistry::register);
    public static final RegistryObject<Item> dragon_enderium_plate = ITEMS.register("dragon_enderium_plate", ItemRegistry::register);
    public static final RegistryObject<Item> dragon_enderium_gear = ITEMS.register("dragon_enderium_gear", ItemRegistry::register);
    public static final RegistryObject<Item> dragon_enderium_coin = ITEMS.register("dragon_enderium_coin", ItemRegistry::register);
    public static final RegistryObject<Item> dragon_breath_plating = ITEMS.register("dragon_breath_plating", ItemRegistry::register);

    // augments
    public static final RegistryObject<ItemCoFH> dragon_integral_component = ITEMS.register("dragon_integral_component", () -> new CustomAugmentItem(new Item.Properties().tab(group),
            AugmentDataHelper.builder()
                    .type(TAG_AUGMENT_TYPE_UPGRADE)
                    .mod(TAG_AUGMENT_BASE_MOD, 4.5F)
                    .build()).setShowInGroups(getFlag(FLAG_UPGRADE_AUGMENTS)));

    public static final RegistryObject<ItemCoFH> end_speed_augment = ITEMS.register("end_speed_augment", () -> new CustomAugmentItem(new Item.Properties().tab(group),
            AugmentDataHelper.builder()
                    .type(TAG_AUGMENT_TYPE_MACHINE)
                    .mod(TAG_AUGMENT_MACHINE_SPEED, 0.4F)
                    .mod(TAG_AUGMENT_MACHINE_POWER, 1.2F)
                    .mod(TAG_AUGMENT_MACHINE_ENERGY, 1.5F)
                    .build()).setShowInGroups(getFlag(FLAG_UPGRADE_AUGMENTS)));

    public static final RegistryObject<ItemCoFH> ender_rf_coil_augment = ITEMS.register("ender_rf_coil_augment", () -> new CustomAugmentItem(new Item.Properties().tab(group),
            AugmentDataHelper.builder()
                    .type(TAG_AUGMENT_TYPE_RF)
                    .mod(TAG_AUGMENT_RF_XFER, 10.0F)
                    .mod(TAG_AUGMENT_RF_STORAGE, 0.3F)
                    .build()).setShowInGroups(getFlag(FLAG_UPGRADE_AUGMENTS)));

    public static Item register() {
        return new Item(new Item.Properties().tab(group));
    }
    public static Item registerItemBlock(Block block) {
        return new BlockItemCoFH(block, new Item.Properties().tab(group));
    }
}
