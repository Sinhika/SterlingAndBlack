package akkamaddi.plugins.sterlingandblack;

import java.util.LinkedList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicates;

import akkamaddi.api.core.LootHelper;
import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.content.items.SimpleAxe;
import alexndr.api.content.items.SimpleHoe;
import alexndr.api.content.items.SimpleItem;
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
		sterlingSteelHelm = new SterlingSteelArmor(
				SterlingAndBlack.armorSterlingSteel, 0)
				.modId(ModInfo.ID).setType("sterlingSteel")
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("sterlingSteelHelm");
		silverstuff.add(sterlingSteelHelm);
		sterlingSteelChest = new SterlingSteelArmor(
				SterlingAndBlack.armorSterlingSteel, 1)
				.modId(ModInfo.ID).setType("sterlingSteel")
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("sterlingSteelChest");
		silverstuff.add(sterlingSteelChest);
		sterlingSteelLegs = new SterlingSteelArmor(
				SterlingAndBlack.armorSterlingSteel, 2)
				.modId(ModInfo.ID).setType("sterlingSteel")
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("sterlingSteelLegs");
		silverstuff.add(sterlingSteelLegs);
		sterlingSteelBoots = new SterlingSteelArmor(
				SterlingAndBlack.armorSterlingSteel, 3)
				.modId(ModInfo.ID).setType("sterlingSteel")
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("sterlingSteelBoots");
		silverstuff.add(sterlingSteelBoots);
        
        // subclass armor
		blackSilverHelm = new BlackSilverArmor(
				SterlingAndBlack.armorBlackSilver, 0).modId(ModInfo.ID)
				.setType("blackSilver")
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("blackSilverHelm");
		silverstuff.add(blackSilverHelm);
		blackSilverChest = new BlackSilverArmor(
				SterlingAndBlack.armorBlackSilver, 1).modId(ModInfo.ID)
				.setType("blackSilver")
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("blackSilverChest");
		silverstuff.add(blackSilverChest);
		blackSilverLegs = new BlackSilverArmor(
				SterlingAndBlack.armorBlackSilver, 2).modId(ModInfo.ID)
				.setType("blackSilver")
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("blackSilverLegs");
		silverstuff.add(blackSilverLegs);
		blackSilverBoots = new BlackSilverArmor(
				SterlingAndBlack.armorBlackSilver, 3).modId(ModInfo.ID)
				.setType("blackSilver")
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("blackSilverBoots");
		silverstuff.add(blackSilverBoots);       

	} // end doArmor()
	
	public static void doTools() 
	{
		sterlingSteelSword = new SimpleSword(SterlingAndBlack.toolSterlingSteel)
				.modId(ModInfo.ID)
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("sterlingSteelSword");
		silverstuff.add(sterlingSteelSword);
		sterlingSteelShovel = new SimpleShovel(
				SterlingAndBlack.toolSterlingSteel).modId(ModInfo.ID)
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("sterlingSteelShovel");
		silverstuff.add(sterlingSteelShovel);
		sterlingSteelAxe = new SimpleAxe(SterlingAndBlack.toolSterlingSteel)
				.modId(ModInfo.ID)
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("sterlingSteelAxe");
		silverstuff.add(sterlingSteelAxe);
		sterlingSteelPickaxe = new SimplePickaxe(
				SterlingAndBlack.toolSterlingSteel).modId(ModInfo.ID)
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("sterlingSteelPickaxe");
		silverstuff.add(sterlingSteelPickaxe);
		sterlingSteelHoe = new SimpleHoe(SterlingAndBlack.toolSterlingSteel)
				.modId(ModInfo.ID)
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("sterlingSteelHoe");
		silverstuff.add(sterlingSteelHoe);

		blackSilverSword = new SimpleSword(SterlingAndBlack.toolBlackSilver)
				.modId(ModInfo.ID)
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("blackSilverSword");
		silverstuff.add(blackSilverSword);
		blackSilverShovel = new SimpleShovel(SterlingAndBlack.toolBlackSilver)
				.modId(ModInfo.ID)
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("blackSilverShovel");
		silverstuff.add(blackSilverShovel);
		blackSilverAxe = new SimpleAxe(SterlingAndBlack.toolBlackSilver)
				.modId(ModInfo.ID)
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("blackSilverAxe");
		silverstuff.add(blackSilverAxe);
		blackSilverPickaxe = new SimplePickaxe(SterlingAndBlack.toolBlackSilver)
				.modId(ModInfo.ID)
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("blackSilverPickaxe");
		silverstuff.add(blackSilverPickaxe);
		blackSilverHoe = new SimpleHoe(SterlingAndBlack.toolBlackSilver)
				.modId(ModInfo.ID)
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("blackSilverHoe");
		silverstuff.add(blackSilverHoe);

        //werewolves
        // note: only BlackSilver is effective against werewolves.
        if (Settings.werewolfEffectiveness) 
        {
			// registration should allow blackSilver stuff to work with
			// OnlySilver's werewolf handler, instead of having
			// to load our own.
			OnlySilverRegistry.registerWerewolfDamage(blackSilverSword,
					Content.<ItemStack, Float> constant(Settings.blackSilverDamageVsEntity+4.0F));
			OnlySilverRegistry.registerWerewolfDamage(blackSilverAxe,
					Content.<ItemStack, Float> constant(Settings.blackSilverDamageVsEntity+3.0F));
			OnlySilverRegistry.registerWerewolfDamage(blackSilverPickaxe,
					Content.<ItemStack, Float> constant(Settings.blackSilverDamageVsEntity+2.0F));
			OnlySilverRegistry.registerWerewolfDamage(blackSilverShovel,
					Content.<ItemStack, Float> constant(Settings.blackSilverDamageVsEntity+1.0F));
			OnlySilverRegistry.registerWerewolfDamage(blackSilverHoe,
					Content.<ItemStack, Float> constant(Settings.blackSilverDamageVsEntity));
       } // end if werewolfEffectiveness

	} // end doTools()
	
	public static void doBlocks() 
	{
        // define blocks
		blockSterlingSteel = new SterlingStorageBlock(Material.iron, ModInfo.ID);
		blockBlackSilver =  ((SimpleBlock) new SimpleBlock(Material.iron).modId(ModInfo.ID)
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setHardness(Settings.blackSilverHardness)
				.setResistance(Settings.blackSilverResistance)
				.setStepSound(Block.soundTypeMetal)).setBeaconBase(true)
				.setBlockName("blockBlackSilver");
		
        blockSterlingSteel.setHarvestLevel("pickaxe", Settings.sterlingSteelHarvestLevel);
        blockBlackSilver.setHarvestLevel("pickaxe", Settings.blackSilverHarvestLevel);
	} // end doBlocks()
	
	public static void doItems()
	{
        // define items
		sterlingSteelIngot = new SimpleItem().modId(ModInfo.ID).isIngot()
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("sterlingSteelIngot");
		smallSterlingSteelChunkItem = new SimpleItem()
				.modId(ModInfo.ID).isIngot()
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("smallSterlingSteelChunkItem");
		mediumSterlingSteelChunkItem = new SimpleItem()
				.modId(ModInfo.ID).isIngot()
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("mediumSterlingSteelChunkItem");
		largeSterlingSteelChunkItem = new SimpleItem()
				.modId(ModInfo.ID).isIngot()
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("largeSterlingSteelChunkItem");

		blackSilverIngot = new SimpleItem().modId(ModInfo.ID).isIngot()
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("blackSilverIngot");
		smallBlackSilverChunkItem = new SimpleItem().modId(ModInfo.ID).isIngot()
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("smallBlackSilverChunkItem");
		mediumBlackSilverChunkItem = new SimpleItem().modId(ModInfo.ID).isIngot()
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("mediumBlackSilverChunkItem");
		largeBlackSilverChunkItem = new SimpleItem().modId(ModInfo.ID).isIngot()
				.setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling)
				.setUnlocalizedName("largeBlackSilverChunkItem");
        
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

	// cut & pasted from OnlySilver's source code...
	@SuppressWarnings("unchecked")
	private static <F, T> Function<F, T> constant(T value) {
		return (Function<F, T>) Functions.constant(value);
	}
} // end class Content
