package com.example.villagers_empowered.villager;

import com.example.villagers_empowered.block.ModBlocks;
import com.example.villagers_empowered.villagers_empowered;
import com.example.villagers_empowered.item.ModItems;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
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
    public static final VillagerProfession FLASONIC = registerProfession("flasonic",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(villagers_empowered.MOD_ID, "flasonic_poi")));
    public static final VillagerProfession LIFARMIAN = registerProfession("lifarmian",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(villagers_empowered.MOD_ID, "lifarmian_poi")));
    public static final VillagerProfession CREATURE_CARRIER = registerProfession("creature_carrier",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(villagers_empowered.MOD_ID, "creature_carrier_poi")));
    public static final VillagerProfession PACKED_LIBRARIAN = registerProfession("packed_librarian",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(villagers_empowered.MOD_ID, "packed_librarian_poi")));


    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(villagers_empowered.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(villagers_empowered.MOD_ID, name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());
    }

    public static void registerPOI(String name, Block block) {
        PointOfInterestHelper.register(new Identifier(villagers_empowered.MOD_ID, name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static void registerVillagers() {
        villagers_empowered.LOGGER.debug("Registering Villagers for " + villagers_empowered.MOD_ID);
        registerPOI("flasonic_poi", ModBlocks.FLASONIC_TABLE);
        registerPOI("lifarmian_poi", ModBlocks.LIFARMIAN_TABLE);
        registerPOI("creature_carrier_poi", ModBlocks.CREATURE_CARRIER_BLOCK);
        registerPOI("packed_librarian_poi", ModBlocks.PACKED_BOOKSHELF);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(PACKED_LIBRARIAN,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.PROTECTION, 4)), 2, 25, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.BLAST_PROTECTION, 4)), 2, 25, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.PROJECTILE_PROTECTION, 4)), 2, 25, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.FIRE_PROTECTION, 4)), 2, 25, 0.2f)));
                });
        TradeOfferHelper.registerVillagerOffers(PACKED_LIBRARIAN,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.THORNS, 3)), 2, 25, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.RESPIRATION, 3)), 2, 25, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.FEATHER_FALLING, 4)), 2, 25, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.FROST_WALKER, 2)), 2, 25, 0.2f)));
                });
        TradeOfferHelper.registerVillagerOffers(PACKED_LIBRARIAN,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.SHARPNESS, 5)), 2, 25, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.SWEEPING, 3)), 2, 25, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.LOOTING, 3)), 2, 25, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.POWER, 5)), 2, 25, 0.2f)));
                });
        TradeOfferHelper.registerVillagerOffers(PACKED_LIBRARIAN,4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.EFFICIENCY, 5)), 2, 25, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.SILK_TOUCH, 1)), 2, 25, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.FORTUNE, 3)), 2, 25, 0.2f)));
                });
        TradeOfferHelper.registerVillagerOffers(PACKED_LIBRARIAN,5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.MENDING, 1)), 2, 25, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.UNBREAKING, 3)), 2, 25, 0.2f)));
                });



        TradeOfferHelper.registerVillagerOffers(FLASONIC,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.WHEAT, 10), new ItemStack(Items.WHEAT_SEEDS, 15), new ItemStack(Items.EMERALD, 1), 8, 2, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.BEETROOT, 10), new ItemStack(Items.BEETROOT_SEEDS, 15), new ItemStack(Items.EMERALD, 1), 8, 2, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.CARROT, 15), new ItemStack(Items.EMERALD, 1), 8, 2, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.POTATO, 15), new ItemStack(Items.EMERALD, 1), 8, 2, 0.05f)));
                });
        TradeOfferHelper.registerVillagerOffers(FLASONIC,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(Items.EMERALD, 1), 12, 4, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.BONE, 1), new ItemStack(Items.EMERALD, 1), 12, 4, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.GUNPOWDER, 1), new ItemStack(Items.EMERALD, 1), 12, 4, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.STRING, 1), new ItemStack(Items.EMERALD, 1), 12, 4, 0.04f)));
                });
        TradeOfferHelper.registerVillagerOffers(FLASONIC,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.IRON_INGOT, 4), new ItemStack(Items.EMERALD, 1), 12, 10, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.GOLD_INGOT, 3), new ItemStack(Items.EMERALD, 1), 12, 10, 0.05f)));
                });
        TradeOfferHelper.registerVillagerOffers(FLASONIC,4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.PUMPKIN, 5), new ItemStack(Items.EMERALD, 1), 8, 10, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.MELON, 5), new ItemStack(Items.EMERALD, 1), 8, 10, 0.05f)));
                });
        TradeOfferHelper.registerVillagerOffers(FLASONIC,5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.BOOK, 1), new ItemStack(Items.EMERALD, 1), 12, 5, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(Items.BOOKSHELF, 1), 4, 5, 0.05f)));
                });



        TradeOfferHelper.registerVillagerOffers(LIFARMIAN,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.STICK, 16), new ItemStack(Items.EMERALD, 1), 8, 5, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.PAPER, 3), new ItemStack(Items.EMERALD, 1), 8, 5, 0.05f)));
                });
        TradeOfferHelper.registerVillagerOffers(LIFARMIAN,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.REDSTONE, 2), 12, 5, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.LAPIS_LAZULI, 1), 12, 5, 0.05f)));
                });
        TradeOfferHelper.registerVillagerOffers(LIFARMIAN,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.GOLDEN_CARROT, 1), 12, 10, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(Items.ENDER_PEARL, 1), 12, 15, 0.05f)));
                });
        TradeOfferHelper.registerVillagerOffers(LIFARMIAN,4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 4), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), 8, 10, 0.1f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.ARROW, 16), 8, 1, 0.05f)));
                });
        TradeOfferHelper.registerVillagerOffers(LIFARMIAN,5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.QUARTZ_BLOCK, 1), 12, 30, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.GLASS, 4), 12, 10, 0.05f)));
                });



        TradeOfferHelper.registerVillagerOffers(CREATURE_CARRIER,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.COW_SPAWN_EGG, 1), 4, 5, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.SHEEP_SPAWN_EGG, 1), 4, 5, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.PIG_SPAWN_EGG, 1), 4, 5, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.CHICKEN_SPAWN_EGG, 1), 4, 5, 0.02f)));
                });
        TradeOfferHelper.registerVillagerOffers(CREATURE_CARRIER,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.ZOMBIE_SPAWN_EGG, 1), 4, 10, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.SKELETON_SPAWN_EGG, 1), 4, 10, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.CREEPER_SPAWN_EGG, 1), 4, 10, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.SPIDER_SPAWN_EGG, 1), 4, 10, 0.02f)));
                });
        TradeOfferHelper.registerVillagerOffers(CREATURE_CARRIER,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.HORSE_SPAWN_EGG, 1), 4, 15, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.AXOLOTL_SPAWN_EGG, 1), 4, 15, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.MOOSHROOM_SPAWN_EGG, 1), 4, 15, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.PANDA_SPAWN_EGG, 1), 4, 15, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.FROG_SPAWN_EGG, 1), 4, 15, 0.04f)));
                });
        TradeOfferHelper.registerVillagerOffers(CREATURE_CARRIER,4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(ModItems.CHARGED_CREEPER_SPAWN_EGG, 1), 4, 20, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.SLIME_SPAWN_EGG, 1), 4, 20, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.BLAZE_SPAWN_EGG, 1), 4, 20, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.SHULKER_SPAWN_EGG, 1), 4, 20, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.ENDERMITE_SPAWN_EGG, 1), 4, 20, 0.04f)));
                });
        TradeOfferHelper.registerVillagerOffers(CREATURE_CARRIER,5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.WITHER_SKELETON_SPAWN_EGG, 1), 4, 25, 0.06f)));
                    factories.add(((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), new ItemStack(ModItems.BASE_SPAWN_EGG, 1), new ItemStack(Items.VILLAGER_SPAWN_EGG, 1), 4, 25, 0.06f)));
                });

    }
}
