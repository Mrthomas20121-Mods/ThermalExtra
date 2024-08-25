package mrthomas20121.thermal_extra.init;

import cofh.core.common.item.BlockItemCoFH;
import cofh.core.common.item.CountedItem;
import cofh.core.common.item.ItemCoFH;
import cofh.core.util.helpers.AugmentDataHelper;
import cofh.lib.util.DeferredRegisterCoFH;
import cofh.thermal.lib.common.item.AugmentItem;
import cofh.thermal.lib.common.item.BlockItemAugmentable;
import mrthomas20121.thermal_extra.filter.AdvancedFilter;
import mrthomas20121.thermal_extra.item.ExtraFoods;
import mrthomas20121.thermal_extra.item.SmithingTemplateHelper;
import mrthomas20121.thermal_extra.item.ToolSetObject;
import mrthomas20121.thermal_extra.item.augment.EnumAugment;
import mrthomas20121.thermal_extra.item.augment.ExtraAugmentType;
import mrthomas20121.thermal_extra.item.augment.UpgradeAugmentItem;
import mrthomas20121.thermal_extra.util.Utils;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static cofh.lib.util.constants.NBTTags.*;
import static cofh.thermal.lib.util.ThermalAugmentRules.*;

@Mod.EventBusSubscriber(modid = mrthomas20121.thermal_extra.ThermalExtra.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ThermalExtraItems {

    public static DeferredRegisterCoFH<Item> ITEMS = DeferredRegisterCoFH.create(ForgeRegistries.ITEMS, mrthomas20121.thermal_extra.ThermalExtra.MOD_ID);

    public static Rarity yellow = Rarity.UNCOMMON;
    public static Rarity dark_aqua = Rarity.create("extra_dark_aqua", style -> style.withColor(ChatFormatting.DARK_AQUA));
    public static Rarity dark_purple = Rarity.create("extra_dark_purple", style -> style.withColor(ChatFormatting.DARK_PURPLE));
    public static Rarity red = Rarity.create("extra_red", style -> style.withColor(ChatFormatting.RED));
    public static Rarity blue = Rarity.create("extra_blue", style -> style.withColor(ChatFormatting.BLUE));
    public static Rarity green = Rarity.create("extra_green", style -> style.withColor(ChatFormatting.DARK_GREEN));

    public static final RegistryObject<BlockItemCoFH> DYNAMO_COLD = ITEMS.register("dynamo_frost", () -> new BlockItemAugmentable(ThermalExtraBlocks.DYNAMO_COLD.get(), new Item.Properties()).setAugValidator(DYNAMO_NO_FLUID_VALIDATOR));

    public static final RegistryObject<SmithingTemplateItem> AUGMENT_TEMPLATE = ITEMS.register("augment_smithing_upgrade", () -> SmithingTemplateHelper.createTemplate("augment"));

    public static final RegistryObject<Item> BEEF_JERKY = ITEMS.register("beef_jerky", item(prop -> prop.food(ExtraFoods.BEEF_JERKY)));
    public static final RegistryObject<Item> CHICKEN_JERKY = ITEMS.register("chicken_jerky", item(prop -> prop.food(ExtraFoods.CHICKEN_JERKY)));
    public static final RegistryObject<Item> COD_JERKY = ITEMS.register("cod_jerky", item(prop -> prop.food(ExtraFoods.COD_JERKY)));
    public static final RegistryObject<Item> MUTTON_JERKY = ITEMS.register("mutton_jerky", item(prop -> prop.food(ExtraFoods.MUTTON_JERKY)));
    public static final RegistryObject<Item> PORK_JERKY = ITEMS.register("pork_jerky", item(prop -> prop.food(ExtraFoods.PORK_JERKY)));
    public static final RegistryObject<Item> RABBIT_JERKY = ITEMS.register("rabbit_jerky", item(prop -> prop.food(ExtraFoods.RABBIT_JERKY)));
    public static final RegistryObject<Item> SALMON_JERKY = ITEMS.register("salmon_jerky", item(prop -> prop.food(ExtraFoods.SALMON_JERKY)));

    public static final RegistryObject<Item> COPPER_ORE_CHUNK = ITEMS.register("copper_ore_chunk", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> IRON_ORE_CHUNK = ITEMS.register("iron_ore_chunk", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> GOLD_ORE_CHUNK = ITEMS.register("gold_ore_chunk", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> TIN_ORE_CHUNK = ITEMS.register("tin_ore_chunk", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> SILVER_ORE_CHUNK = ITEMS.register("silver_ore_chunk", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> LEAD_ORE_CHUNK = ITEMS.register("lead_ore_chunk", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> NICKEL_ORE_CHUNK = ITEMS.register("nickel_ore_chunk", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> ALUMINUM_ORE_CHUNK = ITEMS.register("aluminum_ore_chunk", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> URANIUM_ORE_CHUNK = ITEMS.register("uranium_ore_chunk", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> OSMIUM_ORE_CHUNK = ITEMS.register("osmium_ore_chunk", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> ARCANE_GOLD_ORE_CHUNK = ITEMS.register("arcane_gold_ore_chunk", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> ZINC_ORE_CHUNK = ITEMS.register("zinc_ore_chunk", item((prop) -> prop.rarity(yellow)));

    public static final RegistryObject<Item> ARCANE_GOLD_DUST = ITEMS.register("arcane_gold_dust", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> ZINC_DUST = ITEMS.register("zinc_dust", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> ANCIENT_DUST = ITEMS.register("ancient_dust", item((prop) -> prop.rarity(blue)));
    public static final RegistryObject<Item> OBSIDIAN_DUST = ITEMS.register("obsidian_dust", item((prop) -> prop.rarity(dark_purple)));
    public static final RegistryObject<Item> AMETHYST_DUST = ITEMS.register("amethyst_dust", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> SOUL_SAND_DUST = ITEMS.register("soul_sand_dust", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> STICKY_BALL = ITEMS.register("sticky_ball", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> CHILLER_PLATE_CAST = ITEMS.register("chiller_plate_cast", item((prop) -> {}));
    public static final RegistryObject<Item> POLYOLEFIN_PLATE = ITEMS.register("polyolefin_plate", item((prop) -> prop.rarity(yellow), true));

    public static ToolSetObject SIGNALUM_SET = new ToolSetObject(ITEMS, "signalum", ThermalExtraTiers.SIGNALUM, ThermalExtraArmorMaterials.SIGNALUM, yellow);
    public static ToolSetObject LUMIUM_SET = new ToolSetObject(ITEMS, "lumium", ThermalExtraTiers.LUMIUM, ThermalExtraArmorMaterials.LUMIUM, yellow);
    public static ToolSetObject ENDERIUM_SET = new ToolSetObject(ITEMS, "enderium", ThermalExtraTiers.ENDERIUM, ThermalExtraArmorMaterials.ENDERIUM, yellow);

    public static final RegistryObject<Item> PRESS_ROD_DIE = ITEMS.register("press_rod_die", item());
    public static final RegistryObject<Item> COPPER_ROD = ITEMS.register("copper_rod", item());
    public static final RegistryObject<Item> IRON_ROD = ITEMS.register("iron_rod", item());
    public static final RegistryObject<Item> GOLD_ROD = ITEMS.register("gold_rod", item());
    public static final RegistryObject<Item> DIAMOND_ROD = ITEMS.register("diamond_rod", item());
    public static final RegistryObject<Item> NETHERITE_ROD = ITEMS.register("netherite_rod", item());
    public static final RegistryObject<Item> EMERALD_ROD = ITEMS.register("emerald_rod", item());
    public static final RegistryObject<Item> LEAD_ROD = ITEMS.register("lead_rod", item());
    public static final RegistryObject<Item> TIN_ROD = ITEMS.register("tin_rod", item());
    public static final RegistryObject<Item> SILVER_ROD = ITEMS.register("silver_rod", item());
    public static final RegistryObject<Item> NICKEL_ROD = ITEMS.register("nickel_rod", item());
    public static final RegistryObject<Item> BRONZE_ROD = ITEMS.register("bronze_rod", item());
    public static final RegistryObject<Item> ELECTRUM_ROD = ITEMS.register("electrum_rod", item());
    public static final RegistryObject<Item> CONSTANTAN_ROD = ITEMS.register("constantan_rod", item());
    public static final RegistryObject<Item> INVAR_ROD = ITEMS.register("invar_rod", item());
    public static final RegistryObject<Item> SIGNALUM_ROD = ITEMS.register("signalum_rod", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> LUMIUM_ROD = ITEMS.register("lumium_rod", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> ENDERIUM_ROD = ITEMS.register("enderium_rod", item((prop) -> prop.rarity(yellow)));

    public static ToolSetObject SOUL_INFUSED_SET = new ToolSetObject(ITEMS, "soul_infused", ThermalExtraTiers.SOUL_INFUSED, ThermalExtraArmorMaterials.SOUL_INFUSED, yellow);
	public static final RegistryObject<Item> SOUL_INFUSED_INGOT = ITEMS.register("soul_infused_ingot", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> SOUL_INFUSED_NUGGET = ITEMS.register("soul_infused_nugget", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> SOUL_INFUSED_DUST = ITEMS.register("soul_infused_dust", item((prop) -> prop.rarity(yellow)));
    public static final RegistryObject<Item> SOUL_INFUSED_PLATE = ITEMS.register("soul_infused_plate", item((prop) -> prop.rarity(yellow), true));
    public static final RegistryObject<Item> SOUL_INFUSED_GEAR = ITEMS.register("soul_infused_gear", item((prop) -> prop.rarity(yellow), true));
    public static final RegistryObject<Item> SOUL_INFUSED_COIN = ITEMS.register("soul_infused_coin", item((prop) -> prop.rarity(yellow), true));
    public static final RegistryObject<Item> SOUL_INFUSED_ROD = ITEMS.register("soul_infused_rod", item((prop) -> prop.rarity(yellow)));

    public static ToolSetObject SHELLITE_SET = new ToolSetObject(ITEMS, "shellite", ThermalExtraTiers.SHELLITE, ThermalExtraArmorMaterials.SHELLITE, dark_purple);
    public static final RegistryObject<Item> SHELLITE_INGOT = ITEMS.register("shellite_ingot", item((prop) -> prop.rarity(dark_purple)));
    public static final RegistryObject<Item> SHELLITE_NUGGET = ITEMS.register("shellite_nugget", item((prop) -> prop.rarity(dark_purple)));
    public static final RegistryObject<Item> SHELLITE_DUST = ITEMS.register("shellite_dust", item((prop) -> prop.rarity(dark_purple)));
    public static final RegistryObject<Item> SHELLITE_PLATE = ITEMS.register("shellite_plate", item((prop) -> prop.rarity(dark_purple), true));
    public static final RegistryObject<Item> SHELLITE_GEAR = ITEMS.register("shellite_gear", item((prop) -> prop.rarity(dark_purple)));
    public static final RegistryObject<Item> SHELLITE_COIN = ITEMS.register("shellite_coin", item((prop) -> prop.rarity(dark_purple), true));
    public static final RegistryObject<Item> SHELLITE_ROD = ITEMS.register("shellite_rod", item((prop) -> prop.rarity(dark_purple)));

    public static ToolSetObject TWINITE_SET = new ToolSetObject(ITEMS, "twinite", ThermalExtraTiers.TWINITE, ThermalExtraArmorMaterials.TWINITE, red);
    public static final RegistryObject<Item> TWINITE_INGOT = ITEMS.register("twinite_ingot", item((prop) -> prop.rarity(red)));
    public static final RegistryObject<Item> TWINITE_NUGGET = ITEMS.register("twinite_nugget", item((prop) -> prop.rarity(red)));
    public static final RegistryObject<Item> TWINITE_DUST = ITEMS.register("twinite_dust", item((prop) -> prop.rarity(red)));
    public static final RegistryObject<Item> TWINITE_PLATE = ITEMS.register("twinite_plate", item((prop) -> prop.rarity(red), true));
    public static final RegistryObject<Item> TWINITE_GEAR = ITEMS.register("twinite_gear", item((prop) -> prop.rarity(red)));
    public static final RegistryObject<Item> TWINITE_COIN = ITEMS.register("twinite_coin", item((prop) -> prop.rarity(red), true));
    public static final RegistryObject<Item> TWINITE_ROD = ITEMS.register("twinite_rod", item((prop) -> prop.rarity(red)));

    public static ToolSetObject DRAGONSTEEL_SET = new ToolSetObject(ITEMS, "dragonsteel", ThermalExtraTiers.DRAGONSTEEL, ThermalExtraArmorMaterials.DRAGONSTEEL, blue);
    public static final RegistryObject<Item> DRAGONSTEEL_INGOT = ITEMS.register("dragonsteel_ingot", item((prop) -> prop.rarity(blue)));
    public static final RegistryObject<Item> DRAGONSTEEL_NUGGET = ITEMS.register("dragonsteel_nugget", item((prop) -> prop.rarity(blue)));
    public static final RegistryObject<Item> DRAGONSTEEL_DUST = ITEMS.register("dragonsteel_dust", item((prop) -> prop.rarity(blue)));
    public static final RegistryObject<Item> DRAGONSTEEL_PLATE = ITEMS.register("dragonsteel_plate", item((prop) -> prop.rarity(blue), true));
    public static final RegistryObject<Item> DRAGONSTEEL_GEAR = ITEMS.register("dragonsteel_gear", item((prop) -> prop.rarity(blue)));
    public static final RegistryObject<Item> DRAGONSTEEL_COIN = ITEMS.register("dragonsteel_coin", item((prop) -> prop.rarity(blue), true));
    public static final RegistryObject<Item> DRAGONSTEEL_ROD = ITEMS.register("dragonsteel_rod", item((prop) -> prop.rarity(blue)));


    public static ToolSetObject ABYSSAL_SET = new ToolSetObject(ITEMS, "abyssal", ThermalExtraTiers.ABYSSAL, ThermalExtraArmorMaterials.ABYSSAL, green);
    public static final RegistryObject<Item> ABYSSAL_INGOT = ITEMS.register("abyssal_ingot", item((prop) -> prop.rarity(green)));
    public static final RegistryObject<Item> ABYSSAL_NUGGET = ITEMS.register("abyssal_nugget", item((prop) -> prop.rarity(green)));
    public static final RegistryObject<Item> ABYSSAL_DUST = ITEMS.register("abyssal_dust", item((prop) -> prop.rarity(green)));
    public static final RegistryObject<Item> ABYSSAL_PLATE = ITEMS.register("abyssal_plate", item((prop) -> prop.rarity(green), true));
    public static final RegistryObject<Item> ABYSSAL_GEAR = ITEMS.register("abyssal_gear", item((prop) -> prop.rarity(green)));
    public static final RegistryObject<Item> ABYSSAL_COIN = ITEMS.register("abyssal_coin", item((prop) -> prop.rarity(green), true));
    public static final RegistryObject<Item> ABYSSAL_ROD = ITEMS.register("abyssal_rod", item((prop) -> prop.rarity(green)));

    public static final Map<EnumAugment, Map<ExtraAugmentType, RegistryObject<AugmentItem>>> AUGMENTS = Utils.mapOfKeys(EnumAugment.class, e ->
        Utils.mapOfKeys(ExtraAugmentType.class, augment -> e.build(augment, ITEMS)));

    public static final RegistryObject<ItemCoFH> INTEGRAL_COMPONENT = ITEMS.register("upgrade_augment", () -> new UpgradeAugmentItem(new Item.Properties().rarity(blue),
            AugmentDataHelper.builder()
                    .type(TAG_AUGMENT_TYPE_UPGRADE)
                    .mod(TAG_AUGMENT_BASE_MOD, 5F)
                    .build()));

    public static final RegistryObject<ItemCoFH> ABYSSAL_INTEGRAL_COMPONENT = ITEMS.register("abyssal_upgrade_augment", () -> new UpgradeAugmentItem(new Item.Properties().rarity(blue),
            AugmentDataHelper.builder()
                    .type(TAG_AUGMENT_TYPE_UPGRADE)
                    .mod(TAG_AUGMENT_BASE_MOD, 6F)
                    .build()));

    public static final RegistryObject<Item> AV_ITEM_FILTER_AUGMENT = ITEMS.register("av_item_filter_augment", () -> new AugmentItem(new Item.Properties().rarity(yellow),
            AugmentDataHelper.builder()
                    .type(TAG_AUGMENT_TYPE_FILTER)
                    .feature(TAG_FILTER_TYPE, AdvancedFilter.ITEM_FILTER_TYPE)
                    .build()));

    public static void augmentFlags() {
        flagUniqueAugment(ITEMS.get("integral_augment"));
        flagUniqueAugment(ITEMS.get("integral_augment_2"));
        flagUniqueAugment(ITEMS.get("av_item_filter_augment"));
    }

    public static Supplier<ItemCoFH> item() {
        return item((prop) -> {}, false);
    }

    public static Supplier<ItemCoFH> item(Consumer<Item.Properties> consumer) {
        return item(consumer, false);
    }

    public static Supplier<ItemCoFH> item(Consumer<Item.Properties> consumer, boolean count) {
        Item.Properties props = new Item.Properties();
        consumer.accept(props);
        if(count) {
            return () -> new CountedItem(props);
        }
        return () -> new ItemCoFH(props);
    }
}
