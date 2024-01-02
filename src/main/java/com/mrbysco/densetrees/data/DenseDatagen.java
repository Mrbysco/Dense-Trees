package com.mrbysco.densetrees.data;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.data.assets.DenseBlockStateProvider;
import com.mrbysco.densetrees.data.assets.DenseItemModelProvider;
import com.mrbysco.densetrees.data.assets.DenseLanguageProvider;
import com.mrbysco.densetrees.data.data.DenseBiomeModifiers;
import com.mrbysco.densetrees.data.data.DenseBlockTagProvider;
import com.mrbysco.densetrees.data.data.DenseItemTagProvider;
import com.mrbysco.densetrees.data.data.DenseLootProvider;
import com.mrbysco.densetrees.data.data.DenseRecipeProvider;
import com.mrbysco.densetrees.world.DensePlacedFeatures;
import com.mrbysco.densetrees.world.DenseTreeFeatures;
import com.mrbysco.densetrees.world.DenseTreePlacements;
import com.mrbysco.densetrees.world.DenseVegetationFeatures;
import net.minecraft.core.Cloner;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.VanillaRegistries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DenseDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(true, new DenseRecipeProvider(packOutput, lookupProvider));
			generator.addProvider(true, new DenseLootProvider(packOutput));
			BlockTagsProvider provider;
			generator.addProvider(true, provider = new DenseBlockTagProvider(packOutput, lookupProvider, helper));
			generator.addProvider(true, new DenseItemTagProvider(packOutput, lookupProvider, provider, helper));

			generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(
					packOutput, CompletableFuture.supplyAsync(DenseDatagen::getProvider), Set.of(DenseTrees.MOD_ID)));
		}
		if (event.includeClient()) {
			generator.addProvider(true, new DenseLanguageProvider(packOutput));
			generator.addProvider(true, new DenseBlockStateProvider(packOutput, helper));
			generator.addProvider(true, new DenseItemModelProvider(packOutput, helper));
		}
	}

	private static RegistrySetBuilder.PatchedRegistries getProvider() {
		final RegistrySetBuilder registryBuilder = new RegistrySetBuilder();
		registryBuilder.add(Registries.CONFIGURED_FEATURE, context -> {
			DenseVegetationFeatures.bootstrap(context);
			DenseTreeFeatures.bootstrap(context);
		});
		registryBuilder.add(Registries.PLACED_FEATURE, context -> {
			DensePlacedFeatures.bootstrap(context);
			DenseTreePlacements.bootstrap(context);
		});
		registryBuilder.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, DenseBiomeModifiers::bootstrap);
		// We need the BIOME registry to be present, so we can use a biome tag, doesn't matter that it's empty
		registryBuilder.add(Registries.BIOME, $ -> {
		});
		RegistryAccess.Frozen regAccess = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
		Cloner.Factory cloner$factory = new Cloner.Factory();
		net.neoforged.neoforge.registries.DataPackRegistriesHooks.getDataPackRegistriesWithDimensions().forEach(data -> data.runWithArguments(cloner$factory::addCodec));
		return registryBuilder.buildPatch(regAccess, VanillaRegistries.createLookup(), cloner$factory);
	}
}
