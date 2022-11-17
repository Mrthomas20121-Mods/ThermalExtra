package mrthomas20121.thermal_extra;

import mrthomas20121.thermal_extra.datagen.*;
import mrthomas20121.thermal_extra.filter.AdvancedFilter;
import mrthomas20121.thermal_extra.init.ThermalExtraBlocks;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
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
		AdvancedFilter.init();
		bus.addListener(this::clientStuff);
	}

	public void clientStuff(final FMLClientSetupEvent event) {

		event.enqueueWork(this::registerRenderLayers);
	}

	public void registerRenderLayers() {
		ItemBlockRenderTypes.setRenderLayer(ThermalExtraBlocks.SOUL_INFUSED_GLASS.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(ThermalExtraBlocks.SHELLITE_GLASS.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(ThermalExtraBlocks.TWINITE_GLASS.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(ThermalExtraBlocks.DRAGONSTEEL_GLASS.get(), RenderType.translucent());
	}

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		if(event.includeServer()) {
			if(ModList.get().isLoaded("tconstruct")) {
				gen.addProvider(new TinkerRecipeDatagen(gen));
			}
			gen.addProvider(new ExtraRecipeGen(gen));
			ExtraTagGen.BlockTags blockTags = new ExtraTagGen.BlockTags(gen, fileHelper);
			gen.addProvider(blockTags);
			gen.addProvider(new ExtraTagGen.ItemTags(gen, blockTags, fileHelper));
			gen.addProvider(new ExtraTagGen.FluidTags(gen, fileHelper));
		}
		if(event.includeClient()) {
			gen.addProvider(new ExtraModelGen(gen, fileHelper));
			gen.addProvider(new ExtraLangGen(gen));
			gen.addProvider(new ExtraBlockstateGen(gen, fileHelper));
		}
	}
}
