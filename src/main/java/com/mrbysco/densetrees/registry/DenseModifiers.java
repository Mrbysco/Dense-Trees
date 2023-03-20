package com.mrbysco.densetrees.registry;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.modifier.AddDenseVariationBiomeModifier;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DenseModifiers {
	public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, DenseTrees.MOD_ID);

	public static final RegistryObject<Codec<AddDenseVariationBiomeModifier>> ADD_DENSE_VARIATION = BIOME_MODIFIER_SERIALIZERS.register("add_dense_variation", () ->
			RecordCodecBuilder.create(builder -> builder.group(
					Biome.LIST_CODEC.fieldOf("biomes").forGetter(AddDenseVariationBiomeModifier::biomes),
					PlacedFeature.CODEC.fieldOf("original").forGetter(AddDenseVariationBiomeModifier::original),
					PlacedFeature.CODEC.fieldOf("dense").forGetter(AddDenseVariationBiomeModifier::dense)
			).apply(builder, AddDenseVariationBiomeModifier::new))
	);
}
