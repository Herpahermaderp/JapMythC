package io.github.herpahermaderp.japmythc.block;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.herpahermaderp.japmythc.item.ItemBlockModLeaves;
import io.github.herpahermaderp.japmythc.item.ItemBlockModLogs;
import io.github.herpahermaderp.japmythc.item.ItemBlockModSaplings;
import io.github.herpahermaderp.japmythc.item.ItemBlockModWoods;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static Block bamboo;
	public static BlockFalling ironSand;
	public static BlockRotatedPillar logs;
	public static BlockLeavesBase leaves;
	public static BlockBush saplings;
	public static Block woods;
	public static Block hitobashira;
	public static Block ricePlant;
	
	public static final void init() {
		
		GameRegistry.registerBlock(bamboo = new BlockBamboo("bamboo_block", Material.wood), "bamboo_block");
		GameRegistry.registerBlock(hitobashira = new BlockHitobashira("hitobashira", Material.rock), "hitobashira");
		GameRegistry.registerBlock(ironSand = new BlockIronSand("iron_sand_block", Material.iron), "iron_sand_block");
		GameRegistry.registerBlock(leaves = new BlockModLeaves("leaves", Material.leaves), ItemBlockModLeaves.class, "leaves");
		GameRegistry.registerBlock(logs = new BlockModLogs("log", Material.wood), ItemBlockModLogs.class, "log");
		GameRegistry.registerBlock(ricePlant = new BlockRicePlant("rice_plant"), "rice_plant");
		GameRegistry.registerBlock(saplings = new BlockModSaplings("sapling", Material.plants), ItemBlockModSaplings.class, "sapling");
		GameRegistry.registerBlock(woods = new BlockModWoods("planks", Material.wood), ItemBlockModWoods.class, "planks");
	}
}
