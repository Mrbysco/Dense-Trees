package com.mrbysco.densetrees.data.data;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class DenseBlockTagProvider extends BlockTagsProvider {
	public DenseBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
								 @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, DenseTrees.MOD_ID, existingFileHelper);
	}

	@Override
	public void addTags(HolderLookup.Provider lookupProvider) {
		this.tag(BlockTags.LOGS).add(DenseRegistry.DENSE_OAK_LOG.get(), DenseRegistry.DENSE_SPRUCE_LOG.get(),
				DenseRegistry.DENSE_BIRCH_LOG.get(), DenseRegistry.DENSE_JUNGLE_LOG.get(),
				DenseRegistry.DENSE_ACACIA_LOG.get(), DenseRegistry.DENSE_DARK_OAK_LOG.get(),
				DenseRegistry.DENSE_MANGROVE_LOG.get(), DenseRegistry.DENSE_CHERRY_LOG.get());
		this.tag(BlockTags.LOGS_THAT_BURN).add(DenseRegistry.DENSE_OAK_LOG.get(), DenseRegistry.DENSE_SPRUCE_LOG.get(),
				DenseRegistry.DENSE_BIRCH_LOG.get(), DenseRegistry.DENSE_JUNGLE_LOG.get(),
				DenseRegistry.DENSE_ACACIA_LOG.get(), DenseRegistry.DENSE_DARK_OAK_LOG.get(),
				DenseRegistry.DENSE_MANGROVE_LOG.get(), DenseRegistry.DENSE_CHERRY_LOG.get());
		this.tag(BlockTags.CRIMSON_STEMS).add(DenseRegistry.DENSE_CRIMSON_STEM.get());
		this.tag(BlockTags.WARPED_STEMS).add(DenseRegistry.DENSE_WARPED_STEM.get());
		this.tag(BlockTags.MINEABLE_WITH_AXE).add(DenseRegistry.DENSE_OAK_LOG.get(), DenseRegistry.DENSE_SPRUCE_LOG.get(),
				DenseRegistry.DENSE_BIRCH_LOG.get(), DenseRegistry.DENSE_JUNGLE_LOG.get(),
				DenseRegistry.DENSE_ACACIA_LOG.get(), DenseRegistry.DENSE_DARK_OAK_LOG.get(),
				DenseRegistry.DENSE_MANGROVE_LOG.get(), DenseRegistry.DENSE_CHERRY_LOG.get());
	}
}
