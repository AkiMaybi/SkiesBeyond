package net.akis.skiesbeyond.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.akis.skiesbeyond.sound.ModSounds;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public record ExpulsionEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<ExpulsionEnchantmentEffect> CODEC = MapCodec.unit(ExpulsionEnchantmentEffect::new);


    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (level == 1) {
            user.setVelocity(0, 5, 0);
            Box range = new Box(user.getBlockPos()).expand(5); // 5-block radius
            Vec3d source = user.getPos();

            List<LivingEntity> nearbyEntities = world.getEntitiesByClass(
                    LivingEntity.class,
                    range,
                    target -> target != user && target.isAlive()
            );

            for (LivingEntity target : nearbyEntities) {
                Vec3d direction = target.getPos().subtract(source).normalize(); // Away from user
                double strength = 3; // Adjust push strength
                Vec3d velocity = direction.multiply(strength);

                target.addVelocity(velocity.x, velocity.y + 2, velocity.z); // Add a small upward push
                target.velocityModified = true; // Ensure motion is updated on server
                world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_WIND_CHARGE_THROW, SoundCategory.PLAYERS, 1.0f, 1.0f);
                new Thread(() -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                });
            }



        }

        if (level == 2) {
            EntityType.BREEZE_WIND_CHARGE.spawn(world, user.getBlockPos().down(1), SpawnReason.TRIGGERED);
            new Thread(() -> {
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                user.setVelocity(0, -4, 0);
                EntityType.BREEZE_WIND_CHARGE.spawn(world, user.getBlockPos().down(1), SpawnReason.TRIGGERED);
            }).start();
        }

        if (level == 3) {
            EntityType.BREEZE_WIND_CHARGE.spawn(world, user.getBlockPos().down(1), SpawnReason.TRIGGERED);
            EntityType.BREEZE_WIND_CHARGE.spawn(world, user.getBlockPos().down(1).east(2), SpawnReason.TRIGGERED);
            EntityType.BREEZE_WIND_CHARGE.spawn(world, user.getBlockPos().down(1).east(1).north(1), SpawnReason.TRIGGERED);
            EntityType.BREEZE_WIND_CHARGE.spawn(world, user.getBlockPos().down(1).north(2), SpawnReason.TRIGGERED);
            EntityType.BREEZE_WIND_CHARGE.spawn(world, user.getBlockPos().down(1).north(1).west(1), SpawnReason.TRIGGERED);
            EntityType.BREEZE_WIND_CHARGE.spawn(world, user.getBlockPos().down(1).west(2), SpawnReason.TRIGGERED);
            EntityType.BREEZE_WIND_CHARGE.spawn(world, user.getBlockPos().down(1).west(1).south(1), SpawnReason.TRIGGERED);
            EntityType.BREEZE_WIND_CHARGE.spawn(world, user.getBlockPos().down(1).south(2), SpawnReason.TRIGGERED);
            EntityType.BREEZE_WIND_CHARGE.spawn(world, user.getBlockPos().down(1).south(1).east(1), SpawnReason.TRIGGERED);
        }

    }



    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
