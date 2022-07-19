package de.dafuqs.pridefurnaces;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class PrideFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    
    public PrideFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(PrideFurnaces.PRIDE_FURNACE_BLOCK_ENTITY_TYPE, pos, state, RecipeType.SMELTING);
    }
    
    @Override
    protected Text getContainerName() {
        if(world != null) {
            return world.getBlockState(pos).getBlock().getName();
        }
        return null;
    }
    
    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new FurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
    
}