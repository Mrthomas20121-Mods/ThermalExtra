package mrthomas20121.thermal_extra.item.augment;

import cofh.thermal.lib.common.item.AugmentItem;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static cofh.lib.util.helpers.StringHelper.getTextComponent;

public class UpgradeAugmentItem extends AugmentItem {
    public UpgradeAugmentItem(Properties builder, CompoundTag augmentData) {
        super(builder, augmentData);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(1, getTextComponent("thermal_extra.augment.upgrade")
                .withStyle(ChatFormatting.GOLD));
    }
}
