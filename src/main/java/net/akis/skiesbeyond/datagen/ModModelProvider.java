package net.akis.skiesbeyond.datagen;

import net.akis.skiesbeyond.block.ModBlocks;
import net.akis.skiesbeyond.block.custom.SolarLamp;
import net.akis.skiesbeyond.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool solarClusterPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SOLAR_CLUSTER);


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMBUSTION_CLUSTER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ASHEN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BURNT_ASHEN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHARRING_BLOCK);
        solarClusterPool.stairs(ModBlocks.SOLAR_STAIRS);
        solarClusterPool.slab(ModBlocks.SOLAR_SLAB);
        solarClusterPool.button(ModBlocks.SOLAR_BUTTON);
        solarClusterPool.pressurePlate(ModBlocks.SOLAR_PRESSURE_PLATE);
        solarClusterPool.fence(ModBlocks.SOLAR_FENCE);
        solarClusterPool.fenceGate(ModBlocks.SOLAR_FENCE_GATE);
        solarClusterPool.wall(ModBlocks.SOLAR_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.SOLAR_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SOLAR_TRAPDOOR);


        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.SOLAR_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.SOLAR_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.SOLAR_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(SolarLamp.CLICKED, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SOLAR_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMBUSTED_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EDIBLE_SUN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHARRED_CHISEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.SOLAR_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_HAMMER, Models.HANDHELD);
    }
}
