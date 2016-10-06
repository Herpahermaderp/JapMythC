package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.block.ModBlocks;
import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.init.Blocks;

public class ItemWasabiRoot extends ItemBaseSeeds {

	public ItemWasabiRoot(String unlocalizedName) {
		
		super(ModBlocks.wasabiPlant, Blocks.farmland);
		setUnlocalizedName(unlocalizedName);
		setTextureName(Reference.ID + ":" + unlocalizedName);
		setCreativeTab(CustomCreativeTabs.tab);
	}
}
