package mod.akkamaddi.sterlingblack.datagen;

import java.util.function.Consumer;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import mod.akkamaddi.sterlingblack.config.SterlingBlackConfig;
import mod.akkamaddi.sterlingblack.init.ModBlocks;
import mod.akkamaddi.sterlingblack.init.ModItems;
import mod.akkamaddi.sterlingblack.init.ModTags;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

/** 
 * RecipeProvider for SterlingAndBlack.
 * @author Sinhika
 *
 */
public class Recipes extends RecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
{
    private RecipeSetBuilder setbuilder;

    public Recipes(DataGenerator generatorIn)
    {
        super(generatorIn);
        setbuilder = new RecipeSetBuilder(SterlingAndBlack.MODID);
    }

    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer)
    {
        registerStorageRecipes(consumer);
        registerMiscRecipes(consumer);
        registerToolRecipes(consumer);
        registerArmorRecipes(consumer);
        registerFurnaceRecipes(consumer);
    } // end registerRecipes() 
    
    protected void registerToolRecipes(Consumer<IFinishedRecipe> consumer)
    {
        // STERLING_STEEL
        setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModTags.Items.INGOTS_STERLING_STEEL), "sterling_steel", 
                has(ModTags.Items.INGOTS_STERLING_STEEL), null, false);            
        
        // BLACK_SILVER
        setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModTags.Items.INGOTS_BLACK_SILVER), "black_silver", 
                has(ModTags.Items.INGOTS_BLACK_SILVER), null, false);            
   } // end registerToolRecipes()
    
    protected void registerArmorRecipes(Consumer<IFinishedRecipe> consumer)
    {
        // STERLING_STEEL
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModTags.Items.INGOTS_STERLING_STEEL), "sterling_steel", 
                has(ModTags.Items.INGOTS_STERLING_STEEL), null);

        // BLACK_SILVER
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModTags.Items.INGOTS_BLACK_SILVER), "black_silver", 
                has(ModTags.Items.INGOTS_BLACK_SILVER), null);
        
    } // end registerArmorRecipes()
    
    protected void registerStorageRecipes(Consumer<IFinishedRecipe> consumer)
    {
        // STERLING_STEEL
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.sterling_steel_ingot.get(), ModBlocks.sterling_steel_block.get(), 
                ModItems.sterling_steel_nugget.get(), has(ModItems.sterling_steel_ingot.get()));
        
        setbuilder.buildChunkConversionRecipes(consumer, ModItems.sterling_steel_nugget.get(),
                ModItems.medium_sterling_steel_chunk.get(), ModItems.large_sterling_steel_chunk.get(), 
                has(ModItems.sterling_steel_nugget.get()));
        
        // BLACK_SILVER
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.black_silver_ingot.get(), ModBlocks.black_silver_block.get(), 
                ModItems.black_silver_nugget.get(), has(ModItems.black_silver_ingot.get()));
        
        setbuilder.buildChunkConversionRecipes(consumer, ModItems.black_silver_nugget.get(),
                ModItems.medium_black_silver_chunk.get(), ModItems.large_black_silver_chunk.get(), 
                has(ModItems.black_silver_nugget.get()));
    } // end registerStorageRecipes()
    
    protected void registerMiscRecipes(Consumer<IFinishedRecipe> consumer)
    {
        // rails
        ShapedRecipeBuilder.shaped(Blocks.RAIL.asItem(), 24)
                .define('X', Ingredient.of(ModItems.sterling_steel_ingot.get()))
                .define('Y', Ingredient.of(Tags.Items.RODS_WOODEN))
                .pattern("X X")
                .pattern("XYX")
                .pattern("X X")
                .unlockedBy("hasItem", has(ModItems.sterling_steel_ingot.get()))
                .save(consumer, new ResourceLocation(SterlingAndBlack.MODID, "rails_with_sterling_silver"));
    } // end registerMiscRecipes()

    protected void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer)
    {
        // Chunk to ingot
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_black_silver_chunk.get()),
                ModItems.black_silver_ingot.get(), has(ModItems.large_black_silver_chunk.get()), 
                9.0F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_sterling_steel_chunk.get()),
                ModItems.sterling_steel_ingot.get(), has(ModItems.large_sterling_steel_chunk.get()), 
                6.0F, 200);
        
        // vanilla recycling, tools/armor => nuggets
        // STERLING_STEEL
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.of(ModItems.sterling_steel_axe.get(), ModItems.sterling_steel_boots.get(), ModItems.sterling_steel_chestplate.get(),
                        ModItems.sterling_steel_helmet.get(), ModItems.sterling_steel_hoe.get(), ModItems.sterling_steel_leggings.get(), 
                        ModItems.sterling_steel_pickaxe.get(),ModItems.sterling_steel_shovel.get(), ModItems.sterling_steel_sword.get()), 
                ModItems.sterling_steel_nugget.get(), has(ModItems.sterling_steel_axe.get()), 
                0.4F, 200);
        
        // BLACK_SILVER
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.of(ModItems.black_silver_axe.get(), ModItems.black_silver_boots.get(), ModItems.black_silver_chestplate.get(),
                        ModItems.black_silver_helmet.get(), ModItems.black_silver_hoe.get(), ModItems.black_silver_leggings.get(), 
                        ModItems.black_silver_pickaxe.get(),ModItems.black_silver_shovel.get(), ModItems.black_silver_sword.get()), 
                ModItems.black_silver_nugget.get(), has(ModItems.black_silver_axe.get()), 
                0.4F, 200);
    } // end registerFurnaceRecipes()

    
    @Override
    public ICondition flag(String name)
    {
        return impl_flag(SterlingAndBlack.MODID, SterlingBlackConfig.INSTANCE, name);
    }

} // end subclass SterlingAndBlackDataGenerator$Recipes.
