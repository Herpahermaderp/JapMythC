package io.github.herpahermaderp.japmythc.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class ModRecipes {

	public static void init() {
		
		GameRegistry.addRecipe(new ItemStack(ModItems.katana), new Object[] {"#", "#", "$", '#', ModItems.katanaBladePiece, '$', ModItems.tsuka});
	}
}
