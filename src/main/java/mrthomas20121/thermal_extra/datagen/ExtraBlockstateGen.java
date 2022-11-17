package mrthomas20121.thermal_extra.datagen;

import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ExtraBlockstateGen extends BlockStateProvider {

    public ExtraBlockstateGen(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ThermalExtra.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlock(ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get());
        this.simpleBlock(ThermalExtraBlocks.SHELLITE_BLOCK.get());
        this.simpleBlock(ThermalExtraBlocks.TWINITE_BLOCK.get());
        this.simpleBlock(ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get());

        this.simpleBlock(ThermalExtraBlocks.SOUL_INFUSED_GLASS.get());
        this.simpleBlock(ThermalExtraBlocks.SHELLITE_GLASS.get());
        this.simpleBlock(ThermalExtraBlocks.TWINITE_GLASS.get());
        this.simpleBlock(ThermalExtraBlocks.DRAGONSTEEL_GLASS.get());
    }

    @Override
    public void simpleBlock(Block block) {
        simpleBlock(block, cubeAll(block));
        ResourceLocation registryName = ForgeRegistries.BLOCKS.getKey(block);
        this.itemModels().withExistingParent("thermal_extra:item/"+registryName.getPath(), "thermal_extra:block/"+registryName.getPath());
    }
}