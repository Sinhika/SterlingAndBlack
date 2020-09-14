/**
 * 
 */
package mod.akkamaddi.sterlingblack.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Predicate;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.ModList;

/**
 * @author cyhiggin
 *
 */
public class OnlySilverContents
{
    protected Class<?> registryClass;
    protected Method registerSilverPredicateMethod;

    public class ModMissingException extends RuntimeException {
        private static final long serialVersionUID = -611914051440324793L; 
    };
    
    public class ModReflectionFailException extends RuntimeException
    {
        private static final long serialVersionUID = 6002687435907055945L;
        public ModReflectionFailException(Throwable e) {
            super(e);
        }
    }    
    
    public OnlySilverContents() 
    {
        if (!isModLoaded()) {
            return;
        }
        try
        {
            registryClass = Class.forName("mod.zotmc.onlysilver.api.OnlySilverRegistry");
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
    
    public boolean isModLoaded()
    {
        return ModList.get().isLoaded(getModId());
    }

    public String getModId() {
        return "onlysilver";
    }
    
    public void registerSilverPredicate(Predicate<? super ItemStack> silverPredicate)
    {
       try
        {
            registerSilverPredicateMethod.invoke(null, silverPredicate);
        }
        catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e)
        {
            throw new ModReflectionFailException(e);
        }
    } // end registerSilverPredicate
    
} // end class OnlySilverContents
