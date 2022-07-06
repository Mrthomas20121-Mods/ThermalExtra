package mrthomas20121.thermal_extra;

import mrthomas20121.thermal_extra.filter.AdvancedFilter;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(mrthomas20121.thermal_extra.ThermalExtra.MOD_ID)
//@Mod.EventBusSubscriber(modid = ThermalExtra.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ThermalExtra {

	public static final String MOD_ID = "thermal_extra";
	public static final Logger LOGGER = LogManager.getLogger();

	public ThermalExtra() {
		ThermalExtraItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ThermalExtraFluids.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
		AdvancedFilter.init();
	}

//	@SubscribeEvent
//	public static void gatherData(final GatherDataEvent event) {
//		DataGenerator gen = event.getGenerator();
//		ExistingFileHelper fileHelper = event.getExistingFileHelper();
//		if (event.includeServer()) {
//			gen.addProvider(new RecipeDatagen(gen));
//		}
//	}
}
