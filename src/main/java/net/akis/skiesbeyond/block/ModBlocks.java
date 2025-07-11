package net.akis.skiesbeyond.block;

import net.akis.skiesbeyond.SkiesBeyond;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block SOLAR_CLUSTER = registerBlock("solar_cluster",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER)));
    public static final Block COMBUSTION_CLUSTER = registerBlock("combustion_cluster",
            new Block(AbstractBlock.Settings.create()
                    .strength(5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER)));
    public static final Block ASHEN_ORE = registerBlock("ashen_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5), AbstractBlock.Settings.create()
                            .strength(5f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.BONE)));
    public static final Block BURNT_ASHEN_ORE = registerBlock("burnt_ashen_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5), AbstractBlock.Settings.create()
                            .strength(5f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.BONE)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(SkiesBeyond.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(SkiesBeyond.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        SkiesBeyond.LOGGER.info("Registering " + SkiesBeyond.MOD_ID + " Blocks");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.SOLAR_CLUSTER);
            fabricItemGroupEntries.add(ModBlocks.COMBUSTION_CLUSTER);
        });
    }
}
