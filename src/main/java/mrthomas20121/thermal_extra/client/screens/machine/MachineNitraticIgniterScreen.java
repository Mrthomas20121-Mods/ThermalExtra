package mrthomas20121.thermal_extra.client.screens.machine;

import cofh.thermal.core.client.gui.ThermalGuiHelper;
import cofh.thermal.lib.client.gui.MachineScreen;
import mrthomas20121.thermal_extra.inventory.machine.MachineNitraticIgniterMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import static cofh.core.util.helpers.GuiHelper.*;
import static cofh.lib.util.constants.ModIds.ID_THERMAL;

public class MachineNitraticIgniterScreen extends MachineScreen<MachineNitraticIgniterMenu> {

    public static final String TEX_PATH = ID_THERMAL + ":textures/gui/container/smelter.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public MachineNitraticIgniterScreen(MachineNitraticIgniterMenu container, Inventory inv, Component titleIn) {

        super(container, inv, container.tile, titleIn);
        texture = TEXTURE;
        info = generatePanelInfo("info.thermal_extra.nitratic_igniter");
        name = "nitratic_igniter";
    }

    @Override
    public void init() {

        super.init();

        addElement(createInputSlot(this, 35, 17, tile));
        addElement(createInputSlot(this, 53, 17, tile));
        addElement(createInputSlot(this, 71, 17, tile));

        addElement(createInputSlot(this, 53, 53, tile));

        addElement(createOutputSlot(this, 125, 26, tile));
        addElement(createOutputSlot(this, 143, 26, tile));
        addElement(createOutputSlot(this, 125, 44, tile));
        addElement(createOutputSlot(this, 143, 44, tile));

        addElement(ThermalGuiHelper.createDefaultProgress(this, 94, 35, PROG_ARROW_RIGHT, tile));
        addElement(ThermalGuiHelper.createDefaultSpeed(this, 53, 35, SCALE_CRUSH, tile));
    }

}
