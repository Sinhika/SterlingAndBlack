package akkamaddi.SterlingAndBlack.code;

import java.util.EnumSet;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;

public class HandlerArmor  implements ITickHandler
{
    //effects
    private void onPlayerTick(EntityPlayer player)
    {
        if (player.getCurrentItemOrArmor(3) != null && player.getCurrentItemOrArmor(2) != null && player.getCurrentItemOrArmor(1) != null)
        {
            ItemStack chest = player.getCurrentItemOrArmor(3);
            ItemStack legs = player.getCurrentItemOrArmor(2);
            ItemStack boots = player.getCurrentItemOrArmor(1);

            if (chest.getItem() == SterlingAndBlackCore.sterlingSteelChest & legs.getItem() == SterlingAndBlackCore.sterlingSteelLegs & boots.getItem() == SterlingAndBlackCore.sterlingSteelBoots)
            {
                player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 40, 0));
            }
        }

        if (player.getCurrentItemOrArmor(4) != null && player.getCurrentItemOrArmor(3) != null && player.getCurrentItemOrArmor(2) != null)
        {
            ItemStack helmet = player.getCurrentItemOrArmor(4);
            ItemStack chest = player.getCurrentItemOrArmor(3);
            ItemStack legs = player.getCurrentItemOrArmor(2);

            if (helmet.getItem() == SterlingAndBlackCore.sterlingSteelHelm & chest.getItem() == SterlingAndBlackCore.sterlingSteelChest & legs.getItem() == SterlingAndBlackCore.sterlingSteelLegs)
            {
                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40, 0));
            }
        }

        if (player.getCurrentItemOrArmor(4) != null && player.getCurrentItemOrArmor(3) != null && player.getCurrentItemOrArmor(2) != null && player.getCurrentItemOrArmor(1) != null)
        {
            ItemStack helmet = player.getCurrentItemOrArmor(4);
            ItemStack chest = player.getCurrentItemOrArmor(3);
            ItemStack legs = player.getCurrentItemOrArmor(2);
            ItemStack boots = player.getCurrentItemOrArmor(1);

            if (helmet.getItem() == SterlingAndBlackCore.blackSilverHelm & chest.getItem() == SterlingAndBlackCore.blackSilverChest & legs.getItem() == SterlingAndBlackCore.blackSilverLegs & boots.getItem() == SterlingAndBlackCore.blackSilverBoots)
            {
                player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 40, 0));
            }
        }
    }

    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData)
    {
        if (type.equals(EnumSet.of(TickType.PLAYER)))
        {
            onPlayerTick((EntityPlayer)tickData[0]);
        }
    }

    @Override
    public EnumSet<TickType> ticks()
    {
        return EnumSet.of(TickType.PLAYER, TickType.SERVER);
    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public String getLabel()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
