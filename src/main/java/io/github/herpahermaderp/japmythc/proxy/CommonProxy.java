package io.github.herpahermaderp.japmythc.proxy;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.registry.GameRegistry;
import io.github.herpahermaderp.japmythc.JapMythC;
import io.github.herpahermaderp.japmythc.block.ModBlocks;
import io.github.herpahermaderp.japmythc.entity.ModEntities;
import io.github.herpahermaderp.japmythc.event.JapEventHandler;
import io.github.herpahermaderp.japmythc.item.ModItems;
import io.github.herpahermaderp.japmythc.item.ModRecipes;
import io.github.herpahermaderp.japmythc.network.GuiHandler;
import io.github.herpahermaderp.japmythc.network.PacketDispatcher;
import io.github.herpahermaderp.japmythc.tileentity.ModTileEntities;
import io.github.herpahermaderp.japmythc.world.CustomWorldGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		
		ModTileEntities.init();
		ModBlocks.init();
		ModItems.init();
		PacketDispatcher.registerPackets();
		ModEntities.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		
		GameRegistry.registerWorldGenerator(new CustomWorldGenerator(), 0);
		ModRecipes.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(JapMythC.instance, new GuiHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		
		MinecraftForge.EVENT_BUS.register(new JapEventHandler());
	}
	
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		
		return ctx.getServerHandler().playerEntity;
	}
	
	public void registerRenderers() {
		
		
	}
}
