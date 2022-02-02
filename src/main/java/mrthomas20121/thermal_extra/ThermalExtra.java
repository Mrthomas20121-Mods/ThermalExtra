package mrthomas20121.thermal_extra;

import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(mrthomas20121.thermal_extra.ThermalExtra.MOD_ID)
public class ThermalExtra {

	public static final String MOD_ID = "thermal_extra";
	public static final Logger LOGGER = LogManager.getLogger();

	public ThermalExtra() {
		ThermalExtraItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ThermalExtraFluids.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
