package com.mrbysco.densetrees.data.data;

import com.mrbysco.densetrees.world.DensePlacedFeatures;
import com.mrbysco.densetrees.world.DenseTreeFeatures;
import com.mrbysco.densetrees.world.DenseTreePlacements;
import com.mrbysco.densetrees.world.DenseVegetationFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DenseDatapackProvider extends DatapackBuiltinEntriesProvider {
	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.CONFIGURED_FEATURE, context -> {
				DenseVegetationFeatures.bootstrap(context);
				DenseTreeFeatures.bootstrap(context);
			})
			.add(Registries.PLACED_FEATURE, context -> {
				DensePlacedFeatures.bootstrap(context);
				DenseTreePlacements.bootstrap(context);
			})
			.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, DenseBiomeModifiers::bootstrap);

	public DenseDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, Set<String> modIds) {
		super(output, registries, BUILDER, modIds);
	}
}
