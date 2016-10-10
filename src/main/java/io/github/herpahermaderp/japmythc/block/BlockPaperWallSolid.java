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

public class BlockPaperWallSolid extends Block {

	IIcon[] icon = new IIcon[6];
	
	public BlockPaperWallSolid(String unlocalizedName, Material material) {
		
		super(material);
		setBlockName(unlocalizedName);
		setBlockTextureName(Reference.ID + ":" + unlocalizedName);
		setCreativeTab(CustomCreativeTabs.tab);
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		
		if(meta > 5) {
			
			meta = 0;
		}
		
		return icon[meta];
	}
	
	@Override
	public int damageDropped(int meta) {
		
		return meta;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		
		for(int i = 0; i < 6; ++i) {
			
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		
		for(int i = 0; i < 6; ++i) {
			
			icon[i] = reg.registerIcon(getTextureName() + "_" + i);
		}
	}
}