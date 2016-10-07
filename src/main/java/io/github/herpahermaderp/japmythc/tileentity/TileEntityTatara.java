package io.github.herpahermaderp.japmythc.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.block.BlockTatara;
import io.github.herpahermaderp.japmythc.item.crafting.TataraRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTatara extends TileEntity implements IInventory {

	private ItemStack[] tataraItemStacks = new ItemStack[3];
	public int tataraCookTime;
	public int tataraBurnTime;
	public int currentItemBurnTime;
	private String customName;
	
	@Override
	public int getSizeInventory() {
		
		return this.tataraItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int par1) {
		
		return this.tataraItemStacks[par1];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		
		if(this.tataraItemStacks[par1] != null) {
			
			ItemStack stack;
			
			if(this.tataraItemStacks[par1].stackSize <= par2) {
				
				stack = this.tataraItemStacks[par1];
				this.tataraItemStacks[par1] = null;
				return stack;
			}
			
			else {
				
				stack = this.tataraItemStacks[par1].splitStack(par2);
				
				if(this.tataraItemStacks[par1].stackSize == 0) {
					
					this.tataraItemStacks[par1] = null;
				}
				
				return stack;
			}
		}
		
		else {
			
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		
		if(this.tataraItemStacks[par1] != null) {
			
			ItemStack stack = this.tataraItemStacks[par1];
			this.tataraItemStacks[par1] = null;
			return stack;
		}
		
		else {
			
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack stack) {
		
		this.tataraItemStacks[par1] = stack;
		
		if(stack != null && stack.stackSize > this.getInventoryStackLimit()) {
			
			stack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		
		return this.customName;
	}
	
	public void setCustomName(String customName) {
		
		this.customName = customName;
	}

	@Override
	public boolean hasCustomInventoryName() {
		
		return true;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		
		super.readFromNBT(nbt);
		NBTTagList list = nbt.getTagList("Items", 10);
		this.tataraItemStacks = new ItemStack[this.getSizeInventory()];
		
		for(int i = 0; i < list.tagCount(); ++i) {
			
			NBTTagCompound tag = list.getCompoundTagAt(i);
			byte b0 = tag.getByte("Slot");
			
			if(b0 >= 0 && b0 <this.tataraItemStacks.length) {
				
				this.tataraItemStacks[b0] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
		
		this.tataraBurnTime = nbt.getShort("burnTime");
		this.tataraCookTime = nbt.getShort("cookTime");
		this.currentItemBurnTime = getItemBurnTime(this.tataraItemStacks[1]);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		
		super.writeToNBT(nbt);
		nbt.setShort("burnTime", (short)this.tataraBurnTime);
		nbt.setShort("cookTime", (short)this.tataraCookTime);
		NBTTagList list = new NBTTagList();
		
		for(int i = 0; i < this.tataraItemStacks.length; ++i) {
			
			if(this.tataraItemStacks[i] != null) {
				
				NBTTagCompound stackTag = new NBTTagCompound();
				stackTag.setByte("Slot", (byte) i);
				this.tataraItemStacks[i].writeToNBT(stackTag);
				list.appendTag(stackTag);
			}
		}
		
		nbt.setTag("Items", list);
	}

	@Override
	public int getInventoryStackLimit() {
		
		return 64;
	}
	
	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int par1) {
		
		return this.tataraCookTime * par1 / 200;
	}
	
	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int par1) {
		
		if(this.currentItemBurnTime == 0) {
			
			this.currentItemBurnTime = 200;
		}
		
		return this.tataraBurnTime * par1 / this.currentItemBurnTime;
	}
	
	public boolean isBurning() {
		
		return this.tataraBurnTime > 0;
	}
	
public void updateEntity() {
		
		boolean flag = this.tataraBurnTime > 0;
		boolean flag1 = false;
		
		if(this.tataraBurnTime > 0) {
			
			--this.tataraBurnTime;
		}
		
		if(!this.worldObj.isRemote) {
			
			if(this.tataraBurnTime != 0 || this.tataraItemStacks[1] != null && this.tataraItemStacks[0] != null) {
				
				if(this.tataraBurnTime == 0 && this.canSmelt()) {
					
					this.currentItemBurnTime = this.tataraBurnTime = getItemBurnTime(this.tataraItemStacks[1]);
					
					if(this.tataraBurnTime > 0) {
						
						flag1 = true;
						
						if(this.tataraItemStacks[1] != null) {
							
							--this.tataraItemStacks[1].stackSize;
							
							if(this.tataraItemStacks[1].stackSize == 0) {
								
								this.tataraItemStacks[1] = tataraItemStacks[1].getItem().getContainerItem(tataraItemStacks[1]);
							}
						}
					}
				}
				
				if(this.isBurning() && this.canSmelt()) {
					
					++this.tataraCookTime;
					
					if(this.tataraCookTime == 200) {
						
						this.tataraCookTime = 0;
						this.smeltItem();
						flag1 = true;
					}
				}
				
				else {
					
					this.tataraCookTime = 0;
				}
			}
			
			if(flag != this.tataraBurnTime > 0) {
				
				flag1 = true;
				BlockTatara.updateTataraBlockState(this.tataraBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}
		
		if(flag1) {
			
			this.markDirty();
		}
	}

	private boolean canSmelt() {
	
		if(this.tataraItemStacks[0] == null) {
		
			return false;
		}
	
		else {
		
			ItemStack stack = TataraRecipes.smelting().getSmeltingResult(this.tataraItemStacks[0]);
		
			if(stack == null) {
			
				return false;
			}
		
			if(this.tataraItemStacks[2] == null) {
			
				return true;
			}
		
			if(!this.tataraItemStacks[2].isItemEqual(stack)) {
			
				return false;
			}
		
			int result = tataraItemStacks[2].stackSize + stack.stackSize;
			return result <= getInventoryStackLimit() && result <= this.tataraItemStacks[2].getMaxStackSize();
		}
	}

	public void smeltItem() {
		
		if(this.canSmelt()) {
			
			ItemStack stack = TataraRecipes.smelting().getSmeltingResult(this.tataraItemStacks[0]);
			
			if(this.tataraItemStacks[2] == null) {
				
				this.tataraItemStacks[2] = stack.copy();
			}
			
			else if(this.tataraItemStacks[2].getItem() == stack.getItem()) {
				
				this.tataraItemStacks[2].stackSize += stack.stackSize;
			}
			
			--this.tataraItemStacks[0].stackSize;
			
			if(this.tataraItemStacks[0].stackSize <= 0) {
				
				this.tataraItemStacks[0] = null;
			}
		}
	}
	
	public static int getItemBurnTime(ItemStack stack) {
		
		if(stack == null) {
			
			return 0;
		}
		
		else {
			
			int moddedBurnTime = net.minecraftforge.event.ForgeEventFactory.getFuelBurnTime(stack);
			
			if(moddedBurnTime >= 0) {
				
				return moddedBurnTime;
			}
			
			Item item = stack.getItem();
			
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
				
				Block block = Block.getBlockFromItem(item);
				
				if(block == Blocks.wooden_slab) {
					
					return 150;
				}
				
				if(block.getMaterial() == Material.wood) {
					
					return 300;
				}
				
				if(block == Blocks.coal_block) {
					
					return 16000;
				}
			}
			
			if(item == Items.coal) {
				
				return 1600;
			}
			
			return GameRegistry.getFuelValue(stack);
		}
	}

	public static boolean isItemFuel(ItemStack stack) {
		
		return getItemBurnTime(stack) > 0;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64;
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void closeInventory() {
		
	}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack stack) {
		
		return true;
	}
}
