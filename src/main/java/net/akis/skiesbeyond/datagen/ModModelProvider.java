package net.akis.skiesbeyond.datagen;

import net.akis.skiesbeyond.block.ModBlocks;
import net.akis.skiesbeyond.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

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
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SOLAR_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMBUSTED_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EDIBLE_SUN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHARRED_CHISEL, Models.GENERATED);
    }
}
