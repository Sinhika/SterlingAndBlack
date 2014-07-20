package akkamaddi.SterlingAndBlack.code;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import alexndr.SimpleOres.api.content.SimpleAxe;
import alexndr.SimpleOres.api.content.SimpleHoe;
import alexndr.SimpleOres.api.content.SimpleIngot;
import alexndr.SimpleOres.api.content.SimplePickaxe;
import alexndr.SimpleOres.api.content.SimpleShovel;
import alexndr.SimpleOres.api.content.SimpleSword;
import alexndr.SimpleOres.api.content.SimpleTab;
import alexndr.SimpleOres.api.helpers.LootHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "sterlingandblack", name = "Sterling & Black", version = "1.7.2-1.4.0", 
	dependencies = "required-after:simpleores ; required-after:fusionplugin ; required-after:onlysilver")

public class SterlingAndBlackCore
{
    // The instance of your mod that Forge uses.
    @Instance("sterlingandblack")
    public static SterlingAndBlackCore instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "akkamaddi.SterlingAndBlack.code.ClientProxy", serverSide = "akkamaddi.SterlingAndBlack.code.CommonProxy")
    public static CommonProxy proxy;

    // set actual item names
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

    // set block names
    public static Block blockSterlingSteel;
    public static Block blockBlackSilver;

    public static boolean MakeMeSparkle;

    public static boolean werewolfEffectiveness;

    public static boolean enableRecycling;

    // tab
    public static SimpleTab tabAkkamaddiSterling = new SimpleTab("tabAkkamaddiSterling");

    /**
     * ArmorMaterial. In form ("NAME", max damage (like uses, multiply by pieces for their max damage), new int[] {helmet defense, chestplate defense, leggings defense, boots defense}, enchantability)
     */
    public static ArmorMaterial armorSterlingSteel = EnumHelper.addArmorMaterial("STERLINGSTEEL", 18, new int[] {3, 6, 5, 3}, 28);
    public static ArmorMaterial armorBlackSilver = EnumHelper.addArmorMaterial("BLACKSILVER", 48, new int[] {5, 9, 7, 5}, 24);

    /**
     * Creating the Armor Renderers. This is simply so you can see the armor texture when you wear it.
     */
    public static int rendererSterlingSteel;
    public static int rendererBlackSilver;

    // set tool properties
    // ToolMaterial. In form ("NAME", mining level, max uses, speed, damage to entity, enchantability)
    public static ToolMaterial toolSterlingSteel = EnumHelper.addToolMaterial("STERLINGSTEEL", 3, 660, 10.0F, 2, 26);
    public static ToolMaterial toolBlackSilver = EnumHelper.addToolMaterial("BLACKSILVER", 5, 3460, 16.0F, 6, 22);

    // Tab
    public void setTabIcons()
    {
        /**
         * Creating the custom tabs using the API class "SimpleTab" and setting their icon.
         */
        tabAkkamaddiSterling.setIcon(new ItemStack(SterlingAndBlackCore.blockSterlingSteel));
    }

    /**
     * Run before anything else. Read your config, create blocks, items, etc, and 
     * register them with the GameRegistry. Register recipes.
     */
    @EventHandler 
    public void preInit(FMLPreInitializationEvent event)
    {       
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        MakeMeSparkle = config.get(Configuration.CATEGORY_GENERAL, "Make Me Sparkle, false or true", false).getBoolean(false);
        werewolfEffectiveness = config.get(Configuration.CATEGORY_GENERAL, "Works on Mo'Creatures lycanthropes, true or false", true).getBoolean(true);
        enableRecycling = config.get(Configuration.CATEGORY_GENERAL, "Enable Sterling & Black item recycling recipes: false or true?", false).getBoolean(false);
        config.save();
        
        // define items
        sterlingSteelIngot = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelIngot");
        smallSterlingSteelChunkItem = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("smallSterlingSteelChunkItem");
        mediumSterlingSteelChunkItem = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("mediumSterlingSteelChunkItem");
        largeSterlingSteelChunkItem = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("largeSterlingSteelChunkItem");
        sterlingSteelSword = new SimpleSword(toolSterlingSteel).modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelSword");
        sterlingSteelShovel = new SimpleShovel(toolSterlingSteel).modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelShovel");
        sterlingSteelAxe = new SimpleAxe(toolSterlingSteel).modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelAxe");
        sterlingSteelPickaxe = new SimplePickaxe(toolSterlingSteel).modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelPickaxe");
        sterlingSteelHoe = new SimpleHoe(toolSterlingSteel).modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelHoe");

        // subclass armor
        sterlingSteelHelm = new SimpleArmorWithEffect(armorSterlingSteel, rendererSterlingSteel, 0).modId("sterlingandblack").setType("sterlingSteel").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelHelm");
        sterlingSteelChest = new SimpleArmorWithEffect(armorSterlingSteel, rendererSterlingSteel, 1).modId("sterlingandblack").setType("sterlingSteel").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelChest");
        sterlingSteelLegs = new SimpleArmorWithEffect(armorSterlingSteel, rendererSterlingSteel, 2).modId("sterlingandblack").setType("sterlingSteel").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelLegs");
        sterlingSteelBoots = new SimpleArmorWithEffect( armorSterlingSteel, rendererSterlingSteel, 3).modId("sterlingandblack").setType("sterlingSteel").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("sterlingSteelBoots");
       
        blackSilverIngot = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("blackSilverIngot");
        smallBlackSilverChunkItem = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("smallBlackSilverChunkItem");
        mediumBlackSilverChunkItem = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("mediumBlackSilverChunkItem");
        largeBlackSilverChunkItem = new SimpleIngot().modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("largeBlackSilverChunkItem");
        blackSilverSword = new SimpleSword(toolBlackSilver).modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("blackSilverSword");
        blackSilverShovel = new SimpleShovel(toolBlackSilver).modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("blackSilverShovel");
        blackSilverAxe = new SimpleAxe(toolBlackSilver).modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("blackSilverAxe");
        blackSilverPickaxe = new SimplePickaxe(toolBlackSilver).modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("blackSilverPickaxe");
        blackSilverHoe = new SimpleHoe(toolBlackSilver).modId("sterlingandblack").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("blackSilverHoe");
        
       // subclass armor
        blackSilverHelm = new SimpleArmorWithEffect(armorBlackSilver, rendererBlackSilver, 0).modId("sterlingandblack").setType("blackSilver").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("blackSilverHelm");
        blackSilverChest = new SimpleArmorWithEffect(armorBlackSilver, rendererBlackSilver, 1).modId("sterlingandblack").setType("blackSilver").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("blackSilverChest");
        blackSilverLegs = new SimpleArmorWithEffect(armorBlackSilver, rendererBlackSilver, 2).modId("sterlingandblack").setType("blackSilver").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("blackSilverLegs");
        blackSilverBoots = new SimpleArmorWithEffect(armorBlackSilver, rendererBlackSilver, 3).modId("sterlingandblack").setType("blackSilver").setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling).setUnlocalizedName("blackSilverBoots");
       
        toolSterlingSteel.customCraftingMaterial = SterlingAndBlackCore.sterlingSteelIngot;
        toolBlackSilver.customCraftingMaterial = SterlingAndBlackCore.blackSilverIngot;
        armorSterlingSteel.customCraftingMaterial = SterlingAndBlackCore.sterlingSteelIngot;
        armorBlackSilver.customCraftingMaterial = SterlingAndBlackCore.blackSilverIngot;

         // define blocks
        blockSterlingSteel = new SterlingStorageBlock(Material.iron, "sterlingandblack");
        blockBlackSilver = new BlackStorageBlock(Material.iron, "sterlingandblack");
        
        blockSterlingSteel.setHarvestLevel("pickaxe", 0);
        blockBlackSilver.setHarvestLevel("pickaxe", 0);

        // Registry
        GameRegistry.registerBlock(blockSterlingSteel, "blockSterlingSteel");
        GameRegistry.registerBlock(blockBlackSilver, "blockBlackSilver");
       
        //recipes
        SterlingRecipes.doSterlingRecipes();
        
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

        //werewolves
        if (SterlingAndBlackCore.werewolfEffectiveness)
            try
            {
                MinecraftForge.EVENT_BUS.register(new WerewolfHandler());
            }
            catch (ClassNotFoundException ignored) {}

    } // end preInit

    /**
     * Do your mod setup. Build whatever data structures you care about. 
     */
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        proxy.registerRenderers();
        MinecraftForge.EVENT_BUS.register(new HandlerJoinWorld());
        
        // run tab icon call
        setTabIcons();
       
        //Armor Renderers
        rendererSterlingSteel = proxy.addArmor("sterlingSteel");
        rendererBlackSilver = proxy.addArmor("blackSilver");
                
    } // end load()

    /**
     * Handle interaction with other mods, complete your setup based on this.
     */
    @EventHandler 
    public void postInit(FMLPostInitializationEvent event)
    {
        // Stub Method
    }
} // end class SterlingAndBlackCore
