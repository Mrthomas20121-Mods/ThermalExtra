package mrthomas20121.thermal_extra.init;

import cofh.lib.util.DeferredRegisterCoFH;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.fluid.ClientFluidTypeExtension;
import mrthomas20121.thermal_extra.fluid.FluidHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ThermalExtraFluids {
    public static final DeferredRegisterCoFH<Fluid> FLUIDS = DeferredRegisterCoFH.create(ForgeRegistries.FLUIDS, ThermalExtra.MOD_ID);
    public static final DeferredRegisterCoFH<FluidType> FLUID_TYPES = DeferredRegisterCoFH.create(ForgeRegistries.Keys.FLUID_TYPES, ThermalExtra.MOD_ID);

    // metals
    public static FluidHolder SOUL_INFUSED = register(modLoc("soul_infused"), hot(1000), MapColor.COLOR_ORANGE, 15).metal();
    public static FluidHolder TWINITE = register(modLoc("twinite"), hot(1000), MapColor.COLOR_PINK, 15).metal();
    public static FluidHolder SHELLITE = register(modLoc("shellite"), hot(1300), MapColor.COLOR_MAGENTA, 15).metal();
    public static FluidHolder DRAGONSTEEL = register(modLoc("dragonsteel"), hot(1500), MapColor.COLOR_CYAN, 15).metal();
    public static FluidHolder ABYSSAL = register(modLoc("abyssal"), hot(1500), MapColor.TERRACOTTA_LIGHT_GREEN, 15).metal();

    public static FluidHolder RAW_ALUMINUM = register(modLoc("raw_aluminum"), hot(500), MapColor.COLOR_ORANGE, 15).metal();
    public static FluidHolder RAW_ARCANE_GOLD = register(modLoc("raw_arcane_gold"), hot(500), MapColor.COLOR_YELLOW, 15).metal();
    public static FluidHolder RAW_COPPER = register(modLoc("raw_copper"), hot(500), MapColor.COLOR_ORANGE, 15).metal();
    public static FluidHolder RAW_GOLD = register(modLoc("raw_gold"), hot(500), MapColor.COLOR_YELLOW, 15).metal();
    public static FluidHolder RAW_IRON = register(modLoc("raw_iron"), hot(500), MapColor.RAW_IRON, 15).metal();
    public static FluidHolder RAW_LEAD = register(modLoc("raw_lead"), hot(500), MapColor.TERRACOTTA_BLUE, 15).metal();
    public static FluidHolder RAW_NICKEL = register(modLoc("raw_nickel"), hot(500), MapColor.TERRACOTTA_YELLOW, 15).metal();
    public static FluidHolder RAW_OSMIUM = register(modLoc("raw_osmium"), hot(500), MapColor.COLOR_LIGHT_BLUE, 15).metal();
    public static FluidHolder RAW_SILVER = register(modLoc("raw_silver"), hot(500), MapColor.COLOR_LIGHT_GRAY, 15).metal();
    public static FluidHolder RAW_TIN = register(modLoc("raw_tin"), hot(500), MapColor.COLOR_LIGHT_GRAY, 15).metal();
    public static FluidHolder RAW_URANIUM = register(modLoc("raw_uranium"), hot(500), MapColor.TERRACOTTA_GREEN, 15).metal();
    public static FluidHolder RAW_ZINC = register(modLoc("raw_zinc"), hot(500), MapColor.COLOR_GRAY, 15).metal();

    // metal like fluids
    public static FluidHolder DIESEL = register(modLoc("diesel"), hot(300), MapColor.COLOR_ORANGE, 15);
    public static FluidHolder GASOLINE = register(modLoc("gasoline"), hot(300), MapColor.TERRACOTTA_BLUE, 15);
    public static FluidHolder NAPHTHA = register(modLoc("naphtha"), hot(300), MapColor.TERRACOTTA_BLUE, 15);

    // non metal fluids
    public static FluidHolder PARAFFIN_WAX = register(modLoc("paraffin_wax"), 300, MapColor.QUARTZ, 5);
    public static FluidHolder LUBRICANT = register(modLoc("lubricant"), liquid(800), MapColor.TERRACOTTA_YELLOW, 10);
    public static FluidHolder SUNFLOWER_OIL = register(modLoc("sunflower_oil"), liquid(500), MapColor.COLOR_YELLOW, 3);
    public static FluidHolder CRYSTALLIZED_SUNFLOWER_OIL = register(modLoc("crystallized_sunflower_oil"), liquid(500), MapColor.COLOR_YELLOW, 5);
    public static FluidHolder REFINED_SUNFLOWER_OIL = register(modLoc("refined_sunflower_oil"), liquid(500), MapColor.COLOR_ORANGE, 10);
    public static FluidHolder FLUX_INFUSED_OIL = register(modLoc("flux_infused_oil"), 300, MapColor.COLOR_ORANGE, 15);
    public static FluidHolder POLYOLEFIN = register(modLoc("polyolefin"), liquid(500), MapColor.TERRACOTTA_LIGHT_GRAY, 5);

    private static FluidType.Properties hot(int temp) {
        return FluidType.Properties.create().density(2000).viscosity(10000).temperature(temp)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                // from forge lava type
                .motionScale(0.0023333333333333335D)
                .canSwim(false).canDrown(false)
                .pathType(BlockPathTypes.LAVA).adjacentPathType(null);
    }

    private static FluidType.Properties liquid(int temp) {
        return FluidType.Properties.create().density(2000).viscosity(10000).temperature(temp)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                // from forge lava type
                .motionScale(0.0023333333333333335D)
                .canExtinguish(true)
                .pathType(BlockPathTypes.WATER).adjacentPathType(BlockPathTypes.WATER_BORDER);
    }

    private static ResourceLocation modLoc(String name) {
        return new ResourceLocation(ThermalExtra.MOD_ID, name);
    }

    private static BlockBehaviour.Properties createProperties(MapColor color, int lightLevel) {
        return BlockBehaviour.Properties.of().mapColor(color).replaceable().noCollission().randomTicks().strength(100.0F).lightLevel(state -> lightLevel).pushReaction(PushReaction.DESTROY).noLootTable().liquid().sound(SoundType.EMPTY);
    }

    public static FluidHolder register(ResourceLocation name, int temp, MapColor mapColor, int lightLevel) {
        return register(name, hot(temp).lightLevel(lightLevel), createProperties(mapColor, lightLevel));
    }

    public static FluidHolder register(ResourceLocation name, FluidType.Properties typeProps, MapColor mapColor, int lightLevel) {
        return register(name, typeProps.descriptionId("fluid_type.thermal_extra." + name.getPath()), createProperties(mapColor, lightLevel));
    }

    public static FluidHolder register(ResourceLocation name, int temp, BlockBehaviour.Properties properties) {
        return register(name, hot(temp), properties);
    }

    public static FluidHolder register(ResourceLocation name, FluidType.Properties typeProps, BlockBehaviour.Properties properties) {
        final ResourceLocation flow = new ResourceLocation(name.getNamespace(), "block/fluids/" + name.getPath() + "_flow");
        final ResourceLocation still = new ResourceLocation(name.getNamespace(), "block/fluids/" + name.getPath() + "_still");
        Supplier<FluidType> fluidType = () -> new FluidType(typeProps) {
            @Override
            public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                consumer.accept(new ClientFluidTypeExtension(still, flow));
            }
        };

        return new FluidHolder(name, fluidType, properties);
    }
}
