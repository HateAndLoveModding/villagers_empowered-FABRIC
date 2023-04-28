package com.example.villagers_empowered;

import com.example.villagers_empowered.block.ModBlocks;
import com.example.villagers_empowered.item.ModItems;
import com.example.villagers_empowered.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class villagers_empowered implements ModInitializer {
	public static final String MOD_ID = "villagers_empowered";
	public static final Logger LOGGER = LogManager.getLogger("villagers_empowered");

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModVillagers.setupPOIs();
		ModVillagers.registerTrades();
	}
}