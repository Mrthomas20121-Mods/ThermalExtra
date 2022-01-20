package mrthomas20121.thermal_extra;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ThermalExtra.MOD_ID)
public class ThermalExtra {

	public static final String MOD_ID = "thermal_extra";
	public static final Logger LOGGER = LogManager.getLogger();

	public ThermalExtra() {
		ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
