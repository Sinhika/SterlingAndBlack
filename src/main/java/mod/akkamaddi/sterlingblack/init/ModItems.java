package mod.akkamaddi.sterlingblack.init;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import mod.akkamaddi.sterlingblack.content.BlackSilverArmorItem;
import mod.akkamaddi.sterlingblack.content.SterlingBlackArmorMaterial;
import mod.akkamaddi.sterlingblack.content.SterlingBlackItemTier;
import mod.akkamaddi.sterlingblack.content.SterlingSteelArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holds a list of all our {@link Item}s.
 * Suppliers that create Items are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Item Registry Event is fired by Forge and it is time for the mod to
 * register its Items, our Items are created and registered by the DeferredRegister.
 * The Item Registry Event will always be called after the Block registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo.
 */
public final class ModItems 
{
    public static final DeferredRegister<Item> ITEMS = 
            DeferredRegister.create(ForgeRegistries.ITEMS, SterlingAndBlack.MODID);

    // ingots and nuggets
    public static final RegistryObject<Item> sterling_steel_ingot = ITEMS.register("sterling_steel_ingot", 
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> sterling_steel_nugget = ITEMS.register("sterling_steel_nugget",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> medium_sterling_steel_chunk = ITEMS.register("medium_sterling_steel_chunk", 
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> large_sterling_steel_chunk = ITEMS.register("large_sterling_steel_chunk",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
   
    public static final RegistryObject<Item> black_silver_ingot = ITEMS.register("black_silver_ingot",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> black_silver_nugget = ITEMS.register("black_silver_nugget",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> medium_black_silver_chunk = ITEMS.register("medium_black_silver_chunk",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> large_black_silver_chunk = ITEMS.register("large_black_silver_chunk",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // parts

   
    // TOOLS & WEAPONS
    // bows

    // swords
    public static final RegistryObject<SwordItem> sterling_steel_sword = ITEMS.register("sterling_steel_sword",
            () -> new SwordItem(SterlingBlackItemTier.STERLING_STEEL, 3, -2.4F,
                                new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SwordItem> black_silver_sword = ITEMS.register("black_silver_sword",
            () -> new SwordItem(SterlingBlackItemTier.BLACK_SILVER, 3, -2.4F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // pickaxes
    public static final RegistryObject<PickaxeItem> sterling_steel_pickaxe = ITEMS.register("sterling_steel_pickaxe",
            () -> new PickaxeItem(SterlingBlackItemTier.STERLING_STEEL, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> black_silver_pickaxe = ITEMS.register("black_silver_pickaxe",
            () -> new PickaxeItem(SterlingBlackItemTier.BLACK_SILVER, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // axes
    public static final RegistryObject<AxeItem> sterling_steel_axe = ITEMS.register("sterling_steel_axe",
            () -> new AxeItem(SterlingBlackItemTier.STERLING_STEEL, 7.0F, -3.1F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> black_silver_axe = ITEMS.register("black_silver_axe",
            () -> new AxeItem(SterlingBlackItemTier.BLACK_SILVER, 6.0F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // shovels
    public static final RegistryObject<ShovelItem> sterling_steel_shovel = ITEMS.register("sterling_steel_shovel",
            () -> new ShovelItem(SterlingBlackItemTier.STERLING_STEEL, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> black_silver_shovel = ITEMS.register("black_silver_shovel",
            () -> new ShovelItem(SterlingBlackItemTier.BLACK_SILVER, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // hoes
    public static final RegistryObject<HoeItem> sterling_steel_hoe = ITEMS.register("sterling_steel_hoe",
            () -> new HoeItem(SterlingBlackItemTier.STERLING_STEEL, -2, -2.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> black_silver_hoe = ITEMS.register("black_silver_hoe",
            () -> new HoeItem(SterlingBlackItemTier.BLACK_SILVER, -5, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // ARMOR
    // sterling_steel
    public static final RegistryObject<SterlingSteelArmorItem> sterling_steel_helmet = ITEMS.register("sterling_steel_helmet",
            () -> new SterlingSteelArmorItem(SterlingBlackArmorMaterial.STERLING_STEEL, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SterlingSteelArmorItem> sterling_steel_leggings = ITEMS.register("sterling_steel_leggings",
            () -> new SterlingSteelArmorItem(SterlingBlackArmorMaterial.STERLING_STEEL, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SterlingSteelArmorItem> sterling_steel_chestplate = ITEMS.register("sterling_steel_chestplate",
            () -> new SterlingSteelArmorItem(SterlingBlackArmorMaterial.STERLING_STEEL, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SterlingSteelArmorItem> sterling_steel_boots = ITEMS.register("sterling_steel_boots",
            () -> new SterlingSteelArmorItem(SterlingBlackArmorMaterial.STERLING_STEEL, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // black_silver
    public static final RegistryObject<BlackSilverArmorItem> black_silver_helmet = ITEMS.register("black_silver_helmet",
            () -> new BlackSilverArmorItem(SterlingBlackArmorMaterial.BLACK_SILVER, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<BlackSilverArmorItem> black_silver_leggings = ITEMS.register("black_silver_leggings",
            () -> new BlackSilverArmorItem(SterlingBlackArmorMaterial.BLACK_SILVER, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<BlackSilverArmorItem> black_silver_chestplate = ITEMS.register("black_silver_chestplate",
            () -> new BlackSilverArmorItem(SterlingBlackArmorMaterial.BLACK_SILVER, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<BlackSilverArmorItem> black_silver_boots = ITEMS.register("black_silver_boots",
            () -> new BlackSilverArmorItem(SterlingBlackArmorMaterial.BLACK_SILVER, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

} // end class
