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
import net.minecraft.recipe.Ingredient;
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




        //TOOLS
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CHARRED_CHISEL)
                .pattern(" RR")
                .pattern(" SR")
                .pattern("S  ")
                .input('R', ModItems.SOLAR_ESSENCE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.SOLAR_ESSENCE), conditionsFromItem(ModItems.SOLAR_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "charred_chisel_shaped"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SOLAR_SWORD)
                .pattern("C")
                .pattern("C")
                .pattern("S")
                .input('C', ModItems.COMBUSTED_ESSENCE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.COMBUSTED_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_tools_sword"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SOLAR_PICKAXE)
                .pattern("CCC")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', ModItems.COMBUSTED_ESSENCE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.COMBUSTED_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_tools_pickaxe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SOLAR_SHOVEL)
                .pattern("C")
                .pattern("S")
                .pattern("S")
                .input('C', ModItems.COMBUSTED_ESSENCE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.COMBUSTED_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_tools_shovel"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SOLAR_AXE)
                .pattern("CC")
                .pattern("CS")
                .pattern("S ")
                .input('C', ModItems.COMBUSTED_ESSENCE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.COMBUSTED_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_tools_axe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SOLAR_HOE)
                .pattern(" CC")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', ModItems.COMBUSTED_ESSENCE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.COMBUSTED_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_tools_hoe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SOLAR_HAMMER)
                .pattern("CCC")
                .pattern("CSC")
                .pattern(" S ")
                .input('C', ModItems.COMBUSTED_ESSENCE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.COMBUSTED_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_tools_hammer"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SOLAR_BOW)
                .pattern(" CS")
                .pattern("C S")
                .pattern(" CS")
                .input('C', ModItems.COMBUSTED_ESSENCE)
                .input('S', Items.STRING)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.COMBUSTED_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_tools_bow"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SOLAR_BOOTS)
                .pattern("C C")
                .pattern("C C")
                .input('C', ModItems.COMBUSTED_ESSENCE)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.COMBUSTED_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_armor_boots"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SOLAR_LEGGINGS)
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .input('C', ModItems.COMBUSTED_ESSENCE)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.COMBUSTED_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_armor_leggings"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SOLAR_CHESTPLATE)
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModItems.COMBUSTED_ESSENCE)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.COMBUSTED_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_armor_chestplate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SOLAR_HELMET)
                .pattern("CCC")
                .pattern("C C")
                .input('C', ModItems.COMBUSTED_ESSENCE)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.COMBUSTED_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_armor_helmet"));




        //BLOCKS
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SOLAR_ESSENCE, RecipeCategory.DECORATIONS, ModBlocks.SOLAR_CLUSTER);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.COMBUSTED_ESSENCE, RecipeCategory.DECORATIONS, ModBlocks.COMBUSTION_CLUSTER);
        offer2x2CompactingRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOLAR_BRICKS, ModBlocks.SOLAR_CLUSTER);
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOLAR_SLAB, ModBlocks.SOLAR_BRICKS);
        offerShapelessRecipe(recipeExporter, ModBlocks.SOLAR_BUTTON, ModBlocks.SOLAR_BRICKS, null, 1);
        offerPressurePlateRecipe(recipeExporter, ModBlocks.SOLAR_PRESSURE_PLATE, ModBlocks.SOLAR_BRICKS);
        offerWallRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOLAR_WALL, ModBlocks.SOLAR_BRICKS);
        createStairsRecipe(ModBlocks.SOLAR_STAIRS, Ingredient.ofItems(ModBlocks.SOLAR_BRICKS));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOLAR_FENCE)
                .pattern("BSB")
                .pattern("BSB")
                .input('B', ModBlocks.SOLAR_BRICKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.COMBUSTED_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_block_fence"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOLAR_FENCE_GATE)
                .pattern("SBS")
                .pattern("SBS")
                .input('B', ModBlocks.SOLAR_BRICKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.SOLAR_BRICKS), conditionsFromItem(ModBlocks.SOLAR_BRICKS))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_block_fence_gate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOLAR_DOOR)
                .pattern("BB")
                .pattern("BB")
                .pattern("BB")
                .input('B', ModBlocks.SOLAR_BRICKS)
                .criterion(hasItem(ModBlocks.SOLAR_BRICKS), conditionsFromItem(ModBlocks.SOLAR_BRICKS))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_block_door"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOLAR_TRAPDOOR)
                .pattern("BBB")
                .pattern("BBB")
                .input('B', ModBlocks.SOLAR_BRICKS)
                .criterion(hasItem(ModBlocks.SOLAR_BRICKS), conditionsFromItem(ModBlocks.SOLAR_BRICKS))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_block_trapdoor"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOLAR_STAIRS)
                .pattern("B  ")
                .pattern("BB ")
                .pattern("BBB")
                .input('B', ModBlocks.SOLAR_BRICKS)
                .criterion(hasItem(ModBlocks.SOLAR_BRICKS), conditionsFromItem(ModBlocks.SOLAR_BRICKS))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_block_stairs"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOLAR_LAMP)
                .pattern("CSC")
                .pattern("SLS")
                .pattern("CSC")
                .input('C', ModItems.COMBUSTED_ESSENCE)
                .input('S', ModItems.SOLAR_ESSENCE)
                .input('L', Items.REDSTONE_LAMP)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.COMBUSTED_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "solar_block_lamp"));




        //MISC
        offerSmelting(recipeExporter, COMBUSTED_ESSENCE_SMELTABLES, RecipeCategory.MISC, ModItems.COMBUSTED_ESSENCE, 0.25f, 200, "combusted_essence");
        offerBlasting(recipeExporter, COMBUSTED_ESSENCE_SMELTABLES, RecipeCategory.MISC, ModItems.COMBUSTED_ESSENCE, 0.25f, 100, "combusted_essence");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.STARFRUIT_SEEDS)
                .input(ModItems.STARFRUIT, 1)
                .criterion(hasItem(ModItems.SOLAR_ESSENCE), conditionsFromItem(ModItems.SOLAR_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "edible_sun_shapeless_from_solar_essence"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.EDIBLE_SUN, 4)
                .pattern("KSK")
                .pattern("SCS")
                .pattern("KSK")
                .input('S', ModItems.SOLAR_ESSENCE)
                .input('C', ModItems.COMBUSTED_ESSENCE)
                .input('K', ModItems.STARFRUIT)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.SOLAR_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "edible_sun_shaped"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SUNLIGHT_SMITHING_TEMPLATE)
                .pattern("DCD")
                .pattern("DSD")
                .pattern("DDD")
                .input('S', ModBlocks.SOLAR_CLUSTER)
                .input('C', ModItems.SUNLIGHT_SMITHING_TEMPLATE)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(ModItems.COMBUSTED_ESSENCE), conditionsFromItem(ModItems.SOLAR_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(SkiesBeyond.MOD_ID, "sunlight_smithing_template_from_itself"));

        offerSmithingTrimRecipe(recipeExporter, ModItems.SUNLIGHT_SMITHING_TEMPLATE, Identifier.of(SkiesBeyond.MOD_ID, "sunlight"));


    }
}
