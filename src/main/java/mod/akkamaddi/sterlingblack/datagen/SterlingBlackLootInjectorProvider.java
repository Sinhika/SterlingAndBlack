package mod.akkamaddi.sterlingblack.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import mod.akkamaddi.sterlingblack.init.ModItems;
import mod.alexndr.simplecorelib.datagen.LootTableInjectorProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;

public class SterlingBlackLootInjectorProvider extends LootTableInjectorProvider
{

    public SterlingBlackLootInjectorProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables()
    {
        tables.clear();
        
        // simple_dungeon
        LootPool.Builder foo = createChestPool(1, 1, 0.50F)
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_ingot.get()).setWeight(3)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.large_sterling_steel_chunk.get()).setWeight(3)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 3))))
                .add(ItemLootEntry.lootTableItem(ModItems.black_silver_ingot.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.large_black_silver_chunk.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 3))));
        addInjectionTable(SterlingAndBlack.MODID, "simple_dungeon", foo);                
        
        // stronghold
        foo = createChestPool(1, 1, 0.50F)
                .add(ItemLootEntry.lootTableItem(ModItems.black_silver_ingot.get()).setWeight(3)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.black_silver_sword.get()).setWeight(1));
        addInjectionTable(SterlingAndBlack.MODID, "stronghold", foo);      
       
        // buried_treasure
        foo = createChestPool(1, 1, 0.50F)
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_ingot.get()).setWeight(5)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 4))))
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_sword.get()).setWeight(1));
        addInjectionTable(SterlingAndBlack.MODID, "buried_treasure", foo);      
        
        // shipwreck
        foo = createChestPool(1, 1, 0.25F)
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_ingot.get()).setWeight(3)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 3))))
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_helmet.get()).setWeight(1));
        addInjectionTable(SterlingAndBlack.MODID, "shipwreck", foo);      
        
        // underwater_ruin
        foo = createChestPool(1, 1, 0.25F)
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_ingot.get()).setWeight(3)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_chestplate.get()).setWeight(1));
        addInjectionTable(SterlingAndBlack.MODID, "underwater_ruin", foo);      
        
        // village_armorer
        foo = createChestPool(1, 1, 0.10F)
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_ingot.get()).setWeight(3)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_boots.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_leggings.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_chestplate.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_helmet.get()).setWeight(1));
        addInjectionTable(SterlingAndBlack.MODID, "village_armorer", foo);      
                
        // village_toolsmith
        foo = createChestPool(1, 1, 0.10F)
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_ingot.get()).setWeight(3)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_shovel.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_hoe.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_pickaxe.get()).setWeight(1));
        addInjectionTable(SterlingAndBlack.MODID, "village_toolsmith", foo);      
                
        // village_weaponsmith
        foo = createChestPool(1, 1, 0.10F)
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_ingot.get()).setWeight(3)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_sword.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.sterling_steel_axe.get()).setWeight(1));
        addInjectionTable(SterlingAndBlack.MODID, "village_weaponsmith", foo);      
                
        return tables;
    } // getTables()

} // end class
