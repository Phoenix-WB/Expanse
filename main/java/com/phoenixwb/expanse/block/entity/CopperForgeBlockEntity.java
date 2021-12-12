package com.phoenixwb.expanse.block.entity;

import com.phoenixwb.expanse.init.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CopperForgeBlockEntity extends BlockEntity {

	public CopperForgeBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityInit.COPPER_FORGE.get(), pos, state);
	}

	@Override
	public CompoundTag save(CompoundTag nbt) {
		return super.save(nbt);
	}
	
	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
	}
	
	public void tick() {
	}
}
