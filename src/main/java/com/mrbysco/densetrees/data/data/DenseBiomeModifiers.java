package com.mrbysco.densetrees.data.data;

import com.mrbysco.densetrees.modifier.AddDenseVariationBiomeModifier;
import com.mrbysco.densetrees.world.DensePlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class DenseBiomeModifiers {

	public static void bootstrap(BootstapContext<BiomeModifier> context) {
		HolderGetter<Biome> biomeGetter = context.lookup(Registries.BIOME);
		HolderGetter<PlacedFeature> placedGetter = context.lookup(Registries.PLACED_FEATURE);
		final HolderSet.Named<Biome> overworld = biomeGetter.getOrThrow(BiomeTags.IS_OVERWORLD);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.DARK_FOREST_VEGETATION, DensePlacedFeatures.DENSE_DARK_FOREST_VEGETATION);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_FLOWER_FOREST, DensePlacedFeatures.DENSE_TREES_FLOWER_FOREST);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_MEADOW, DensePlacedFeatures.DENSE_TREES_MEADOW);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_TAIGA, DensePlacedFeatures.DENSE_TREES_TAIGA);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_GROVE, DensePlacedFeatures.DENSE_TREES_GROVE);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_BADLANDS, DensePlacedFeatures.DENSE_TREES_BADLANDS);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_SNOWY, DensePlacedFeatures.DENSE_TREES_SNOWY);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_SWAMP, DensePlacedFeatures.DENSE_TREES_SWAMP);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_WINDSWEPT_SAVANNA, DensePlacedFeatures.DENSE_TREES_WINDSWEPT_SAVANNA);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_SAVANNA, DensePlacedFeatures.DENSE_TREES_SAVANNA);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.BIRCH_TALL, DensePlacedFeatures.DENSE_BIRCH_TALL);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_BIRCH, DensePlacedFeatures.DENSE_TREES_BIRCH);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_WINDSWEPT_FOREST, DensePlacedFeatures.DENSE_TREES_WINDSWEPT_FOREST);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_WINDSWEPT_HILLS, DensePlacedFeatures.DENSE_TREES_WINDSWEPT_HILLS);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_WATER, DensePlacedFeatures.DENSE_TREES_WATER);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_PLAINS, DensePlacedFeatures.DENSE_TREES_PLAINS);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_BIRCH_AND_OAK, DensePlacedFeatures.DENSE_TREES_BIRCH_AND_OAK);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_SPARSE_JUNGLE, DensePlacedFeatures.DENSE_TREES_SPARSE_JUNGLE);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_OLD_GROWTH_SPRUCE_TAIGA, DensePlacedFeatures.DENSE_TREES_OLD_GROWTH_SPRUCE_TAIGA);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_OLD_GROWTH_PINE_TAIGA, DensePlacedFeatures.DENSE_TREES_OLD_GROWTH_PINE_TAIGA);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_JUNGLE, DensePlacedFeatures.DENSE_TREES_JUNGLE);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_MANGROVE, DensePlacedFeatures.DENSE_TREES_MANGROVE);
		addDenseVariation(context, placedGetter, overworld, VegetationPlacements.TREES_CHERRY, DensePlacedFeatures.DENSE_TREES_CHERRY);
		final HolderSet.Named<Biome> nether = biomeGetter.getOrThrow(BiomeTags.IS_NETHER);
		addDenseVariation(context, placedGetter, nether, TreePlacements.CRIMSON_FUNGI, DensePlacedFeatures.DENSE_CRIMSON_FUNGI);
		addDenseVariation(context, placedGetter, nether, TreePlacements.WARPED_FUNGI, DensePlacedFeatures.DENSE_WARPED_FUNGI);
	}

	private static void addDenseVariation(BootstapContext<BiomeModifier> context, HolderGetter<PlacedFeature> placedGetter,
										  HolderSet.Named<Biome> biomeSet, ResourceKey<PlacedFeature> original, ResourceKey<PlacedFeature> denseKey) {
		final ResourceKey<BiomeModifier> denseLocation = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, denseKey.location());
		final BiomeModifier addDenseVariationBiomeModifier = new AddDenseVariationBiomeModifier(
				biomeSet,
				placedGetter.getOrThrow(original),
				placedGetter.getOrThrow(denseKey)
		);
		context.register(denseLocation, addDenseVariationBiomeModifier);
	}
}
