package io.github.herpahermaderp.japmythc.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.lib.Reference;
import io.github.herpahermaderp.japmythc.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemSword;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class ItemKatana extends ItemSword implements IExtendedReach {
	
	public EntityLivingBase renderViewEntity;
	public EntityLivingBase entityLB;
	public static ItemKatana theClass;
	
	KeyBinding[] keyBindings = ClientProxy.keyBindings;
	
	public ItemKatana(String unlocalizedName, ToolMaterial material) {
		
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
	}
	
	@Override
	public float getReach() {
		
		return 20.0F;
	}
	
	public static MovingObjectPosition getTeleportReach(float dist) {
	    
		ItemKatana ik = ItemKatana.getIK();
		Minecraft mc = Minecraft.getMinecraft();
	    EntityLivingBase theRenderViewEntity = ik.getRenderViewEntity();
	    AxisAlignedBB theViewBoundingBox = AxisAlignedBB.getBoundingBox(theRenderViewEntity.posX-0.5D, theRenderViewEntity.posY-0.0D, theRenderViewEntity.posZ-0.5D, theRenderViewEntity.posX+0.5D, theRenderViewEntity.posY+1.5D, theRenderViewEntity.posZ+0.5D);
	    
	    MovingObjectPosition returnMOP = null;
	    
	    if (mc.theWorld != null) {
	        
	    	double var2 = dist;
	        returnMOP = theRenderViewEntity.rayTrace(var2, 0);
	        double calcdist = var2;
	        Vec3 pos = ik.getPositionEyes(0);
	        var2 = calcdist;
	       
	        if (returnMOP != null) {
	            
	        	calcdist = returnMOP.hitVec.distanceTo(pos);
	        }
	         
	        Vec3 lookvec = theRenderViewEntity.getLook(0);
	        Vec3 var8 = pos.addVector(lookvec.xCoord * var2, lookvec.yCoord * var2, lookvec.zCoord * var2);
	        Entity pointedEntity = null;
	        float var9 = 1.0F;
	        
	        @SuppressWarnings("unchecked")
	        List<Entity> list = mc.theWorld.getEntitiesWithinAABBExcludingEntity(theRenderViewEntity, theViewBoundingBox.addCoord(lookvec.xCoord * var2, lookvec.yCoord * var2, lookvec.zCoord * var2).expand(var9, var9, var9));
	        double d = calcdist;
	            
	        for (Entity entity : list) {
	            
	        	if (entity.canBeCollidedWith()) {
	                
	        		float bordersize = entity.getCollisionBorderSize();
	                
	        		AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(entity.posX-entity.width/2, entity.posY, entity.posZ-entity.width/2, entity.posX+entity.width/2, entity.posY+entity.height, entity.posZ+entity.width/2);
	                aabb.expand(bordersize, bordersize, bordersize);
	                MovingObjectPosition mop0 = aabb.calculateIntercept(pos, var8);
	                    
	                if (aabb.isVecInside(pos)) {
	                    
	                	if (0.0D < d || d == 0.0D) {
	                        
	                		pointedEntity = entity;
	                        d = 0.0D;
	                    }
	                } 
	                
	                else if (mop0 != null) {
	                    
	                	double d1 = pos.distanceTo(mop0.hitVec);
	                        
	                    if (d1 < d || d == 0.0D) {
	                        
	                    	pointedEntity = entity;
	                        d = d1;
	                    }
	                }
	            }
	        }
	           
	        if (pointedEntity != null && (d < calcdist || returnMOP == null)) {
	             
	        	returnMOP = new MovingObjectPosition(pointedEntity);
	        }
	    }
	    
	    return returnMOP;
	}
	
	public static ItemKatana getIK() {
		
		return theClass;
	}
	
	public EntityLivingBase getRenderViewEntity() {
		
		return this.renderViewEntity;
	}
	
	@SideOnly(Side.CLIENT)
	public Vec3 getPositionEyes(float par1) {
		
		if(par1 == 1.0F) {
			
			return Vec3.createVectorHelper(entityLB.posX, entityLB.posY + (double)entityLB.getEyeHeight(), entityLB.posZ);
		}
		
		else {
			
			double d0 = entityLB.prevPosX + (entityLB.posX - entityLB.prevPosX) * (double)par1;
			double d1 = entityLB.prevPosY + (entityLB.posY - entityLB.prevPosY) * (double)par1 + (double)entityLB.getEyeHeight();
			double d2 = entityLB.prevPosZ + (entityLB.posZ - entityLB.prevPosZ) * (double)par1;
			return Vec3.createVectorHelper(d0, d1, d2);
		}
	}
}
