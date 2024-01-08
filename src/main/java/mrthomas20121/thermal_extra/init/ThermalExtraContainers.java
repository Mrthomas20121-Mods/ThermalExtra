package mrthomas20121.thermal_extra.init;

import cofh.lib.util.DeferredRegisterCoFH;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.containers.DynamoFrostMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static cofh.core.util.ProxyUtils.getClientPlayer;
import static cofh.core.util.ProxyUtils.getClientWorld;

public class ThermalExtraContainers {

    public static DeferredRegisterCoFH<MenuType<?>> CONTAINERS = DeferredRegisterCoFH.create(ForgeRegistries.MENU_TYPES, ThermalExtra.MOD_ID);

    public static final RegistryObject<MenuType<DynamoFrostMenu>> DYNAMO_FROST_CONTAINER = CONTAINERS.register("dynamo_frost", () -> IForgeMenuType.create((windowId, inv, data) -> new DynamoFrostMenu(windowId, getClientWorld(), data.readBlockPos(), inv, getClientPlayer())));
}
