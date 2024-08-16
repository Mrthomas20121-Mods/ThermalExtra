package mrthomas20121.thermal_extra.data;

import cofh.lib.init.data.loot.BlockLootSubProviderCoFH;
import mrthomas20121.thermal_extra.ThermalExtra;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class ExtraBlockLoot extends BlockLootSubProviderCoFH {

    @Override
    protected void generate() {
        ForgeRegistries.BLOCKS.getKeys().stream().filter(key -> key.getNamespace().equals(ThermalExtra.MOD_ID))
                .map(ForgeRegistries.BLOCKS::getValue).toList().forEach(block -> {
                    if(block instanceof GlassBlock) {
                        dropWhenSilkTouch(block);
                    }
                    else {
                        dropSelf(block);
                    }
                });
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getKeys().stream().filter(key -> key.getNamespace().equals(ThermalExtra.MOD_ID))
                .map(ForgeRegistries.BLOCKS::getValue).toList();
    }
}
