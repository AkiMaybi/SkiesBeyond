package net.akis.skiesbeyond.potion;

import net.akis.skiesbeyond.SkiesBeyond;
import net.akis.skiesbeyond.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {

    public static final RegistryEntry<Potion> SKY_LEAPING_POTION = regiserPotion("sky_leaping_potion",
            new Potion(new StatusEffectInstance(ModEffects.JUMP_FOR_THE_STARS, 200, 0)));

    private static RegistryEntry<Potion> regiserPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(SkiesBeyond.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        SkiesBeyond.LOGGER.info("Registering " + SkiesBeyond.MOD_ID + " Potions");
    }
}
