package mrthomas20121.thermal_extra.item;

import cofh.thermal.lib.item.AugmentItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

import static cofh.lib.util.helpers.StringHelper.getTextComponent;

public class CustomAugmentItem extends AugmentItem {
    public CustomAugmentItem(Properties builder, CompoundNBT augmentData) {
        super(builder, augmentData);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(1, getTextComponent(String.format("item.%s.%s.desc", this.getRegistryName().getNamespace(), this.getRegistryName().getPath()))
                .withStyle(TextFormatting.GOLD));
    }
}
