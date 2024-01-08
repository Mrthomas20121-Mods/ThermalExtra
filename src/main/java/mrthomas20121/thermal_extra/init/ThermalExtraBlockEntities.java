package mrthomas20121.thermal_extra.init;

import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.block.DynamoColdBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ThermalExtraBlockEntities {

    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ThermalExtra.MOD_ID);

    public static RegistryObject<BlockEntityType<?>> DYNAMO_COLD = BLOCK_ENTITIES.register("dynamo_frost", () -> BlockEntityType.Builder.of(DynamoColdBlockEntity::new, ThermalExtraBlocks.DYNAMO_COLD.get()).build(null));
}
