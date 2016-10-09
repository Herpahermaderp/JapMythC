package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.block.BlockTatami;
import io.github.herpahermaderp.japmythc.block.ModBlocks;
import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemTatami extends Item {

	public ItemTatami(String unlocalizedName) {
		
		super();
		setUnlocalizedName(unlocalizedName);
		setTextureName(Reference.ID + ":" + unlocalizedName);
		setCreativeTab(CustomCreativeTabs.tab);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float movX, float movY, float movZ) {
		
        if (world.isRemote) {
        	
            return true;
        }
        
        else if (meta != 1) {
        	
            return false;
        }
        
        else {
        	
            ++y;
            BlockTatami blockbed = (BlockTatami)ModBlocks.tatami;
            int i1 = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            byte b0 = 0;
            byte b1 = 0;

            if (i1 == 0) {
            	
                b1 = 1;
            }

            if (i1 == 1) {
            	
                b0 = -1;
            }

            if (i1 == 2) {
            	
                b1 = -1;
            }

            if (i1 == 3) {
            	
                b0 = 1;
            }

            if (player.canPlayerEdit(x, y, z, meta, stack) && player.canPlayerEdit(x + b0, y, z + b1, meta, stack)) {
            	
                if (world.isAirBlock(x, y, z) && world.isAirBlock(x + b0, y, z + b1) && World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && World.doesBlockHaveSolidTopSurface(world, x + b0, y - 1, z + b1)) {
                	
                    world.setBlock(x, y, z, blockbed, i1, 3);

                    if (world.getBlock(x, y, z) == blockbed) {
                    	
                        world.setBlock(x + b0, y, z + b1, blockbed, i1 + 8, 3);
                    }

                    --stack.stackSize;
                    return true;
                }
                
                else {
                	
                    return false;
                }
            }
            
            else {
            	
                return false;
            }
        }
    }
}
