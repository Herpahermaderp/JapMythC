package io.github.herpahermaderp.japmythc.event;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.item.IExtendedReach;
import io.github.herpahermaderp.japmythc.item.ItemKatana;
import io.github.herpahermaderp.japmythc.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;

public class JapEventHandler {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(KeyInputEvent event) {
		
		KeyBinding[] keyBindings = ClientProxy.keyBindings;
		
		if(keyBindings[0].isPressed()) {
			
			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer thePlayer = mc.thePlayer;
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
					
					if(ieri != null) {
						
						float reach = ieri.getReach();
						MovingObjectPosition mov = ItemKatana.getMouseOverExtended(reach);
						
						if(mov != null) {
							
							EntityPlayerMP player = (EntityPlayerMP)EntityThrowable.getKUser();
						}
					}
				}
			}
		}
	}
}
