package net.akis.skiesbeyond.block;

import net.akis.skiesbeyond.SkiesBeyond;
import net.akis.skiesbeyond.block.custom.CharringBlock;
import net.akis.skiesbeyond.block.custom.SolarLamp;
import net.akis.skiesbeyond.block.custom.StarFruitCropBlock;
import net.akis.skiesbeyond.sound.ModSounds;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
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
    public static final Block SOLAR_BRICKS = registerBlock("solar_bricks",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));



    public static final Block CHARRING_BLOCK = registerBlock("charring_block",
            new CharringBlock(AbstractBlock.Settings.create()
                    .strength(5f)
                    .requiresTool()
                    .sounds(ModSounds.CHARRING_BLOCK_SOUNDS)));
    public static final Block SOLAR_LAMP = registerBlock("solar_lamp",
            new SolarLamp(AbstractBlock.Settings.create().strength(1f).requiresTool().luminance(state -> state.get(SolarLamp.CLICKED) ? 15 : 0)));

    public static final Block STARFRUIT_CROP = registerBlockWithoutBlockItem("starfruit_crop",
            new StarFruitCropBlock(AbstractBlock.Settings.create().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));




    public static final Block SOLAR_STAIRS = registerBlock("solar_stairs",
            new StairsBlock(ModBlocks.SOLAR_CLUSTER.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block SOLAR_SLAB = registerBlock("solar_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block SOLAR_BUTTON = registerBlock("solar_button",
            new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));
    public static final Block SOLAR_PRESSURE_PLATE = registerBlock("solar_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block SOLAR_FENCE = registerBlock("solar_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block SOLAR_FENCE_GATE = registerBlock("solar_fence_gate",
            new FenceGateBlock(WoodType.ACACIA,
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block SOLAR_WALL = registerBlock("solar_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block SOLAR_DOOR = registerBlock("solar_door",
            new DoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
    public static final Block SOLAR_TRAPDOOR = registerBlock("solar_trapdoor",
            new TrapdoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));









    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(SkiesBeyond.MOD_ID, name), block);
    }
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
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
