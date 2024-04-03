package mrthomas20121.thermal_extra.client.screens.machine;


import cofh.thermal.core.client.gui.ThermalGuiHelper;
import cofh.thermal.lib.client.gui.MachineScreen;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.inventory.machine.MachineFluidMixerMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import static cofh.core.util.helpers.GuiHelper.*;

public class MachineFluidMixerScreen extends MachineScreen<MachineFluidMixerMenu> {

    public static final String TEX_PATH = ThermalExtra.MOD_ID + ":textures/gui/container/fluid_mixer.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public MachineFluidMixerScreen(MachineFluidMixerMenu container, Inventory inv, Component titleIn) {

        super(container, inv, container.tile, titleIn);
        texture = TEXTURE;
        info = generatePanelInfo("info.thermal_extra.machine_fluid_mixer");
        name = "fluid_mixer";
    }

    @Override
    public void init() {

        super.init();


        addElement(setClearable(createMediumInputFluidStorage(this, 34, 22, tile.getTank(0), tile), tile, 0));
        addElement(setClearable(createMediumInputFluidStorage(this, 56, 22, tile.getTank(1), tile), tile, 1));

        
        addElement(setClearable(createMediumOutputFluidStorage(this, 116, 22, tile.getTank(2), tile), tile, 1));
        addElement(setClearable(createMediumOutputFluidStorage(this, 138, 22, tile.getTank(3), tile), tile, 1));

        addElement(ThermalGuiHelper.createDefaultFluidProgress(this, 80, 35, PROG_DROP_RIGHT, tile));
        addElement(ThermalGuiHelper.createDefaultProgress(this, 80, 35, PROG_DROP_RIGHT, tile));
    }

}