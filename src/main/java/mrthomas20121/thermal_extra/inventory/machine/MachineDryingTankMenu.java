package mrthomas20121.thermal_extra.inventory.machine;

import cofh.core.common.inventory.BlockEntityCoFHMenu;
import cofh.lib.common.inventory.SlotCoFH;
import cofh.lib.common.inventory.SlotRemoveOnly;
import cofh.lib.common.inventory.wrapper.InvWrapperCoFH;
import cofh.thermal.lib.common.block.entity.Reconfigurable4WayBlockEntity;
import mrthomas20121.thermal_extra.init.ThermalExtraContainers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class MachineDryingTankMenu extends BlockEntityCoFHMenu {

    public final Reconfigurable4WayBlockEntity tile;

    public MachineDryingTankMenu(int windowId, Level level, BlockPos pos, Inventory inventory, Player player) {

        super(ThermalExtraContainers.DRYING_TANK_CONTAINER.get(), windowId, level, pos, inventory, player);
        this.tile = (Reconfigurable4WayBlockEntity) level.getBlockEntity(pos);
        InvWrapperCoFH tileInv = new InvWrapperCoFH(this.tile.getItemInv());

        addSlot(new SlotRemoveOnly(tileInv, 0, 100, 17));
        addSlot(new SlotRemoveOnly(tileInv, 1, 100, 35));
        addSlot(new SlotRemoveOnly(tileInv, 2, 100, 53));
        addSlot(new SlotRemoveOnly(tileInv, 3, 118, 17));
        addSlot(new SlotRemoveOnly(tileInv, 4, 118, 35));
        addSlot(new SlotRemoveOnly(tileInv, 5, 118, 53));

        addSlot(new SlotCoFH(tileInv, 3, 8, 53));

        bindAugmentSlots(tileInv, 4, this.tile.augSize());
        bindPlayerInventory(inventory);
    }

}
