package io.github.herpahermaderp.japmythc.block;

import java.util.ArrayList;

import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.item.ModItems;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockKara extends Block {
	
	public BlockKara(String unlocalizedName, Material material) {
		
		super(material);
		setBlockName(unlocalizedName);
		setBlockTextureName(Reference.ID + ":" + unlocalizedName);
		setCreativeTab(CustomCreativeTabs.tab);
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
		
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		drops.add(new ItemStack(ModItems.tamahagane, world.rand.nextInt(3) + 2));
		drops.add(new ItemStack(ModItems.hochotetsu, world.rand.nextInt(3) + 2));
		return drops;
	}
}
