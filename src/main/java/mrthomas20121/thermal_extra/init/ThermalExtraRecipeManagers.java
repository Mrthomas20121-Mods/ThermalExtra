package mrthomas20121.thermal_extra.init;

import mrthomas20121.thermal_extra.recipe.*;

import static cofh.thermal.lib.util.ThermalRecipeManagers.registerManager;

public class ThermalExtraRecipeManagers {

    public static void register() {
        registerManager(ColdFuelManager.instance());
        registerManager(MetalInfuserRecipeManager.instance());
        registerManager(AdvancedRefineryRecipeManager.instance());
        registerManager(NitraticIgniterRecipeManager.instance());
        registerManager(FluidMixerRecipeManager.instance());
        registerManager(ComponentAssemblyRecipeManager.instance());
    }
}
