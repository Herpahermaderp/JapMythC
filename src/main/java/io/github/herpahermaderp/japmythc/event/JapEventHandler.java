package io.github.herpahermaderp.japmythc.event;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.entity.projectile.EntitySpiritFlame;
import io.github.herpahermaderp.japmythc.item.IExtendedReach;
import io.github.herpahermaderp.japmythc.item.ISpawnParticlesSF;
import io.github.herpahermaderp.japmythc.network.PacketDispatcher;
import io.github.herpahermaderp.japmythc.network.client.PacketISpawnParticlesSF;
import io.github.herpahermaderp.japmythc.network.server.PacketKatanaTeleport;
import io.github.herpahermaderp.japmythc.network.server.PacketSFJumpAttack;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;

public class JapEventHandler {

	public static final int interval = 1200;
	public static final int damage = 10;
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onRightClickLeftShiftEvent(MouseEvent event) {
		
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		World world = player.getEntityWorld();
		ItemStack stack = player.getCurrentEquippedItem();
		IExtendedReach ieri;
		
		if(stack != null) {
		
			if(stack.getItem() instanceof IExtendedReach) {
				
				ieri = (IExtendedReach) stack.getItem();
				
				if(event.button == 1 && event.buttonstate) {
					
					if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
						
						if(player != null) {
					
							if(!stack.hasTagCompound()) {
								
								stack.setTagCompound(new NBTTagCompound());
							}
							
							if(world.getTotalWorldTime() > stack.getTagCompound().getInteger("nextUseTP")) {
							
								if(ieri != null) {
									
									float reach = ieri.getReach();
									MovingObjectPosition mov = PacketKatanaTeleport.getTeleportReach(reach);
							
									if(mov != null) {
								
										if(mov.entityHit != null && mov.entityHit.hurtResistantTime == 0) {
									
											if(mov.entityHit != player) {
												
												System.out.println("Sending PacketKatanaTeleport to SERVER");
												PacketDispatcher.sendToServer(new PacketKatanaTeleport(mov.entityHit.getEntityId()));	
												player.getCurrentEquippedItem().damageItem(damage, player);
												
												if(!player.capabilities.isCreativeMode) {
													
													stack.getTagCompound().setInteger("nextUseTP", (int)(world.getTotalWorldTime() + interval));
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
			else {
				
				ieri = null;
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onLeftShiftJump(LivingJumpEvent event) {
		
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		World world = player.getEntityWorld();
		ItemStack stack = player.getCurrentEquippedItem();
		ISpawnParticlesSF ispsf;
		float radius = 5.0F;
		
		if(stack != null) {
			
			if(stack.getItem() instanceof ISpawnParticlesSF) {
				
				ispsf = (ISpawnParticlesSF) stack.getItem();
				
				if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
					
					if(event.entity == player) {
						
						if(player != null) {
							
							if(!stack.hasTagCompound()) {
								
								stack.setTagCompound(new NBTTagCompound());
							}

							if(world.getTotalWorldTime() > stack.getTagCompound().getInteger("nextUseJump")) {
							
								if(ispsf != null) {
									
									System.out.println("Sending PacketISPawnParticlesSF to CLIENT");
									PacketDispatcher.sendToAllAround(new PacketISpawnParticlesSF(player, radius), player, 64.0D);
									System.out.println("Sending PacketSFJumpAttack to SERVER");
									PacketDispatcher.sendToServer(new PacketSFJumpAttack());
									player.getCurrentEquippedItem().damageItem(damage, player);
									
									if(!player.capabilities.isCreativeMode) {
										
										stack.getTagCompound().setInteger("nextUseJump", (int)(world.getTotalWorldTime() + interval));
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onLeftClickLeftShiftEvent(MouseEvent event) {
		
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		ItemStack stack = player.getCurrentEquippedItem();
		ISpawnParticlesSF ispsf;
		float par1;
		
		if(stack != null) {
			
			if(stack.getItem() instanceof ISpawnParticlesSF) {
				
				ispsf = (ISpawnParticlesSF) stack.getItem();
				
				if(event.button == 0 && event.buttonstate) {
					
					if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
						
						if(player != null) {
							
							if(ispsf != null) {
								
								Vec3 vec = player.getLook(1);
								
								for(int i = 0; i < 1; ++i) {
									
									EntitySpiritFlame entityspiritflame = new EntitySpiritFlame(player.worldObj, player.posX, player.posY, player.posZ, vec.xCoord, vec.yCoord, vec.zCoord);
									entityspiritflame.shootingEntity = player;
									player.worldObj.spawnEntityInWorld(entityspiritflame);
									player.getCurrentEquippedItem().damageItem(damage, player);
								}
							}
						}
					}
				}
			}
		}
	}
}