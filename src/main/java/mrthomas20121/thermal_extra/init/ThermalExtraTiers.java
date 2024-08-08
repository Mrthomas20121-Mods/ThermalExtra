package mrthomas20121.thermal_extra.init;

import mrthomas20121.thermal_extra.util.ExtraTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ThermalExtraTiers {

    public static final Tier SIGNALUM = register("signalum", List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE), ThermalExtraTags.Blocks.NEEDS_SIGNALUM_TOOLS, ThermalExtraTags.Items.SIGNALUM_REPAIR_MATERIAL, 4, 1751, 8.5f, 3.5f, 14);
    public static final Tier LUMIUM = register("lumium", List.of(SIGNALUM), List.of(Tiers.NETHERITE), ThermalExtraTags.Blocks.NEEDS_LUMIUM_TOOLS, ThermalExtraTags.Items.LUMIUM_REPAIR_MATERIAL, 4, 1751, 8.5f, 3.5f, 14);
    public static final Tier ENDERIUM = register("enderium", List.of(LUMIUM), List.of(Tiers.NETHERITE), ThermalExtraTags.Blocks.NEEDS_ENDERIUM_TOOLS, ThermalExtraTags.Items.ENDERIUM_REPAIR_MATERIAL, 5, 1961, 9.5f, 4.5f, 15);
    public static final Tier SOUL_INFUSED = register("soul_infused", List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE), ThermalExtraTags.Blocks.NEEDS_SOUL_INFUSED_TOOLS, ThermalExtraTags.Items.SOUL_INFUSED_REPAIR_MATERIAL, 4, 1751, 8.5f, 3.5f, 14);
    public static final Tier TWINITE = register("twinite", List.of(ENDERIUM), List.of(Tiers.NETHERITE), ThermalExtraTags.Blocks.NEEDS_TWINITE_TOOLS, ThermalExtraTags.Items.TWINITE_REPAIR_MATERIAL, 4, 2001, 10f, 5f, 16);
    public static final Tier SHELLITE = register("shellite", List.of(TWINITE), List.of(Tiers.NETHERITE), ThermalExtraTags.Blocks.NEEDS_SHELLITE_TOOLS, ThermalExtraTags.Items.SHELLITE_REPAIR_MATERIAL, 4, 2001, 10.5f, 5.5f, 16);
    public static final Tier DRAGONSTEEL = register("dragonsteel", List.of(Tiers.NETHERITE), List.of(), ThermalExtraTags.Blocks.NEEDS_DRAGONSTEEL_TOOLS, ThermalExtraTags.Items.DRAGONSTEEL_REPAIR_MATERIAL, 4, 2001, 11f, 6f, 16);
    public static final Tier ABYSSAL = register("abyssal", List.of(DRAGONSTEEL), List.of(), ThermalExtraTags.Blocks.NEEDS_ABYSSAL_TOOLS, ThermalExtraTags.Items.ABYSSAL_REPAIR_MATERIAL, 4, 2001, 11.5f, 6.5f, 16);

    private static Tier register(String name, List<Object> before, List<Object> after, TagKey<Block> tag, TagKey<Item> ingredient, int level, int uses, float speed, float damage, int enchantmentValue)
    {
        final Tier tier = new ExtraTier(name, level, uses, speed, damage, enchantmentValue, tag, () -> Ingredient.of(ingredient));
        TierSortingRegistry.registerTier(tier, new ResourceLocation("thermal_extra", name), before, after);
        return tier;
    }
}
