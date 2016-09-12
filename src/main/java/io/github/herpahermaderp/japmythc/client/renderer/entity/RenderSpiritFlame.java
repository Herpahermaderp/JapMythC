package io.github.herpahermaderp.japmythc.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import io.github.herpahermaderp.japmythc.entity.projectile.EntitySpiritFlame;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderFireball;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderSpiritFlame extends RenderFireball {

	private static final ResourceLocation texture = new ResourceLocation(Reference.ID, "textures/entity/spirit_flame.png");
	private float field_77002_a;
	
	public RenderSpiritFlame(float p_i1254_1_) {
		
		super(p_i1254_1_);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		
		return getCustomTexture((EntitySpiritFlame) entity);
	}
	
	private ResourceLocation getCustomTexture(EntitySpiritFlame entity) {
		
		return texture;
	}
	
	@SuppressWarnings("unused")
	@Override
	public void doRender(Entity entity, double posX, double posY, double posZ, float yaw, float partialTick) {
		
		GL11.glPushMatrix();
		this.bindEntityTexture(entity);
		GL11.glTranslatef((float)posX, (float)posY, (float)posZ);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		float f2 = this.field_77002_a;
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		Tessellator tessellator = Tessellator.instance;
		float f3 = 0.0F;
		float f4 = 1.0F;
		float f5 = 0.0F;
		float f6 = 1.0F;
		float f7 = 1.0F;
		float f8 = 0.5F;
		float f9 = 0.25F;
		GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		tessellator.addVertexWithUV((double)(0.0F - f8), (double)(0.0F - f9), 0.0D, (double)f3, (double)f6);
		tessellator.addVertexWithUV((double)(f7 - f8), (double)(0.0F - f9), 0.0D, (double)f4, (double)f6);
		tessellator.addVertexWithUV((double)(f7 - f8), (double)(1.0F - f9), 0.0D, (double)f4, (double)f5);
		tessellator.addVertexWithUV((double)(0.0F - f8), (double)(1.0F - f9), 0.0D, (double)f3, (double)f5);
		tessellator.draw();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}
}
