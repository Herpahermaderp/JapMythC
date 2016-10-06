package io.github.herpahermaderp.japmythc.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.tileentity.TileEntityTatara;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ContainerTatara extends Container {

	private TileEntityTatara tileTatara;
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;
	
	public ContainerTatara(InventoryPlayer player, TileEntityTatara tatara) {
		
		this.tileTatara = tatara;
		this.addSlotToContainer(new Slot(tatara, 0, 56, 17));
		this.addSlotToContainer(new Slot(tatara, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnace(player.player, tatara, 2, 116, 35));
		int i;
		
		for(i = 0; i < 3; i++) {
			
			for(int j = 0; j < 9; j++) {
				
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(i = 0; i < 9; i++) {
			
			this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
		}
	}
	
	public void addCraftingToCrafters(ICrafting craft) {
		
		super.addCraftingToCrafters(craft);
		craft.sendProgressBarUpdate(this, 0, this.tileTatara.tataraCookTime);
		craft.sendProgressBarUpdate(this, 1, this.tileTatara.tataraBurnTime);
		craft.sendProgressBarUpdate(this, 2, this.tileTatara.currentItemBurnTime);
	}
	
	public void detectAndSendChanges() {
		
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.crafters.size(); i++) {
			
			ICrafting craft = (ICrafting)this.crafters.get(i);
			
			if(this.lastCookTime != this.tileTatara.tataraCookTime) {
				
				craft.sendProgressBarUpdate(this, 0, this.tileTatara.tataraCookTime);
			}
			
			if(this.lastBurnTime != this.tileTatara.tataraBurnTime) {
				
				craft.sendProgressBarUpdate(this, 1, this.tileTatara.tataraBurnTime);
			}
			
			if(this.lastItemBurnTime != this.tileTatara.currentItemBurnTime) {
				
				craft.sendProgressBarUpdate(this, 2, this.tileTatara.currentItemBurnTime);
			}
		}
		
		this.lastCookTime = this.tileTatara.tataraCookTime;
		this.lastBurnTime = this.tileTatara.tataraBurnTime;
		this.lastItemBurnTime = this.tileTatara.currentItemBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		
		if(par1 == 0) {
			
			this.tileTatara.tataraCookTime = par2;
		}
		
		if(par1 == 1) {
			
			this.tileTatara.tataraBurnTime = par2;
		}
		
		if(par1 == 2) {
			
			this.tileTatara.currentItemBurnTime = par2;
		}
	}
	
	public boolean canInteractWith(EntityPlayer player) {
		
		return this.tileTatara.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
		
		ItemStack stack = null;
		Slot slot = (Slot)this.inventorySlots.get(par2);
		
		if(slot != null && slot.getHasStack()) {
			
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();
			
			if(par2 == 2) {
				
				if(!this.mergeItemStack(stack1, 3, 39, true)) {
					
					return null;
				}
				
				slot.onSlotChange(stack1, stack);
			}
			
			else if(par2 != 1 && par2 != 0) {
				
				if(FurnaceRecipes.smelting().getSmeltingResult(stack1) != null) {
					
					if(!this.mergeItemStack(stack1, 0, 1, false)) {
						
						return null;
					}
				}
				
				else if(TileEntityTatara.isItemFuel(stack1)) {
					
					if(!this.mergeItemStack(stack1, 1, 2, false)) {
						
						return null;
					}
				}
				
				else if(par2 >= 3 && par2 < 30) {
					
					if(!this.mergeItemStack(stack1, 30, 39, false)) {
						
						return null;
					}
				}
				
				else if(par2 >= 30 && par2 < 39 && !this.mergeItemStack(stack1, 3, 30, false)) {
					
					return null;
				}
			}
			
			else if(!this.mergeItemStack(stack1, 3, 39, false)) {
				
				return null;
			}
			
			if(stack1.stackSize == 0) {
				
				slot.putStack((ItemStack)null);
			}
			
			else {
				
				slot.onSlotChanged();
			}
			
			if(stack1.stackSize == stack.stackSize) {
				
				return null;
			}
			
			slot.onPickupFromSlot(player, stack1);
		}
		
		return stack;
	}
}
