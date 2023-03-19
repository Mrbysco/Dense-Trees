package com.mrbysco.densetrees.data.data;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DenseItemTagProvider extends ItemTagsProvider {
	public DenseItemTagProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
		super(dataGenerator, blockTagsProvider, DenseTrees.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(ItemTags.LOGS).add(DenseRegistry.DENSE_OAK_LOG_ITEM.get(), DenseRegistry.DENSE_SPRUCE_LOG_ITEM.get(),
				DenseRegistry.DENSE_BIRCH_LOG_ITEM.get(), DenseRegistry.DENSE_JUNGLE_LOG_ITEM.get(),
				DenseRegistry.DENSE_ACACIA_LOG_ITEM.get(), DenseRegistry.DENSE_DARK_OAK_LOG_ITEM.get());
	}
}
