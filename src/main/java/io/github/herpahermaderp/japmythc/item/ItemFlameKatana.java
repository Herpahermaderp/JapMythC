package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemFlameKatana extends ItemKatana implements IExtendedReach, ISpawnParticles {
	
	EntityPlayer player;
	
	public ItemFlameKatana(String unlocalizedName, ToolMaterial material) {
		
		super(unlocalizedName, material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
	}
	
	@Override
	public float getReach() {
		
		return 200.0F;
	}
	
	//@Override
	//@SideOnly(Side.CLIENT)
	//public void onUpdate(ItemStack stack, World world, Entity entity, int par1, boolean par2) {
		
		//float radius = 5.0F;
		
		//if(!world.isRemote) {
			
			//PacketDispatcher.sendToAllAround(new MessageISpawnParticles(player, radius), player, 64.0D);
		//}
	//}

	@Override
	public void spawnParticles(World world, EntityPlayer player, ItemStack stack, double posX, double posY, double posZ, float radius) {
		
		int i1 = MathHelper.floor_double(posX + radius);
		int j1 = MathHelper.floor_double(posY + radius);
		int k1 = MathHelper.floor_double(posZ + radius);
		
		for (int i = MathHelper.floor_double(posX - radius); i < i1; ++i) {
			
			for (int j = MathHelper.floor_double(posY - radius + 1.0D); j < j1; ++j) {
				
				for (int k = MathHelper.floor_double(posZ - radius); k < k1; ++k) {
					
					double d0 = (double)((float) i + world.rand.nextFloat());
					double d1 = (double)((float) j + world.rand.nextFloat());
					double d2 = (double)((float) k + world.rand.nextFloat());
					double d3 = d0 - posX;
					double d4 = d1 - posY;
					double d5 = d2 - posZ;
					double d6 = (double) MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
					d3 /= d6;
					d4 /= d6;
					d5 /= d6;
					double d7 = 0.5D / (d6 / (double) radius + 0.1D);
					d7 *= (double)(world.rand.nextFloat() * world.rand.nextFloat() + 0.3F);
					d3 *= d7;
					d4 *= d7;
					d5 *= d7;
					world.spawnParticle("flame", (d0 + posX * 1.0D) / 2.0D, (d1 + posY * 1.0D) / 2.0D, (d2 + posZ * 1.0D) / 2.0D, d3, d4, d5);
					world.spawnParticle("smoke", d0, d1, d2, d3, d4, d5);
				}
			}
		}
	}
}
