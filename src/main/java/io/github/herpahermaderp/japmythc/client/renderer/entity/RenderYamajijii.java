package io.github.herpahermaderp.japmythc.client.renderer.entity;

import io.github.herpahermaderp.japmythc.entity.monster.EntityYamajijii;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderYamajijii extends RenderLiving {

	protected ResourceLocation texture;
	
	public RenderYamajijii(ModelBase model, float shadowSize) {
		
		super(model, shadowSize);
		setEntityTexture();
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase entity, float par2) {
		
		preRenderCallbackYamajijii((EntityYamajijii)entity, par2);
	}
	
	protected void preRenderCallbackYamajijii(EntityYamajijii entity, float par2) {
		
	}
	
	protected void setEntityTexture() {
		
		texture = new ResourceLocation(Reference.ID + ":/textures/entity/yamajijii.png");
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		
		return texture;
	}
}
