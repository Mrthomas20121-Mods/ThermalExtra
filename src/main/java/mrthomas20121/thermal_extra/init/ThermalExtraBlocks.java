package mrthomas20121.thermal_extra.init;

import cofh.thermal.core.block.HardenedGlassBlock;
import mrthomas20121.thermal_extra.ThermalExtra;
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
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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

    public static RegistryObject<Block> registerGlass(String name) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new HardenedGlassBlock(Block.Properties.copy(Blocks.GLASS)
                .isValidSpawn(ThermalExtraBlocks::neverAllowSpawn)
                .isRedstoneConductor(ThermalExtraBlocks::isNotSolid)
                .isSuffocating(ThermalExtraBlocks::isNotSolid)
                .isViewBlocking(ThermalExtraBlocks::isNotSolid)));
        Rarity rarity = name.contains("soul_infused") ? Rarity.RARE : Rarity.EPIC;
        ThermalExtraItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ThermalExtraItems.resourcesTab).tab(ThermalExtraItems.resourcesTab).rarity(rarity)));
        return block;
    }

    public static RegistryObject<Block> register(String name) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f, 5f).sound(SoundType.METAL)));
        Rarity rarity = name.contains("soul_infused") ? Rarity.RARE : ThermalExtraItems.gold_rarity;
        ThermalExtraItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ThermalExtraItems.blockTab).rarity(rarity)));
        return block;
    }

    private static Boolean neverAllowSpawn(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity) {
        return false;
    }
    private static boolean isNotSolid(BlockState state, BlockGetter reader, BlockPos pos) {
        return false;
    }
}
