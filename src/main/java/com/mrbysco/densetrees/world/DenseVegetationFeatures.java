package com.mrbysco.densetrees.world;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class DenseVegetationFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_DARK_FOREST_VEGETATION = FeatureUtils.createKey("densetrees:dense_dark_forest_vegetation");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_TREES_FLOWER_FOREST = FeatureUtils.createKey("densetrees:dense_trees_flower_forest");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_MEADOW_TREES = FeatureUtils.createKey("densetrees:dense_meadow_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_TREES_TAIGA = FeatureUtils.createKey("densetrees:dense_trees_taiga");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_TREES_GROVE = FeatureUtils.createKey("densetrees:dense_trees_grove");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_TREES_SAVANNA = FeatureUtils.createKey("densetrees:dense_trees_savanna");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_BIRCH_TALL = FeatureUtils.createKey("densetrees:dense_birch_tall");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_TREES_WINDSWEPT_HILLS = FeatureUtils.createKey("densetrees:dense_trees_windswept_hills");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_TREES_WATER = FeatureUtils.createKey("densetrees:dense_trees_water");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_TREES_BIRCH_AND_OAK = FeatureUtils.createKey("densetrees:dense_trees_birch_and_oak");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_TREES_PLAINS = FeatureUtils.createKey("densetrees:dense_trees_plains");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_TREES_SPARSE_JUNGLE = FeatureUtils.createKey("densetrees:dense_trees_sparse_jungle");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_TREES_OLD_GROWTH_SPRUCE_TAIGA = FeatureUtils.createKey("densetrees:dense_trees_old_growth_spruce_taiga");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_TREES_OLD_GROWTH_PINE_TAIGA = FeatureUtils.createKey("densetrees:dense_trees_old_growth_pine_taiga");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_TREES_JUNGLE = FeatureUtils.createKey("densetrees:dense_trees_jungle");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_MANGROVE_VEGETATION = FeatureUtils.createKey("densetrees:dense_mangrove_vegetation");

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
		HolderGetter<ConfiguredFeature<?, ?>> configuredGetter = context.lookup(Registries.CONFIGURED_FEATURE);
		HolderGetter<PlacedFeature> placedGetter = context.lookup(Registries.PLACED_FEATURE);

		FeatureUtils.register(context, DENSE_DARK_FOREST_VEGETATION, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredGetter.getOrThrow(TreeFeatures.HUGE_BROWN_MUSHROOM)), 0.025F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredGetter.getOrThrow(TreeFeatures.HUGE_RED_MUSHROOM)), 0.05F), new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_DARK_OAK_CHECKED), 0.6666667F), new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_BIRCH_CHECKED), 0.2F), new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_FANCY_OAK_CHECKED), 0.1F)), placedGetter.getOrThrow(DenseTreePlacements.DENSE_OAK_CHECKED)));
		FeatureUtils.register(context, DENSE_TREES_FLOWER_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_BIRCH_BEES_002), 0.2F), new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_FANCY_OAK_BEES_002), 0.1F)), placedGetter.getOrThrow(DenseTreePlacements.DENSE_OAK_BEES_002)));
		FeatureUtils.register(context, DENSE_MEADOW_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_FANCY_OAK_BEES), 0.5F)), placedGetter.getOrThrow(DenseTreePlacements.DENSE_SUPER_BIRCH_BEES)));
		FeatureUtils.register(context, DENSE_TREES_TAIGA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_PINE_CHECKED), 0.33333334F)), placedGetter.getOrThrow(DenseTreePlacements.DENSE_SPRUCE_CHECKED)));
		FeatureUtils.register(context, DENSE_TREES_GROVE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_PINE_ON_SNOW), 0.33333334F)), placedGetter.getOrThrow(DenseTreePlacements.DENSE_SPRUCE_ON_SNOW)));
		FeatureUtils.register(context, DENSE_TREES_SAVANNA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_ACACIA_CHECKED), 0.8F)), placedGetter.getOrThrow(DenseTreePlacements.DENSE_OAK_CHECKED)));
		FeatureUtils.register(context, DENSE_BIRCH_TALL, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_SUPER_BIRCH_BEES_0002), 0.5F)), placedGetter.getOrThrow(DenseTreePlacements.DENSE_BIRCH_BEES_0002_PLACED)));
		FeatureUtils.register(context, DENSE_TREES_WINDSWEPT_HILLS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_SPRUCE_CHECKED), 0.666F), new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_FANCY_OAK_CHECKED), 0.1F)), placedGetter.getOrThrow(DenseTreePlacements.DENSE_OAK_CHECKED)));
		FeatureUtils.register(context, DENSE_TREES_WATER, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_FANCY_OAK_CHECKED), 0.1F)), placedGetter.getOrThrow(DenseTreePlacements.DENSE_OAK_CHECKED)));
		FeatureUtils.register(context, DENSE_TREES_BIRCH_AND_OAK, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_BIRCH_BEES_0002_PLACED), 0.2F), new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_FANCY_OAK_BEES_0002), 0.1F)), placedGetter.getOrThrow(DenseTreePlacements.DENSE_OAK_BEES_0002)));
		FeatureUtils.register(context, DENSE_TREES_PLAINS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_FANCY_OAK_BEES_005)), 0.33333334F)), PlacementUtils.inlinePlaced(configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_OAK_BEES_005))));
		FeatureUtils.register(context, DENSE_TREES_SPARSE_JUNGLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_FANCY_OAK_CHECKED), 0.1F), new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_JUNGLE_BUSH), 0.5F)), placedGetter.getOrThrow(DenseTreePlacements.DENSE_JUNGLE_TREE_CHECKED)));
		FeatureUtils.register(context, DENSE_TREES_OLD_GROWTH_SPRUCE_TAIGA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_MEGA_SPRUCE_CHECKED), 0.33333334F), new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_PINE_CHECKED), 0.33333334F)), placedGetter.getOrThrow(DenseTreePlacements.DENSE_SPRUCE_CHECKED)));
		FeatureUtils.register(context, DENSE_TREES_OLD_GROWTH_PINE_TAIGA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_MEGA_SPRUCE_CHECKED), 0.025641026F), new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_MEGA_PINE_CHECKED), 0.30769232F), new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_PINE_CHECKED), 0.33333334F)), placedGetter.getOrThrow(DenseTreePlacements.DENSE_SPRUCE_CHECKED)));
		FeatureUtils.register(context, DENSE_TREES_JUNGLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_FANCY_OAK_CHECKED), 0.1F), new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_JUNGLE_BUSH), 0.5F), new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_MEGA_JUNGLE_TREE_CHECKED), 0.33333334F)), placedGetter.getOrThrow(DenseTreePlacements.DENSE_JUNGLE_TREE_CHECKED)));
		FeatureUtils.register(context, DENSE_MANGROVE_VEGETATION, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedGetter.getOrThrow(DenseTreePlacements.DENSE_TALL_MANGROVE_CHECKED), 0.85F)), placedGetter.getOrThrow(DenseTreePlacements.DENSE_MANGROVE_CHECKED)));
	}
}
