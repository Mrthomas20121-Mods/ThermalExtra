package mrthomas20121.thermal_extra;

import mrthomas20121.thermal_extra.datagen.*;
import mrthomas20121.thermal_extra.filter.AdvancedFilter;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(mrthomas20121.thermal_extra.ThermalExtra.MOD_ID)
@Mod.EventBusSubscriber(modid = ThermalExtra.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ThermalExtra {

	public static final String MOD_ID = "thermal_extra";
	public static final Logger LOGGER = LogManager.getLogger();

	public ThermalExtra() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ThermalExtraItems.ITEMS.register(bus);
		ThermalExtraBlocks.BLOCKS.register(bus);
		ThermalExtraFluids.FLUIDS.register(bus);
		ThermalExtraFluids.FLUID_TYPES.register(bus);
		AdvancedFilter.init();
	}

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		if(ModList.get().isLoaded("tconstruct")) {
			//gen.m_236039_(true, new TinkerRecipeDatagen(gen));
		}
		gen.addProvider(event.includeServer(), new ExtraRecipeGen(gen));
		ExtraTagGen.BlockTags blockTags = new ExtraTagGen.BlockTags(gen, fileHelper);
		gen.addProvider(event.includeServer(), blockTags);
		gen.addProvider(event.includeServer(), new ExtraTagGen.ItemTags(gen, blockTags, fileHelper));
		gen.addProvider(event.includeServer(), new ExtraTagGen.FluidTags(gen, fileHelper));

		gen.addProvider(event.includeClient(), new ExtraModelGen(gen, fileHelper));
		gen.addProvider(event.includeClient(), new ExtraLangGen(gen));
		gen.addProvider(event.includeClient(), new ExtraBlockstateGen(gen, fileHelper));
	}
}
