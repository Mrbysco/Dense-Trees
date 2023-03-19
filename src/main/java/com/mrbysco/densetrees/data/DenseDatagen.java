package com.mrbysco.densetrees.data;

import com.mrbysco.densetrees.data.assets.DenseBlockStateProvider;
import com.mrbysco.densetrees.data.assets.DenseItemModelProvider;
import com.mrbysco.densetrees.data.assets.DenseLanguageProvider;
import com.mrbysco.densetrees.data.data.DenseBlockTagProvider;
import com.mrbysco.densetrees.data.data.DenseItemTagProvider;
import com.mrbysco.densetrees.data.data.DenseLootProvider;
import com.mrbysco.densetrees.data.data.DenseRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DenseDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(new DenseRecipeProvider(generator));
			generator.addProvider(new DenseLootProvider(generator));
			BlockTagsProvider provider;
			generator.addProvider(provider = new DenseBlockTagProvider(generator, helper));
			generator.addProvider(new DenseItemTagProvider(generator, provider, helper));
		}
		if (event.includeClient()) {
			generator.addProvider(new DenseLanguageProvider(generator));
			generator.addProvider(new DenseBlockStateProvider(generator, helper));
			generator.addProvider(new DenseItemModelProvider(generator, helper));
		}
	}
}
