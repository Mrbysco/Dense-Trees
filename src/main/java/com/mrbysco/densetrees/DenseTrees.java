package com.mrbysco.densetrees;

import com.mojang.logging.LogUtils;
import com.mrbysco.densetrees.config.DenseConfig;
import com.mrbysco.densetrees.handler.SaplingHandler;
import com.mrbysco.densetrees.registry.DenseRegistry;
import com.mrbysco.densetrees.world.DenseTreeFeatures;
import com.mrbysco.densetrees.world.DenseTreePlacements;
import com.mrbysco.densetrees.world.DenseVegetationFeatures;
import com.mrbysco.densetrees.world.DenseVegetationPlacements;
import com.mrbysco.densetrees.world.DenseWorldGen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(DenseTrees.MOD_ID)
public class DenseTrees {
	public static final Logger LOGGER = LogUtils.getLogger();
	public static final String MOD_ID = "densetrees";

	public DenseTrees() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DenseConfig.commonSpec);
		eventBus.register(DenseConfig.class);

		DenseRegistry.BLOCKS.register(eventBus);
		DenseRegistry.ITEMS.register(eventBus);
		DenseTreeFeatures.CONFIGURED_FEATURES.register(eventBus);
		DenseTreePlacements.PLACED_FEATURES.register(eventBus);
		DenseVegetationFeatures.CONFIGURED_FEATURES.register(eventBus);
		DenseVegetationPlacements.PLACED_FEATURES.register(eventBus);

		MinecraftForge.EVENT_BUS.register(new SaplingHandler());
		MinecraftForge.EVENT_BUS.register(new DenseWorldGen());
	}
}
