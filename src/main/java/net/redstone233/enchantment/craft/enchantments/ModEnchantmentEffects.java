package net.redstone233.enchantment.craft.enchantments;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.enchantment.effect.EnchantmentLocationBasedEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.redstone233.enchantment.craft.HammerCraftEnchantments;
import net.redstone233.enchantment.craft.enchantments.effects.entity.SlowCurseEffect;
import net.redstone233.enchantment.craft.enchantments.effects.entity.SpeedCurseEnchantmentEffect;
import net.redstone233.enchantment.craft.enchantments.effects.entity.VampireEnchantmentEffect;

public class ModEnchantmentEffects {

    private static void registerEntityEffect(String id, MapCodec<? extends EnchantmentEntityEffect> codec) {
        registerLocationBasedEffect(id, codec);
        Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(HammerCraftEnchantments.MOD_ID, id), codec);
    }

    private static void registerLocationBasedEffect(String id, MapCodec<? extends EnchantmentLocationBasedEffect> codec) {
        Registry.register(Registries.ENCHANTMENT_LOCATION_BASED_EFFECT_TYPE, Identifier.of(HammerCraftEnchantments.MOD_ID, id), codec);
    }

    public static void registerEnchantmentEffects() {
        registerEntityEffect("vampire_effect", VampireEnchantmentEffect.CODEC);
        registerEntityEffect("speed_curse_effect", SpeedCurseEnchantmentEffect.CODEC);
        registerEntityEffect("slowness_curse_effect", SlowCurseEffect.CODEC);
        HammerCraftEnchantments.LOGGER.info("Registering mod enchantment effects for " + HammerCraftEnchantments.MOD_ID);
    }
}
