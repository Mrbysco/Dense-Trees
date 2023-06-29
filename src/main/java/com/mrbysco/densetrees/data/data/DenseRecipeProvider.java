package com.mrbysco.densetrees.data.data;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class DenseRecipeProvider extends RecipeProvider {
	public DenseRecipeProvider(PackOutput packOutput) {
		super(packOutput);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
		planksFromDenseLog(consumer, Blocks.ACACIA_PLANKS, DenseRegistry.DENSE_ACACIA_LOG);
		planksFromDenseLog(consumer, Blocks.BIRCH_PLANKS, DenseRegistry.DENSE_BIRCH_LOG);
		planksFromDenseLog(consumer, Blocks.DARK_OAK_PLANKS, DenseRegistry.DENSE_DARK_OAK_LOG);
		planksFromDenseLog(consumer, Blocks.JUNGLE_PLANKS, DenseRegistry.DENSE_JUNGLE_LOG);
		planksFromDenseLog(consumer, Blocks.OAK_PLANKS, DenseRegistry.DENSE_OAK_LOG);
		planksFromDenseLog(consumer, Blocks.SPRUCE_PLANKS, DenseRegistry.DENSE_SPRUCE_LOG);
		planksFromDenseLog(consumer, Blocks.MANGROVE_PLANKS, DenseRegistry.DENSE_MANGROVE_LOG);
		planksFromDenseLog(consumer, Blocks.CHERRY_PLANKS, DenseRegistry.DENSE_CHERRY_LOG);
		planksFromDenseLog(consumer, Blocks.CRIMSON_PLANKS, DenseRegistry.DENSE_CRIMSON_STEM);
		planksFromDenseLog(consumer, Blocks.WARPED_PLANKS, DenseRegistry.DENSE_WARPED_STEM);

		logsFromDenseLog(consumer, Blocks.ACACIA_LOG, DenseRegistry.DENSE_ACACIA_LOG);
		logsFromDenseLog(consumer, Blocks.BIRCH_LOG, DenseRegistry.DENSE_BIRCH_LOG);
		logsFromDenseLog(consumer, Blocks.DARK_OAK_LOG, DenseRegistry.DENSE_DARK_OAK_LOG);
		logsFromDenseLog(consumer, Blocks.JUNGLE_LOG, DenseRegistry.DENSE_JUNGLE_LOG);
		logsFromDenseLog(consumer, Blocks.OAK_LOG, DenseRegistry.DENSE_OAK_LOG);
		logsFromDenseLog(consumer, Blocks.SPRUCE_LOG, DenseRegistry.DENSE_SPRUCE_LOG);
		logsFromDenseLog(consumer, Blocks.MANGROVE_LOG, DenseRegistry.DENSE_MANGROVE_LOG);
		logsFromDenseLog(consumer, Blocks.CHERRY_LOG, DenseRegistry.DENSE_CHERRY_LOG);
		stemsFromDenseLog(consumer, Blocks.CRIMSON_STEM, DenseRegistry.DENSE_CRIMSON_STEM);
		stemsFromDenseLog(consumer, Blocks.WARPED_STEM, DenseRegistry.DENSE_WARPED_STEM);
	}

	protected static void planksFromDenseLog(Consumer<FinishedRecipe> recipeConsumer, ItemLike planks, RegistryObject<Block> log) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 64)
				.requires(log.get()).group("planks").unlockedBy("has_log", has(log.get()))
				.save(recipeConsumer, new ResourceLocation(DenseTrees.MOD_ID, "planks_from_" + log.getId().getPath()));
	}

	protected static void logsFromDenseLog(Consumer<FinishedRecipe> recipeConsumer, ItemLike log, RegistryObject<Block> denseLog) {
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, log, 64)
				.pattern("##").pattern("##")
				.define('#', denseLog.get()).unlockedBy("has_dense_log", has(denseLog.get()))
				.save(recipeConsumer, new ResourceLocation(DenseTrees.MOD_ID, "logs_from_" + denseLog.getId().getPath()));
	}

	protected static void stemsFromDenseLog(Consumer<FinishedRecipe> recipeConsumer, ItemLike log, RegistryObject<Block> denseLog) {
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, log, 64)
				.pattern("##").pattern("##")
				.define('#', denseLog.get()).unlockedBy("has_dense_log", has(denseLog.get()))
				.save(recipeConsumer, new ResourceLocation(DenseTrees.MOD_ID, "stems_from_" + denseLog.getId().getPath()));
	}

}
