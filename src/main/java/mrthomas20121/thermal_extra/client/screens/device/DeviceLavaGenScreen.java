package mrthomas20121.thermal_extra.client.screens.device;

import cofh.thermal.lib.client.gui.AugmentableTileScreen;
import mrthomas20121.thermal_extra.inventory.device.DeviceLavaGenMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import static cofh.core.util.helpers.GuiHelper.createMediumFluidStorage;
import static cofh.core.util.helpers.GuiHelper.generatePanelInfo;
import static cofh.lib.util.constants.ModIds.ID_THERMAL;

public class DeviceLavaGenScreen extends AugmentableTileScreen<DeviceLavaGenMenu> {

    public static final String TEX_PATH = ID_THERMAL + ":textures/gui/container/water_gen.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public DeviceLavaGenScreen(DeviceLavaGenMenu container, Inventory inv, Component titleIn) {

        super(container, inv, container.tile, titleIn);
        texture = TEXTURE;
        info = generatePanelInfo("info.thermal.device_water_gen");
    }

    @Override
    public void init() {

        super.init();

        addElement(createMediumFluidStorage(this, 116, 22, tile.getTank(0)));
    }

}
