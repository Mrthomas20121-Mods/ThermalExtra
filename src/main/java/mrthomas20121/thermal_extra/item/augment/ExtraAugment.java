package mrthomas20121.thermal_extra.item.augment;

import cofh.core.util.helpers.AugmentDataHelper;
import cofh.lib.util.DeferredRegisterCoFH;
import cofh.thermal.lib.common.item.AugmentItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.RegistryObject;

public class ExtraAugment {

    public static ExtraAugment builder(DeferredRegisterCoFH<Item> registry) {
        return new ExtraAugment(registry);
    }

    private final DeferredRegisterCoFH<Item> registry;
    private final AugmentDataHelper.Builder helper = AugmentDataHelper.builder();
    private Rarity rare;

    public ExtraAugment(DeferredRegisterCoFH<Item> registry) {
        this.registry = registry;
    }

    public ExtraAugment type(String type) {
        helper.type(type);
        return this;
    }

    public ExtraAugment mod(String s, float value) {
        this.helper.mod(s, value);
        return this;
    }

    public ExtraAugment feature(String mod, String value) {
        this.helper.feature(mod, value);
        return this;
    }

    public ExtraAugment rarity(Rarity r) {
        this.rare = r;
        return this;
    }

    public RegistryObject<AugmentItem> build(String name) {
        return registry.register(name, () -> new AugmentItem(new Item.Properties().rarity(this.rare), helper.build()));
    }
}
