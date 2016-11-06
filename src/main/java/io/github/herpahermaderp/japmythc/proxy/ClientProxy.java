package io.github.herpahermaderp.japmythc.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.github.herpahermaderp.japmythc.client.model.ModelYamajijii;
import io.github.herpahermaderp.japmythc.client.renderer.entity.RenderSpiritFlame;
import io.github.herpahermaderp.japmythc.client.renderer.entity.RenderYamajijii;
import io.github.herpahermaderp.japmythc.entity.monster.EntityYamajijii;
import io.github.herpahermaderp.japmythc.entity.projectile.EntitySpiritFlame;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		
		super.preInit(e);
		RenderingRegistry.registerEntityRenderingHandler(EntityYamajijii.class, new RenderYamajijii(new ModelYamajijii(), 0.5F));
	}
	
	@Override
	public void init(FMLInitializationEvent e) {
		
		super.init(e);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		
		super.postInit(e);
	}
	
	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		
		return(ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx));
	}
	
	@Override
	public void registerRenderers() {
		
		super.registerRenderers();
		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritFlame.class, new RenderSpiritFlame(0));
	}
}
