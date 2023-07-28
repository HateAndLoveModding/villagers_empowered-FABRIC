package com.example.villagers_empowered.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class ChargedCreeperSpawnEgg extends Item {
    public ChargedCreeperSpawnEgg(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // Ensure we don't spawn the lightning only on the client.
        // This is to prevent desync.
        if(world.isClient) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        BlockPos frontOfPlayer = user.getBlockPos().offset(user.getHorizontalFacing(), 10);
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
        world.spawnEntity(creeperEntity);

        // Spawn the lightning bolt.
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
        world.spawnEntity(lightningBolt);

        // Nothing has changed to the item stack,
        // so we just return it how it was.
        TypedActionResult.pass(user.getStackInHand(hand));
        ItemStack heldStack = user.getStackInHand(hand);
        heldStack.decrement(1);
        return TypedActionResult.success(heldStack);
    }
}
