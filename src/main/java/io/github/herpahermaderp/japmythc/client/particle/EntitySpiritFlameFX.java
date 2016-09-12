package io.github.herpahermaderp.japmythc.client.particle;

import org.lwjgl.opengl.GL11;

import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntitySpiritFlameFX extends EntityFX {

	private final ResourceLocation texture = new ResourceLocation(Reference.ID, "textures/particle/spiritflame_fx.png");
	
	public EntitySpiritFlameFX(World world, double parX, double parY, double parZ, double parMotionX, double parMotionY, double parMotionZ) {
		
		super(world, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        this.motionX = this.motionX * 0.009999999776482582D + parMotionX;
        this.motionY = this.motionY * 0.009999999776482582D + parMotionY;
        this.motionZ = this.motionZ * 0.009999999776482582D + parMotionZ;
        double d6 = parX + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        d6 = parY + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        d6 = parZ + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.particleRed = this.particleGreen = this.particleBlue = 1.0F;
        this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
        this.noClip = true;
	}
	
	@Override
	public void renderParticle(Tessellator tess, float partialTick, float par3, float par4, float par5, float par6, float par7) {
		
		float f6 = ((float)this.particleAge + partialTick) / (float)this.particleMaxAge;
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glDepthMask(false);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);
		tess.startDrawingQuads();
		tess.setBrightness(getBrightnessForRender(partialTick));
		float scale = 0.1F * particleScale;
		float x = (float)(prevPosX + (posX - prevPosX) * partialTick - interpPosX);
		float y = (float)(prevPosY + (posY - prevPosY) * partialTick - interpPosY);
		float z = (float)(prevPosZ + (posZ - prevPosZ) * partialTick - interpPosZ);
		tess.addVertexWithUV(x - par3 * scale - par6 * scale, y - par4 * scale, z - par5 * scale - par7 * scale, 0, 0);
		tess.addVertexWithUV(x - par3 * scale + par6 * scale, y + par4 * scale, z - par5 * scale + par7 * scale, 1, 0);
		tess.addVertexWithUV(x + par3 * scale + par6 * scale, y + par4 * scale, z + par5 * scale + par7 * scale, 1, 1);
		tess.addVertexWithUV(x + par3 * scale - par6 * scale, y - par4 * scale, z + par5 * scale - par7 * scale, 0, 1);
		tess.draw();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDepthMask(true);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
	}
	
	public int getFXLayer() {
		
		return 3;
	}
	
	public int getBrightnessForRender(float partialTick)
    {
        float f1 = ((float)this.particleAge + partialTick) / (float)this.particleMaxAge;

        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }

        if (f1 > 1.0F)
        {
            f1 = 1.0F;
        }

        int i = super.getBrightnessForRender(partialTick);
        int j = i & 255;
        int k = i >> 16 & 255;
        j += (int)(f1 * 15.0F * 16.0F);

        if (j > 240)
        {
            j = 240;
        }

        return j | k << 16;
    }
	
	public float getBrightness(float partialTick)
    {
        float f1 = ((float)this.particleAge + partialTick) / (float)this.particleMaxAge;

        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }

        if (f1 > 1.0F)
        {
            f1 = 1.0F;
        }

        float f2 = super.getBrightness(partialTick);
        return f2 * f1 + (1.0F - f1);
    }
	
	public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }

        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9599999785423279D;
        this.motionY *= 0.9599999785423279D;
        this.motionZ *= 0.9599999785423279D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }
}
