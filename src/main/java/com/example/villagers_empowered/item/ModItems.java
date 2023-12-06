package com.example.villagers_empowered.item;

import com.example.villagers_empowered.villagers_empowered;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BASE_SPAWN_EGG = registerItem("base_spawn_egg",
            new Item(new FabricItemSettings()));

    public static final Item CHARGED_CREEPER_SPAWN_EGG = registerItem("charged_creeper_spawn_egg",
            new ChargedCreeperSpawnEgg(new FabricItemSettings()));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(villagers_empowered.MOD_ID, name), item);
    }
    public static void addItemsToItemGroups() {

        addToItemGroup(ItemGroups.SPAWN_EGGS, BASE_SPAWN_EGG);
        addToItemGroup(ItemGroups.SPAWN_EGGS, CHARGED_CREEPER_SPAWN_EGG);
    }
    public static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        villagers_empowered.LOGGER.debug("Registering Mod Items for " + villagers_empowered.MOD_ID);
        addItemsToItemGroups();
    }


}
