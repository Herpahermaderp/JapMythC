package io.github.herpahermaderp.japmythc.block;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import io.github.herpahermaderp.japmythc.block.descriptor.FusumaNormDescriptor;
import io.github.herpahermaderp.japmythc.block.descriptor.FusumaSakuraManDescriptor;
import io.github.herpahermaderp.japmythc.block.descriptor.FusumaSakuraRiverDescriptor;
import io.github.herpahermaderp.japmythc.item.ItemBlockModLeaves;
import io.github.herpahermaderp.japmythc.item.ItemBlockModLogs;
import io.github.herpahermaderp.japmythc.item.ItemBlockModSaplings;
import io.github.herpahermaderp.japmythc.item.ItemBlockModWoods;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static Block bamboo;
	public static Block fusuma;
	public static Block fusumaSM;
	public static Block fusumaSR;
	public static Block hitobashira;
	public static Block ironSand;
	public static Block jubokkoSapling;
	public static Block logs;
	public static Block leaves;
	public static Block sakuraSapling;
	public static Block woods;
	public static Block ricePlant;
	
	public static final void init() {
		
		GameRegistry.registerBlock(bamboo = new BlockBamboo("bamboo_block", Material.wood), "bamboo_block");
		GameRegistry.registerBlock(hitobashira = new BlockHitobashira("hitobashira", Material.rock), "hitobashira");
		GameRegistry.registerBlock(ironSand = new BlockIronSand("iron_sand_block", Material.iron), "iron_sand_block");
		GameRegistry.registerBlock(jubokkoSapling = new BlockJubokkoSapling("sapling_jubokko", Material.plants), ItemBlockModSaplings.class, "sapling_jubokko");
		GameRegistry.registerBlock(leaves = new BlockModLeaves("leaves", Material.leaves), ItemBlockModLeaves.class, "leaves");
		GameRegistry.registerBlock(logs = new BlockModLogs("log", Material.wood), ItemBlockModLogs.class, "log");
		GameRegistry.registerBlock(ricePlant = new BlockRicePlant("rice_plant"), "rice_plant");
		GameRegistry.registerBlock(sakuraSapling = new BlockSakuraSapling("sapling_sakura", Material.plants), ItemBlockModSaplings.class, "sapling_sakura");
		GameRegistry.registerBlock(woods = new BlockModWoods("planks", Material.wood), ItemBlockModWoods.class, "planks");
		
		if(Loader.isModLoaded("malisisdoors")) {
			
			FusumaNormDescriptor fusumaNorm = new FusumaNormDescriptor("fusuma");
			FusumaSakuraManDescriptor fusumaSakuraMan = new FusumaSakuraManDescriptor("fusuma_sm");
			FusumaSakuraRiverDescriptor fusumaSakuraRiver = new FusumaSakuraRiverDescriptor("fusuma_sr");
			fusumaNorm.register();
			fusumaSakuraMan.register();
			fusumaSakuraRiver.register();
			fusuma = fusumaNorm.getBlock();
			fusumaSM = fusumaSakuraMan.getBlock();
			fusumaSR = fusumaSakuraRiver.getBlock();
		}
		
		else {

			GameRegistry.registerBlock(fusuma = new BlockFusumaNorm("fusuma", Material.wood), "fusuma");
			GameRegistry.registerBlock(fusumaSM = new BlockFusumaSakuraMan("fusuma_sm", Material.wood), "fusuma_sm");
			GameRegistry.registerBlock(fusumaSR = new BlockFusumaSakuraRiver("fusuma_sr", Material.wood), "fusuma_sr");
		}
	}
}
