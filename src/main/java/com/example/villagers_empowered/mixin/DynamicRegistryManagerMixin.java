package com.example.villagers_empowered.mixin;

import com.example.villagers_empowered.StructurizedReborn.FabricStructurePoolImpl;
import com.example.villagers_empowered.StructurizedReborn.StructurePoolAddCallback;
import com.google.gson.JsonElement;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.util.dynamic.RegistryLoader;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;


@Mixin(DynamicRegistryManager.class)
public interface DynamicRegistryManagerMixin {
    @Inject(method = "load(Lcom/mojang/serialization/DynamicOps;Lnet/minecraft/util/dynamic/RegistryLoader$LoaderAccess;Lnet/minecraft/util/registry/DynamicRegistryManager$Info;)V", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
    private static <E> void load(DynamicOps<JsonElement> ops, RegistryLoader.LoaderAccess loaderAccess, DynamicRegistryManager.Info<E> info, CallbackInfo ci, DataResult dataResult) {
        RegistryKey<? extends Registry<E>> registryKey = info.registry();
        if (registryKey.equals(Registry.STRUCTURE_POOL_KEY)) {
            for (E registryEntry : loaderAccess.dynamicRegistryManager().get(registryKey)) {
                if (registryEntry instanceof StructurePool pool) {
                    StructurePoolAddCallback.EVENT.invoker().onAdd(new FabricStructurePoolImpl(pool));
                }
            }
        }
    }
}
