package io.github.herpahermaderp.japmythc.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemCustomSpawnEgg extends ItemMonsterPlacer {

	@SideOnly(Side.CLIENT)
	private IIcon icon;
	protected int colorBase = 0x000000;
	protected int colorSpots = 0xFFFFFF;
	protected String entityToSpawnName = "";
	protected String entityToSpawnNameFull = "";
	protected EntityLiving entityToSpawn = null;
	
	public ItemCustomSpawnEgg() {
		
		super();
	}
	
	public ItemCustomSpawnEgg(String entityToSpawnName, int primaryColor, int secondaryColor) {
		
		setHasSubtypes(false);
		maxStackSize = 64;
		setCreativeTab(CustomCreativeTabs.tab);
		setEntityToSpawnName(entityToSpawnName);
		colorBase = primaryColor;
		colorSpots = secondaryColor;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float movX, float movY, float movZ) {
		
		if(world.isRemote) {
			
			return true;
		}
		
		else {
			
			Block block = world.getBlock(x, y, z);
			x += Facing.offsetsXForSide[meta];
			y += Facing.offsetsYForSide[meta];
			z += Facing.offsetsZForSide[meta];
			double d0 = 0.0D;
			
			if(meta == 1 && block.getRenderType() == 11) {
				
				d0 = 0.5D;
			}
			
			Entity entity = spawnEntity(world, x + 0.5D, y + d0, z + 0.5D);
			
			if(entity != null) {
				
				if(entity instanceof EntityLivingBase && stack.hasDisplayName()) {
					
					((EntityLiving)entity).setCustomNameTag(stack.getDisplayName());
				}
				
				if(!player.capabilities.isCreativeMode) {
					
					--stack.stackSize;
				}
			}
			
			return true;
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		if(world.isRemote) {
			
			return stack;
		}
		
		else {
			
			MovingObjectPosition mov = getMovingObjectPositionFromPlayer(world, player, true);
			
			if(mov == null) {
				
				return stack;
			}
			
			else {
				
				if(mov.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
					
					int i = mov.blockX;
					int j = mov.blockY;
					int k = mov.blockZ;
					
					if(!world.canMineBlock(player, i, j, k)) {
						
						return stack;
					}
					
					if(!player.canPlayerEdit(i, j, k, mov.sideHit, stack)) {
						
						return stack;
					}
					
					if(world.getBlock(i, k, k) instanceof BlockLiquid) {
						
						Entity entity = spawnEntity(world, i, j, k);
						
						if(entity != null) {
							
							if(entity instanceof EntityLivingBase && stack.hasDisplayName()) {
								
								((EntityLiving)entity).setCustomNameTag(stack.getDisplayName());
							}
							
							if(!player.capabilities.isCreativeMode) {
								
								--stack.stackSize;
							}
						}
					}
				}
				
				return stack;
			}
		}
	}
	
	public Entity spawnEntity(World world, double x, double y, double z) {
		
		if(!world.isRemote) {
			
			entityToSpawnNameFull = Reference.ID + "." + entityToSpawnName;
			
			if(EntityList.stringToClassMapping.containsKey(entityToSpawnNameFull)) {
				
				entityToSpawn = (EntityLiving) EntityList.createEntityByName(entityToSpawnNameFull, world);
				entityToSpawn.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
				world.spawnEntityInWorld(entityToSpawn);
				entityToSpawn.onSpawnWithEgg((IEntityLivingData)null);
				entityToSpawn.playLivingSound();
			}
		}
		
		return entityToSpawn;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		
		list.add(new ItemStack(item, 1, 0));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int color) {
		
		return (color == 0) ? colorBase : colorSpots;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		
		return true;
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		
		return "Spawn " + entityToSpawnName;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		
		super.registerIcons(reg);
		icon = reg.registerIcon(getIconString() + "_overlay");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int damage, int renderPass) {
		
		return renderPass > 0 ? icon : super.getIconFromDamageForRenderPass(damage, renderPass);
	}
	
	public void setColors(int primary, int secondary) {
		
		colorBase = primary;
		colorSpots = secondary;
	}
	
	public int getColorBase() {
		
		return colorBase;
	}
	
	public int getColorSpots() {
		
		return colorSpots;
	}
	
	public void setEntityToSpawnName(String name) {
		
		entityToSpawnName = name;
		entityToSpawnNameFull = Reference.ID + "." + entityToSpawnName;
	}
}