package com.mrbysco.densetrees.data.data;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.concurrent.CompletableFuture;

public class DenseRecipeProvider extends RecipeProvider {
	public DenseRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
		super(provider, recipeOutput);
	}

	@Override
	protected void buildRecipes() {
		planksFromDenseLog(Blocks.ACACIA_PLANKS, DenseRegistry.DENSE_ACACIA_LOG);
		planksFromDenseLog(Blocks.BIRCH_PLANKS, DenseRegistry.DENSE_BIRCH_LOG);
		planksFromDenseLog(Blocks.DARK_OAK_PLANKS, DenseRegistry.DENSE_DARK_OAK_LOG);
		planksFromDenseLog(Blocks.PALE_OAK_PLANKS, DenseRegistry.DENSE_PALE_OAK_LOG);
		planksFromDenseLog(Blocks.JUNGLE_PLANKS, DenseRegistry.DENSE_JUNGLE_LOG);
		planksFromDenseLog(Blocks.OAK_PLANKS, DenseRegistry.DENSE_OAK_LOG);
		planksFromDenseLog(Blocks.SPRUCE_PLANKS, DenseRegistry.DENSE_SPRUCE_LOG);
		planksFromDenseLog(Blocks.MANGROVE_PLANKS, DenseRegistry.DENSE_MANGROVE_LOG);
		planksFromDenseLog(Blocks.CHERRY_PLANKS, DenseRegistry.DENSE_CHERRY_LOG);
		planksFromDenseLog(Blocks.CRIMSON_PLANKS, DenseRegistry.DENSE_CRIMSON_STEM);
		planksFromDenseLog(Blocks.WARPED_PLANKS, DenseRegistry.DENSE_WARPED_STEM);

		logsFromDenseLog(Blocks.ACACIA_LOG, DenseRegistry.DENSE_ACACIA_LOG);
		logsFromDenseLog(Blocks.BIRCH_LOG, DenseRegistry.DENSE_BIRCH_LOG);
		logsFromDenseLog(Blocks.DARK_OAK_LOG, DenseRegistry.DENSE_DARK_OAK_LOG);
		logsFromDenseLog(Blocks.PALE_OAK_LOG, DenseRegistry.DENSE_PALE_OAK_LOG);
		logsFromDenseLog(Blocks.JUNGLE_LOG, DenseRegistry.DENSE_JUNGLE_LOG);
		logsFromDenseLog(Blocks.OAK_LOG, DenseRegistry.DENSE_OAK_LOG);
		logsFromDenseLog(Blocks.SPRUCE_LOG, DenseRegistry.DENSE_SPRUCE_LOG);
		logsFromDenseLog(Blocks.MANGROVE_LOG, DenseRegistry.DENSE_MANGROVE_LOG);
		logsFromDenseLog(Blocks.CHERRY_LOG, DenseRegistry.DENSE_CHERRY_LOG);
		stemsFromDenseLog(Blocks.CRIMSON_STEM, DenseRegistry.DENSE_CRIMSON_STEM);
		stemsFromDenseLog(Blocks.WARPED_STEM, DenseRegistry.DENSE_WARPED_STEM);
	}

	protected void planksFromDenseLog(ItemLike planks, DeferredHolder<Block, ? extends Block> log) {
		shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 64)
				.requires(log.get()).group("planks").unlockedBy("has_log", has(log.get()))
				.save(this.output, DenseTrees.modLoc("planks_from_" + log.getId().getPath()).toString());
	}

	protected void logsFromDenseLog(ItemLike log, DeferredHolder<Block, ? extends Block> denseLog) {
		shaped(RecipeCategory.BUILDING_BLOCKS, log, 64)
				.pattern("##").pattern("##")
				.define('#', denseLog.get()).unlockedBy("has_dense_log", has(denseLog.get()))
				.save(this.output, DenseTrees.modLoc("logs_from_" + denseLog.getId().getPath()).toString());
	}

	protected void stemsFromDenseLog(ItemLike log, DeferredHolder<Block, ? extends Block> denseLog) {
		shaped(RecipeCategory.BUILDING_BLOCKS, log, 64)
				.pattern("##").pattern("##")
				.define('#', denseLog.get()).unlockedBy("has_dense_log", has(denseLog.get()))
				.save(this.output, DenseTrees.modLoc("stems_from_" + denseLog.getId().getPath()).toString());
	}

	public static class Runner extends RecipeProvider.Runner {
		public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
			super(output, completableFuture);
		}

		@Override
		protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
			return new DenseRecipeProvider(provider, recipeOutput);
		}

		@Override
		public String getName() {
			return "Dense Trees Recipes";
		}
	}

}
