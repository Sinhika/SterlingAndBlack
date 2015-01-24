package akkamaddi.plugins.sterlingandblack;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import alexndr.api.content.inventory.SimpleTab;
import alexndr.api.core.LogHelper;

import com.google.common.base.Function;
import com.google.common.base.Functions;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid =  ModInfo.ID, name = ModInfo.NAME, version =  ModInfo.VERSION, 
	dependencies = "required-after:simplecore; required-after:simpleores ; required-after:fusion ; required-after:akkamaddicore; required-after:onlysilver; after:MoCreatures")

public class SterlingAndBlack
{
//    // The instance of your mod that Forge uses.
//    @Instance("sterlingandblack")
//    public static SterlingAndBlack instance;

//    // Says where the client and server 'proxy' code is loaded.
//    @SidedProxy(clientSide = "akkamaddi.SterlingAndBlack.code.ClientProxy", 
//    			serverSide = "akkamaddi.akkamaddiCore.code.CommonProxy")
//    public static CommonProxy proxy;

    // tab
    public static SimpleTab tabAkkamaddiSterling;

    /**
     * ArmorMaterial. In form ("NAME", max damage (like uses, multiply by pieces for their max damage), new int[] {helmet defense, chestplate defense, leggings defense, boots defense}, enchantability)
     */
    public static ArmorMaterial armorSterlingSteel, armorBlackSilver;

     // set tool properties
    // ToolMaterial. In form ("NAME", mining level, max uses, speed, damage to entity, enchantability)
	public static ToolMaterial toolSterlingSteel, toolBlackSilver;
   
    /**
     * Run before anything else. Read your config, create blocks, items, etc, and 
     * register them with the GameRegistry. Register recipes.
     */
    @EventHandler 
    public void preInit(FMLPreInitializationEvent event)
    {       
		// Tab
		LogHelper.info("Loading SimpleTungsten...");
		tabAkkamaddiSterling = new SimpleTab("tabAkkamaddiSterling","general");
		
		//Configuration
		Settings.createOrLoadSettings(event);
		
		//Content
		setToolAndArmorStats();
		Content.preInitialize();
		Recipes.preInitialize();
		Content.setLoot();
		
     } // end preInit

    /**
     * Do your mod setup. Build whatever data structures you care about. 
     */
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
		// run tab icon call
		setTabIcons();
		setRepairMaterials();
		Recipes.initialize();
    } // end load()

    /**
     * Handle interaction with other mods, complete your setup based on this.
     */
    @EventHandler 
    public void postInit(FMLPostInitializationEvent event)
    {
		LogHelper.info("Sterling & Black loaded");
    }
    
    // cut & pasted from OnlySilver's source code...
	@SuppressWarnings("unchecked")
	public static <F, T> Function<F, T> constant(T value) {
		return (Function<F, T>) Functions.constant(value);
	}

	/**
	 * Sets the tool and armor stats from the Settings file.
	 */
	private static void setToolAndArmorStats() 
	{
		/**
		 * ToolMaterial
		 */
//		public static ToolMaterial toolSterlingSteel = EnumHelper.addToolMaterial(
//		"STERLINGSTEEL", 3, 660, 10.0F, 2, 26);
//public static ToolMaterial toolBlackSilver = EnumHelper.addToolMaterial(
//		"BLACKSILVER", 5, 3460, 16.0F, 6, 22);

	/**
		 * ArmorMaterial. In form ("NAME", max damage (like uses, multiply by
		 * pieces for their max damage), new int[] {helmet defense, chestplate
		 * defense, leggings defense, boots defense}, enchantability)
		 */
//		public static ArmorMaterial armorSterlingSteel = EnumHelper
//		.addArmorMaterial("STERLINGSTEEL", 18, new int[] { 3, 6, 5, 3 }, 28);
//public static ArmorMaterial armorBlackSilver = EnumHelper.addArmorMaterial(
//		"BLACKSILVER", 48, new int[] { 5, 9, 7, 5 }, 24);
	} // end setToolAndArmorStats()
	
	/**
	 * Sets repair materials for the tools/armor of that type. ie. Copper Ingot to repair copper tools and armor.
	 */
	private static void setRepairMaterials()
	{
		// Tools
		toolSterlingSteel.customCraftingMaterial = Content.sterlingSteelIngot;
		toolBlackSilver.customCraftingMaterial = Content.blackSilverIngot;

		// Armor
		armorSterlingSteel.customCraftingMaterial = Content.sterlingSteelIngot;
		armorBlackSilver.customCraftingMaterial = Content.blackSilverIngot;
	} // end setRepairMaterials()

    /**
     * Creating the custom tabs using the API class "SimpleTab" and setting their icon.
     */
    private void setTabIcons()
    {
        tabAkkamaddiSterling.setIcon(new ItemStack(Content.blockSterlingSteel));
    }


} // end class SterlingAndBlackCore
