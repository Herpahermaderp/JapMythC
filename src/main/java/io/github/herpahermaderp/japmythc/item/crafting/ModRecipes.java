package io.github.herpahermaderp.japmythc.item.crafting;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.herpahermaderp.japmythc.block.ModBlocks;
import io.github.herpahermaderp.japmythc.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes {

	public static void init() {
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.bamboo), new Object[] {"##", "##", '#', ModItems.bamboo});
		GameRegistry.addRecipe(new ItemStack(ModItems.charm, 1, 0), new Object[] {"###", "#$#", "###", '#', Items.stick, '$', ModItems.spiritCore});
		GameRegistry.addRecipe(new ItemStack(ModItems.cucumberSeeds, 4), new Object[] {"#", '#', ModItems.cucumber});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.hitobashira), new Object[] {"#$#", "$#$", "#$#", '#', Items.rotten_flesh, '$', Items.bone});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.ironSand), new Object[] {"#$#", "$%$", "#$#", '#', Items.iron_ingot, '$', Blocks.sand, '%', Blocks.iron_block});
		GameRegistry.addRecipe(new ItemStack(ModItems.jo), new Object[] {"#", "$", "#", '#', Items.stick, '$', ModItems.samagewa});
		GameRegistry.addRecipe(new ItemStack(ModItems.kappaMaki), new Object[] {"#$#", "$%$", "#$#", '#', ModItems.seaweed, '$', ModItems.rice, '%', ModItems.cucumber});
		GameRegistry.addRecipe(new ItemStack(ModItems.katana), new Object[] {"#", "#", "$", '#', ModItems.katanaBladePiece, '$', ModItems.tsuka});
		GameRegistry.addRecipe(new ItemStack(ModItems.katanaBladePiece), new Object[] {"#", "$", "#", '#', ModItems.tamahaganeIngot, '$', ModItems.hochotetsuIngot});
		GameRegistry.addRecipe(new ItemStack(ModItems.kunai), new Object[] {"#", "$", '#', ModItems.tamahaganeIngot, '$', Items.stick});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.paperWallSolid, 1, 0), new Object[] {"#$#", "#$#", "#$#", '#', ModItems.bamboo, '$', ModItems.washi});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.paperWallSolid, 1, 1), new Object[] {"#$#", "###", "#$#", '#', ModItems.bamboo, '$', ModItems.washi});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.paperWallSolid, 1, 2), new Object[] {"###", "#$#", "###", '#', ModItems.bamboo, '$', ModItems.washi});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.paperWallSolid, 1, 3), new Object[] {"$#$", "###", "$#$", '#', ModItems.bamboo, '$', ModItems.washi});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.paperWallSolid, 1, 4), new Object[] {"#$#", "$$$", "#$#", '#', ModItems.bamboo, '$', ModItems.washi});
		GameRegistry.addRecipe(new ItemStack(ModItems.pocky), new Object[] {"#", "$", "$", '#', new ItemStack(Items.dye, 3), '$', Items.wheat});
		GameRegistry.addRecipe(new ItemStack(ModItems.shinai), new Object[] {"#", "#", "$", '#', ModItems.bamboo, '$', ModItems.tsuka});
		GameRegistry.addRecipe(new ItemStack(ModItems.shuriken), new Object[] {" # ", "# #", " # ", '#', ModItems.tamahaganeIngot});
		GameRegistry.addRecipe(new ItemStack(ModItems.soySauce), new Object[] {"#", "#", "$", '#', ModItems.soyBean, '$', Items.water_bucket});
		GameRegistry.addRecipe(new ItemStack(ModItems.spiritCore), new Object[] {"###", "#$#", "###", '#', ModItems.spiritFlame, '$', ModItems.yamajijiiEye});
		GameRegistry.addRecipe(new ItemStack(Items.stick, 4), new Object[] {"#", "#", '#', ModBlocks.woods});
		GameRegistry.addRecipe(new ItemStack(ModItems.tatami), new Object[] {"###", "$$$", "###", '#', ModItems.rice, '$', Blocks.wool});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tatara), new Object[] {"# #", "#$#", "$#$", '#', Blocks.hardened_clay, '$', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(ModItems.teaCup), new Object[] {"# #", " # ", '#', ModItems.bamboo});
		GameRegistry.addRecipe(new ItemStack(ModItems.tsuka), new Object[] {"#$#", "#$#", "#$#", '#', ModItems.samagewa, '$', ModBlocks.woods});
		GameRegistry.addRecipe(new ItemStack(ModItems.tsuka), new Object[] {"#$#", "#$#", "#$#", '#', ModItems.samagewa, '$', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(ModItems.washi), new Object[] {"###", '#', ModItems.rice});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.woods, 4, 0), new Object[] {"#", '#', ModBlocks.jubokkoLog});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.woods, 4, 1), new Object[] {"#", '#', ModBlocks.sakuraLog});
	}
}
