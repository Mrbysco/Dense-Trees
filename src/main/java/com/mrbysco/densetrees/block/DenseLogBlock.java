package com.mrbysco.densetrees.block;

import com.mrbysco.densetrees.registry.DenseRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DenseLogBlock extends RotatedPillarBlock {
	public DenseLogBlock(Properties properties) {
		super(properties);
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 5;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 5;
	}

	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return true;
	}

	@Override
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		super.animateTick(state, level, pos, random);

		if (level.isClientSide) {
			double yOffset = state.is(DenseRegistry.DENSE_MANGROVE_LOG.get()) ? -1.5D : 0;
			level.addParticle(ParticleTypes.GLOW,
					(double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D + yOffset, (double) pos.getZ() + 0.5D,
					(double) ((float) (level.random.nextFloat() - 0.5) * 2 + random.nextFloat()) - 0.5D,
					(double) ((float) (level.random.nextFloat() - 0.5) * 2 - random.nextFloat() - 1.0F),
					(double) ((float) (level.random.nextFloat() - 0.5) * 2 + random.nextFloat()) - 0.5D);
		}
	}
}
