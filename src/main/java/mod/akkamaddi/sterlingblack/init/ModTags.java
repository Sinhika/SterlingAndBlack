package mod.akkamaddi.sterlingblack.init;

import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;

public class ModTags
{

    public static class Items
    {
        public static final ITag.INamedTag<Item> INGOTS_STERLING_STEEL = TagUtils.forgeTag("ingots/sterling_steel");
        public static final ITag.INamedTag<Item> NUGGETS_STERLING_STEEL = TagUtils.forgeTag("nuggets/sterling_steel");
        public static final ITag.INamedTag<Item> BLOCK_STERLING_STEEL = TagUtils.forgeTag("storage_blocks/sterling_steel");
        public static final ITag.INamedTag<Item> RODS_STERLING_STEEL = TagUtils.forgeTag("rods/sterling_steel");
        
        public static final ITag.INamedTag<Item> INGOTS_BLACK_SILVER = TagUtils.forgeTag("ingots/black_silver");
        public static final ITag.INamedTag<Item> NUGGETS_BLACK_SILVER = TagUtils.forgeTag("nuggets/black_silver");
        public static final ITag.INamedTag<Item> BLOCK_BLACK_SILVER = TagUtils.forgeTag("storage_blocks/black_silver");
        
        public static final ITag.INamedTag<Item> INGOTS_SILVER = TagUtils.forgeTag("ingots/silver");
        public static final ITag.INamedTag<Item> GEM_ONYX = TagUtils.forgeTag("gems/onyx");
        
    } // end class Items
    
    
    public static class Blocks
    {
        public static final ITag.INamedTag<Block> BLOCK_STERLING_STEEL = TagUtils.forgeBlockTag("storage_blocks/sterling_steel");
        public static final ITag.INamedTag<Block> BLOCK_BLACK_SILVER = TagUtils.forgeBlockTag("storage_blocks/black_silver");
    } // end class Blocks

    
} // end class ModTags
