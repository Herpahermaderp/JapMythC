package io.github.herpahermaderp.japmythc.block.descriptor;

import io.github.herpahermaderp.japmythc.creativetab.CustomCreativeTabs;
import io.github.herpahermaderp.japmythc.lib.Reference;
import net.malisis.doors.door.DoorDescriptor;
import net.malisis.doors.door.DoorRegistry;
import net.malisis.doors.door.movement.SlidingDoorMovement;

public class FusumaNormDescriptor extends DoorDescriptor {

	public FusumaNormDescriptor(String unlocalizedName) {
		
		setName(unlocalizedName);
		//setTextureName(Reference.ID + ":" + unlocalizedName);
		setMovement(DoorRegistry.getMovement(SlidingDoorMovement.class));
		setTab(CustomCreativeTabs.tab);
	}
}
