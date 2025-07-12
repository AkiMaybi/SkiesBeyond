package net.akis.skiesbeyond.item;

import net.akis.skiesbeyond.SkiesBeyond;
import net.akis.skiesbeyond.item.custom.CharredChisel;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item SOLAR_ESSENCE = registerItem("solar_essence", new Item(new Item.Settings().maxCount(96)));
    public static final Item COMBUSTED_ESSENCE = registerItem("combusted_essence", new Item(new Item.Settings()));

    public static final Item CHARRED_CHISEL = registerItem("charred_chisel", new CharredChisel(new Item.Settings().maxDamage(32).maxCount(1)));
    public static final Item EDIBLE_SUN = registerItem("edible_sun", new Item(new Item.Settings().food(ModFoodComponents.EDIBLE_SUN).maxCount(32)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.skiesbeyond.edible_sun"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SkiesBeyond.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SkiesBeyond.LOGGER.info("Registering " + SkiesBeyond.MOD_ID + " Items");



    }
}
