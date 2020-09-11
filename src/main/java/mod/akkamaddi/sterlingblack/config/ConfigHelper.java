package mod.akkamaddi.sterlingblack.config;

import net.minecraftforge.fml.config.ModConfig;

public final class ConfigHelper
{
    public static void bakeClient(final ModConfig config) 
    {
        SterlingBlackConfig.makeMeSparkle = ConfigHolder.CLIENT.clientMakeMeSparkle.get();
    } // end bakeClient

    public static void bakeServer(final ModConfig config) 
    {
        // general stuff
        // recipe flags.
        SterlingBlackConfig.INSTANCE.putFlag("recycling_enabled", 
                ConfigHolder.SERVER.serverEnableRecycling.get());
        SterlingBlackConfig.INSTANCE.putFlag("silver_recycling_enabled", 
                ConfigHolder.SERVER.serverEnableSilverRecycling.get());
    } // end bakeServer
} // end-class
