package io.github.herpahermaderp.japmythc.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockModCrops extends BlockBush implements IGrowable {

	protected int maxGrowthStage = 7;
	
	@SideOnly(Side.CLIENT)
	protected IIcon[] icon;
	
	public BlockModCrops() {
		
		setTickRandomly(true);
		float f = 0.5F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		setCreativeTab((CreativeTabs)null);
		setHardness(0.0F);
		setStepSound(soundTypeGrass);
		disableStats();
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block block) {
		
		return block == Blocks.farmland;
	}
	
	public void incrementGrowStage(World world, Random rand, int parX, int parY, int parZ) {
		
		int growStage = world.getBlockMetadata(parX, parY, parZ) + MathHelper.getRandomIntegerInRange(rand, 2, 5);
		
		if(growStage > maxGrowthStage) {
			
			growStage = maxGrowthStage;
		}
		
		world.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
	}
	
	@Override
	public Item getItemDropped(int par1, Random rand, int fortune) {
		
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public int getRenderType() {
		
		return 1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int growthStage) {
		
		return icon[growthStage];
	}
	
	@Override
	public boolean func_149851_a(World world, int parX, int parY, int parZ, boolean par5) {
		
		return world.getBlockMetadata(parX, parY, parZ) != 7;
	}
	
	@Override
	public boolean func_149852_a(World world, Random rand, int par3, int par4, int par5) {
		
		return true;
	}
	
	@Override
	public void func_149853_b(World world, Random rand, int parX, int parY, int parZ) {
		
		incrementGrowStage(world, rand, parX, parY, parZ);
	}
	
	@Override
	public void updateTick(World world, int parX, int parY, int parZ, Random rand) {
		
		super.updateTick(world, parX, parY, parZ, rand);
		int growStage = world.getBlockMetadata(parX, parY, parZ) + 1;
		
		if(growStage > maxGrowthStage) {
			
			growStage = maxGrowthStage;
		}
		
		world.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
	}
}
