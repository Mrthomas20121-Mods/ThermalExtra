package mrthomas20121.thermal_extra.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;

public class ClientFluidTypeExtension implements IClientFluidTypeExtensions {

    private final ResourceLocation still;
    private final ResourceLocation flow;

    public ClientFluidTypeExtension(ResourceLocation still, ResourceLocation flow) {

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
