package com.mrbysco.densetrees.data;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.data.assets.DenseBlockStateProvider;
import com.mrbysco.densetrees.data.assets.DenseItemModelProvider;
import com.mrbysco.densetrees.data.assets.DenseLanguageProvider;
import com.mrbysco.densetrees.data.data.DenseBiomeModifiers;
import com.mrbysco.densetrees.data.data.DenseBlockTagProvider;
import com.mrbysco.densetrees.data.data.DenseItemTagProvider;
import com.mrbysco.densetrees.data.data.DenseLootProvider;
import com.mrbysco.densetrees.data.data.DenseRecipeProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.RegistryOps;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DenseDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		final RegistryOps<JsonElement> ops = RegistryOps.create(JsonOps.INSTANCE, RegistryAccess.builtinCopy());
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(true, new DenseRecipeProvider(generator));
			generator.addProvider(true, new DenseLootProvider(generator));
			BlockTagsProvider provider;
			generator.addProvider(true, provider = new DenseBlockTagProvider(generator, helper));
			generator.addProvider(true, new DenseItemTagProvider(generator, provider, helper));

			generator.addProvider(event.includeServer(), JsonCodecProvider.forDatapackRegistry(generator, helper, DenseTrees.MOD_ID, ops, Registry.PLACED_FEATURE_REGISTRY, DenseBiomeModifiers.getPlacedFeatures(ops)));
			generator.addProvider(event.includeServer(), JsonCodecProvider.forDatapackRegistry(generator, helper, DenseTrees.MOD_ID, ops, ForgeRegistries.Keys.BIOME_MODIFIERS, DenseBiomeModifiers.getBiomeModifiers(ops)));
		}
		if (event.includeClient()) {
			generator.addProvider(true, new DenseLanguageProvider(generator));
			generator.addProvider(true, new DenseBlockStateProvider(generator, helper));
			generator.addProvider(true, new DenseItemModelProvider(generator, helper));
		}
	}
}
