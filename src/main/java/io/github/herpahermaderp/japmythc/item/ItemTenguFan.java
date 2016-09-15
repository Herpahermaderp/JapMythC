package io.github.herpahermaderp.japmythc.item;

import java.util.List;

import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemTenguFan extends ItemSword {
	
	public ItemTenguFan(String unlocalizedName, ToolMaterial material) {
		
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.ID + ":" + unlocalizedName);
		this.setCreativeTab(CustomCreativeTabs.tab);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		AxisAlignedBB fanBox = getEffectAABB(world, player);
		Vec3 lookVec = player.getLookVec();
		
		fanEntitiesAABB(world, player, fanBox);
		
		stack.damageItem(1, player);
		
		for (int i = 0; i < 30; i++) {
			
			world.spawnParticle("cloud", fanBox.minX + world.rand.nextFloat() * (fanBox.maxX - fanBox.minX), fanBox.minY + world.rand.nextFloat() * (fanBox.maxY - fanBox.minY), fanBox.minZ + world.rand.nextFloat() * (fanBox.maxZ - fanBox.minZ), lookVec.xCoord, lookVec.yCoord, lookVec.zCoord);
		}
		
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		
		return stack;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		
        return EnumAction.block;
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
        
		return 5;
    }
	
	@Override
	public boolean isFull3D() {
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	private void fanEntitiesAABB(World world, EntityPlayer player, AxisAlignedBB fanBox) {
		
		Vec3 moveVec = player.getLookVec();
		
		List<Entity> inBox = world.getEntitiesWithinAABBExcludingEntity(player, fanBox);
		
		float force = 2.0F;
		
		for(Entity entity : inBox) {
			
			if(entity.canBePushed() || entity instanceof EntityItem) {
				
				entity.motionX = moveVec.xCoord * force;
				entity.motionY = moveVec.yCoord * force;
				entity.motionZ = moveVec.zCoord * force;
			}
		}
	}
	
	private AxisAlignedBB getEffectAABB(World world, EntityPlayer player) {
		
		double range = 3.0D;
		double radius = 2.0D;
		
		Vec3 srcVec = Vec3.createVectorHelper(player.posX, player.posY + player.getEyeHeight(), player.posZ);
		Vec3 lookVec = player.getLookVec();
		Vec3 destVec = srcVec.addVector(lookVec.xCoord * range, lookVec.yCoord * range, lookVec.zCoord * range);
		
		AxisAlignedBB crumbleBox =  AxisAlignedBB.getBoundingBox(destVec.xCoord - radius, destVec.yCoord - radius, destVec.zCoord - radius, destVec.xCoord + radius, destVec.yCoord + radius, destVec.zCoord + radius);
		
		return crumbleBox;
	}
}
