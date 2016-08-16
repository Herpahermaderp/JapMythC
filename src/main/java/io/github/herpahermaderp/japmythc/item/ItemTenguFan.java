package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.item.ItemSword;

public class ItemTenguFan extends ItemSword {
	
	public ItemTenguFan(String unlocalizedName, ToolMaterial material) {
		
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
	}
	
	
}
