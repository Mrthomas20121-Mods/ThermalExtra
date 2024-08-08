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

    public static FluidThermalExtra MOLTEN_SOUL_INFUSED = registerFluid("soul_infused", 1000);
    public static FluidThermalExtra MOLTEN_SHELLITE = registerFluid("shellite", 1100);
    public static FluidThermalExtra MOLTEN_TWINITE = registerFluid("twinite", 1300);
    public static FluidThermalExtra MOLTEN_DRAGONSTEEL = registerFluid("dragonsteel", 1500);
    public static FluidThermalExtra MOLTEN_ABYSSAL = registerFluid("abyssal", 1500);
    public static FluidThermalExtra SUNFLOWER_OIL = registerFluid("sunflower_oil", 400);
    public static FluidThermalExtra CRYSTALLIZED_SUNFLOWER_OIL = registerFluid("crystallized_sunflower_oil", 500);
    public static FluidThermalExtra REFINED_SUNFLOWER_OIL = registerFluid("refined_sunflower_oil", 500);
    public static FluidThermalExtra FLUX_INFUSED_OIL = registerFluid("flux_infused_oil", 500);
    public static FluidThermalExtra DIESEL = registerFluid("diesel", 1000);
    public static FluidThermalExtra POLYOLEFIN = registerFluid("polyolefin", 500);
    public static FluidThermalExtra RAW_ALUMINUM = registerFluid("raw_aluminum", 500);
    public static FluidThermalExtra RAW_ARCANE_GOLD = registerFluid("raw_arcane_gold", 500);
    public static FluidThermalExtra RAW_COPPER = registerFluid("raw_copper", 500);
    public static FluidThermalExtra RAW_GOLD = registerFluid("raw_gold", 500);
    public static FluidThermalExtra RAW_IRON = registerFluid("raw_iron", 500);
    public static FluidThermalExtra RAW_LEAD = registerFluid("raw_lead", 500);
    public static FluidThermalExtra RAW_NICKEL = registerFluid("raw_nickel", 500);
    public static FluidThermalExtra RAW_OSMIUM = registerFluid("raw_osmium", 500);
    public static FluidThermalExtra RAW_SILVER = registerFluid("raw_silver", 500);
    public static FluidThermalExtra RAW_TIN = registerFluid("raw_tin", 500);
    public static FluidThermalExtra RAW_URANIUM = registerFluid("raw_uranium", 500);
    public static FluidThermalExtra RAW_ZINC = registerFluid("raw_zinc", 500);

    public static FluidThermalExtra registerFluid(String name, int temp) {
        return new FluidThermalExtra(name, String.format("thermal_extra:block/fluids/%s_still", name), String.format("thermal:block/fluids/%s_flow", name), temp);
    }
}
