package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.item.Item;

public class ItemTamahaganeIngot extends Item {

	public ItemTamahaganeIngot(String unlocalizedName) {
		
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
		this.setCreativeTab(CustomCreativeTabs.tab);
	}
}
