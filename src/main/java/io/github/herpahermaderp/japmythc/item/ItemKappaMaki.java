package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.item.ItemFood;

public class ItemKappaMaki extends ItemFood {

	public ItemKappaMaki(String unlocalizedName, int healAmount, float saturation, boolean par3) {
		
		super(healAmount, saturation, par3);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
		this.setCreativeTab(CustomCreativeTabs.tab);
	}
}
