package mrthomas20121.thermal_extra.data;

import cofh.lib.init.data.LootTableProviderCoFH;
import cofh.thermal.core.init.data.tables.TCoreBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;

public class ExtraLootTableProvider extends LootTableProviderCoFH {

    public ExtraLootTableProvider(PackOutput output) {

        super(output, List.of(
                new SubProviderEntry(ExtraBlockLoot::new, LootContextParamSets.BLOCK)
        ));
    }

}
