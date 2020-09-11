package mod.akkamaddi.sterlingblack.config;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ClientConfig
{
    final ForgeConfigSpec.BooleanValue clientMakeMeSparkle;
    
    ClientConfig(final ForgeConfigSpec.Builder builder) 
    {
        builder.push("General");
        clientMakeMeSparkle = builder.comment("Make Sterling Steel blocks sparkle?")
                .translation(SterlingAndBlack.MODID + "config.MakeMeSparkle")
                .define("MakeMeSparkle", true);
        builder.pop();
    }
} // end-class

