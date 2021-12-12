package com.phoenixwb.expanse.block.malleeshrub;

import java.util.Random;

import com.phoenixwb.expanse.util.ModTags;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MalleeStemBlock extends Block {
	public VoxelShape SHAPE = Block.box(6, 0, 6, 10, 16, 10);

	public MalleeStemBlock(Properties properties) {
		super(properties);
	}

	public VoxelShape getShape(BlockState p_57100_, BlockGetter p_57101_, BlockPos p_57102_,
			CollisionContext p_57103_) {
		return SHAPE;
	}

	public boolean propagatesSkylightDown(BlockState p_48941_, BlockGetter p_48942_, BlockPos p_48943_) {
		return true;
	}

	public boolean isPathfindable(BlockState p_48906_, BlockGetter p_48907_, BlockPos p_48908_,
			PathComputationType p_48909_) {
		return false;
	}

	public void tick(BlockState state, ServerLevel level, BlockPos pos, Random rand) {
		if (!canSurvive(level, pos)) {
			level.destroyBlock(pos, true);
		}
	}

	public boolean canSurvive(LevelReader level, BlockPos pos) {
		return level.getBlockState(pos.below()).is(ModTags.Blocks.MALLEE_STEM_PLANTABLE_ON);
	}
}
