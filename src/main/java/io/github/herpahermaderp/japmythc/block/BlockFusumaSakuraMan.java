package io.github.herpahermaderp.japmythc.block;

import java.util.Random;

import io.github.herpahermaderp.japmythc.item.ModItems;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockFusumaSakuraMan extends BlockDoor {

public BlockFusumaSakuraMan(String unlocalizedName, Material material) {
		
		super(material);
		setBlockName(unlocalizedName);
	}
	
	@Override
	public Item getItem(World world, int posX, int posY, int posZ) {
		
		return ModItems.fusumaSM;
	}
	
	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		
		return(meta & 8) !=0 ? null : ModItems.fusumaSM;
	}
}
