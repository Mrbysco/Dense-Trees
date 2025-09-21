package com.mrbysco.densetrees.data;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.data.assets.DenseLanguageProvider;
import com.mrbysco.densetrees.data.assets.DenseModelProvider;
import com.mrbysco.densetrees.data.data.DenseBlockTagProvider;
import com.mrbysco.densetrees.data.data.DenseDatapackProvider;
import com.mrbysco.densetrees.data.data.DenseItemTagProvider;
import com.mrbysco.densetrees.data.data.DenseLootProvider;
import com.mrbysco.densetrees.data.data.DenseRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber
public class DenseDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent.Client event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		generator.addProvider(true, new DenseRecipeProvider.Runner(packOutput, lookupProvider));
		generator.addProvider(true, new DenseLootProvider(packOutput, lookupProvider));
		BlockTagsProvider provider;
		generator.addProvider(true, provider = new DenseBlockTagProvider(packOutput, lookupProvider));
		generator.addProvider(true, new DenseItemTagProvider(packOutput, lookupProvider, provider));

		generator.addProvider(true, new DenseDatapackProvider(
				packOutput,
				event.getLookupProvider(),
				Set.of(DenseTrees.MOD_ID)
		));

		generator.addProvider(true, new DenseLanguageProvider(packOutput));
		generator.addProvider(true, new DenseModelProvider(packOutput));
	}
}
