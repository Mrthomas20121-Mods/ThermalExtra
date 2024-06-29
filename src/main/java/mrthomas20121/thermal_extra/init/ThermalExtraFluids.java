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
    public static FluidThermalExtra flux_infused_oil = registerFluid("flux_infused_oil", 500);
    public static FluidThermalExtra flux_diesel = registerFluid("flux_diesel", 1000);
    public static FluidThermalExtra biodiesel = registerFluid("biodiesel", 1000);
    public static FluidThermalExtra liquid_biomass = registerFluid("liquid_biomass", 200);
    public static FluidThermalExtra polyolefin = registerFluid("polyolefin", 500);
    public static FluidThermalExtra super_biodiesel = registerFluid("super_biodiesel", 1000);
    public static FluidThermalExtra raw_aluminum = registerFluid("raw_aluminum", 500);
    public static FluidThermalExtra raw_arcane_gold = registerFluid("raw_arcane_gold", 500);
    public static FluidThermalExtra raw_copper = registerFluid("raw_copper", 500);
    public static FluidThermalExtra raw_gold = registerFluid("raw_gold", 500);
    public static FluidThermalExtra raw_iron = registerFluid("raw_iron", 500);
    public static FluidThermalExtra raw_lead = registerFluid("raw_lead", 500);
    public static FluidThermalExtra raw_nickel = registerFluid("raw_nickel", 500);
    public static FluidThermalExtra raw_osmium = registerFluid("raw_osmium", 500);
    public static FluidThermalExtra raw_silver = registerFluid("raw_silver", 500);
    public static FluidThermalExtra raw_tin = registerFluid("raw_tin", 500);
    public static FluidThermalExtra raw_uranium = registerFluid("raw_uranium", 500);
    public static FluidThermalExtra raw_zinc = registerFluid("raw_zinc", 500);


    public static FluidThermalExtra registerFluid(String name, int temp) {
        return new FluidThermalExtra(name, String.format("thermal_extra:block/fluids/%s_still", name), String.format("thermal:block/fluids/%s_flow", name), temp);
    }
}
