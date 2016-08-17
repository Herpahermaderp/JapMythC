package io.github.herpahermaderp.japmythc.item;

import cpw.mods.fml.common.eventhandler.Event.Result;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class ItemBloomFan extends Item {

	public ItemBloomFan(String unlocalizedName) {
		
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setMaxStackSize(1);
		this.setMaxDamage(132);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int par1, int par2, int par3, int par4, float f1, float f2, float f3) {
		
		if(!player.canPlayerEdit(par1, par2, par3, par4, stack)) {
			
			return false;
		}
		
		else {
		
			if(ItemBloomFan.applyBonemeal(stack, world, par1, par2, par3, player)) {
		
				stack.damageItem(1, player);
				
				player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
				
				if (!world.isRemote) {
            
					world.playAuxSFX(2005, par1, par2, par3, 0);
				}
			
				return true;
			}
			
			return false;
		}
	}
	
	@Override
	public boolean getIsRepairable(ItemStack par1stack, ItemStack par2stack) {
		
		if(par1stack.getItem().equals(par2stack.getItem())) {
			
			return false;
		}
		
		else if(par2stack.getItem().equals(Items.paper)) {
			
			return true;
		}
		
		else {
			
			return false;
		}
	}
	
	@Override
	public int getMaxDamage(ItemStack stack) {
		
		return 132;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		
        return EnumAction.block;
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
        
		return 5;
    }
	
	@Override
	public boolean isFull3D() {
		
		return true;
	}
	
	public static boolean applyBonemeal(ItemStack stack, World world, int par1, int par2, int par3, EntityPlayer player)
    {
        Block block = world.getBlock(par1, par2, par3);

        BonemealEvent event = new BonemealEvent(player, world, block, par1, par2, par3);
        
        if (MinecraftForge.EVENT_BUS.post(event)) {
            
        	return false;
        }

        if (event.getResult() == Result.ALLOW) {
            
            return true;
        }

        if (block instanceof IGrowable) {
            
        	IGrowable igrowable = (IGrowable)block;

            if (igrowable.func_149851_a(world, par1, par2, par3, world.isRemote)) {
                
            	if (!world.isRemote) {
                    
            		if (igrowable.func_149852_a(world, world.rand, par1, par2, par3)) {
                        
            			igrowable.func_149853_b(world, world.rand, par1, par2, par3);
                    }
                }

                return true;
            }
        }

        return false;
    }
}
