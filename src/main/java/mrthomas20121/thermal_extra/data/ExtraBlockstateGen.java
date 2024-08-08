package mrthomas20121.thermal_extra.data;

import cofh.lib.init.data.BlockStateProviderCoFH;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ExtraBlockstateGen extends BlockStateProviderCoFH {

    public ExtraBlockstateGen(PackOutput gen, ExistingFileHelper exFileHelper) {
        super(gen, ThermalExtra.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlock(ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get());
        this.simpleBlock(ThermalExtraBlocks.SHELLITE_BLOCK.get());
        this.simpleBlock(ThermalExtraBlocks.TWINITE_BLOCK.get());
        this.simpleBlock(ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get());
        this.simpleBlock(ThermalExtraBlocks.ABYSSAL_BLOCK.get());

        this.translucentBlock(ThermalExtraBlocks.SOUL_INFUSED_GLASS.get());
        this.translucentBlock(ThermalExtraBlocks.SHELLITE_GLASS.get());
        this.translucentBlock(ThermalExtraBlocks.TWINITE_GLASS.get());
        this.translucentBlock(ThermalExtraBlocks.DRAGONSTEEL_GLASS.get());
        this.translucentBlock(ThermalExtraBlocks.ABYSSAL_GLASS.get());
    }

    public void translucentBlock(Block block) {
        ResourceLocation registryName = ForgeRegistries.BLOCKS.getKey(block);
        this.simpleBlock(block, models().cubeAll(name(block), blockTexture(block)).renderType("translucent"));
        this.itemModels().withExistingParent("thermal_extra:item/"+registryName.getPath(), "thermal_extra:block/"+registryName.getPath());
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    @Override
    public void simpleBlock(Block block) {
        simpleBlock(block, cubeAll(block));
        ResourceLocation registryName = ForgeRegistries.BLOCKS.getKey(block);
        this.itemModels().withExistingParent("thermal_extra:item/"+registryName.getPath(), "thermal_extra:block/"+registryName.getPath());
    }
}
