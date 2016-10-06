package io.github.herpahermaderp.japmythc.network;

import cpw.mods.fml.common.network.IGuiHandler;
import io.github.herpahermaderp.japmythc.client.gui.GuiTatara;
import io.github.herpahermaderp.japmythc.inventory.ContainerTatara;
import io.github.herpahermaderp.japmythc.tileentity.TileEntityTatara;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

	public static final int GUI_TATARA = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if(ID == GUI_TATARA) {
			
			return new ContainerTatara(player.inventory, (TileEntityTatara)world.getTileEntity(x, y, z));
		}
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if(ID == GUI_TATARA) {
			
			return new GuiTatara(player.inventory, (TileEntityTatara)world.getTileEntity(x, y, z));
		}
		
		return null;
	}
}
