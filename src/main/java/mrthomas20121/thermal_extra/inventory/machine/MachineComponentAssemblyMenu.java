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

public class MachineComponentAssemblyMenu extends BlockEntityCoFHMenu {

    public final Reconfigurable4WayBlockEntity tile;

    public MachineComponentAssemblyMenu(int windowId, Level level, BlockPos pos, Inventory inventory, Player player) {

        super(ThermalExtraContainers.COMPONENT_ASSEMBLY_CONTAINER.get(), windowId, level, pos, inventory, player);
        this.tile = (Reconfigurable4WayBlockEntity) level.getBlockEntity(pos);
        InvWrapperCoFH tileInv = new InvWrapperCoFH(this.tile.getItemInv());

        addSlot(new SlotCoFH(tileInv, 0, 62, 17));
        addSlot(new SlotCoFH(tileInv, 1, 80, 17));
        addSlot(new SlotCoFH(tileInv, 2, 62, 35));
        addSlot(new SlotCoFH(tileInv, 3, 80, 35));
        addSlot(new SlotCoFH(tileInv, 4, 62, 53));
        addSlot(new SlotCoFH(tileInv, 5, 80, 53));
        addSlot(new SlotRemoveOnly(tileInv, 6, 130, 35));

        addSlot(new SlotCoFH(tileInv, 7, 8, 53));

        bindAugmentSlots(tileInv, 8, this.tile.augSize());
        bindPlayerInventory(inventory);
    }

}
