package akkamaddi.plugins.sterlingandblack;

import alexndr.api.core.LogHelper;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import alexndr.plugins.Fusion.FusionMaterial;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes
{
 	public static void preInitialize()
	{
		try {
			addOreDictEntries();
			LogHelper.verboseInfo(ModInfo.ID,
					"All OreDictionary entries were added successfully.");
		} 
		catch (Exception e) {
			LogHelper.severe(ModInfo.ID,
			 "OreDictionary entries were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
	} // end preInitialize()
	
	public static void initialize()
	{
		try {
			addRecipes();
			LogHelper.verboseInfo(ModInfo.ID,
					"All recipes were added successfully.");
		} catch (Exception e) {
			LogHelper.severe(ModInfo.ID,
							"Recipes were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
	} // end initialize()

	public static void addOreDictEntries()
	{
        // Ore Dictionary
		OreDictionary.registerOre("ingotSterlingSteel", new ItemStack(
				Content.sterlingSteelIngot));
		OreDictionary.registerOre("ingotBlackSilver", new ItemStack(
				Content.blackSilverIngot));
        
	} // end addOreDictEntries()
	
    @SuppressWarnings("unchecked")
	public static void addRecipes()
    {
        //Storage Block
        GameRegistry.addRecipe(new ItemStack(Content.blockSterlingSteel, 1), 
        		new Object[] {"AAA", "AAA", "AAA", 'A', Content.sterlingSteelIngot});
        GameRegistry.addRecipe(new ItemStack(Content.blockBlackSilver, 1), 
        		new Object[] {"AAA", "AAA", "AAA", 'A', Content.blackSilverIngot});
        
        //Item Recipe
        //Ingot Recipe
        GameRegistry.addShapelessRecipe(new ItemStack(Content.sterlingSteelIngot, 9), new Object[]
                                        {
                                            Content.blockSterlingSteel
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(Content.blackSilverIngot, 9), new Object[]
                                        {
                                            Content.blockBlackSilver
                                        });
        //Sterling Steel chunks
        GameRegistry.addShapelessRecipe(new ItemStack(Content.largeSterlingSteelChunkItem, 1), new Object[]
                                        {
                                            Content.smallSterlingSteelChunkItem, Content.smallSterlingSteelChunkItem, Content.smallSterlingSteelChunkItem, Content.smallSterlingSteelChunkItem, Content.smallSterlingSteelChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(Content.largeSterlingSteelChunkItem, 1), new Object[]
                                        {
                                            Content.mediumSterlingSteelChunkItem, Content.mediumSterlingSteelChunkItem, Content.mediumSterlingSteelChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(Content.largeSterlingSteelChunkItem, 1), new Object[]
                                        {
                                            Content.mediumSterlingSteelChunkItem, Content.mediumSterlingSteelChunkItem, Content.smallSterlingSteelChunkItem, Content.smallSterlingSteelChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(Content.mediumSterlingSteelChunkItem, 1), new Object[]
                                        {
                                            Content.smallSterlingSteelChunkItem, Content.smallSterlingSteelChunkItem, Content.smallSterlingSteelChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(Content.mediumSterlingSteelChunkItem, 2), new Object[]
                                        {
                                            Content.largeSterlingSteelChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(Content.smallSterlingSteelChunkItem, 2), new Object[]
                                        {
                                            Content.mediumSterlingSteelChunkItem
                                        });
        //Black Silver chunks
        GameRegistry.addShapelessRecipe(new ItemStack(Content.largeBlackSilverChunkItem, 1), new Object[]
                                        {
                                            Content.smallBlackSilverChunkItem, Content.smallBlackSilverChunkItem, Content.smallBlackSilverChunkItem, Content.smallBlackSilverChunkItem, Content.smallBlackSilverChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(Content.largeBlackSilverChunkItem, 1), new Object[]
                                        {
                                            Content.mediumBlackSilverChunkItem, Content.mediumBlackSilverChunkItem, Content.mediumBlackSilverChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(Content.largeBlackSilverChunkItem, 1), new Object[]
                                        {
                                            Content.mediumBlackSilverChunkItem, Content.mediumBlackSilverChunkItem, Content.smallBlackSilverChunkItem, Content.smallBlackSilverChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(Content.mediumBlackSilverChunkItem, 1), new Object[]
                                        {
                                            Content.smallBlackSilverChunkItem, Content.smallBlackSilverChunkItem, Content.smallBlackSilverChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(Content.mediumBlackSilverChunkItem, 2), new Object[]
                                        {
                                            Content.largeBlackSilverChunkItem
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(Content.smallBlackSilverChunkItem, 2), new Object[]
                                        {
                                            Content.mediumBlackSilverChunkItem
                                        });
        // Tools
        //Sterling Steel Tool Recipes
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sterlingSteelPickaxe, true, new Object[]
                {
                    "XXX", " Y ", " Y ", 'X', "ingotSterlingSteel", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sterlingSteelAxe, true, new Object[]
                {
                    "XX ", "XY ", " Y ", 'X', "ingotSterlingSteel", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sterlingSteelShovel, true, new Object[]
                {
                    "X", "Y", "Y", 'X', "ingotSterlingSteel", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sterlingSteelSword, true, new Object[]
                {
                    "X", "X", "Y", 'X', "ingotSterlingSteel", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sterlingSteelHoe, true, new Object[]
                {
                    "XX ", " Y ", " Y ", 'X', "ingotSterlingSteel", 'Y', "stickWood"
                }));
        //Sterling Steel Armor
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sterlingSteelHelm, true, new Object[]
                {
                    "XXX", "X X", 'X', "ingotSterlingSteel"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sterlingSteelChest, true, new Object[]
                {
                    "X X", "XXX", "XXX", 'X', "ingotSterlingSteel"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sterlingSteelLegs, true, new Object[]
                {
                    "XXX", "X X", "X X", 'X', "ingotSterlingSteel"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sterlingSteelBoots, true, new Object[]
                {
                    "X X", "X X", 'X', "ingotSterlingSteel"
                }));
        //Black Silver Tool Recipes
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.blackSilverPickaxe, true, new Object[]
                {
                    "XXX", " Y ", " Y ", 'X', "ingotBlackSilver", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.blackSilverAxe, true, new Object[]
                {
                    "XX ", "XY ", " Y ", 'X', "ingotBlackSilver", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.blackSilverShovel, true, new Object[]
                {
                    "X", "Y", "Y", 'X', "ingotBlackSilver", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.blackSilverSword, true, new Object[]
                {
                    "X", "X", "Y", 'X', "ingotBlackSilver", 'Y', "stickWood"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.blackSilverHoe, true, new Object[]
                {
                    "XX ", " Y ", " Y ", 'X', "ingotBlackSilver", 'Y', "stickWood"
                }));
        //Black Silver Armor
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.blackSilverHelm, true, new Object[]
                {
                    "XXX", "X X", 'X', "ingotBlackSilver"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.blackSilverChest, true, new Object[]
                {
                    "X X", "XXX", "XXX", 'X', "ingotBlackSilver"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.blackSilverLegs, true, new Object[]
                {
                    "XXX", "X X", "X X", 'X', "ingotBlackSilver"
                }));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.blackSilverBoots, true, new Object[]
                {
                    "X X", "X X", 'X', "ingotBlackSilver"
                }));
        // recipes: Rails
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.rail, 24, 0), true, new Object[]
                {
                    "X X", "XYX", "X X", 'X', "ingotSterlingSteel", 'Y', "stickWood"
                }));
        
        // recipes: Smelting
        GameRegistry.addSmelting(Content.largeSterlingSteelChunkItem, new ItemStack(Content.sterlingSteelIngot), 6.0F);
        GameRegistry.addSmelting(Content.largeBlackSilverChunkItem, new ItemStack(Content.blackSilverIngot), 9.0F);
        
        // recipes: Fusion Furnace
        //Sterling Steel
		FusionFurnaceRecipes.addSmelting(
				FusionMaterial.of("ingotIron"),
				FusionMaterial.of("ingotSilver"), 
				FusionMaterial.of(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
				new ItemStack(Content.smallSterlingSteelChunkItem), 6.0F);
		FusionFurnaceRecipes.addSmelting(
				FusionMaterial.of("ingotIron"),
				FusionMaterial.of("ingotSilver"), 
				FusionMaterial.of(Items.dye, 1, 4), 
				new ItemStack(Content.mediumSterlingSteelChunkItem), 8.0F);
		FusionFurnaceRecipes.addSmelting(
				FusionMaterial.of("ingotIron"),
				FusionMaterial.of("ingotSilver"), 
				FusionMaterial.of(Items.glowstone_dust), 
				new ItemStack(Content.largeSterlingSteelChunkItem), 20.F);
        
        //Black Silver
		FusionFurnaceRecipes.addSmelting(
				FusionMaterial.of("gemOnyx"), 
				FusionMaterial.of("ingotSilver"), 
				FusionMaterial.of(Content.smallSterlingSteelChunkItem), 
				new ItemStack(Content.smallBlackSilverChunkItem), 9.0F);
		FusionFurnaceRecipes.addSmelting(
				FusionMaterial.of("gemOnyx"), 
				FusionMaterial.of("ingotSilver"), 
				FusionMaterial.of(Content.mediumSterlingSteelChunkItem), 
				new ItemStack(Content.mediumBlackSilverChunkItem), 12.0F);
		FusionFurnaceRecipes.addSmelting(
				FusionMaterial.of("gemOnyx"), 
				FusionMaterial.of("ingotSilver"), 
				FusionMaterial.of(Content.largeSterlingSteelChunkItem), 
				new ItemStack(Content.largeBlackSilverChunkItem), 30.F);

        if (Settings.enableRecycling)
        {
            // Sterling Steel
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.sterlingSteelHelm, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Content.largeSterlingSteelChunkItem), 15.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.sterlingSteelChest, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel, 2, 0), new ItemStack(Items.coal, 2, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Content.largeSterlingSteelChunkItem, 2, 0), 30.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.sterlingSteelLegs, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel, 2, 0), new ItemStack(Items.coal, 2, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Content.largeSterlingSteelChunkItem, 2, 0), 30.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.sterlingSteelBoots, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Content.largeSterlingSteelChunkItem), 15.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.sterlingSteelSword, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Content.largeSterlingSteelChunkItem), 15.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.sterlingSteelShovel, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Content.largeSterlingSteelChunkItem), 15.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.sterlingSteelPickaxe, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Content.largeSterlingSteelChunkItem), 15.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.sterlingSteelAxe, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Content.largeSterlingSteelChunkItem), 15.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.sterlingSteelHoe, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Content.largeSterlingSteelChunkItem), 15.0F);
            
            // Black Silver
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.blackSilverHelm, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.lava_bucket), 
            		new ItemStack(Content.largeBlackSilverChunkItem), 20.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.blackSilverChest, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel, 2, 0), new ItemStack(Items.lava_bucket), 
            		new ItemStack(Content.largeBlackSilverChunkItem, 2, 0), 40.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.blackSilverLegs, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel, 2, 0), new ItemStack(Items.lava_bucket), 
            		new ItemStack(Content.largeBlackSilverChunkItem, 2, 0), 40.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.blackSilverBoots, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.lava_bucket), 
            		new ItemStack(Content.largeBlackSilverChunkItem), 20.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.blackSilverSword, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.lava_bucket), 
            		new ItemStack(Content.largeBlackSilverChunkItem), 20.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.blackSilverShovel, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.lava_bucket), 
            		new ItemStack(Content.largeBlackSilverChunkItem), 20.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.blackSilverPickaxe, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.lava_bucket), 
            		new ItemStack(Content.largeBlackSilverChunkItem), 20.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.blackSilverAxe, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.lava_bucket), 
            		new ItemStack(Content.largeBlackSilverChunkItem), 20.0F);
            FusionFurnaceRecipes.addSmelting(new ItemStack(Content.blackSilverHoe, 1, OreDictionary.WILDCARD_VALUE), 
            		new ItemStack(Blocks.gravel), new ItemStack(Items.lava_bucket), 
            		new ItemStack(Content.largeBlackSilverChunkItem), 20.0F);
        } // end-if enableRecycling
    }
}
