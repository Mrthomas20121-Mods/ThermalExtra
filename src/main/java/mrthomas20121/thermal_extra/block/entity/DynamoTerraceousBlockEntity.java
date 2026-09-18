package mrthomas20121.thermal_extra.block.entity;

import cofh.lib.common.inventory.ItemStorageCoFH;
import cofh.thermal.core.common.config.ThermalCoreConfig;
import cofh.thermal.lib.common.block.entity.DynamoBlockEntity;
import mrthomas20121.thermal_extra.init.ThermalExtraBlockEntities;
import mrthomas20121.thermal_extra.inventory.DynamoTerraceousMenu;
import mrthomas20121.thermal_extra.recipe.TerraceousFuelManager;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

import static cofh.lib.api.StorageGroup.INPUT;

public class DynamoTerraceousBlockEntity extends DynamoBlockEntity {

    protected ItemStorageCoFH fuelSlot = new ItemStorageCoFH(item -> filter.valid(item) && TerraceousFuelManager.instance().validFuel(item));

    public DynamoTerraceousBlockEntity(BlockPos pos, BlockState state) {

        super(ThermalExtraBlockEntities.DYNAMO_TERRACEOUS.get(), pos, state);

        inventory.addSlot(fuelSlot, INPUT);

        addAugmentSlots(ThermalCoreConfig.dynamoAugments);
        initHandlers();
    }

    @Override
    protected int getBaseProcessTick() {

        return TerraceousFuelManager.instance().getBasePower();
    }

    // region PROCESS
    @Override
    protected boolean canProcessStart() {

        return TerraceousFuelManager.instance().getEnergy(fuelSlot.getItemStack()) > 0;
    }

    @Override
    protected void processStart() {

        int fuelVal = Math.round(TerraceousFuelManager.instance().getEnergy(fuelSlot.getItemStack()) * energyMod);
        processTick = Math.min(baseProcessTick, fuelVal);
        fuel += fuelMax = fuelVal;
        fuelSlot.consume(1);
    }
    // endregion

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {

        return new DynamoTerraceousMenu(i, level, worldPosition, inventory, player);
    }
}
