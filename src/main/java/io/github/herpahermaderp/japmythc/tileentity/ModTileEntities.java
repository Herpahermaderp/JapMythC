package io.github.herpahermaderp.japmythc.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities {

	public static void init() {
		
		GameRegistry.registerTileEntity(TileEntityTatara.class, "japmythc_tile_entity_tatara");
	}
}
