package mod.akkamaddi.sterlingblack.datagen;

import java.util.function.BiConsumer;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import mod.akkamaddi.sterlingblack.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.LootTableInjectorProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class SterlingBlackLootInjectorSubprovider extends LootTableInjectorProvider
{

	@Override
	public void generate(BiConsumer<ResourceLocation, Builder> bar) 
	{
        // simple_dungeon
        LootPool.Builder foo = createChestPool(1, 1, 0.50F)
                .add(LootItem.lootTableItem(ModItems.sterling_steel_ingot.get()).setWeight(3)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(ModItems.large_sterling_steel_chunk.get()).setWeight(3)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))))
                .add(LootItem.lootTableItem(ModItems.black_silver_ingot.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(ModItems.large_black_silver_chunk.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))));
        addInjectionTable(bar, getInjectionTableId(SterlingAndBlack.MODID, "simple_dungeon"), foo);                
        
        // stronghold
        foo = createChestPool(1, 1, 0.50F)
                .add(LootItem.lootTableItem(ModItems.black_silver_ingot.get()).setWeight(3)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(ModItems.black_silver_sword.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(SterlingAndBlack.MODID, "stronghold"), foo);      
       
        // buried_treasure
        foo = createChestPool(1, 1, 0.50F)
                .add(LootItem.lootTableItem(ModItems.sterling_steel_ingot.get()).setWeight(5)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                .add(LootItem.lootTableItem(ModItems.sterling_steel_sword.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(SterlingAndBlack.MODID, "buried_treasure"), foo);      
        
        // shipwreck
        foo = createChestPool(1, 1, 0.25F)
                .add(LootItem.lootTableItem(ModItems.sterling_steel_ingot.get()).setWeight(3)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                .add(LootItem.lootTableItem(ModItems.sterling_steel_helmet.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(SterlingAndBlack.MODID, "shipwreck"), foo);      
        
        // underwater_ruin
        foo = createChestPool(1, 1, 0.25F)
                .add(LootItem.lootTableItem(ModItems.sterling_steel_ingot.get()).setWeight(3)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(ModItems.sterling_steel_chestplate.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(SterlingAndBlack.MODID, "underwater_ruin"), foo);      
        
        // village_armorer
        foo = createChestPool(1, 1, 0.10F)
                .add(LootItem.lootTableItem(ModItems.sterling_steel_ingot.get()).setWeight(3)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(ModItems.sterling_steel_boots.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.sterling_steel_leggings.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.sterling_steel_chestplate.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.sterling_steel_helmet.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(SterlingAndBlack.MODID, "village_armorer"), foo);      
                
        // village_toolsmith
        foo = createChestPool(1, 1, 0.10F)
                .add(LootItem.lootTableItem(ModItems.sterling_steel_ingot.get()).setWeight(3)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(ModItems.sterling_steel_shovel.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.sterling_steel_hoe.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.sterling_steel_pickaxe.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(SterlingAndBlack.MODID, "village_toolsmith"), foo);      
                
        // village_weaponsmith
        foo = createChestPool(1, 1, 0.10F)
                .add(LootItem.lootTableItem(ModItems.sterling_steel_ingot.get()).setWeight(3)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(ModItems.sterling_steel_sword.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.sterling_steel_axe.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(SterlingAndBlack.MODID, "village_weaponsmith"), foo);      
                
    } // generate()


} // end class
