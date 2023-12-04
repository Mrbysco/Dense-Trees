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

	public static final DeferredBlock<Block> DENSE_OAK_LOG = BLOCKS.register("dense_oak_log", () -> denseLog(MapColor.WOOD, MapColor.PODZOL));
	public static final DeferredBlock<Block> DENSE_SPRUCE_LOG = BLOCKS.register("dense_spruce_log", () -> denseLog(MapColor.PODZOL, MapColor.COLOR_BROWN));
	public static final DeferredBlock<Block> DENSE_BIRCH_LOG = BLOCKS.register("dense_birch_log", () -> denseLog(MapColor.SAND, MapColor.QUARTZ));
	public static final DeferredBlock<Block> DENSE_JUNGLE_LOG = BLOCKS.register("dense_jungle_log", () -> denseLog(MapColor.DIRT, MapColor.PODZOL));
	public static final DeferredBlock<Block> DENSE_ACACIA_LOG = BLOCKS.register("dense_acacia_log", () -> denseLog(MapColor.COLOR_ORANGE, MapColor.STONE));
	public static final DeferredBlock<Block> DENSE_DARK_OAK_LOG = BLOCKS.register("dense_dark_oak_log", () -> denseLog(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
	public static final DeferredBlock<Block> DENSE_MANGROVE_LOG = BLOCKS.register("dense_mangrove_log", () -> denseLog(MapColor.COLOR_RED, MapColor.PODZOL));
	public static final DeferredBlock<Block> DENSE_CHERRY_LOG = BLOCKS.register("dense_cherry_log", () -> denseLog(MapColor.COLOR_RED, MapColor.PODZOL));
	public static final DeferredBlock<Block> DENSE_CRIMSON_STEM = BLOCKS.register("dense_crimson_stem", () -> denseNetherStem(MapColor.CRIMSON_STEM));
	public static final DeferredBlock<Block> DENSE_WARPED_STEM = BLOCKS.register("dense_warped_stem", () -> denseNetherStem(MapColor.CRIMSON_STEM));

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


	private static DenseLogBlock denseLog(MapColor color, MapColor color2) {
		return new DenseLogBlock(BlockBehaviour.Properties.of().mapColor((state) -> {
			return state.getValue(DenseLogBlock.AXIS) == Direction.Axis.Y ? color : color2;
		}).instrument(NoteBlockInstrument.BASS).ignitedByLava().strength(4.0F).sound(SoundType.WOOD));
	}

	private static DenseLogBlock denseNetherStem(MapColor color) {
		return new DenseLogBlock(BlockBehaviour.Properties.of().mapColor((p_152620_) -> {
			return color;
		}).strength(4.0F).sound(SoundType.STEM));
	}
}
