package com.phoenixwb.expanse.init;

import com.phoenixwb.expanse.Expanse;
import com.phoenixwb.expanse.block.entity.CopperForgeBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, Expanse.MOD_ID);

	public static final RegistryObject<BlockEntityType<CopperForgeBlockEntity>> COPPER_FORGE = BLOCK_ENTITIES.register(
			"copper_forge",
			() -> BlockEntityType.Builder.of(CopperForgeBlockEntity::new, BlockInit.COPPER_FORGE.get()).build(null));
}
