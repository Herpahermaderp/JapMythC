package io.github.herpahermaderp.japmythc.network.client;

import java.io.IOException;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.github.herpahermaderp.japmythc.item.ISpawnParticlesFlames;
import io.github.herpahermaderp.japmythc.item.ISpawnParticlesGeneric;
import io.github.herpahermaderp.japmythc.network.AbstractMessage.AbstractClientMessage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

public class PacketISpawnParticlesFlames extends AbstractClientMessage<PacketISpawnParticlesFlames> {

	private ItemStack stack;
	private String commandSenderName;
	private float r;
	
	public PacketISpawnParticlesFlames() {
		
	}
	
	public PacketISpawnParticlesFlames(EntityPlayer player, float radius) {
		
		this.commandSenderName = player.getCommandSenderName();
		this.stack = player.getHeldItem();
		r = radius;
	}
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		
		commandSenderName = ByteBufUtils.readUTF8String(buffer);
		stack = ByteBufUtils.readItemStack(buffer);
		r = buffer.readFloat();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		
		ByteBufUtils.writeUTF8String(buffer, commandSenderName);
		ByteBufUtils.writeItemStack(buffer, stack);
		buffer.writeFloat(r);
	}

	@Override
	protected void process(EntityPlayer player, Side side) {
		
EntityPlayer commandSender = player.worldObj.getPlayerEntityByName(commandSenderName);
		
		if(commandSender != null && stack != null && stack.getItem() instanceof ISpawnParticlesGeneric) {
			
			((ISpawnParticlesFlames) stack.getItem()).spawnParticlesFlames(player.worldObj, commandSender, stack, player.posX, player.posY, player.posZ, r);
		}
	}
}
