package net.akis.skiesbeyond.datagen;

import net.akis.skiesbeyond.block.ModBlocks;
import net.akis.skiesbeyond.block.custom.SolarLamp;
import net.akis.skiesbeyond.block.custom.StarFruitCropBlock;
import net.akis.skiesbeyond.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool solarbrickpool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SOLAR_BRICKS);


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOLAR_CLUSTER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMBUSTION_CLUSTER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ASHEN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BURNT_ASHEN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHARRING_BLOCK);
        solarbrickpool.stairs(ModBlocks.SOLAR_STAIRS);
        solarbrickpool.slab(ModBlocks.SOLAR_SLAB);
        solarbrickpool.button(ModBlocks.SOLAR_BUTTON);
        solarbrickpool.pressurePlate(ModBlocks.SOLAR_PRESSURE_PLATE);
        solarbrickpool.fence(ModBlocks.SOLAR_FENCE);
        solarbrickpool.fenceGate(ModBlocks.SOLAR_FENCE_GATE);
        solarbrickpool.wall(ModBlocks.SOLAR_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.SOLAR_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SOLAR_TRAPDOOR);


        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.SOLAR_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.SOLAR_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.SOLAR_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(SolarLamp.CLICKED, lampOnIdentifier, lampOffIdentifier)));

        blockStateModelGenerator.registerCrop(ModBlocks.STARFRUIT_CROP, StarFruitCropBlock.AGE, 0,1,2,3,4,5,6);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SOLAR_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMBUSTED_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EDIBLE_SUN, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARFRUIT, Models.GENERATED);
        //itemModelGenerator.register(ModItems.CHARRED_CHISEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.SOLAR_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_HAMMER, Models.HANDHELD);


        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SOLAR_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SOLAR_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SOLAR_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SOLAR_BOOTS));

        itemModelGenerator.register(ModItems.SOLAR_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUNLIGHT_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARJUMP_MUSIC_DISC, Models.GENERATED);
    }
}
