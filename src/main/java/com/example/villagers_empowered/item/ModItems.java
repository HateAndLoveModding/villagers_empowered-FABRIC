package com.example.villagers_empowered.item;

import com.example.villagers_empowered.villagers_empowered;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item BASE_SPAWN_EGG = registerItem("base_spawn_egg",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item CHARGED_CREEPER_SPAWN_EGG = registerItem("charged_creeper_spawn_egg",
            new ChargedCreeperSpawnEgg(new FabricItemSettings().group(ItemGroup.MISC)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(villagers_empowered.MOD_ID, name), item);
    }

    public static void registerModItems() {
        villagers_empowered.LOGGER.debug("Registering Mod Items for " + villagers_empowered.MOD_ID);
    }


}
