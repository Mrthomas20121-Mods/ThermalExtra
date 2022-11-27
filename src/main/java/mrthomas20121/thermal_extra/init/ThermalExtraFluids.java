package mrthomas20121.thermal_extra.init;

import cofh.lib.util.DeferredRegisterCoFH;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.fluid.FluidThermalExtra;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.ForgeRegistries;

public class ThermalExtraFluids {
    public static final DeferredRegisterCoFH<Fluid> FLUIDS = DeferredRegisterCoFH.create(ForgeRegistries.FLUIDS, ThermalExtra.MOD_ID);
    public static final DeferredRegisterCoFH<FluidType> FLUID_TYPES = DeferredRegisterCoFH.create(ForgeRegistries.Keys.FLUID_TYPES, ThermalExtra.MOD_ID);

    public static FluidThermalExtra soul_infused = registerFluid("soul_infused", 1000);
    public static FluidThermalExtra shellite = registerFluid("shellite", 1100);
    public static FluidThermalExtra twinite = registerFluid("twinite", 1300);
    public static FluidThermalExtra dragonsteel = registerFluid("dragonsteel", 1500);
    public static FluidThermalExtra sunflower_oil = registerFluid("sunflower_oil", 400);
    public static FluidThermalExtra crystallized_sunflower_oil = registerFluid("crystallized_sunflower_oil", 500);
    public static FluidThermalExtra refined_sunflower_oil = registerFluid("refined_sunflower_oil", 500);
    public static FluidThermalExtra basalt = registerFluid("basalt", 500);
    public static FluidThermalExtra blitz = registerFluid("blitz", 500);
    public static FluidThermalExtra blizz = registerFluid("blizz", 500);
    public static FluidThermalExtra icy_water = registerFluid("icy_water", 500);


    public static FluidThermalExtra registerFluid(String name, int temp) {
        return new FluidThermalExtra(name, String.format("thermal_extra:block/fluids/%s_still", name), String.format("thermal:block/fluids/%s_flow", name), temp);
    }
}
