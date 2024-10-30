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
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record SlowCurseEffect(EnchantmentLevelBasedValue slownessLevel) implements EnchantmentEntityEffect {

    public static final MapCodec<SlowCurseEffect> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance
                    .group(EnchantmentLevelBasedValue.CODEC.fieldOf("slownessLevel").forGetter(effect -> effect.slownessLevel))
                    .apply(instance, SlowCurseEffect::new)
    );

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (!(user instanceof LivingEntity livingEntity)) return;

        livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, (int) slownessLevel.getValue(level), false, false, false));
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
