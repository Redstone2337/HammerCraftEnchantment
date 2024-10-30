package net.redstone233.enchantment.craft.enchantments;

import com.google.common.collect.ImmutableList;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.redstone233.enchantment.craft.HammerCraftEnchantments;

public class ModEnchantments {

    private static final EquipmentSlot[] ALL_ARMOR = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
    
    public static final RegistryKey<Enchantment> VAMPIRE = ModEnchantments.of("vampire");
    
    public static final RegistryKey<Enchantment> SPEED_CURSE = ModEnchantments.of("speed_curse");
    
    public static final RegistryKey<Enchantment> SLOWNESS_CURSE = ModEnchantments.of("slowness_curse");
    
    public static final RegistryKey<Enchantment> ARMOR = ModEnchantments.of("armor");
    
    public static final RegistryKey<Enchantment> ADVANCED_ARMOR = ModEnchantments.of("advanced_armor");
    
    public static final RegistryKey<Enchantment> ATTACK_SPEED = ModEnchantments.of("attack_speed");
    
    public static final RegistryKey<Enchantment> SUPER_ATTACK_SPEED = ModEnchantments.of("super_attack_speed");
    
    public static final RegistryKey<Enchantment> ADVANCED_BANE_OF_ARTHROPODS = ModEnchantments.of("advanced_bane_of_arthropods");
    
    public static final RegistryKey<Enchantment> SUPER_BANE_OF_ARTHROPODS = ModEnchantments.of("super_bane_of_arthropods");
    
    public static final RegistryKey<Enchantment> EXPERIENCE_LOOT = ModEnchantments.of("experience_loot");
    
    public static final RegistryKey<Enchantment> ADVANCED_PROTECTION = ModEnchantments.of("advanced_protection");
    
    public static final RegistryKey<Enchantment> SUPER_PROTECTION = ModEnchantments.of("super_protection");
    
    public static final RegistryKey<Enchantment> ADVANCED_SHARPNESS = ModEnchantments.of("advanced_sharpness");
    
    public static final RegistryKey<Enchantment> EXTREME_SHARPNESS = ModEnchantments.of("extreme_sharpness");
    
    public static final RegistryKey<Enchantment> SUPER_SHARPNESS = ModEnchantments.of("super_sharpness");
    
    public static final RegistryKey<Enchantment> ULTIMATE_SHARPNESS = ModEnchantments.of("ultimate_sharpness");
    
    public static final RegistryKey<Enchantment> ADVANCED_SMITE = ModEnchantments.of("advanced_smite");
    
    public static final RegistryKey<Enchantment> SUPER_SMITE = ModEnchantments.of("super_smite");
    
    public static final ImmutableList<RegistryKey<Enchantment>> HAMMER_ENCHANTMENTS = ImmutableList.of(VAMPIRE,SPEED_CURSE,SLOWNESS_CURSE,ARMOR,ADVANCED_ARMOR,ATTACK_SPEED,SUPER_ATTACK_SPEED,ADVANCED_BANE_OF_ARTHROPODS,SUPER_BANE_OF_ARTHROPODS,EXPERIENCE_LOOT,ADVANCED_PROTECTION,SUPER_PROTECTION,ADVANCED_SHARPNESS,EXTREME_SHARPNESS,SUPER_SHARPNESS,ULTIMATE_SHARPNESS,ADVANCED_SMITE,SUPER_SMITE);


    private static RegistryKey<Enchantment> of(String id) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(HammerCraftEnchantments.MOD_ID, id));
    }

    public static void registerModEnchantments() {
        HammerCraftEnchantments.LOGGER.info("Registering ModEnchantments for " + HammerCraftEnchantments.MOD_ID);
    }
}
