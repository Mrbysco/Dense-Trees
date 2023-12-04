package com.mrbysco.densetrees.config;

import com.mrbysco.densetrees.DenseTrees;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class DenseConfig {
	public static class Common {
		public final ModConfigSpec.ConfigValue<List<? extends String>> biomeBlacklist;

		public final ModConfigSpec.BooleanValue enableSaplingToDenseTree;
		public final ModConfigSpec.DoubleValue saplingToDenseTreeChance;

		Common(ModConfigSpec.Builder builder) {
			builder.comment("General settings")
					.push("General");

			enableSaplingToDenseTree = builder
					.comment("Setting this to true will allow saplings to turn into dense trees [Default: true]")
					.define("enableSaplingToDenseTree", true);


			saplingToDenseTreeChance = builder
					.comment("Chance of a sapling turning into a dense tree. (0.05 = 5%) [Default: 0.05]")
					.defineInRange("saplingToDenseTreeChance", 0.05, 0, 1);


			builder.pop();
			builder.comment("Biome settings")
					.push("Biome");

			biomeBlacklist = builder
					.comment("Blacklist biomes from spawning dense trees. (Use the registry name of the biome) Example: \"minecraft:flower_forest\"")
					.defineListAllowEmpty(List.of("biomeBlacklist"), () -> List.of(""), o -> o instanceof String);

			builder.pop();
		}
	}

	public static final ModConfigSpec commonSpec;
	public static final Common COMMON;

	static {
		final Pair<Common, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Common::new);
		commonSpec = specPair.getRight();
		COMMON = specPair.getLeft();
	}

	@SubscribeEvent
	public static void onLoad(final ModConfigEvent.Loading configEvent) {
		DenseTrees.LOGGER.debug("Loaded Dense Trees' config file {}", configEvent.getConfig().getFileName());
	}

	@SubscribeEvent
	public static void onFileChange(final ModConfigEvent.Reloading configEvent) {
		DenseTrees.LOGGER.debug("Dense Trees' config just got changed on the file system!");
	}
}
