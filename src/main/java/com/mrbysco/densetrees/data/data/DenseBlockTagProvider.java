package com.mrbysco.densetrees.data.data;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class DenseBlockTagProvider extends BlockTagsProvider {
	public DenseBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, lookupProvider, DenseTrees.MOD_ID);
	}

	@Override
	public void addTags(HolderLookup.Provider lookupProvider) {
		this.tag(BlockItemTags.OAK_LOGS.block()).add(DenseRegistry.DENSE_OAK_LOG.getKey());
		this.tag(BlockItemTags.SPRUCE_LOGS.block()).add(DenseRegistry.DENSE_SPRUCE_LOG.getKey());
		this.tag(BlockItemTags.BIRCH_LOGS.block()).add(DenseRegistry.DENSE_BIRCH_LOG.getKey());
		this.tag(BlockTags.JUNGLE_LOGS).add(DenseRegistry.DENSE_JUNGLE_LOG.getKey());
		this.tag(BlockItemTags.ACACIA_LOGS.block()).add(DenseRegistry.DENSE_ACACIA_LOG.getKey());
		this.tag(BlockItemTags.DARK_OAK_LOGS.block()).add(DenseRegistry.DENSE_DARK_OAK_LOG.getKey());
		this.tag(BlockItemTags.MANGROVE_LOGS.block()).add(DenseRegistry.DENSE_MANGROVE_LOG.getKey());
		this.tag(BlockItemTags.CHERRY_LOGS.block()).add(DenseRegistry.DENSE_CHERRY_LOG.getKey());
		this.tag(BlockItemTags.PALE_OAK_LOGS.block()).add(DenseRegistry.DENSE_PALE_OAK_LOG.getKey());
		this.tag(BlockItemTags.CRIMSON_STEMS.block()).add(DenseRegistry.DENSE_CRIMSON_STEM.getKey());
		this.tag(BlockItemTags.WARPED_STEMS.block()).add(DenseRegistry.DENSE_WARPED_STEM.getKey());
		this.tag(BlockTags.MINEABLE_WITH_AXE).add(DenseRegistry.DENSE_OAK_LOG.getKey(), DenseRegistry.DENSE_SPRUCE_LOG.getKey(),
				DenseRegistry.DENSE_BIRCH_LOG.getKey(), DenseRegistry.DENSE_JUNGLE_LOG.getKey(),
				DenseRegistry.DENSE_ACACIA_LOG.getKey(), DenseRegistry.DENSE_DARK_OAK_LOG.getKey(),
				DenseRegistry.DENSE_MANGROVE_LOG.getKey(), DenseRegistry.DENSE_CHERRY_LOG.getKey(),
				DenseRegistry.DENSE_PALE_OAK_LOG.getKey());
	}
}
