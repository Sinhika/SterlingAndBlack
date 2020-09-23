package mod.akkamaddi.sterlingblack.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import mod.akkamaddi.sterlingblack.config.SterlingBlackConfig;
import mod.akkamaddi.sterlingblack.helpers.OnlySilverContents;
import mod.akkamaddi.sterlingblack.init.ModBlocks;
import mod.akkamaddi.sterlingblack.init.ModItems;
import mod.akkamaddi.sterlingblack.init.ModTags;
import mod.alexndr.fusion.api.datagen.FusionRecipeSetBuilder;
import mod.alexndr.fusion.api.recipe.AbstractFusionRecipeProvider;
import mod.alexndr.simpleores.api.datagen.ISimpleConditionBuilder;
import mod.alexndr.simpleores.api.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;

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
            gen.addProvider(new FusionRecipes(gen));
        }
     } // end gatherData()

    
    /**
     * Fusion RecipeProvider for Fusion
     */
    public static class FusionRecipes extends AbstractFusionRecipeProvider
            implements IConditionBuilder, ISimpleConditionBuilder
    {
        private FusionRecipeSetBuilder fusionbuilder;

        public FusionRecipes(DataGenerator generatorIn)
        {
            super(generatorIn);
            fusionbuilder = new FusionRecipeSetBuilder(SterlingAndBlack.MODID);
        }

        
        @Override
        protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
        {
            registerSterlingSteelRecipes(consumer);
            registerBlackSilverRecipes(consumer);
            registerSilverRecyclingRecipes(consumer);
        }

        protected void registerSterlingSteelRecipes(Consumer<IFinishedRecipe> consumer)
        {
            List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
            Ingredient[] catalysts = new Ingredient[3];

            primary_inputs.add(Ingredient.fromTag(ModTags.Items.INGOTS_SILVER));
            primary_inputs.add(Ingredient.fromItems(Items.IRON_INGOT));
            catalysts[0] = Ingredient.fromTag(ItemTags.COALS);
            catalysts[1] = Ingredient.fromItems(Items.LAPIS_LAZULI);
            catalysts[2] = Ingredient.fromItems(Items.GLOWSTONE_DUST);
            
            fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, ModItems.sterling_steel_nugget.get(),
                    ModItems.medium_sterling_steel_chunk.get(), ModItems.large_sterling_steel_chunk.get(), 6.0F, 600,
                    null);
            
            fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                    Ingredient.fromItems(ModItems.sterling_steel_axe.get(), ModItems.sterling_steel_boots.get(),
                            ModItems.sterling_steel_helmet.get(), ModItems.sterling_steel_hoe.get(), 
                            ModItems.sterling_steel_pickaxe.get(), ModItems.sterling_steel_shovel.get(),
                            ModItems.sterling_steel_sword.get()),
                    Ingredient.fromItems(ModItems.sterling_steel_chestplate.get(), ModItems.sterling_steel_leggings.get()),
                    Ingredient.fromItems(Items.GRAVEL), Ingredient.fromTag(ItemTags.COALS), 
                    ModItems.large_sterling_steel_chunk.get(), 15.0F, 600, 
                    flag("recycling_enabled"), "recycle_sterling_steel_items");
        } // end registerSterlingSteelRecipes.

        protected void registerBlackSilverRecipes(Consumer<IFinishedRecipe> consumer)
        {
            List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
            Ingredient[] catalysts = new Ingredient[3];

            primary_inputs.add(Ingredient.fromTag(ModTags.Items.INGOTS_SILVER));
            primary_inputs.add(Ingredient.fromTag(ModTags.Items.GEM_ONYX));
            catalysts[0] = Ingredient.fromItems(ModItems.sterling_steel_nugget.get());
            catalysts[1] = Ingredient.fromItems(ModItems.medium_sterling_steel_chunk.get());
            catalysts[2] = Ingredient.fromItems(ModItems.large_sterling_steel_chunk.get());
            
            fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, ModItems.black_silver_nugget.get(),
                    ModItems.medium_black_silver_chunk.get(), ModItems.large_black_silver_chunk.get(), 9.0F, 600,
                    null);
            
            fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                    Ingredient.fromItems(ModItems.black_silver_axe.get(), ModItems.black_silver_boots.get(),
                            ModItems.black_silver_helmet.get(), ModItems.black_silver_hoe.get(), 
                            ModItems.black_silver_pickaxe.get(), ModItems.black_silver_shovel.get(),
                            ModItems.black_silver_sword.get()),
                    Ingredient.fromItems(ModItems.black_silver_chestplate.get(), ModItems.black_silver_leggings.get()),
                    Ingredient.fromItems(Items.GRAVEL), Ingredient.fromItems(Items.LAVA_BUCKET), 
                    ModItems.large_black_silver_chunk.get(), 20.0F, 600, 
                    flag("recycling_enabled"), "recycle_black_silver_items");
        } // end registerBlackSilverRecipes

        private ResourceLocation make_silver_resource(String path) {
            return new ResourceLocation(OnlySilverContents.getModId(), path);
        }
        
        protected void registerSilverRecyclingRecipes(Consumer<IFinishedRecipe> consumer)
        {
            if (OnlySilverContents.isModLoaded()) 
            {
                Ingredient doubleYield = Ingredient.fromItems(
                        ForgeRegistries.ITEMS.getValue(make_silver_resource("silver_chestplate")),
                        ForgeRegistries.ITEMS.getValue(make_silver_resource("silver_leggings")));
                
                Ingredient singleYield = Ingredient.fromItems(
                        ForgeRegistries.ITEMS.getValue(make_silver_resource("silver_wand")),
                        ForgeRegistries.ITEMS.getValue(make_silver_resource("silver_rod")),
                        ForgeRegistries.ITEMS.getValue(make_silver_resource("silver_bow")),
                        ForgeRegistries.ITEMS.getValue(make_silver_resource("silver_sword")),
                        ForgeRegistries.ITEMS.getValue(make_silver_resource("silver_pickaxe")),
                        ForgeRegistries.ITEMS.getValue(make_silver_resource("silver_axe")),
                        ForgeRegistries.ITEMS.getValue(make_silver_resource("silver_shovel")),
                        ForgeRegistries.ITEMS.getValue(make_silver_resource("silver_hoe")),
                        ForgeRegistries.ITEMS.getValue(make_silver_resource("silver_helmet")),
                        ForgeRegistries.ITEMS.getValue(make_silver_resource("silver_boots")));
                        
                fusionbuilder.buildFusionRecyclingRecipes(consumer, singleYield, doubleYield,
                        Ingredient.fromItems(Items.GRAVEL), Ingredient.fromTag(ItemTags.COALS),
                        ForgeRegistries.ITEMS.getValue(make_silver_resource("silver_ore")), 
                        10.0F, 600, and(flag("silver_recycling_enabled"), modLoaded("onlysilver")), 
                        "recycle_only_silver_items");
            }
        } // end registerSilverRecyclingRecipes

        
        @Override
        public ICondition flag(String name)
        {
            return impl_flag(SterlingAndBlack.MODID, SterlingBlackConfig.INSTANCE, name);
        }
    } // end-class FusionRecipes.
    
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
            
            setbuilder.buildChunkConversionRecipes(consumer, ModItems.sterling_steel_nugget.get(),
                    ModItems.medium_sterling_steel_chunk.get(), ModItems.large_sterling_steel_chunk.get(), 
                    hasItem(ModItems.sterling_steel_nugget.get()));
            
            // BLACK_SILVER
            setbuilder.buildSimpleStorageRecipes(consumer, ModItems.black_silver_ingot.get(), ModBlocks.black_silver_block.get(), 
                    ModItems.black_silver_nugget.get(), hasItem(ModItems.black_silver_ingot.get()));
            
            setbuilder.buildChunkConversionRecipes(consumer, ModItems.black_silver_nugget.get(),
                    ModItems.medium_black_silver_chunk.get(), ModItems.large_black_silver_chunk.get(), 
                    hasItem(ModItems.black_silver_nugget.get()));
        } // end registerStorageRecipes()
        
        protected void registerMiscRecipes(Consumer<IFinishedRecipe> consumer)
        {
        } // end registerMiscRecipes()

        protected void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer)
        {
            // Chunk to ingot
            setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModItems.large_black_silver_chunk.get()),
                    ModItems.black_silver_ingot.get(), hasItem(ModItems.large_black_silver_chunk.get()), 
                    9.0F, 200);
            setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModItems.large_sterling_steel_chunk.get()),
                    ModItems.sterling_steel_ingot.get(), hasItem(ModItems.large_sterling_steel_chunk.get()), 
                    6.0F, 200);
            
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
