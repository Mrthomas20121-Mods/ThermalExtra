package mrthomas20121.thermal_extra.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class CustomArmorItem extends ArmorItem {

    private String armorTexture;

    public CustomArmorItem(ArmorMaterial material, EquipmentSlot slot, Item.Properties properties) {
        super(material, slot, properties);
        if(!slot.equals(EquipmentSlot.LEGS)) {
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
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "thermal_extra:textures/models/armor/"+this.armorTexture+".png";
    }
}