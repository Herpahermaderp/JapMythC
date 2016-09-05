package io.github.herpahermaderp.japmythc.network.client;

import java.util.Random;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.github.herpahermaderp.japmythc.JapMythC;
import io.github.herpahermaderp.japmythc.item.IExtendedReach;
import io.github.herpahermaderp.japmythc.item.ItemKatana;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MovingObjectPosition;

public class MessageKatanaTeleport implements IMessage {
	
	private int entityId;
	
	public MessageKatanaTeleport() {
		
	}
	
	public MessageKatanaTeleport(int parEntityId) {
		
		entityId = parEntityId;
		System.out.println("Constructor");
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
		entityId = ByteBufUtils.readVarInt(buf, 4);
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		
		ByteBufUtils.writeVarInt(buf, entityId, 4);
	}
	
	public static class Handler implements IMessageHandler<MessageKatanaTeleport, IMessage> {
		
		Random rand = new Random();
		
		@Override
		public IMessage onMessage(final MessageKatanaTeleport message, MessageContext ctx) {
			
			final EntityPlayerMP thePlayerMP = (EntityPlayerMP)JapMythC.proxy.getPlayerEntity(ctx);	
			Entity theEntity = thePlayerMP.worldObj.getEntityByID(message.entityId);	
			
			if(thePlayerMP.getCurrentEquippedItem() == null) {
					
				return null;
			}
				
			if(thePlayerMP.getCurrentEquippedItem().getItem() instanceof IExtendedReach) {
					
				IExtendedReach theWeapon = (IExtendedReach)thePlayerMP.getCurrentEquippedItem().getItem();
				float reach = theWeapon.getReach();
				MovingObjectPosition mov = ItemKatana.getTeleportReach(reach);
				double distanceSq = thePlayerMP.getDistanceSqToEntity(theEntity);
				double reachSq = theWeapon.getReach() * theWeapon.getReach();
				
				if(reachSq >= distanceSq) {
					
					thePlayerMP.attackTargetEntityWithCurrentItem(theEntity);
					thePlayerMP.setPositionAndUpdate(mov.entityHit.posX, mov.entityHit.posY, mov.entityHit.posZ);
					
					double motionX = this.rand.nextGaussian() * 0.02D;
					double motionY = this.rand.nextGaussian() * 0.02D;
					double motionZ = this.rand.nextGaussian() * 0.02D;
					thePlayerMP.worldObj.spawnParticle("heart", thePlayerMP.posX + rand.nextFloat() * thePlayerMP.width * 2.0F - thePlayerMP.width, thePlayerMP.posY + 0.5D + rand.nextFloat() * thePlayerMP.height, thePlayerMP.posZ + rand.nextFloat() * thePlayerMP.width * 2.0F - thePlayerMP.width, motionX, motionY, motionZ);
					System.out.println(thePlayerMP.worldObj.isRemote);
				}	
				
				return null;
			}
			
			return null;
		}
	}
}
