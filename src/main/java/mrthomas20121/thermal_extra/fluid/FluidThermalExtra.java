package mrthomas20121.thermal_extra.fluid;

import cofh.lib.common.fluid.FluidCoFH;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FluidThermalExtra extends FluidCoFH {

    private final String key;
    private final RegistryObject<FluidType> type;

    public FluidThermalExtra(String key, String stillTexture, String flowTexture, int temp) {
        super(ThermalExtraFluids.FLUIDS, key);

        this.key = key;

        type = ThermalExtraFluids.FLUID_TYPES.register(key, () -> new FluidType(FluidType.Properties.create()
                .lightLevel(12)
                .density(4000)
                .viscosity(2500)
                .temperature(temp)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BOTTLE_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BOTTLE_EMPTY)) {

            @Override
            public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {

                consumer.accept(new ClientFluidTypeExtensions(new ResourceLocation(stillTexture), new ResourceLocation(flowTexture)));
            }
        });

        bucket = ThermalExtraItems.ITEMS.register(bucket(key), () -> new BucketItem(stillFluid, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    }

    public RegistryObject<Item> getBucket() {
        return this.bucket;
    }

    public RegistryObject<ForgeFlowingFluid> getStillFluid() {
        return this.stillFluid;
    }

    public RegistryObject<ForgeFlowingFluid> getFlowingFluid() {
        return this.flowingFluid;
    }

    @Override
    protected ForgeFlowingFluid.Properties fluidProperties() {

        return new ForgeFlowingFluid.Properties(type(), stillFluid, flowingFluid).bucket(bucket);
    }

    public TagKey<Fluid> getFluidTag() {
        return FluidTags.create(new ResourceLocation("forge", "molten_"+key));
    }

    @Override
    protected Supplier<FluidType> type() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public static class ClientFluidTypeExtensions implements IClientFluidTypeExtensions {

        private final ResourceLocation still;
        private final ResourceLocation flow;

        public ClientFluidTypeExtensions(ResourceLocation still, ResourceLocation flow) {

            this.still = still;
            this.flow = flow;
        }

        @Override
        public ResourceLocation getStillTexture() {
            return this.still;
        }

        @Override
        public ResourceLocation getFlowingTexture() {
            return this.flow;
        }
    }
}
