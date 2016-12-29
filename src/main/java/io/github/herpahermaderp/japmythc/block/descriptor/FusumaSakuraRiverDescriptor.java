package io.github.herpahermaderp.japmythc.block.descriptor;

import io.github.herpahermaderp.japmythc.block.ModBlocks;
import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.malisis.doors.door.DoorDescriptor;
import net.malisis.doors.door.DoorRegistry;
import net.malisis.doors.door.movement.SlidingDoorMovement;
import net.minecraft.world.IBlockAccess;

public class FusumaSakuraRiverDescriptor extends DoorDescriptor {

	public FusumaSakuraRiverDescriptor(String unlocalizedName) {
		
		setName(unlocalizedName);
		setTextureName(Reference.ID + ":" + unlocalizedName);
		setMovement(DoorRegistry.getMovement(SlidingDoorMovement.class));
		setTab(CustomCreativeTabs.tab);
	}
	
	public void isNeighborBlock(IBlockAccess world, int posX, int posY, int posZ) {
		
		if(world.getBlock(posX + 1, posY, posZ) == ModBlocks.fusumaSR) {
			
			setTextureName(getTextureName() + "_sm");
		}
	}
}
