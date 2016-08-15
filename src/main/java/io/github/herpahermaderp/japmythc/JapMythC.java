package io.github.herpahermaderp.japmythc;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import io.github.herpahermaderp.japmythc.lib.Reference;
import io.github.herpahermaderp.japmythc.proxy.CommonProxy;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VER)

public class JapMythC {

	@SidedProxy(clientSide = Reference.PROXY_LOC + ".ClientProxy", serverSide = Reference.PROXY_LOC + ".ServerProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static JapMythC instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		
		proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		
		proxy.postInit(e);
	}
}
