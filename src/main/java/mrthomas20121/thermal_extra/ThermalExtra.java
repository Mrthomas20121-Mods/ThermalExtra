package mrthomas20121.thermal_extra;

import cofh.core.client.event.CoreClientEvents;
import mrthomas20121.thermal_extra.client.screens.AdvancedItemFilterScreen;
import mrthomas20121.thermal_extra.client.screens.DynamoFrostScreen;
import mrthomas20121.thermal_extra.client.screens.device.DeviceLavaGenScreen;
import mrthomas20121.thermal_extra.client.screens.machine.*;
import mrthomas20121.thermal_extra.data.*;
import mrthomas20121.thermal_extra.filter.AdvancedFilter;
import mrthomas20121.thermal_extra.init.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;

@Mod(mrthomas20121.thermal_extra.ThermalExtra.MOD_ID)
public class ThermalExtra {

	public static final String MOD_ID = "thermal_extra";
	public static final Logger LOGGER = LogManager.getLogger();

	public ThermalExtra() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ThermalExtraItems.ITEMS.register(bus);
		ThermalExtraBlocks.BLOCKS.register(bus);
		ThermalExtraFluids.FLUIDS.register(bus);
		ThermalExtraFluids.FLUID_TYPES.register(bus);
		ThermalExtraBlockEntities.BLOCK_ENTITIES.register(bus);
		ThermalExtraContainers.CONTAINERS.register(bus);
		ThermalExtraRecipeTypes.RECIPE_TYPES.register(bus);
		ThermalExtraRecipeSerializers.RECIPE_SERIALIZERS.register(bus);
		ThermalExtraCreativeTabs.CREATIVE_TABS.register(bus);
		AdvancedFilter.init();
		ThermalExtraRecipeManagers.register();

		bus.addListener(this::gatherData);
		bus.addListener(this::clientSetup);
	}

	public void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			CoreClientEvents.addNamespace(ThermalExtra.MOD_ID);
			MenuScreens.register(ThermalExtraContainers.ADVANCED_REFINERY_CONTAINER.get(), MachineAdvancedRefineryScreen::new);
			MenuScreens.register(ThermalExtraContainers.NITRATIC_IGNITER_CONTAINER.get(), MachineNitraticIgniterScreen::new);
			MenuScreens.register(ThermalExtraContainers.FLUID_MIXER_CONTAINER.get(), MachineFluidMixerScreen::new);
			MenuScreens.register(ThermalExtraContainers.DYNAMO_FROST_CONTAINER.get(), DynamoFrostScreen::new);
			MenuScreens.register(ThermalExtraContainers.ADVANCED_ITEM_FILTER_CONTAINER.get(), AdvancedItemFilterScreen::new);
			MenuScreens.register(ThermalExtraContainers.LAVA_GEN_CONTAINER.get(), DeviceLavaGenScreen::new);
			MenuScreens.register(ThermalExtraContainers.COMPONENT_ASSEMBLY_CONTAINER.get(), MachineComponentAssemblyScreen::new);
			MenuScreens.register(ThermalExtraContainers.ENDOTHERMIC_DEHYDRATOR_CONTAINER.get(), MachineEndothermicDehydratorScreen::new);
		});
	}

	public void gatherData(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		PackOutput packOutput = gen.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		// server stuff
		gen.addProvider(event.includeServer(), new ExtraRecipeGen(packOutput));
		ExtraTagGen.BlockTags blockTags = new ExtraTagGen.BlockTags(packOutput, lookupProvider, fileHelper);
		gen.addProvider(event.includeServer(), blockTags);
		gen.addProvider(event.includeServer(), new ExtraTagGen.ItemTags(packOutput, lookupProvider, blockTags.contentsGetter(), fileHelper));
		gen.addProvider(event.includeServer(), new ExtraTagGen.FluidTags(packOutput, lookupProvider, fileHelper));
		gen.addProvider(event.includeServer(), new ExtraTagGen.EntityTags(packOutput, lookupProvider, fileHelper));
		gen.addProvider(event.includeServer(), new ExtraLootTableProvider(packOutput));

		// client stuff
		gen.addProvider(event.includeClient(), new ExtraModelGen(packOutput, fileHelper));
		gen.addProvider(event.includeClient(), new ExtraLangGen(packOutput));
		gen.addProvider(event.includeClient(), new ExtraBlockstateGen(packOutput, fileHelper));
	}
}
