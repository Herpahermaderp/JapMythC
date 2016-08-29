package io.github.herpahermaderp.japmythc.network.client;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

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
		
		@Override
		public IMessage onMessage(final MessageKatanaTeleport message, MessageContext ctx) {
			
			return null;
		}
	}
}
