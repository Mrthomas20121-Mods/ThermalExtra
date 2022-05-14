package mrthomas20121.thermal_extra;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ThermalExtra.MOD_ID)
public class CommonEvents {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void dropEvent(LivingDropsEvent event) {

        if(event.isCanceled()) {
            return;
        }

        DamageSource source = event.getSource();
        Entity attacker = source.getEntity();

        if(attacker instanceof Player && event.getEntityLiving() instanceof EnderMan enderman) {
            Player player = (Player) attacker;
            int index = 0;
            for(ItemStack stack: player.getArmorSlots()) {
                if(!stack.isEmpty()) {
                    if(stack.getItem().getRegistryName().toString().contains("thermal_extra:dragon_bronze")) {
                        index++;
                    }
                }
            }

            if(index == 4) {
                event.getDrops().add(new ItemEntity(enderman.level, enderman.getX()+0.5d, enderman.getY()+0.5d, enderman.getZ()+0.5d, new ItemStack(Items.DRAGON_BREATH)));
            }
        }
    }
}
