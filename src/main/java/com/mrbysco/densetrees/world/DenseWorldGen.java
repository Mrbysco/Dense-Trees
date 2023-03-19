package com.mrbysco.densetrees.world;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class DenseWorldGen {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void biomeLoadingEvent(BiomeLoadingEvent event) {
		ResourceKey<Biome> biomeKey = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
		BiomeGenerationSettingsBuilder builder = event.getGeneration();

		List<Holder<PlacedFeature>> featureList = builder.getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_FLOWER_FOREST, DenseVegetationPlacements.DENSE_TREES_FLOWER_FOREST.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_MEADOW, DenseVegetationPlacements.DENSE_TREES_MEADOW.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_TAIGA, DenseVegetationPlacements.DENSE_TREES_TAIGA.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_GROVE, DenseVegetationPlacements.DENSE_TREES_GROVE.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_BADLANDS, DenseVegetationPlacements.DENSE_TREES_BADLANDS.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_SNOWY, DenseVegetationPlacements.DENSE_TREES_SNOWY.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_SWAMP, DenseVegetationPlacements.DENSE_TREES_SWAMP.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_WINDSWEPT_SAVANNA, DenseVegetationPlacements.DENSE_TREES_WINDSWEPT_SAVANNA.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_SAVANNA, DenseVegetationPlacements.DENSE_TREES_SAVANNA.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.BIRCH_TALL, DenseVegetationPlacements.DENSE_BIRCH_TALL.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_BIRCH, DenseVegetationPlacements.DENSE_TREES_BIRCH.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_WINDSWEPT_FOREST, DenseVegetationPlacements.DENSE_TREES_WINDSWEPT_FOREST.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_WINDSWEPT_HILLS, DenseVegetationPlacements.DENSE_TREES_WINDSWEPT_HILLS.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_WATER, DenseVegetationPlacements.DENSE_TREES_WATER.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_PLAINS, DenseVegetationPlacements.DENSE_TREES_PLAINS.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_BIRCH_AND_OAK, DenseVegetationPlacements.DENSE_TREES_BIRCH_AND_OAK.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_SPARSE_JUNGLE, DenseVegetationPlacements.DENSE_TREES_SPARSE_JUNGLE.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_OLD_GROWTH_SPRUCE_TAIGA, DenseVegetationPlacements.DENSE_TREES_OLD_GROWTH_SPRUCE_TAIGA.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_OLD_GROWTH_PINE_TAIGA, DenseVegetationPlacements.DENSE_TREES_OLD_GROWTH_PINE_TAIGA.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, VegetationPlacements.TREES_JUNGLE, DenseVegetationPlacements.DENSE_TREES_JUNGLE.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, TreePlacements.CRIMSON_FUNGI, DenseTreePlacements.DENSE_CRIMSON_FUNGI.getHolder().orElseThrow());
		addDenseVariation(biomeKey, builder, featureList, TreePlacements.WARPED_FUNGI, DenseTreePlacements.DENSE_WARPED_FUNGI.getHolder().orElseThrow());
	}

	private void addDenseVariation(ResourceKey<Biome> biomeKey, BiomeGenerationSettingsBuilder builder, List<Holder<PlacedFeature>> placedHolders, Holder<PlacedFeature> vanillaFeature, Holder<PlacedFeature> feature) {
		boolean addVariation = false;
		for (Holder<PlacedFeature> featureHolder : placedHolders) {
			var foundFeature = featureHolder.unwrapKey().orElse(null);
			var vanilla = vanillaFeature.unwrapKey().orElse(null);
			if (foundFeature != null && vanilla != null && foundFeature.location().equals(vanilla.location())) {
				addVariation = true;
				break;
			}
		}

		if (addVariation) {
//			DenseTrees.LOGGER.debug("Adding dense tree {} to biome {}", feature.unwrapKey().orElseThrow(), biomeKey.location());
			builder.getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(feature);
		}
	}
}
