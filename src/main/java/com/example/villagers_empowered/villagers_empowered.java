package com.example.villagers_empowered;

import com.example.villagers_empowered.block.ModBlocks;
import com.example.villagers_empowered.item.ModItems;
import com.example.villagers_empowered.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerData;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

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
