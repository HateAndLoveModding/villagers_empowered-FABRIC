package com.example.villagers_empowered.villager;

import com.example.villagers_empowered.block.ModBlocks;
import com.example.villagers_empowered.villagers_empowered;
import com.example.villagers_empowered.item.ModItems;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.mixin.object.builder.PointOfInterestTypeAccessor;
import net.fabricmc.fabric.mixin.object.builder.VillagerProfessionAccessor;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final PointOfInterestType FLASONIC_POI = registerPOI("flasonic_poi", ModBlocks.FLASONIC_TABLE);
    public static final VillagerProfession FLASONIC = registerProfession("flasonic", FLASONIC_POI);
    public static final PointOfInterestType LIFARMIAN_POI = registerPOI("lifarmian_poi", ModBlocks.LIFARMIAN_TABLE);
    public static final VillagerProfession LIFARMIAN = registerProfession("lifarmian", LIFARMIAN_POI);
    public static final PointOfInterestType CREATURE_CARRIER_POI = registerPOI("creature_carrier_poi", ModBlocks.CREATURE_CARRIER_BLOCK);
    public static final VillagerProfession CREATURE_CARRIER = registerProfession("creature_carrier", CREATURE_CARRIER_POI);

    public static VillagerProfession registerProfession(String name, PointOfInterestType type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(villagers_empowered.MOD_ID, name),
                VillagerProfessionAccessor.create(name, type, ImmutableSet.of(), ImmutableSet.of(),
                        SoundEvents.ENTITY_VILLAGER_WORK_ARMORER));
    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return Registry.register(Registry.POINT_OF_INTEREST_TYPE, new Identifier(villagers_empowered.MOD_ID, name),
                PointOfInterestTypeAccessor.callCreate(name,
                        ImmutableSet.copyOf(block.getStateManager().getStates()), 1, 1));
    }

    public static void setupPOIs() {
        PointOfInterestTypeAccessor.callSetup(FLASONIC_POI);
        PointOfInterestTypeAccessor.callSetup(LIFARMIAN_POI);
        PointOfInterestTypeAccessor.callSetup(CREATURE_CARRIER_POI);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(FLASONIC,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.WHEAT, 1), new ItemStack(Items.WHEAT_SEEDS, 2), new ItemStack(Items.EMERALD, 1), 25, 1, 0.005f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.BEETROOT, 1), new ItemStack(Items.BEETROOT_SEEDS, 2), new ItemStack(Items.EMERALD, 1), 25, 1, 0.005f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.CARROT, 2), new ItemStack(Items.EMERALD, 1), 25, 1, 0.005f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.POTATO, 2), new ItemStack(Items.EMERALD, 1), 25, 1, 0.005f)));
                });
        TradeOfferHelper.registerVillagerOffers(FLASONIC,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(Items.EMERALD, 1), 25, 2, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.BONE, 1), new ItemStack(Items.EMERALD, 1), 25, 2, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.GUNPOWDER, 1), new ItemStack(Items.EMERALD, 1), 25, 2, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.STRING, 1), new ItemStack(Items.EMERALD, 1), 25, 2, 0.02f)));
                });
        TradeOfferHelper.registerVillagerOffers(FLASONIC,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.IRON_INGOT, 1), new ItemStack(Items.EMERALD, 1), 25, 3, 0.03f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.GOLD_INGOT, 1), new ItemStack(Items.EMERALD, 1), 25, 3, 0.03f)));
                });
        TradeOfferHelper.registerVillagerOffers(FLASONIC,4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.PUMPKIN, 1), new ItemStack(Items.EMERALD, 1), 25, 4, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.MELON, 1), new ItemStack(Items.EMERALD, 1), 25, 4, 0.04f)));
                });
        TradeOfferHelper.registerVillagerOffers(FLASONIC,5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.BOOK, 1), new ItemStack(Items.EMERALD, 1), 24, 5, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.BOOKSHELF, 1), 8, 5, 0.05f)));
                });



        TradeOfferHelper.registerVillagerOffers(LIFARMIAN,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.STICK, 1), new ItemStack(Items.EMERALD, 1), 25, 1, 0.005f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.PAPER, 1), new ItemStack(Items.EMERALD, 1), 25, 1, 0.005f)));
                });
        TradeOfferHelper.registerVillagerOffers(LIFARMIAN,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.REDSTONE, 2), 12, 4, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.LAPIS_LAZULI, 1), 12, 4, 0.02f)));
                });
        TradeOfferHelper.registerVillagerOffers(LIFARMIAN,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.GOLDEN_CARROT, 3), 12, 7, 0.03f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.ENDER_PEARL, 1), 12, 7, 0.03f)));
                });
        TradeOfferHelper.registerVillagerOffers(LIFARMIAN,4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), 12, 9, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.ARROW, 16), 12, 9, 0.04f)));
                });
        TradeOfferHelper.registerVillagerOffers(LIFARMIAN,5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.QUARTZ_BLOCK, 1), 12, 10, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.GLASS, 4), 12, 10, 0.05f)));
                });



        TradeOfferHelper.registerVillagerOffers(CREATURE_CARRIER,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.ZOMBIE_SPAWN_EGG, 1), 4, 3, 0.01f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.SKELETON_SPAWN_EGG, 1), 4, 3, 0.01f)));
                });
        TradeOfferHelper.registerVillagerOffers(CREATURE_CARRIER,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.CREEPER_SPAWN_EGG, 1), 4, 15, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.SPIDER_SPAWN_EGG, 1), 4, 15, 0.02f)));
                });
        TradeOfferHelper.registerVillagerOffers(CREATURE_CARRIER,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.COW_SPAWN_EGG, 1), 4, 20, 0.03f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.SHEEP_SPAWN_EGG, 1), 4, 20, 0.03f)));
                });
        TradeOfferHelper.registerVillagerOffers(CREATURE_CARRIER,4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.BEE_SPAWN_EGG, 1), 4, 25, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.SLIME_SPAWN_EGG, 1), 4, 25, 0.04f)));
                });
        TradeOfferHelper.registerVillagerOffers(CREATURE_CARRIER,5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.WITHER_SKELETON_SPAWN_EGG, 1), 4, 30, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.VILLAGER_SPAWN_EGG, 1), 4, 30, 0.05f)));
                });
    }
}
