package com.mrbysco.densetrees.handler;

import com.mrbysco.densetrees.config.DenseConfig;
import com.mrbysco.densetrees.world.DenseTreeFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.event.level.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SaplingHandler {
	private static final Map<ResourceLocation, Supplier<ResourceKey<ConfiguredFeature<?, ?>>>> changeFeatureMap = populateMap();

	@SubscribeEvent
	public void saplingGrowEvent(SaplingGrowTreeEvent event) {
		LevelAccessor levelAccessor = event.getLevel();
		if (DenseConfig.COMMON.enableSaplingToDenseTree.get() && levelAccessor.getRandom().nextDouble() <= DenseConfig.COMMON.saplingToDenseTreeChance.get() && event.getFeature() != null) {
			ResourceKey<? extends ConfiguredFeature<?, ?>> unwrappedKey = event.getFeature().unwrapKey().orElse(null);
			if (unwrappedKey != null && changeFeatureMap.containsKey(unwrappedKey.location())) {
				ResourceKey<ConfiguredFeature<?, ?>> denseConfiguredFeature = changeFeatureMap.getOrDefault(unwrappedKey.location(), () -> null).get();
				if (denseConfiguredFeature != null)
					event.setFeature(denseConfiguredFeature);
			}
		}
	}

	public static Map<ResourceLocation, Supplier<ResourceKey<ConfiguredFeature<?, ?>>>> populateMap() {
		Map<ResourceLocation, Supplier<ResourceKey<ConfiguredFeature<?, ?>>>> map = new HashMap<>();
		map.put(TreeFeatures.OAK.location(), () -> DenseTreeFeatures.DENSE_OAK);
		map.put(TreeFeatures.DARK_OAK.location(), () -> DenseTreeFeatures.DENSE_DARK_OAK);
		map.put(TreeFeatures.BIRCH.location(), () -> DenseTreeFeatures.DENSE_BIRCH);
		map.put(TreeFeatures.ACACIA.location(), () -> DenseTreeFeatures.DENSE_ACACIA);
		map.put(TreeFeatures.SPRUCE.location(), () -> DenseTreeFeatures.DENSE_SPRUCE);
		map.put(TreeFeatures.PINE.location(), () -> DenseTreeFeatures.DENSE_PINE);
		map.put(TreeFeatures.JUNGLE_TREE.location(), () -> DenseTreeFeatures.DENSE_JUNGLE_TREE);
		map.put(TreeFeatures.FANCY_OAK.location(), () -> DenseTreeFeatures.DENSE_FANCY_OAK);
		map.put(TreeFeatures.JUNGLE_TREE_NO_VINE.location(), () -> DenseTreeFeatures.DENSE_JUNGLE_TREE_NO_VINE);
		map.put(TreeFeatures.MEGA_JUNGLE_TREE.location(), () -> DenseTreeFeatures.DENSE_MEGA_JUNGLE_TREE);
		map.put(TreeFeatures.MEGA_SPRUCE.location(), () -> DenseTreeFeatures.DENSE_MEGA_SPRUCE);
		map.put(TreeFeatures.MEGA_PINE.location(), () -> DenseTreeFeatures.DENSE_MEGA_PINE);
		map.put(TreeFeatures.SUPER_BIRCH_BEES_0002.location(), () -> DenseTreeFeatures.DENSE_SUPER_BIRCH_BEES_0002);
		map.put(TreeFeatures.SUPER_BIRCH_BEES.location(), () -> DenseTreeFeatures.DENSE_SUPER_BIRCH_BEES);
		map.put(TreeFeatures.SWAMP_OAK.location(), () -> DenseTreeFeatures.DENSE_SWAMP_OAK);
		map.put(TreeFeatures.JUNGLE_BUSH.location(), () -> DenseTreeFeatures.DENSE_JUNGLE_BUSH);
		map.put(TreeFeatures.AZALEA_TREE.location(), () -> DenseTreeFeatures.DENSE_AZALEA_TREE);
		map.put(TreeFeatures.MANGROVE.location(), () -> DenseTreeFeatures.DENSE_MANGROVE);
		map.put(TreeFeatures.TALL_MANGROVE.location(), () -> DenseTreeFeatures.DENSE_TALL_MANGROVE);
		map.put(TreeFeatures.OAK_BEES_0002.location(), () -> DenseTreeFeatures.DENSE_OAK_BEES_0002);
		map.put(TreeFeatures.OAK_BEES_002.location(), () -> DenseTreeFeatures.DENSE_OAK_BEES_002);
		map.put(TreeFeatures.OAK_BEES_005.location(), () -> DenseTreeFeatures.DENSE_OAK_BEES_005);
		map.put(TreeFeatures.BIRCH_BEES_0002.location(), () -> DenseTreeFeatures.DENSE_BIRCH_BEES_0002);
		map.put(TreeFeatures.BIRCH_BEES_002.location(), () -> DenseTreeFeatures.DENSE_BIRCH_BEES_002);
		map.put(TreeFeatures.BIRCH_BEES_005.location(), () -> DenseTreeFeatures.DENSE_BIRCH_BEES_005);
		map.put(TreeFeatures.FANCY_OAK_BEES_0002.location(), () -> DenseTreeFeatures.DENSE_FANCY_OAK_BEES_0002);
		map.put(TreeFeatures.FANCY_OAK_BEES_002.location(), () -> DenseTreeFeatures.DENSE_FANCY_OAK_BEES_002);
		map.put(TreeFeatures.FANCY_OAK_BEES_005.location(), () -> DenseTreeFeatures.DENSE_FANCY_OAK_BEES_005);
		map.put(TreeFeatures.FANCY_OAK_BEES.location(), () -> DenseTreeFeatures.DENSE_FANCY_OAK_BEES);
		map.put(TreeFeatures.CRIMSON_FUNGUS_PLANTED.location(), () -> DenseTreeFeatures.DENSE_CRIMSON_FUNGUS_PLANTED);
		map.put(TreeFeatures.WARPED_FUNGUS_PLANTED.location(), () -> DenseTreeFeatures.DENSE_WARPED_FUNGUS_PLANTED);
		return map;
	}
}
