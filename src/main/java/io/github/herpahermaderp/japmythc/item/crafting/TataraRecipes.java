package io.github.herpahermaderp.japmythc.item.crafting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import io.github.herpahermaderp.japmythc.block.ModBlocks;
import io.github.herpahermaderp.japmythc.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TataraRecipes {

	private static final TataraRecipes smeltingBase = new TataraRecipes();
	@SuppressWarnings("rawtypes")
	private Map smeltingList = new HashMap();
	@SuppressWarnings("rawtypes")
	private Map experienceList = new HashMap();
	//private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
	//private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();
	
	public static final TataraRecipes smelting() {
		
		return smeltingBase;
	}
	
	private TataraRecipes() {
		
		this.addBlockSmelting(ModBlocks.ironSand, new ItemStack(ModBlocks.kara), 0.7F);
		this.addItemSmelting(ModItems.tamahagane, new ItemStack(ModItems.tamahaganeIngot), 0.7F);
		this.addItemSmelting(ModItems.hochotetsu, new ItemStack(ModItems.hochotetsuIngot), 0.7F);
	}
	
	public void addBlockSmelting(Block block, ItemStack stack, float par3) {
		
		this.addItemSmelting(Item.getItemFromBlock(block), stack, par3);
	}
	
	public void addItemSmelting(Item item, ItemStack stack, float par3) {
		
		this.addSmelting(new ItemStack(item, 1, 32767), stack, par3);
	}
	
	@SuppressWarnings("unchecked")
	public void addSmelting(ItemStack par1Stack, ItemStack par2Stack, float par3) {
		
		this.smeltingList.put(par1Stack, par2Stack);
		this.experienceList.put(par2Stack, Float.valueOf(par3));
	}
	
	@SuppressWarnings("rawtypes")
	public ItemStack getSmeltingResult(ItemStack stack) {
		
		Iterator iterator = this.smeltingList.entrySet().iterator();
		Entry entry;
		
		do {
			
			if(!iterator.hasNext()) {
				
				return null;
			}
			
			entry = (Entry)iterator.next();
		}
		
		while(!this.isSameItem(stack, (ItemStack)entry.getKey()));
		return (ItemStack)entry.getValue();
	}
	
	private boolean isSameItem(ItemStack par1Stack, ItemStack par2Stack) {
		
		return par2Stack.getItem() == par1Stack.getItem() && (par2Stack.getItemDamage() == 32767 || par2Stack.getItemDamage() == par1Stack.getItemDamage());
	}
	
	@SuppressWarnings("rawtypes")
	public Map getSmeltingList() {
		
		return this.smeltingList;
	}
	
	@SuppressWarnings("rawtypes")
	public float doExperience(ItemStack stack) {
		
		float ret = stack.getItem().getSmeltingExperience(stack);
		
		if(ret != -1) {
			
			return ret;
		}
		
		Iterator iterator = this.experienceList.entrySet().iterator();
		Entry entry;
		
		do {
			
			if(!iterator.hasNext()) {
				
				return 0.0F;
			}
			
			entry = (Entry)iterator.next();
		}
		
		while(!this.isSameItem(stack, (ItemStack)entry.getKey()));
		return ((Float)entry.getValue()).floatValue();
	}
}
