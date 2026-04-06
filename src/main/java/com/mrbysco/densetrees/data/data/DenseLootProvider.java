package com.mrbysco.densetrees.data.data;

import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DenseLootProvider extends LootTableProvider {
	public DenseLootProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, Set.of(),
				List.of(
						new SubProviderEntry(DenseBlockLoot::new, LootContextParamSets.BLOCK)
				)
				, lookupProvider);
	}

	private static class DenseBlockLoot extends BlockLootSubProvider {
		protected DenseBlockLoot(HolderLookup.Provider provider) {
			super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
		}

		@Override
		protected void generate() {
			dropLogsWithSilkTouch(DenseRegistry.DENSE_OAK_LOG, Blocks.OAK_LOG);
			dropLogsWithSilkTouch(DenseRegistry.DENSE_SPRUCE_LOG, Blocks.SPRUCE_LOG);
			dropLogsWithSilkTouch(DenseRegistry.DENSE_BIRCH_LOG, Blocks.BIRCH_LOG);
			dropLogsWithSilkTouch(DenseRegistry.DENSE_JUNGLE_LOG, Blocks.JUNGLE_LOG);
			dropLogsWithSilkTouch(DenseRegistry.DENSE_ACACIA_LOG, Blocks.ACACIA_LOG);
			dropLogsWithSilkTouch(DenseRegistry.DENSE_DARK_OAK_LOG, Blocks.DARK_OAK_LOG);
			dropLogsWithSilkTouch(DenseRegistry.DENSE_PALE_OAK_LOG, Blocks.PALE_OAK_LOG);
			dropLogsWithSilkTouch(DenseRegistry.DENSE_MANGROVE_LOG, Blocks.MANGROVE_LOG);
			dropLogsWithSilkTouch(DenseRegistry.DENSE_CHERRY_LOG, Blocks.CHERRY_LOG);
			dropLogsWithSilkTouch(DenseRegistry.DENSE_CRIMSON_STEM, Blocks.CRIMSON_STEM);
			dropLogsWithSilkTouch(DenseRegistry.DENSE_WARPED_STEM, Blocks.WARPED_STEM);
		}

		private void dropLogsWithSilkTouch(DeferredBlock<? extends Block> denseLog, Block regularLog) {
			this.add(denseLog.get(), (block) ->
					createSilkTouchDispatchTable(block,
							LootItem.lootTableItem(regularLog)
									.apply(SetItemCountFunction.setCount(ConstantValue.exactly(16.0F)))
					));
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return (Iterable<Block>) DenseRegistry.BLOCKS.getEntries().stream().map(holder -> (Block) holder.get())::iterator;
		}
	}
}