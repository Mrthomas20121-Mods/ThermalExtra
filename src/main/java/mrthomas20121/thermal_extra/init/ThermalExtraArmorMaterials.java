package mrthomas20121.thermal_extra.init;

import cofh.lib.common.item.ArmorMaterialCoFH;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

public class ThermalExtraArmorMaterials {

    public static ArmorMaterialCoFH SIGNALUM = register("thermal_extra:signalum", 34, new int[] { 3, 8, 6, 3 }, 15, SoundEvents.ARMOR_EQUIP_IRON, 2.0f, 0.0f, ThermalExtraTags.Items.SIGNALUM_REPAIR_MATERIAL);
    public static ArmorMaterialCoFH LUMIUM = register("thermal_extra:lumium", 35, new int[] { 3, 8, 6, 3 }, 22, SoundEvents.ARMOR_EQUIP_GOLD, 2.0f, 0.0f, ThermalExtraTags.Items.LUMIUM_REPAIR_MATERIAL);
    public static ArmorMaterialCoFH ENDERIUM = register("thermal_extra:enderium", 36, new int[] { 3, 8, 6, 3 }, 15, SoundEvents.ARMOR_EQUIP_IRON, 2.0f, 0.0f, ThermalExtraTags.Items.ENDERIUM_REPAIR_MATERIAL);
    public static ArmorMaterialCoFH SOUL_INFUSED = register("thermal_extra:soul_infused", 36, new int[] { 3, 7, 5, 3 }, 24, SoundEvents.ARMOR_EQUIP_ELYTRA, 2.0f, 0.0f, ThermalExtraTags.Items.SOUL_INFUSED_REPAIR_MATERIAL);
    public static ArmorMaterialCoFH TWINITE = register("thermal_extra:twinite", 36, new int[] { 3, 8, 6, 3 }, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.0f, 0.0f, ThermalExtraTags.Items.TWINITE_REPAIR_MATERIAL);
    public static ArmorMaterialCoFH SHELLITE = register("thermal_extra:shellite", 36, new int[] { 3, 8, 6, 3 }, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.0f, 0.0f, ThermalExtraTags.Items.SHELLITE_REPAIR_MATERIAL);
    public static ArmorMaterialCoFH DRAGONSTEEL = register("thermal_extra:dragonsteel", 38, new int[] { 4, 9, 7, 4 }, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.0f, 0.0f, ThermalExtraTags.Items.DRAGONSTEEL_REPAIR_MATERIAL);
    public static ArmorMaterialCoFH ABYSSAL = register("thermal_extra:abyssal", 40, new int[] { 5, 10, 8, 5 }, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.0f, 0.0f, ThermalExtraTags.Items.SHELLITE_REPAIR_MATERIAL);

    public static ArmorMaterialCoFH register(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float toughnessIn, float knockbackResistanceIn, TagKey<Item> repairMaterialSupplier) {
        return new ArmorMaterialCoFH(nameIn, maxDamageFactorIn, damageReductionAmountsIn, enchantabilityIn, equipSoundIn, toughnessIn, knockbackResistanceIn, () -> Ingredient.of(repairMaterialSupplier));
    }
}
