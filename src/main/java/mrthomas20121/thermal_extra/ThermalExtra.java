package mrthomas20121.thermal_extra;

import mrthomas20121.thermal_extra.init.Items;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ThermalExtra.MOD_ID)
public class ThermalExtra {

	public static final String MOD_ID = "thermal_extra";
	public static final Logger LOGGER = LogManager.getLogger();

	public ThermalExtra() {
		Items.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ThermalExtraFluids.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
