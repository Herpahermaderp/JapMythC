package io.github.herpahermaderp.japmythc.client.renderer.entity;

import io.github.herpahermaderp.japmythc.entity.monster.EntityAmanojaku;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderAmanojaku extends RenderLiving {

	protected ResourceLocation texture;
	
	public RenderAmanojaku(ModelBase model, float shadowSize) {
		
		super(model, shadowSize);
		setEntityTexture();
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase entity, float par2) {
		
		preRenderCallBackAmanojaku((EntityAmanojaku)entity, par2);
	}
	
	protected void preRenderCallBackAmanojaku(EntityAmanojaku entity, float par2) {
		
		
	}
	
	protected void setEntityTexture() {
		
		texture = new ResourceLocation(Reference.ID + ":/textures/entity/amanojaku.png");
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		
		return texture;
	}
}
