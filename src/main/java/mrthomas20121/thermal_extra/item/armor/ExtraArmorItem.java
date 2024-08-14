package mrthomas20121.thermal_extra.item.armor;

import cofh.core.common.item.ArmorItemCoFH;
import mrthomas20121.thermal_extra.init.ThermalExtraArmorMaterials;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;

public class ExtraArmorItem extends ArmorItemCoFH {

    public ExtraArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return stack.getItem() instanceof ArmorItem && (((ArmorItem) stack.getItem()).getMaterial() == ArmorMaterials.GOLD || ((ArmorItem) stack.getItem()).getMaterial() == ThermalExtraArmorMaterials.LUMIUM);
    }
}
