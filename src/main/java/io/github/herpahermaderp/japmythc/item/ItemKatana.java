package io.github.herpahermaderp.japmythc.item;

import java.util.List;

import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemSword;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class ItemKatana extends ItemSword implements IExtendedReach {
	
	public ItemKatana(String unlocalizedName, ToolMaterial material) {
		
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
	}
	
	@Override
	public float getReach() {
		
		return 200.0F;
	}
	
	public static MovingObjectPosition getTeleportReach(float dist) {
	    
		Minecraft mc = Minecraft.getMinecraft();
	    AxisAlignedBB theViewBoundingBox = AxisAlignedBB.getBoundingBox(mc.renderViewEntity.posX-0.5D, mc.renderViewEntity.posY-0.0D, mc.renderViewEntity.posZ-0.5D, mc.renderViewEntity.posX+0.5D, mc.renderViewEntity.posY+1.5D,mc.renderViewEntity.posZ+0.5D);
	    MovingObjectPosition returnMOP = null;
	    
	    if(mc.renderViewEntity != null) {
	    
	    	if (mc.theWorld != null) {
	        
	    		double var2 = dist;
	    		returnMOP = mc.renderViewEntity.rayTrace(var2, 0);
	    		double calcdist = var2;
	    		Vec3 pos = mc.renderViewEntity.getPosition(0);
	    		var2 = calcdist;
	       
	    		if (returnMOP != null) {
	            
	    			calcdist = returnMOP.hitVec.distanceTo(pos);
	    		}
	         
	    		Vec3 lookvec = mc.renderViewEntity.getLook(0);
	    		Vec3 var8 = pos.addVector(lookvec.xCoord * var2, lookvec.yCoord * var2, lookvec.zCoord * var2);
	    		Entity pointedEntity = null;
	    		float var9 = 1.0F;
	        
	    		@SuppressWarnings("unchecked")
	    		List<Entity> list = mc.theWorld.getEntitiesWithinAABBExcludingEntity(mc.renderViewEntity, theViewBoundingBox.addCoord(lookvec.xCoord * var2, lookvec.yCoord * var2, lookvec.zCoord * var2).expand(var9, var9, var9));
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
	    }
	    	
	    return returnMOP;   
	}
}
