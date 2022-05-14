package mrthomas20121.thermal_extra.item;

import cofh.thermal.lib.item.AugmentItem;
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

public class CustomAugmentItem extends AugmentItem {
    public CustomAugmentItem(Properties builder, CompoundTag augmentData) {
        super(builder, augmentData);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(1, getTextComponent(String.format("item.%s.%s.desc", this.getRegistryName().getNamespace(), this.getRegistryName().getPath()))
                .withStyle(ChatFormatting.GOLD));
    }
}
