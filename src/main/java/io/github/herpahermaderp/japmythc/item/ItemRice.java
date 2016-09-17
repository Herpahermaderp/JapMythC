package io.github.herpahermaderp.japmythc.item;

import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemRice extends ItemSeeds implements IPlantable {

	private final Block theBlockPlant;
	
	public ItemRice(String unlocalizedName, Block blockPlant, Block isSoil) {
		
		super(blockPlant, isSoil);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CustomCreativeTabs.tab);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
		theBlockPlant = blockPlant;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int parX, int parY, int parZ, int par7, float par8, float par9, float par10) {
		
		if(par7 != 1) {
			
			return false;
		}
		
		else if(player.canPlayerEdit(parX, parY + 1, parZ, par7, stack)) {
				
			if(world.getBlock(parX, parY, parZ).canSustainPlant(world, parX, parY, parZ, ForgeDirection.UP, this) && world.isAirBlock(parX, parY + 1, parZ)) {
				
				world.setBlock(parX, parY + 1, parZ, theBlockPlant);
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
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {

		return EnumPlantType.Crop;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {

		return theBlockPlant;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {

		return 0;
	}
}
