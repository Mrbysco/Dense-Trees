package com.mrbysco.densetrees.world;

import com.google.common.collect.ImmutableList;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MangrovePropaguleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.rootplacers.AboveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.UpwardsBranchingTrunkPlacer;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class DenseTreeFeatures {
	private static final BeehiveDecorator BEEHIVE_0002 = new BeehiveDecorator(0.002F);
	private static final BeehiveDecorator BEEHIVE_001 = new BeehiveDecorator(0.01F);
	private static final BeehiveDecorator BEEHIVE_002 = new BeehiveDecorator(0.02F);
	private static final BeehiveDecorator BEEHIVE_005 = new BeehiveDecorator(0.05F);
	private static final BeehiveDecorator BEEHIVE = new BeehiveDecorator(1.0F);

	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_OAK = FeatureUtils.createKey("densetrees:dense_oak");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_DARK_OAK = FeatureUtils.createKey("densetrees:dense_dark_oak");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_BIRCH = FeatureUtils.createKey("densetrees:dense_birch");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_ACACIA = FeatureUtils.createKey("densetrees:dense_acacia");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_SPRUCE = FeatureUtils.createKey("densetrees:dense_spruce");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_PINE = FeatureUtils.createKey("densetrees:dense_pine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_JUNGLE_TREE = FeatureUtils.createKey("densetrees:dense_jungle_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_FANCY_OAK = FeatureUtils.createKey("densetrees:dense_fancy_oak");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_JUNGLE_TREE_NO_VINE = FeatureUtils.createKey("densetrees:dense_jungle_tree_no_vine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_MEGA_JUNGLE_TREE = FeatureUtils.createKey("densetrees:dense_mega_jungle_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_MEGA_SPRUCE = FeatureUtils.createKey("densetrees:dense_mega_spruce");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_MEGA_PINE = FeatureUtils.createKey("densetrees:dense_mega_pine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_SUPER_BIRCH_BEES_0002 = FeatureUtils.createKey("densetrees:dense_super_birch_bees_0002");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_SUPER_BIRCH_BEES = FeatureUtils.createKey("densetrees:dense_super_birch_bees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_SWAMP_OAK = FeatureUtils.createKey("densetrees:dense_swamp_oak");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_JUNGLE_BUSH = FeatureUtils.createKey("densetrees:dense_jungle_bush");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_AZALEA_TREE = FeatureUtils.createKey("densetrees:dense_azalea_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_MANGROVE = FeatureUtils.createKey("densetrees:dense_mangrove");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_TALL_MANGROVE = FeatureUtils.createKey("densetrees:dense_tall_mangrove");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_OAK_BEES_0002 = FeatureUtils.createKey("densetrees:dense_oak_bees_0002");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_OAK_BEES_002 = FeatureUtils.createKey("densetrees:dense_oak_bees_002");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_OAK_BEES_005 = FeatureUtils.createKey("densetrees:dense_oak_bees_005");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_BIRCH_BEES_0002 = FeatureUtils.createKey("densetrees:dense_birch_bees_0002");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_BIRCH_BEES_002 = FeatureUtils.createKey("densetrees:dense_birch_bees_002");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_BIRCH_BEES_005 = FeatureUtils.createKey("densetrees:dense_birch_bees_005");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_FANCY_OAK_BEES_0002 = FeatureUtils.createKey("densetrees:dense_fancy_oak_bees_0002");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_FANCY_OAK_BEES_002 = FeatureUtils.createKey("densetrees:dense_fancy_oak_bees_002");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_FANCY_OAK_BEES_005 = FeatureUtils.createKey("densetrees:dense_fancy_oak_bees_005");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_FANCY_OAK_BEES = FeatureUtils.createKey("densetrees:dense_fancy_oak_bees");

	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_CRIMSON_FUNGUS = FeatureUtils.createKey("densetrees:dense_crimson_fungus");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_CRIMSON_FUNGUS_PLANTED = FeatureUtils.createKey("densetrees:dense_crimson_fungus_planted");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_WARPED_FUNGUS = FeatureUtils.createKey("densetrees:dense_warped_fungus");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_WARPED_FUNGUS_PLANTED = FeatureUtils.createKey("densetrees:dense_warped_fungus_planted");

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
		FeatureUtils.register(context, DENSE_OAK, Feature.TREE, createOak().build());
		FeatureUtils.register(context, DENSE_DARK_OAK, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_DARK_OAK_LOG.get()), new DarkOakTrunkPlacer(6, 2, 1), BlockStateProvider.simple(Blocks.DARK_OAK_LEAVES), new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))).ignoreVines().build());
		FeatureUtils.register(context, DENSE_BIRCH, Feature.TREE, createBirch().build());
		FeatureUtils.register(context, DENSE_ACACIA, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_ACACIA_LOG.get()), new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.simple(Blocks.ACACIA_LEAVES), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
		FeatureUtils.register(context, DENSE_SPRUCE, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_SPRUCE_LOG.get()), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)), new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().build());
		FeatureUtils.register(context, DENSE_PINE, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_SPRUCE_LOG.get()), new StraightTrunkPlacer(6, 4, 0), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), UniformInt.of(3, 4)), new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().build());
		FeatureUtils.register(context, DENSE_JUNGLE_TREE, Feature.TREE, createJungleTree().decorators(ImmutableList.of(new CocoaDecorator(0.2F), TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.25F))).ignoreVines().build());
		FeatureUtils.register(context, DENSE_FANCY_OAK, Feature.TREE, createFancyOak().build());
		FeatureUtils.register(context, DENSE_JUNGLE_TREE_NO_VINE, Feature.TREE, createJungleTree().ignoreVines().build());
		FeatureUtils.register(context, DENSE_MEGA_JUNGLE_TREE, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_JUNGLE_LOG.get()), new MegaJungleTrunkPlacer(10, 2, 19), BlockStateProvider.simple(Blocks.JUNGLE_LEAVES), new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2), new TwoLayersFeatureSize(1, 1, 2))).decorators(ImmutableList.of(TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.25F))).build());
		FeatureUtils.register(context, DENSE_MEGA_SPRUCE, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_SPRUCE_LOG.get()), new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)), new TwoLayersFeatureSize(1, 1, 2))).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.PODZOL)))).build());
		FeatureUtils.register(context, DENSE_MEGA_PINE, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_SPRUCE_LOG.get()), new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(3, 7)), new TwoLayersFeatureSize(1, 1, 2))).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.PODZOL)))).build());
		FeatureUtils.register(context, DENSE_SUPER_BIRCH_BEES_0002, Feature.TREE, createSuperBirch().decorators(ImmutableList.of(BEEHIVE_0002)).build());
		FeatureUtils.register(context, DENSE_SUPER_BIRCH_BEES, Feature.TREE, createSuperBirch().decorators(ImmutableList.of(BEEHIVE)).build());
		FeatureUtils.register(context, DENSE_SWAMP_OAK, Feature.TREE, createStraightBlobTree(DenseRegistry.DENSE_OAK_LOG.get(), Blocks.OAK_LEAVES, 5, 3, 0, 3).decorators(ImmutableList.of(new LeaveVineDecorator(0.25F))).build());
		FeatureUtils.register(context, DENSE_JUNGLE_BUSH, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_JUNGLE_LOG.get()), new StraightTrunkPlacer(1, 0, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2), new TwoLayersFeatureSize(0, 0, 0))).build());
		FeatureUtils.register(context, DENSE_AZALEA_TREE, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_OAK_LOG.get()), new BendingTrunkPlacer(4, 2, 0, 3, UniformInt.of(1, 2)), new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.AZALEA_LEAVES.defaultBlockState(), 3).add(Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState(), 1)), new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 50), new TwoLayersFeatureSize(1, 0, 1))).dirt(BlockStateProvider.simple(Blocks.ROOTED_DIRT)).forceDirt().build());
		FeatureUtils.register(context, DENSE_MANGROVE, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_MANGROVE_LOG.get()), new UpwardsBranchingTrunkPlacer(2, 1, 4, UniformInt.of(1, 4), 0.5F, UniformInt.of(0, 1), BuiltInRegistries.BLOCK.getOrCreateTag(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH)), BlockStateProvider.simple(Blocks.MANGROVE_LEAVES), new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 70), Optional.of(new MangroveRootPlacer(UniformInt.of(1, 3), BlockStateProvider.simple(Blocks.MANGROVE_ROOTS), Optional.of(new AboveRootPlacement(BlockStateProvider.simple(Blocks.MOSS_CARPET), 0.5F)), new MangroveRootPlacement(BuiltInRegistries.BLOCK.getOrCreateTag(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH), HolderSet.direct(Block::builtInRegistryHolder, Blocks.MUD, Blocks.MUDDY_MANGROVE_ROOTS), BlockStateProvider.simple(Blocks.MUDDY_MANGROVE_ROOTS), 8, 15, 0.2F))), new TwoLayersFeatureSize(2, 0, 2))).decorators(List.of(new LeaveVineDecorator(0.125F), new AttachedToLeavesDecorator(0.14F, 1, 0, new RandomizedIntStateProvider(BlockStateProvider.simple(Blocks.MANGROVE_PROPAGULE.defaultBlockState().setValue(MangrovePropaguleBlock.HANGING, Boolean.valueOf(true))), MangrovePropaguleBlock.AGE, UniformInt.of(0, 4)), 2, List.of(Direction.DOWN)), BEEHIVE_001)).ignoreVines().build());
		FeatureUtils.register(context, DENSE_TALL_MANGROVE, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_MANGROVE_LOG.get()), new UpwardsBranchingTrunkPlacer(4, 1, 9, UniformInt.of(1, 6), 0.5F, UniformInt.of(0, 1), BuiltInRegistries.BLOCK.getOrCreateTag(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH)), BlockStateProvider.simple(Blocks.MANGROVE_LEAVES), new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 70), Optional.of(new MangroveRootPlacer(UniformInt.of(3, 7), BlockStateProvider.simple(Blocks.MANGROVE_ROOTS), Optional.of(new AboveRootPlacement(BlockStateProvider.simple(Blocks.MOSS_CARPET), 0.5F)), new MangroveRootPlacement(BuiltInRegistries.BLOCK.getOrCreateTag(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH), HolderSet.direct(Block::builtInRegistryHolder, Blocks.MUD, Blocks.MUDDY_MANGROVE_ROOTS), BlockStateProvider.simple(Blocks.MUDDY_MANGROVE_ROOTS), 8, 15, 0.2F))), new TwoLayersFeatureSize(3, 0, 2))).decorators(List.of(new LeaveVineDecorator(0.125F), new AttachedToLeavesDecorator(0.14F, 1, 0, new RandomizedIntStateProvider(BlockStateProvider.simple(Blocks.MANGROVE_PROPAGULE.defaultBlockState().setValue(MangrovePropaguleBlock.HANGING, Boolean.valueOf(true))), MangrovePropaguleBlock.AGE, UniformInt.of(0, 4)), 2, List.of(Direction.DOWN)), BEEHIVE_001)).ignoreVines().build());
		FeatureUtils.register(context, DENSE_OAK_BEES_0002, Feature.TREE, createOak().decorators(List.of(BEEHIVE_0002)).build());
		FeatureUtils.register(context, DENSE_OAK_BEES_002, Feature.TREE, createOak().decorators(List.of(BEEHIVE_002)).build());
		FeatureUtils.register(context, DENSE_OAK_BEES_005, Feature.TREE, createOak().decorators(List.of(BEEHIVE_005)).build());
		FeatureUtils.register(context, DENSE_BIRCH_BEES_0002, Feature.TREE, createBirch().decorators(List.of(BEEHIVE_0002)).build());
		FeatureUtils.register(context, DENSE_BIRCH_BEES_002, Feature.TREE, createBirch().decorators(List.of(BEEHIVE_002)).build());
		FeatureUtils.register(context, DENSE_BIRCH_BEES_005, Feature.TREE, createBirch().decorators(List.of(BEEHIVE_005)).build());
		FeatureUtils.register(context, DENSE_FANCY_OAK_BEES_0002, Feature.TREE, createFancyOak().decorators(List.of(BEEHIVE_0002)).build());
		FeatureUtils.register(context, DENSE_FANCY_OAK_BEES_002, Feature.TREE, createFancyOak().decorators(List.of(BEEHIVE_002)).build());
		FeatureUtils.register(context, DENSE_FANCY_OAK_BEES_005, Feature.TREE, createFancyOak().decorators(List.of(BEEHIVE_005)).build());
		FeatureUtils.register(context, DENSE_FANCY_OAK_BEES, Feature.TREE, createFancyOak().decorators(List.of(BEEHIVE)).build());

		FeatureUtils.register(context, DENSE_CRIMSON_FUNGUS, Feature.HUGE_FUNGUS, new HugeFungusConfiguration(Blocks.CRIMSON_NYLIUM.defaultBlockState(), DenseRegistry.DENSE_CRIMSON_STEM.get().defaultBlockState(), Blocks.NETHER_WART_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(), false));
		FeatureUtils.register(context, DENSE_CRIMSON_FUNGUS_PLANTED, Feature.HUGE_FUNGUS, new HugeFungusConfiguration(Blocks.CRIMSON_NYLIUM.defaultBlockState(), DenseRegistry.DENSE_CRIMSON_STEM.get().defaultBlockState(), Blocks.NETHER_WART_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(), true));
		FeatureUtils.register(context, DENSE_WARPED_FUNGUS, Feature.HUGE_FUNGUS, new HugeFungusConfiguration(Blocks.WARPED_NYLIUM.defaultBlockState(), DenseRegistry.DENSE_WARPED_STEM.get().defaultBlockState(), Blocks.WARPED_WART_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(), false));
		FeatureUtils.register(context, DENSE_WARPED_FUNGUS_PLANTED, Feature.HUGE_FUNGUS, new HugeFungusConfiguration(Blocks.WARPED_NYLIUM.defaultBlockState(), DenseRegistry.DENSE_WARPED_STEM.get().defaultBlockState(), Blocks.WARPED_WART_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(), true));
	}

	private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block log, Block leaves, int baseHeight, int heightRandA, int heightRandB, int radius) {
		return new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(log),
				new StraightTrunkPlacer(baseHeight, heightRandA, heightRandB), BlockStateProvider.simple(leaves),
				new BlobFoliagePlacer(ConstantInt.of(radius), ConstantInt.of(0), 3),
				new TwoLayersFeatureSize(1, 0, 1));
	}

	private static TreeConfiguration.TreeConfigurationBuilder createOak() {
		return createStraightBlobTree(DenseRegistry.DENSE_OAK_LOG.get(), Blocks.OAK_LEAVES, 4, 2, 0, 2).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder createBirch() {
		return createStraightBlobTree(DenseRegistry.DENSE_BIRCH_LOG.get(), Blocks.BIRCH_LEAVES, 5, 2, 0, 2).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder createSuperBirch() {
		return createStraightBlobTree(DenseRegistry.DENSE_BIRCH_LOG.get(), Blocks.BIRCH_LEAVES, 5, 2, 6, 2).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder createJungleTree() {
		return createStraightBlobTree(DenseRegistry.DENSE_JUNGLE_LOG.get(), Blocks.JUNGLE_LEAVES, 4, 8, 0, 2);
	}

	private static TreeConfiguration.TreeConfigurationBuilder createFancyOak() {
		return (new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(DenseRegistry.DENSE_OAK_LOG.get()),
				new FancyTrunkPlacer(3, 11, 0),
				BlockStateProvider.simple(Blocks.OAK_LEAVES),
				new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
				new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
	}
}
