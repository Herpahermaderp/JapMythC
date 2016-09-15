package io.github.herpahermaderp.japmythc.block;

import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class BlockIronSand extends BlockFalling {

	public BlockIronSand(String unlocalizedName, Material material) {
		
		super(material);
		setBlockName(unlocalizedName);
		setBlockTextureName(Reference.ID + ":" + unlocalizedName);
		setCreativeTab(CustomCreativeTabs.tab);
		setHarvestLevel("shovel", 1);
	}
}
