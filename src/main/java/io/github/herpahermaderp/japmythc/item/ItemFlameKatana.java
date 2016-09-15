package io.github.herpahermaderp.japmythc.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import scala.util.Random;

public class ItemFlameKatana extends ItemKatana implements IExtendedReach, ISpawnParticlesGeneric, ISpawnParticlesFlames {
	
	EntityPlayer player;
	
	public ItemFlameKatana(String unlocalizedName, ToolMaterial material) {
		
		super(unlocalizedName, material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
		this.setCreativeTab(CustomCreativeTabs.tab);
	}
	
	@Override
	public float getReach() {
		
		return 200.0F;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void spawnParticlesFlames(World world, EntityPlayer player, ItemStack stack, double posX, double posY, double posZ, float r) {
		
		for(int par1 = 0; par1 < 20; ++par1) {
			
			Random rand = new Random();
			double motionX = rand.nextGaussian() * 0.02D;
			double motionY = rand.nextGaussian() * 0.02D;
		    double motionZ = rand.nextGaussian() * 0.02D;
			
			player.worldObj.spawnParticle("flame", posX + (rand.nextDouble() - 0.5D) * (double)player.width, posY - 1.0D, posZ + (rand.nextDouble() - 0.5D) * (double)player.width, motionX, motionY, motionZ);
		}
	}
}
