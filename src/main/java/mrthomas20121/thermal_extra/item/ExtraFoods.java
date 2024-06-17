package mrthomas20121.thermal_extra.item;

import net.minecraft.world.food.FoodProperties;

public class ExtraFoods {

    public static final FoodProperties BEEF_JERKY = (new FoodProperties.Builder()).nutrition(8).saturationMod(1.4F).meat().build();
    public static final FoodProperties CHICKEN_JERKY = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).meat().build();
    public static final FoodProperties COD_JERKY = (new FoodProperties.Builder()).nutrition(5).saturationMod(1F).build();
    public static final FoodProperties MUTTON_JERKY = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).meat().build();
    public static final FoodProperties PORK_JERKY = (new FoodProperties.Builder()).nutrition(8).saturationMod(1.3F).meat().build();
    public static final FoodProperties RABBIT_JERKY = (new FoodProperties.Builder()).nutrition(5).saturationMod(1F).meat().build();
    public static final FoodProperties SALMON_JERKY = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).build();
}
