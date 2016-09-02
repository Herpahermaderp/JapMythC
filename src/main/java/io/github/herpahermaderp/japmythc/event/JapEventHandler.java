package io.github.herpahermaderp.japmythc.event;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.JapMythC;
import io.github.herpahermaderp.japmythc.item.IExtendedReach;
import io.github.herpahermaderp.japmythc.item.ItemKatana;
import io.github.herpahermaderp.japmythc.network.client.MessageKatanaTeleport;
import io.github.herpahermaderp.japmythc.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.client.event.MouseEvent;

public class JapEventHandler {

	public static final int interval = 1200;
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(MouseEvent par2Event) {
		
		KeyBinding[] keyBindings = ClientProxy.keyBindings;
		
		if(keyBindings[0].isPressed()) {
			
			if(par2Event.button == 1 && par2Event.buttonstate) {
				
				Minecraft mc = Minecraft.getMinecraft();
				EntityPlayer thePlayer = mc.thePlayer;
				World world = thePlayer.getEntityWorld();
			
				if(thePlayer != null) {
				
					ItemStack stack = thePlayer.getCurrentEquippedItem();
					IExtendedReach ieri;
				
					if(stack != null) {
					
						if(stack.getItem() instanceof IExtendedReach) {
						
							ieri = (IExtendedReach) stack.getItem();
						}
					
						else {
						
							ieri = null;
						}
				
						if(!stack.hasTagCompound()) {
							
							stack.setTagCompound(new NBTTagCompound());
						}
						
						if(world.getTotalWorldTime() > stack.getTagCompound().getInteger("nextUse")) {
						
							if(ieri != null) {
								
								float reach = ieri.getReach();
								MovingObjectPosition mov = ItemKatana.getTeleportReach(reach);
						
								if(mov != null) {
							
									if(mov.entityHit != null && mov.entityHit.hurtResistantTime == 0) {
								
										if(mov.entityHit != thePlayer) {
									
											JapMythC.network.sendToServer(new MessageKatanaTeleport(mov.entityHit.getEntityId()));		
											thePlayer.getCurrentEquippedItem().damageItem(10, thePlayer);
											stack.getTagCompound().setInteger("nextUse", (int)(world.getTotalWorldTime() + interval));
										}
									}
								}
							}
						}
					}
				}
			}
		}		
	}

}