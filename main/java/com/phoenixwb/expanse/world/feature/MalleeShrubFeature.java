package com.phoenixwb.expanse.world.feature;

import com.mojang.serialization.Codec;
import com.phoenixwb.expanse.init.BlockInit;
import com.phoenixwb.expanse.util.TreeBuilder;
import com.phoenixwb.expanse.util.TreeBuilder.LeavesType;
import com.phoenixwb.expanse.util.TreeBuilder.LogType;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class MalleeShrubFeature extends Feature<NoneFeatureConfiguration> {
	public MalleeShrubFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	public boolean isAirOrLeaves(BlockState state) {
		if (state.getBlock() == Blocks.AIR || state.getBlock() == BlockTags.LEAVES) {
			return true;
		}
		return false;
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		BlockPos pos = context.origin();
		WorldGenLevel level = context.level();
		BlockState state = context.level().getBlockState(pos);
		while (pos.getY() > 1 && isAirOrLeaves(state)) {
			pos = pos.below();
		}

		if (!isGrassOrDirt(level, pos)) {
			return false;
		}

		int[] heightRange = { 4, 8 };

		TreeBuilder MALLEE_SHRUB = new TreeBuilder(context, BlockInit.MALLEE_STEM.get().defaultBlockState(),
				BlockInit.MALLEE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2), heightRange, 0, LogType.SINGLE, LeavesType.CAP);

		MALLEE_SHRUB.placeTrunk();

		MALLEE_SHRUB.placeLeaves();
		return true;
	}
}
