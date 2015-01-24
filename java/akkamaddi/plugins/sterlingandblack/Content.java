package akkamaddi.plugins.sterlingandblack;

import java.util.LinkedList;
import java.util.List;

import com.google.common.base.Predicates;

import akkamaddi.api.core.LootHelper;
import alexndr.api.content.items.SimpleAxe;
import alexndr.api.content.items.SimpleHoe;
import alexndr.api.content.items.SimplePickaxe;
import alexndr.api.content.items.SimpleShovel;
import alexndr.api.content.items.SimpleSword;
import alexndr.api.core.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zotmc.onlysilver.api.OnlySilverRegistry;

public class Content 
{
    public static List<Item> silverstuff;

	/**
	 * Loads all the Sterling & Black content, by calling the methods below.
	 */
	public static void preInitialize()
	{
		silverstuff =  new LinkedList<Item>();
		
		try {
			doItems();
			LogHelper.verboseInfo(ModInfo.ID,
					"All items were added successfully");
		} 
		catch (Exception e) {
			LogHelper.severe(ModInfo.ID,
							"Items were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
		try {
			doBlocks();
			LogHelper.verboseInfo(ModInfo.ID,
					"All blocks were added successfully");
		} 
		catch (Exception e) {
			LogHelper.severe(ModInfo.ID,
							"Blocks were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
		try {
			doTools();
			LogHelper.verboseInfo(ModInfo.ID,
					"All tools were added successfully");
		} 
		catch (Exception e) {
			LogHelper.severe(ModInfo.ID,
							"Tools were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
		try {
			doArmor();
			LogHelper.verboseInfo(ModInfo.ID,
					"All armor was added successfully");
		} 
		catch (Exception e) {
			LogHelper.severe(ModInfo.ID,
							"Armor was not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
        
        // register silver items with OnlySilver so that silver enchantments are applicable.
		for (Item item : silverstuff) {
			OnlySilverRegistry.registerSilverPredicate(item, Predicates.<ItemStack>alwaysTrue());
		}
		

	} // end preInitialize()
	
	public static void doArmor() 
	{
        // subclass armor
        sterlingSteelHelm = new SterlingSteelArmor(armorSterlingSteel, rendererSterlingSteel, 0).modId("sterlingandblack").setType("sterlingSteel").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelHelm");
        silverstuff.add(sterlingSteelHelm);
        sterlingSteelChest = new SterlingSteelArmor(armorSterlingSteel, rendererSterlingSteel, 1).modId("sterlingandblack").setType("sterlingSteel").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelChest");
        silverstuff.add(sterlingSteelChest);
        sterlingSteelLegs = new SterlingSteelArmor(armorSterlingSteel, rendererSterlingSteel, 2).modId("sterlingandblack").setType("sterlingSteel").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelLegs");
        silverstuff.add(sterlingSteelLegs);
        sterlingSteelBoots = new SterlingSteelArmor( armorSterlingSteel, rendererSterlingSteel, 3).modId("sterlingandblack").setType("sterlingSteel").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelBoots");
        silverstuff.add(sterlingSteelBoots);
        
        // subclass armor
        blackSilverHelm = new BlackSilverArmor(armorBlackSilver, rendererBlackSilver, 0).modId("sterlingandblack").setType("blackSilver").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("blackSilverHelm");
        silverstuff.add(blackSilverHelm);
        blackSilverChest = new BlackSilverArmor(armorBlackSilver, rendererBlackSilver, 1).modId("sterlingandblack").setType("blackSilver").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("blackSilverChest");
        silverstuff.add(blackSilverChest);
        blackSilverLegs = new BlackSilverArmor(armorBlackSilver, rendererBlackSilver, 2).modId("sterlingandblack").setType("blackSilver").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("blackSilverLegs");
        silverstuff.add(blackSilverLegs);
        blackSilverBoots = new BlackSilverArmor(armorBlackSilver, rendererBlackSilver, 3).modId("sterlingandblack").setType("blackSilver").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("blackSilverBoots");
        silverstuff.add(blackSilverBoots);
       

	} // end doArmor()
	
	public static void doTools() 
	{
        sterlingSteelSword = new SimpleSword(toolSterlingSteel).modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelSword");
        silverstuff.add(sterlingSteelSword);
        sterlingSteelShovel = new SimpleShovel(toolSterlingSteel).modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelShovel");
        silverstuff.add(sterlingSteelShovel);
        sterlingSteelAxe = new SimpleAxe(toolSterlingSteel).modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelAxe");
        silverstuff.add(sterlingSteelAxe);
        sterlingSteelPickaxe = new SimplePickaxe(toolSterlingSteel).modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelPickaxe");
        silverstuff.add(sterlingSteelPickaxe);
        sterlingSteelHoe = new SimpleHoe(toolSterlingSteel).modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelHoe");
        silverstuff.add(sterlingSteelHoe);
        
        blackSilverSword = new SimpleSword(toolBlackSilver).modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("blackSilverSword");
        silverstuff.add(blackSilverSword);
        blackSilverShovel = new SimpleShovel(toolBlackSilver).modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("blackSilverShovel");
        silverstuff.add(blackSilverShovel);
        blackSilverAxe = new SimpleAxe(toolBlackSilver).modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("blackSilverAxe");
        silverstuff.add(blackSilverAxe);
        blackSilverPickaxe = new SimplePickaxe(toolBlackSilver).modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("blackSilverPickaxe");
        silverstuff.add(blackSilverPickaxe);
        blackSilverHoe = new SimpleHoe(toolBlackSilver).modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("blackSilverHoe");
        silverstuff.add(blackSilverHoe);

        //werewolves
        // note: only BlackSilver is effective against werewolves.
        if (Settings.werewolfEffectiveness) 
        {
			// registration should allow blackSilver stuff to work with
			// OnlySilver's werewolf handler, instead of having
			// to load our own.
			OnlySilverRegistry.registerWerewolfDamage(blackSilverSword,
					SterlingAndBlack.<ItemStack, Float> constant(10.0F));
			OnlySilverRegistry.registerWerewolfDamage(blackSilverAxe,
					SterlingAndBlack.<ItemStack, Float> constant(9.0F));
			OnlySilverRegistry.registerWerewolfDamage(blackSilverPickaxe,
					SterlingAndBlack.<ItemStack, Float> constant(8.0F));
			OnlySilverRegistry.registerWerewolfDamage(blackSilverShovel,
					SterlingAndBlack.<ItemStack, Float> constant(7.0F));
			OnlySilverRegistry.registerWerewolfDamage(blackSilverHoe,
					SterlingAndBlack.<ItemStack, Float> constant(6.0F));
       } // end if werewolfEffectiveness

	} // end doTools()
	
	public static void doBlocks() 
	{
        // define blocks
		blockSterlingSteel = new SterlingStorageBlock(Material.iron,
				"sterlingandblack");
		blockBlackSilver = new BlackStorageBlock(Material.iron,
				"sterlingandblack");
        blockSterlingSteel.setHarvestLevel("pickaxe", 0);
        blockBlackSilver.setHarvestLevel("pickaxe", 0);
	} // end doBlocks()
	
	public static void doItems()
	{
        // define items
        sterlingSteelIngot = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelIngot");
        smallSterlingSteelChunkItem = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("smallSterlingSteelChunkItem");
        mediumSterlingSteelChunkItem = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("mediumSterlingSteelChunkItem");
        largeSterlingSteelChunkItem = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("largeSterlingSteelChunkItem");
        
        blackSilverIngot = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("blackSilverIngot");
        smallBlackSilverChunkItem = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("smallBlackSilverChunkItem");
        mediumBlackSilverChunkItem = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("mediumBlackSilverChunkItem");
        largeBlackSilverChunkItem = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling).setUnlocalizedName("largeBlackSilverChunkItem");
        
	} // end doItems()
	
	public static void setLoot() 
	{
        // loot
       LootHelper.addLoot("villageBlacksmith", new ItemStack(sterlingSteelIngot), 1, 2, 2);
       LootHelper.addLoot("villageBlacksmith", new ItemStack(largeSterlingSteelChunkItem), 1, 2, 3);
       LootHelper.addLoot("villageBlacksmith", new ItemStack(sterlingSteelSword), 1, 2, 1);
       LootHelper.addLoot("villageBlacksmith", new ItemStack(sterlingSteelPickaxe), 2, 3, 1);
       LootHelper.addLoot("villageBlacksmith", new ItemStack(sterlingSteelAxe), 1, 1, 1);
       LootHelper.addLoot("villageBlacksmith", new ItemStack(sterlingSteelShovel), 1, 1, 1);
       LootHelper.addLoot("villageBlacksmith", new ItemStack(sterlingSteelHoe), 1, 1, 1);
       LootHelper.addLoot("villageBlacksmith", new ItemStack(largeBlackSilverChunkItem), 1, 2, 2);
       LootHelper.addLoot("villageBlacksmith", new ItemStack(blackSilverIngot), 1, 2, 2);
       LootHelper.addLoot("villageBlacksmith", new ItemStack(blackSilverSword), 1, 1, 1);
       LootHelper.addLoot("villageBlacksmith", new ItemStack(blackSilverPickaxe), 1, 2, 1);
       LootHelper.addLoot("mineshaftCorridor", new ItemStack(sterlingSteelPickaxe), 2, 3, 1);
       LootHelper.addLoot("mineshaftCorridor", new ItemStack(blackSilverPickaxe), 1, 2, 1);
       LootHelper.addLoot("mineshaftCorridor", new ItemStack(sterlingSteelShovel), 2, 3, 1);
       LootHelper.addLoot("mineshaftCorridor", new ItemStack(blackSilverShovel), 1, 2, 1);
       LootHelper.addLoot("dungeonChest", new ItemStack(sterlingSteelIngot), 1, 2, 2);
       LootHelper.addLoot("dungeonChest", new ItemStack(blackSilverIngot), 1, 2, 2);
       LootHelper.addLoot("dungeonChest", new ItemStack(sterlingSteelSword), 1, 1, 1);
       LootHelper.addLoot("dungeonChest", new ItemStack(blackSilverSword), 1, 1, 1);
       LootHelper.addLoot("dungeonChest", new ItemStack(sterlingSteelAxe), 1, 1, 1);
       LootHelper.addLoot("dungeonChest", new ItemStack(blackSilverAxe), 1, 1, 1);
       LootHelper.addLoot("strongholdLibrary", new ItemStack(sterlingSteelIngot), 1, 2, 2);
       LootHelper.addLoot("strongholdLibrary", new ItemStack(sterlingSteelSword), 2, 4, 1);
       LootHelper.addLoot("strongholdLibrary", new ItemStack(blackSilverChest), 1, 4, 1);
       LootHelper.addLoot("strongholdLibrary", new ItemStack(blackSilverHelm), 1, 4, 1);
       LootHelper.addLoot("strongholdLibrary", new ItemStack(blackSilverLegs), 1, 4, 1);
       LootHelper.addLoot("strongholdLibrary", new ItemStack(blackSilverBoots), 1, 4, 1);
       LootHelper.addLoot("pyramidDesertyChest", new ItemStack(sterlingSteelSword), 1, 1, 1);
       LootHelper.addLoot("pyramidJungleChest", new ItemStack(blackSilverSword), 1, 1, 1);

	} // end setLoot()
	
	// Sterling Steel
	public static Item sterlingSteelIngot;
	public static Item smallSterlingSteelChunkItem;
	public static Item mediumSterlingSteelChunkItem;
	public static Item largeSterlingSteelChunkItem;

	public static Item sterlingSteelSword;
	public static Item sterlingSteelShovel;
	public static Item sterlingSteelAxe;
	public static Item sterlingSteelPickaxe;
	public static Item sterlingSteelHoe;

	public static Item sterlingSteelHelm;
	public static Item sterlingSteelChest;
	public static Item sterlingSteelLegs;
	public static Item sterlingSteelBoots;
	
	public static Block blockSterlingSteel;

	// Black Silver
	public static Item blackSilverIngot;
	public static Item smallBlackSilverChunkItem;
	public static Item mediumBlackSilverChunkItem;
	public static Item largeBlackSilverChunkItem;

	public static Item blackSilverSword;
	public static Item blackSilverShovel;
	public static Item blackSilverAxe;
	public static Item blackSilverPickaxe;
	public static Item blackSilverHoe;

	public static Item blackSilverHelm;
	public static Item blackSilverChest;
	public static Item blackSilverLegs;
	public static Item blackSilverBoots;

	public static Block blockBlackSilver;
} // end class Content
