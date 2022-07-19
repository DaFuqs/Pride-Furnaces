package de.dafuqs.pridefurnaces;

import net.minecraft.block.BlockState;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PrideFurnaceBlock extends FurnaceBlock {

    public PrideFurnaceBlock(Settings settings) {
        super(settings);
    }
    
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PrideFurnaceBlockEntity(pos, state);
    }
    
    protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof PrideFurnaceBlockEntity) {
            player.openHandledScreen((NamedScreenHandlerFactory)blockEntity);
            player.incrementStat(Stats.INTERACT_WITH_FURNACE); // yeah, why not. It's a furnace after all
        }
    }
    
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(world, type, PrideFurnaces.PRIDE_FURNACE_BLOCK_ENTITY_TYPE);
    }
    
}
