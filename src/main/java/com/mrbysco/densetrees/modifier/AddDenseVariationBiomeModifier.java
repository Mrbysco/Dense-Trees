package com.mrbysco.densetrees.modifier;

import com.mojang.serialization.Codec;
import com.mrbysco.densetrees.registry.DenseModifiers;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeGenerationSettingsBuilder;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;

import java.util.List;

public record AddDenseVariationBiomeModifier(HolderSet<Biome> biomes, Holder<PlacedFeature> original,
											 Holder<PlacedFeature> dense) implements BiomeModifier {
	@Override
	public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
		if (phase == Phase.ADD && this.biomes.contains(biome)) {
			BiomeGenerationSettingsBuilder generationSettings = builder.getGenerationSettings();
			boolean hasOriginal = false;
			List<Holder<PlacedFeature>> featureList = generationSettings.getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
			for (Holder<PlacedFeature> featureHolder : featureList) {
				var foundFeature = featureHolder.unwrapKey().orElse(null);
				var vanillaKey = original.unwrapKey().orElse(null);
				if (foundFeature != null && vanillaKey != null && foundFeature.location().equals(vanillaKey.location())) {
					hasOriginal = true;
					break;
				}
			}

			if (hasOriginal) {
//				DenseTrees.LOGGER.debug("Adding dense tree {} to biome {}", dense.unwrapKey().orElseThrow().location(), biome.unwrapKey().orElseThrow().location());
				generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, dense);
			}
		}
	}

	@Override
	public Codec<? extends BiomeModifier> codec() {
		return DenseModifiers.ADD_DENSE_VARIATION.get();
	}
}
