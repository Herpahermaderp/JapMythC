package io.github.herpahermaderp.japmythc.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {

	public static Item charm;
	
	public static final void init() {
		
		GameRegistry.registerItem(charm = new ItemCharm("charm"), "charm");
	}
}
