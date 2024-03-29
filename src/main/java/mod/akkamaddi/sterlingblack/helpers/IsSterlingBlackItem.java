package mod.akkamaddi.sterlingblack.helpers;

import java.util.function.Predicate;

import mod.akkamaddi.sterlingblack.init.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

public class IsSterlingBlackItem implements Predicate<ItemStack>
{
    @Override
    public boolean test(ItemStack t)
    {
        for (RegistryObject<Item> ii : ModItems.ITEMS.getEntries()) 
        {
            if (t.getItem() == ii.get()) {
                return true;
            }
        }
        return false;
    }
} // end predicate class IsSilverItem