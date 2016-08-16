package io.github.herpahermaderp.japmythc.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static Item charm;
	public static ItemSword tenguFan;
	
	public static ToolMaterial FANBLOOM = EnumHelper.addToolMaterial("Fan_bloom", 0, 131, 0, 0, 0);
	public static ToolMaterial FANTENGU = EnumHelper.addToolMaterial("fan_tengu", 0, 131, 0, 3.0F, 10);
	public static ToolMaterial FANWIND = EnumHelper.addToolMaterial("fan_wind", 0, 131, 0, 0, 0);
	
	public static final void init() {
		
		GameRegistry.registerItem(charm = new ItemCharm("charm"), "charm");
		GameRegistry.registerItem(tenguFan = new ItemTenguFan("tengu_fan", FANTENGU), "tengu_fan");
	}
}
