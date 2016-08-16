package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemWindFan extends Item {

	public ItemWindFan(String unlocalizedName) {
		
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxStackSize(1);
	}
}
