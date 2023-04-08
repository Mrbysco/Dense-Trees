package com.mrbysco.densetrees.handler;

import com.mrbysco.densetrees.config.DenseConfig;
import com.mrbysco.densetrees.world.DenseTreeFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.event.world.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SaplingHandler {
	private static final Map<ResourceLocation, Supplier<Holder<? extends ConfiguredFeature<?, ?>>>> changeFeatureMap = populateMap();

	@SubscribeEvent
	public void saplingGrowEvent(SaplingGrowTreeEvent event) {
		LevelAccessor levelAccessor = event.getWorld();
		if (DenseConfig.COMMON.enableSaplingToDenseTree.get() && levelAccessor.getRandom().nextDouble() <= DenseConfig.COMMON.saplingToDenseTreeChance.get()) {
			ResourceKey<? extends ConfiguredFeature<?, ?>> unwrappedKey = event.getFeature().unwrapKey().orElse(null);
			if (unwrappedKey != null && changeFeatureMap.containsKey(unwrappedKey.location())) {
				Holder<? extends ConfiguredFeature<?, ?>> denseConfiguredFeature = changeFeatureMap.getOrDefault(unwrappedKey.location(), () -> null).get();
				if (denseConfiguredFeature != null)
					event.setFeature(denseConfiguredFeature);
			}
		}
	}

	public static Map<ResourceLocation, Supplier<Holder<? extends ConfiguredFeature<?, ?>>>> populateMap() {
		Map<ResourceLocation, Supplier<Holder<? extends ConfiguredFeature<?, ?>>>> map = new HashMap<>();
		map.put(TreeFeatures.OAK.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_OAK.getHolder().orElseThrow());
		map.put(TreeFeatures.DARK_OAK.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_DARK_OAK.getHolder().orElseThrow());
		map.put(TreeFeatures.BIRCH.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_BIRCH.getHolder().orElseThrow());
		map.put(TreeFeatures.ACACIA.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_ACACIA.getHolder().orElseThrow());
		map.put(TreeFeatures.SPRUCE.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_SPRUCE.getHolder().orElseThrow());
		map.put(TreeFeatures.PINE.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_PINE.getHolder().orElseThrow());
		map.put(TreeFeatures.JUNGLE_TREE.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_JUNGLE_TREE.getHolder().orElseThrow());
		map.put(TreeFeatures.FANCY_OAK.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_FANCY_OAK.getHolder().orElseThrow());
		map.put(TreeFeatures.JUNGLE_TREE_NO_VINE.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_JUNGLE_TREE_NO_VINE.getHolder().orElseThrow());
		map.put(TreeFeatures.MEGA_JUNGLE_TREE.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_MEGA_JUNGLE_TREE.getHolder().orElseThrow());
		map.put(TreeFeatures.MEGA_SPRUCE.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_MEGA_SPRUCE.getHolder().orElseThrow());
		map.put(TreeFeatures.MEGA_PINE.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_MEGA_PINE.getHolder().orElseThrow());
		map.put(TreeFeatures.SUPER_BIRCH_BEES_0002.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_SUPER_BIRCH_BEES_0002.getHolder().orElseThrow());
		map.put(TreeFeatures.SUPER_BIRCH_BEES.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_SUPER_BIRCH_BEES.getHolder().orElseThrow());
		map.put(TreeFeatures.SWAMP_OAK.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_SWAMP_OAK.getHolder().orElseThrow());
		map.put(TreeFeatures.JUNGLE_BUSH.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_JUNGLE_BUSH.getHolder().orElseThrow());
		map.put(TreeFeatures.AZALEA_TREE.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_AZALEA_TREE.getHolder().orElseThrow());
		map.put(TreeFeatures.OAK_BEES_0002.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_OAK_BEES_0002.getHolder().orElseThrow());
		map.put(TreeFeatures.OAK_BEES_002.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_OAK_BEES_002.getHolder().orElseThrow());
		map.put(TreeFeatures.OAK_BEES_005.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_OAK_BEES_005.getHolder().orElseThrow());
		map.put(TreeFeatures.BIRCH_BEES_0002.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_BIRCH_BEES_0002.getHolder().orElseThrow());
		map.put(TreeFeatures.BIRCH_BEES_002.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_BIRCH_BEES_002.getHolder().orElseThrow());
		map.put(TreeFeatures.BIRCH_BEES_005.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_BIRCH_BEES_005.getHolder().orElseThrow());
		map.put(TreeFeatures.FANCY_OAK_BEES_0002.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_FANCY_OAK_BEES_0002.getHolder().orElseThrow());
		map.put(TreeFeatures.FANCY_OAK_BEES_002.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_FANCY_OAK_BEES_002.getHolder().orElseThrow());
		map.put(TreeFeatures.FANCY_OAK_BEES_005.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_FANCY_OAK_BEES_005.getHolder().orElseThrow());
		map.put(TreeFeatures.FANCY_OAK_BEES.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_FANCY_OAK_BEES.getHolder().orElseThrow());
		map.put(TreeFeatures.CRIMSON_FUNGUS_PLANTED.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_CRIMSON_FUNGUS_PLANTED.getHolder().orElseThrow());
		map.put(TreeFeatures.WARPED_FUNGUS_PLANTED.unwrapKey().orElseThrow().location(), () -> DenseTreeFeatures.DENSE_WARPED_FUNGUS_PLANTED.getHolder().orElseThrow());
		return map;
	}
}
