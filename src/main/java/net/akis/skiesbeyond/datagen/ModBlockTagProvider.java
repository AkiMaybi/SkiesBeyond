package net.akis.skiesbeyond.datagen;

import net.akis.skiesbeyond.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ASHEN_ORE)
                .add(ModBlocks.CHARRING_BLOCK)
                .add(ModBlocks.BURNT_ASHEN_ORE)
                .add(ModBlocks.COMBUSTION_CLUSTER)
                .add(ModBlocks.SOLAR_CLUSTER);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ASHEN_ORE).add(ModBlocks.BURNT_ASHEN_ORE)
                .add(ModBlocks.SOLAR_CLUSTER).add(ModBlocks.COMBUSTION_CLUSTER);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CHARRING_BLOCK);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.SOLAR_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.SOLAR_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.SOLAR_WALL);
    }
}
