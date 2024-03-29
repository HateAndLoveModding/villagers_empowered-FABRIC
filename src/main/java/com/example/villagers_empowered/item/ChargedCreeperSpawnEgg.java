package com.example.villagers_empowered.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class ChargedCreeperSpawnEgg extends Item {
    public ChargedCreeperSpawnEgg(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        CreeperEntity creeperEntity = getCreeperEntity(world, user);
        world.spawnEntity(creeperEntity);

        LightningEntity lightningBolt = getLightningEntity(world, user);
        world.spawnEntity(lightningBolt);

        //TypedActionResult.pass(user.getStackInHand(hand));
        ItemStack heldStack = user.getStackInHand(hand);
        heldStack.decrement(1);
        return TypedActionResult.success(heldStack);
    }

    @NotNull
    private static LightningEntity getLightningEntity(World world, PlayerEntity user) {
        LightningEntity lightningBolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        if (user.getHorizontalFacing().equals(Direction.EAST)) {
            lightningBolt.setPosition(user.getX() + 8, user.getY(), user.getZ());
        } else if (user.getHorizontalFacing().equals(Direction.WEST)) {
            lightningBolt.setPosition(user.getX() - 8, user.getY(), user.getZ());
        } else if (user.getHorizontalFacing().equals(Direction.SOUTH)) {
            lightningBolt.setPosition(user.getX(), user.getY(), user.getZ() + 8);
        } else if (user.getHorizontalFacing().equals(Direction.NORTH)) {
            lightningBolt.setPosition(user.getX(), user.getY(), user.getZ() - 8);
        }
        return lightningBolt;
    }

    @NotNull
    private static CreeperEntity getCreeperEntity(World world, PlayerEntity user) {
        CreeperEntity creeperEntity = new CreeperEntity(EntityType.CREEPER, world);
        if (user.getHorizontalFacing().equals(Direction.EAST)) {
            creeperEntity.setPosition(user.getX() + 8, user.getY(), user.getZ());
        } else if (user.getHorizontalFacing().equals(Direction.WEST)) {
            creeperEntity.setPosition(user.getX() - 8, user.getY(), user.getZ());
        } else if (user.getHorizontalFacing().equals(Direction.SOUTH)) {
            creeperEntity.setPosition(user.getX(), user.getY(), user.getZ() + 8);
        } else if (user.getHorizontalFacing().equals(Direction.NORTH)) {
            creeperEntity.setPosition(user.getX(), user.getY(), user.getZ() - 8);
        }
        return creeperEntity;
    }
}
