package akkamaddi.SterlingAndBlack.code;

import java.util.Random;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class HandlerJoinWorld
{
    public static double rand;
    public static int range;

    public static RandomRange random = new RandomRange();

    /**
     * This class allows zombies and skeletons to spawn holding/wearing SimpleOres items.
     */
    @ForgeSubscribe
    public void EntityJoinWorldEvent(EntityJoinWorldEvent event)
    {
        rand = Math.random();
        range = random.nextInt(1, 30);

        if ((rand <= 0.03D) && ((event.entity instanceof EntityLiving)) && ((event.entity instanceof EntitySkeleton | event.entity instanceof EntityZombie)))
        {
            EntityLiving living = (EntityLiving)event.entity;

            if (range == 1)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(SterlingAndBlackCore.sterlingSteelHelm));
            }

            if (range == 2)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(SterlingAndBlackCore.sterlingSteelChest));
            }

            if (range == 3)
            {
                living.setCurrentItemOrArmor(2, new ItemStack(SterlingAndBlackCore.sterlingSteelLegs));
            }

            if (range == 4)
            {
                living.setCurrentItemOrArmor(1, new ItemStack(SterlingAndBlackCore.sterlingSteelBoots));
            }

            if (range == 5)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.sterlingSteelSword));
            }

            if (range == 6)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.sterlingSteelShovel));
            }

            if (range == 7)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.sterlingSteelAxe));
            }

            if (range == 8)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.sterlingSteelPickaxe));
            }

            if (range == 9)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.sterlingSteelHoe));
            }

            if (range == 10)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(SterlingAndBlackCore.blackSilverHelm));
            }

            if (range == 11)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(SterlingAndBlackCore.blackSilverChest));
            }

            if (range == 12)
            {
                living.setCurrentItemOrArmor(2, new ItemStack(SterlingAndBlackCore.blackSilverLegs));
            }

            if (range == 13)
            {
                living.setCurrentItemOrArmor(1, new ItemStack(SterlingAndBlackCore.blackSilverBoots));
            }

            if (range == 14)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.blackSilverSword));
            }

            if (range == 15)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.blackSilverShovel));
            }

            if (range == 16)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.blackSilverAxe));
            }

            if (range == 17)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.blackSilverPickaxe));
            }

            if (range == 18)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.blackSilverHoe));
            }

            if (range == 19)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(SterlingAndBlackCore.sterlingSteelHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(SterlingAndBlackCore.sterlingSteelChest));
                living.setCurrentItemOrArmor(2, new ItemStack(SterlingAndBlackCore.sterlingSteelLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(SterlingAndBlackCore.sterlingSteelBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.sterlingSteelSword));
            }

            if (range == 20)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(SterlingAndBlackCore.blackSilverHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(SterlingAndBlackCore.blackSilverChest));
                living.setCurrentItemOrArmor(2, new ItemStack(SterlingAndBlackCore.blackSilverLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(SterlingAndBlackCore.blackSilverBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.blackSilverSword));
            }

            if (range == 21)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(SterlingAndBlackCore.sterlingSteelHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(SterlingAndBlackCore.sterlingSteelChest));
                living.setCurrentItemOrArmor(2, new ItemStack(SterlingAndBlackCore.sterlingSteelLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(SterlingAndBlackCore.sterlingSteelBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.sterlingSteelSword));
            }

            if (range == 22)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(SterlingAndBlackCore.blackSilverHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(SterlingAndBlackCore.blackSilverChest));
                living.setCurrentItemOrArmor(2, new ItemStack(SterlingAndBlackCore.blackSilverLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(SterlingAndBlackCore.blackSilverBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.blackSilverSword));
            }

            if (range == 23)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(SterlingAndBlackCore.sterlingSteelHelm));
                living.setCurrentItemOrArmor(1, new ItemStack(SterlingAndBlackCore.sterlingSteelBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.sterlingSteelPickaxe));
            }

            if (range == 24)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(SterlingAndBlackCore.blackSilverHelm));
                living.setCurrentItemOrArmor(1, new ItemStack(SterlingAndBlackCore.blackSilverBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.blackSilverPickaxe));
            }

            if (range == 25)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(SterlingAndBlackCore.sterlingSteelHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(SterlingAndBlackCore.sterlingSteelChest));
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.sterlingSteelAxe));
            }

            if (range == 26)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(SterlingAndBlackCore.blackSilverHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(SterlingAndBlackCore.blackSilverChest));
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.blackSilverAxe));
            }

            if (range == 27)
            {
                living.setCurrentItemOrArmor(2, new ItemStack(SterlingAndBlackCore.sterlingSteelLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(SterlingAndBlackCore.sterlingSteelBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.sterlingSteelShovel));
            }

            if (range == 28)
            {
                living.setCurrentItemOrArmor(2, new ItemStack(SterlingAndBlackCore.blackSilverLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(SterlingAndBlackCore.blackSilverBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.blackSilverShovel));
            }

            if (range == 29)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(SterlingAndBlackCore.sterlingSteelHelm));
                living.setCurrentItemOrArmor(1, new ItemStack(SterlingAndBlackCore.sterlingSteelBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.sterlingSteelHoe));
            }

            if (range == 30)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(SterlingAndBlackCore.blackSilverHelm));
                living.setCurrentItemOrArmor(1, new ItemStack(SterlingAndBlackCore.blackSilverBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(SterlingAndBlackCore.blackSilverHoe));
            }
        }
    }
}

class RandomRange extends Random
{
    public int nextInt(int min, int max)
    {
        return nextInt(max - min + 1) + min;
    }
}