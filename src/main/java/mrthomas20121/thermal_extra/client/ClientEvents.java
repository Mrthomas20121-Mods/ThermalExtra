package mrthomas20121.thermal_extra.client;

import cofh.core.client.event.CoreClientEvents;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.client.screens.AdvancedItemFilterScreen;
import mrthomas20121.thermal_extra.client.screens.DynamoFrostScreen;
import mrthomas20121.thermal_extra.client.screens.device.DeviceLavaGenScreen;
import mrthomas20121.thermal_extra.client.screens.machine.*;
import mrthomas20121.thermal_extra.init.ThermalExtraContainers;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ThermalExtra.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void itemTooltipEvent(ItemTooltipEvent event) {
        ResourceLocation item = ForgeRegistries.ITEMS.getKey(event.getItemStack().getItem());

        if(item != null && item.getPath().equals("device_lava_gen")) {
            event.getToolTip().add(1, Component.translatable("info.thermal_extra.lava_gen_nether.0").withStyle(ChatFormatting.GOLD));
        }
    }
}
