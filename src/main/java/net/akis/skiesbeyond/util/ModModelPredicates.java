package net.akis.skiesbeyond.util;

import net.akis.skiesbeyond.SkiesBeyond;
import net.akis.skiesbeyond.component.ModDataComponentTypes;
import net.akis.skiesbeyond.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.CHARRED_CHISEL, Identifier.of(SkiesBeyond.MOD_ID, "used"),
                ((stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1f :0f));

        registerCustomBow(ModItems.SOLAR_BOW);
    }

    private static void registerCustomBow(Item item) {
        ModelPredicateProviderRegistry.register(item, Identifier.ofVanilla("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / 20.0F;
            }
        });
        ModelPredicateProviderRegistry.register(
                item,
                Identifier.ofVanilla("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
        );
    }
}
