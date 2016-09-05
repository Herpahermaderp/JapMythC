package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.lib.Reference;

public class ItemSpiritFlameKatana extends ItemKatana {
	
	public ItemSpiritFlameKatana(String unlocalizedName, ToolMaterial material) {
		
		super(unlocalizedName, material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
	}
}
