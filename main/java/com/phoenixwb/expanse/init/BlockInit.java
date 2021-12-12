package com.phoenixwb.expanse.init;

import com.phoenixwb.expanse.Expanse;
import com.phoenixwb.expanse.block.CopperForgeBlock;
import com.phoenixwb.expanse.block.SmallGrassBlock;
import com.phoenixwb.expanse.block.malleeshrub.MalleeShrubBlock;
import com.phoenixwb.expanse.block.malleeshrub.MalleeStemBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Expanse.MOD_ID);

	// Expanse World
	public static final RegistryObject<Block> SMALL_GRASS = BLOCKS.register("small_grass",
			() -> new SmallGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS)));

	public static final RegistryObject<Block> MALLEE_SHRUB = BLOCKS
			.register("mallee_shrub",
					() -> new MalleeShrubBlock(
							BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.GRASS).instabreak()
									.sound(SoundType.GRASS).randomTicks().noOcclusion().noCollission(),
							TreeInit.MALLEE));

	public static final RegistryObject<Block> MALLEE_STEM = BLOCKS.register("mallee_stem",
			() -> new MalleeStemBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_WHITE)
					.strength(0).sound(SoundType.BAMBOO)));

	public static final RegistryObject<Block> MALLEE_LEAVES = BLOCKS.register("mallee_leaves",
			() -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

	// Expanse Tech
	public static final RegistryObject<Block> COPPER_FORGE = BLOCKS.register("copper_forge",
			() -> new CopperForgeBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE)
					.strength(4.5f, 6).sound(SoundType.COPPER)));
}
