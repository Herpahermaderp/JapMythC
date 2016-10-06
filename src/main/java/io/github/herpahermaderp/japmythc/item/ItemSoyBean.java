package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.block.ModBlocks;
import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.init.Blocks;

public class ItemSoyBean extends ItemBaseSeeds {

	public ItemSoyBean(String unlocalizedName) {
		
		super(ModBlocks.soyPlant, Blocks.farmland);
		setUnlocalizedName(unlocalizedName);
		setTextureName(Reference.ID + ":" + unlocalizedName);
		setCreativeTab(CustomCreativeTabs.tab);
	}
}
