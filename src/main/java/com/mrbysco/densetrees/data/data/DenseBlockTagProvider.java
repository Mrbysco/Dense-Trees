package com.mrbysco.densetrees.data.data;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class DenseBlockTagProvider extends BlockTagsProvider {
	public DenseBlockTagProvider(DataGenerator generator, @Nullable ExistingFileHelper fileHelper) {
		super(generator, DenseTrees.MOD_ID, fileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(BlockTags.LOGS).add(DenseRegistry.DENSE_OAK_LOG.get(), DenseRegistry.DENSE_SPRUCE_LOG.get(),
				DenseRegistry.DENSE_BIRCH_LOG.get(), DenseRegistry.DENSE_JUNGLE_LOG.get(),
				DenseRegistry.DENSE_ACACIA_LOG.get(), DenseRegistry.DENSE_DARK_OAK_LOG.get(), DenseRegistry.DENSE_MANGROVE_LOG.get());
		this.tag(BlockTags.LOGS_THAT_BURN).add(DenseRegistry.DENSE_OAK_LOG.get(), DenseRegistry.DENSE_SPRUCE_LOG.get(),
				DenseRegistry.DENSE_BIRCH_LOG.get(), DenseRegistry.DENSE_JUNGLE_LOG.get(),
				DenseRegistry.DENSE_ACACIA_LOG.get(), DenseRegistry.DENSE_DARK_OAK_LOG.get(), DenseRegistry.DENSE_MANGROVE_LOG.get());
		this.tag(BlockTags.CRIMSON_STEMS).add(DenseRegistry.DENSE_CRIMSON_STEM.get());
		this.tag(BlockTags.WARPED_STEMS).add(DenseRegistry.DENSE_WARPED_STEM.get());
		this.tag(BlockTags.NON_FLAMMABLE_WOOD).add(DenseRegistry.DENSE_CRIMSON_STEM.get(), DenseRegistry.DENSE_WARPED_STEM.get()); //TODO: Remove in 1.19.3 as the tag is removed there
		this.tag(BlockTags.MINEABLE_WITH_AXE).add(DenseRegistry.DENSE_OAK_LOG.get(), DenseRegistry.DENSE_SPRUCE_LOG.get(),
				DenseRegistry.DENSE_BIRCH_LOG.get(), DenseRegistry.DENSE_JUNGLE_LOG.get(),
				DenseRegistry.DENSE_ACACIA_LOG.get(), DenseRegistry.DENSE_DARK_OAK_LOG.get(), DenseRegistry.DENSE_MANGROVE_LOG.get());
	}
}
