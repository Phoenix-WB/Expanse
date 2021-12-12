package com.phoenixwb.expanse.util;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class TreeBuilder {

	public enum LogType {
		SINGLE, ABSTRACT;
	}

	public enum LeavesType {
		COVERED, FRACTION, CAP;
	}

	FeaturePlaceContext<NoneFeatureConfiguration> context;
	BlockState log;
	BlockState leaves;
	int[] heightRange;
	int layers;
	LogType logType;
	LeavesType leavesType;
	int trunkRange = heightRange[1] - heightRange[0];
	int treeHeight;

	public TreeBuilder(FeaturePlaceContext<NoneFeatureConfiguration> context, BlockState log, BlockState leaves,
			int[] heightRange, int layers, LogType logType, LeavesType leavesType) {
		this.context = context;
		this.log = log;
		this.leaves = leaves;
		this.heightRange = heightRange;
		this.layers = layers;
		this.logType = logType;
		this.leavesType = leavesType;
	}

	public void placeTrunk() {
		if (this.logType == LogType.SINGLE) {
			ArrayList<Integer> trunkHeights = createTrunkArray();
			Random rand = new Random();
			BlockPos pos = context.origin();
			int trunkHeight = trunkHeights.get(rand.nextInt(trunkRange));
			for (int i = 0; i < trunkHeight + 1; i++) {
				context.level().setBlock(new BlockPos(pos.getX(), trunkHeight + i, pos.getZ()), log, 3);
			}
			setTreeHeight(trunkHeight);
		}
	}

	public void placeLeaves() {
		if (this.leavesType == LeavesType.CAP) {
			WorldGenLevel level = context.level();
			BlockPos pos = context.origin();
			level.setBlock(new BlockPos(pos.getX(), treeHeight + 1, pos.getZ()), leaves, 3);
			level.setBlock(new BlockPos(pos.getX(), treeHeight + 2, pos.getZ()), leaves, 3);
			level.setBlock(new BlockPos(pos.getX() + 1, treeHeight + 1, pos.getZ()), leaves, 3);
			level.setBlock(new BlockPos(pos.getX(), treeHeight + 1, pos.getZ() + 1), leaves, 3);
			level.setBlock(new BlockPos(pos.getX() - 1, treeHeight + 1, pos.getZ()), leaves, 3);
			level.setBlock(new BlockPos(pos.getX(), treeHeight + 1, pos.getZ() - 1), leaves, 3);
		}
	}

	protected ArrayList<Integer> createTrunkArray() {
		ArrayList<Integer> trunkHeights = new ArrayList<Integer>();
		for (int i = 0; i < trunkRange + 1; i++) {
			trunkHeights.add(i + heightRange[0]);
		}
		return trunkHeights;
	}

	protected void setTreeHeight(int treeHeight) {
		this.treeHeight = treeHeight;
	}
}
