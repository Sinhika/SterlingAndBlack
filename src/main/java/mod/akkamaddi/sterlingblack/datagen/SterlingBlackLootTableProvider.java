package mod.akkamaddi.sterlingblack.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.akkamaddi.sterlingblack.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.BlockLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;

public class SterlingBlackLootTableProvider extends BlockLootTableProvider
{

    public SterlingBlackLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
    {
        tables.clear();
        standardDropTable(ModBlocks.sterling_steel_block.get());
        standardDropTable(ModBlocks.black_silver_block.get());
        return tables;
    }

} // end class
