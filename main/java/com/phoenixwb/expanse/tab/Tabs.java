package com.phoenixwb.expanse.tab;

import com.phoenixwb.expanse.init.BlockInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class Tabs {

	public static final CreativeModeTab EXPANSE_WORLD = new CreativeModeTab(CreativeModeTab.TABS.length,
			"expanse_world") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(BlockInit.SMALL_GRASS.get());
		}
	};

	public static final CreativeModeTab EXPANSE_TECH = new CreativeModeTab(CreativeModeTab.TABS.length,
			"expanse_tech") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(BlockInit.COPPER_FORGE.get());
		}
	};
}
