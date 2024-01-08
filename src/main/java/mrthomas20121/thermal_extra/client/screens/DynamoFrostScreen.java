package mrthomas20121.thermal_extra.client.screens;

import cofh.thermal.core.client.gui.ThermalGuiHelper;
import cofh.thermal.lib.client.gui.DynamoScreen;
import mrthomas20121.thermal_extra.containers.DynamoFrostMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import static cofh.core.util.helpers.GuiHelper.*;
import static cofh.lib.util.constants.ModIds.ID_THERMAL;

public class DynamoFrostScreen extends DynamoScreen<DynamoFrostMenu> {

    public static final String TEX_PATH = ID_THERMAL + ":textures/gui/container/item_dynamo.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public DynamoFrostScreen(DynamoFrostMenu container, Inventory inv, Component titleIn) {

        super(container, inv, container.tile, titleIn);
        texture = TEXTURE;
        info = appendLine(generatePanelInfo("info.thermal_extra.dynamo_frost"), "info.thermal.dynamo.throttle");
    }

    @Override
    public void init() {

        super.init();

        addElement(ThermalGuiHelper.createDefaultDuration(this, 80, 35, SCALE_FLAME, tile));
    }

}

