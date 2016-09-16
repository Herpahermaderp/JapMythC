package io.github.herpahermaderp.japmythc.world.gen.feature;

import java.util.Random;

import io.github.herpahermaderp.japmythc.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;

public class WorldGenJubokkoTree extends WorldGenerator {

	private final int minTreeHeight;
	private final int metaWood;
	private final int metaLeaves;
	
	public WorldGenJubokkoTree(boolean par1) {
		
		this(par1, 4, 0, 0);
	}
	
	public WorldGenJubokkoTree(boolean par1, int par2, int par3, int par4) {
		
		super(par1);
		this.minTreeHeight = par2;
		this.metaWood = par3;
		this.metaLeaves = par4;
	}
	
	public boolean generate(World world, Random rand, int par3, int par4, int par5)
    {
        int l = rand.nextInt(4) + this.minTreeHeight;
        int i1 = 1 + rand.nextInt(2);
        int j1 = l - i1;
        int k1 = 2 + rand.nextInt(2);
        boolean flag = true;

        if (par4 >= 1 && par4 + l + 1 <= 256)
        {
            int i2;
            int l3;

            for (int l1 = par4; l1 <= par4 + 1 + l && flag; ++l1)
            {
                boolean flag1 = true;

                if (l1 - par4 < i1)
                {
                    l3 = 0;
                }
                else
                {
                    l3 = k1;
                }

                for (i2 = par3 - l3; i2 <= par3 + l3 && flag; ++i2)
                {
                    for (int j2 = par5 - l3; j2 <= par5 + l3 && flag; ++j2)
                    {
                        if (l1 >= 0 && l1 < 256)
                        {
                            Block block = world.getBlock(i2, l1, j2);

                            if (!block.isAir(world, i2, l1, j2) && !block.isLeaves(world, i2, l1, j2))
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
                Block block1 = world.getBlock(par3, par4 - 1, par5);
                boolean isSoil = block1.canSustainPlant(world, par3, par4 - 1, par5, ForgeDirection.UP, (BlockSapling)Blocks.sapling);
                
                if (isSoil && par4 < 256 - l - 1)
                {
                    block1.onPlantGrow(world, par3, par4 - 1, par5, par3, par4, par5);
                    l3 = rand.nextInt(2);
                    i2 = 1;
                    byte b0 = 0;
                    int k2;
                    int i4;

                    for (i4 = 0; i4 <= j1; ++i4)
                    {
                        k2 = par4 + l - i4;

                        for (int l2 = par3 - l3; l2 <= par3 + l3; ++l2)
                        {
                            int i3 = l2 - par3;

                            for (int j3 = par5 - l3; j3 <= par5 + l3; ++j3)
                            {
                                int k3 = j3 - par5;

                                if ((Math.abs(i3) != l3 || Math.abs(k3) != l3 || l3 <= 0) && world.getBlock(l2, k2, j3).canBeReplacedByLeaves(world, l2, k2, j3))
                                {
                                    this.setBlockAndNotifyAdequately(world, l2, k2, j3, ModBlocks.leaves, this.metaLeaves);
                                }
                            }
                        }

                        if (l3 >= i2)
                        {
                            l3 = b0;
                            b0 = 1;
                            ++i2;

                            if (i2 > k1)
                            {
                                i2 = k1;
                            }
                        }
                        else
                        {
                            ++l3;
                        }
                    }

                    i4 = rand.nextInt(3);

                    for (k2 = 0; k2 < l - i4; ++k2)
                    {
                        Block block2 = world.getBlock(par3, par4 + k2, par5);

                        if (block2.isAir(world, par3, par4 + k2, par5) || block2.isLeaves(world, par3, par4 + k2, par5))
                        {
                            this.setBlockAndNotifyAdequately(world, par3, par4 + k2, par5, ModBlocks.logs, this.metaWood);
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
}
