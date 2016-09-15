package io.github.herpahermaderp.japmythc.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockModWoods extends Block {

	public static final String[] types = { "jubokko", "sakura" };
	IIcon[] icon = new IIcon[2];
	
	public BlockModWoods(String unlocalizedName, Material material) {
		
		super(material);
		setBlockName(unlocalizedName);
		setBlockTextureName(Reference.ID + ":" + unlocalizedName);
		setCreativeTab(CustomCreativeTabs.tab);
		setStepSound(soundTypeWood);
	}
	
	@Override
	public int damageDropped(int meta) {
		
		return meta;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		
		if(meta > 2) {
			
			meta = 0;
		}
		
		return this.icon[meta];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister register) {
		
		icon = new IIcon[types.length];
		
		for(int i = 0; i < 2; ++i) {
			
			icon[i] = register.registerIcon(this.getTextureName() + "_" + types[i]);
		}
	}
}
