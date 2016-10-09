package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.item.ItemSword;

public class ItemShinai extends ItemSword {

	public ItemShinai(String unlocalizedName, ToolMaterial material) {
		
		super(material);
		setUnlocalizedName(unlocalizedName);
		setTextureName(Reference.ID + ":" + unlocalizedName);
		setCreativeTab(CustomCreativeTabs.tab);
	}
}
