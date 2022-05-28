package mod.akkamaddi.sterlingblack.content;

import java.util.List;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import mod.akkamaddi.sterlingblack.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

// TODO redo this for 1.18.1 Tiers classes.
public class SterlingBlackItemTiers
{
    public static final TagKey<Block> STERLING_STEEL_TAG = 
            BlockTags.create(new ResourceLocation(SterlingAndBlack.MODID, "needs_sterling_steel_tool"));
    public static final TagKey<Block> BLACK_SILVER_TAG = 
            BlockTags.create(new ResourceLocation(SterlingAndBlack.MODID, "needs_black_silver_tool"));
    
    public static final Tier  STERLING_STEEL = TierSortingRegistry.registerTier(
            new ForgeTier(Tiers.IRON.getLevel(), 660, 10.0F, 2.0F, 26, STERLING_STEEL_TAG, 
                    ()->Ingredient.of( ModItems.sterling_steel_ingot.get())),
            new ResourceLocation(SterlingAndBlack.MODID, "sterling_steel"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
    
    public static final Tier BLACK_SILVER = TierSortingRegistry.registerTier(
            new ForgeTier(5, 3460, 16.0F, 6.0F, 22, BLACK_SILVER_TAG, ()->Ingredient.of( ModItems.black_silver_ingot.get())),
            new ResourceLocation(SterlingAndBlack.MODID, "black_silver"), List.of(Tiers.NETHERITE), List.of());

}  // end class SimpleOresItemTier
