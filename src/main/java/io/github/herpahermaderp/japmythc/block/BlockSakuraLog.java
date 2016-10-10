package io.github.herpahermaderp.japmythc.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockSakuraLog extends BlockRotatedPillar {

	@SideOnly(Side.CLIENT)
	private IIcon iconSide;
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	
	protected BlockSakuraLog(String unlocalizedName, Material material) {
		
		super(material);
		setBlockName(unlocalizedName);
		setBlockTextureName(Reference.ID + ":" + unlocalizedName);
		setCreativeTab(CustomCreativeTabs.tab);
		setHardness(2.0F);
		setResistance(10.0F);
		setStepSound(soundTypeWood);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	protected IIcon getSideIcon(int meta) {
		
		return iconSide;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	protected IIcon getTopIcon(int meta) {
		
		return iconTop;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister register) {
		
		iconSide = register.registerIcon(this.getTextureName() + "_log");
		iconTop = register.registerIcon(this.getTextureName() + "_log_top");
	}
}
