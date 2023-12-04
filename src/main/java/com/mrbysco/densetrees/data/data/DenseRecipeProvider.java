package com.mrbysco.densetrees.data.data;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.concurrent.CompletableFuture;

public class DenseRecipeProvider extends RecipeProvider {
	public DenseRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, lookupProvider);
	}

	@Override
	protected void buildRecipes(RecipeOutput recipeOutput) {
		planksFromDenseLog(recipeOutput, Blocks.ACACIA_PLANKS, DenseRegistry.DENSE_ACACIA_LOG);
		planksFromDenseLog(recipeOutput, Blocks.BIRCH_PLANKS, DenseRegistry.DENSE_BIRCH_LOG);
		planksFromDenseLog(recipeOutput, Blocks.DARK_OAK_PLANKS, DenseRegistry.DENSE_DARK_OAK_LOG);
		planksFromDenseLog(recipeOutput, Blocks.JUNGLE_PLANKS, DenseRegistry.DENSE_JUNGLE_LOG);
		planksFromDenseLog(recipeOutput, Blocks.OAK_PLANKS, DenseRegistry.DENSE_OAK_LOG);
		planksFromDenseLog(recipeOutput, Blocks.SPRUCE_PLANKS, DenseRegistry.DENSE_SPRUCE_LOG);
		planksFromDenseLog(recipeOutput, Blocks.MANGROVE_PLANKS, DenseRegistry.DENSE_MANGROVE_LOG);
		planksFromDenseLog(recipeOutput, Blocks.CHERRY_PLANKS, DenseRegistry.DENSE_CHERRY_LOG);
		planksFromDenseLog(recipeOutput, Blocks.CRIMSON_PLANKS, DenseRegistry.DENSE_CRIMSON_STEM);
		planksFromDenseLog(recipeOutput, Blocks.WARPED_PLANKS, DenseRegistry.DENSE_WARPED_STEM);

		logsFromDenseLog(recipeOutput, Blocks.ACACIA_LOG, DenseRegistry.DENSE_ACACIA_LOG);
		logsFromDenseLog(recipeOutput, Blocks.BIRCH_LOG, DenseRegistry.DENSE_BIRCH_LOG);
		logsFromDenseLog(recipeOutput, Blocks.DARK_OAK_LOG, DenseRegistry.DENSE_DARK_OAK_LOG);
		logsFromDenseLog(recipeOutput, Blocks.JUNGLE_LOG, DenseRegistry.DENSE_JUNGLE_LOG);
		logsFromDenseLog(recipeOutput, Blocks.OAK_LOG, DenseRegistry.DENSE_OAK_LOG);
		logsFromDenseLog(recipeOutput, Blocks.SPRUCE_LOG, DenseRegistry.DENSE_SPRUCE_LOG);
		logsFromDenseLog(recipeOutput, Blocks.MANGROVE_LOG, DenseRegistry.DENSE_MANGROVE_LOG);
		logsFromDenseLog(recipeOutput, Blocks.CHERRY_LOG, DenseRegistry.DENSE_CHERRY_LOG);
		stemsFromDenseLog(recipeOutput, Blocks.CRIMSON_STEM, DenseRegistry.DENSE_CRIMSON_STEM);
		stemsFromDenseLog(recipeOutput, Blocks.WARPED_STEM, DenseRegistry.DENSE_WARPED_STEM);
	}

	protected static void planksFromDenseLog(RecipeOutput recipeOutput, ItemLike planks, DeferredHolder<Block, ? extends Block> log) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 64)
				.requires(log.get()).group("planks").unlockedBy("has_log", has(log.get()))
				.save(recipeOutput, new ResourceLocation(DenseTrees.MOD_ID, "planks_from_" + log.getId().getPath()));
	}

	protected static void logsFromDenseLog(RecipeOutput recipeOutput, ItemLike log, DeferredHolder<Block, ? extends Block> denseLog) {
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, log, 64)
				.pattern("##").pattern("##")
				.define('#', denseLog.get()).unlockedBy("has_dense_log", has(denseLog.get()))
				.save(recipeOutput, new ResourceLocation(DenseTrees.MOD_ID, "logs_from_" + denseLog.getId().getPath()));
	}

	protected static void stemsFromDenseLog(RecipeOutput recipeOutput, ItemLike log, DeferredHolder<Block, ? extends Block> denseLog) {
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, log, 64)
				.pattern("##").pattern("##")
				.define('#', denseLog.get()).unlockedBy("has_dense_log", has(denseLog.get()))
				.save(recipeOutput, new ResourceLocation(DenseTrees.MOD_ID, "stems_from_" + denseLog.getId().getPath()));
	}

}
