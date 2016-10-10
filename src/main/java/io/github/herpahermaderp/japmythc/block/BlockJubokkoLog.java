package io.github.herpahermaderp.japmythc.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockJubokkoLog extends BlockRotatedPillar {

	@SideOnly(Side.CLIENT)
	private IIcon iconSide;
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	
	public BlockJubokkoLog(String unlocalizedName, Material material) {
		
		super(material);
		setBlockName(unlocalizedName);
		setBlockTextureName(Reference.ID + ":" + unlocalizedName);
		setCreativeTab(CustomCreativeTabs.tab);
		setHardness(2.0F);
		setResistance(10.0F);
		setStepSound(soundTypeWood);
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		
		return AxisAlignedBB.getBoundingBox((double)((float)x + 1.0F), (double)y, (double)((float)z + 1.0F), (double)((float)(x + 1) - 1.0F), (double)((float)(y + 1) - 1.0F), (double)((float)(z + 1) - 1.0F));
	}
	
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		
		return AxisAlignedBB.getBoundingBox((double)((float)x + 1.0F), (double)y, (double)((float)z + 1.0F), (double)((float)(x + 1) - 1.0F), (double)(y + 1), (double)((float)(z + 1) - 1.0F));
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
	
	public void onEntityCollidedWithBlock(World world, int posX, int posY, int posZ, Entity entity) {
		
		entity.attackEntityFrom(DamageSource.generic, 1.0F);
	}
}
