package mrthomas20121.thermal_extra.filter;

import cofh.core.util.filter.FilterRegistry;
import cofh.core.util.filter.HeldItemFilter;
import cofh.core.util.filter.TileItemFilter;
import cofh.lib.util.filter.IFilter;
import cofh.lib.util.filter.IFilterFactory;
import cofh.lib.util.filter.ITileFilterFactory;

public class AdvancedFilter {

    public static final String ITEM_FILTER_TYPE = "advanced_item";

    public static final int SIZE = 18;
    public static final ITileFilterFactory<IFilter> FACTORY = (tile, nbt) -> new TileItemFilter(tile, SIZE).read(nbt);
    public static final IFilterFactory<IFilter> HELD_FACTORY = nbt -> new HeldItemFilter(SIZE).read(nbt);

    public static void init() {
        FilterRegistry.registerHeldFilter(ITEM_FILTER_TYPE, HELD_FACTORY);
        FilterRegistry.registerTileFilter(ITEM_FILTER_TYPE, FACTORY);
    }
}
