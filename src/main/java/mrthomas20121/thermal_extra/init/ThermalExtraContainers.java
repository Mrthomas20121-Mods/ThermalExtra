package mrthomas20121.thermal_extra.init;

import cofh.lib.util.DeferredRegisterCoFH;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.inventory.AdvancedItemFilterMenu;
import mrthomas20121.thermal_extra.inventory.DynamoFrostMenu;
import mrthomas20121.thermal_extra.inventory.device.DeviceLavaGenMenu;
import mrthomas20121.thermal_extra.inventory.machine.*;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static cofh.core.util.ProxyUtils.getClientPlayer;
import static cofh.core.util.ProxyUtils.getClientWorld;

public class ThermalExtraContainers {

    public static DeferredRegisterCoFH<MenuType<?>> CONTAINERS = DeferredRegisterCoFH.create(ForgeRegistries.MENU_TYPES, ThermalExtra.MOD_ID);

    public static final RegistryObject<MenuType<MachineMetalInfuserMenu>> METAL_INFUSER_CONTAINER = CONTAINERS.register("metal_infuser", () -> IForgeMenuType.create((windowId, inv, data) -> new MachineMetalInfuserMenu(windowId, getClientWorld(), data.readBlockPos(), inv, getClientPlayer())));
    public static final RegistryObject<MenuType<MachineAdvancedRefineryMenu>> ADVANCED_REFINERY_CONTAINER = CONTAINERS.register("advanced_refinery", () -> IForgeMenuType.create((windowId, inv, data) -> new MachineAdvancedRefineryMenu(windowId, getClientWorld(), data.readBlockPos(), inv, getClientPlayer())));
    public static final RegistryObject<MenuType<MachineNitraticIgniterMenu>> NITRATIC_IGNITER_CONTAINER = CONTAINERS.register("nitratic_igniter", () -> IForgeMenuType.create((windowId, inv, data) -> new MachineNitraticIgniterMenu(windowId, getClientWorld(), data.readBlockPos(), inv, getClientPlayer())));
    public static final RegistryObject<MenuType<DynamoFrostMenu>> DYNAMO_FROST_CONTAINER = CONTAINERS.register("dynamo_frost", () -> IForgeMenuType.create((windowId, inv, data) -> new DynamoFrostMenu(windowId, getClientWorld(), data.readBlockPos(), inv, getClientPlayer())));
    public static final RegistryObject<MenuType<AdvancedItemFilterMenu>> ADVANCED_ITEM_FILTER_CONTAINER = CONTAINERS.register("advanced_item_filter", () -> IForgeMenuType.create((windowId, inv, data) -> new AdvancedItemFilterMenu(windowId, getClientWorld(), inv, getClientPlayer(), data.readVarInt(), data.readVarInt(), data.readBlockPos())));
    public static final RegistryObject<MenuType<MachineFluidMixerMenu>> FLUID_MIXER_CONTAINER = CONTAINERS.register("fluid_mixer", () -> IForgeMenuType.create((windowId, inv, data) -> new MachineFluidMixerMenu(windowId, getClientWorld(), data.readBlockPos(), inv, getClientPlayer())));
    public static final RegistryObject<MenuType<DeviceLavaGenMenu>> LAVA_GEN_CONTAINER = CONTAINERS.register("lava_gen", () -> IForgeMenuType.create((windowId, inv, data) -> new DeviceLavaGenMenu(windowId, getClientWorld(), data.readBlockPos(), inv, getClientPlayer())));
    public static final RegistryObject<MenuType<MachineComponentAssemblyMenu>> COMPONENT_ASSEMBLY_CONTAINER = CONTAINERS.register("component_assembly", () -> IForgeMenuType.create((windowId, inv, data) -> new MachineComponentAssemblyMenu(windowId, getClientWorld(), data.readBlockPos(), inv, getClientPlayer())));
    public static final RegistryObject<MenuType<MachineDryingTankMenu>> DRYING_TANK_CONTAINER = CONTAINERS.register("drying_tank", () -> IForgeMenuType.create((windowId, inv, data) -> new MachineDryingTankMenu(windowId, getClientWorld(), data.readBlockPos(), inv, getClientPlayer())));

}
