package net.akis.skiesbeyond.enchantment;

import com.mojang.serialization.MapCodec;
import net.akis.skiesbeyond.SkiesBeyond;
import net.akis.skiesbeyond.enchantment.custom.ExpulsionEnchantmentEffect;
import net.akis.skiesbeyond.enchantment.custom.StrikedownEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {

    public static final MapCodec<? extends EnchantmentEntityEffect> STRIKEDOWN =
            registerEntityEffect("strikedown", StrikedownEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> EXPULSION =
            registerEntityEffect("expulsion", ExpulsionEnchantmentEffect.CODEC);



    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<?extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(SkiesBeyond.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        SkiesBeyond.LOGGER.info("Registering " + SkiesBeyond.MOD_ID + " Enchantments");
    }
}
