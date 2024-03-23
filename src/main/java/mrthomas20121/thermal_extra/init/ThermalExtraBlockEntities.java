package mrthomas20121.thermal_extra.init;

import cofh.lib.util.DeferredRegisterCoFH;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.block.entity.DynamoColdBlockEntity;
import mrthomas20121.thermal_extra.block.entity.MachineMetalInfuserBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ThermalExtraBlockEntities {

    public static DeferredRegisterCoFH<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegisterCoFH.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ThermalExtra.MOD_ID);

    public static RegistryObject<BlockEntityType<?>> DYNAMO_COLD = BLOCK_ENTITIES.register("dynamo_frost", () -> BlockEntityType.Builder.of(DynamoColdBlockEntity::new, ThermalExtraBlocks.DYNAMO_COLD.get()).build(null));
    public static RegistryObject<BlockEntityType<?>> METAL_INFUSER = BLOCK_ENTITIES.register("metal_infuser", () -> BlockEntityType.Builder.of(MachineMetalInfuserBlockEntity::new, ThermalExtraBlocks.BLOCKS.get("metal_infuser")).build(null));
}
