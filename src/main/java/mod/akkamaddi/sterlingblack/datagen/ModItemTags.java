package mod.akkamaddi.sterlingblack.datagen;

import java.util.concurrent.CompletableFuture;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import mod.akkamaddi.sterlingblack.init.ModBlocks;
import mod.akkamaddi.sterlingblack.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.MiningItemTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends MiningItemTags
{

    public ModItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
			CompletableFuture<TagLookup<Block>> blockTagProvider, ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, blockTagProvider, SterlingAndBlack.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider)
    {
        super.addTags(lookupProvider);
        registerNuggetTags();
        registerIngotTags();
        registerStorageBlockTags();
        registerToolTags(ModItems.ITEMS);
        registerArmorTags(ModItems.ITEMS);
    }

    /**
     * Create standard forge tags for storage blocks.
     */
    private void registerStorageBlockTags()
    {
        this.tag(TagUtils.forgeTag("storage_blocks"))
            .addTag(TagUtils.forgeTag("storage_blocks/sterling_steel"))
            .addTag(TagUtils.forgeTag("storage_blocks/black_silver"));
        
        this.tag(TagUtils.forgeTag("storage_blocks/sterling_steel"))
            .add(ModBlocks.sterling_steel_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/black_silver"))
            .add(ModBlocks.black_silver_block.get().asItem());
    } // end registerStorageBlockTags

    
    private void registerNuggetTags()
    {
        this.tag(TagUtils.forgeTag("nuggets"))
            .addTag(TagUtils.forgeTag("nuggets/black_silver"))
            .addTag(TagUtils.forgeTag("nuggets/sterling_steel"));
        
        this.tag(TagUtils.forgeTag("nuggets/black_silver"))
            .add(ModItems.black_silver_nugget.get());
        this.tag(TagUtils.forgeTag("nuggets/sterling_steel"))
            .add(ModItems.sterling_steel_nugget.get());
    } 
 
    private void registerIngotTags()
    {
        this.tag(TagUtils.forgeTag("ingots"))
            .addTag(TagUtils.forgeTag("ingots/black_silver"))
            .addTag(TagUtils.forgeTag("ingots/sterling_steel"));
        
        this.tag(TagUtils.forgeTag("ingots/black_silver"))
            .add(ModItems.black_silver_ingot.get());
        this.tag(TagUtils.forgeTag("ingots/sterling_steel"))
            .add(ModItems.sterling_steel_ingot.get());
    } 
        
 
} // new class
