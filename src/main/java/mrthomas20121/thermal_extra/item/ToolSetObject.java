package mrthomas20121.thermal_extra.item;

import cofh.core.common.item.*;
import cofh.lib.common.item.*;
import cofh.lib.util.DeferredRegisterCoFH;
import mrthomas20121.thermal_extra.item.armor.ExtraArmorItem;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ToolSetObject {

    private final RegistryObject<AxeItemCoFH> AXE;
    private final RegistryObject<PickaxeItemCoFH> PICKAXE;
    private final RegistryObject<HoeItemCoFH> HOE;
    private final RegistryObject<ShovelItemCoFH> SHOVEL;
    private final RegistryObject<SwordItemCoFH> SWORD;
    private final RegistryObject<ExcavatorItem> EXCAVATOR;
    private final RegistryObject<HammerItem> HAMMER;
    private final RegistryObject<KnifeItem> KNIFE;
    private final RegistryObject<SickleItem> SICKLE;
    private final RegistryObject<ArmorItemCoFH> HELMET;
    private final RegistryObject<ArmorItemCoFH> CHESTPLATE;
    private final RegistryObject<ArmorItemCoFH> LEGGINGS;
    private final RegistryObject<ArmorItemCoFH> BOOTS;

    public ToolSetObject(DeferredRegisterCoFH<Item> registry, String name, Tier tier, ArmorMaterial material, Rarity rarity) {
        this(registry, name, tier, material, rarity, false);
    }

    public ToolSetObject(DeferredRegisterCoFH<Item> registry, String name, Tier tier, ArmorMaterial material, Rarity rarity, boolean aboveNetherite) {
        Item.Properties properties = new Item.Properties().rarity(rarity).stacksTo(1);
        // tiers above netherite get higher sword attack speed
        final float swordSpeed = aboveNetherite? -2.3f: -2.4f;
        // make it fire-resistant if it's above netherite
        if(aboveNetherite) {
            properties.fireResistant();
        }
        this.AXE = registry.register(name+"_axe", () -> new AxeItemCoFH(tier, 5.0f, -3.0f, properties));
        this.PICKAXE = registry.register(name+"_pickaxe", () -> new PickaxeItemCoFH(tier, 1, -2.8f, properties));
        this.HOE = registry.register(name+"_hoe", () -> new HoeItemCoFH(tier, aboveNetherite ? -4 : -3, aboveNetherite? 0f : 0.5f, properties));
        this.SHOVEL = registry.register(name+"_shovel", () -> new ShovelItemCoFH(tier, 1.5f, -3f, properties));
        this.SWORD = registry.register(name+"_sword", () -> new SwordItemCoFH(tier, 3, swordSpeed, properties));
        this.EXCAVATOR = registry.register(name+"_excavator", () -> new ExcavatorItem(tier, properties));
        this.HAMMER = registry.register(name+"_hammer", () -> new HammerItem(tier, properties));
        this.KNIFE = registry.register(name+"_knife", () -> new KnifeItem(tier, properties));
        this.SICKLE = registry.register(name+"_sickle", () -> new SickleItem(tier, properties));
        this.HELMET = registry.register(name+"_helmet", () -> new ExtraArmorItem(material, ArmorItem.Type.HELMET, properties));
        this.CHESTPLATE = registry.register(name+"_chestplate", () -> new ExtraArmorItem(material, ArmorItem.Type.CHESTPLATE, properties));
        this.LEGGINGS = registry.register(name+"_leggings", () -> new ExtraArmorItem(material, ArmorItem.Type.LEGGINGS, properties));
        this.BOOTS = registry.register(name+"_boots", () -> new ExtraArmorItem(material, ArmorItem.Type.BOOTS, properties));
    }

    public RegistryObject<AxeItemCoFH> axe() {
        return AXE;
    }

    public RegistryObject<PickaxeItemCoFH> pickaxe() {
        return PICKAXE;
    }

    public RegistryObject<HoeItemCoFH> hoe() {
        return HOE;
    }

    public RegistryObject<ShovelItemCoFH> shovel() {
        return SHOVEL;
    }

    public RegistryObject<SwordItemCoFH> sword() {
        return SWORD;
    }

    public RegistryObject<ExcavatorItem> excavator() {
        return EXCAVATOR;
    }

    public RegistryObject<HammerItem> hammer() {
        return HAMMER;
    }

    public RegistryObject<KnifeItem> knife() {
        return KNIFE;
    }

    public RegistryObject<SickleItem> sickle() {
        return SICKLE;
    }

    public RegistryObject<ArmorItemCoFH> helmet() {
        return HELMET;
    }

    public RegistryObject<ArmorItemCoFH> chestplate() {
        return CHESTPLATE;
    }

    public RegistryObject<ArmorItemCoFH> leggings() {
        return LEGGINGS;
    }

    public RegistryObject<ArmorItemCoFH> boots() {
        return BOOTS;
    }

    public List<RegistryObject<? extends Item>> getALLItems() {
        return List.of(sword(), axe(), pickaxe(), shovel(), hoe(), excavator(), hammer(), knife(), sickle(), helmet(), chestplate(), leggings(), boots());
    }
}
