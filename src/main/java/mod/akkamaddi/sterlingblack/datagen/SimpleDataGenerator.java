package mod.akkamaddi.sterlingblack.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import java.util.function.Consumer;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import mod.akkamaddi.sterlingblack.init.ModBlocks;
import mod.akkamaddi.sterlingblack.init.ModItems;
import mod.akkamaddi.sterlingblack.init.ModTags;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

/**
 * bundles up the GatherDataEvent handler and all the necessary data providers for
 * data generation.
 * @author Sinhika
 */
@EventBusSubscriber(modid = SterlingAndBlack.MODID, bus = MOD)
public class SimpleDataGenerator
{

    /**
     * GatherDataEvent handler.
     * @param event the GatherDataEvent.
     */
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        if (event.includeServer())
        {
            gen.addProvider(new Recipes(gen));
        }
     } // end gatherData()

    /** 
     * RecipeProvider for SterlingAndBlack.
     * @author Sinhika
     *
     */
    public static class Recipes extends RecipeProvider implements IConditionBuilder
    {

        public Recipes(DataGenerator generatorIn)
        {
            super(generatorIn);
        }

        protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
        {
            registerStorageRecipes(consumer);
            registerMiscRecipes(consumer);
            registerToolRecipes(consumer);
            registerArmorRecipes(consumer);
            registerFurnaceRecipes(consumer);
        } // end registerRecipes() 
        
        protected void registerToolRecipes(Consumer<IFinishedRecipe> consumer)
        {
            // axe
            ShapedRecipeBuilder.shapedRecipe(ModItems.sterling_steel_axe.get())
                .key('S', ModTags.Items.INGOTS_STERLING_STEEL)
                .key('T', Tags.Items.RODS_WOODEN)
                .patternLine("SS")
                .patternLine("ST")
                .patternLine(" T")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_STERLING_STEEL))
                .build(consumer);
            
            // hoe
            ShapedRecipeBuilder.shapedRecipe(ModItems.sterling_steel_hoe.get())
                .key('S', ModTags.Items.INGOTS_STERLING_STEEL)
                .key('T', Tags.Items.RODS_WOODEN)
                .patternLine("SS")
                .patternLine(" T")
                .patternLine(" T")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_STERLING_STEEL))
                .build(consumer);
            
            // pickaxe
            ShapedRecipeBuilder.shapedRecipe(ModItems.sterling_steel_pickaxe.get())
                .key('S', ModTags.Items.INGOTS_STERLING_STEEL)
                .key('T', Tags.Items.RODS_WOODEN)
                .patternLine("SSS")
                .patternLine(" T ")
                .patternLine(" T ")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_STERLING_STEEL))
                .build(consumer);
            
            // sword
            ShapedRecipeBuilder.shapedRecipe(ModItems.sterling_steel_sword.get())
                .key('S', ModTags.Items.INGOTS_STERLING_STEEL)
                .key('T', Tags.Items.RODS_WOODEN)
                .patternLine(" S")
                .patternLine(" S")
                .patternLine(" T")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_STERLING_STEEL))
                .build(consumer);
            
            // shovel
            ShapedRecipeBuilder.shapedRecipe(ModItems.sterling_steel_shovel.get())
                .key('S', ModTags.Items.INGOTS_STERLING_STEEL)
                .key('T', Tags.Items.RODS_WOODEN)
                .patternLine(" S")
                .patternLine(" T")
                .patternLine(" T")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_STERLING_STEEL))
                .build(consumer);
            
        } // end registerToolRecipes()
        
        protected void registerArmorRecipes(Consumer<IFinishedRecipe> consumer)
        {
            ShapedRecipeBuilder.shapedRecipe(ModItems.sterling_steel_helmet.get())
                .key('S', ModItems.sterling_steel_ingot.get())
                .patternLine("SSS")
                .patternLine("S S")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_STERLING_STEEL))
                .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ModItems.sterling_steel_chestplate.get())
                .key('S', ModItems.sterling_steel_ingot.get())
                .patternLine("S S")
                .patternLine("SSS")
                .patternLine("SSS")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_STERLING_STEEL))
                .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ModItems.sterling_steel_leggings.get())
                .key('S', ModItems.sterling_steel_ingot.get())
                .patternLine("SSS")
                .patternLine("S S")
                .patternLine("S S")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_STERLING_STEEL))
                .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ModItems.sterling_steel_boots.get())
                .key('S', ModItems.sterling_steel_ingot.get())
                .patternLine("   ")
                .patternLine("S S")
                .patternLine("S S")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_STERLING_STEEL))
                .build(consumer);
                
        } // end registerArmorRecipes()
        
        protected void registerStorageRecipes(Consumer<IFinishedRecipe> consumer)
        {
            // block <=> ingots
            ShapelessRecipeBuilder.shapelessRecipe(ModItems.sterling_steel_ingot.get(), 9)
                .addIngredient(ModBlocks.sterling_steel_block.get())
                .addCriterion("has_item", hasItem(ModTags.Items.BLOCK_STERLING_STEEL))
                .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ModBlocks.sterling_steel_block.get())
                .key('S', ModItems.sterling_steel_ingot.get())
                .patternLine("SSS")
                .patternLine("SSS")
                .patternLine("SSS")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_STERLING_STEEL))
                .build(consumer);
            
            // ingot <=> nuggets
            ShapelessRecipeBuilder.shapelessRecipe(ModItems.sterling_steel_nugget.get(), 9)
                .addIngredient(ModItems.sterling_steel_ingot.get())
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_STERLING_STEEL))
                .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ModItems.sterling_steel_ingot.get())
                .key('S', ModItems.sterling_steel_nugget.get())
                .patternLine("SSS")
                .patternLine("SSS")
                .patternLine("SSS")
                .addCriterion("has_item", hasItem(ModTags.Items.NUGGETS_STERLING_STEEL))
                .build(consumer, new ResourceLocation(SterlingAndBlack.MODID, "sterling_steel_ingot_from_nugget"));
        } // end registerStorageRecipes()
        
        protected void registerMiscRecipes(Consumer<IFinishedRecipe> consumer)
        {
            
        } // end registerMiscRecipes()

        protected void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer)
        {
            // No ores in this mod.
            
            // vanilla recycling, tools/armor => nuggets
            // smelting
            CookingRecipeBuilder
                    .smeltingRecipe(
                            Ingredient.fromItems(ModItems.sterling_steel_axe.get(),
                                    ModItems.sterling_steel_hoe.get(), ModItems.sterling_steel_pickaxe.get(),
                                    ModItems.sterling_steel_shovel.get(), ModItems.sterling_steel_sword.get()),
                            ModItems.sterling_steel_nugget.get(), 0.4F, 200)
                    .addCriterion("has_item", hasItem(ModItems.sterling_steel_axe.get()))
                    .build(consumer, new ResourceLocation(SterlingAndBlack.MODID, "sterling_steel_nugget_from_smelting_tools"));

            CookingRecipeBuilder
                    .smeltingRecipe(
                            Ingredient.fromItems(ModItems.sterling_steel_boots.get(), ModItems.sterling_steel_chestplate.get(),
                                    ModItems.sterling_steel_helmet.get(), ModItems.sterling_steel_leggings.get()),
                            ModItems.sterling_steel_nugget.get(), 0.4F, 200)
                    .addCriterion("has_item", hasItem(ModItems.sterling_steel_boots.get()))
                    .build(consumer, new ResourceLocation(SterlingAndBlack.MODID, "sterling_steel_nugget_from_smelting_armor"));
          
            // blasting
            CookingRecipeBuilder
                    .blastingRecipe(
                            Ingredient.fromItems(ModItems.sterling_steel_boots.get(), ModItems.sterling_steel_chestplate.get(),
                                    ModItems.sterling_steel_helmet.get(), ModItems.sterling_steel_leggings.get()),
                            ModItems.sterling_steel_nugget.get(), 0.4F, 100)
                    .addCriterion("has_item", hasItem(ModItems.sterling_steel_boots.get()))
                    .build(consumer, new ResourceLocation(SterlingAndBlack.MODID, "sterling_steel_nugget_from_blasting_armor"));

        } // end registerFurnaceRecipes()

    } // end subclass SterlingAndBlackDataGenerator$Recipes.
    
} // end-class SterlingAndBlackDataGenerator
