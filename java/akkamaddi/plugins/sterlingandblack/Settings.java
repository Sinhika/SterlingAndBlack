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
			if (enableArmorStatModification) {
				LogHelper.verboseInfo(ModInfo.ID,
						"Armor Stat Modification enabled!");
				customizeArmorStats();
			} // end-if enableArmorStatModification
			else
				armorStatDefaults();

			// Block Stat Modification
			if (enableBlockStatModification) {
				LogHelper.verboseInfo(ModInfo.ID,
						"Block Stat Modification enabled!");
				customizeBlockStats();
			} else
				blockStatDefaults();

			if (enableToolStatModification) {
				LogHelper.verboseInfo(ModInfo.ID,
						"Tool Stat Modification enabled!");
				customizeToolStats();
			} else
				toolStatDefaults();
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
	public static void armorStatDefaults() {}
	
	/**
	 * sets customized armor stats.
	 */
	public static void customizeArmorStats() {}
	
	/**
	 * Sets the default block stats.
	 */
	public static void blockStatDefaults() {}

	/**
	 * sets customized block stats.
	 */
	public static void customizeBlockStats() {}
	
	/**
	 * Sets the default tool stats.
	 */
	public static void toolStatDefaults() {}

	/**
	 * set customized tool stats.
	 */
	public static void customizeToolStats() {}

	// Booleans
    public static boolean MakeMeSparkle;
    public static boolean werewolfEffectiveness;

} // end class Settings
