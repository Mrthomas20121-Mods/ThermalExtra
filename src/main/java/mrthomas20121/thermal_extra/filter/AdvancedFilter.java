package mrthomas20121.thermal_extra.filter;

import cofh.core.util.filter.FilterRegistry;
import cofh.core.util.filter.IFilter;
import cofh.core.util.filter.IFilterFactory;
import cofh.core.util.filter.ItemFilter;

public class AdvancedFilter {

    public static final String ITEM_FILTER_TYPE = "advanced_item";
    public static final String FLUID_FILTER_TYPE = "advanced_fluid";

    public static final int SIZE = 24;
    public static final IFilterFactory<IFilter> FACTORY = (nbt, holderType,  held, pos) -> new AdvancedItemFilter(SIZE, holderType, held, pos).read(nbt);

    public static void init() {
        FilterRegistry.registerFilterFactory(ITEM_FILTER_TYPE, FACTORY);
    }
}
