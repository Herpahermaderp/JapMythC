package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTsuka extends Item {

	public ItemTsuka(String unlocalizedName) {
		
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
	}
}