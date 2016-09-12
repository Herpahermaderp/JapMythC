package io.github.herpahermaderp.japmythc.network.server;

import java.io.IOException;
import java.util.List;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.github.herpahermaderp.japmythc.item.ISpawnParticlesSF;
import io.github.herpahermaderp.japmythc.network.AbstractMessage.AbstractServerMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.AxisAlignedBB;

public class PacketSFJumpAttack extends AbstractServerMessage<PacketSFJumpAttack> {

	private int entityId;
	
	public PacketSFJumpAttack() {
		
	}
	
	public PacketSFJumpAttack(int theEntityId) {
		
		entityId = theEntityId;
	}
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		
		entityId = ByteBufUtils.readVarInt(buffer, 4);
	}
	
	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		
		ByteBufUtils.writeVarInt(buffer, entityId, 4);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	protected void process(EntityPlayer player, Side side) {
		
		if(player.getCurrentEquippedItem().getItem() instanceof ISpawnParticlesSF) {
			
			if(!player.worldObj.isRemote) {
				
				double radius = 5.0D;
				List list = player.worldObj.getEntitiesWithinAABBExcludingEntity(player, AxisAlignedBB.getBoundingBox(player.posX - radius, player.posY - radius, player.posZ - radius, player.posX + radius, player.posY + 6.0D - radius, player.posZ + radius));
				int listSize = list.size();
				int fireTime = 10;
				
				for(int l = 0; l < listSize; l++) {
					
					Entity entity = (Entity) list.get(l);
					entity.setFire(fireTime);
				}
			}
		}
	}
}
