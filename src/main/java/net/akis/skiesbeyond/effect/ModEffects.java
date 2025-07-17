package net.akis.skiesbeyond.effect;

import net.akis.skiesbeyond.SkiesBeyond;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> JUMP_FOR_THE_STARS = registerStatusEffect("jump_for_the_stars",
            new JumpForTheStarsEffect(StatusEffectCategory.BENEFICIAL, 0xEDDE72)
                    .addAttributeModifier(EntityAttributes.GENERIC_JUMP_STRENGTH,
                            Identifier.of(SkiesBeyond.MOD_ID, "jump_for_the_stars"), 0.5f,
            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(SkiesBeyond.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        SkiesBeyond.LOGGER.info("Registering " + SkiesBeyond.MOD_ID + " Effects");
    }
}
