package io.github.herpahermaderp.japmythc.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static Item bloomFan;
	public static Item charm;
	public static ItemSword katana;
	public static Item windFan;
	public static ItemSword tenguFan;
	
	public static ToolMaterial KATANA = EnumHelper.addToolMaterial("katana", 0, 250, 0, 3.0F, 10);
	public static ToolMaterial FANTENGU = EnumHelper.addToolMaterial("fan_tengu", 0, 131, 0, 3.0F, 10);
	
	public static final void init() {
		
		GameRegistry.registerItem(bloomFan = new ItemBloomFan("blooming_fan"), "blooming_fan");
		GameRegistry.registerItem(charm = new ItemCharm("charm"), "charm");
		GameRegistry.registerItem(katana = new ItemKatana("katana", KATANA), "katana");
		GameRegistry.registerItem(tenguFan = new ItemTenguFan("tengu_fan", FANTENGU), "tengu_fan");
		GameRegistry.registerItem(windFan = new ItemWindFan("wind_fan"), "wind_fan");
	}
}
