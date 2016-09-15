package io.github.herpahermaderp.japmythc.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockModLeaves extends ItemBlockWithMetadata {

	public ItemBlockModLeaves(Block block) {
		
		super(block, block);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		
		return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}
}
