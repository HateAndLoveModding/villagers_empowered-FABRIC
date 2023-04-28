package com.example.villagers_empowered.StructurizedReborn;

import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.util.Identifier;

public interface FabricStructurePool {
    void addStructurePoolElement(StructurePoolElement element, int weight);

    StructurePool getUnderlyingPool();

    default Identifier getId() {
        return getUnderlyingPool().getId();
    }
}
