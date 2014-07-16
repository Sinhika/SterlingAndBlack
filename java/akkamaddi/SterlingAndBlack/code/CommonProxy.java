package akkamaddi.SterlingAndBlack.code;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy
{
    // Client stuff
    public void registerRenderers()
    {
        // Nothing here as the server doesn't render graphics or entities!
    }

    public int addArmor(String armor)
    {
        return 0;
    }

    public void registerTickHandler()
    {
        // TODO Auto-generated method stub
        TickRegistry.registerTickHandler(new HandlerArmor(), Side.SERVER);
    }
}
