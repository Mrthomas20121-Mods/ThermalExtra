package mrthomas20121.thermal_extra.client.screens.machine;


import cofh.thermal.core.client.gui.ThermalGuiHelper;
import cofh.thermal.lib.client.gui.MachineScreen;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.inventory.machine.MachineAdvancedRefineryMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import static cofh.core.util.helpers.GuiHelper.*;

public class MachineAdvancedRefineryScreen extends MachineScreen<MachineAdvancedRefineryMenu> {

    public static final String TEX_PATH = ThermalExtra.MOD_ID + ":textures/gui/container/advanced_refinery.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public MachineAdvancedRefineryScreen(MachineAdvancedRefineryMenu container, Inventory inv, Component titleIn) {

        super(container, inv, container.tile, titleIn);
        texture = TEXTURE;
        info = generatePanelInfo("info.thermal.machine_refinery");
        name = "refinery";
    }

    @Override
    public void init() {

        super.init();

        addElement(createOutputSlot(this, 100, 17, tile));
        addElement(createOutputSlot(this, 100, 35, tile));
        addElement(createOutputSlot(this, 100, 53, tile));

        addElement(setClearable(createSmallInputFluidStorage(this, 34, 17, tile.getTank(0), tile), tile, 0));


        addElement(setClearable(createMediumOutputFluidStorage(this, 118, 22, tile.getTank(1), tile), tile, 1));
        addElement(setClearable(createMediumOutputFluidStorage(this, 136, 22, tile.getTank(2), tile), tile, 2));
        addElement(setClearable(createMediumOutputFluidStorage(this, 154, 22, tile.getTank(3), tile), tile, 3));

        addElement(ThermalGuiHelper.createDefaultFluidProgress(this, 65, 35, PROG_DROP_RIGHT, tile));
        addElement(ThermalGuiHelper.createDefaultProgress(this, 65, 35, PROG_DROP_RIGHT, tile));
        addElement(ThermalGuiHelper.createDefaultSpeed(this, 35, 53, SCALE_FLAME, tile));
    }

}