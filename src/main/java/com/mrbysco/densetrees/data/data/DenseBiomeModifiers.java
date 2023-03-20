package com.mrbysco.densetrees.data.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.modifier.AddDenseVariationBiomeModifier;
import com.mrbysco.densetrees.world.DenseTreeFeatures;
import com.mrbysco.densetrees.world.DenseVegetationFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
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
import net.minecraftforge.common.world.BiomeModifier;

import java.util.List;
import java.util.Map;

public class DenseBiomeModifiers {
	public static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

	public static Map<ResourceLocation, PlacedFeature> getPlacedFeatures(RegistryOps<JsonElement> ops) {
		Map<ResourceLocation, PlacedFeature> map = Maps.newHashMap();

		generatePlacedFeature(ops, map, "dense_dark_forest_vegetation", DenseVegetationFeatures.DENSE_DARK_FOREST_VEGETATION.getHolder().orElseThrow(), CountPlacement.of(16), InSquarePlacement.spread(), TREE_THRESHOLD, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, RarityFilter.onAverageOnceEvery(10), BiomeFilter.biome());
		generatePlacedFeature(ops, map, "dense_trees_plains", DenseVegetationFeatures.DENSE_TREES_PLAINS.getHolder().orElseThrow(), PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), TREE_THRESHOLD, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, RarityFilter.onAverageOnceEvery(10), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());
		generatePlacedFeature(ops, map, "dense_trees_flower_forest", DenseVegetationFeatures.DENSE_TREES_FLOWER_FOREST.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(6, 0.1F, 1)));
		generatePlacedFeature(ops, map, "dense_trees_meadow", DenseVegetationFeatures.DENSE_MEADOW_TREES.getHolder().orElseThrow(), denseTreePlacement(RarityFilter.onAverageOnceEvery(100)));
		generatePlacedFeature(ops, map, "dense_trees_taiga", DenseVegetationFeatures.DENSE_TREES_TAIGA.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		generatePlacedFeature(ops, map, "dense_trees_grove", DenseVegetationFeatures.DENSE_TREES_GROVE.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		generatePlacedFeature(ops, map, "dense_trees_badlands", DenseTreeFeatures.DENSE_OAK.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(5, 0.1F, 1), Blocks.OAK_SAPLING));
		generatePlacedFeature(ops, map, "dense_trees_snowy", DenseTreeFeatures.DENSE_SPRUCE.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(0, 0.1F, 1), Blocks.SPRUCE_SAPLING));
		generatePlacedFeature(ops, map, "dense_trees_swamp", DenseTreeFeatures.DENSE_SWAMP_OAK.getHolder().orElseThrow(), PlacementUtils.countExtra(2, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(2), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, RarityFilter.onAverageOnceEvery(10), BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)));
		generatePlacedFeature(ops, map, "dense_trees_windswept_savanna", DenseVegetationFeatures.DENSE_TREES_SAVANNA.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
		generatePlacedFeature(ops, map, "dense_trees_savanna", DenseVegetationFeatures.DENSE_TREES_SAVANNA.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		generatePlacedFeature(ops, map, "dense_birch_tall", DenseVegetationFeatures.DENSE_BIRCH_TALL.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		generatePlacedFeature(ops, map, "dense_trees_birch", DenseTreeFeatures.DENSE_BIRCH_BEES_0002.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1), Blocks.BIRCH_SAPLING));
		generatePlacedFeature(ops, map, "dense_trees_windswept_forest", DenseVegetationFeatures.DENSE_TREES_WINDSWEPT_HILLS.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(3, 0.1F, 1)));
		generatePlacedFeature(ops, map, "dense_trees_windswept_hills", DenseVegetationFeatures.DENSE_TREES_WINDSWEPT_HILLS.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
		generatePlacedFeature(ops, map, "dense_trees_water", DenseVegetationFeatures.DENSE_TREES_WATER.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
		generatePlacedFeature(ops, map, "dense_trees_birch_and_oak", DenseVegetationFeatures.DENSE_TREES_BIRCH_AND_OAK.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		generatePlacedFeature(ops, map, "dense_trees_sparse_jungle", DenseVegetationFeatures.DENSE_TREES_SPARSE_JUNGLE.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
		generatePlacedFeature(ops, map, "dense_trees_old_growth_spruce_taiga", DenseVegetationFeatures.DENSE_TREES_OLD_GROWTH_SPRUCE_TAIGA.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		generatePlacedFeature(ops, map, "dense_trees_old_growth_pine_taiga", DenseVegetationFeatures.DENSE_TREES_OLD_GROWTH_PINE_TAIGA.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		generatePlacedFeature(ops, map, "dense_trees_jungle", DenseVegetationFeatures.DENSE_TREES_JUNGLE.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(50, 0.1F, 1)));
		generatePlacedFeature(ops, map, "dense_trees_mangrove", DenseVegetationFeatures.DENSE_MANGROVE_VEGETATION.getHolder().orElseThrow(), CountPlacement.of(25), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(5), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, RarityFilter.onAverageOnceEvery(10), BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.MANGROVE_PROPAGULE.defaultBlockState(), BlockPos.ZERO)));
		generatePlacedFeature(ops, map, "dense_crimson_fungi", DenseTreeFeatures.DENSE_CRIMSON_FUNGUS.getHolder().orElseThrow(), CountOnEveryLayerPlacement.of(8), BiomeFilter.biome(), RarityFilter.onAverageOnceEvery(5));
		generatePlacedFeature(ops, map, "dense_warped_fungi", DenseTreeFeatures.DENSE_WARPED_FUNGUS.getHolder().orElseThrow(), CountOnEveryLayerPlacement.of(8), BiomeFilter.biome(), RarityFilter.onAverageOnceEvery(5));

		return map;
	}

	private static void generatePlacedFeature(RegistryOps<JsonElement> ops, Map<ResourceLocation, PlacedFeature> map, String name, Holder<ConfiguredFeature<?, ?>> holder, PlacementModifier... modifiers) {
		generatePlacedFeature(ops, map, name, holder, List.of(modifiers));
	}

	private static void generatePlacedFeature(RegistryOps<JsonElement> ops, Map<ResourceLocation, PlacedFeature> map, String name, Holder<ConfiguredFeature<?, ?>> holder, List<PlacementModifier> modifiers) {
		final Holder<ConfiguredFeature<?, ?>> featureKeyHolder = ops.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get()
				.getOrCreateHolderOrThrow(holder.unwrapKey().get().cast(Registry.CONFIGURED_FEATURE_REGISTRY).get());
		final PlacedFeature feature = new PlacedFeature(featureKeyHolder, modifiers);
		map.put(new ResourceLocation(DenseTrees.MOD_ID, name), feature);
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

	public static Map<ResourceLocation, BiomeModifier> getBiomeModifiers(RegistryOps<JsonElement> ops) {
		Map<ResourceLocation, BiomeModifier> map = Maps.newHashMap();
		final HolderSet.Named<Biome> overworld = new HolderSet.Named<>(ops.registry(Registry.BIOME_REGISTRY).get(), BiomeTags.IS_OVERWORLD);
		addDenseVariation(ops, map, overworld, "dark_forest_vegetation", "dense_dark_forest_vegetation");
		addDenseVariation(ops, map, overworld, "trees_flower_forest", "dense_trees_flower_forest");
		addDenseVariation(ops, map, overworld, "trees_meadow", "dense_trees_meadow");
		addDenseVariation(ops, map, overworld, "trees_taiga", "dense_trees_taiga");
		addDenseVariation(ops, map, overworld, "trees_grove", "dense_trees_grove");
		addDenseVariation(ops, map, overworld, "trees_badlands", "dense_trees_badlands");
		addDenseVariation(ops, map, overworld, "trees_snowy", "dense_trees_snowy");
		addDenseVariation(ops, map, overworld, "trees_swamp", "dense_trees_swamp");
		addDenseVariation(ops, map, overworld, "trees_windswept_savanna", "dense_trees_windswept_savanna");
		addDenseVariation(ops, map, overworld, "trees_savanna", "dense_trees_savanna");
		addDenseVariation(ops, map, overworld, "birch_tall", "dense_birch_tall");
		addDenseVariation(ops, map, overworld, "trees_birch", "dense_trees_birch");
		addDenseVariation(ops, map, overworld, "trees_windswept_forest", "dense_trees_windswept_forest");
		addDenseVariation(ops, map, overworld, "trees_windswept_hills", "dense_trees_windswept_hills");
		addDenseVariation(ops, map, overworld, "trees_water", "dense_trees_water");
		addDenseVariation(ops, map, overworld, "trees_plains", "dense_trees_plains");
		addDenseVariation(ops, map, overworld, "trees_birch_and_oak", "dense_trees_birch_and_oak");
		addDenseVariation(ops, map, overworld, "trees_sparse_jungle", "dense_trees_sparse_jungle");
		addDenseVariation(ops, map, overworld, "trees_old_growth_spruce_taiga", "dense_trees_old_growth_spruce_taiga");
		addDenseVariation(ops, map, overworld, "trees_old_growth_pine_taiga", "dense_trees_old_growth_pine_taiga");
		addDenseVariation(ops, map, overworld, "trees_jungle", "dense_trees_jungle");
		addDenseVariation(ops, map, overworld, "trees_mangrove", "dense_trees_mangrove");
		final HolderSet.Named<Biome> nether = new HolderSet.Named<>(ops.registry(Registry.BIOME_REGISTRY).get(), BiomeTags.IS_NETHER);
		addDenseVariation(ops, map, nether, "crimson_fungi", "dense_crimson_fungi");
		addDenseVariation(ops, map, nether, "warped_fungi", "dense_warped_fungi");

		return map;
	}

	private static void addDenseVariation(RegistryOps<JsonElement> ops, Map<ResourceLocation, BiomeModifier> map, HolderSet.Named<Biome> biomeSet, String original, String densePath) {
		final ResourceLocation denseLocation = new ResourceLocation(DenseTrees.MOD_ID, densePath);
		final BiomeModifier addDenseVariationBiomeModifier = new AddDenseVariationBiomeModifier(
				biomeSet,
				ops.registry(Registry.PLACED_FEATURE_REGISTRY).get()
						.getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, new ResourceLocation(original))),
				ops.registry(Registry.PLACED_FEATURE_REGISTRY).get()
						.getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, denseLocation))
		);
		map.put(denseLocation, addDenseVariationBiomeModifier);
	}
}
