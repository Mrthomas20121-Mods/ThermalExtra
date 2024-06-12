package mrthomas20121.thermal_extra.init;

import cofh.lib.util.DeferredRegisterCoFH;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.block.entity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ThermalExtraBlockEntities {

    public static DeferredRegisterCoFH<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegisterCoFH.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ThermalExtra.MOD_ID);

    public static RegistryObject<BlockEntityType<?>> DYNAMO_COLD = BLOCK_ENTITIES.register("dynamo_frost", () -> BlockEntityType.Builder.of(DynamoColdBlockEntity::new, ThermalExtraBlocks.DYNAMO_COLD.get()).build(null));
    public static RegistryObject<BlockEntityType<?>> METAL_INFUSER = BLOCK_ENTITIES.register("metal_infuser", () -> BlockEntityType.Builder.of(MachineMetalInfuserBlockEntity::new, ThermalExtraBlocks.BLOCKS.get("metal_infuser")).build(null));
    public static RegistryObject<BlockEntityType<?>> ADVANCED_REFINERY = BLOCK_ENTITIES.register("advanced_refinery", () -> BlockEntityType.Builder.of(MachineAdvancedRefineryBlockEntity::new, ThermalExtraBlocks.BLOCKS.get("advanced_refinery")).build(null));
    public static RegistryObject<BlockEntityType<?>> NITRATIC_IGNITER = BLOCK_ENTITIES.register("nitratic_igniter", () -> BlockEntityType.Builder.of(MachineNitraticIgniterBlockEntity::new, ThermalExtraBlocks.BLOCKS.get("nitratic_igniter")).build(null));
    public static RegistryObject<BlockEntityType<?>> FLUID_MIXER = BLOCK_ENTITIES.register("fluid_mixer", () -> BlockEntityType.Builder.of(MachineFluidMixerBlockEntity::new, ThermalExtraBlocks.BLOCKS.get("fluid_mixer")).build(null));
    public static RegistryObject<BlockEntityType<?>> COMPONENT_ASSEMBLY = BLOCK_ENTITIES.register("component_assembly", () -> BlockEntityType.Builder.of(MachineComponentAssemblyBlockEntity::new, ThermalExtraBlocks.BLOCKS.get("component_assembly")).build(null));
    public static RegistryObject<BlockEntityType<?>> DRYING_TANK = BLOCK_ENTITIES.register("drying_tank", () -> BlockEntityType.Builder.of(MachineComponentAssemblyBlockEntity::new, ThermalExtraBlocks.BLOCKS.get("drying_tank")).build(null));

    public static RegistryObject<BlockEntityType<?>> LAVA_GEN = BLOCK_ENTITIES.register("lava_gen", () -> BlockEntityType.Builder.of(DeviceLavaGenBlockEntity::new, ThermalExtraBlocks.BLOCKS.get("device_lava_gen")).build(null));

}
