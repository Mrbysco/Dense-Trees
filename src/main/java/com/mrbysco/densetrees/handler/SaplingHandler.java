package com.mrbysco.densetrees.handler;

import com.mrbysco.densetrees.config.DenseConfig;
import com.mrbysco.densetrees.world.DenseTreeFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.BlockGrowFeatureEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SaplingHandler {
	private static final Map<Identifier, Supplier<ResourceKey<ConfiguredFeature<?, ?>>>> changeFeatureMap = populateMap();

	@SubscribeEvent
	public void saplingGrowEvent(BlockGrowFeatureEvent event) {
		LevelAccessor levelAccessor = event.getLevel();
		if (DenseConfig.COMMON.enableSaplingToDenseTree.get() && levelAccessor.getRandom().nextDouble() <= DenseConfig.COMMON.saplingToDenseTreeChance.get() && event.getFeature() != null) {
			ResourceKey<? extends ConfiguredFeature<?, ?>> unwrappedKey = event.getFeature().unwrapKey().orElse(null);
			if (unwrappedKey != null && changeFeatureMap.containsKey(unwrappedKey.identifier())) {
				ResourceKey<ConfiguredFeature<?, ?>> denseConfiguredFeature = changeFeatureMap.getOrDefault(unwrappedKey.identifier(), () -> null).get();
				if (denseConfiguredFeature != null)
					event.setFeature(denseConfiguredFeature);
			}
		}
	}

	private static Map<Identifier, Supplier<ResourceKey<ConfiguredFeature<?, ?>>>> populateMap() {
		Map<Identifier, Supplier<ResourceKey<ConfiguredFeature<?, ?>>>> map = new HashMap<>();
		map.put(TreeFeatures.OAK.identifier(), () -> DenseTreeFeatures.DENSE_OAK);
		map.put(TreeFeatures.DARK_OAK.identifier(), () -> DenseTreeFeatures.DENSE_DARK_OAK);
		map.put(TreeFeatures.BIRCH.identifier(), () -> DenseTreeFeatures.DENSE_BIRCH);
		map.put(TreeFeatures.ACACIA.identifier(), () -> DenseTreeFeatures.DENSE_ACACIA);
		map.put(TreeFeatures.SPRUCE.identifier(), () -> DenseTreeFeatures.DENSE_SPRUCE);
		map.put(TreeFeatures.PINE.identifier(), () -> DenseTreeFeatures.DENSE_PINE);
		map.put(TreeFeatures.JUNGLE_TREE.identifier(), () -> DenseTreeFeatures.DENSE_JUNGLE_TREE);
		map.put(TreeFeatures.FANCY_OAK.identifier(), () -> DenseTreeFeatures.DENSE_FANCY_OAK);
		map.put(TreeFeatures.JUNGLE_TREE_NO_VINE.identifier(), () -> DenseTreeFeatures.DENSE_JUNGLE_TREE_NO_VINE);
		map.put(TreeFeatures.MEGA_JUNGLE_TREE.identifier(), () -> DenseTreeFeatures.DENSE_MEGA_JUNGLE_TREE);
		map.put(TreeFeatures.MEGA_SPRUCE.identifier(), () -> DenseTreeFeatures.DENSE_MEGA_SPRUCE);
		map.put(TreeFeatures.MEGA_PINE.identifier(), () -> DenseTreeFeatures.DENSE_MEGA_PINE);
		map.put(TreeFeatures.SUPER_BIRCH_BEES_0002.identifier(), () -> DenseTreeFeatures.DENSE_SUPER_BIRCH_BEES_0002);
		map.put(TreeFeatures.SUPER_BIRCH_BEES.identifier(), () -> DenseTreeFeatures.DENSE_SUPER_BIRCH_BEES);
		map.put(TreeFeatures.SWAMP_OAK.identifier(), () -> DenseTreeFeatures.DENSE_SWAMP_OAK);
		map.put(TreeFeatures.JUNGLE_BUSH.identifier(), () -> DenseTreeFeatures.DENSE_JUNGLE_BUSH);
		map.put(TreeFeatures.AZALEA_TREE.identifier(), () -> DenseTreeFeatures.DENSE_AZALEA_TREE);
		map.put(TreeFeatures.MANGROVE.identifier(), () -> DenseTreeFeatures.DENSE_MANGROVE);
		map.put(TreeFeatures.TALL_MANGROVE.identifier(), () -> DenseTreeFeatures.DENSE_TALL_MANGROVE);
		map.put(TreeFeatures.CHERRY.identifier(), () -> DenseTreeFeatures.DENSE_CHERRY);
		map.put(TreeFeatures.CHERRY_BEES_005.identifier(), () -> DenseTreeFeatures.DENSE_CHERRY_BEES_005);
		map.put(TreeFeatures.OAK_BEES_0002_LEAF_LITTER.identifier(), () -> DenseTreeFeatures.DENSE_OAK_BEES_0002_LEAF_LITTER);
		map.put(TreeFeatures.OAK_BEES_002.identifier(), () -> DenseTreeFeatures.DENSE_OAK_BEES_002);
		map.put(TreeFeatures.OAK_BEES_005.identifier(), () -> DenseTreeFeatures.DENSE_OAK_BEES_005);
		map.put(TreeFeatures.BIRCH_BEES_0002.identifier(), () -> DenseTreeFeatures.DENSE_BIRCH_BEES_0002);
		map.put(TreeFeatures.BIRCH_BEES_002.identifier(), () -> DenseTreeFeatures.DENSE_BIRCH_BEES_002);
		map.put(TreeFeatures.BIRCH_BEES_005.identifier(), () -> DenseTreeFeatures.DENSE_BIRCH_BEES_005);
		map.put(TreeFeatures.FANCY_OAK_BEES_0002_LEAF_LITTER.identifier(), () -> DenseTreeFeatures.DENSE_FANCY_OAK_BEES_0002_LEAF_LITTER);
		map.put(TreeFeatures.FANCY_OAK_BEES_002.identifier(), () -> DenseTreeFeatures.DENSE_FANCY_OAK_BEES_002);
		map.put(TreeFeatures.FANCY_OAK_BEES_005.identifier(), () -> DenseTreeFeatures.DENSE_FANCY_OAK_BEES_005);
		map.put(TreeFeatures.FANCY_OAK_BEES.identifier(), () -> DenseTreeFeatures.DENSE_FANCY_OAK_BEES);
		map.put(TreeFeatures.CRIMSON_FUNGUS_PLANTED.identifier(), () -> DenseTreeFeatures.DENSE_CRIMSON_FUNGUS_PLANTED);
		map.put(TreeFeatures.WARPED_FUNGUS_PLANTED.identifier(), () -> DenseTreeFeatures.DENSE_WARPED_FUNGUS_PLANTED);

		map.put(TreeFeatures.PALE_OAK.identifier(), () -> DenseTreeFeatures.DENSE_DARK_OAK);
		map.put(TreeFeatures.PALE_OAK_BONEMEAL.identifier(), () -> DenseTreeFeatures.DENSE_DARK_OAK);
		map.put(TreeFeatures.PALE_OAK_CREAKING.identifier(), () -> DenseTreeFeatures.DENSE_DARK_OAK);
		return map;
	}
}
