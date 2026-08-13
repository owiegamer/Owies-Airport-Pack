package owiegamer.owies_airport_pack_neoforge.datagen;


import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import owiegamer.owies_airport_pack_neoforge.OwiesAirportPackNeoforge;
import owiegamer.owies_airport_pack_neoforge.block.ModBlocks;
import owiegamer.owies_airport_pack_neoforge.item.ModItems;


import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GROUNDLIGHTRED.get())
                .pattern("   ")
                .pattern(" G ")
                .pattern("ASA")
                .define('A', ModBlocks.ASPHALT.get())
                .define('S', Blocks.GLOWSTONE)
                .define('G', Blocks.RED_STAINED_GLASS)
                .unlockedBy("has_glowstone", has(Blocks.GLOWSTONE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GROUNDLIGHTGREEN.get())
                .pattern("   ")
                .pattern(" G ")
                .pattern("ASA")
                .define('A', ModBlocks.ASPHALT.get())
                .define('S', Blocks.GLOWSTONE)
                .define('G', Blocks.GREEN_STAINED_GLASS)
                .unlockedBy("has_glowstone", has(Blocks.GLOWSTONE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GROUNDLIGHTBLUE.get())
                .pattern("   ")
                .pattern(" G ")
                .pattern("ASA")
                .define('A', ModBlocks.ASPHALT.get())
                .define('S', Blocks.GLOWSTONE)
                .define('G', Blocks.BLUE_STAINED_GLASS)
                .unlockedBy("has_glowstone", has(Blocks.GLOWSTONE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GROUNDLIGHTWHITE.get())
                .pattern("   ")
                .pattern(" G ")
                .pattern("ASA")
                .define('A', ModBlocks.ASPHALT.get())
                .define('S', Blocks.GLOWSTONE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_glowstone", has(Blocks.GLOWSTONE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LINEBRUSH.get())
                .pattern("FFF")
                .pattern("SSS")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('F', Items.FEATHER)
                .unlockedBy("has_feather", has(Items.FEATHER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PAINTBUCKETYELLOW.get())
                .pattern("IYI")
                .pattern("IYI")
                .pattern("III")
                .define('I', Items.IRON_INGOT)
                .define('Y', Items.YELLOW_DYE)
                .unlockedBy("has_iron", has(Items.IRON_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PAINTBUCKETWHITE.get())
                .pattern("IYI")
                .pattern("IYI")
                .pattern("III")
                .define('I', Items.IRON_INGOT)
                .define('Y', Items.WHITE_DYE)
                .unlockedBy("has_iron", has(Items.IRON_INGOT)).save(recipeOutput);



        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.STONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUNWAYCONCRETE, 4)
                .unlockedBy("has_stone", has(Items.STONE)).save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.BLACKSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASPHALT, 4)
                .unlockedBy("has_blackstone", has(Items.BLACKSTONE)).save(recipeOutput);

    }


    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, OwiesAirportPackNeoforge.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}