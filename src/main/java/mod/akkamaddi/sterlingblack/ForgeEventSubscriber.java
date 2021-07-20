package mod.akkamaddi.sterlingblack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.sterlingblack.config.SterlingBlackConfig;
import mod.akkamaddi.sterlingblack.loot.SterlingBlackInjectionLookup;
import mod.alexndr.simplecorelib.helpers.LootUtils;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * Subscribe to events from the FORGE EventBus that should be handled on both PHYSICAL sides in this class
 *
 */
@EventBusSubscriber(modid = SterlingAndBlack.MODID, bus = EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber
{
    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogManager.getLogger(SterlingAndBlack.MODID + " Forge Event Subscriber");
    private static final SterlingBlackInjectionLookup lootLookupMap = new SterlingBlackInjectionLookup();
        
    /**
     * add mod loot to loot tables. Code heavily based on Botania's LootHandler, which
     * neatly solves the problem when I couldn't figure it out.
     */
    @SubscribeEvent
    public static void LootLoad(final LootTableLoadEvent event)
    {
        if (SterlingBlackConfig.addModLootToChests)
        {
            LootUtils.LootLoadHandler(SterlingAndBlack.MODID, event, lootLookupMap);
       } // end-if config allows
    } // end LootLoad()
    
} // end-class
