package io.github.herpahermaderp.japmythc.item;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.herpahermaderp.japmythc.block.ModBlocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes {

	public static void init() {
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.bamboo), new Object[] {"##", "##", '#', ModItems.bamboo});
		GameRegistry.addRecipe(new ItemStack(ModItems.cucumberSeeds, 4), new Object[] {"#", '#', ModItems.cucumber});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.hitobashira), new Object[] {"#$#", "$#$", "#$#", '#', Items.rotten_flesh, '$', Items.bone});
		GameRegistry.addRecipe(new ItemStack(ModItems.katana), new Object[] {"#", "#", "$", '#', ModItems.katanaBladePiece, '$', ModItems.tsuka});
		GameRegistry.addRecipe(new ItemStack(ModItems.kunai), new Object[] {"#", "$", '#', Items.iron_ingot, '$', Items.stick});
		GameRegistry.addRecipe(new ItemStack(ModItems.shuriken), new Object[] {" # ", "# #", " # ", '#', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(Items.stick), new Object[] {"#", "#", '#', new ItemStack(ModBlocks.woods, 0)});
		GameRegistry.addRecipe(new ItemStack(Items.stick), new Object[] {"#", "#", '#', new ItemStack(ModBlocks.woods, 1)});
		GameRegistry.addRecipe(new ItemStack(ModItems.washi), new Object[] {"###", '#', ModItems.rice});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.woods, 4, 0), new Object[] {"#", '#', new ItemStack(ModBlocks.jubokkoLog)});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.woods, 4, 1), new Object[] {"#", '#', new ItemStack(ModBlocks.sakuraLog)});
	}
}
