package com.example.villagers_empowered.world.village;

import com.example.villagers_empowered.StructurizedReborn.FabricStructurePoolRegistry;
import com.example.villagers_empowered.villagers_empowered;
import net.minecraft.util.Identifier;

public class VillageAdditions {
    public static void registerNewVillageStructures() {
        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/plains/houses"),
                new Identifier(villagers_empowered.MOD_ID, "packed_house"), 2
        );
    }
}
