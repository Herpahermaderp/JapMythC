package io.github.herpahermaderp.japmythc.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import io.github.herpahermaderp.japmythc.JapMythC;
import io.github.herpahermaderp.japmythc.entity.projectile.EntitySpiritFlame;
import net.minecraft.entity.EntityList;

public class ModEntities {

	static int startEntityId;
	static int i;
	
	public static void init() {
		
		registerEntityProjectile(EntitySpiritFlame.class, "Spirit Flame");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void registerEntityProjectile(Class entityClass, String name) {
		
		EntityRegistry.registerModEntity(entityClass, name, ++startEntityId, JapMythC.instance, 64, 10, true);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void registerEntity(Class entityClass, String name) {
		
		EntityRegistry.registerModEntity(entityClass, name, ++startEntityId, JapMythC.instance, 80, 3, false);
	}
	
	@SuppressWarnings("rawtypes")
	public static void registerEntityEgg(Class entityClass, String name, int primary, int secondary) {
		
		registerEntity(entityClass, name);
		
		if(i == 0) {
			
			registerSpawnEgg(name, primary, secondary);
			++i;
		}
	}
	
	public static void registerSpawnEgg(String name, int primary, int secondary) {
		
	}
	
	public static int getUniqueEntityId() {
		
		do {
			
			startEntityId++;
		}
		
		while(EntityList.getStringFromID(startEntityId) != null);
		
		return startEntityId;
	}
}
