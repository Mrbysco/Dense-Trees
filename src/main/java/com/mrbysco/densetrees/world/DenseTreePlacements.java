package com.mrbysco.densetrees.world;

import com.mrbysco.densetrees.DenseTrees;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class DenseTreePlacements {
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DenseTrees.MOD_ID);

	public static final RegistryObject<PlacedFeature> DENSE_OAK_CHECKED = register("dense_oak_checked", DenseTreeFeatures.DENSE_OAK.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_DARK_OAK_CHECKED = register("dense_dark_oak_checked", DenseTreeFeatures.DENSE_DARK_OAK.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.DARK_OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_BIRCH_CHECKED = register("dense_birch_checked", DenseTreeFeatures.DENSE_BIRCH.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_ACACIA_CHECKED = register("dense_acacia_checked", DenseTreeFeatures.DENSE_ACACIA.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.ACACIA_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_SPRUCE_CHECKED = register("dense_spruce_checked", DenseTreeFeatures.DENSE_SPRUCE.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
	public static final BlockPredicate SNOW_TREE_PREDICATE = BlockPredicate.matchesBlocks(List.of(Blocks.SNOW_BLOCK, Blocks.POWDER_SNOW), new BlockPos(0, -1, 0));
	public static final List<PlacementModifier> SNOW_TREE_FILTER_DECORATOR = List.of(EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.POWDER_SNOW, BlockPos.ZERO)), 8), BlockPredicateFilter.forPredicate(SNOW_TREE_PREDICATE));
	public static final RegistryObject<PlacedFeature> DENSE_PINE_ON_SNOW = register("dense_pine_on_snow", DenseTreeFeatures.DENSE_PINE.getHolder().orElseThrow(), SNOW_TREE_FILTER_DECORATOR);
	public static final RegistryObject<PlacedFeature> DENSE_SPRUCE_ON_SNOW = register("dense_spruce_on_snow", DenseTreeFeatures.DENSE_SPRUCE.getHolder().orElseThrow(), SNOW_TREE_FILTER_DECORATOR);
	public static final RegistryObject<PlacedFeature> DENSE_PINE_CHECKED = register("dense_pine_checked", DenseTreeFeatures.DENSE_PINE.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_JUNGLE_TREE_CHECKED = register("dense_jungle_tree", DenseTreeFeatures.DENSE_JUNGLE_TREE.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_FANCY_OAK_CHECKED = register("dense_fancy_oak_checked", DenseTreeFeatures.DENSE_FANCY_OAK.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_MEGA_JUNGLE_TREE_CHECKED = register("dense_mega_jungle_tree_checked", DenseTreeFeatures.DENSE_MEGA_JUNGLE_TREE.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_MEGA_SPRUCE_CHECKED = register("dense_mega_spruce_checked", DenseTreeFeatures.DENSE_MEGA_SPRUCE.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_MEGA_PINE_CHECKED = register("dense_mega_pine_checked", DenseTreeFeatures.DENSE_MEGA_PINE.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_JUNGLE_BUSH = register("dense_jungle_bush", DenseTreeFeatures.DENSE_JUNGLE_BUSH.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_SUPER_BIRCH_BEES_0002 = register("dense_super_birch_bees_0002", DenseTreeFeatures.DENSE_SUPER_BIRCH_BEES_0002.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_SUPER_BIRCH_BEES = register("dense_super_birch_bees", DenseTreeFeatures.DENSE_SUPER_BIRCH_BEES.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_OAK_BEES_0002 = register("dense_oak_bees_0002", DenseTreeFeatures.DENSE_OAK_BEES_0002.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_OAK_BEES_002 = register("dense_oak_bees_002", DenseTreeFeatures.DENSE_OAK_BEES_002.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_BIRCH_BEES_0002_PLACED = register("dense_birch_bees_0002", DenseTreeFeatures.DENSE_BIRCH_BEES_0002.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_BIRCH_BEES_002 = register("dense_birch_bees_002", DenseTreeFeatures.DENSE_BIRCH_BEES_002.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_FANCY_OAK_BEES_0002 = register("dense_fancy_oak_bees_0002", DenseTreeFeatures.DENSE_FANCY_OAK_BEES_0002.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_FANCY_OAK_BEES_002 = register("dense_fancy_oak_bees_002", DenseTreeFeatures.DENSE_FANCY_OAK_BEES_002.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> DENSE_FANCY_OAK_BEES = register("dense_fancy_oak_bees", DenseTreeFeatures.DENSE_FANCY_OAK_BEES.getHolder().orElseThrow(), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

	public static final RegistryObject<PlacedFeature> DENSE_CRIMSON_FUNGI = register("crimson_fungi", DenseTreeFeatures.DENSE_CRIMSON_FUNGUS.getHolder().orElseThrow(), CountOnEveryLayerPlacement.of(8), BiomeFilter.biome(), RarityFilter.onAverageOnceEvery(5));
	public static final RegistryObject<PlacedFeature> DENSE_WARPED_FUNGI = register("warped_fungi", DenseTreeFeatures.DENSE_WARPED_FUNGUS.getHolder().orElseThrow(), CountOnEveryLayerPlacement.of(8), BiomeFilter.biome(), RarityFilter.onAverageOnceEvery(5));

	private static RegistryObject<PlacedFeature> register(String registryName,
														  Holder<? extends ConfiguredFeature<?, ?>> configuredHolder,
														  List<PlacementModifier> placementModifiers) {
		return PLACED_FEATURES.register(registryName, () -> new PlacedFeature(Holder.hackyErase(configuredHolder), List.copyOf(placementModifiers)));
	}

	private static RegistryObject<PlacedFeature> register(String registryName,
														  Holder<? extends ConfiguredFeature<?, ?>> configuredHolder,
														  Supplier<List<PlacementModifier>> placementModifiers) {
		return PLACED_FEATURES.register(registryName, () -> new PlacedFeature(Holder.hackyErase(configuredHolder), List.copyOf(placementModifiers.get())));
	}

	private static RegistryObject<PlacedFeature> register(String registryName,
														  Holder<? extends ConfiguredFeature<?, ?>> configuredHolder,
														  PlacementModifier... placementModifiers) {
		return PLACED_FEATURES.register(registryName, () -> new PlacedFeature(Holder.hackyErase(configuredHolder), List.of(placementModifiers)));
	}
}