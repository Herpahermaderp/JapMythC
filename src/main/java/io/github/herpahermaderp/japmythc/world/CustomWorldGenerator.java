package io.github.herpahermaderp.japmythc.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import io.github.herpahermaderp.japmythc.world.gen.feature.WorldGenJubokkoTree;
import io.github.herpahermaderp.japmythc.world.gen.feature.WorldGenSakuraTree;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CustomWorldGenerator implements IWorldGenerator {

	@SuppressWarnings("unused")
	private WorldGenerator gen_sakura_tree;
	@SuppressWarnings("unused")
	private WorldGenerator gen_jubokko_tree;
	
	public CustomWorldGenerator() {
		
		this.gen_sakura_tree = new WorldGenSakuraTree(true);
		this.gen_jubokko_tree = new WorldGenJubokkoTree(true);
	}
	
	@Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {   
    
		switch(world.provider.dimensionId) {
		
		case 0:
			this.generateSakuraTree(world, rand, chunkX, chunkZ);
			break;
			
		case -1:
			this.generateJubokkoTree(world, rand, chunkX, chunkZ);
			break;
			
		case 1:
			break;
		}
	}
	
	@SuppressWarnings("unused")
	public void generateSakuraTree(World world, Random rand, int posX, int posZ) {
		
		for(int i = 0; i < 16; ++i) {
			
			int par1xCoord = posX + rand.nextInt(16);
			int par1yCoord = rand.nextInt(70);
			int par1zCoord = posZ + rand.nextInt(16);
		}
		
		for(int i = 0; i < 20; ++i) {
			
			int par2xCoord = posX + rand.nextInt(16);
			int par2yCoord = rand.nextInt(90);
			int par2zCoord = posZ + rand.nextInt(16);
			(new WorldGenSakuraTree(false, 4, 1, 1, false)).generate(world, rand, par2xCoord, par2yCoord, par2zCoord);
		}
	}
	
	@SuppressWarnings("unused")
	public void generateJubokkoTree(World world, Random rand, int posX, int posZ) {
		
		for(int i = 0; i < 16; ++i) {
			
			int par1xCoord = posX + rand.nextInt(16);
			int par1yCoord = rand.nextInt(70);
			int par1zCoord = posZ + rand.nextInt(16);
		}
		
		for(int i = 0; i < 20; ++i) {
			
			int par2xCoord = posX + rand.nextInt(16);
			int par2yCoord = rand.nextInt(90);
			int par2zCoord = posZ + rand.nextInt(16);
			(new WorldGenJubokkoTree(false, 10, 0, 0)).generate(world, rand, par2xCoord, par2yCoord, par2zCoord);
		}
	}
}
