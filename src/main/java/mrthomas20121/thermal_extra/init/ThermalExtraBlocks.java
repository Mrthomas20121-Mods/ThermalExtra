package mrthomas20121.thermal_extra.init;

import cofh.thermal.core.common.block.HardenedGlassBlock;
import cofh.thermal.lib.common.block.DynamoBlock;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.block.DynamoColdBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static cofh.lib.util.constants.BlockStatePropertiesCoFH.ACTIVE;
import static cofh.lib.util.helpers.BlockHelper.lightValue;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.of;

public class ThermalExtraBlocks {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ThermalExtra.MOD_ID);

    public static RegistryObject<Block> SOUL_INFUSED_BLOCK = register("soul_infused_block");
    public static RegistryObject<Block> SHELLITE_BLOCK = register("shellite_block");
    public static RegistryObject<Block> TWINITE_BLOCK = register("twinite_block");
    public static RegistryObject<Block> DRAGONSTEEL_BLOCK = register("dragonsteel_block");
    public static RegistryObject<Block> SOUL_INFUSED_GLASS = registerGlass("soul_infused_glass");
    public static RegistryObject<Block> SHELLITE_GLASS = registerGlass("shellite_glass");
    public static RegistryObject<Block> TWINITE_GLASS = registerGlass("twinite_glass");
    public static RegistryObject<Block> DRAGONSTEEL_GLASS = registerGlass("dragonsteel_glass");

    public static RegistryObject<DynamoBlock> DYNAMO_COLD = BLOCKS.register("dynamo_frost", () -> new DynamoBlock(of().sound(SoundType.NETHERITE_BLOCK).strength(2.0F).lightLevel(lightValue(ACTIVE, 7)), DynamoColdBlockEntity.class, ThermalExtraBlockEntities.DYNAMO_COLD));

    private static Rarity getRarity(String name) {

        if(name.contains("soul_infused")) {
            return ThermalExtraItems.tier1Rarity;
        }
        else if(name.contains("shellite")) {
            return ThermalExtraItems.tier2Rarity;
        }
        else if(name.contains("twinite")) {
            return ThermalExtraItems.tier3Rarity;
        }

        return ThermalExtraItems.tier0Rarity;
    }

    public static RegistryObject<Block> registerGlass(String name) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new HardenedGlassBlock(Block.Properties.copy(Blocks.GLASS)
                .isValidSpawn(ThermalExtraBlocks::neverAllowSpawn)
                .isRedstoneConductor(ThermalExtraBlocks::isNotSolid)
                .isSuffocating(ThermalExtraBlocks::isNotSolid)
                .isViewBlocking(ThermalExtraBlocks::isNotSolid)));
        Rarity rarity = getRarity(name);
        ThermalExtraItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(rarity)));
        return block;
    }

    public static RegistryObject<Block> register(String name) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(5f, 5f).sound(SoundType.METAL)));
        Rarity rarity = getRarity(name);
        ThermalExtraItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(rarity)));
        return block;
    }

    private static Boolean neverAllowSpawn(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity) {
        return false;
    }
    private static boolean isNotSolid(BlockState state, BlockGetter reader, BlockPos pos) {
        return false;
    }
}
