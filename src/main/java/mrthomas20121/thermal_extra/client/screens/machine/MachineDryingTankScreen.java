package mrthomas20121.thermal_extra.client.screens.machine;


import cofh.thermal.core.client.gui.ThermalGuiHelper;
import cofh.thermal.lib.client.gui.MachineScreen;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.inventory.machine.MachineDryingTankMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import static cofh.core.util.helpers.GuiHelper.*;

public class MachineDryingTankScreen extends MachineScreen<MachineDryingTankMenu> {

    public static final String TEX_PATH = ThermalExtra.MOD_ID + ":textures/gui/container/drying_tank.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public MachineDryingTankScreen(MachineDryingTankMenu container, Inventory inv, Component titleIn) {

        super(container, inv, container.tile, titleIn);
        texture = TEXTURE;
        info = generatePanelInfo("info.thermal_extra.drying_tank");
        name = "drying_tank";
    }

    @Override
    public void init() {

        super.init();

        addElement(createOutputSlot(this, 100, 17, tile));
        addElement(createOutputSlot(this, 100, 35, tile));
        addElement(createOutputSlot(this, 100, 53, tile));
        addElement(createOutputSlot(this, 118, 17, tile));
        addElement(createOutputSlot(this, 118, 35, tile));
        addElement(createOutputSlot(this, 118, 53, tile));

        addElement(setClearable(createMediumOutputFluidStorage(this, 34, 17, tile.getTank(0), tile), tile, 0));

        addElement(ThermalGuiHelper.createDefaultFluidProgress(this, 65, 35, PROG_DROP_RIGHT, tile));
        addElement(ThermalGuiHelper.createDefaultProgress(this, 65, 35, PROG_DROP_RIGHT, tile));
    }

}