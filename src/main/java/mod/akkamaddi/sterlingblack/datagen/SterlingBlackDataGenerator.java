package mod.akkamaddi.sterlingblack.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import java.util.function.Consumer;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import mod.akkamaddi.sterlingblack.config.SterlingBlackConfig;
import mod.akkamaddi.sterlingblack.init.ModBlocks;
import mod.akkamaddi.sterlingblack.init.ModItems;
import mod.akkamaddi.sterlingblack.init.ModTags;
import mod.alexndr.simpleores.api.datagen.ISimpleConditionBuilder;
import mod.alexndr.simpleores.api.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
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
public class SterlingBlackDataGenerator
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
    public static class Recipes extends RecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
    {
        private RecipeSetBuilder setbuilder;

        public Recipes(DataGenerator generatorIn)
        {
            super(generatorIn);
            setbuilder = new RecipeSetBuilder(SterlingAndBlack.MODID);
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
            // STERLING_STEEL
            setbuilder.buildSimpleToolSet(consumer, Ingredient.fromTag(ModTags.Items.INGOTS_STERLING_STEEL), "sterling_steel", 
                    hasItem(ModTags.Items.INGOTS_STERLING_STEEL), null, false);            
            
            // BLACK_SILVER
            setbuilder.buildSimpleToolSet(consumer, Ingredient.fromTag(ModTags.Items.INGOTS_BLACK_SILVER), "black_silver", 
                    hasItem(ModTags.Items.INGOTS_BLACK_SILVER), null, false);            
       } // end registerToolRecipes()
        
        protected void registerArmorRecipes(Consumer<IFinishedRecipe> consumer)
        {
            // STERLING_STEEL
            setbuilder.buildSimpleArmorSet(consumer, Ingredient.fromTag(ModTags.Items.INGOTS_STERLING_STEEL), "sterling_steel", 
                    hasItem(ModTags.Items.INGOTS_STERLING_STEEL), null);

            // BLACK_SILVER
            setbuilder.buildSimpleArmorSet(consumer, Ingredient.fromTag(ModTags.Items.INGOTS_BLACK_SILVER), "black_silver", 
                    hasItem(ModTags.Items.INGOTS_BLACK_SILVER), null);
            
        } // end registerArmorRecipes()
        
        protected void registerStorageRecipes(Consumer<IFinishedRecipe> consumer)
        {
            // STERLING_STEEL
            setbuilder.buildSimpleStorageRecipes(consumer, ModItems.sterling_steel_ingot.get(), ModBlocks.sterling_steel_block.get(), 
                    ModItems.sterling_steel_nugget.get(), hasItem(ModItems.sterling_steel_ingot.get()));
            
            // BLACK_SILVER
            setbuilder.buildSimpleStorageRecipes(consumer, ModItems.black_silver_ingot.get(), ModBlocks.black_silver_block.get(), 
                    ModItems.black_silver_nugget.get(), hasItem(ModItems.black_silver_ingot.get()));
        } // end registerStorageRecipes()
        
        protected void registerMiscRecipes(Consumer<IFinishedRecipe> consumer)
        {
            
        } // end registerMiscRecipes()

        protected void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer)
        {
            // No ores in this mod.
            
            // vanilla recycling, tools/armor => nuggets
            // STERLING_STEEL
            setbuilder.buildVanillaRecyclingRecipes(consumer,
                    Ingredient.fromItems(ModItems.sterling_steel_axe.get(), ModItems.sterling_steel_boots.get(), ModItems.sterling_steel_chestplate.get(),
                            ModItems.sterling_steel_helmet.get(), ModItems.sterling_steel_hoe.get(), ModItems.sterling_steel_leggings.get(), 
                            ModItems.sterling_steel_pickaxe.get(),ModItems.sterling_steel_shovel.get(), ModItems.sterling_steel_sword.get()), 
                    ModItems.sterling_steel_nugget.get(), hasItem(ModItems.sterling_steel_axe.get()), 
                    0.4F, 200);
            
            // BLACK_SILVER
            setbuilder.buildVanillaRecyclingRecipes(consumer,
                    Ingredient.fromItems(ModItems.black_silver_axe.get(), ModItems.black_silver_boots.get(), ModItems.black_silver_chestplate.get(),
                            ModItems.black_silver_helmet.get(), ModItems.black_silver_hoe.get(), ModItems.black_silver_leggings.get(), 
                            ModItems.black_silver_pickaxe.get(),ModItems.black_silver_shovel.get(), ModItems.black_silver_sword.get()), 
                    ModItems.black_silver_nugget.get(), hasItem(ModItems.black_silver_axe.get()), 
                    0.4F, 200);
        } // end registerFurnaceRecipes()

        
        @Override
        public ICondition flag(String name)
        {
            return impl_flag(SterlingAndBlack.MODID, SterlingBlackConfig.INSTANCE, name);
        }

    } // end subclass SterlingAndBlackDataGenerator$Recipes.
    
} // end-class SterlingAndBlackDataGenerator
