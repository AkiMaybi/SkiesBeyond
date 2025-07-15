package net.akis.skiesbeyond.datagen;

import net.akis.skiesbeyond.item.ModItems;
import net.akis.skiesbeyond.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.COMBUSTED_ESSENCE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.SOLAR_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.SOLAR_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.SOLAR_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.SOLAR_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.SOLAR_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SOLAR_HELMET)
                .add(ModItems.SOLAR_CHESTPLATE)
                .add(ModItems.SOLAR_LEGGINGS)
                .add(ModItems.SOLAR_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.SOLAR_ESSENCE);
        getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.SUNLIGHT_SMITHING_TEMPLATE);
    }
}
