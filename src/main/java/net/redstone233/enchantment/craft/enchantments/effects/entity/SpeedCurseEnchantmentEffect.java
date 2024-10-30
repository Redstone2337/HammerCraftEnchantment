package net.redstone233.enchantment.craft.enchantments.effects.entity;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;

public record SpeedCurseEnchantmentEffect(EnchantmentLevelBasedValue speedReduction) implements EnchantmentEntityEffect {

    public static final MapCodec<SpeedCurseEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance
                    .group(EnchantmentLevelBasedValue.CODEC.fieldOf("speedReduction").forGetter(effect -> effect.speedReduction))
                    .apply(instance, SpeedCurseEnchantmentEffect::new)
    );

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (user instanceof PlayerEntity player) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,20,level,false,false,false));
        } else {
            return;
        }

        Random random = world.getRandom();
        double d = random.nextGaussian() * 0.02;
        double e = random.nextGaussian() * 0.02;
        double f = random.nextGaussian() * 0.02;
        // 产生粒子效果，这里使用SLOWNESS的粒子类型，可以根据需要替换
        world.spawnParticles(ParticleTypes.POOF, user.getParticleX(1.0), user.getRandomBodyY(), user.getParticleZ(1.0), 1, d, e, f, 0.0);
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
