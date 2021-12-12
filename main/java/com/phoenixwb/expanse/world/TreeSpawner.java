package com.phoenixwb.expanse.world;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@SuppressWarnings("rawtypes")
public abstract class TreeSpawner {
	@Nullable
	protected abstract Feature getFeature(Random random);

	@SuppressWarnings("unchecked")
	public boolean spawn(ServerLevel level, ChunkGenerator generator, BlockPos pos, BlockState blockUnder,
			Random random) {
		Feature tree = getFeature(random);
		if (tree == null)
			return false;

		level.setBlock(pos, Blocks.AIR.defaultBlockState(), 4);
		if (tree.place(new FeaturePlaceContext(null, level, generator, random, pos, new NoneFeatureConfiguration()))) {
			return true;
		}
		level.setBlock(pos, blockUnder, 4);
		return false;
	}
}
