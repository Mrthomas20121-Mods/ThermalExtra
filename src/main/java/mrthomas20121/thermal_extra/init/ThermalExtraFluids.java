package mrthomas20121.thermal_extra.init;

import cofh.lib.fluid.FluidCoFH;
import cofh.lib.util.DeferredRegisterCoFH;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.fluid.FluidThermalExtra;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

public class ThermalExtraFluids {
    public static final DeferredRegisterCoFH<Fluid> FLUIDS = DeferredRegisterCoFH.create(ForgeRegistries.FLUIDS, ThermalExtra.MOD_ID);

    public static FluidThermalExtra dragon_enderium = registerFluid("dragon_enderium", 1500);
    public static FluidThermalExtra dragon_bronze = registerFluid("dragon_bronze", 1000);
    public static FluidThermalExtra drownium = registerFluid("drownium", 900);
    public static FluidThermalExtra nebulium = registerFluid("nebulium", 900);
    public static FluidThermalExtra nectium = registerFluid("nectium", 900);
    public static FluidThermalExtra polarium = registerFluid("polarium", 900);
    public static FluidThermalExtra vukaium = registerFluid("vukaium", 900);
    public static FluidThermalExtra zauvium = registerFluid("zauvium", 900);
    public static FluidThermalExtra sunflower_oil = registerFluid("sunflower_oil", 400);
    public static FluidThermalExtra crystallized_sunflower_oil = registerFluid("crystallized_sunflower_oil", 500);
    public static FluidThermalExtra refined_sunflower_oil = registerFluid("refined_sunflower_oil", 500);

    public static FluidThermalExtra registerFluid(String name, int temp) {
        return new FluidThermalExtra(name, String.format("thermal_extra:block/fluids/%s_still", name), String.format("thermal:block/fluids/%s_flow", name), temp);
    }
}
