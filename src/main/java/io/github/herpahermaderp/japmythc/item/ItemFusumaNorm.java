package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.block.ModBlocks;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemFusumaNorm extends ItemDoor {

	public ItemFusumaNorm(String unlocalizedName, Material material) {
		
		super(material);
		setUnlocalizedName(unlocalizedName);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int posX, int posY, int posZ, int side, float motionX, float motionY, float motionZ) {
		
		if(side != 1) {
			
			return false;
		}
		
		else {
			
			++posY;
			Block block = ModBlocks.fusuma;
			
			if(player.canPlayerEdit(posX, posY, posZ, side, stack) && player.canPlayerEdit(posX, posY + 1, posZ, side, stack)) {
				
				if(!block.canPlaceBlockAt(world, posX, posY, posZ)) {
					
					return false;
				}
				
				else {
					
					int i1 = MathHelper.floor_double((player.rotationYaw + 180.0F) * 4.0F / 360.0F - 0.5D) & 3;
					placeDoorBlock(world, posX, posY, posZ, i1, block);
					--stack.stackSize;
					return true;
				}
			}
			
			else {
				
				return false;
			}
		}
	}
}
