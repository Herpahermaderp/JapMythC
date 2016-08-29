package io.github.herpahermaderp.japmythc.proxy;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import io.github.herpahermaderp.japmythc.JapMythC;
import io.github.herpahermaderp.japmythc.event.JapEventHandler;
import io.github.herpahermaderp.japmythc.item.ModItems;
import io.github.herpahermaderp.japmythc.lib.Reference;
import io.github.herpahermaderp.japmythc.network.client.MessageKatanaTeleport;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		
		ModItems.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		
		JapMythC.network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.CHANNEL);
		
		int packetId = 0;
		
		JapMythC.network.registerMessage(MessageKatanaTeleport.Handler.class, MessageKatanaTeleport.class, packetId++, Side.SERVER);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		
		MinecraftForge.EVENT_BUS.register(new JapEventHandler());
	}
	
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		
		return ctx.getServerHandler().playerEntity;
	}
}
