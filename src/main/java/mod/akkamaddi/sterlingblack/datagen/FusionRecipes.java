package mod.akkamaddi.sterlingblack.datagen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import mod.akkamaddi.sterlingblack.config.SterlingBlackConfig;
import mod.akkamaddi.sterlingblack.helpers.OnlySilverContents;
import mod.akkamaddi.sterlingblack.init.ModItems;
import mod.akkamaddi.sterlingblack.init.ModTags;
import mod.alexndr.fusion.api.datagen.FusionRecipeSetBuilder;
import mod.alexndr.fusion.api.recipe.AbstractFusionRecipeProvider;
import mod.alexndr.simplecorelib.api.datagen.ISimpleConditionBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Fusion RecipeProvider for Fusion
 */
public class FusionRecipes extends AbstractFusionRecipeProvider
        implements IConditionBuilder, ISimpleConditionBuilder
{
    private FusionRecipeSetBuilder fusionbuilder;

    public FusionRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
        fusionbuilder = new FusionRecipeSetBuilder(SterlingAndBlack.MODID);
    }

    
    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerSterlingSteelRecipes(consumer);
        registerBlackSilverRecipes(consumer);
        registerSilverRecyclingRecipes(consumer);
    }

    protected void registerSterlingSteelRecipes(Consumer<FinishedRecipe> consumer)
    {
        List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
        Ingredient[] catalysts = new Ingredient[3];

        primary_inputs.add(Ingredient.of(ModTags.Items.INGOTS_SILVER));
        primary_inputs.add(Ingredient.of(Items.IRON_INGOT));
        catalysts[0] = Ingredient.of(ItemTags.COALS);
        catalysts[1] = Ingredient.of(Items.LAPIS_LAZULI);
        catalysts[2] = Ingredient.of(Items.GLOWSTONE_DUST);
        
        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, ModItems.sterling_steel_nugget.get(),
                ModItems.medium_sterling_steel_chunk.get(), ModItems.large_sterling_steel_chunk.get(), 6.0F, 600,
                null);
        
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(ModItems.sterling_steel_axe.get(), ModItems.sterling_steel_boots.get(),
                        ModItems.sterling_steel_helmet.get(), ModItems.sterling_steel_hoe.get(), 
                        ModItems.sterling_steel_pickaxe.get(), ModItems.sterling_steel_shovel.get(),
                        ModItems.sterling_steel_sword.get()),
                Ingredient.of(ModItems.sterling_steel_chestplate.get(), ModItems.sterling_steel_leggings.get()),
                Ingredient.of(Items.GRAVEL), Ingredient.of(ItemTags.COALS), 
                ModItems.large_sterling_steel_chunk.get(), 15.0F, 600, 
                flag("recycling_enabled"), "recycle_sterling_steel_items");
    } // end registerSterlingSteelRecipes.

    protected void registerBlackSilverRecipes(Consumer<FinishedRecipe> consumer)
    {
        List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
        Ingredient[] catalysts = new Ingredient[3];

        primary_inputs.add(Ingredient.of(ModTags.Items.INGOTS_SILVER));
        primary_inputs.add(Ingredient.of(ModTags.Items.GEM_ONYX));
        catalysts[0] = Ingredient.of(ModItems.sterling_steel_nugget.get());
        catalysts[1] = Ingredient.of(ModItems.medium_sterling_steel_chunk.get());
        catalysts[2] = Ingredient.of(ModItems.large_sterling_steel_chunk.get());
        
        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, ModItems.black_silver_nugget.get(),
                ModItems.medium_black_silver_chunk.get(), ModItems.large_black_silver_chunk.get(), 9.0F, 600,
                null);
        
        fusionbuilder.buildFusionRecyclingRecipes(consumer, 
                Ingredient.of(ModItems.black_silver_axe.get(), ModItems.black_silver_boots.get(),
                        ModItems.black_silver_helmet.get(), ModItems.black_silver_hoe.get(), 
                        ModItems.black_silver_pickaxe.get(), ModItems.black_silver_shovel.get(),
                        ModItems.black_silver_sword.get()),
                Ingredient.of(ModItems.black_silver_chestplate.get(), ModItems.black_silver_leggings.get()),
                Ingredient.of(Items.GRAVEL), Ingredient.of(Items.LAVA_BUCKET), 
                ModItems.large_black_silver_chunk.get(), 20.0F, 600, 
                flag("recycling_enabled"), "recycle_black_silver_items");
    } // end registerBlackSilverRecipes

    private ResourceLocation make_silver_resource(String path) {
        return new ResourceLocation(OnlySilverContents.getModId(), path);
    }
    
    protected void registerSilverRecyclingRecipes(Consumer<FinishedRecipe> consumer)
    {
        if (OnlySilverContents.isModLoaded()) 
        {
            Ingredient doubleYield = Ingredient.of(
                    ForgeRegistries.ITEMS.getValue(make_silver_resource("silver_chestplate")),
                    ForgeRegistries.ITEMS.getValue(make_silver_resource("silver_leggings")));
            
            Ingredient singleYield = Ingredient.of(
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
                    Ingredient.of(Items.GRAVEL), Ingredient.of(ItemTags.COALS),
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
