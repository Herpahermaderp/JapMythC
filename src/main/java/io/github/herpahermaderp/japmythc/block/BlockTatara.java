package io.github.herpahermaderp.japmythc.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.JapMythC;
import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import io.github.herpahermaderp.japmythc.network.GuiHandler;
import io.github.herpahermaderp.japmythc.tileentity.TileEntityTatara;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockTatara extends BlockContainer {
	
	private final Random rand = new Random();
	public IIcon top;
	public IIcon sides;
	private final boolean isActive;

	public BlockTatara(String unlocalizedName, Material material, boolean isActive) {
		
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Reference.ID + ":" + unlocalizedName);
		
		if(!isActive) {
			
			this.setCreativeTab(CustomCreativeTabs.tab);
		}
		
		this.isActive = isActive;
	}
	
	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		
		return Item.getItemFromBlock(ModBlocks.tatara);
	}
	
	public void onBlockAdded(World world, int x, int y, int z) {
		
		super.onBlockAdded(world, x, y, z);
		this.func_149930_e(world, x, y, z);
	}
	
	private void func_149930_e(World world, int x, int y, int z) {
		
		if(!world.isRemote) {
			
			Block block = world.getBlock(x, y, z - 1);
			Block block1 = world.getBlock(x, y, z + 1);
			Block block2 = world.getBlock(x - 1, y, z);
			Block block3 = world.getBlock(x + 1, y, z);
			byte b0 = 3;
			
			if(block.func_149730_j() && !block1.func_149730_j()) {
				
				b0 = 3;
			}
			
			if(block1.func_149730_j() && !block.func_149730_j()) {
				
				b0 = 2;
			}
			
			if(block2.func_149730_j() && !block3.func_149730_j()) {
				
				b0 = 5;
			}
			
			if(block3.func_149730_j() && !block2.func_149730_j()) {
				
				b0 = 4;
			}
			
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		
		if(side == 1) {
			
			return top;
		}
		
		return sides;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister reg) {
		
		top = reg.registerIcon(this.isActive ? Reference.ID + ":" + "tatara_lit" : getTextureName());
		sides = reg.registerIcon(this.isActive ? Reference.ID + ":" + "tatara_sides" : getTextureName() + "_sides");
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		
		TileEntity te = world.getTileEntity(x, y, z);
		
		if(te == null || player.isSneaking()) {
			
			return false;
		}
		
		else {
			
			for(int i = -1; i < 2; i++) {
				
				for(int j = -1; j < 2; j++) {
					
					if(BlockTatara.isMultiBlock(world, x + i, y, z + j)) {
						
						player.openGui(JapMythC.instance, GuiHandler.GUI_TATARA, world, x + i, y, z + j);
						return true;
					}
				}
			}
			
			if(BlockTatara.isMultiBlock(world, x, y - 1, z)) {
				
				player.openGui(JapMythC.instance, GuiHandler.GUI_TATARA, world, x, y - 1, z);
				return true;
			}
			
			else if(BlockTatara.isMultiBlock(world, x, y - 2, z)) {
				
				player.openGui(JapMythC.instance, GuiHandler.GUI_TATARA, world, x, y - 2, z);
				return true;
			}
		}
		
		return false;
	}
	
	public static void updateTataraBlockState(boolean par1, World world, int x, int y, int z) {
		
		int l = world.getBlockMetadata(x, y, z);
		TileEntity te = world.getTileEntity(x, y, z);
		
		if(par1) {
			
			world.setBlock(x, y, z, ModBlocks.tatara_lit);
		}
		
		else {
			world.setBlock(x, y, z, ModBlocks.tatara);
		}
		
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
		
		if(te != null) {
			
			te.validate();
			world.setTileEntity(x, y, z, te);
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		
		return new TileEntityTatara();
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {
		
		int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		if(l == 0) {
			
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		
		if(l == 1) {
			
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		
		if(l == 2) {
			
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		
		if(l == 3) {
			
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
	}
	
	@Override
	public void breakBlock(World world, int posX, int posY, int posZ, Block block, int state) {
		
		TileEntityTatara te = (TileEntityTatara) world.getTileEntity(posX, posY, posZ);
		
		if(te != null) {
			
			for(int i = 0; i < te.getSizeInventory(); ++i) {
				
				ItemStack stack = te.getStackInSlot(i);
				
				if(stack != null) {
					
					float randX = this.rand.nextFloat() * 0.8F + 0.1F;
					float randY = this.rand.nextFloat() * 0.8F + 0.1F;
					float randZ = this.rand.nextFloat() * 0.8F + 0.1F;
					
					while(stack.stackSize > 0) {
						
						int j = this.rand.nextInt(21) + 10;
						
						if(j > stack.stackSize) {
							
							j = stack.stackSize;
						}
						
						stack.stackSize -= j;
						EntityItem item = new EntityItem(world, (double)((float)posX + randX), (double)((float)posY + randY), (double)((float)posZ + randZ), new ItemStack(stack.getItem(), j, stack.getItemDamage()));
						
						if(stack.hasTagCompound()) {
							
							item.getEntityItem().setTagCompound((NBTTagCompound)stack.getTagCompound().copy());
						}
						
						float f = 0.05F;
						item.motionX = (double)((float)this.rand.nextGaussian() * f);
						item.motionY = (double)((float)this.rand.nextGaussian() * f + 0.2F);
						item.motionZ = (double)((float)this.rand.nextGaussian() * f);
						world.spawnEntityInWorld(item);
					}
				}
			}
			
			world.func_147453_f(posX, posY, posZ, block);
		}
		
		super.breakBlock(world, posX, posY, posZ, block, state);
	}
	
	public static boolean isMultiBlock(World world, int x, int y, int z) {
		
		if(world.getBlock(x, y - 1, z) == Blocks.lava && world.getBlock(x + 1, y, z) == Blocks.iron_block && world.getBlock(x - 1, y, z) == Blocks.iron_block && world.getBlock(x, y, z + 1) == Blocks.iron_block && world.getBlock(x, y, z - 1) == Blocks.iron_block && world.getBlock(x + 1, y, z + 1) == Blocks.obsidian && world.getBlock(x + 1, y, z - 1) == Blocks.obsidian && world.getBlock(x - 1, y, z - 1) == Blocks.obsidian && world.getBlock(x - 1, y, z + 1) == Blocks.obsidian) {
			
			return true;
		}
		
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		
		return Item.getItemFromBlock(ModBlocks.tatara);
	}
}