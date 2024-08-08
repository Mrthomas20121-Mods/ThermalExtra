package mrthomas20121.thermal_extra.item;

import cofh.core.common.item.CountedItem;
import cofh.core.common.item.ItemCoFH;
import cofh.lib.util.DeferredRegisterCoFH;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.RegistryObject;

public class MetalSetObject {

    private final RegistryObject<Item> INGOT;
    private final RegistryObject<Item> NUGGET;
    private final RegistryObject<Item> DUST;
    private final RegistryObject<CountedItem> PLATE;
    private final RegistryObject<Item> GEAR;
    private final RegistryObject<CountedItem> COIN;
    private final RegistryObject<Item> ROD;

    public MetalSetObject(DeferredRegisterCoFH<Item> registry, String name, Rarity rarity) {
        INGOT = registry.register(name+"_ingot", () -> item(rarity));
        NUGGET = registry.register(name+"_nugget", () -> item(rarity));
        DUST = registry.register(name+"_dust", () -> item(rarity));
        PLATE = registry.register(name+"_plate", () -> itemCount(rarity));
        GEAR = registry.register(name+"_gear", () -> item(rarity));
        COIN = registry.register(name+"_coin", () -> itemCount(rarity));
        ROD = registry.register(name+"_rod", () -> item(rarity));
    }

    private Item item(Rarity rarity) {
        return new Item(new Item.Properties().rarity(rarity));
    }

    private CountedItem itemCount(Rarity rarity) {
        return new CountedItem(new Item.Properties().rarity(rarity));
    }

    public RegistryObject<Item> ingot() {
        return INGOT;
    }

    public RegistryObject<Item> nugget() {
        return NUGGET;
    }

    public RegistryObject<Item> dust() {
        return DUST;
    }

    public RegistryObject<CountedItem> plate() {
        return PLATE;
    }

    public RegistryObject<Item> gear() {
        return GEAR;
    }

    public RegistryObject<CountedItem> coin() {
        return COIN;
    }

    public RegistryObject<Item> rod() {
        return ROD;
    }
}
