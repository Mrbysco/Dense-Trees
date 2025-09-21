package com.mrbysco.densetrees.data.assets;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;

public class DenseModelProvider extends ModelProvider {
	public DenseModelProvider(PackOutput packOutput) {
		super(packOutput, DenseTrees.MOD_ID);
	}

	@Override
	protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
		blockModels.woodProvider(Blocks.OAK_LOG).logWithHorizontal(DenseRegistry.DENSE_OAK_LOG.get());
		blockModels.woodProvider(Blocks.SPRUCE_LOG).logWithHorizontal(DenseRegistry.DENSE_SPRUCE_LOG.get());
		blockModels.woodProvider(Blocks.BIRCH_LOG).logWithHorizontal(DenseRegistry.DENSE_BIRCH_LOG.get());
		blockModels.woodProvider(Blocks.JUNGLE_LOG).logWithHorizontal(DenseRegistry.DENSE_JUNGLE_LOG.get());
		blockModels.woodProvider(Blocks.ACACIA_LOG).logWithHorizontal(DenseRegistry.DENSE_ACACIA_LOG.get());
		blockModels.woodProvider(Blocks.DARK_OAK_LOG).logWithHorizontal(DenseRegistry.DENSE_DARK_OAK_LOG.get());
		blockModels.woodProvider(Blocks.PALE_OAK_LOG).logWithHorizontal(DenseRegistry.DENSE_PALE_OAK_LOG.get());
		blockModels.woodProvider(Blocks.MANGROVE_LOG).logWithHorizontal(DenseRegistry.DENSE_MANGROVE_LOG.get());
		blockModels.woodProvider(Blocks.CHERRY_LOG).logWithHorizontal(DenseRegistry.DENSE_CHERRY_LOG.get());
		blockModels.woodProvider(Blocks.CRIMSON_STEM).logWithHorizontal(DenseRegistry.DENSE_CRIMSON_STEM.get());
		blockModels.woodProvider(Blocks.WARPED_STEM).logWithHorizontal(DenseRegistry.DENSE_WARPED_STEM.get());
	}
}
