package com.mrbysco.densetrees.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;

import java.util.List;

public class DensePlacedFeatures {
	public static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

	public static final ResourceKey<PlacedFeature> DENSE_DARK_FOREST_VEGETATION = PlacementUtils.createKey("densetrees:dense_dark_forest_vegetation");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_PLAINS = PlacementUtils.createKey("densetrees:dense_trees_plains");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_FLOWER_FOREST = PlacementUtils.createKey("densetrees:dense_trees_flower_forest");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_MEADOW = PlacementUtils.createKey("densetrees:dense_trees_meadow");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_TAIGA = PlacementUtils.createKey("densetrees:dense_trees_taiga");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_GROVE = PlacementUtils.createKey("densetrees:dense_trees_grove");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_BADLANDS = PlacementUtils.createKey("densetrees:dense_trees_badlands");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_SNOWY = PlacementUtils.createKey("densetrees:dense_trees_snowy");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_SWAMP = PlacementUtils.createKey("densetrees:dense_trees_swamp");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_WINDSWEPT_SAVANNA = PlacementUtils.createKey("densetrees:dense_trees_windswept_savanna");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_SAVANNA = PlacementUtils.createKey("densetrees:dense_trees_savanna");
	public static final ResourceKey<PlacedFeature> DENSE_BIRCH_TALL = PlacementUtils.createKey("densetrees:dense_birch_tall");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_BIRCH = PlacementUtils.createKey("densetrees:dense_trees_birch");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_WINDSWEPT_FOREST = PlacementUtils.createKey("densetrees:dense_trees_windswept_forest");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_WINDSWEPT_HILLS = PlacementUtils.createKey("densetrees:dense_trees_windswept_hills");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_WATER = PlacementUtils.createKey("densetrees:dense_trees_water");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_BIRCH_AND_OAK = PlacementUtils.createKey("densetrees:dense_trees_birch_and_oak");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_SPARSE_JUNGLE = PlacementUtils.createKey("densetrees:dense_trees_sparse_jungle");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_OLD_GROWTH_SPRUCE_TAIGA = PlacementUtils.createKey("densetrees:dense_trees_old_growth_spruce_taiga");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_OLD_GROWTH_PINE_TAIGA = PlacementUtils.createKey("densetrees:dense_trees_old_growth_pine_taiga");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_JUNGLE = PlacementUtils.createKey("densetrees:dense_trees_jungle");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_MANGROVE = PlacementUtils.createKey("densetrees:dense_trees_mangrove");
	public static final ResourceKey<PlacedFeature> DENSE_TREES_CHERRY = PlacementUtils.createKey("densetrees:dense_trees_cherry");
	public static final ResourceKey<PlacedFeature> DENSE_CRIMSON_FUNGI = PlacementUtils.createKey("densetrees:dense_crimson_fungi");
	public static final ResourceKey<PlacedFeature> DENSE_WARPED_FUNGI = PlacementUtils.createKey("densetrees:dense_warped_fungi");


	public static void bootstrap(BootstapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?, ?>> configuredGetter = context.lookup(Registries.CONFIGURED_FEATURE);

		PlacementUtils.register(context, DENSE_DARK_FOREST_VEGETATION, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_DARK_FOREST_VEGETATION), CountPlacement.of(16), InSquarePlacement.spread(), TREE_THRESHOLD, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, RarityFilter.onAverageOnceEvery(10), BiomeFilter.biome());
		PlacementUtils.register(context, DENSE_TREES_PLAINS, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_TREES_PLAINS), PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), TREE_THRESHOLD, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, RarityFilter.onAverageOnceEvery(10), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());
		PlacementUtils.register(context, DENSE_TREES_FLOWER_FOREST, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_TREES_FLOWER_FOREST), denseTreePlacement(PlacementUtils.countExtra(6, 0.1F, 1)));
		PlacementUtils.register(context, DENSE_TREES_MEADOW, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_MEADOW_TREES), denseTreePlacement(RarityFilter.onAverageOnceEvery(100)));
		PlacementUtils.register(context, DENSE_TREES_TAIGA, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_TREES_TAIGA), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		PlacementUtils.register(context, DENSE_TREES_GROVE, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_TREES_GROVE), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		PlacementUtils.register(context, DENSE_TREES_BADLANDS, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_OAK), denseTreePlacement(PlacementUtils.countExtra(5, 0.1F, 1), Blocks.OAK_SAPLING));
		PlacementUtils.register(context, DENSE_TREES_SNOWY, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_SPRUCE), denseTreePlacement(PlacementUtils.countExtra(0, 0.1F, 1), Blocks.SPRUCE_SAPLING));
		PlacementUtils.register(context, DENSE_TREES_SWAMP, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_SWAMP_OAK), PlacementUtils.countExtra(2, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(2), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, RarityFilter.onAverageOnceEvery(10), BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)));
		PlacementUtils.register(context, DENSE_TREES_WINDSWEPT_SAVANNA, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_TREES_SAVANNA), denseTreePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
		PlacementUtils.register(context, DENSE_TREES_SAVANNA, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_TREES_SAVANNA), denseTreePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		PlacementUtils.register(context, DENSE_BIRCH_TALL, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_BIRCH_TALL), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		PlacementUtils.register(context, DENSE_TREES_BIRCH, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_BIRCH_BEES_0002), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1), Blocks.BIRCH_SAPLING));
		PlacementUtils.register(context, DENSE_TREES_WINDSWEPT_FOREST, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_TREES_WINDSWEPT_HILLS), denseTreePlacement(PlacementUtils.countExtra(3, 0.1F, 1)));
		PlacementUtils.register(context, DENSE_TREES_WINDSWEPT_HILLS, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_TREES_WINDSWEPT_HILLS), denseTreePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
		PlacementUtils.register(context, DENSE_TREES_WATER, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_TREES_WATER), denseTreePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
		PlacementUtils.register(context, DENSE_TREES_BIRCH_AND_OAK, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_TREES_BIRCH_AND_OAK), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		PlacementUtils.register(context, DENSE_TREES_SPARSE_JUNGLE, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_TREES_SPARSE_JUNGLE), denseTreePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
		PlacementUtils.register(context, DENSE_TREES_OLD_GROWTH_SPRUCE_TAIGA, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_TREES_OLD_GROWTH_SPRUCE_TAIGA), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		PlacementUtils.register(context, DENSE_TREES_OLD_GROWTH_PINE_TAIGA, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_TREES_OLD_GROWTH_PINE_TAIGA), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		PlacementUtils.register(context, DENSE_TREES_JUNGLE, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_TREES_JUNGLE), denseTreePlacement(PlacementUtils.countExtra(50, 0.1F, 1)));
		PlacementUtils.register(context, DENSE_TREES_MANGROVE, configuredGetter.getOrThrow(DenseVegetationFeatures.DENSE_MANGROVE_VEGETATION), CountPlacement.of(25), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(5), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, RarityFilter.onAverageOnceEvery(10), BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.MANGROVE_PROPAGULE.defaultBlockState(), BlockPos.ZERO)));
		PlacementUtils.register(context, DENSE_TREES_CHERRY, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_CHERRY_BEES_005), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1), Blocks.CHERRY_SAPLING));
		PlacementUtils.register(context, DENSE_CRIMSON_FUNGI, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_CRIMSON_FUNGUS), CountOnEveryLayerPlacement.of(8), BiomeFilter.biome(), RarityFilter.onAverageOnceEvery(5));
		PlacementUtils.register(context, DENSE_WARPED_FUNGI, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_WARPED_FUNGUS), CountOnEveryLayerPlacement.of(8), BiomeFilter.biome(), RarityFilter.onAverageOnceEvery(5));
	}

	private static ImmutableList.Builder<PlacementModifier> denseTreePlacementBase(PlacementModifier placementModifier) {
		return ImmutableList.<PlacementModifier>builder()
				.add(placementModifier)
				.add(InSquarePlacement.spread())
				.add(TREE_THRESHOLD)
				.add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)
				.add(BiomeFilter.biome())
				.add(RarityFilter.onAverageOnceEvery(10));
	}

	public static List<PlacementModifier> denseTreePlacement(PlacementModifier placementModifier) {
		return denseTreePlacementBase(placementModifier).build();
	}

	public static List<PlacementModifier> denseTreePlacement(PlacementModifier placementModifier, Block sapling) {
		return denseTreePlacementBase(placementModifier)
				.add(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(sapling.defaultBlockState(), BlockPos.ZERO))).build();
	}
}
