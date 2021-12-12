package com.phoenixwb.expanse.init;

import java.util.Random;

import com.phoenixwb.expanse.world.TreeSpawner;

import net.minecraft.world.level.levelgen.feature.Feature;

@SuppressWarnings("rawtypes")
public class TreeInit {
	public static final TreeSpawner MALLEE = new TreeSpawner() {
		@Override
		protected Feature getFeature(Random random) {
			return FeatureInit.MALLEE_SHRUB.get();
		}
	};
}
