package com.example.villagers_empowered.mixin;

import net.minecraft.structure.pool.StructurePools;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(StructurePools.class)
public class StructurePoolsMixin {

   /* @Inject(method = "bootstrap", at = @At(value = "HEAD"))
    private static void structurized_reborn_getBootstrapRegisterables(Registerable<StructurePool> structurePoolsRegisterable, CallbackInfo ci){
        System.out.println("Grabbed registerable");
        FabricStructurePoolRegistry.registryEntryLookup = structurePoolsRegisterable;
    }*/

}
