/**
 * 
 */
package akkamaddi.plugins.sterlingandblack;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import akkamaddi.api.core.ModContents;

/**
 * @author cyhiggin
 *
 */
public class OnlySilverContents extends ModContents
{
    protected Class<?> registryClass;
    protected Method registerSilverPredicateMethod;
    
    public OnlySilverContents() 
    {
        if (!isModLoaded()) {
            return;
        }
        try
        {
            registryClass = Class
                    .forName("zotmc.onlysilver.api.OnlySilverRegistry");
        }
        catch (ClassNotFoundException | SecurityException e)
        {
            throw new ModReflectionFailException(e);
        }
        try
        {
            Method [] registryMethods = registryClass.getDeclaredMethods();
            for (Method m: registryMethods)
            {
                if (m.getName().endsWith("registerSilverPredicate"))
                {
                    registerSilverPredicateMethod = m;
                    break;
                }
            } // end-for
        }
        catch (SecurityException e)
        {
            throw new ModReflectionFailException(e);
        }
    } // end OnlySilverContents ctor
    
    
    public void registerSilverPredicate(Item item, Predicate<?> silverPredicate)
    {
       try
        {
            registerSilverPredicateMethod.invoke(null, new Object [] {item, silverPredicate});
        }
        catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e)
        {
            throw new ModReflectionFailException(e);
        }
    } // end registerSilverPredicate
    
    /* (non-Javadoc)
     * @see akkamaddi.api.core.ModContents#getModId()
     */
    @Override
    public String getModId()
    {
        return "onlysilver";
        // end
    }

} // end class OnlySilverContents
