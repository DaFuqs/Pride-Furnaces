package de.dafuqs.pridefurnaces;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PrideFurnaces implements ModInitializer {

    public static final String MOD_ID = "pridefurnaces";
	protected static final Logger LOGGER = LogUtils.getLogger();
    
    public static final List<String> STUFF_TO_BE_PROUD_OF = List.of("ace", "agender", "aro", "bi", "gay", "genderqueer", "lesbian", "nonbinary", "pan", "trans");
    public static final FabricItemSettings FURNACE_ITEM_SETTINGS = new FabricItemSettings().group(ItemGroup.DECORATIONS);
    
    public static List<Block> prideFurnaceBlocks = new ArrayList<>();
    public static BlockEntityType<? extends AbstractFurnaceBlockEntity> PRIDE_FURNACE_BLOCK_ENTITY_TYPE;
    
    private static void registerBlock(String name, Block block) {
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, name), block);
    }

    private static void registerItem(String name, Item item) {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), item);
    }
    
    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String id, FabricBlockEntityTypeBuilder.Factory<T> factory, Block... blocks) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, id), FabricBlockEntityTypeBuilder.create(factory, blocks).build());
    }

    @Override
    public void onInitialize() {
        log("Registering blocks and items...");
    
        for(String pride : STUFF_TO_BE_PROUD_OF) {
            String blockID = pride + "_furnace";
            Block block = new PrideFurnaceBlock(FabricBlockSettings.copyOf(Blocks.FURNACE));
            registerBlock(blockID, block);
            registerItem(blockID, new BlockItem(block, FURNACE_ITEM_SETTINGS));
            prideFurnaceBlocks.add(block);
        }
        
        Block[] blocks = prideFurnaceBlocks.toArray(new Block[0]);
        PRIDE_FURNACE_BLOCK_ENTITY_TYPE = registerBlockEntity("pride_furnace", PrideFurnaceBlockEntity::new, blocks);
        
        log("Startup finished!");
    }

    public static void log(String message) {
        LOGGER.info("[PrideFurnaces] " + message);
    }

}
