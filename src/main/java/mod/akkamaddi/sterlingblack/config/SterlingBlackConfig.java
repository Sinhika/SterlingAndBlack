package mod.akkamaddi.sterlingblack.config;

import mod.alexndr.simplecorelib.api.config.SimpleConfig;

public class SterlingBlackConfig extends SimpleConfig
{
    // recipe flags
    public static SterlingBlackConfig INSTANCE = new SterlingBlackConfig();
    
    // general
    public static boolean addModLootToChests;
    
    // client-side
    public static boolean makeMeSparkle = true;
    

} // end-class
