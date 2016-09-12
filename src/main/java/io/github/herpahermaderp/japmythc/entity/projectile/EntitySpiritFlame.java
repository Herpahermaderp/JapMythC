package io.github.herpahermaderp.japmythc.entity.projectile;

import java.util.List;

import io.github.herpahermaderp.japmythc.client.renderer.CustomRenderGlobal;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntitySpiritFlame extends EntityFireball {

	private int field_145795_e = -1;
    private int field_145793_f = -1;
    private int field_145794_g = -1;
    private Block field_145796_h;
    private boolean inGround;
    public EntityLivingBase shootingEntity;
    private int ticksAlive;
    private int ticksInAir;
    public double accelerationX;
    public double accelerationY;
    public double accelerationZ;
    
	public EntitySpiritFlame(World world) {
        
		super(world);
        this.setSize(0.3125F, 0.3125F);
    }

    public EntitySpiritFlame(World world, EntityLivingBase entity, double posX, double posY, double posZ) {
        
    	super(world, entity, posX, posY, posZ);
        this.setSize(0.3125F, 0.3125F);
    }

    public EntitySpiritFlame(World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ) {
        
    	super(world, posX, posY, posZ, motionX, motionY, motionZ);
        this.setSize(0.3125F, 0.3125F);
    }
    
    @SuppressWarnings({ "rawtypes" })
	@Override
    public void onUpdate() {
    	
    	if (!this.worldObj.isRemote && (this.shootingEntity != null && this.shootingEntity.isDead || !this.worldObj.blockExists((int)this.posX, (int)this.posY, (int)this.posZ))) {
            
    		this.setDead();
        }
        
    	else {
            
    		super.onUpdate();
    		this.setFire(-1);

            if (this.inGround) {
                
            	if (this.worldObj.getBlock(this.field_145795_e, this.field_145793_f, this.field_145794_g) == this.field_145796_h) {
                    
            		++this.ticksAlive;

                    if (this.ticksAlive == 600) {
                        
                    	this.setDead();
                    }

                    return;
                }

                this.inGround = false;
                this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
                this.ticksAlive = 0;
                this.ticksInAir = 0;
            }
            
            else {
                
            	++this.ticksInAir;
            }

            Vec3 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            Vec3 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31);
            vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

            if (movingobjectposition != null) {
                
            	vec31 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
            }

            Entity entity = null;
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double d0 = 0.0D;

            for (int i = 0; i < list.size(); ++i) {
                
            	Entity entity1 = (Entity)list.get(i);

                if (entity1.canBeCollidedWith() && (!entity1.isEntityEqual(this.shootingEntity) || this.ticksInAir >= 25)) {
                    
                	float f = 0.3F;
                    AxisAlignedBB axisalignedbb = entity1.boundingBox.expand((double)f, (double)f, (double)f);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(vec3, vec31);

                    if (movingobjectposition1 != null) {
                        
                    	double d1 = vec3.distanceTo(movingobjectposition1.hitVec);

                        if (d1 < d0 || d0 == 0.0D) {
                            
                        	entity = entity1;
                            d0 = d1;
                        }
                    }
                }
            }

            if (entity != null) {
                
            	movingobjectposition = new MovingObjectPosition(entity);
            }

            if (movingobjectposition != null) {
            	
                this.onImpact(movingobjectposition);
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) + 90.0F;

            for (this.rotationPitch = (float)(Math.atan2((double)f1, this.motionY) * 180.0D / Math.PI) - 90.0F; this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
            	
                ;
            }

            while (this.rotationPitch - this.prevRotationPitch >= 180.0F) {
            	
                this.prevRotationPitch += 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw < -180.0F) {
            	
                this.prevRotationYaw -= 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw >= 180.0F) {
            	
                this.prevRotationYaw += 360.0F;
            }

            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
            float f2 = this.getMotionFactor();

            if (this.isInWater()) {
            	
                for (int j = 0; j < 4; ++j) {
                	
                    float f3 = 0.25F;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f3, this.posY - this.motionY * (double)f3, this.posZ - this.motionZ * (double)f3, this.motionX, this.motionY, this.motionZ);
                }

                f2 = 0.8F;
            }

            this.motionX += this.accelerationX;
            this.motionY += this.accelerationY;
            this.motionZ += this.accelerationZ;
            this.motionX *= (double)f2;
            this.motionY *= (double)f2;
            this.motionZ *= (double)f2;
            CustomRenderGlobal.spawnParticle("spirit_flame", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
            this.setPosition(this.posX, this.posY, this.posZ);
        }
    }
    
    protected float getMotionFactor() {
    	
        return 0.95F;
    }
    
    protected void onImpact(MovingObjectPosition mov) {
        
    	if (!this.worldObj.isRemote) {
            
    		if (mov.entityHit != null) {
                
    			if (!mov.entityHit.isImmuneToFire() && mov.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 5.0F)) {
                    
    				mov.entityHit.setFire(5);
                }
            }
            
    		else {
                
    			int i = mov.blockX;
                int j = mov.blockY;
                int k = mov.blockZ;

                switch (mov.sideHit) {
                    
                	case 0:
                        --j;
                        break;
                    
                	case 1:
                        ++j;
                        break;
                    
                	case 2:
                        --k;
                        break;
                    
                	case 3:
                        ++k;
                        break;
                    
                	case 4:
                        --i;
                        break;
                    
                	case 5:
                        ++i;
                }

                if (this.worldObj.isAirBlock(i, j, k)) {
                    
                	this.worldObj.setBlock(i, j, k, Blocks.fire);
                }
            }

            this.setDead();
        }
    }

    public boolean canBeCollidedWith() {
        
    	return false;
    }

    public boolean attackEntityFrom(DamageSource attackSource, float par2) {
        
    	return false;
    }
}