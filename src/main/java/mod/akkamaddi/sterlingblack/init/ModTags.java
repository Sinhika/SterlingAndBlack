package mod.akkamaddi.sterlingblack.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ModTags
{

    public static class Items
    {
        public static final Tag<Item> INGOTS_STERLING_STEEL = forgeTag("ingots/sterling_steel");
        public static final Tag<Item> NUGGETS_STERLING_STEEL = forgeTag("nuggets/sterling_steel");
        public static final Tag<Item> BLOCK_STERLING_STEEL = forgeTag("storage_blocks/sterling_steel");
        public static final Tag<Item> RODS_STERLING_STEEL = forgeTag("rods/sterling_steel");
        
        public static final Tag<Item> INGOTS_BLACK_SILVER = forgeTag("ingots/black_silver");
        public static final Tag<Item> NUGGETS_BLACK_SILVER = forgeTag("nuggets/black_silver");
        public static final Tag<Item> BLOCK_BLACK_SILVER = forgeTag("storage_blocks/black_silver");
        
//        private static Tag<Item> tag(String name) {
//            return new ItemTags.Wrapper(new ResourceLocation(SterlingAndBlack.MODID, name));
//        }

        private static Tag<Item> forgeTag(String name) {
            return new ItemTags.Wrapper(new ResourceLocation("forge", name));
        }
    } // end class Items
    
    
    public static class Blocks
    {
        public static final Tag<Block> BLOCK_STERLING_STEEL = forgeTag("storage_blocks/sterling_steel");
        public static final Tag<Block> BLOCK_BLACK_SILVER = forgeTag("storage_blocks/black_silver");
        
//        private static Tag<Block> tag(String name) {
//            return new BlockTags.Wrapper(new ResourceLocation(SterlingAndBlack.MODID, name));
//        }

        private static Tag<Block> forgeTag(String name) {
            return new BlockTags.Wrapper(new ResourceLocation("forge", name));
        }
    } // end class Blocks

    
} // end class ModTags
