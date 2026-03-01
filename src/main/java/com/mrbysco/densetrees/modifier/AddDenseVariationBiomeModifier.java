package com.mrbysco.densetrees.modifier;

import com.mojang.serialization.MapCodec;
import com.mrbysco.densetrees.config.DenseConfig;
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
			if (DenseConfig.COMMON.disableWorldgen.get())
				return;
			BiomeGenerationSettingsBuilder generationSettings = builder.getGenerationSettings();
			boolean hasOriginal = false;
			List<Holder<PlacedFeature>> featureList = generationSettings.getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
			for (Holder<PlacedFeature> featureHolder : featureList) {
				var foundFeature = featureHolder.unwrapKey().orElse(null);
				var vanillaKey = original.unwrapKey().orElse(null);
				if (foundFeature != null && vanillaKey != null && foundFeature.identifier().equals(vanillaKey.identifier())) {
					hasOriginal = true;
					break;
				}
			}

			if (hasOriginal) {
//				DenseTrees.LOGGER.debug("Adding dense tree {} to biome {}", dense.unwrapKey().orElseThrow().identifier(), biome.unwrapKey().orElseThrow().identifier());
				if (isBlacklisted(biome))
					return;
				generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, dense);
			}
		}
	}

	private boolean isBlacklisted(Holder<Biome> biome) {
		var biomeKey = biome.unwrapKey().orElse(null);
		if (biomeKey != null) {
			return DenseConfig.COMMON.biomeBlacklist.get().contains(biomeKey.identifier().toString());
		}
		return false;
	}

	@Override
	public MapCodec<? extends BiomeModifier> codec() {
		return DenseModifiers.ADD_DENSE_VARIATION.get();
	}
}
