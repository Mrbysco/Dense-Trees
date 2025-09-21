package com.mrbysco.densetrees.data.data;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class DenseItemTagProvider extends ItemTagsProvider {
	public DenseItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
	                            TagsProvider<Block> blockTagProvider) {
		super(output, lookupProvider, blockTagProvider.contentsGetter(), DenseTrees.MOD_ID);
	}

	@Override
	public void addTags(HolderLookup.Provider lookupProvider) {
		this.tag(ItemTags.OAK_LOGS).add(DenseRegistry.DENSE_OAK_LOG.asItem());
		this.tag(ItemTags.SPRUCE_LOGS).add(DenseRegistry.DENSE_SPRUCE_LOG.asItem());
		this.tag(ItemTags.BIRCH_LOGS).add(DenseRegistry.DENSE_BIRCH_LOG.asItem());
		this.tag(ItemTags.JUNGLE_LOGS).add(DenseRegistry.DENSE_JUNGLE_LOG.asItem());
		this.tag(ItemTags.ACACIA_LOGS).add(DenseRegistry.DENSE_ACACIA_LOG.asItem());
		this.tag(ItemTags.DARK_OAK_LOGS).add(DenseRegistry.DENSE_DARK_OAK_LOG.asItem());
		this.tag(ItemTags.MANGROVE_LOGS).add(DenseRegistry.DENSE_MANGROVE_LOG.asItem());
		this.tag(ItemTags.CHERRY_LOGS).add(DenseRegistry.DENSE_CHERRY_LOG.asItem());
		this.tag(ItemTags.PALE_OAK_LOGS).add(DenseRegistry.DENSE_PALE_OAK_LOG.asItem());
		this.tag(ItemTags.CRIMSON_STEMS).add(DenseRegistry.DENSE_CRIMSON_STEM_ITEM.get());
		this.tag(ItemTags.WARPED_STEMS).add(DenseRegistry.DENSE_WARPED_STEM_ITEM.get());
		this.tag(ItemTags.NON_FLAMMABLE_WOOD).add(DenseRegistry.DENSE_CRIMSON_STEM_ITEM.get(), DenseRegistry.DENSE_WARPED_STEM_ITEM.get());
	}
}
