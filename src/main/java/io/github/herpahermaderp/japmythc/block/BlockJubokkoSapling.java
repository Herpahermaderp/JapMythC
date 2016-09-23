package io.github.herpahermaderp.japmythc.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import io.github.herpahermaderp.japmythc.world.gen.feature.WorldGenJubokkoTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockJubokkoSapling extends BlockBush implements IGrowable {

protected BlockJubokkoSapling(String unlocalizedName, Material material) {
		
		setBlockName(unlocalizedName);
		setBlockTextureName(Reference.ID + ":" + unlocalizedName);
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		setCreativeTab(CustomCreativeTabs.tab);
	}
	
	public void updateTick(World world, int par2, int par3, int par4, Random rand) {
        
		if (!world.isRemote) {
			
            super.updateTick(world, par2, par3, par4, rand);

            if (world.getBlockLightValue(par2, par3 + 1, par4) >= 9 && rand.nextInt(7) == 0) {
            	
                this.func_149879_c(world, par2, par3, par4, rand);
            }
        }
    }
	
	@SideOnly(Side.CLIENT)
	public void func_149879_c(World world, int par2, int par3, int par4, Random rand) {
		
        int l = world.getBlockMetadata(par2, par3, par4);

        if ((l & 8) == 0) {
        	
            world.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
        }
        
        else {
            
        	this.growTree(world, par2, par3, par4, rand);
        }
    }
	
	public void growTree(World world, int par2, int par3, int par4, Random rand) {
        
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, rand, par2, par3, par4)) {
			
			return;
		}
        
		int l = world.getBlockMetadata(par2, par3, par4) & 3;
		Object object = rand.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);

		int i1 = 0;
		int j1 = 0;
		boolean flag = false;

        if (!flag) {
                    
        	j1 = 0;
        	i1 = 0;
        	object = new WorldGenJubokkoTree(true);    
        }

        Block block = Blocks.air;

        if (flag) {
            
        	world.setBlock(par2 + i1, par3, par4 + j1, block, 0, 4);
        	world.setBlock(par2 + i1 + 1, par3, par4 + j1, block, 0, 4);
        	world.setBlock(par2 + i1, par3, par4 + j1 + 1, block, 0, 4);
        	world.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, block, 0, 4);
        }
        
       	else {
            
        	world.setBlock(par2, par3, par4, block, 0, 4);
        }

        if (!((WorldGenerator)object).generate(world, rand, par2 + i1, par3, par4 + j1)) {
            
        	if (flag) {
                
        		world.setBlock(par2 + i1, par3, par4 + j1, this, l, 4);
        		world.setBlock(par2 + i1 + 1, par3, par4 + j1, this, l, 4);
        		world.setBlock(par2 + i1, par3, par4 + j1 + 1, this, l, 4);
        		world.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this, l, 4);
        	}
            
        	else {
                
        		world.setBlock(par2, par3, par4, this, l, 4);
        	}
        }
    }
	
	public boolean isSameSapling(World world, int blockPosX, int blockPosY, int blockPosZ, int par5) {
        
		return world.getBlock(blockPosX, blockPosY, blockPosZ) == this && (world.getBlockMetadata(blockPosX, blockPosY, blockPosZ) & 7) == par5;
    }
	@Override
	public boolean func_149851_a(World world, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
		
		return true;
	}

	@Override
	public boolean func_149852_a(World world, Random rand, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
		
		return (double)world.rand.nextFloat() < 0.45D;
	}

	@Override
	public void func_149853_b(World world, Random rand, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
	
		this.func_149879_c(world, p_149853_3_, p_149853_4_, p_149853_5_, rand);
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block block) {
		
		if(block == Blocks.netherrack) {
			
			return true;
		}

		return false;
	}
	
	@Override
	public boolean canBlockStay(World world, int posX, int posY, int posZ) {
		
		if(world.getBlock(posX, posY - 1, posZ) == Blocks.netherrack) {
			
			return true;
		}
		
		return false;
	}
}
