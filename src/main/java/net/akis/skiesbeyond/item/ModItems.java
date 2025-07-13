package net.akis.skiesbeyond.item;

import net.akis.skiesbeyond.SkiesBeyond;
import net.akis.skiesbeyond.item.custom.CharredChisel;
import net.akis.skiesbeyond.item.custom.HammerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
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

    public static final Item SOLAR_SWORD = registerItem("solar_sword",
            new SwordItem(ModToolMaterials.SOLAR, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SOLAR, 3, -2.4f))));
    public static final Item SOLAR_PICKAXE = registerItem("solar_pickaxe",
            new PickaxeItem(ModToolMaterials.SOLAR, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SOLAR, 1, -2.8f))));
    public static final Item SOLAR_SHOVEL = registerItem("solar_shovel",
            new ShovelItem(ModToolMaterials.SOLAR, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.SOLAR, 1.5f, -3.0f))));
    public static final Item SOLAR_AXE = registerItem("solar_axe",
            new AxeItem(ModToolMaterials.SOLAR, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.SOLAR, 6, -3.2f))));
    public static final Item SOLAR_HOE = registerItem("solar_hoe",
            new HoeItem(ModToolMaterials.SOLAR, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.SOLAR, 0, -3.0f))));
    public static final Item SOLAR_HAMMER = registerItem("solar_hammer",
            new HammerItem(ModToolMaterials.SOLAR, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SOLAR, 2, -1.4f))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SkiesBeyond.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SkiesBeyond.LOGGER.info("Registering " + SkiesBeyond.MOD_ID + " Items");



    }
}
