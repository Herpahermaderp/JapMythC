package io.github.herpahermaderp.japmythc.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.item.ModItems;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockCucumberPlant extends BlockModCrops {

public BlockCucumberPlant(String unlocalizedName) {
		
		setBlockName(unlocalizedName);
		setBlockTextureName(Reference.ID + ":" + unlocalizedName);
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random rand) {
		
		int n = rand.nextInt(3);
		return meta / n;
	}
	
	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		
		return(ModItems.cucumber);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		
		icon = new IIcon[maxGrowthStage + 1];
		icon[0] = register.registerIcon(getTextureName() + "_0");
		icon[1] = register.registerIcon(getTextureName() + "_0");
		icon[2] = register.registerIcon(getTextureName() + "_0");
		icon[3] = register.registerIcon(getTextureName() + "_1");
		icon[4] = register.registerIcon(getTextureName() + "_1");
		icon[5] = register.registerIcon(getTextureName() + "_1");
		icon[6] = register.registerIcon(getTextureName() + "_1");
		icon[7] = register.registerIcon(getTextureName() + "_2");
	}
}