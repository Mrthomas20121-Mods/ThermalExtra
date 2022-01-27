package mrthomas20121.thermal_extra.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Foods {

    public static Food cactus_stew = (new Food.Builder()).nutrition(6).saturationMod(0.6F).effect(()->new EffectInstance(Effects.HEALTH_BOOST, 100), 0.5f).build();
}
