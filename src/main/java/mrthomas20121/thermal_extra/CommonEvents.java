package mrthomas20121.thermal_extra;

import cofh.core.init.CoreMobEffects;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import mrthomas20121.thermal_extra.init.ThermalExtraTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityMobGriefingEvent;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ThermalExtra.MOD_ID)
public class CommonEvents {

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(ThermalExtraItems::augmentFlags);
    }

    @SubscribeEvent
    public static void visibilityEvent(LivingEvent.LivingVisibilityEvent event) {

        // this is always nonnull in vanilla, but you never know
        Entity lookingEntity = event.getLookingEntity();
        if(lookingEntity == null) {
            return;
        }

        if(isFullArmor(ThermalExtraTags.Items.TWINITE_ARMOR, event.getEntity()) && lookingEntity.getType().equals(EntityType.BLAZE)) {
            event.modifyVisibility(0.2f);
        }
    }

    @SubscribeEvent
    public static void attackEntity(AttackEntityEvent event) {
        if(!event.isCanceled()) {
            Player player = event.getEntity();
            if(player.getMainHandItem().is(ThermalExtraTags.Items.ABYSSAL_TOOLS)) {
                if(event.getTarget() instanceof LivingEntity entity && !entity.hasEffect(MobEffects.WEAKNESS)) {
                    entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS));
                }
            }
        }
    }

    @SubscribeEvent
    public static void criticalHit(CriticalHitEvent event) {
        if(!event.isCanceled()) {
            Player player = event.getEntity();
            if(player.getMainHandItem().is(ThermalExtraTags.Items.DRAGONSTEEL_TOOLS)) {
               event.setDamageModifier(5f);
               if(player.level().getRandom().nextFloat() <= 0.3F) {
                   event.setResult(Event.Result.ALLOW);
                }
            }
        }
    }

    @SubscribeEvent
    public static void enderPearlEvent(EntityTeleportEvent.EnderPearl event) {
        if(isFullArmor(ThermalExtraTags.Items.ENDERIUM_ARMOR, event.getPlayer())) {
            event.setAttackDamage(0);
        }
    }

    @SubscribeEvent
    public static void takeDamage(LivingHurtEvent event) {
        if(event.getEntity() instanceof Player player && isFullArmor(ThermalExtraTags.Items.SHELLITE_ARMOR, player) && event.getSource().is(DamageTypeTags.IS_FALL)) {
            event.setAmount(event.getAmount()*0.2f);
        }
        else if(event.getSource().getDirectEntity() instanceof LivingEntity living) {
            LivingEntity target = event.getEntity();
            if(living.isHolding(stack -> stack.is(ThermalExtraTags.Items.ENDERIUM_TOOLS))) {
                if(isInTag(target.getType(), ThermalExtraTags.EntityTypes.ENDER_MOBS)) {
                    event.setAmount(event.getAmount()*1.5f);
                }
            }
        }
    }

    private static boolean isInTag(EntityType<?> entityType, TagKey<EntityType<?>> tag) {
        return ForgeRegistries.ENTITY_TYPES.tags().getTag(tag).contains(entityType);
    }

    /**
     * get the name of an entity
     * @param entityType entity
     * @return
     */
    private static String getEntityName(EntityType<?> entityType) {
        ResourceLocation loc = ForgeRegistries.ENTITY_TYPES.getKey(entityType);

        if(loc != null) {
            return loc.getPath();
        }

        return "empty";
    }

    /**
     * Return true if the entity is wearing the armor set
     * @param armor the armor tag
     * @param entity the entity to check
     * @return
     */
    private static boolean isFullArmor(TagKey<Item> armor, LivingEntity entity) {
        boolean bool = true;

        // loop through the equipment slots
        for(EquipmentSlot slot: EquipmentSlot.values()) {
            // ignore mainhand and offhand
            if(slot.equals(EquipmentSlot.MAINHAND) || slot.equals(EquipmentSlot.OFFHAND)) {
                continue;
            }

            // is the item in slot in the tag?
            if(!entity.getItemBySlot(slot).is(armor)) {
                bool = false;
            }

            // stop the for loop when bool is false, not need to go further
            if(!bool) {
                break;
            }
        }
        return bool;
    }
}
