package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.item.Item;

public class ItemKunai extends Item {

	public ItemKunai(String unlocalizedName) {
		
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CustomCreativeTabs.tab);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
	}
}
