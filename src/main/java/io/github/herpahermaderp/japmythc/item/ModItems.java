package io.github.herpahermaderp.japmythc.item;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static Item bamboo;
	public static Item bloomFan;
	public static Item charm;
	public static Item cucumber;
	public static Item cucumberSeeds;
	public static Item customEgg;
	public static Item flameKatana;
	public static Item fusuma;
	public static Item fusumaSM;
	public static Item fusumaSR;
	public static Item hochotetsu;
	public static Item hochotetsuIngot;
	public static Item jo;
	public static Item kappaMaki;
	public static Item katana;
	public static Item katanaBladePiece;
	public static Item kimonoHelmet;
	public static Item kimonoChestplate;
	public static Item kimonoLeggings;
	public static Item kimonoBoots;
	public static Item kunai;
	public static Item ninjaHelmet;
	public static Item ninjaChesplate;
	public static Item ninjaLeggings;
	public static Item ninjaBoots;
	public static Item pocky;
	public static Item rice;
	public static Item samagewa;
	public static Item seaweed;
	public static Item shinai;
	public static Item shuriken;
	public static Item soyBean;
	public static Item soySauce;
	public static Item spiritCore;
	public static Item spiritFlame;
	public static Item spiritFlameKatana;
	public static Item tamahagane;
	public static Item tamahaganeIngot;
	public static Item tatami;
	public static Item teaCup;
	public static Item tenguFan;
	public static Item tsuka;
	public static Item wasabiRoot;
	public static Item washi;
	public static Item windFan;
	public static Item yamajijiiEye;
	
	public static ArmorMaterial CLOTH = EnumHelper.addArmorMaterial("cloth", 0, new int[] {0, 0, 0, 0}, 0);
	public static ToolMaterial FANTENGU = EnumHelper.addToolMaterial("fan_tengu", 0, 131, 0, 3.0F, 10);
	public static ToolMaterial FKATANA = EnumHelper.addToolMaterial("fkatana", 0, 250, 0, 6.0F, 10);
	public static ToolMaterial JO = EnumHelper.addToolMaterial("jo", 0, 131, 0, 3.0F, 0);
	public static ToolMaterial KATANA = EnumHelper.addToolMaterial("katana", 0, 250, 0, 3.0F, 10);
	public static ToolMaterial SFKATANA = EnumHelper.addToolMaterial("sfkatana", 0, 250, 0, 11.0F, 10);
	public static ToolMaterial SHINAI = EnumHelper.addToolMaterial("shinai", 0, 131, 0, 3.0F, 0);
	
	public static final void init() {
		
		GameRegistry.registerItem(bamboo = new ItemBamboo("bamboo"), "bamboo");
		GameRegistry.registerItem(bloomFan = new ItemBloomFan("blooming_fan"), "blooming_fan");
		GameRegistry.registerItem(charm = new ItemCharm("charm"), "charm");
		GameRegistry.registerItem(cucumber = new ItemCucumber("cucumber"), "cucumber");
		GameRegistry.registerItem(cucumberSeeds = new ItemCucumberSeeds("cucumber_seeds"), "cucumber_seeds");
		GameRegistry.registerItem(customEgg = new ItemCustomSpawnEgg("custom_spawn_egg"), "custom_spawn_egg");
		GameRegistry.registerItem(flameKatana = new ItemFlameKatana("katana_fire", FKATANA), "katana_fire");
		GameRegistry.registerItem(hochotetsu = new ItemHochoTetsu("hocho-tetsu"), "hocho-tetsu");
		GameRegistry.registerItem(hochotetsuIngot = new ItemHochoTetsuIngot("hocho-tetsu_ingot"), "hocho-tetsu_ingot");
		GameRegistry.registerItem(jo = new ItemJo("jo", JO), "jo");
		GameRegistry.registerItem(kappaMaki = new ItemKappaMaki("kappa_maki", 1, 1.0F, false), "kappa_maki");
		GameRegistry.registerItem(katana = new ItemKatana("katana", KATANA), "katana");
		GameRegistry.registerItem(katanaBladePiece = new ItemKatanaBladePiece("katana_blade_piece"), "katana_blade_piece");
		GameRegistry.registerItem(kimonoHelmet = new ItemArmorKimono("kimono_helmet", CLOTH, "kimono", 0), "kimono_helmet");
		GameRegistry.registerItem(kimonoChestplate = new ItemArmorKimono("kimono_chestplate", CLOTH, "kimono", 1), "kimono_chestplate");
		GameRegistry.registerItem(kimonoLeggings = new ItemArmorKimono("kimono_leggings", CLOTH, "kimono", 2), "kimono_leggings");
		GameRegistry.registerItem(kimonoBoots = new ItemArmorKimono("kimono_boots", CLOTH, "kimono", 3), "kimono_boots");
		GameRegistry.registerItem(kunai = new ItemKunai("kunai"), "kunai");
		GameRegistry.registerItem(ninjaHelmet = new ItemArmorNinja("ninja_helmet", CLOTH, "ninja", 0), "ninja_helmet");
		GameRegistry.registerItem(ninjaChesplate = new ItemArmorNinja("ninja_chestplate", CLOTH, "ninja", 1), "ninja_chestplate");
		GameRegistry.registerItem(ninjaLeggings = new ItemArmorNinja("ninja_leggings", CLOTH, "ninja", 2), "ninja_leggings");
		GameRegistry.registerItem(ninjaBoots = new ItemArmorNinja("ninja_boots", CLOTH, "ninja", 3), "ninja_boots");
		GameRegistry.registerItem(pocky = new ItemPocky("pocky", 1, false), "pocky");
		GameRegistry.registerItem(rice = new ItemRice("rice"), "rice");
		GameRegistry.registerItem(samagewa = new ItemSamagewa("samagewa"), "samagewa");
		GameRegistry.registerItem(seaweed = new ItemSeaweed("seaweed"), "seaweed");
		GameRegistry.registerItem(shinai = new ItemShinai("shinai", SHINAI), "shinai");
		GameRegistry.registerItem(shuriken = new ItemShuriken("shuriken"), "shuriken");
		GameRegistry.registerItem(soyBean = new ItemSoyBean("soy_bean"), "soy_bean");
		GameRegistry.registerItem(soySauce = new ItemSoySauce("soy_sauce"), "soy_sauce");
		GameRegistry.registerItem(spiritCore = new ItemSpiritCore("spirit_core"), "spirit_core");
		GameRegistry.registerItem(spiritFlame = new ItemSpiritFlame("spirit_flame"), "spirit_flame");
		GameRegistry.registerItem(spiritFlameKatana = new ItemSpiritFlameKatana("katana_spiritfire", SFKATANA), "katana_spiritfire");
		GameRegistry.registerItem(tamahagane = new ItemTamahagane("tamahagane"), "tamahagane");
		GameRegistry.registerItem(tamahaganeIngot = new ItemTamahaganeIngot("tamahagane_ingot"), "tamahagane_ingot");
		GameRegistry.registerItem(tatami = new ItemTatami("tatami_mat"), "tatami_mat");
		GameRegistry.registerItem(teaCup = new ItemTeaCup("tea_cup"), "tea_cup");
		GameRegistry.registerItem(tenguFan = new ItemTenguFan("tengu_fan", FANTENGU), "tengu_fan");
		GameRegistry.registerItem(tsuka = new ItemTsuka("tsuka"), "tsuka");
		GameRegistry.registerItem(wasabiRoot = new ItemWasabiRoot("wasabi_root"), "wasabi_root");
		GameRegistry.registerItem(washi = new ItemWashi("washi"), "washi");
		GameRegistry.registerItem(windFan = new ItemWindFan("wind_fan"), "wind_fan");
		GameRegistry.registerItem(yamajijiiEye = new ItemYamajijiiEye("yamajijii_eye"), "yamajijii_eye");
		
		if(!Loader.isModLoaded("malisisdoors")) {
			
			GameRegistry.registerItem(fusuma = new ItemFusumaNorm("fusuma_item", Material.wood).setTextureName(Reference.ID + ":fusuma_item"), "fusuma_item");
			GameRegistry.registerItem(fusumaSM = new ItemFusumaSakuraMan("fusuma_sm_item", Material.wood).setTextureName(Reference.ID + ":fusuma_sm_item"), "fusuma_sm_item");
			GameRegistry.registerItem(fusumaSR = new ItemFusumaSakuraRiver("fusuma_sr_item", Material.wood).setTextureName(Reference.ID + ":fusuma_sr_item"), "fusuma_sr_item");
		}
	}
}
