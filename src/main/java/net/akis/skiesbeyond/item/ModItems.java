package net.akis.skiesbeyond.item;

import net.akis.skiesbeyond.SkiesBeyond;
import net.akis.skiesbeyond.block.ModBlocks;
import net.akis.skiesbeyond.item.custom.CharredChisel;
import net.akis.skiesbeyond.item.custom.HammerItem;
import net.akis.skiesbeyond.item.custom.ModArmorItem;
import net.akis.skiesbeyond.sound.ModSounds;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
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

    public static final Item STARFRUIT_SEEDS = registerItem("starfruit_seeds",
            new AliasedBlockItem(ModBlocks.STARFRUIT_CROP, new Item.Settings()));
    public static final Item STARFRUIT = registerItem("starfruit", new Item(new Item.Settings().food(ModFoodComponents.STARFRUIT).maxCount(32)));


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

    public static final Item SOLAR_BOW = registerItem("solar_bow",
            new BowItem(new Item.Settings().maxDamage(500)));

    public static final Item SOLAR_HELMET = registerItem("solar_helmet",
            new ModArmorItem(ModArmorMaterials.SOLAR_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(20))));
    public static final Item SOLAR_LEGGINGS = registerItem("solar_leggings",
            new ModArmorItem(ModArmorMaterials.SOLAR_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(20))));
    public static final Item SOLAR_CHESTPLATE = registerItem("solar_chestplate",
            new ModArmorItem(ModArmorMaterials.SOLAR_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(20))));
    public static final Item SOLAR_BOOTS = registerItem("solar_boots",
            new ModArmorItem(ModArmorMaterials.SOLAR_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(20))));

    public static final Item SUNLIGHT_SMITHING_TEMPLATE = registerItem("sunlight_armor_trim_smithing_template",
            SmithingTemplateItem.of(Identifier.of(SkiesBeyond.MOD_ID, "sunlight"), FeatureFlags.VANILLA));

    public static final Item STARJUMP_MUSIC_DISC = registerItem("starjump_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.STARJUMP_KEY).maxCount(1)));

    public static final Item SOLAR_HORSE_ARMOR = registerItem("solar_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.SOLAR_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));







    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SkiesBeyond.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SkiesBeyond.LOGGER.info("Registering " + SkiesBeyond.MOD_ID + " Items");



    }
}
