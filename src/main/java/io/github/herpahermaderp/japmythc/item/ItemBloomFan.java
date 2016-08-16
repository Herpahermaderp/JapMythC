package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBloomFan extends Item {

	public ItemBloomFan(String unlocalizedName) {
		
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int par1, int par2, int par3, int par4, float f1, float f2, float f3) {
		
		return ItemDye.applyBonemeal(stack, world, par1, par2, par3, player);
	}
}
