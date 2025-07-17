package net.akis.skiesbeyond.datagen;

import net.akis.skiesbeyond.block.ModBlocks;
import net.akis.skiesbeyond.block.custom.StarFruitCropBlock;
import net.akis.skiesbeyond.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CHARRING_BLOCK);
        addDrop(ModBlocks.COMBUSTION_CLUSTER);
        addDrop(ModBlocks.SOLAR_CLUSTER);

        addDrop(ModBlocks.ASHEN_ORE, oreDrops(ModBlocks.ASHEN_ORE, ModItems.SOLAR_ESSENCE));
        addDrop(ModBlocks.BURNT_ASHEN_ORE, multiDrops(ModBlocks.BURNT_ASHEN_ORE, ModItems.COMBUSTED_ESSENCE, 1, 3));

        addDrop(ModBlocks.SOLAR_STAIRS);
        addDrop(ModBlocks.SOLAR_SLAB, slabDrops(ModBlocks.SOLAR_SLAB));
        addDrop(ModBlocks.SOLAR_BUTTON);
        addDrop(ModBlocks.SOLAR_PRESSURE_PLATE);
        addDrop(ModBlocks.SOLAR_FENCE);
        addDrop(ModBlocks.SOLAR_FENCE_GATE);
        addDrop(ModBlocks.SOLAR_WALL);
        addDrop(ModBlocks.SOLAR_TRAPDOOR);
        addDrop(ModBlocks.SOLAR_DOOR, doorDrops(ModBlocks.SOLAR_DOOR));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.STARFRUIT_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(StarFruitCropBlock.AGE, StarFruitCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.STARFRUIT_CROP, this.cropDrops(ModBlocks.STARFRUIT_CROP, ModItems.STARFRUIT, ModItems.STARFRUIT_SEEDS, builder2));
    }

    public LootTable.Builder multiDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return  this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }

}
