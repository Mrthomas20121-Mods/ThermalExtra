package mrthomas20121.thermal_extra;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ThermalExtra.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class CommonEvents {

    @SubscribeEvent
    public static void itemTooltipEvent(ItemTooltipEvent event) {
        ResourceLocation item = ForgeRegistries.ITEMS.getKey(event.getItemStack().getItem());

        if(item != null && item.getPath().equals("device_lava_gen")) {
            event.getToolTip().add(1, Component.translatable("info.thermal_extra.lava_gen_nether").withStyle(ChatFormatting.GOLD));
        }
    }
}
