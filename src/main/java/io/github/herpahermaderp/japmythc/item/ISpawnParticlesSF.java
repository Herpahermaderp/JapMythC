package io.github.herpahermaderp.japmythc.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ISpawnParticlesSF {

	@SideOnly(Side.CLIENT)
	void spawnParticlesSF(World world, EntityPlayer player, ItemStack stack, double x, double y, double z, float r);
}
