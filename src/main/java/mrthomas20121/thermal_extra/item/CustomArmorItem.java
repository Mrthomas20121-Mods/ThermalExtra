package mrthomas20121.thermal_extra.item;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class CustomArmorItem extends ArmorItem {

    private String armorTexture;

    public CustomArmorItem(IArmorMaterial material, EquipmentSlotType slot, Item.Properties properties) {
        super(material, slot, properties);
        if(!slot.equals(EquipmentSlotType.LEGS)) {
            this.setArmorTexture("dragon_bronze_layer_1");
        }
        else {
            this.setArmorTexture("dragon_bronze_layer_2");
        }
    }

    public Item setArmorTexture(String armorTexture) {
        this.armorTexture = armorTexture;
        return this;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return "thermal_extra:textures/models/armor/"+this.armorTexture+".png";
    }
}