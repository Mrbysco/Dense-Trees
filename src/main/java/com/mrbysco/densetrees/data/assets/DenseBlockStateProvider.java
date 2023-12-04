package com.mrbysco.densetrees.data.assets;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class DenseBlockStateProvider extends BlockStateProvider {
	public DenseBlockStateProvider(PackOutput packOutput, ExistingFileHelper fileHelper) {
		super(packOutput, DenseTrees.MOD_ID, fileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		for (DeferredHolder<Block, ? extends Block> deferredHolder : DenseRegistry.BLOCKS.getEntries()) {
			if (deferredHolder.get() instanceof RotatedPillarBlock)
				denseLogBlock(deferredHolder);
		}
	}

	public void denseLogBlock(DeferredHolder<Block, ? extends Block> block) {
		String vanillaPath = "block/" + block.getId().getPath().replace("dense_", "");
		axisBlock((RotatedPillarBlock) block.get(), new ResourceLocation(vanillaPath), new ResourceLocation(vanillaPath + "_top"));
	}
}
