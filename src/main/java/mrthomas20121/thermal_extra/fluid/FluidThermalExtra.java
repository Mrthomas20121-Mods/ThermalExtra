package mrthomas20121.thermal_extra.fluid;

import cofh.lib.fluid.FluidCoFH;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.registries.RegistryObject;

public class FluidThermalExtra extends FluidCoFH {

    public FluidThermalExtra(String key, String stillTexture, String flowTexture) {
        super(ThermalExtraFluids.FLUIDS, key, FluidAttributes.builder(new ResourceLocation(stillTexture), new ResourceLocation(flowTexture))
                        .density(4000)
                        .viscosity(2500)
                        .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY));

        bucket = ThermalExtraItems.ITEMS.register(bucket(key), () -> new BucketItem(stillFluid, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ThermalExtraItems.group)));

        properties.bucket(bucket);
    }

    public RegistryObject<Item> getBucket() {
        return this.bucket;
    }

    public RegistryObject<FlowingFluid> getStillFluid() {
        return this.stillFluid;
    }

    public RegistryObject<FlowingFluid> getFlowingFluid() {
        return this.flowingFluid;
    }
}
