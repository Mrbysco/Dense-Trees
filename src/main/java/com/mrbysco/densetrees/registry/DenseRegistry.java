package com.mrbysco.densetrees.registry;

import com.mrbysco.densetrees.DenseTrees;
import com.mrbysco.densetrees.block.DenseLogBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DenseRegistry {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DenseTrees.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DenseTrees.MOD_ID);

	public static final RegistryObject<Block> DENSE_OAK_LOG = BLOCKS.register("dense_oak_log", () -> denseLog(MaterialColor.WOOD, MaterialColor.PODZOL));
	public static final RegistryObject<Block> DENSE_SPRUCE_LOG = BLOCKS.register("dense_spruce_log", () -> denseLog(MaterialColor.PODZOL, MaterialColor.COLOR_BROWN));
	public static final RegistryObject<Block> DENSE_BIRCH_LOG = BLOCKS.register("dense_birch_log", () -> denseLog(MaterialColor.SAND, MaterialColor.QUARTZ));
	public static final RegistryObject<Block> DENSE_JUNGLE_LOG = BLOCKS.register("dense_jungle_log", () -> denseLog(MaterialColor.DIRT, MaterialColor.PODZOL));
	public static final RegistryObject<Block> DENSE_ACACIA_LOG = BLOCKS.register("dense_acacia_log", () -> denseLog(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> DENSE_DARK_OAK_LOG = BLOCKS.register("dense_dark_oak_log", () -> denseLog(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN));
	public static final RegistryObject<Block> DENSE_MANGROVE_LOG = BLOCKS.register("dense_mangrove_log", () -> denseLog(MaterialColor.COLOR_RED, MaterialColor.PODZOL));
	public static final RegistryObject<Block> DENSE_CRIMSON_STEM = BLOCKS.register("dense_crimson_stem", () -> denseNetherStem(MaterialColor.CRIMSON_STEM));
	public static final RegistryObject<Block> DENSE_WARPED_STEM = BLOCKS.register("dense_warped_stem", () -> denseNetherStem(MaterialColor.CRIMSON_STEM));

	public static final RegistryObject<Item> DENSE_OAK_LOG_ITEM = ITEMS.register("dense_oak_log", () -> new BlockItem(DENSE_OAK_LOG.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_SPRUCE_LOG_ITEM = ITEMS.register("dense_spruce_log", () -> new BlockItem(DENSE_SPRUCE_LOG.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_BIRCH_LOG_ITEM = ITEMS.register("dense_birch_log", () -> new BlockItem(DENSE_BIRCH_LOG.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_JUNGLE_LOG_ITEM = ITEMS.register("dense_jungle_log", () -> new BlockItem(DENSE_JUNGLE_LOG.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_ACACIA_LOG_ITEM = ITEMS.register("dense_acacia_log", () -> new BlockItem(DENSE_ACACIA_LOG.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_DARK_OAK_LOG_ITEM = ITEMS.register("dense_dark_oak_log", () -> new BlockItem(DENSE_DARK_OAK_LOG.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_MANGROVE_LOG_ITEM = ITEMS.register("dense_mangrove_log", () -> new BlockItem(DENSE_MANGROVE_LOG.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_CRIMSON_STEM_ITEM = ITEMS.register("dense_crimson_stem", () -> new BlockItem(DENSE_CRIMSON_STEM.get(), itemProperties()));
	public static final RegistryObject<Item> DENSE_WARPED_STEM_ITEM = ITEMS.register("dense_warped_stem", () -> new BlockItem(DENSE_WARPED_STEM.get(), itemProperties()));


	private static DenseLogBlock denseLog(MaterialColor color, MaterialColor color2) {
		return new DenseLogBlock(BlockBehaviour.Properties.of(Material.WOOD, (state) -> {
			return state.getValue(DenseLogBlock.AXIS) == Direction.Axis.Y ? color : color2;
		}).strength(4.0F).sound(SoundType.WOOD));
	}

	private static DenseLogBlock denseNetherStem(MaterialColor color) {
		return new DenseLogBlock(BlockBehaviour.Properties.of(Material.NETHER_WOOD, (p_152620_) -> {
			return color;
		}).strength(4.0F).sound(SoundType.STEM));
	}

	private static Item.Properties itemProperties() {
		return new Item.Properties();
	}
}
