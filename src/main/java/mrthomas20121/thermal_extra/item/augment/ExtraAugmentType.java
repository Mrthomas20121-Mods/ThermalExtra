package mrthomas20121.thermal_extra.item.augment;

import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import net.minecraft.world.item.Rarity;

public enum ExtraAugmentType {

    SOUL_INFUSED(ThermalExtraItems.yellow),
    TWINITE(ThermalExtraItems.red),
    SHELLITE(ThermalExtraItems.dark_purple),
    DRAGONSTEEL(ThermalExtraItems.blue),
    ABYSSAL(ThermalExtraItems.green);

    public static final ExtraAugmentType[] VALUES = ExtraAugmentType.values();

    private final Rarity rarity;
    private final int tier;

    ExtraAugmentType(Rarity rarity) {
        this.rarity = rarity;
        this.tier = this.ordinal()+1;
    }

    public int getTier() {
        return tier;
    }

    public Rarity getRarity() {
        return rarity;
    }
}
