package com.phoenixwb.expanse.init;

import java.util.function.Supplier;

import com.phoenixwb.expanse.Expanse;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BiomeInit {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
			Expanse.MOD_ID);
	
	static {
		createBiome("shrubland", OverworldBiomes::theVoid);
	}
	
	public static ResourceKey<Biome> SHRUBLAND = registerBiome("shrubland");
	
	public static ResourceKey<Biome> registerBiome(String biomeName) {
		return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Expanse.MOD_ID, biomeName));
	}
	
	public static RegistryObject<Biome> createBiome(String biomeName, Supplier<Biome> biome) {
		return BIOMES.register(biomeName, biome);
	}
	
	public static void registerBiomes() {
		BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(SHRUBLAND, 7));
	}
}
