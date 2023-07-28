package com.example.villagers_empowered;

import com.example.villagers_empowered.block.ModBlocks;
import com.example.villagers_empowered.item.ModItems;
import com.example.villagers_empowered.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class villagers_empowered implements ModInitializer {
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