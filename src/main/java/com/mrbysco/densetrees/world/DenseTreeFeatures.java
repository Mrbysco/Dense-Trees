package com.mrbysco.densetrees.world;

import com.google.common.collect.ImmutableList;
import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.core.Registry;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
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
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.OptionalInt;

public class DenseTreeFeatures {
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, DenseTrees.MOD_ID);

	private static final BeehiveDecorator BEEHIVE_0002 = new BeehiveDecorator(0.002F);
	private static final BeehiveDecorator BEEHIVE_002 = new BeehiveDecorator(0.02F);
	private static final BeehiveDecorator BEEHIVE_005 = new BeehiveDecorator(0.05F);
	private static final BeehiveDecorator BEEHIVE = new BeehiveDecorator(1.0F);

	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_OAK = CONFIGURED_FEATURES.register("dense_oak", () -> new ConfiguredFeature<>(Feature.TREE, createOak().build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_DARK_OAK = CONFIGURED_FEATURES.register("dense_dark_oak", () -> new ConfiguredFeature<>(Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_DARK_OAK_LOG.get()), new DarkOakTrunkPlacer(6, 2, 1), BlockStateProvider.simple(Blocks.DARK_OAK_LEAVES), new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))).ignoreVines().build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_BIRCH = CONFIGURED_FEATURES.register("dense_birch", () -> new ConfiguredFeature<>(Feature.TREE, createBirch().build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_ACACIA = CONFIGURED_FEATURES.register("dense_acacia", () -> new ConfiguredFeature<>(Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_ACACIA_LOG.get()), new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.simple(Blocks.ACACIA_LEAVES), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_SPRUCE = CONFIGURED_FEATURES.register("dense_spruce", () -> new ConfiguredFeature<>(Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_SPRUCE_LOG.get()), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)), new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_PINE = CONFIGURED_FEATURES.register("dense_pine", () -> new ConfiguredFeature<>(Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_SPRUCE_LOG.get()), new StraightTrunkPlacer(6, 4, 0), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), UniformInt.of(3, 4)), new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_JUNGLE_TREE = CONFIGURED_FEATURES.register("dense_jungle_tree", () -> new ConfiguredFeature<>(Feature.TREE, createJungleTree().decorators(ImmutableList.of(new CocoaDecorator(0.2F), TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.25F))).ignoreVines().build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_FANCY_OAK = CONFIGURED_FEATURES.register("dense_fancy_oak", () -> new ConfiguredFeature<>(Feature.TREE, createFancyOak().build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_JUNGLE_TREE_NO_VINE = CONFIGURED_FEATURES.register("dense_jungle_tree_no_vine", () -> new ConfiguredFeature<>(Feature.TREE, createJungleTree().ignoreVines().build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_MEGA_JUNGLE_TREE = CONFIGURED_FEATURES.register("dense_mega_jungle_tree", () -> new ConfiguredFeature<>(Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_JUNGLE_LOG.get()), new MegaJungleTrunkPlacer(10, 2, 19), BlockStateProvider.simple(Blocks.JUNGLE_LEAVES), new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2), new TwoLayersFeatureSize(1, 1, 2))).decorators(ImmutableList.of(TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.25F))).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_MEGA_SPRUCE = CONFIGURED_FEATURES.register("dense_mega_spruce", () -> new ConfiguredFeature<>(Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_SPRUCE_LOG.get()), new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)), new TwoLayersFeatureSize(1, 1, 2))).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.PODZOL)))).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_MEGA_PINE = CONFIGURED_FEATURES.register("dense_mega_pine", () -> new ConfiguredFeature<>(Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_SPRUCE_LOG.get()), new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(3, 7)), new TwoLayersFeatureSize(1, 1, 2))).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.PODZOL)))).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_SUPER_BIRCH_BEES_0002 = CONFIGURED_FEATURES.register("dense_super_birch_bees_0002", () -> new ConfiguredFeature<>(Feature.TREE, createSuperBirch().decorators(ImmutableList.of(BEEHIVE_0002)).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_SUPER_BIRCH_BEES = CONFIGURED_FEATURES.register("dense_super_birch_bees", () -> new ConfiguredFeature<>(Feature.TREE, createSuperBirch().decorators(ImmutableList.of(BEEHIVE)).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_SWAMP_OAK = CONFIGURED_FEATURES.register("dense_swamp_oak", () -> new ConfiguredFeature<>(Feature.TREE, createStraightBlobTree(DenseRegistry.DENSE_OAK_LOG.get(), Blocks.OAK_LEAVES, 5, 3, 0, 3).decorators(ImmutableList.of(new LeaveVineDecorator(0.25F))).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_JUNGLE_BUSH = CONFIGURED_FEATURES.register("dense_jungle_bush", () -> new ConfiguredFeature<>(Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_JUNGLE_LOG.get()), new StraightTrunkPlacer(1, 0, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2), new TwoLayersFeatureSize(0, 0, 0))).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_AZALEA_TREE = CONFIGURED_FEATURES.register("dense_azalea_tree", () -> new ConfiguredFeature<>(Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(DenseRegistry.DENSE_OAK_LOG.get()), new BendingTrunkPlacer(4, 2, 0, 3, UniformInt.of(1, 2)), new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.AZALEA_LEAVES.defaultBlockState(), 3).add(Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState(), 1)), new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 50), new TwoLayersFeatureSize(1, 0, 1))).dirt(BlockStateProvider.simple(Blocks.ROOTED_DIRT)).forceDirt().build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_OAK_BEES_0002 = CONFIGURED_FEATURES.register("dense_oak_bees_0002", () -> new ConfiguredFeature<>(Feature.TREE, createOak().decorators(List.of(BEEHIVE_0002)).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_OAK_BEES_002 = CONFIGURED_FEATURES.register("dense_oak_bees_002", () -> new ConfiguredFeature<>(Feature.TREE, createOak().decorators(List.of(BEEHIVE_002)).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_OAK_BEES_005 = CONFIGURED_FEATURES.register("dense_oak_bees_005", () -> new ConfiguredFeature<>(Feature.TREE, createOak().decorators(List.of(BEEHIVE_005)).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_BIRCH_BEES_0002 = CONFIGURED_FEATURES.register("dense_birch_bees_0002", () -> new ConfiguredFeature<>(Feature.TREE, createBirch().decorators(List.of(BEEHIVE_0002)).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_BIRCH_BEES_002 = CONFIGURED_FEATURES.register("dense_birch_bees_002", () -> new ConfiguredFeature<>(Feature.TREE, createBirch().decorators(List.of(BEEHIVE_002)).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_BIRCH_BEES_005 = CONFIGURED_FEATURES.register("dense_birch_bees_005", () -> new ConfiguredFeature<>(Feature.TREE, createBirch().decorators(List.of(BEEHIVE_005)).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_FANCY_OAK_BEES_0002 = CONFIGURED_FEATURES.register("dense_fancy_oak_bees_0002", () -> new ConfiguredFeature<>(Feature.TREE, createFancyOak().decorators(List.of(BEEHIVE_0002)).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_FANCY_OAK_BEES_002 = CONFIGURED_FEATURES.register("dense_fancy_oak_bees_002", () -> new ConfiguredFeature<>(Feature.TREE, createFancyOak().decorators(List.of(BEEHIVE_002)).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_FANCY_OAK_BEES_005 = CONFIGURED_FEATURES.register("dense_fancy_oak_bees_005", () -> new ConfiguredFeature<>(Feature.TREE, createFancyOak().decorators(List.of(BEEHIVE_005)).build()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_FANCY_OAK_BEES = CONFIGURED_FEATURES.register("dense_fancy_oak_bees", () -> new ConfiguredFeature<>(Feature.TREE, createFancyOak().decorators(List.of(BEEHIVE)).build()));

	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_CRIMSON_FUNGUS = CONFIGURED_FEATURES.register("dense_crimson_fungus", () -> new ConfiguredFeature<>(Feature.HUGE_FUNGUS, new HugeFungusConfiguration(Blocks.CRIMSON_NYLIUM.defaultBlockState(), DenseRegistry.DENSE_CRIMSON_STEM.get().defaultBlockState(), Blocks.NETHER_WART_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(), false)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_CRIMSON_FUNGUS_PLANTED = CONFIGURED_FEATURES.register("dense_crimson_fungus_planted", () -> new ConfiguredFeature<>(Feature.HUGE_FUNGUS, new HugeFungusConfiguration(Blocks.CRIMSON_NYLIUM.defaultBlockState(), DenseRegistry.DENSE_CRIMSON_STEM.get().defaultBlockState(), Blocks.NETHER_WART_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(), true)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_WARPED_FUNGUS = CONFIGURED_FEATURES.register("dense_warped_fungus", () -> new ConfiguredFeature<>(Feature.HUGE_FUNGUS, new HugeFungusConfiguration(Blocks.WARPED_NYLIUM.defaultBlockState(), DenseRegistry.DENSE_WARPED_STEM.get().defaultBlockState(), Blocks.WARPED_WART_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(), false)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DENSE_WARPED_FUNGUS_PLANTED = CONFIGURED_FEATURES.register("dense_warped_fungus_planted", () -> new ConfiguredFeature<>(Feature.HUGE_FUNGUS, new HugeFungusConfiguration(Blocks.WARPED_NYLIUM.defaultBlockState(), DenseRegistry.DENSE_WARPED_STEM.get().defaultBlockState(), Blocks.WARPED_WART_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(), true)));


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
