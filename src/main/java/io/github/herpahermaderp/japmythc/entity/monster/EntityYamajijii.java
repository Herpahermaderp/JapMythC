package io.github.herpahermaderp.japmythc.entity.monster;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityYamajijii extends EntityMob {

	public EntityYamajijii(World world) {
		
		super(world);
	}
	
	@Override
	protected void applyEntityAttributes() {
		
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(45.0D);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		
		float attackDamage = (float)getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
		int knockbackModifier = 0;
		
		if(entity instanceof EntityLivingBase) {
			
			attackDamage += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase)entity);
			knockbackModifier += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase)entity);
		}
		
		boolean isTargetHurt = entity.attackEntityFrom(DamageSource.causeMobDamage(this), attackDamage);
		
		if(isTargetHurt) {
			
			if(knockbackModifier > 0) {
				
				entity.addVelocity((double)(-MathHelper.sin(rotationYaw * (float)Math.PI / 180.0F) * (float)knockbackModifier * 0.5D), 0.1D, (double)(MathHelper.cos(rotationYaw * (float)Math.PI / 180.0F) * (float)knockbackModifier * 0.5D));
				motionX *= 0.6D;
				motionZ *= 0.6D;
			}
			
			int fireModifier = EnchantmentHelper.getFireAspectModifier(this);
			
			if(fireModifier > 0) {
				
				entity.setFire(fireModifier * 4);
			}
			
			if(entity instanceof EntityLivingBase) {
				
				EnchantmentHelper.func_151384_a((EntityLivingBase)entity, this);
			}
			
			EnchantmentHelper.func_151385_b(this, entity);
		}
		
		return isTargetHurt;
	}
}
