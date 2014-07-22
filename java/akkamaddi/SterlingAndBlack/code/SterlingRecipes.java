package akkamaddi.SterlingAndBlack.code;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import zotmc.onlysilver.api.OnlySilverAPI;
import alexndr.SimpleOres.core.Content;
import alexndr.SimpleOres.plugins.fusion.FusionRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class SterlingRecipes
{
    // wildcard
    // private static final int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;

    @SuppressWarnings("unchecked")
	public static void doSterlingRecipes()
    {
        // Ore Dictionary
        OreDictionary.registerOre("ingotSterlingSteel", new ItemStack(SterlingAndBlackCore.sterlingSteelIngot));
        OreDictionary.registerOre("ingotBlackSilver", new ItemStack(SterlingAndBlackCore.blackSilverIngot));
        
        // recipes: Crafting
        //Storage Block
        GameRegistry.addRecipe(new ItemStack(SterlingAndBlackCore.blockSterlingSteel, 1), 
        		new Object[] {"AAA", "AAA", "AAA", 'A', SterlingAndBlackCore.sterlingSteelIngot});
        GameRegistry.addRecipe(new ItemStack(SterlingAndBlackCore.blockBlackSilver, 1), 
        		new Object[] {"AAA", "AAA", "AAA", 'A', SterlingAndBlackCore.blackSilverIngot});
        //Item Recipe
        //Ingot Recipe
        GameRegistry.addShapelessRecipe(new ItemStack(SterlingAndBlackCore.sterlingSteelIngot, 9), new Object[]
                                        {
                                            SterlingAndBlackCore.blockSterlingSteel
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(SterlingAndBlackCore.blackSilverIngot, 9), new Object[]
                                        {
                                            SterlingAndBlackCore.blockBlackSilver
                                        });
        //Sterling Steel chunks
        GameRegistry.addShapelessRecipe(new ItemStack(SterlingAndBlackCore.largeSterlingSteelChunkItem, 1), new Object[]
                                        {
                                            SterlingAndBlackCore.smallSterlingSteelChunkItem, SterlingAndBlackCore.smallSterlingSteelChunkItem, SterlingAndBlackCore.smallSterlingSteelChunkItem, SterlingAndBlackCore.smallSterlingSteelChunkItem, SterlingAndBlackCore.smallSterlingSteelChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(SterlingAndBlackCore.largeSterlingSteelChunkItem, 1), new Object[]
                                        {
                                            SterlingAndBlackCore.mediumSterlingSteelChunkItem, SterlingAndBlackCore.mediumSterlingSteelChunkItem, SterlingAndBlackCore.mediumSterlingSteelChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(SterlingAndBlackCore.largeSterlingSteelChunkItem, 1), new Object[]
                                        {
                                            SterlingAndBlackCore.mediumSterlingSteelChunkItem, SterlingAndBlackCore.mediumSterlingSteelChunkItem, SterlingAndBlackCore.smallSterlingSteelChunkItem, SterlingAndBlackCore.smallSterlingSteelChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(SterlingAndBlackCore.mediumSterlingSteelChunkItem, 1), new Object[]
                                        {
                                            SterlingAndBlackCore.smallSterlingSteelChunkItem, SterlingAndBlackCore.smallSterlingSteelChunkItem, SterlingAndBlackCore.smallSterlingSteelChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(SterlingAndBlackCore.mediumSterlingSteelChunkItem, 2), new Object[]
                                        {
                                            SterlingAndBlackCore.largeSterlingSteelChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(SterlingAndBlackCore.smallSterlingSteelChunkItem, 2), new Object[]
                                        {
                                            SterlingAndBlackCore.mediumSterlingSteelChunkItem
                                        });
        //Black Silver chunks
        GameRegistry.addShapelessRecipe(new ItemStack(SterlingAndBlackCore.largeBlackSilverChunkItem, 1), new Object[]
                                        {
                                            SterlingAndBlackCore.smallBlackSilverChunkItem, SterlingAndBlackCore.smallBlackSilverChunkItem, SterlingAndBlackCore.smallBlackSilverChunkItem, SterlingAndBlackCore.smallBlackSilverChunkItem, SterlingAndBlackCore.smallBlackSilverChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(SterlingAndBlackCore.largeBlackSilverChunkItem, 1), new Object[]
                                        {
                                            SterlingAndBlackCore.mediumBlackSilverChunkItem, SterlingAndBlackCore.mediumBlackSilverChunkItem, SterlingAndBlackCore.mediumBlackSilverChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(SterlingAndBlackCore.largeBlackSilverChunkItem, 1), new Object[]
                                        {
                                            SterlingAndBlackCore.mediumBlackSilverChunkItem, SterlingAndBlackCore.mediumBlackSilverChunkItem, SterlingAndBlackCore.smallBlackSilverChunkItem, SterlingAndBlackCore.smallBlackSilverChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(SterlingAndBlackCore.mediumBlackSilverChunkItem, 1), new Object[]
                                        {
                                            SterlingAndBlackCore.smallBlackSilverChunkItem, SterlingAndBlackCore.smallBlackSilverChunkItem, SterlingAndBlackCore.smallBlackSilverChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(SterlingAndBlackCore.mediumBlackSilverChunkItem, 2), new Object[]
                                        {
                                            SterlingAndBlackCore.largeBlackSilverChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(SterlingAndBlackCore.smallBlackSilverChunkItem, 2), new Object[]
                                        {
                                            SterlingAndBlackCore.mediumBlackSilverChunkItem
                                        });
        // Tools
        //Sterling Steel Tool Recipes
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.sterlingSteelPickaxe, true, new Object[]
                {
                    "XXX", " Y ", " Y ", 'X', "ingotSterlingSteel", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.sterlingSteelAxe, true, new Object[]
                {
                    "XX ", "XY ", " Y ", 'X', "ingotSterlingSteel", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.sterlingSteelShovel, true, new Object[]
                {
                    "X", "Y", "Y", 'X', "ingotSterlingSteel", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.sterlingSteelSword, true, new Object[]
                {
                    "X", "X", "Y", 'X', "ingotSterlingSteel", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.sterlingSteelHoe, true, new Object[]
                {
                    "XX ", " Y ", " Y ", 'X', "ingotSterlingSteel", 'Y', "stickWood"
                }));
        //Sterling Steel Armor
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.sterlingSteelHelm, true, new Object[]
                {
                    "XXX", "X X", 'X', "ingotSterlingSteel"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.sterlingSteelChest, true, new Object[]
                {
                    "X X", "XXX", "XXX", 'X', "ingotSterlingSteel"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.sterlingSteelLegs, true, new Object[]
                {
                    "XXX", "X X", "X X", 'X', "ingotSterlingSteel"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.sterlingSteelBoots, true, new Object[]
                {
                    "X X", "X X", 'X', "ingotSterlingSteel"
                }));
        //Black Silver Tool Recipes
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.blackSilverPickaxe, true, new Object[]
                {
                    "XXX", " Y ", " Y ", 'X', "ingotBlackSilver", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.blackSilverAxe, true, new Object[]
                {
                    "XX ", "XY ", " Y ", 'X', "ingotBlackSilver", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.blackSilverShovel, true, new Object[]
                {
                    "X", "Y", "Y", 'X', "ingotBlackSilver", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.blackSilverSword, true, new Object[]
                {
                    "X", "X", "Y", 'X', "ingotBlackSilver", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.blackSilverHoe, true, new Object[]
                {
                    "XX ", " Y ", " Y ", 'X', "ingotBlackSilver", 'Y', "stickWood"
                }));
        //Black Silver Armor
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.blackSilverHelm, true, new Object[]
                {
                    "XXX", "X X", 'X', "ingotBlackSilver"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.blackSilverChest, true, new Object[]
                {
                    "X X", "XXX", "XXX", 'X', "ingotBlackSilver"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.blackSilverLegs, true, new Object[]
                {
                    "XXX", "X X", "X X", 'X', "ingotBlackSilver"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SterlingAndBlackCore.blackSilverBoots, true, new Object[]
                {
                    "X X", "X X", 'X', "ingotBlackSilver"
                }));
        // recipes: Rails
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.rail, 24, 0), true, new Object[]
                {
                    "X X", "XYX", "X X", 'X', "ingotSterlingSteel", 'Y', "stickWood"
                }));
        
        // recipes: Smelting
        GameRegistry.addSmelting(SterlingAndBlackCore.largeSterlingSteelChunkItem, new ItemStack(SterlingAndBlackCore.sterlingSteelIngot), 6.0F);
        GameRegistry.addSmelting(SterlingAndBlackCore.largeBlackSilverChunkItem, new ItemStack(SterlingAndBlackCore.blackSilverIngot), 9.0F);
        
        // recipes: Fusion Furnace
        //Sterling Steel
        FusionRecipes.addSmelting(new ItemStack(Items.iron_ingot), 
        		new ItemStack(OnlySilverAPI.silverIngot.get()), new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
        		new ItemStack(SterlingAndBlackCore.smallSterlingSteelChunkItem), 6.0F);
        FusionRecipes.addSmelting(new ItemStack(Items.iron_ingot), new ItemStack(OnlySilverAPI.silverIngot.get()), 
        		new ItemStack(Items.dye, 1, 4), new ItemStack(SterlingAndBlackCore.mediumSterlingSteelChunkItem), 8.0F);
        FusionRecipes.addSmelting(new ItemStack(Items.iron_ingot), new ItemStack(OnlySilverAPI.silverIngot.get()), 
        		new ItemStack(Items.glowstone_dust), new ItemStack(SterlingAndBlackCore.largeSterlingSteelChunkItem), 20.F);
        //Black Silver
        FusionRecipes.addSmelting(new ItemStack(Content.onyx_gem), new ItemStack(OnlySilverAPI.silverIngot.get()), 
        		new ItemStack(SterlingAndBlackCore.smallSterlingSteelChunkItem), 
        		new ItemStack(SterlingAndBlackCore.smallBlackSilverChunkItem), 9.0F);
        FusionRecipes.addSmelting(new ItemStack(Content.onyx_gem), new ItemStack(OnlySilverAPI.silverIngot.get()), 
        		new ItemStack(SterlingAndBlackCore.mediumSterlingSteelChunkItem), 
        		new ItemStack(SterlingAndBlackCore.mediumBlackSilverChunkItem), 12.0F);
        FusionRecipes.addSmelting(new ItemStack(Content.onyx_gem), new ItemStack(OnlySilverAPI.silverIngot.get()), 
        		new ItemStack(SterlingAndBlackCore.largeSterlingSteelChunkItem), 
        		new ItemStack(SterlingAndBlackCore.largeBlackSilverChunkItem), 30.F);

        if (SterlingAndBlackCore.enableRecycling)
        {
            // Sterling Steel
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.sterlingSteelHelm, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(SterlingAndBlackCore.largeSterlingSteelChunkItem), 15.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.sterlingSteelChest, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel, 2, 0), new ItemStack(Items.coal, 2, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(SterlingAndBlackCore.largeSterlingSteelChunkItem, 2, 0), 30.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.sterlingSteelLegs, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel, 2, 0), new ItemStack(Items.coal, 2, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(SterlingAndBlackCore.largeSterlingSteelChunkItem, 2, 0), 30.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.sterlingSteelBoots, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(SterlingAndBlackCore.largeSterlingSteelChunkItem), 15.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.sterlingSteelSword, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(SterlingAndBlackCore.largeSterlingSteelChunkItem), 15.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.sterlingSteelShovel, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(SterlingAndBlackCore.largeSterlingSteelChunkItem), 15.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.sterlingSteelPickaxe, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(SterlingAndBlackCore.largeSterlingSteelChunkItem), 15.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.sterlingSteelAxe, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(SterlingAndBlackCore.largeSterlingSteelChunkItem), 15.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.sterlingSteelHoe, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(SterlingAndBlackCore.largeSterlingSteelChunkItem), 15.0F);
            
            // Black Silver
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.blackSilverHelm, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.lava_bucket), 
            		new ItemStack(SterlingAndBlackCore.largeBlackSilverChunkItem), 20.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.blackSilverChest, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel, 2, 0), new ItemStack(Items.lava_bucket), 
            		new ItemStack(SterlingAndBlackCore.largeBlackSilverChunkItem, 2, 0), 40.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.blackSilverLegs, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel, 2, 0), new ItemStack(Items.lava_bucket), 
            		new ItemStack(SterlingAndBlackCore.largeBlackSilverChunkItem, 2, 0), 40.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.blackSilverBoots, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.lava_bucket), 
            		new ItemStack(SterlingAndBlackCore.largeBlackSilverChunkItem), 20.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.blackSilverSword, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.lava_bucket), 
            		new ItemStack(SterlingAndBlackCore.largeBlackSilverChunkItem), 20.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.blackSilverShovel, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.lava_bucket), 
            		new ItemStack(SterlingAndBlackCore.largeBlackSilverChunkItem), 20.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.blackSilverPickaxe, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.lava_bucket), 
            		new ItemStack(SterlingAndBlackCore.largeBlackSilverChunkItem), 20.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.blackSilverAxe, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.lava_bucket), 
            		new ItemStack(SterlingAndBlackCore.largeBlackSilverChunkItem), 20.0F);
            FusionRecipes.addSmelting(new ItemStack(SterlingAndBlackCore.blackSilverHoe, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.lava_bucket), 
            		new ItemStack(SterlingAndBlackCore.largeBlackSilverChunkItem), 20.0F);
        } // end-if enableRecycling
    }
}
