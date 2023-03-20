//package com.mrbysco.densetrees.world;
//
//import com.google.common.collect.ImmutableList;
//import com.mrbysco.densetrees.DenseTrees;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Holder;
//import net.minecraft.core.Registry;
//import net.minecraft.data.worldgen.placement.PlacementUtils;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
//import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
//import net.minecraft.world.level.levelgen.placement.BiomeFilter;
//import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
//import net.minecraft.world.level.levelgen.placement.CountPlacement;
//import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
//import net.minecraft.world.level.levelgen.placement.PlacedFeature;
//import net.minecraft.world.level.levelgen.placement.PlacementModifier;
//import net.minecraft.world.level.levelgen.placement.RarityFilter;
//import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.RegistryObject;
//
//import java.util.List;
//import java.util.function.Supplier;
//
//public class DenseVegetationPlacements {
//	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DenseTrees.MOD_ID);
//
//	public static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);
//
//	public static final RegistryObject<PlacedFeature> DENSE_DARK_FOREST_VEGETATION = register("dense_dark_forest_vegetation", DenseVegetationFeatures.DENSE_DARK_FOREST_VEGETATION.getHolder().orElseThrow(), CountPlacement.of(16), InSquarePlacement.spread(), TREE_THRESHOLD, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_PLAINS = register("dense_trees_plains", DenseVegetationFeatures.DENSE_TREES_PLAINS.getHolder().orElseThrow(), PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), TREE_THRESHOLD, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_FLOWER_FOREST = register("dense_trees_flower_forest", DenseVegetationFeatures.DENSE_TREES_FLOWER_FOREST.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(6, 0.1F, 1)));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_MEADOW = register("dense_trees_meadow", DenseVegetationFeatures.DENSE_MEADOW_TREES.getHolder().orElseThrow(), denseTreePlacement(RarityFilter.onAverageOnceEvery(100)));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_TAIGA = register("dense_trees_taiga", DenseVegetationFeatures.DENSE_TREES_TAIGA.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_GROVE = register("dense_trees_grove", DenseVegetationFeatures.DENSE_TREES_GROVE.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_BADLANDS = register("dense_trees_badlands", DenseTreeFeatures.DENSE_OAK.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(5, 0.1F, 1), Blocks.OAK_SAPLING));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_SNOWY = register("dense_trees_snowy", DenseTreeFeatures.DENSE_SPRUCE.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(0, 0.1F, 1), Blocks.SPRUCE_SAPLING));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_SWAMP = register("dense_trees_swamp", DenseTreeFeatures.DENSE_SWAMP_OAK.getHolder().orElseThrow(), PlacementUtils.countExtra(2, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(2), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_WINDSWEPT_SAVANNA = register("dense_trees_windswept_savanna", DenseVegetationFeatures.DENSE_TREES_SAVANNA.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_SAVANNA = register("dense_trees_savanna", DenseVegetationFeatures.DENSE_TREES_SAVANNA.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
//	public static final RegistryObject<PlacedFeature> DENSE_BIRCH_TALL = register("dense_birch_tall", DenseVegetationFeatures.DENSE_BIRCH_TALL.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_BIRCH = register("dense_trees_birch", DenseTreeFeatures.DENSE_BIRCH_BEES_0002.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1), Blocks.BIRCH_SAPLING));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_WINDSWEPT_FOREST = register("dense_trees_windswept_forest", DenseVegetationFeatures.DENSE_TREES_WINDSWEPT_HILLS.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(3, 0.1F, 1)));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_WINDSWEPT_HILLS = register("dense_trees_windswept_hills", DenseVegetationFeatures.DENSE_TREES_WINDSWEPT_HILLS.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_WATER = register("dense_trees_water", DenseVegetationFeatures.DENSE_TREES_WATER.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_BIRCH_AND_OAK = register("dense_trees_birch_and_oak", DenseVegetationFeatures.DENSE_TREES_BIRCH_AND_OAK.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_SPARSE_JUNGLE = register("dense_trees_sparse_jungle", DenseVegetationFeatures.DENSE_TREES_SPARSE_JUNGLE.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_OLD_GROWTH_SPRUCE_TAIGA = register("dense_trees_old_growth_spruce_taiga", DenseVegetationFeatures.DENSE_TREES_OLD_GROWTH_SPRUCE_TAIGA.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_OLD_GROWTH_PINE_TAIGA = register("dense_trees_old_growth_pine_taiga", DenseVegetationFeatures.DENSE_TREES_OLD_GROWTH_PINE_TAIGA.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
//	public static final RegistryObject<PlacedFeature> DENSE_TREES_JUNGLE = register("dense_trees_jungle", DenseVegetationFeatures.DENSE_TREES_JUNGLE.getHolder().orElseThrow(), denseTreePlacement(PlacementUtils.countExtra(50, 0.1F, 1)));
//
//	private static RegistryObject<PlacedFeature> register(String registryName,
//														  Holder<? extends ConfiguredFeature<?, ?>> configuredHolder,
//														  List<PlacementModifier> placementModifiers) {
//		return PLACED_FEATURES.register(registryName, () -> new PlacedFeature(Holder.hackyErase(configuredHolder), List.copyOf(placementModifiers)));
//	}
//
//	private static RegistryObject<PlacedFeature> register(String registryName,
//														  Holder<? extends ConfiguredFeature<?, ?>> configuredHolder,
//														  Supplier<List<PlacementModifier>> placementModifiers) {
//		return PLACED_FEATURES.register(registryName, () -> new PlacedFeature(Holder.hackyErase(configuredHolder), List.copyOf(placementModifiers.get())));
//	}
//
//	private static RegistryObject<PlacedFeature> register(String registryName,
//														  Holder<? extends ConfiguredFeature<?, ?>> configuredHolder,
//														  PlacementModifier... placementModifiers) {
//		return PLACED_FEATURES.register(registryName, () -> new PlacedFeature(Holder.hackyErase(configuredHolder), List.of(placementModifiers)));
//	}
//
//	private static ImmutableList.Builder<PlacementModifier> denseTreePlacementBase(PlacementModifier placementModifier) {
//		return ImmutableList.<PlacementModifier>builder()
//				.add(placementModifier)
//				.add(InSquarePlacement.spread())
//				.add(TREE_THRESHOLD)
//				.add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)
//				.add(BiomeFilter.biome())
//				.add(RarityFilter.onAverageOnceEvery(10))
//				;
//	}
//
//	public static List<PlacementModifier> denseTreePlacement(PlacementModifier placementModifier) {
//		return denseTreePlacementBase(placementModifier).build();
//	}
//
//	public static List<PlacementModifier> denseTreePlacement(PlacementModifier placementModifier, Block sapling) {
//		return denseTreePlacementBase(placementModifier)
//				.add(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(sapling.defaultBlockState(), BlockPos.ZERO))).build();
//	}
//}
