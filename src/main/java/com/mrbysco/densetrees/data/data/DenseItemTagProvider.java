package com.mrbysco.densetrees.data.data;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class DenseItemTagProvider extends ItemTagsProvider {
	public DenseItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
								TagsProvider<Block> blockTagProvider, ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, blockTagProvider.contentsGetter(), DenseTrees.MOD_ID, existingFileHelper);
	}

	@Override
	public void addTags(HolderLookup.Provider lookupProvider) {
		this.tag(ItemTags.LOGS).add(DenseRegistry.DENSE_OAK_LOG_ITEM.get(), DenseRegistry.DENSE_SPRUCE_LOG_ITEM.get(),
				DenseRegistry.DENSE_BIRCH_LOG_ITEM.get(), DenseRegistry.DENSE_JUNGLE_LOG_ITEM.get(),
				DenseRegistry.DENSE_ACACIA_LOG_ITEM.get(), DenseRegistry.DENSE_DARK_OAK_LOG_ITEM.get(),
				DenseRegistry.DENSE_MANGROVE_LOG_ITEM.get(), DenseRegistry.DENSE_CHERRY_LOG_ITEM.get());
		this.tag(ItemTags.CRIMSON_STEMS).add(DenseRegistry.DENSE_CRIMSON_STEM_ITEM.get());
		this.tag(ItemTags.WARPED_STEMS).add(DenseRegistry.DENSE_WARPED_STEM_ITEM.get());
		this.tag(ItemTags.NON_FLAMMABLE_WOOD).add(DenseRegistry.DENSE_CRIMSON_STEM_ITEM.get(), DenseRegistry.DENSE_WARPED_STEM_ITEM.get());
	}
}
