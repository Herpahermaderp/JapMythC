package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.block.ModBlocks;
import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.init.Blocks;

public class ItemCucumberSeeds extends ItemBaseSeeds {

	public ItemCucumberSeeds(String unlocalizedName) {
		
		super(ModBlocks.cucumberPlant, Blocks.farmland);
		setUnlocalizedName(unlocalizedName);
		setTextureName(Reference.ID + ":" + unlocalizedName);
		setCreativeTab(CustomCreativeTabs.tab);
	}
}
