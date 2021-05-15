package mod.akkamaddi.sterlingblack.config;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ServerConfig
{
    final ForgeConfigSpec.BooleanValue serverEnableRecycling; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableSilverRecycling; // recipe flag
    final ForgeConfigSpec.BooleanValue serverAddModLootToChests;
    
    ServerConfig(final ForgeConfigSpec.Builder builder)
    {
        builder.push("General");
        serverAddModLootToChests = builder.comment("Add Sterling and Black items to chest loot?")
                .translation(SterlingAndBlack.MODID + ".config.addModLootToChests")
                .define("AddModLootToChests", true);
        serverEnableRecycling = 
                builder.comment("Enable fusion furnace recycling of sterling steel and black silver items")
                .translation(SterlingAndBlack.MODID + "config.EnableRecycling")
                .define("EnableRecycling", true);
        serverEnableSilverRecycling = 
                builder.comment("Enable fusion furnace recycling of silver items")
                .translation(SterlingAndBlack.MODID + "config.EnableSilverRecycling")
                .define("EnableSilverRecycling", true);
        builder.pop();
    } // end ctor

} // end-class
