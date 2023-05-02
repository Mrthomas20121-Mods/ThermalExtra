package mrthomas20121.thermal_extra.filter;

import cofh.core.inventory.container.ItemFilterContainer;
import cofh.core.util.filter.ItemFilter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.Nullable;

public class ExtraItemFilter extends ItemFilter {

    public ExtraItemFilter(int size, boolean held, BlockPos pos) {
        super(size, held, pos);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {

        return new ItemFilterContainer(i, player.level, inventory, player, held, pos);
    }
}
