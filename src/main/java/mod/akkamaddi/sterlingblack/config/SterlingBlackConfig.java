package mod.akkamaddi.sterlingblack.config;

import java.util.HashMap;
import java.util.Map;

import mod.alexndr.simplecorelib.config.ISimpleConfig;

public class SterlingBlackConfig implements ISimpleConfig
{
    // recipe flags
    private static Map<String, Boolean> flags = new HashMap<>();
    public static SterlingBlackConfig INSTANCE = new SterlingBlackConfig();
    
    // general
    public static boolean addModLootToChests;
    
    // client-side
    public static boolean makeMeSparkle = true;
    
    @Override
    public void clear()
    {
        flags.clear();
    }

    @Override
    public boolean getFlag(String n)
    {
        Boolean obj = flags.get(n);
        return obj != null && obj;
    }

    @Override
    public void putFlag(String n, boolean val)
    {
        flags.put(n, val);
    }

} // end-class
