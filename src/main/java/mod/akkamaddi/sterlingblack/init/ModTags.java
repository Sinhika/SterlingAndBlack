package mod.akkamaddi.sterlingblack.init;

import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags
{

    public static class Items
    {
        public static final TagKey<Item> INGOTS_STERLING_STEEL = TagUtils.forgeTag("ingots/sterling_steel");
        public static final TagKey<Item> NUGGETS_STERLING_STEEL = TagUtils.forgeTag("nuggets/sterling_steel");
        public static final TagKey<Item> BLOCK_STERLING_STEEL = TagUtils.forgeTag("storage_blocks/sterling_steel");
        public static final TagKey<Item> RODS_STERLING_STEEL = TagUtils.forgeTag("rods/sterling_steel");
        
        public static final TagKey<Item> INGOTS_BLACK_SILVER = TagUtils.forgeTag("ingots/black_silver");
        public static final TagKey<Item> NUGGETS_BLACK_SILVER = TagUtils.forgeTag("nuggets/black_silver");
        public static final TagKey<Item> BLOCK_BLACK_SILVER = TagUtils.forgeTag("storage_blocks/black_silver");
        
        public static final TagKey<Item> INGOTS_SILVER = TagUtils.forgeTag("ingots/silver");
        public static final TagKey<Item> GEM_ONYX = TagUtils.forgeTag("gems/onyx");
        
    } // end class Items
    
    
    public static class Blocks
    {
        public static final TagKey<Block> BLOCK_STERLING_STEEL = TagUtils.forgeBlockTag("storage_blocks/sterling_steel");
        public static final TagKey<Block> BLOCK_BLACK_SILVER = TagUtils.forgeBlockTag("storage_blocks/black_silver");
    } // end class Blocks

    
} // end class ModTags
