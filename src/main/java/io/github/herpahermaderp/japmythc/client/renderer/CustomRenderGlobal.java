package io.github.herpahermaderp.japmythc.client.renderer;

import io.github.herpahermaderp.japmythc.client.particle.EntitySpiritFlameFX;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class CustomRenderGlobal {

	private static Minecraft mc = Minecraft.getMinecraft();
	private static World theWorld = mc.theWorld;
	
	public static EntityFX spawnParticle(String particleName, double parX, double parY, double parZ, double motionX, double motionY, double motionZ) {
		
		if(mc != null && mc.renderViewEntity != null && mc.effectRenderer != null) {
			
			int particleSettings = mc.gameSettings.particleSetting;
			
			if(particleSettings == 1 && theWorld.rand.nextInt(3) == 0) {
				
				particleSettings = 2;
			}
			
			double varX = mc.renderViewEntity.posX - parX;
			double varY = mc.renderViewEntity.posY - parY;
			double varZ = mc.renderViewEntity.posZ - parZ;
			EntityFX eFX = null;
			double var1 = 16.0D;
			
			if(varX * varX + varY * varY + varZ + varZ > var1 * var1) {
				
				return null;
			}
			
			else if(particleSettings > 1) {
				
				return null;
			}
			
			else {
				
				if(particleName.equals("spirit_flame")) {
					
					eFX = new EntitySpiritFlameFX(theWorld, parX, parY, parZ, (float) motionX, (float) motionY, (float) motionZ);
				}
				
				mc.effectRenderer.addEffect((EntityFX) eFX);
				return (EntityFX) eFX;
			}
		}
		
		return null;
	}
}
