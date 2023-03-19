package com.mrbysco.densetrees.data.assets;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class DenseBlockStateProvider extends BlockStateProvider {
	public DenseBlockStateProvider(DataGenerator gen, ExistingFileHelper fileHelper) {
		super(gen, DenseTrees.MOD_ID, fileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		for (RegistryObject<Block> registryObject : DenseRegistry.BLOCKS.getEntries()) {
			if (registryObject.get() instanceof RotatedPillarBlock rotatedPillarBlock)
				denseLogBlock(rotatedPillarBlock);
		}
	}

	public void denseLogBlock(RotatedPillarBlock block) {
		String vanillaPath = "block/" + block.getRegistryName().getPath().replace("dense_", "");
		axisBlock(block, new ResourceLocation(vanillaPath), new ResourceLocation(vanillaPath + "_top"));
	}
}
