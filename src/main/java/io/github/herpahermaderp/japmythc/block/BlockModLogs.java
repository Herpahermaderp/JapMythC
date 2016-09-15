package io.github.herpahermaderp.japmythc.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockModLogs extends BlockRotatedPillar {

	public static final String[] types = { "jubokko", "sakura" };
	@SideOnly(Side.CLIENT)
	private IIcon[] iconSide;
	@SideOnly(Side.CLIENT)
	private IIcon[] iconTop;
	
	protected BlockModLogs(String unlocalizedName, Material material) {
		
		super(material);
		setBlockName(unlocalizedName);
		setBlockTextureName(Reference.ID + ":" + unlocalizedName);
		setCreativeTab(CustomCreativeTabs.tab);
		setHardness(2.0F);
		setResistance(10.0F);
		setStepSound(soundTypeWood);
	}
	
	@Override
	public int damageDropped(int meta) {
		
		return meta;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
	}
		
	@SideOnly(Side.CLIENT)
	@Override
	protected IIcon getSideIcon(int meta) {
		
		return iconSide[meta];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	protected IIcon getTopIcon(int meta) {
		
		return iconTop[meta];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister register) {
		
		iconSide = new IIcon[types.length];
		iconTop = new IIcon[types.length];
		
		for(int i = 0; i < iconSide.length; ++i) {
			
			iconSide[i] = register.registerIcon(this.getTextureName() + "_" + types[i]);
		}
		
		for(int i = 0; i < iconTop.length; ++i) {
			
			iconTop[i] = register.registerIcon(Reference.ID + ":" + types[i] + "_logTop");
		}
	}
}
