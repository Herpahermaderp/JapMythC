package io.github.herpahermaderp.japmythc.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static Item bamboo;
	public static Item bloomFan;
	public static Item charm;
	public static Item katanaBladePiece;
	public static Item kunai;
	public static Item rice;
	public static Item shuriken;
	public static Item spiritFlame;
	public static Item tsuka;
	public static Item windFan;
	
	public static ItemSword flameKatana;
	public static ItemSword jo;
	public static ItemSword katana;
	public static ItemSword spiritFlameKatana;
	public static ItemSword tenguFan;
	
	public static ToolMaterial FANTENGU = EnumHelper.addToolMaterial("fan_tengu", 0, 131, 0, 3.0F, 10);
	public static ToolMaterial FKATANA = EnumHelper.addToolMaterial("fkatana", 0, 250, 0, 6.0F, 10);
	public static ToolMaterial JO = EnumHelper.addToolMaterial("jo", 0, 131, 0, 3.0F, 0);
	public static ToolMaterial KATANA = EnumHelper.addToolMaterial("katana", 0, 250, 0, 3.0F, 10);
	public static ToolMaterial SFKATANA = EnumHelper.addToolMaterial("sfkatana", 0, 250, 0, 11.0F, 10);
	
	public static final void init() {
		
		GameRegistry.registerItem(bamboo = new ItemBamboo("bamboo"), "bamboo");
		GameRegistry.registerItem(bloomFan = new ItemBloomFan("blooming_fan"), "blooming_fan");
		GameRegistry.registerItem(charm = new ItemCharm("charm"), "charm");
		GameRegistry.registerItem(flameKatana = new ItemFlameKatana("katana_fire", FKATANA), "katana_fire");
		GameRegistry.registerItem(jo = new ItemJo("jo", JO), "jo");
		GameRegistry.registerItem(katana = new ItemKatana("katana", KATANA), "katana");
		GameRegistry.registerItem(katanaBladePiece = new ItemKatanaBladePiece("katana_blade_piece"), "katana_blade_piece");
		GameRegistry.registerItem(kunai = new ItemKunai("kunai"), "kunai");
		GameRegistry.registerItem(rice = new ItemRice("rice"), "rice");
		GameRegistry.registerItem(shuriken = new ItemShuriken("shuriken"), "shuriken");
		GameRegistry.registerItem(spiritFlame = new ItemSpiritFlame("spirit_flame"), "spirit_flame");
		GameRegistry.registerItem(spiritFlameKatana = new ItemSpiritFlameKatana("katana_spiritfire", SFKATANA), "katana_spiritfire");
		GameRegistry.registerItem(tenguFan = new ItemTenguFan("tengu_fan", FANTENGU), "tengu_fan");
		GameRegistry.registerItem(tsuka = new ItemTsuka("tsuka"), "tsuka");
		GameRegistry.registerItem(windFan = new ItemWindFan("wind_fan"), "wind_fan");
	}
}
