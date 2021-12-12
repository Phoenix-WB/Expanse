package com.phoenixwb.expanse.init;

import com.phoenixwb.expanse.Expanse;
import com.phoenixwb.expanse.world.feature.MalleeShrubFeature;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FeatureInit {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES,
			Expanse.MOD_ID);	

	public static final RegistryObject<MalleeShrubFeature> MALLEE_SHRUB = FEATURES.register("mallee_shrub",
			() -> new MalleeShrubFeature(NoneFeatureConfiguration.CODEC));
}
