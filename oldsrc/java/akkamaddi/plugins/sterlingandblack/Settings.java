package akkamaddi.plugins.sterlingandblack;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import akkamaddi.api.core.ASettings;
import alexndr.api.core.LogHelper;

public class Settings extends ASettings 
{
	/** 
	 * umbrella config loading routine. must be instantiated by child classes.
	 * @param event
	 */
	public static void createOrLoadSettings(FMLPreInitializationEvent event) 
	{
		config = GetConfig(event, "akkamaddi", "sterlingandblack.cfg");
		
		try {
			LogHelper.verboseInfo(ModInfo.ID, "Loading Settings...");
			config.load();
			genericSettings(ModInfo.ID, ModInfo.NAME);
			
			// additional general settings
			MakeMeSparkle = config.getBoolean("Make Me Sparkle",
					Configuration.CATEGORY_GENERAL, false,
					"Make Sterling Steel blocks sparkle, true or false?");
			
			werewolfEffectiveness = config
					.getBoolean("Works on MoCreatures lycanthropes",
							Configuration.CATEGORY_GENERAL, true,
					 	"Black Silver affects Mo'Creatures lycanthropes like silver, true or false");
	       
			// Armor Stat Modification
			armorStatDefaults();
			if (enableArmorStatModification) 
			{
				LogHelper.verboseInfo(ModInfo.ID,
						"Armor Stat Modification enabled!");
				customizeArmorStats();
			} // end-if enableArmorStatModification

			// Block Stat Modification
			blockStatDefaults();
			if (enableBlockStatModification) {
				LogHelper.verboseInfo(ModInfo.ID,
						"Block Stat Modification enabled!");
				customizeBlockStats();
			} 
			
			toolStatDefaults();
			if (enableToolStatModification) {
				LogHelper.verboseInfo(ModInfo.ID,
						"Tool Stat Modification enabled!");
				customizeToolStats();
			} 
		} // end-try
		catch (Exception e) {
			LogHelper
					.severe(ModInfo.ID,
							"Settings failed to load correctly. The plugin may not function correctly");
		}

		finally {
			config.save();
			LogHelper.verboseInfo(ModInfo.ID, "Settings loaded successfully");
		}
		
	} // end createOrLoadSettings()
	
	/**
	 * Sets the default armor stats.
	 */
	public static void armorStatDefaults() 
	{
		sterlingSteelArmorDurability = 18;
		blackSilverArmorDurability = 48;
		sterlingSteelArmorDamageReduction = new int [] { 3, 6, 5, 3 };
		blackSilverArmorDamageReduction = new int []  { 5, 9, 7, 5 };
		sterlingSteelArmorEnchantability = 28;
		blackSilverArmorEnchantability = 11;
	}
	
	/**
	 * sets customized armor stats.
	 */
	public static void customizeArmorStats() 
	{
		sterlingSteelArmorDurability = config.getInt("Sterling Steel Armor Durability",
				"Armor Stat Modification", sterlingSteelArmorDurability, 0, 255,
				"Controls the durability of Sterling Steel Armor.");
		sterlingSteelArmorDamageReduction = config.get("Armor Stat Modification",
				"Sterling Steel Armor Damage Reduction Array",
				sterlingSteelArmorDamageReduction).getIntList();
		sterlingSteelArmorEnchantability = config.getInt(
				"Sterling Steel Armor Enchantability", "Armor Stat Modification", 
				sterlingSteelArmorEnchantability,
				0, 255, "Controls the enchantability of Sterling Steel Armor.");
		
		blackSilverArmorDurability = config.getInt("Black Silver Armor Durability",
				"Armor Stat Modification", blackSilverArmorDurability, 0, 255,
				"Controls the durability of Black Silver Armor.");
		blackSilverArmorDamageReduction = config.get("Armor Stat Modification",
				"Black Silver Armor Damage Reduction Array",
				blackSilverArmorDamageReduction).getIntList();
		blackSilverArmorEnchantability = config.getInt(
				"Black Silver Armor Enchantability", "Armor Stat Modification", 
				blackSilverArmorEnchantability,
				0, 255, "Controls the enchantability of Black Silver Armor.");
	} // end customizeArmorStats()
	
	/**
	 * Sets the default block stats.
	 */
	public static void blockStatDefaults() 
	{
		 sterlingSteelHardness = 7.0F;
		 blackSilverHardness = 12.0F;
		 sterlingSteelResistance = 12.0F;
		 blackSilverResistance = 26.0F;
		 sterlingSteelHarvestLevel = 0;
		 blackSilverHarvestLevel = 0;
		 sterlingSteelLightLevel = 0.8F;
	}
	

	/**
	 * sets customized block stats.
	 */
	public static void customizeBlockStats() 
	{
		sterlingSteelHardness = config.getFloat("Sterling Steel Hardness",
				"Block Stat Modification", sterlingSteelHardness, 0.0F, 32000.0F,
				"How many hits to break a block");
		sterlingSteelResistance = config.getFloat("Sterling Steel Resistance",
				"Block Stat Modification", sterlingSteelResistance, 0.0F, 32000.0F,
				"Explosion Resistance");
		sterlingSteelHarvestLevel = config.getInt("Sterling Steel Harvest Level",
				"Block Stat Modification", sterlingSteelHarvestLevel, 0, 255,
				"Tool level required to harvest this block");
		sterlingSteelLightLevel = config.getFloat("Sterling Steel Light Level",
				"Block Stat Modification", sterlingSteelLightLevel, 0.0F, 32.0F,
				"Light Level emitted by Sterling Steel Blocks");
		
		blackSilverHardness = config.getFloat("Black Silver Hardness",
				"Block Stat Modification", blackSilverHardness, 0.0F, 32000.0F,
				"How many hits to break a block");
		blackSilverResistance = config.getFloat("Black Silver Resistance",
				"Block Stat Modification", blackSilverResistance, 0.0F, 32000.0F,
				"Explosion Resistance");
		blackSilverHarvestLevel = config.getInt("Black Silver Harvest Level",
				"Block Stat Modification", blackSilverHarvestLevel, 0, 255,
				"Tool level required to harvest this block");
	} // end customizeBlockStats()
	
	/**
	 * Sets the default tool stats.
	 */
	public static void toolStatDefaults() 
	{
		 sterlingSteelMiningLevel = 3;
		 blackSilverMiningLevel = 5;
		 sterlingSteelUsesNum = 660;
		 blackSilverUsesNum = 3460;
		 sterlingSteelMiningSpeed = 10.0F;
		 blackSilverMiningSpeed = 16.0F;
		 sterlingSteelDamageVsEntity =  2.0F;
		 blackSilverDamageVsEntity = 6.0F;
		 sterlingSteelEnchantability = 26;
		 blackSilverEnchantability = 22;
	} // end toolStatDefaults()

	/**
	 * set customized tool stats.
	 */
	public static void customizeToolStats() 
	{
		sterlingSteelMiningLevel = config
				.getInt("Sterling Steel Mining Level", "Tool Stat Modification",
						sterlingSteelMiningLevel, 0, 255,
						"Controls the mining level of Sterling Steel Tools. 0 = wood, 1 = stone, 2 = iron, 3 = diamond.");
		sterlingSteelUsesNum = config.getInt("Sterling Steel Tools Durability",
				"Tool Stat Modification", sterlingSteelUsesNum, 0, 32000,
				"Controls the number of uses Sterling Steel Tools have.");
		sterlingSteelMiningSpeed = config
				.getFloat("Sterling Steel Mining Speed", "Tool Stat Modification",
						sterlingSteelMiningSpeed, 0, 32000,
						"Controls the speed at which Sterling Steel Tools harvest their appropriate blocks.");
		sterlingSteelDamageVsEntity = config
				.getFloat("Sterling Steel Damage Vs. Entities",
						"Tool Stat Modification", sterlingSteelDamageVsEntity,
						0, 32000,
						"Controls the amount of damage that Sterling Steel Tools will do to entities.");
		sterlingSteelEnchantability = config.getInt(
				"Sterling Steel Tools Enchantability", "Tool Stat Modification",
				sterlingSteelEnchantability, 0, 32000,
				"Controls the enchantability of Sterling Steel Tools.");
		
		blackSilverMiningLevel = config
				.getInt("Black Silver Mining Level", "Tool Stat Modification",
						blackSilverMiningLevel, 0,	255,
						"Controls the mining level of Black Silver Tools. 0 = wood, 1 = stone, 2 = iron, 3 = diamond.");
		blackSilverUsesNum = config.getInt("Black Silver Tools Durability",
				"Tool Stat Modification", blackSilverUsesNum, 0, 32000,
				"Controls the number of uses Black Silver Tools have.");
		blackSilverMiningSpeed = config
				.getFloat("Black Silver Mining Speed", "Tool Stat Modification",
						blackSilverMiningSpeed, 0, 32000,
						"Controls the speed at which Black Silver Tools harvest their appropriate blocks.");
		blackSilverDamageVsEntity = config
				.getFloat("Black Silver Damage Vs. Entities",
						"Tool Stat Modification", blackSilverDamageVsEntity,
						0, 32000,
						"Controls the amount of damage that Black Silver Tools will do to entities.");
		blackSilverEnchantability = config.getInt(
				"Black Silver Tools Enchantability", "Tool Stat Modification",
				blackSilverEnchantability, 0, 32000,
				"Controls the enchantability of Black Silver Tools.");
		
	} // end customizeToolStats()

	// Booleans
    public static boolean MakeMeSparkle;
    public static boolean werewolfEffectiveness;

	// Tool Stats
	public static int sterlingSteelMiningLevel, blackSilverMiningLevel;
	public static int sterlingSteelUsesNum, blackSilverUsesNum;
	public static float sterlingSteelMiningSpeed, blackSilverMiningSpeed;
	public static float sterlingSteelDamageVsEntity,blackSilverDamageVsEntity;
	public static int sterlingSteelEnchantability, blackSilverEnchantability;

	// Armor Stats
	public static int sterlingSteelArmorDurability, blackSilverArmorDurability;
	public static int[] sterlingSteelArmorDamageReduction, blackSilverArmorDamageReduction;
	public static int sterlingSteelArmorEnchantability, blackSilverArmorEnchantability;

	// Block stats
	public static float sterlingSteelHardness,blackSilverHardness;
	public static float sterlingSteelResistance, blackSilverResistance;
	public static int sterlingSteelHarvestLevel, blackSilverHarvestLevel;
	public static float sterlingSteelLightLevel;
	
} // end class Settings
