package com.example.villagers_empowered.Main;

import com.example.villagers_empowered.villagers_empowered;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block LIFARMIAN_TABLE = registerBlock("lifarmian_table",
            new Block(FabricBlockSettings.copy(Blocks.OAK_WOOD).strength(2.5f).hardness(2.5f).requiresTool()));
    public static final Block FLASONIC_TABLE = registerBlock("flasonic_table",
            new Block(FabricBlockSettings.copy(Blocks.OAK_WOOD).strength(2.5f).hardness(2.5f).requiresTool()));
    public static final Block CREATURE_CARRIER_BLOCK = registerBlock("creature_carrier_block",
            new Block(FabricBlockSettings.copy(Blocks.IRON_BLOCK).strength(3.5f).hardness(3.5f).requiresTool()));
    public static final Block PACKED_BOOKSHELF = registerBlock("packed_bookshelf",
            new Block(FabricBlockSettings.copy(Blocks.OAK_WOOD).strength(4f).hardness(4f).requiresTool()));
    public static final Block ARTISANS_WORKBENCH = registerBlock("artisans_workbench",
            new Block(FabricBlockSettings.copy(Blocks.IRON_BLOCK).strength(5f).hardness(5f).requiresTool()));
    public static final Block POTION_STAND = registerBlock("potion_stand",
            new Block(FabricBlockSettings.copy(Blocks.BREWING_STAND).strength(3.5f).hardness(3.5f).requiresTool()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(villagers_empowered.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(villagers_empowered.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(item));
    }

    public static void registerModBlocks() {
        villagers_empowered.LOGGER.debug("Registering ModBlocks for " + villagers_empowered.MOD_ID);
    }
}
