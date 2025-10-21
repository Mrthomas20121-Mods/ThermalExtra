package mrthomas20121.thermal_extra.fluid;

import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class FluidHolder {

    private static TagKey<Fluid> forgeTag(String name) {
        return TagKey.create(Registries.FLUID, new ResourceLocation("forge", name));
    }

    protected ResourceLocation name;
    protected RegistryObject<ForgeFlowingFluid> stillFluid;
    protected RegistryObject<ForgeFlowingFluid> flowingFluid;
    protected RegistryObject<LiquidBlock> block;
    protected RegistryObject<Item> bucket;
    private final RegistryObject<FluidType> type;
    private boolean isMetal = false;
    private final TagKey<Fluid> tag;

    public FluidHolder(ResourceLocation name, Supplier<FluidType> fluidTypeSupplier, BlockBehaviour.Properties properties) {
        this.name = name;
        this.stillFluid = ThermalExtraFluids.FLUIDS.register(name.getPath(), () -> new ForgeFlowingFluid.Source(this.fluidProperties()));
        this.flowingFluid = ThermalExtraFluids.FLUIDS.register(flowing(name.getPath()), () -> new ForgeFlowingFluid.Flowing(this.fluidProperties()));
        this.type = ThermalExtraFluids.FLUID_TYPES.register(name.getPath(), fluidTypeSupplier);
        this.bucket = ThermalExtraItems.ITEMS.register(bucket(name.getPath()), () -> new BucketItem(stillFluid, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        this.block = ThermalExtraBlocks.BLOCKS.register(name.getPath(), () -> new LiquidBlock(flowingFluid, properties));
        this.tag = forgeTag(isMetal ? molten(this.name.getPath()): this.name.getPath());
    }

    public FluidHolder metal() {
        isMetal = true;
        return this;
    }

    public RegistryObject<Item> getBucket() {
        return this.bucket;
    }

    public RegistryObject<ForgeFlowingFluid> getFlowingFluid() {
        return flowingFluid;
    }

    public RegistryObject<ForgeFlowingFluid> getStillFluid() {
        return stillFluid;
    }

    public RegistryObject<ForgeFlowingFluid> still() {
        return this.getStillFluid();
    }

    public RegistryObject<ForgeFlowingFluid> flowing() {
        return this.getFlowingFluid();
    }

    public boolean isMetal() {
        return isMetal;
    }

    public RegistryObject<LiquidBlock> getBlock() {
        return block;
    }

    public RegistryObject<FluidType> getType() {
        return type;
    }

    public ResourceLocation getName() {
        return name;
    }

    public TagKey<Fluid> tag() {
        return this.tag;
    }

    protected ForgeFlowingFluid.Properties fluidProperties() {
        return new ForgeFlowingFluid.Properties(this.type, this.stillFluid, this.flowingFluid).block(this.block).bucket(this.bucket);
    }

    public String fluid(String fluid) {
        return fluid + "_fluid";
    }

    public String flowing(String fluid) {
        return fluid + "_flowing";
    }

    public String bucket(String fluid) {
        return fluid + "_bucket";
    }

    public String molten(String fluid) {
        return "molten_"+fluid;
    }
}
