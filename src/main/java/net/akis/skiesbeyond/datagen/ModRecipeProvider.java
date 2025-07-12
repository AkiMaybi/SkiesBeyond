package net.akis.skiesbeyond.datagen;

import net.akis.skiesbeyond.SkiesBeyond;
import net.akis.skiesbeyond.block.ModBlocks;
import net.akis.skiesbeyond.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {


    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> COMBUSTED_ESSENCE_SMELTABLES = List.of(ModItems.SOLAR_ESSENCE);



        offerSmelting(recipeExporter, COMBUSTED_ESSENCE_SMELTABLES, RecipeCategory.MISC, ModItems.COMBUSTED_ESSENCE, 0.25f, 200, "combusted_essence");
        offerBlasting(recipeExporter, COMBUSTED_ESSENCE_SMELTABLES, RecipeCategory.MISC, ModItems.COMBUSTED_ESSENCE, 0.25f, 100, "combusted_essence");
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SOLAR_ESSENCE, RecipeCategory.DECORATIONS, ModBlocks.SOLAR_CLUSTER);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.COMBUSTED_ESSENCE, RecipeCategory.DECORATIONS, ModBlocks.COMBUSTION_CLUSTER);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHARRED_CHISEL)
                .pattern(" RR")
                .pattern(" SR")
                .pattern("S  ")
                .input('R', ModItems.SOLAR_ESSENCE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.SOLAR_ESSENCE), conditionsFromItem(ModItems.SOLAR_ESSENCE))
                .offerTo(recipeExporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.EDIBLE_SUN)
                .input(ModItems.SOLAR_ESSENCE, 3)
                .criterion(hasItem(ModItems.SOLAR_ESSENCE), conditionsFromItem(ModItems.SOLAR_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "edible_sun_shapeless_from_solar_essence"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.EDIBLE_SUN)
                .pattern(" R ")
                .pattern("RTR")
                .pattern(" R ")
                .input('R', ModItems.SOLAR_ESSENCE)
                .input('T', ModItems.COMBUSTED_ESSENCE)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.SOLAR_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "edible_sun_shaped"));

        ;

    }
}
