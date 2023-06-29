package com.mrbysco.densetrees.registry;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.block.DenseLogBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DenseRegistry {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DenseTrees.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DenseTrees.MOD_ID);

	public static final RegistryObject<Block> DENSE_OAK_LOG = BLOCKS.register("dense_oak_log", () -> denseLog(MapColor.WOOD, MapColor.PODZOL));
	public static final RegistryObject<Block> DENSE_SPRUCE_LOG = BLOCKS.register("dense_spruce_log", () -> denseLog(MapColor.PODZOL, MapColor.COLOR_BROWN));
	public static final RegistryObject<Block> DENSE_BIRCH_LOG = BLOCKS.register("dense_birch_log", () -> denseLog(MapColor.SAND, MapColor.QUARTZ));
	public static final RegistryObject<Block> DENSE_JUNGLE_LOG = BLOCKS.register("dense_jungle_log", () -> denseLog(MapColor.DIRT, MapColor.PODZOL));
	public static final RegistryObject<Block> DENSE_ACACIA_LOG = BLOCKS.register("dense_acacia_log", () -> denseLog(MapColor.COLOR_ORANGE, MapColor.STONE));
	public static final RegistryObject<Block> DENSE_DARK_OAK_LOG = BLOCKS.register("dense_dark_oak_log", () -> denseLog(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
	public static final RegistryObject<Block> DENSE_MANGROVE_LOG = BLOCKS.register("dense_mangrove_log", () -> denseLog(MapColor.COLOR_RED, MapColor.PODZOL));
	public static final RegistryObject<Block> DENSE_CHERRY_LOG = BLOCKS.register("dense_cherry_log", () -> denseLog(MapColor.COLOR_RED, MapColor.PODZOL));
	public static final RegistryObject<Block> DENSE_CRIMSON_STEM = BLOCKS.register("dense_crimson_stem", () -> denseNetherStem(MapColor.CRIMSON_STEM));
	public static final RegistryObject<Block> DENSE_WARPED_STEM = BLOCKS.register("dense_warped_stem", () -> denseNetherStem(MapColor.CRIMSON_STEM));

	public static final RegistryObject<Item> DENSE_OAK_LOG_ITEM = ITEMS.register("dense_oak_log", () -> new BlockItem(DENSE_OAK_LOG.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_SPRUCE_LOG_ITEM = ITEMS.register("dense_spruce_log", () -> new BlockItem(DENSE_SPRUCE_LOG.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_BIRCH_LOG_ITEM = ITEMS.register("dense_birch_log", () -> new BlockItem(DENSE_BIRCH_LOG.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_JUNGLE_LOG_ITEM = ITEMS.register("dense_jungle_log", () -> new BlockItem(DENSE_JUNGLE_LOG.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_ACACIA_LOG_ITEM = ITEMS.register("dense_acacia_log", () -> new BlockItem(DENSE_ACACIA_LOG.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_DARK_OAK_LOG_ITEM = ITEMS.register("dense_dark_oak_log", () -> new BlockItem(DENSE_DARK_OAK_LOG.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_MANGROVE_LOG_ITEM = ITEMS.register("dense_mangrove_log", () -> new BlockItem(DENSE_MANGROVE_LOG.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_CHERRY_LOG_ITEM = ITEMS.register("dense_cherry_log", () -> new BlockItem(DENSE_CHERRY_LOG.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_CRIMSON_STEM_ITEM = ITEMS.register("dense_crimson_stem", () -> new BlockItem(DENSE_CRIMSON_STEM.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_WARPED_STEM_ITEM = ITEMS.register("dense_warped_stem", () -> new BlockItem(DENSE_WARPED_STEM.get(), itemProperties()));


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

	private static Item.Properties itemProperties() {
		return new Item.Properties();
	}
}
