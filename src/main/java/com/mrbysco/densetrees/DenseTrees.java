package com.mrbysco.densetrees;

import com.mojang.logging.LogUtils;
import com.mrbysco.densetrees.config.DenseConfig;
import com.mrbysco.densetrees.handler.SaplingHandler;
import com.mrbysco.densetrees.registry.DenseModifiers;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;

import java.util.List;

@Mod(DenseTrees.MOD_ID)
public class DenseTrees {
	public static final Logger LOGGER = LogUtils.getLogger();
	public static final String MOD_ID = "densetrees";

	public DenseTrees(IEventBus eventBus) {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DenseConfig.commonSpec);
		eventBus.register(DenseConfig.class);

		eventBus.addListener(this::registerCreativeTab);

		DenseRegistry.BLOCKS.register(eventBus);
		DenseRegistry.ITEMS.register(eventBus);
		DenseModifiers.BIOME_MODIFIER_SERIALIZERS.register(eventBus);

		NeoForge.EVENT_BUS.register(new SaplingHandler());
	}

	private void registerCreativeTab(final BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			List<ItemStack> stacks = DenseRegistry.ITEMS.getEntries().stream().map(reg -> new ItemStack(reg.get())).toList();
			event.acceptAll(stacks);
		}
	}
}
