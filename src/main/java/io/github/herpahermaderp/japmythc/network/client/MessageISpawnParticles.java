package io.github.herpahermaderp.japmythc.network.client;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.relauncher.Side;
import io.github.herpahermaderp.japmythc.item.ISpawnParticles;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class MessageISpawnParticles implements IMessage {

	private ItemStack stack;
	private String senderName;
	private float r;
	
	public MessageISpawnParticles() {
		
	}
	
	public MessageISpawnParticles(EntityPlayer player, float radius) {
	
		this.senderName = player.getCommandSenderName();
		this.stack = player.getHeldItem();
		r = radius;
	}
		
	@Override
	public void fromBytes(ByteBuf buf) {
		
		senderName = ByteBufUtils.readUTF8String(buf);
		stack = ByteBufUtils.readItemStack(buf);
		r = buf.readFloat();
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		
		ByteBufUtils.writeUTF8String(buf, senderName);
		ByteBufUtils.writeItemStack(buf, stack);
		buf.writeFloat(r);
	}
	
	protected void process(EntityPlayer player, Side side) {
		
		EntityPlayer commandSender = player.worldObj.getPlayerEntityByName(senderName);
		
		if(commandSender != null && stack != null && stack.getItem() instanceof ISpawnParticles) {
			
			((ISpawnParticles) stack.getItem()).spawnParticles(player.worldObj, commandSender, stack, player.posX, player.posY, player.posZ, r);
		}
	}
}
