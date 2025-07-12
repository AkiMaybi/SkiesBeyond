package net.akis.skiesbeyond.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent EDIBLE_SUN = new FoodComponent.Builder().snack().nutrition(1).saturationModifier(0.25f).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200), 0.5f).build();
}
