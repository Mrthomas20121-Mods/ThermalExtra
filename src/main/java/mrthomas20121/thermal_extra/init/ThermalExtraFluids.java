package mrthomas20121.thermal_extra.init;

import cofh.lib.fluid.FluidCoFH;
import cofh.lib.util.DeferredRegisterCoFH;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.fluid.FluidThermalExtra;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

public class ThermalExtraFluids {
    public static final DeferredRegisterCoFH<Fluid> FLUIDS = DeferredRegisterCoFH.create(ForgeRegistries.FLUIDS, ThermalExtra.MOD_ID);

    public static FluidThermalExtra dragon_enderium = registerFluid("dragon_enderium");
    public static FluidThermalExtra dragon_bronze = registerFluid("dragon_bronze");
    public static FluidThermalExtra drownium = registerFluid("drownium");
    public static FluidThermalExtra nebulium = registerFluid("nebulium");
    public static FluidThermalExtra nectium = registerFluid("nectium");
    public static FluidThermalExtra polarium = registerFluid("polarium");
    public static FluidThermalExtra vukaium = registerFluid("vukaium");
    public static FluidThermalExtra zauvium = registerFluid("zauvium");

    public static FluidThermalExtra registerFluid(String name) {
        return new FluidThermalExtra(name, String.format("thermal_extra:block/fluids/%s_still", name), String.format("thermal:block/fluids/%s_flow", name));
    }
}
