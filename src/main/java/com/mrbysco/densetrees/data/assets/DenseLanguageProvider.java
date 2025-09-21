package com.mrbysco.densetrees.data.assets;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.jetbrains.annotations.Nullable;

public class DenseLanguageProvider extends LanguageProvider {
	public DenseLanguageProvider(PackOutput packOutput) {
		super(packOutput, DenseTrees.MOD_ID, "en_us");
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
		addBlock(DenseRegistry.DENSE_CHERRY_LOG, "Dense Cherry Log");
		addBlock(DenseRegistry.DENSE_CRIMSON_STEM, "Dense Crimson Stem");
		addBlock(DenseRegistry.DENSE_WARPED_STEM, "Dense Warped Stem");

		addConfig("General", "General", "General Settings");
		addConfig("enableSaplingToDenseTree", "Enable Sapling to Dense Tree", "Setting this to true will allow saplings to turn into dense trees");
		addConfig("saplingToDenseTreeChance", "Sapling to Dense Tree Chance", "Chance of a sapling turning into a dense tree. (0.05 = 5%)");
		addConfig("Biome", "Biome", "Biome Settings");
		addConfig("biomeBlacklist", "Biome Blacklist", "Blacklist biomes from spawning dense trees. (Use the registry name of the biome) Example: \"minecraft:flower_forest\"");
	}

	/**
	 * Add the translation for a config entry
	 *
	 * @param path        The path of the config entry
	 * @param name        The name of the config entry
	 * @param description The description of the config entry (optional in case of targeting "title" or similar entries that have no tooltip)
	 */
	private void addConfig(String path, String name, @Nullable String description) {
		this.add("densetrees.configuration." + path, name);
		if (description != null && !description.isEmpty())
			this.add("densetrees.configuration." + path + ".tooltip", description);
	}
}
