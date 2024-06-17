package mrthomas20121.thermal_extra.client.screens.machine;


import cofh.thermal.core.client.gui.ThermalGuiHelper;
import cofh.thermal.lib.client.gui.MachineScreen;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.inventory.machine.MachineEndothermicDehydratorMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import static cofh.core.util.helpers.GuiHelper.*;

public class MachineEndothermicDehydratorScreen extends MachineScreen<MachineEndothermicDehydratorMenu> {

    public static final String TEX_PATH = ThermalExtra.MOD_ID + ":textures/gui/container/endothermic_dehydrator.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public MachineEndothermicDehydratorScreen(MachineEndothermicDehydratorMenu container, Inventory inv, Component titleIn) {

        super(container, inv, container.tile, titleIn);
        texture = TEXTURE;
        info = generatePanelInfo("info.thermal_extra.endothermic_dehydrator");
        name = "endothermic_dehydrator";
    }

    @Override
    public void init() {

        super.init();

        addElement(createOutputSlot(this, 118, 17, tile));
        addElement(createOutputSlot(this, 118, 35, tile));
        addElement(createOutputSlot(this, 118, 53, tile));
        addElement(createOutputSlot(this, 136, 17, tile));
        addElement(createOutputSlot(this, 136, 35, tile));
        addElement(createOutputSlot(this, 136, 53, tile));

        addElement(setClearable(createMediumInputFluidStorage(this, 34, 22, tile.getTank(0), tile), tile, 0));
        addElement(setClearable(createMediumOutputFluidStorage(this, 150, 22, tile.getTank(1), tile), tile, 1));

        addElement(ThermalGuiHelper.createDefaultFluidProgress(this, 88, 35, PROG_ARROW_FLUID_RIGHT, tile));
        addElement(ThermalGuiHelper.createDefaultProgress(this, 88, 35, PROG_ARROW_RIGHT, tile));
    }

}