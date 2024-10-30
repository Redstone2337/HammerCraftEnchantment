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
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;

public record VampireEnchantmentEffect(EnchantmentLevelBasedValue health) implements EnchantmentEntityEffect {

    public static final MapCodec<VampireEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance
                    .group(EnchantmentLevelBasedValue.CODEC.fieldOf("health").forGetter(effect -> effect.health))
                    .apply(instance, VampireEnchantmentEffect::new)
    );

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (!(user instanceof LivingEntity livingEntity)) return;

        livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 0, false, false, false));
        livingEntity.heal(health.getValue(level));

        Random random = world.getRandom();
        double d = random.nextGaussian() * 0.02;
        double e = random.nextGaussian() * 0.02;
        double f = random.nextGaussian() * 0.02;
        world.spawnParticles(ParticleTypes.HEART, user.getParticleX(1.0), user.getRandomBodyY(), user.getParticleZ(1.0), 1, d, e, f, 0.0);
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
