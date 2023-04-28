package com.example.villagers_empowered.block;

import com.example.villagers_empowered.villagers_empowered;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block LIFARMIAN_TABLE = registerBlock("lifarmian_table",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(2.5f).hardness(2.5f).requiresTool()), ItemGroup.MISC);
    public static final Block FLASONIC_TABLE = registerBlock("flasonic_table",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(2.5f).hardness(2.5f).requiresTool()), ItemGroup.MISC);
    public static final Block CREATURE_CARRIER_BLOCK = registerBlock("creature_carrier_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3.5f).hardness(3.5f).requiresTool()), ItemGroup.MISC);
    public static final Block PACKED_BOOKSHELF = registerBlock("packed_bookshelf",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(4f).hardness(4f).requiresTool()), ItemGroup.MISC);

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(villagers_empowered.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(villagers_empowered.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(villagers_empowered.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        villagers_empowered.LOGGER.debug("Registering ModBlocks for " + villagers_empowered.MOD_ID);
    }
}
