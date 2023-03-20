package com.mrbysco.densetrees.data.assets;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class DenseLanguageProvider extends LanguageProvider {
	public DenseLanguageProvider(DataGenerator gen) {
		super(gen, DenseTrees.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		addBlock(DenseRegistry.DENSE_OAK_LOG, "Dense Oak Log");
		addBlock(DenseRegistry.DENSE_SPRUCE_LOG, "Dense Spruce Log");
		addBlock(DenseRegistry.DENSE_BIRCH_LOG, "Dense Birch Log");
		addBlock(DenseRegistry.DENSE_JUNGLE_LOG, "Dense Jungle Log");
		addBlock(DenseRegistry.DENSE_ACACIA_LOG, "Dense Acacia Log");
		addBlock(DenseRegistry.DENSE_DARK_OAK_LOG, "Dense Dark Oak Log");
		addBlock(DenseRegistry.DENSE_MANGROVE_LOG, "Dense Mangrove Log");
		addBlock(DenseRegistry.DENSE_CRIMSON_STEM, "Dense Crimson Stem");
		addBlock(DenseRegistry.DENSE_WARPED_STEM, "Dense Warped Stem");
	}
}
