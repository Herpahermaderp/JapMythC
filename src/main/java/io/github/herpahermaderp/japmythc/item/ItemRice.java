package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.block.ModBlocks;
import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.init.Blocks;

public class ItemRice extends ItemBaseSeeds {

	public ItemRice(String unlocalizedName) {
		
		super(ModBlocks.ricePlant, Blocks.farmland);
		setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CustomCreativeTabs.tab);
		setTextureName(Reference.ID + ":" + unlocalizedName);
	}
}
