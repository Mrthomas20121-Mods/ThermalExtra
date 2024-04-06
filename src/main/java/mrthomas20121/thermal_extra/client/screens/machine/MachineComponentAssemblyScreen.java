package mrthomas20121.thermal_extra.client.screens.machine;

import cofh.thermal.core.client.gui.ThermalGuiHelper;
import cofh.thermal.lib.client.gui.MachineScreen;
import mrthomas20121.thermal_extra.ThermalExtra;
import mrthomas20121.thermal_extra.inventory.machine.MachineComponentAssemblyMenu;
import mrthomas20121.thermal_extra.inventory.machine.MachineMetalInfuserMenu;
import mrthomas20121.thermal_extra.recipe.ComponentAssemblyRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import static cofh.core.util.helpers.GuiHelper.*;
import static cofh.lib.util.constants.ModIds.ID_THERMAL;

public class MachineComponentAssemblyScreen extends MachineScreen<MachineComponentAssemblyMenu> {

    public static final String TEX_PATH = ThermalExtra.MOD_ID + ":textures/gui/container/component_assembly.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public MachineComponentAssemblyScreen(MachineComponentAssemblyMenu container, Inventory inv, Component titleIn) {

        super(container, inv, container.tile, titleIn);
        texture = TEXTURE;
        info = generatePanelInfo("info.thermal_extra.machine_metal_infuser");
        name = "component_assembly";
    }

    @Override
    public void init() {

        super.init();

        addElement(createInputSlot(this, 62, 17, tile));
        addElement(createInputSlot(this, 62, 35, tile));
        addElement(createInputSlot(this, 62, 53, tile));
        addElement(createInputSlot(this, 80, 17, tile));
        addElement(createInputSlot(this, 80, 35, tile));
        addElement(createInputSlot(this, 80, 53, tile));

        addElement(createLargeOutputSlot(this, 130, 35, tile));

        addElement(setClearable(createMediumInputFluidStorage(this, 34, 22, tile.getTank(0), tile), tile, 0));
        addElement(setClearable(createMediumInputFluidStorage(this, 153, 22, tile.getTank(1), tile), tile, 1));

        addElement(ThermalGuiHelper.createDefaultFluidProgress(this, 98, 35, PROG_ARROW_FLUID_RIGHT, tile));
        addElement(ThermalGuiHelper.createDefaultProgress(this, 98, 35, PROG_ARROW_RIGHT, tile));
    }

}
