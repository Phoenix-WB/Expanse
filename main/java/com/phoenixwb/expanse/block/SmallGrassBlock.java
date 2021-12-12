package com.phoenixwb.expanse.block;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SmallGrassBlock extends TallGrassBlock {
	protected static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 7, 14);

	public SmallGrassBlock(Properties properties) {
		super(properties);
		
	}
	
	@Override
	 public VoxelShape getShape(BlockState p_57336_, BlockGetter p_57337_, BlockPos p_57338_, CollisionContext p_57339_) {
	      return SHAPE;
	   }

	@Override
	public void performBonemeal(ServerLevel p_57320_, Random p_57321_, BlockPos p_57322_, BlockState p_57323_) {
		BushBlock bushblock = (BushBlock) Blocks.GRASS;
		if (bushblock.defaultBlockState().canSurvive(p_57320_, p_57322_)) {
			p_57320_.setBlockAndUpdate(p_57322_, bushblock.defaultBlockState());
		}
	}
}
