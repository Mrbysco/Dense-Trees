package com.mrbysco.densetrees.data.assets;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class DenseItemModelProvider extends ItemModelProvider {
	public DenseItemModelProvider(PackOutput packOutput, ExistingFileHelper fileHelper) {
		super(packOutput, DenseTrees.MOD_ID, fileHelper);
	}

	@Override
	protected void registerModels() {
		for (DeferredHolder<Item, ? extends Item> deferredHolder : DenseRegistry.ITEMS.getEntries()) {
			if (deferredHolder.get() instanceof BlockItem blockItem && blockItem.getBlock() instanceof RotatedPillarBlock)
				withExistingParent(deferredHolder.getId().getPath(), modLoc("block/" + deferredHolder.getId().getPath()));
		}
	}
}
