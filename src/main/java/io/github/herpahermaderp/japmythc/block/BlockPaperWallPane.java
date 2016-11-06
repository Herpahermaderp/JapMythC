package io.github.herpahermaderp.japmythc.block;

import java.util.List;

import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockPaperWallPane extends BlockPane {

	IIcon[] frontIcon = new IIcon[5];
	IIcon sideIcon;
	public String front;
	public String side;
	
	protected BlockPaperWallPane(String unlocalizedName, String par2, Material material, boolean par4) {
		
		super(unlocalizedName, par2, material, par4);
		this.setBlockName(unlocalizedName);
		this.front = unlocalizedName;
		this.side = par2;
		this.setBlockTextureName(Reference.ID + ":" + unlocalizedName);
		this.setCreativeTab(CustomCreativeTabs.tab);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		
		for(int i = 0; i < 5; ++i) {
			
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		
		if(meta > 5) {
			
			meta = 0;
		}
		
		return frontIcon[meta];
	}
	
	@Override
	public void registerBlockIcons(IIconRegister reg) {
		
		for(int i = 0; i < 5; ++i) {
			
			this.frontIcon[i] = reg.registerIcon(Reference.ID + ":paper_wall_solid_" + i);
			this.sideIcon = reg.registerIcon(Reference.ID + ":fusuma_side");
		}
	}
}
