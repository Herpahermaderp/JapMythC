package io.github.herpahermaderp.japmythc.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ISpawnParticles {

	@SideOnly(Side.CLIENT)
	void spawnParticles(World world, EntityPlayer player, ItemStack stack, double x, double y, double z, float r);
}
