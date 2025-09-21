package com.mrbysco.densetrees.registry;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.block.DenseLogBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DenseRegistry {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DenseTrees.MOD_ID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DenseTrees.MOD_ID);

	public static final DeferredBlock<Block> DENSE_OAK_LOG = BLOCKS.registerBlock("dense_oak_log", (properties) -> denseLog(properties, MapColor.WOOD, MapColor.PODZOL));
	public static final DeferredBlock<Block> DENSE_SPRUCE_LOG = BLOCKS.registerBlock("dense_spruce_log", (properties) -> denseLog(properties, MapColor.PODZOL, MapColor.COLOR_BROWN));
	public static final DeferredBlock<Block> DENSE_BIRCH_LOG = BLOCKS.registerBlock("dense_birch_log", (properties) -> denseLog(properties, MapColor.SAND, MapColor.QUARTZ));
	public static final DeferredBlock<Block> DENSE_JUNGLE_LOG = BLOCKS.registerBlock("dense_jungle_log", (properties) -> denseLog(properties, MapColor.DIRT, MapColor.PODZOL));
	public static final DeferredBlock<Block> DENSE_ACACIA_LOG = BLOCKS.registerBlock("dense_acacia_log", (properties) -> denseLog(properties, MapColor.COLOR_ORANGE, MapColor.STONE));
	public static final DeferredBlock<Block> DENSE_DARK_OAK_LOG = BLOCKS.registerBlock("dense_dark_oak_log", (properties) -> denseLog(properties, MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
	public static final DeferredBlock<Block> DENSE_MANGROVE_LOG = BLOCKS.registerBlock("dense_mangrove_log", (properties) -> denseLog(properties, MapColor.COLOR_RED, MapColor.PODZOL));
	public static final DeferredBlock<Block> DENSE_CHERRY_LOG = BLOCKS.registerBlock("dense_cherry_log", (properties) -> denseLog(properties, MapColor.COLOR_RED, MapColor.PODZOL));
	public static final DeferredBlock<Block> DENSE_CRIMSON_STEM = BLOCKS.registerBlock("dense_crimson_stem", (properties) -> denseNetherStem(properties, MapColor.CRIMSON_STEM));
	public static final DeferredBlock<Block> DENSE_WARPED_STEM = BLOCKS.registerBlock("dense_warped_stem", (properties) -> denseNetherStem(properties, MapColor.CRIMSON_STEM));

	public static final DeferredItem<BlockItem> DENSE_OAK_LOG_ITEM = ITEMS.registerSimpleBlockItem(DENSE_OAK_LOG);
	public static final DeferredItem<BlockItem> DENSE_SPRUCE_LOG_ITEM = ITEMS.registerSimpleBlockItem(DENSE_SPRUCE_LOG);
	public static final DeferredItem<BlockItem> DENSE_BIRCH_LOG_ITEM = ITEMS.registerSimpleBlockItem(DENSE_BIRCH_LOG);
	public static final DeferredItem<BlockItem> DENSE_JUNGLE_LOG_ITEM = ITEMS.registerSimpleBlockItem(DENSE_JUNGLE_LOG);
	public static final DeferredItem<BlockItem> DENSE_ACACIA_LOG_ITEM = ITEMS.registerSimpleBlockItem(DENSE_ACACIA_LOG);
	public static final DeferredItem<BlockItem> DENSE_DARK_OAK_LOG_ITEM = ITEMS.registerSimpleBlockItem(DENSE_DARK_OAK_LOG);
	public static final DeferredItem<BlockItem> DENSE_MANGROVE_LOG_ITEM = ITEMS.registerSimpleBlockItem(DENSE_MANGROVE_LOG);
	public static final DeferredItem<BlockItem> DENSE_CHERRY_LOG_ITEM = ITEMS.registerSimpleBlockItem(DENSE_CHERRY_LOG);
	public static final DeferredItem<BlockItem> DENSE_CRIMSON_STEM_ITEM = ITEMS.registerSimpleBlockItem(DENSE_CRIMSON_STEM);
	public static final DeferredItem<BlockItem> DENSE_WARPED_STEM_ITEM = ITEMS.registerSimpleBlockItem(DENSE_WARPED_STEM);


	private static DenseLogBlock denseLog(BlockBehaviour.Properties properties, MapColor color, MapColor color2) {
		return new DenseLogBlock(properties.mapColor((state) -> {
			return state.getValue(DenseLogBlock.AXIS) == Direction.Axis.Y ? color : color2;
		}).instrument(NoteBlockInstrument.BASS).ignitedByLava().strength(4.0F).sound(SoundType.WOOD));
	}

	private static DenseLogBlock denseNetherStem(BlockBehaviour.Properties properties, MapColor color) {
		return new DenseLogBlock(properties.mapColor((p_152620_) -> {
			return color;
		}).strength(4.0F).sound(SoundType.STEM));
	}
}
