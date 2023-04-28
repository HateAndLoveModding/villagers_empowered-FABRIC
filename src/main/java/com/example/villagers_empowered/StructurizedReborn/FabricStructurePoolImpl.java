package com.example.villagers_empowered.StructurizedReborn;

import com.example.villagers_empowered.mixin.StructurePoolAccessor;
import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;

import java.util.ArrayList;
import java.util.List;


public class FabricStructurePoolImpl implements FabricStructurePool {
    private final StructurePool pool;

    public FabricStructurePoolImpl(StructurePool pool) {
        this.pool = pool;
    }

    @Override
    public void addStructurePoolElement(StructurePoolElement element) {
        addStructurePoolElement(element, 1);
    }

    @Override
    public void addStructurePoolElement(StructurePoolElement element, int weight) {
        //adds to elementCounts list; minecraft makes these immutable lists, so we replace them with an array list
        StructurePoolAccessor pool = (StructurePoolAccessor) getUnderlyingPool();

        if (pool.getElementCounts() instanceof ArrayList) {
            pool.getElementCounts().add(Pair.of(element, weight));
        } else {
            List<Pair<StructurePoolElement, Integer>> list = new ArrayList<>(pool.getElementCounts());
            list.add(Pair.of(element, weight));
            pool.setElementCounts(list);
        }

        //adds to elements list
        for (int i = 0; i < weight; i++) {
            pool.getElements().add(element);
        }
    }

    @Override
    public StructurePool getUnderlyingPool() {
        return pool;
    }
}
