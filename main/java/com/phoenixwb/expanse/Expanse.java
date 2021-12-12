package com.phoenixwb.expanse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.phoenixwb.expanse.init.BiomeInit;
import com.phoenixwb.expanse.init.BlockEntityInit;
import com.phoenixwb.expanse.init.BlockInit;
import com.phoenixwb.expanse.init.FeatureInit;
import com.phoenixwb.expanse.init.ItemInit;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("expanse")
@Mod.EventBusSubscriber(modid = Expanse.MOD_ID, bus = Bus.MOD)
public class Expanse {
	public static final Logger 	LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "expanse";

	public Expanse() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		bus.addListener(this::doClientStuff);
		bus.addListener(this::registerBlockColors);
		bus.addListener(this::registerItemColors);

		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		FeatureInit.FEATURES.register(bus);
		BlockEntityInit.BLOCK_ENTITIES.register(bus);
		BiomeInit.BIOMES.register(bus);
		BiomeInit.registerBiomes();

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemBlockRenderTypes.setRenderLayer(BlockInit.SMALL_GRASS.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(BlockInit.MALLEE_SHRUB.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(BlockInit.MALLEE_LEAVES.get(), RenderType.cutout());
		});
	}

	public void registerBlockColors(ColorHandlerEvent.Block event) {
		event.getBlockColors().register((p_92641_, p_92642_, p_92643_, p_92644_) -> {
			return p_92642_ != null && p_92643_ != null ? BiomeColors.getAverageGrassColor(p_92642_, p_92643_)
					: GrassColor.get(0.5D, 1.0D);
		}, BlockInit.SMALL_GRASS.get(), BlockInit.MALLEE_LEAVES.get());
	}

	public void registerItemColors(ColorHandlerEvent.Item event) {
		BlockColors p_92684_ = event.getBlockColors();
		event.getItemColors().register((p_92687_, p_92688_) -> {
			BlockState blockstate = ((BlockItem) p_92687_.getItem()).getBlock().defaultBlockState();
			return p_92684_.getColor(blockstate, (BlockAndTintGetter) null, (BlockPos) null, p_92688_);
		}, BlockInit.SMALL_GRASS.get(), BlockInit.MALLEE_LEAVES.get());
	}
}
