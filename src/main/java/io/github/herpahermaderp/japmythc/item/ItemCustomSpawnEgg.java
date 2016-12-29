package io.github.herpahermaderp.japmythc.item;

import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.entity.CustomEntityList;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemCustomSpawnEgg extends Item {

	@SideOnly(Side.CLIENT)
	private IIcon overlay;
	
	public ItemCustomSpawnEgg(String unlocalizedName) {
		
		super();
		setHasSubtypes(true);
		setTextureName("spawn_egg");
		setCreativeTab(CustomCreativeTabs.tab);
		setUnlocalizedName(unlocalizedName);
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		
		String s = ("" + StatCollector.translateToLocal("item.hhdjmc.spawn_egg.name")).trim();
		String entityName = CustomEntityList.getStringFromID(stack.getItemDamage());
		
		if(entityName != null) {
			
			s = s + "." + StatCollector.translateToLocal("entity." + Reference.ID + "." + entityName + ".name");
		}
		
		return s;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int renderPass) {
		
		List<Integer> colors = CustomEntityList.entityEggs.get(CustomEntityList.getClassFromID(stack.getItemDamage()));
		return colors != null && colors.size() > 1 ? colors.get((renderPass == 0 ? 0 : 1)) : 16777215;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		
		if(world.isRemote) {
			
			return true;
		}
		
		else {
			
			Block block = world.getBlock(x,  y, z);
			x += Facing.offsetsXForSide[side];
			y += Facing.offsetsYForSide[side];
			z += Facing.offsetsZForSide[side];
			double d0 = 0.0D;
			
			if(side == 1 && block != null && block.getRenderType() == 11) {
				
				d0 = 0.5D;
			}
			
			Entity entity = spawnCreature(world, stack.getItemDamage(), x + 0.5D, y + d0, z + 0.5D);
			
			if(entity != null) {
				
				if(entity instanceof EntityLiving && stack.hasDisplayName()) {
					
					((EntityLiving) entity).setCustomNameTag(stack.getDisplayName());
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
		
		if(!world.isRemote) {
			
			MovingObjectPosition mop = getMovingObjectPositionFromPlayer(world, player, true);
			
			if(mop != null) {
				
				if(mop.typeOfHit == MovingObjectType.BLOCK) {
					
					int i = mop.blockX;
					int j = mop.blockY;
					int k = mop.blockZ;
					
					if(!world.canMineBlock(player, i, j, k)) {
						
						return stack;
					}
					
					if(!player.canPlayerEdit(i, j, k, mop.sideHit, stack)) {
						
						return stack;
					}
					
					if(world.getBlock(i, j, k).getMaterial() == Material.water) {
						
						Entity entity = spawnCreature(world, stack.getItemDamage(), i, j, k);
						
						if(entity != null) {
							
							if(entity instanceof EntityLiving && stack.hasDisplayName()) {
								
								((EntityLiving) entity).setCustomNameTag(stack.getDisplayName());
							}
							
							if(!player.capabilities.isCreativeMode) {
								
								--stack.stackSize;
							}
						}						
					}
				}
			}
		}
		
		return stack;
	}
	
	public Entity spawnCreature(World world, int entityID, double x, double y, double z) {
		
		Entity entity = null;
		Class<? extends Entity> oClass = CustomEntityList.getClassFromID(entityID);
		
		if(CustomEntityList.entityEggs.containsKey(oClass)) {
			
			entity = CustomEntityList.createEntity(oClass, world);
			
			if(entity instanceof EntityLiving) {
				
				EntityLiving entityLiving = (EntityLiving) entity;
				entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
				entityLiving.rotationYawHead = entityLiving.rotationYaw;
				entityLiving.renderYawOffset = entityLiving.rotationYaw;
				entityLiving.onSpawnWithEgg((IEntityLivingData) null);
				world.spawnEntityInWorld(entity);
				entityLiving.playLivingSound();
			}
		}
		
		return entity;
	}
	
	public static boolean spawnChild(World world, ItemStack stack, EntityPlayer player, EntityAgeable entity) {
		
		Class oClass = CustomEntityList.getClassFromID(stack.getItemDamage());
		
		if(oClass != null && oClass.isAssignableFrom(entity.getClass())) {
			
			EntityAgeable child = entity.createChild(entity);
			
			if(child != null) {
				
				child.setGrowingAge(-24000);
				child.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, 0.0F, 0.0F);
				
				if(!world.isRemote) {
					
					world.spawnEntityInWorld(child);
				}
				
				if(stack.hasDisplayName()) {
					
					child.setCustomNameTag(stack.getDisplayName());
				}
				
				if(!player.capabilities.isCreativeMode) {
					
					--stack.stackSize;
					
					if(stack.stackSize <= 0) {
						
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
					}
				}
				
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		
		Iterator<Class<? extends Entity>> iterator = CustomEntityList.entityEggs.keySet().iterator();
		
		while(iterator.hasNext()) {
			
			Class<? extends Entity> oClass = iterator.next();
			List<Integer> colors = CustomEntityList.entityEggs.get(oClass);
			
			if(colors != null && colors.size() == 2) {
				
				list.add(new ItemStack(item, 1, CustomEntityList.getEntityId(oClass)));
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int damage, int pass) {
		
		return pass > 0 ? overlay : super.getIconFromDamageForRenderPass(damage, pass);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		
		super.registerIcons(register);
		overlay = register.registerIcon(getIconString() + "_overlay");
	}
}