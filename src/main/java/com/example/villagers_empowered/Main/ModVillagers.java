package com.example.villagers_empowered.Main;

import com.example.villagers_empowered.Main.ModBlocks;
import com.example.villagers_empowered.Main.ModItems;
import com.example.villagers_empowered.villagers_empowered;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.Arrays;

public class ModVillagers {
    public static PointOfInterestType FLASONIC_POI = PointOfInterestHelper.register(new Identifier(villagers_empowered.MOD_ID,"flasonic_poi"), 1, 1,
            ModBlocks.FLASONIC_TABLE);
    public static VillagerProfession FLASONIC = Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(villagers_empowered.MOD_ID, "flasonic"),
            new VillagerProfession("flasonic", holder -> holder.value().equals(FLASONIC_POI), holder -> holder.value().equals(FLASONIC_POI), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_FARMER));
    public static PointOfInterestType LIFARMIAN_POI = PointOfInterestHelper.register(new Identifier(villagers_empowered.MOD_ID,"lifarmian_poi"), 1, 1,
            ModBlocks.LIFARMIAN_TABLE);
    public static VillagerProfession LIFARMIAN = Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(villagers_empowered.MOD_ID, "lifarmian"),
            new VillagerProfession("lifarmian", holder -> holder.value().equals(LIFARMIAN_POI), holder -> holder.value().equals(LIFARMIAN_POI), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_FARMER));
    public static PointOfInterestType CREATURE_CARRIER_POI = PointOfInterestHelper.register(new Identifier(villagers_empowered.MOD_ID,"creature_carrier_poi"), 1, 1,
            ModBlocks.CREATURE_CARRIER_BLOCK);
    public static VillagerProfession CREATURE_CARRIER = Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(villagers_empowered.MOD_ID, "creature_carrier"),
            new VillagerProfession("creature_carrier", holder -> holder.value().equals(CREATURE_CARRIER_POI), holder -> holder.value().equals(CREATURE_CARRIER_POI), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_FARMER));
    public static PointOfInterestType PACKED_LIBRARIAN_POI = PointOfInterestHelper.register(new Identifier(villagers_empowered.MOD_ID,"packed_librarian_poi"), 1, 1,
            ModBlocks.PACKED_BOOKSHELF);
    public static VillagerProfession PACKED_LIBRARIAN = Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(villagers_empowered.MOD_ID, "packed_librarian"),
            new VillagerProfession("packed_librarian", holder -> holder.value().equals(PACKED_LIBRARIAN_POI), holder -> holder.value().equals(PACKED_LIBRARIAN_POI), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_FARMER));
    public static PointOfInterestType ARCANE_ARTISAN_POI = PointOfInterestHelper.register(new Identifier(villagers_empowered.MOD_ID,"arcane_artisan_poi"), 1, 1,
            ModBlocks.ARTISANS_WORKBENCH);
    public static VillagerProfession ARCANE_ARTISAN = Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(villagers_empowered.MOD_ID, "arcane_artisan"),
            new VillagerProfession("arcane_artisan", holder -> holder.value().equals(ARCANE_ARTISAN_POI), holder -> holder.value().equals(ARCANE_ARTISAN_POI), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_FARMER));
    public static PointOfInterestType POTION_MASTER_POI = PointOfInterestHelper.register(new Identifier(villagers_empowered.MOD_ID,"potion_master_poi"), 1, 1,
            ModBlocks.POTION_STAND);
    public static VillagerProfession POTION_MASTER = Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(villagers_empowered.MOD_ID, "potion_master"),
            new VillagerProfession("potion_master", holder -> holder.value().equals(POTION_MASTER_POI), holder -> holder.value().equals(POTION_MASTER_POI), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_FARMER));


    public static void registerTrades() {
        ItemStack sixEmeraldBlocks = new ItemStack(Items.EMERALD_BLOCK, 6);

        TradeOfferHelper.registerVillagerOffers(PACKED_LIBRARIAN,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.PROTECTION, 4)), 2, 5, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.BLAST_PROTECTION, 4)), 2, 5, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.PROJECTILE_PROTECTION, 4)), 2, 5, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.FIRE_PROTECTION, 4)), 2, 5, 0.2f)));
                });
        TradeOfferHelper.registerVillagerOffers(PACKED_LIBRARIAN,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.THORNS, 3)), 2, 30, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.RESPIRATION, 3)), 2, 30, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.FEATHER_FALLING, 4)), 2, 30, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.FROST_WALKER, 2)), 2, 30, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.SWIFT_SNEAK, 3)), 2, 30, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.DEPTH_STRIDER, 3)), 2, 30, 0.2f)));
                });
        TradeOfferHelper.registerVillagerOffers(PACKED_LIBRARIAN,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.SHARPNESS, 5)), 2, 40, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.SWEEPING, 3)), 2, 40, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.LOOTING, 3)), 2, 40, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.POWER, 5)), 2, 40, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.KNOCKBACK, 2)), 2, 40, 0.2f)));
                });
        TradeOfferHelper.registerVillagerOffers(PACKED_LIBRARIAN,4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.EFFICIENCY, 5)), 2, 50, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.SILK_TOUCH, 1)), 2, 50, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.FORTUNE, 3)), 2, 50, 0.2f)));
                });
        TradeOfferHelper.registerVillagerOffers(PACKED_LIBRARIAN,5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.MENDING, 1)), 2, 60, 0.2f)));
                    factories.add(((entity, random) -> new TradeOffer(sixEmeraldBlocks, EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.UNBREAKING, 3)), 2, 60, 0.2f)));
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



        ItemStack emeraldBlock = new ItemStack(Items.EMERALD_BLOCK, 1);
        ItemStack baseSpawnEgg = new ItemStack(ModItems.BASE_SPAWN_EGG, 1);
        ItemStack waterBottle = new ItemStack(Items.POTION, 1);
        NbtCompound tag = new NbtCompound();
        tag.putString("Potion", "minecraft:water");
        waterBottle.setNbt(tag);

        TradeOfferHelper.registerVillagerOffers(CREATURE_CARRIER,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.COW_SPAWN_EGG, 1), 4, 3, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.SHEEP_SPAWN_EGG, 1), 4, 3, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.PIG_SPAWN_EGG, 1), 4, 3, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.CHICKEN_SPAWN_EGG, 1), 4, 3, 0.02f)));
                });
        TradeOfferHelper.registerVillagerOffers(CREATURE_CARRIER,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.ZOMBIE_SPAWN_EGG, 1), 4, 15, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.SKELETON_SPAWN_EGG, 1), 4, 15, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.CREEPER_SPAWN_EGG, 1), 4, 15, 0.02f)));
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.SPIDER_SPAWN_EGG, 1), 4, 15, 0.02f)));
                });
        TradeOfferHelper.registerVillagerOffers(CREATURE_CARRIER,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.HORSE_SPAWN_EGG, 1), 4, 20, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.AXOLOTL_SPAWN_EGG, 1), 4, 20, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.MOOSHROOM_SPAWN_EGG, 1), 4, 20, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.PANDA_SPAWN_EGG, 1), 4, 20, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.FROG_SPAWN_EGG, 1), 4, 20, 0.04f)));
                });
        TradeOfferHelper.registerVillagerOffers(CREATURE_CARRIER,4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(ModItems.CHARGED_CREEPER_SPAWN_EGG, 1), 4, 25, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.SLIME_SPAWN_EGG, 1), 4, 25, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.BLAZE_SPAWN_EGG, 1), 4, 25, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.SHULKER_SPAWN_EGG, 1), 4, 25, 0.04f)));
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.ENDERMITE_SPAWN_EGG, 1), 4, 25, 0.04f)));
                });
        TradeOfferHelper.registerVillagerOffers(CREATURE_CARRIER,5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.WITHER_SKELETON_SPAWN_EGG, 1), 4, 30, 0.06f)));
                    factories.add(((entity, random) -> new TradeOffer(emeraldBlock, baseSpawnEgg, new ItemStack(Items.VILLAGER_SPAWN_EGG, 1), 4, 30, 0.06f)));
                });



        TradeOfferHelper.registerVillagerOffers(POTION_MASTER, 1, factories -> {
            factories.add((entity, random) -> {
                NbtCompound potionTag = new NbtCompound();
                ItemStack potion = new ItemStack(Items.POTION, 1);
                potionTag.putString("Potion", "minecraft:leaping");
                potion.setNbt(potionTag);
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), waterBottle, potion, 2, 5, 0.2f);
            });
            factories.add((entity, random) -> {
                NbtCompound potionTag = new NbtCompound();
                ItemStack potion = new ItemStack(Items.POTION, 1);
                potionTag.putString("Potion", "minecraft:swiftness");
                potion.setNbt(potionTag);
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), waterBottle, potion, 2, 5, 0.2f);
            });
        });
        TradeOfferHelper.registerVillagerOffers(POTION_MASTER, 2, factories -> {
            factories.add((entity, random) -> {
                NbtCompound potionTag = new NbtCompound();
                ItemStack potion = new ItemStack(Items.POTION, 1);
                potionTag.putString("Potion", "minecraft:strength");
                potion.setNbt(potionTag);
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), waterBottle, potion, 2, 30, 0.2f);
            });
            factories.add((entity, random) -> {
                NbtCompound potionTag = new NbtCompound();
                ItemStack potion = new ItemStack(Items.POTION, 1);
                potionTag.putString("Potion", "minecraft:invisibility");
                potion.setNbt(potionTag);
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), waterBottle, potion, 2, 30, 0.2f);
            });
        });
        TradeOfferHelper.registerVillagerOffers(POTION_MASTER, 3, factories -> {
            factories.add((entity, random) -> {
                NbtCompound potionTag = new NbtCompound();
                ItemStack potion = new ItemStack(Items.POTION, 1);
                potionTag.putString("Potion", "minecraft:water_breathing");
                potion.setNbt(potionTag);
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), waterBottle, potion, 2, 40, 0.2f);
            });
            factories.add((entity, random) -> {
                NbtCompound potionTag = new NbtCompound();
                ItemStack potion = new ItemStack(Items.POTION, 1);
                potionTag.putString("Potion", "minecraft:fire_resistance");
                potion.setNbt(potionTag);
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), waterBottle, potion, 2, 40, 0.2f);
            });
        });
        TradeOfferHelper.registerVillagerOffers(POTION_MASTER, 4, factories -> {
            factories.add((entity, random) -> {
                NbtCompound potionTag = new NbtCompound();
                ItemStack potion = new ItemStack(Items.POTION, 1);
                potionTag.putString("Potion", "minecraft:night_vision");
                potion.setNbt(potionTag);
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), waterBottle, potion, 2, 50, 0.2f);
            });
            factories.add((entity, random) -> {
                NbtCompound potionTag = new NbtCompound();
                ItemStack potion = new ItemStack(Items.POTION, 1);
                potionTag.putString("Potion", "minecraft:slow_falling");
                potion.setNbt(potionTag);
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), waterBottle, potion, 2, 50, 0.2f);
            });
        });
        TradeOfferHelper.registerVillagerOffers(POTION_MASTER, 5, factories -> {
            factories.add((entity, random) -> {
                NbtCompound potionTag = new NbtCompound();
                ItemStack potion = new ItemStack(Items.POTION, 1);
                potionTag.putString("Potion", "minecraft:healing");
                potion.setNbt(potionTag);
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), waterBottle, potion, 2, 60, 0.2f);
            });
            factories.add((entity, random) -> {
                NbtCompound potionTag = new NbtCompound();
                ItemStack potion = new ItemStack(Items.POTION, 1);
                potionTag.putString("Potion", "minecraft:regeneration");
                potion.setNbt(potionTag);
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1), waterBottle, potion, 2, 60, 0.2f);
            });
        });



        TradeOfferHelper.registerVillagerOffers(ARCANE_ARTISAN, 1, factories -> {
            factories.add((entity, random) -> {
                int level = 0;
                ItemStack enchantedHelmet = new ItemStack(Items.DIAMOND_HELMET);
                for (Enchantment enchantment : Arrays.asList(Enchantments.UNBREAKING, Enchantments.RESPIRATION, Enchantments.MENDING, Enchantments.AQUA_AFFINITY, Enchantments.THORNS, Enchantments.PROTECTION)) {
                    if (random.nextInt(6) + 1 == 1) {
                        enchantedHelmet.addEnchantment(enchantment, enchantment.getMaxLevel());
                        level += 4;
                    }
                }
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1 + level), enchantedHelmet, 2, 5, 0.2f);
            });
            factories.add((entity, random) -> {
                int level = 0;
                ItemStack enchantedHelmet = new ItemStack(Items.DIAMOND_CHESTPLATE);
                for (Enchantment enchantment : Arrays.asList(Enchantments.UNBREAKING, Enchantments.PROTECTION, Enchantments.MENDING, Enchantments.THORNS)) {
                    if (random.nextInt(4) + 1 == 1) {
                        enchantedHelmet.addEnchantment(enchantment, enchantment.getMaxLevel());
                        level += 4;
                    }
                }
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1 + level), enchantedHelmet, 2, 5, 0.2f);
            });
        });
        TradeOfferHelper.registerVillagerOffers(ARCANE_ARTISAN, 2, factories -> {
            factories.add((entity, random) -> {
                int level = 0;
                ItemStack enchantedHelmet = new ItemStack(Items.DIAMOND_LEGGINGS);
                for (Enchantment enchantment : Arrays.asList(Enchantments.UNBREAKING, Enchantments.PROTECTION, Enchantments.MENDING, Enchantments.THORNS, Enchantments.SWIFT_SNEAK)) {
                    if (random.nextInt(5) + 1 == 1) {
                        enchantedHelmet.addEnchantment(enchantment, enchantment.getMaxLevel());
                        level += 4;
                    }
                }
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1 + level), enchantedHelmet, 2, 30, 0.2f);
            });
            factories.add((entity, random) -> {
                int level = 0;
                ItemStack enchantedHelmet = new ItemStack(Items.DIAMOND_BOOTS);
                for (Enchantment enchantment : Arrays.asList(Enchantments.UNBREAKING, Enchantments.PROTECTION, Enchantments.MENDING, Enchantments.FEATHER_FALLING, Enchantments.DEPTH_STRIDER)) {
                    if (random.nextInt(5) + 1 == 1) {
                        enchantedHelmet.addEnchantment(enchantment, enchantment.getMaxLevel());
                        level += 4;
                    }
                }
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1 + level), enchantedHelmet, 2, 30, 0.2f);
            });
        });
        TradeOfferHelper.registerVillagerOffers(ARCANE_ARTISAN, 3, factories -> {
            factories.add((entity, random) -> {
                int level = 0;
                ItemStack enchantedHelmet = new ItemStack(Items.DIAMOND_SWORD);
                for (Enchantment enchantment : Arrays.asList(Enchantments.UNBREAKING, Enchantments.SHARPNESS, Enchantments.MENDING, Enchantments.SWEEPING, Enchantments.LOOTING, Enchantments.FIRE_ASPECT)) {
                    if (random.nextInt(6) + 1 == 1) {
                        enchantedHelmet.addEnchantment(enchantment, enchantment.getMaxLevel());
                        level += 4;
                    }
                }
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1 + level), enchantedHelmet, 2, 40, 0.2f);
            });
            factories.add((entity, random) -> {
                int level = 0;
                ItemStack enchantedHelmet = new ItemStack(Items.DIAMOND_AXE);
                for (Enchantment enchantment : Arrays.asList(Enchantments.UNBREAKING, Enchantments.EFFICIENCY, Enchantments.MENDING, Enchantments.SHARPNESS, Enchantments.SILK_TOUCH)) {
                    if (random.nextInt(5) + 1 == 1) {
                        enchantedHelmet.addEnchantment(enchantment, enchantment.getMaxLevel());
                        level += 4;
                    }
                }
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1 + level), enchantedHelmet, 2, 40, 0.2f);
            });
        });
        TradeOfferHelper.registerVillagerOffers(ARCANE_ARTISAN, 4, factories -> {
            factories.add((entity, random) -> {
                int level = 0;
                ItemStack enchantedHelmet = new ItemStack(Items.DIAMOND_SHOVEL);
                for (Enchantment enchantment : Arrays.asList(Enchantments.UNBREAKING, Enchantments.EFFICIENCY, Enchantments.MENDING, Enchantments.SILK_TOUCH)) {
                    if (random.nextInt(4) + 1 == 1) {
                        enchantedHelmet.addEnchantment(enchantment, enchantment.getMaxLevel());
                        level += 4;
                    }
                }
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1 + level), enchantedHelmet, 2, 50, 0.2f);
            });
            factories.add((entity, random) -> {
                int level = 0;
                ItemStack enchantedHelmet = new ItemStack(Items.DIAMOND_PICKAXE);
                for (Enchantment enchantment : Arrays.asList(Enchantments.UNBREAKING, Enchantments.EFFICIENCY, Enchantments.MENDING, Enchantments.SILK_TOUCH)) {
                    if (random.nextInt(4) + 1 == 1) {
                        enchantedHelmet.addEnchantment(enchantment, enchantment.getMaxLevel());
                        level += 4;
                    }
                }
                return new TradeOffer(new ItemStack(Items.EMERALD_BLOCK, 1 + level), enchantedHelmet, 2, 50, 0.2f);
            });
        });
    }
}
