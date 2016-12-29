package io.github.herpahermaderp.japmythc.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import io.github.herpahermaderp.japmythc.JapMythC;
import io.github.herpahermaderp.japmythc.entity.monster.EntityAmanojaku;
import io.github.herpahermaderp.japmythc.entity.monster.EntityJorogumo;
import io.github.herpahermaderp.japmythc.entity.monster.EntityYamajijii;
import io.github.herpahermaderp.japmythc.entity.projectile.EntitySpiritFlame;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

public class ModEntities {

	static int startEntityId;
	static int i;
	
	public static void init() {
		
		registerEntityProjectile(EntitySpiritFlame.class, "Spirit Flame", 64, 10, true);
		registerEntityEgg(EntityYamajijii.class, "Yamajijii", 80, 3, false, 0x999999, 0x000000);
		registerEntityEgg(EntityAmanojaku.class, "Amanojaku", 80, 3, false, 0x888888, 0x111111);
		registerEntityEgg(EntityJorogumo.class, "Jorogumo", 80, 3, false, 0x777777, 0x222222);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void registerEntityProjectile(Class entityClass, String name, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
		
		EntityRegistry.registerModEntity(entityClass, name, ++startEntityId, JapMythC.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
		System.out.println("Registering projectile entity " + name + " with ID " + startEntityId);
	}
	
	public static void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
		
		EntityRegistry.registerModEntity(entityClass, name, ++startEntityId, JapMythC.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
		System.out.println("Registering mod entity " + name + " with ID " + startEntityId);
	}
	
	public static void registerEntityEgg(Class<? extends Entity> entityClass, String name, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int primary, int secondary) {
		
		registerEntity(entityClass, name, trackingRange, updateFrequency, sendsVelocityUpdates);
		registerSpawnEgg(entityClass, name, primary, secondary);
	}
	
	public static void registerSpawnEgg(Class<? extends Entity> entityClass, String name, int primary, int secondary) {
		
		CustomEntityList.addMapping(entityClass, name, primary, secondary);
		
		if(!CustomEntityList.classToStringMapping.containsKey(entityClass)) {
			
			throw new IllegalArgumentException("Entity " + entityClass + " spawn egg not registered");
		}
	}
	
	public static int getUniqueEntityId() {
		
		do {
			
			startEntityId++;
		}
		
		while(EntityList.getStringFromID(startEntityId) != null);
		
		return startEntityId;
	}
}
