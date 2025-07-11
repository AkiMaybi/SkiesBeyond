package net.akis.skiesbeyond.item;

import net.akis.skiesbeyond.SkiesBeyond;
import net.akis.skiesbeyond.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup SUNLIGHT_SET_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SkiesBeyond.MOD_ID, "sunlight_set"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SOLAR_ESSENCE))
                    .displayName(Text.translatable("itemgroup.skiesbeyond.sunlight_set"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SOLAR_ESSENCE);
                        entries.add(ModItems.COMBUSTED_ESSENCE);
                        entries.add(ModBlocks.SOLAR_CLUSTER);
                        entries.add(ModBlocks.COMBUSTION_CLUSTER);
                        entries.add(ModBlocks.ASHEN_ORE);
                        entries.add(ModBlocks.BURNT_ASHEN_ORE);
                        entries.add(ModItems.CHARRED_CHISEL);
                        entries.add(ModBlocks.CHARRING_BLOCK);
                    }).build());







    public static void registerItemGroups() {
        SkiesBeyond.LOGGER.info("Registering " + SkiesBeyond.MOD_ID + " Item Groups");
    }
}
