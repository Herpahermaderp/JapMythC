package io.github.herpahermaderp.japmythc.block;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import io.github.herpahermaderp.japmythc.block.descriptor.FusumaNormDescriptor;
import io.github.herpahermaderp.japmythc.block.descriptor.FusumaSakuraManDescriptor;
import io.github.herpahermaderp.japmythc.block.descriptor.FusumaSakuraRiverDescriptor;
import io.github.herpahermaderp.japmythc.item.ItemBlockModLeaves;
import io.github.herpahermaderp.japmythc.item.ItemBlockModSaplings;
import io.github.herpahermaderp.japmythc.item.ItemBlockModWoods;
import io.github.herpahermaderp.japmythc.item.ItemBlockPaperWallPane;
import io.github.herpahermaderp.japmythc.item.ItemBlockPaperWallSolid;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static Block bamboo;
	public static Block cucumberPlant;
	public static Block fusuma;
	public static Block fusumaSM;
	public static Block fusumaSR;
	public static Block hitobashira;
	public static Block ironSand;
	public static Block jubokkoLog;
	public static Block jubokkoSapling;
	public static Block kara;
	public static Block leaves;
	public static Block paperWallPane;
	public static Block paperWallSolid;
	public static Block ricePlant;
	public static Block sakuraLog;
	public static Block sakuraSapling;
	public static Block soyPlant;
	public static Block tatami;
	public static Block tatara;
	public static Block tatara_lit;
	public static Block wasabiPlant;
	public static Block woods;
	
	public static final void init() {
		
		GameRegistry.registerBlock(bamboo = new BlockBamboo("bamboo_block", Material.wood), "bamboo_block");
		GameRegistry.registerBlock(cucumberPlant = new BlockCucumberPlant("cucumber_plant"), "cucumber_plant");
		GameRegistry.registerBlock(hitobashira = new BlockHitobashira("hitobashira", Material.rock), "hitobashira");
		GameRegistry.registerBlock(ironSand = new BlockIronSand("iron_sand", Material.iron), "iron_sand");
		GameRegistry.registerBlock(jubokkoLog = new BlockJubokkoLog("jubokko", Material.wood), "jubokko");
		GameRegistry.registerBlock(jubokkoSapling = new BlockJubokkoSapling("sapling_jubokko", Material.plants), ItemBlockModSaplings.class, "sapling_jubokko");
		GameRegistry.registerBlock(kara = new BlockKara("kara", Material.iron), "kara");
		GameRegistry.registerBlock(leaves = new BlockModLeaves("leaves", Material.leaves), ItemBlockModLeaves.class, "leaves");
		GameRegistry.registerBlock(paperWallPane = new BlockPaperWallPane("paper_wall_pane", "paper_wall_pane_side", Material.glass, false), ItemBlockPaperWallPane.class, "paper_wall_pane");
		GameRegistry.registerBlock(paperWallSolid = new BlockPaperWallSolid("paper_wall_solid", Material.wood), ItemBlockPaperWallSolid.class, "paper_wall_solid");
		GameRegistry.registerBlock(ricePlant = new BlockRicePlant("rice_plant"), "rice_plant");
		GameRegistry.registerBlock(sakuraLog = new BlockSakuraLog("sakura", Material.wood), "sakura");
		GameRegistry.registerBlock(sakuraSapling = new BlockSakuraSapling("sapling_sakura", Material.plants), ItemBlockModSaplings.class, "sapling_sakura");
		GameRegistry.registerBlock(soyPlant = new BlockSoyPlant("soy_plant"), "soy_plant");
		GameRegistry.registerBlock(tatami = new BlockTatami("tatami", Material.cloth), "tatami");
		GameRegistry.registerBlock(tatara = new BlockTatara("tatara", Material.rock, false), "tatara");
		GameRegistry.registerBlock(tatara_lit = new BlockTatara("tatara_active", Material.rock, true), "tatara_active");
		GameRegistry.registerBlock(wasabiPlant = new BlockWasabiPlant("wasabi_plant"), "wasabi_plant");
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
