package mod.akkamaddi.sterlingblack.datagen;

import java.util.List;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import mod.akkamaddi.sterlingblack.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.MiningBlockTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockTags extends MiningBlockTags
{

    public ModBlockTags(DataGenerator gen, ExistingFileHelper existingFileHelper)
    {
        super(gen, SterlingAndBlack.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        super.addTags();
        registerStorageBlockTags();
        registerBeaconBlockTags();
    }

    /**
     * Identify metal blocks as beacon block bases.
     */
    private void registerBeaconBlockTags()
    {
        this.tag(BlockTags.BEACON_BASE_BLOCKS)
            .add(ModBlocks.sterling_steel_block.get())
            .add(ModBlocks.black_silver_block.get());
    }
    
    /**
     * Create standard forge tags for storage blocks.
     */
    private void registerStorageBlockTags()
    {
        this.tag(TagUtils.forgeBlockTag("storage_blocks"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/sterling_steel"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/black_silver"));
        
        this.tag(TagUtils.forgeBlockTag("storage_blocks/sterling_steel"))
            .add(ModBlocks.sterling_steel_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/black_silver"))
            .add(ModBlocks.black_silver_block.get());
} // end registerStorageBlockTags
       
    @Override
    protected void registerMiningTags()
    {
        // all the registered blocks are mineable.
        List<Block> mineables = ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
        
        // note: all the mineable blocks are iron-level.
        registerMineableTags(mineables, 
                List.of(), // 1 stone
                List.of(ModBlocks.sterling_steel_block.get()), // 2 - iron
                List.of(ModBlocks.black_silver_block.get()), // 3 - diamond
                List.of()); // 4 - netherite
    } // registerMiningTags()

} // end class
