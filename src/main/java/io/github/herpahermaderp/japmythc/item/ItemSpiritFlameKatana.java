package io.github.herpahermaderp.japmythc.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.client.renderer.CustomRenderGlobal;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemSpiritFlameKatana extends ItemFlameKatana implements IExtendedReach, ISpawnParticlesGeneric, ISpawnParticlesSF {
	
	public ItemSpiritFlameKatana(String unlocalizedName, ToolMaterial material) {
		
		super(unlocalizedName, material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
	}
	
	@SideOnly(Side.CLIENT)
	public void spawnParticlesSF(World world, EntityPlayer player, ItemStack stack, double posX, double posY, double posZ, float radius) {
		
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
					//player.worldObj.spawnParticle("flame", (d0 + posX) / 2.0D, posY - 1.0D, (d2 + posZ) / 2.0D, d3, 0.0D, d5);
					CustomRenderGlobal.spawnParticle("spirit_flame", (d0 + posX) / 2.0D, posY - 1.0D, (d2 + posZ) / 2.0D, d3, 0, d5);
				}
			}
		}
	}
}
