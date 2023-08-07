package com.example.villagers_empowered;

import com.example.villagers_empowered.block.ModBlocks;
import com.example.villagers_empowered.item.ModItems;
import com.example.villagers_empowered.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class villagers_empowered implements ModInitializer {
    //savanna and snowy
    //fix height of structure
    public static final String MOD_ID = "villagers_empowered";
    public static final Logger LOGGER = LoggerFactory.getLogger("villagers_empowered");

    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModVillagers.registerVillagers();
        ModVillagers.registerTrades();
    }
}
