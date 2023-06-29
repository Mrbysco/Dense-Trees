package com.mrbysco.densetrees.world;

import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class DenseTreePlacements {
	public static final BlockPredicate SNOW_TREE_PREDICATE = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.SNOW_BLOCK, Blocks.POWDER_SNOW);
	public static final List<PlacementModifier> SNOW_TREE_FILTER_DECORATOR = List.of(EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.not(BlockPredicate.matchesBlocks(Blocks.POWDER_SNOW)), 8), BlockPredicateFilter.forPredicate(SNOW_TREE_PREDICATE));

	public static final ResourceKey<PlacedFeature> DENSE_OAK_CHECKED = PlacementUtils.createKey("densetrees:dense_oak_checked");
	public static final ResourceKey<PlacedFeature> DENSE_DARK_OAK_CHECKED = PlacementUtils.createKey("densetrees:dense_dark_oak_checked");
	public static final ResourceKey<PlacedFeature> DENSE_BIRCH_CHECKED = PlacementUtils.createKey("densetrees:dense_birch_checked");
	public static final ResourceKey<PlacedFeature> DENSE_ACACIA_CHECKED = PlacementUtils.createKey("densetrees:dense_acacia_checked");
	public static final ResourceKey<PlacedFeature> DENSE_SPRUCE_CHECKED = PlacementUtils.createKey("densetrees:dense_spruce_checked");
	public static final ResourceKey<PlacedFeature> DENSE_MANGROVE_CHECKED = PlacementUtils.createKey("densetrees:dense_mangrove_checked");
	public static final ResourceKey<PlacedFeature> DENSE_PINE_ON_SNOW = PlacementUtils.createKey("densetrees:dense_pine_on_snow");
	public static final ResourceKey<PlacedFeature> DENSE_SPRUCE_ON_SNOW = PlacementUtils.createKey("densetrees:dense_spruce_on_snow");
	public static final ResourceKey<PlacedFeature> DENSE_PINE_CHECKED = PlacementUtils.createKey("densetrees:dense_pine_checked");
	public static final ResourceKey<PlacedFeature> DENSE_JUNGLE_TREE_CHECKED = PlacementUtils.createKey("densetrees:dense_jungle_tree");
	public static final ResourceKey<PlacedFeature> DENSE_FANCY_OAK_CHECKED = PlacementUtils.createKey("densetrees:dense_fancy_oak_checked");
	public static final ResourceKey<PlacedFeature> DENSE_MEGA_JUNGLE_TREE_CHECKED = PlacementUtils.createKey("densetrees:dense_mega_jungle_tree_checked");
	public static final ResourceKey<PlacedFeature> DENSE_MEGA_SPRUCE_CHECKED = PlacementUtils.createKey("densetrees:dense_mega_spruce_checked");
	public static final ResourceKey<PlacedFeature> DENSE_MEGA_PINE_CHECKED = PlacementUtils.createKey("densetrees:dense_mega_pine_checked");
	public static final ResourceKey<PlacedFeature> DENSE_TALL_MANGROVE_CHECKED = PlacementUtils.createKey("densetrees:dense_tall_mangrove_checked");
	public static final ResourceKey<PlacedFeature> DENSE_JUNGLE_BUSH = PlacementUtils.createKey("densetrees:dense_jungle_bush");
	public static final ResourceKey<PlacedFeature> DENSE_SUPER_BIRCH_BEES_0002 = PlacementUtils.createKey("densetrees:dense_super_birch_bees_0002");
	public static final ResourceKey<PlacedFeature> DENSE_SUPER_BIRCH_BEES = PlacementUtils.createKey("densetrees:dense_super_birch_bees");
	public static final ResourceKey<PlacedFeature> DENSE_OAK_BEES_0002 = PlacementUtils.createKey("densetrees:dense_oak_bees_0002");
	public static final ResourceKey<PlacedFeature> DENSE_OAK_BEES_002 = PlacementUtils.createKey("densetrees:dense_oak_bees_002");
	public static final ResourceKey<PlacedFeature> DENSE_BIRCH_BEES_0002_PLACED = PlacementUtils.createKey("densetrees:dense_birch_bees_0002");
	public static final ResourceKey<PlacedFeature> DENSE_BIRCH_BEES_002 = PlacementUtils.createKey("densetrees:dense_birch_bees_002");
	public static final ResourceKey<PlacedFeature> DENSE_FANCY_OAK_BEES_0002 = PlacementUtils.createKey("densetrees:dense_fancy_oak_bees_0002");
	public static final ResourceKey<PlacedFeature> DENSE_FANCY_OAK_BEES_002 = PlacementUtils.createKey("densetrees:dense_fancy_oak_bees_002");
	public static final ResourceKey<PlacedFeature> DENSE_FANCY_OAK_BEES = PlacementUtils.createKey("densetrees:dense_fancy_oak_bees");

	public static void bootstrap(BootstapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?, ?>> configuredGetter = context.lookup(Registries.CONFIGURED_FEATURE);

		PlacementUtils.register(context, DENSE_OAK_CHECKED, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_OAK), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(context, DENSE_DARK_OAK_CHECKED, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_DARK_OAK), PlacementUtils.filteredByBlockSurvival(Blocks.DARK_OAK_SAPLING));
		PlacementUtils.register(context, DENSE_BIRCH_CHECKED, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_BIRCH), PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING));
		PlacementUtils.register(context, DENSE_ACACIA_CHECKED, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_ACACIA), PlacementUtils.filteredByBlockSurvival(Blocks.ACACIA_SAPLING));
		PlacementUtils.register(context, DENSE_SPRUCE_CHECKED, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_SPRUCE), PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
		PlacementUtils.register(context, DENSE_MANGROVE_CHECKED, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_MANGROVE), PlacementUtils.filteredByBlockSurvival(Blocks.MANGROVE_PROPAGULE));
		PlacementUtils.register(context, DENSE_PINE_ON_SNOW, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_PINE), SNOW_TREE_FILTER_DECORATOR);
		PlacementUtils.register(context, DENSE_SPRUCE_ON_SNOW, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_SPRUCE), SNOW_TREE_FILTER_DECORATOR);
		PlacementUtils.register(context, DENSE_PINE_CHECKED, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_PINE), PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
		PlacementUtils.register(context, DENSE_JUNGLE_TREE_CHECKED, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_JUNGLE_TREE), PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING));
		PlacementUtils.register(context, DENSE_FANCY_OAK_CHECKED, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_FANCY_OAK), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(context, DENSE_MEGA_JUNGLE_TREE_CHECKED, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_MEGA_JUNGLE_TREE), PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING));
		PlacementUtils.register(context, DENSE_MEGA_SPRUCE_CHECKED, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_MEGA_SPRUCE), PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
		PlacementUtils.register(context, DENSE_MEGA_PINE_CHECKED, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_MEGA_PINE), PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
		PlacementUtils.register(context, DENSE_TALL_MANGROVE_CHECKED, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_TALL_MANGROVE), PlacementUtils.filteredByBlockSurvival(Blocks.MANGROVE_PROPAGULE));
		PlacementUtils.register(context, DENSE_JUNGLE_BUSH, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_JUNGLE_BUSH), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(context, DENSE_SUPER_BIRCH_BEES_0002, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_SUPER_BIRCH_BEES_0002), PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING));
		PlacementUtils.register(context, DENSE_SUPER_BIRCH_BEES, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_SUPER_BIRCH_BEES), PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING));
		PlacementUtils.register(context, DENSE_OAK_BEES_0002, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_OAK_BEES_0002), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(context, DENSE_OAK_BEES_002, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_OAK_BEES_002), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(context, DENSE_BIRCH_BEES_0002_PLACED, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_BIRCH_BEES_0002), PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING));
		PlacementUtils.register(context, DENSE_BIRCH_BEES_002, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_BIRCH_BEES_002), PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING));
		PlacementUtils.register(context, DENSE_FANCY_OAK_BEES_0002, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_FANCY_OAK_BEES_0002), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(context, DENSE_FANCY_OAK_BEES_002, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_FANCY_OAK_BEES_002), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(context, DENSE_FANCY_OAK_BEES, configuredGetter.getOrThrow(DenseTreeFeatures.DENSE_FANCY_OAK_BEES), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	}
}