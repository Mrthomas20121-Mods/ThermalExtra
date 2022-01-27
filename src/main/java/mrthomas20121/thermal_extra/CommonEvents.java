package mrthomas20121.thermal_extra;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
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

        if(attacker instanceof PlayerEntity && event.getEntityLiving() instanceof EndermanEntity) {
            EndermanEntity enderman = (EndermanEntity) event.getEntityLiving();
            PlayerEntity player = (PlayerEntity) attacker;
            int index = 0;
            for(ItemStack stack: player.getArmorSlots()) {
                if(!stack.isEmpty()) {
                    if(stack.getItem().getRegistryName().toString().contains("thermal_extra:dragon_bronze")) {
                        index++;
                    }
                }
            }

            if(index == 4) {
                event.getDrops().add(new ItemEntity(enderman.level, enderman.getX(), enderman.getY(), enderman.getZ(), new ItemStack(Items.DRAGON_BREATH)));
            }
        }
    }
}
