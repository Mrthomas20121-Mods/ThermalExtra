package mrthomas20121.thermal_extra.init;

import cofh.lib.fluid.FluidCoFH;
import cofh.lib.util.DeferredRegisterCoFH;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.fluid.FluidThermalExtra;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

public class ThermalExtraFluids {
    public static final DeferredRegisterCoFH<Fluid> FLUIDS = DeferredRegisterCoFH.create(ForgeRegistries.FLUIDS, ThermalExtra.MOD_ID);

    public static FluidCoFH dragon_enderium = registerFluid("dragon_enderium");
    public static FluidCoFH dragon_bronze = registerFluid("dragon_bronze");
    public static FluidCoFH drownium = registerFluid("drownium");
    public static FluidCoFH nebulium = registerFluid("nebulium");
    public static FluidCoFH nectium = registerFluid("nectium");
    public static FluidCoFH polarium = registerFluid("polarium");
    public static FluidCoFH vukaium = registerFluid("vukaium");
    public static FluidCoFH zauvium = registerFluid("zauvium");

    public static FluidCoFH registerFluid(String name) {
        return new FluidThermalExtra(name, String.format("thermal_extra:block/fluids/%s_still", name), String.format("thermal:block/fluids/%s_flow", name));
    }
}
