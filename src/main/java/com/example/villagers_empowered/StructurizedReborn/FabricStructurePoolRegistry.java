package com.example.villagers_empowered.StructurizedReborn;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.structure.pool.ListPoolElement;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePoolElementType;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.processor.StructureProcessorLists;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.math.random.LocalRandom;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.*;

public class FabricStructurePoolRegistry {

    private static final Multimap<String, Quintuple<String,String,String,String, Integer>> structures_info = LinkedHashMultimap.create();
    private static final Map<String,String> structures_key_ref = new HashMap<>();
    private static final Multimap<String, Pair<String,RegistryEntry<PlacedFeature>>> feature_structures = LinkedHashMultimap.create();
    private static final Multimap<String, ListPoolElement> list_structures = LinkedHashMultimap.create();

    public static void registerSimple(Identifier poolId,Identifier structureId, int weight){
        register(poolId,structureId,weight, StructureProcessorLists.EMPTY,StructurePool.Projection.RIGID, StructurePoolElementType.LEGACY_SINGLE_POOL_ELEMENT);
    }

    public static void register(Identifier poolId,Identifier structureId, int weight, RegistryEntry<StructureProcessorList> processor, StructurePool.Projection projection ,StructurePoolElementType<?> type){
        String poolType = Objects.requireNonNull(Registry.STRUCTURE_POOL_ELEMENT.getId(type)).toString();
        String processorId = Objects.requireNonNull(BuiltinRegistries.STRUCTURE_PROCESSOR_LIST.getId(processor.value())).toString();
        String projectionId = projection.getId();
        structures_info.put(poolId.toString(), new Quintuple<>(structureId.toString(), poolType, processorId, projectionId, weight));
        structures_key_ref.put(structureId.toString(),poolId.toString());
    }

    public static void processRegistry(FabricStructurePool structurePool){
        String poolId = structurePool.getUnderlyingPool().getId().toString();
        System.out.println(poolId);
        for (String key : structures_info.keys()){
            if (Objects.equals(key, poolId)){
                System.out.println("found a match with " + key);
                structures_info.get(key).forEach(value -> addToPool(structurePool,value, key)
                );
                structurePool.getUnderlyingPool().getElementIndicesInRandomOrder(new LocalRandom(5)).forEach(value -> System.out.println(value.toString()));
            }
        }
    }

    private static void addToPool(FabricStructurePool structurePool, Quintuple<String,String,String,String, Integer> quint, String key){
        List<StructurePoolElement> spe = new LinkedList<>();
        StructurePoolElementType<?> type = Registry.STRUCTURE_POOL_ELEMENT.get(new Identifier(quint.b));
        if (Objects.equals(type, StructurePoolElementType.SINGLE_POOL_ELEMENT)){
            spe.add(StructurePoolElement.ofProcessedSingle(quint.a,RegistryEntry.of(BuiltinRegistries.STRUCTURE_PROCESSOR_LIST.get(new Identifier(quint.c)))).apply(StructurePool.Projection.getById(quint.d)));
        } else if (Objects.equals(type, StructurePoolElementType.LEGACY_SINGLE_POOL_ELEMENT)){
            System.out.println("adding" + quint.a);
            spe.add(StructurePoolElement.ofProcessedLegacySingle(quint.a,RegistryEntry.of(BuiltinRegistries.STRUCTURE_PROCESSOR_LIST.get(new Identifier(quint.c)))).apply(StructurePool.Projection.getById(quint.d)));
        }else if (Objects.equals(type, StructurePoolElementType.LIST_POOL_ELEMENT)){
            spe.addAll(list_structures.get(key));
        }else if (Objects.equals(type, StructurePoolElementType.FEATURE_POOL_ELEMENT)){
            List<StructurePoolElement> finalSpe = new LinkedList<>();
            feature_structures.get(key).forEach(
                    value -> {if(value.getLeft().equals(quint.a)){
                        finalSpe.add(StructurePoolElement.ofFeature(value.getRight()).apply(StructurePool.Projection.getById(quint.d)));
                    }}
            );
            spe.addAll(finalSpe);
        } else {
            spe.add(StructurePoolElement.ofEmpty().apply(StructurePool.Projection.RIGID));
        }
        spe.forEach(value -> structurePool.addStructurePoolElement(value,quint.e));
    }

    static{
        StructurePoolAddCallback.EVENT.register(FabricStructurePoolRegistry::processRegistry);
    }

    private record  Quintuple<A, B, C, D, E>(A a, B b, C c, D d, E e) {


    }
}
