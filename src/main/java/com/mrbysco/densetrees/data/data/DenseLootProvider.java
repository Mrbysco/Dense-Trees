package com.mrbysco.densetrees.data.data;

import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DenseLootProvider extends LootTableProvider {
	public DenseLootProvider(PackOutput packOutput) {
		super(packOutput, Set.of(),
				List.of(
						new SubProviderEntry(FarmingBlocks::new, LootContextParamSets.BLOCK)
				)
		);
	}

	private static class FarmingBlocks extends BlockLootSubProvider {
		protected FarmingBlocks() {
			super(Set.of(), FeatureFlags.REGISTRY.allFlags());
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
	protected void validate(Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationtracker) {
		map.forEach((name, table) -> table.validate(validationtracker));
	}
}