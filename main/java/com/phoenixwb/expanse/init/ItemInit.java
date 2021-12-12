package com.phoenixwb.expanse.init;

import com.phoenixwb.expanse.Expanse;
import com.phoenixwb.expanse.tab.Tabs;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Expanse.MOD_ID);

	// Expanse World
	public static final RegistryObject<Item> SMALL_GRASS = ITEMS.register("small_grass",
			() -> new BlockItem(BlockInit.SMALL_GRASS.get(), new Item.Properties().tab(Tabs.EXPANSE_WORLD)));

	public static final RegistryObject<Item> MALLEE_SHRUB = ITEMS.register("mallee_shrub",
			() -> new BlockItem(BlockInit.MALLEE_SHRUB.get(), new Item.Properties().tab(Tabs.EXPANSE_WORLD)));
	
	public static final RegistryObject<Item> MALLEE_STEM = ITEMS.register("mallee_stem",
			() -> new BlockItem(BlockInit.MALLEE_STEM.get(), new Item.Properties().tab(Tabs.EXPANSE_WORLD)));
	
	public static final RegistryObject<Item> MALLEE_LEAVES = ITEMS.register("mallee_leaves",
			() -> new BlockItem(BlockInit.MALLEE_LEAVES.get(), new Item.Properties().tab(Tabs.EXPANSE_WORLD)));

	// Expanse Tech
	public static final RegistryObject<Item> COPPER_FORGE = ITEMS.register("copper_forge",
			() -> new BlockItem(BlockInit.COPPER_FORGE.get(), new Item.Properties().tab(Tabs.EXPANSE_TECH)));
}
