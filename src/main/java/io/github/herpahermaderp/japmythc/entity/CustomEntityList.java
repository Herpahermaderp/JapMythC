package io.github.herpahermaderp.japmythc.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class CustomEntityList {

	public static int entitiesAdded = 0;
	//Maps between an entity class and a string
	public static Map<String, Class<? extends Entity>> stringToClassMapping = new HashMap<String, Class<? extends Entity>>();
	//Maps between a string and an entity class
	public static Map<Class<? extends Entity>, String> classToStringMapping = new HashMap<Class<? extends Entity>, String>();
	//Maps between an entity ID and an entity class
	public static Map<Integer, Class<? extends Entity>> IDToClassMapping = new HashMap<Integer, Class<? extends Entity>>();
	//Maps between an entity class and an entity ID
	private static Map<Class<? extends Entity>, Integer> classToIDMapping = new HashMap<Class<? extends Entity>, Integer>();
	//Maps between an entity name and an entity ID
	private static Map<String, Integer> stringToIDMapping = new HashMap<String, Integer>();
	public static HashMap<Class<? extends Entity>, List<Integer>> entityEggs = new LinkedHashMap<Class<? extends Entity>, List<Integer>>();
	
	public static void addMapping(Class<? extends Entity> oClass, String entityName) {
		
		int entityID = getEntityId(oClass);
		stringToClassMapping.put(entityName, oClass);
		classToStringMapping.put(oClass, entityName);
		IDToClassMapping.put(entityID, oClass);
		classToIDMapping.put(oClass, entityID);
		stringToIDMapping.put(entityName, entityID);
	}
	
	public static void addMapping(Class<? extends Entity> oClass, String entityName, Integer... colors) {
		
		addMapping(oClass, entityName);
		entityEggs.put(oClass, Arrays.asList(colors));
	}
	
	public static int getEntityId(Class<? extends Entity> oClass) {
		
		if(classToIDMapping.containsKey(oClass)) {
			
			return classToIDMapping.get(oClass);
		}
		
		else if(!IDToClassMapping.containsKey(entitiesAdded)) {
			
			return entitiesAdded++;
		}
		
		else {
			
			while(IDToClassMapping.containsKey(entitiesAdded)) {
				
				++entitiesAdded;
			}
			
			return entitiesAdded;
		}
	}
	
	public static Entity createEntityByName(String entityName, World world) {
		
		return createEntity(stringToClassMapping.get(entityName), world);
	}
	
	public static Entity createEntityFromNBT(NBTTagCompound nbt, World world) {
		
		Entity entity = createEntityByName(nbt.getString("id"), world);
		
		if(entity != null) {
			
			try {
				
				entity.readFromNBT(nbt);
			}
			
			catch(Exception e) {
				
				e.printStackTrace();
				entity = null;
			}
		}
		
		return entity;
	}
	
	public static Entity createEntityByID(int entityID, World world) {
		
		return createEntity(getClassFromID(entityID), world);
	}
	
	public static Entity createEntity(Class<? extends Entity> oClass, World world) {
		
		Entity entity = null;
		
		try {
			
			if(oClass != null) {
				
				entity = oClass.getConstructor(World.class).newInstance(world);
			}
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return entity;
	}
	
	public static int getEntityID(Entity entity) {
		
		Class<? extends Entity> oClass = entity.getClass();
		return classToIDMapping.containsKey(oClass) ? classToIDMapping.get(oClass) : 0;
	}
	
	public static Class<? extends Entity> getClassFromID(int entityID) {
		
		return IDToClassMapping.get(entityID);
	}
	
	public static String getEntityString(Entity entity) {
		
		return classToStringMapping.get(entity.getClass());
	}
	
	public static String getStringFromID(int entityID) {
		
		Class<? extends Entity> oClass = getClassFromID(entityID);
		return oClass != null ? classToStringMapping.get(oClass) : null;
	}
}
