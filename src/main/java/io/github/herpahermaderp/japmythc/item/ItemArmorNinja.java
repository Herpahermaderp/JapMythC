package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorNinja extends ItemArmor {

	public String textureName;
	
	public ItemArmorNinja(String unlocalizedName, ArmorMaterial material, String textureName, int type) {
		
		super(material, 0, type);
		this.textureName = textureName;
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		
		return Reference.ID + ":textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
}
