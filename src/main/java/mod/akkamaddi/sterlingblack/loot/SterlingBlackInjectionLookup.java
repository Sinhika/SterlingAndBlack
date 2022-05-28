package mod.akkamaddi.sterlingblack.loot;

import mod.alexndr.simplecorelib.api.helpers.InjectionTableLookup;

@SuppressWarnings("serial")
public class SterlingBlackInjectionLookup extends InjectionTableLookup
{

    public SterlingBlackInjectionLookup()
    {
       super();
       
       this.put("simple_dungeon", "simple_dungeon");
       AddStrongholdAliases();
       AddOceanAliases();
       this.put("village_armorer", "village_armorer");
       this.put("village_toolsmith", "village_toolsmith");
       this.put("village_weaponsmith", "village_weaponsmith");
    } // end ctor()

} // end class
