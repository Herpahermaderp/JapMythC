package io.github.herpahermaderp.japmythc.creativetab;

import io.github.herpahermaderp.japmythc.block.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CustomCreativeTabs {
	
	public static final CreativeTabs tab = new CreativeTabs("tab") {
		
		@Override
		public Item getTabIconItem() {
			
			return Item.getItemFromBlock(ModBlocks.sakuraSapling);
		}
		
		@Override
		public int func_151243_f() {
			
			return 1;
		}
	};
}
