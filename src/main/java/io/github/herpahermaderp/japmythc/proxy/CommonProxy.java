package io.github.herpahermaderp.japmythc.proxy;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import io.github.herpahermaderp.japmythc.item.ModItems;

public class CommonProxy {

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		
		ModItems.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
