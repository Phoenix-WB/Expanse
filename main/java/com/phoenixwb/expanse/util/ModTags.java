package com.phoenixwb.expanse.util;

import com.phoenixwb.expanse.Expanse;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {
	public static class Blocks {
		public static final Tags.IOptionalNamedTag<Block> MALLEE_STEM_PLANTABLE_ON = createTag(
				"mallee_stem_plantable_on");

		private static Tags.IOptionalNamedTag<Block> createTag(String name) {
			return BlockTags.createOptional(new ResourceLocation(Expanse.MOD_ID, name));
		}
	}

	/*public static class Items {
		private static Tags.IOptionalNamedTag<Item> createTag(String name) {
			return ItemTags.createOptional(new ResourceLocation(Expanse.MOD_ID, name));
		}
	} */
}
