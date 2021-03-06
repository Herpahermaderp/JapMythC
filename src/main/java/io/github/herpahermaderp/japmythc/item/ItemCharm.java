package io.github.herpahermaderp.japmythc.item;

import java.util.List;

import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemCharm extends Item {

	public IIcon[] icons = new IIcon[5];
	
	public ItemCharm(String unlocalizedName) {
		
		super();
		this.setHasSubtypes(true);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CustomCreativeTabs.tab);
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
		
		for (int i = 0; i < 4; i ++) {
			
			this.icons[i] = reg.registerIcon(Reference.ID + ":" + "charm_" + i);
		}
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
		
		if(meta > 3) {
			
			meta = 0;
		}
		
		return this.icons[meta];
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		
		for(int i = 0; i < 4; i ++) {
			
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		
		return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}
}
