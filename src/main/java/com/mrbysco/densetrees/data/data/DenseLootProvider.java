package com.mrbysco.densetrees.data.data;

import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.registries.DeferredHolder;

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
			for (DeferredHolder<Block, ? extends Block> deferredHolder : DenseRegistry.BLOCKS.getEntries()) {
				if (deferredHolder.get() instanceof RotatedPillarBlock)
					this.dropSelf(deferredHolder.get());
			}

		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return (Iterable<Block>) DenseRegistry.BLOCKS.getEntries().stream().map(holder -> (Block) holder.get())::iterator;
		}
	}

	@Override
	protected void validate(WritableRegistry<LootTable> writableregistry, ValidationContext validationcontext, ProblemReporter.Collector problemreporter$collector) {
		super.validate(writableregistry, validationcontext, problemreporter$collector);
	}
}