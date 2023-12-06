package com.example.villagers_empowered.StructurizedReborn;

import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;

public interface FabricStructurePool {
    void addStructurePoolElement(StructurePoolElement element, int weight);
    StructurePool getUnderlyingPool();
}
