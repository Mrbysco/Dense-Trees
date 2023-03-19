package com.mrbysco.densetrees.data.assets;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class DenseItemModelProvider extends ItemModelProvider {
	public DenseItemModelProvider(DataGenerator gen, ExistingFileHelper fileHelper) {
		super(gen, DenseTrees.MOD_ID, fileHelper);
	}

	@Override
	protected void registerModels() {
		for (RegistryObject<Item> registryObject : DenseRegistry.ITEMS.getEntries()) {
			if (registryObject.get() instanceof BlockItem blockItem && blockItem.getBlock() instanceof RotatedPillarBlock)
				withExistingParent(registryObject.getId().getPath(), modLoc("block/" + registryObject.getId().getPath()));
		}
	}
}
