package io.github.herpahermaderp.japmythc.proxy;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;

public class ClientProxy extends CommonProxy {

	public static KeyBinding[] keyBindings;
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		
		super.preInit(e);
	}
	
	@Override
	public void init(FMLInitializationEvent e) {
		
		super.init(e);
		keyBindings = new KeyBinding[1];
		
		keyBindings[1] = new KeyBinding("key.desc", Keyboard.KEY_LSHIFT, "key.desc");
		
		for(int i = 0; i < keyBindings.length; ++i) {
			
			ClientRegistry.registerKeyBinding(keyBindings[i]);
		}
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		
		super.postInit(e);
	}
	
	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		
		return(ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx));
	}
}
