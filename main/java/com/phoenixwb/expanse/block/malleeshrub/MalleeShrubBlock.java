package com.phoenixwb.expanse.block.malleeshrub;

import java.util.Random;

import com.phoenixwb.expanse.world.TreeSpawner;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class MalleeShrubBlock extends SaplingBlock {
	private final TreeSpawner tree;

	public MalleeShrubBlock (Properties properties, TreeSpawner spawner) {
		super(null, properties);
		this.tree = spawner;
	}
	
	@Override
	public void advanceTree(ServerLevel world, BlockPos pos, BlockState state, Random rand) {
		if (state.getValue(STAGE) == 0) {
			world.setBlock(pos, state.cycle(STAGE), 4);
		}
		else {
			tree.spawn(world, world.getChunkSource().getGenerator(), pos, state, rand);
		}
	}
}
