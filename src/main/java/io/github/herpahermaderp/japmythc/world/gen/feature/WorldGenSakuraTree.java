package io.github.herpahermaderp.japmythc.world.gen.feature;

import java.util.Random;

import io.github.herpahermaderp.japmythc.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

public class WorldGenSakuraTree extends WorldGenAbstractTree {

	private final int minTreeHeight;
	private final boolean vinesGrow;
	private final int metaWood;
	private final int metaLeaves;
	
	public WorldGenSakuraTree(boolean par1) {
		
		this(par1, 4, 0, 0, false);
	}
	
	public WorldGenSakuraTree(boolean par1, int par2, int par3, int par4, boolean par5) {
		
		super(par1);
		this.minTreeHeight = par2;
		this.metaWood = par3;
		this.metaLeaves = par4;
		this.vinesGrow = par5;
	}
	
	@Override
	public boolean generate(World world, Random rand, int par3, int par4, int par5) {
		
		int l = rand.nextInt(3) + this.minTreeHeight;
        boolean flag = true;

        if (par4 >= 1 && par4 + l + 1 <= 256)
        {
            byte b0;
            int k1;
            Block block;

            for (int i1 = par4; i1 <= par4 + 1 + l; ++i1)
            {
                b0 = 1;

                if (i1 == par4)
                {
                    b0 = 0;
                }

                if (i1 >= par4 + 1 + l - 2)
                {
                    b0 = 2;
                }

                for (int j1 = par3 - b0; j1 <= par3 + b0 && flag; ++j1)
                {
                    for (k1 = par5 - b0; k1 <= par5 + b0 && flag; ++k1)
                    {
                        if (i1 >= 0 && i1 < 256)
                        {
                            block = world.getBlock(j1, i1, k1);

                            if (!this.isReplaceable(world, j1, i1, k1))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                Block block2 = world.getBlock(par3, par4 - 1, par5);

                boolean isSoil = block2.canSustainPlant(world, par3, par4 - 1, par5, ForgeDirection.UP, (BlockSapling)Blocks.sapling);
                if (isSoil && par4 < 256 - l - 1)
                {
                    block2.onPlantGrow(world, par3, par4 - 1, par5, par3, par4, par5);
                    b0 = 3;
                    byte b1 = 0;
                    int l1;
                    int i2;
                    int j2;
                    int i3;

                    for (k1 = par4 - b0 + l; k1 <= par4 + l; ++k1)
                    {
                        i3 = k1 - (par4 + l);
                        l1 = b1 + 1 - i3 / 2;

                        for (i2 = par3 - l1; i2 <= par3 + l1; ++i2)
                        {
                            j2 = i2 - par3;

                            for (int k2 = par5 - l1; k2 <= par5 + l1; ++k2)
                            {
                                int l2 = k2 - par5;

                                if (Math.abs(j2) != l1 || Math.abs(l2) != l1 || rand.nextInt(2) != 0 && i3 != 0)
                                {
                                    Block block1 = world.getBlock(i2, k1, k2);

                                    if (block1.isAir(world, i2, k1, k2) || block1.isLeaves(world, i2, k1, k2))
                                    {
                                        this.setBlockAndNotifyAdequately(world, i2, k1, k2, ModBlocks.leaves, this.metaLeaves);
                                    }
                                }
                            }
                        }
                    }

                    for (k1 = 0; k1 < l; ++k1)
                    {
                        block = world.getBlock(par3, par4 + k1, par5);

                        if (block.isAir(world, par3, par4 + k1, par5) || block.isLeaves(world, par3, par4 + k1, par5))
                        {
                            this.setBlockAndNotifyAdequately(world, par3, par4 + k1, par5, ModBlocks.logs, this.metaWood);

                            if (this.vinesGrow && k1 > 0)
                            {
                                if (rand.nextInt(3) > 0 && world.isAirBlock(par3 - 1, par4 + k1, par5))
                                {
                                    this.setBlockAndNotifyAdequately(world, par3 - 1, par4 + k1, par5, Blocks.vine, 8);
                                }

                                if (rand.nextInt(3) > 0 && world.isAirBlock(par3 + 1, par4 + k1, par5))
                                {
                                    this.setBlockAndNotifyAdequately(world, par3 + 1, par4 + k1, par5, Blocks.vine, 2);
                                }

                                if (rand.nextInt(3) > 0 && world.isAirBlock(par3, par4 + k1, par5 - 1))
                                {
                                    this.setBlockAndNotifyAdequately(world, par3, par4 + k1, par5 - 1, Blocks.vine, 1);
                                }

                                if (rand.nextInt(3) > 0 && world.isAirBlock(par3, par4 + k1, par5 + 1))
                                {
                                    this.setBlockAndNotifyAdequately(world, par3, par4 + k1, par5 + 1, Blocks.vine, 4);
                                }
                            }
                        }
                    }

                    if (this.vinesGrow)
                    {
                        for (k1 = par4 - 3 + l; k1 <= par4 + l; ++k1)
                        {
                            i3 = k1 - (par4 + l);
                            l1 = 2 - i3 / 2;

                            for (i2 = par3 - l1; i2 <= par3 + l1; ++i2)
                            {
                                for (j2 = par5 - l1; j2 <= par5 + l1; ++j2)
                                {
                                    if (world.getBlock(i2, k1, j2).isLeaves(world, i2, k1, j2))
                                    {
                                        if (rand.nextInt(4) == 0 && world.getBlock(i2 - 1, k1, j2).isAir(world, i2 - 1, k1, j2))
                                        {
                                            this.growVines(world, i2 - 1, k1, j2, 8);
                                        }

                                        if (rand.nextInt(4) == 0 && world.getBlock(i2 + 1, k1, j2).isAir(world, i2 + 1, k1, j2))
                                        {
                                            this.growVines(world, i2 + 1, k1, j2, 2);
                                        }

                                        if (rand.nextInt(4) == 0 && world.getBlock(i2, k1, j2 - 1).isAir(world, i2, k1, j2 - 1))
                                        {
                                            this.growVines(world, i2, k1, j2 - 1, 1);
                                        }

                                        if (rand.nextInt(4) == 0 && world.getBlock(i2, k1, j2 + 1).isAir(world, i2, k1, j2 + 1))
                                        {
                                            this.growVines(world, i2, k1, j2 + 1, 4);
                                        }
                                    }
                                }
                            }
                        }

                        if (rand.nextInt(5) == 0 && l > 5)
                        {
                            for (k1 = 0; k1 < 2; ++k1)
                            {
                                for (i3 = 0; i3 < 4; ++i3)
                                {
                                    if (rand.nextInt(4 - k1) == 0)
                                    {
                                        l1 = rand.nextInt(3);
                                        this.setBlockAndNotifyAdequately(world, par3 + Direction.offsetX[Direction.rotateOpposite[i3]], par4 + l - 5 + k1, par5 + Direction.offsetZ[Direction.rotateOpposite[i3]], Blocks.cocoa, l1 << 2 | i3);
                                    }
                                }
                            }
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
	}
	
	private void growVines(World world, int par2, int par3, int par4, int par5) {
        
		this.setBlockAndNotifyAdequately(world, par2, par3, par4, Blocks.vine, par5);
        int i1 = 4;

        while (true) {
            
        	--par3;

            if (!world.getBlock(par2, par3, par4).isAir(world, par2, par3, par4) || i1 <= 0) {
            	
                return;
            }

            this.setBlockAndNotifyAdequately(world, par2, par3, par4, Blocks.vine, par5);
            --i1;
        }
    }
}
