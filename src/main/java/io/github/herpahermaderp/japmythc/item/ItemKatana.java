package io.github.herpahermaderp.japmythc.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import scala.util.Random;

public class ItemKatana extends ItemSword implements IExtendedReach, ISpawnParticlesGeneric {
	
	public static final int interval = 1200;
	IExtendedReach ieri;
	int entityId;
	EntityPlayerMP playerMP;
	
	public ItemKatana(String unlocalizedName, ToolMaterial material) {
		
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
	}
	
	@Override
	public float getReach() {
		
		return 200.0F;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void spawnParticles(World world, EntityPlayer player, ItemStack stack, double posX, double posY, double posZ, float r) {
		
		for(int par1 = 0; par1 < 20; ++par1) {
			
			Random rand = new Random();

			player.worldObj.spawnParticle("largesmoke", posX + (rand.nextDouble() - 0.5D) * (double)player.width, posY - 1.0D, posZ + (rand.nextDouble() - 0.5D) * (double)player.width, 0.0D, 0.0D, 0.0D);
		}
	}
}
