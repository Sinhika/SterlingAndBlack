package akkamaddi.SterlingAndBlack.code;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import alexndr.SimpleOres.api.content.SimpleArmor;

public class SimpleArmorWithEffect extends SimpleArmor 
{

	public SimpleArmorWithEffect(ArmorMaterial armormaterial, int renderer,
			int slotnumber) 
	{
		super(armormaterial, renderer, slotnumber);
	}

	/**
     * Called to tick armor in the armor slot. Override to do something
     *
     * @param world
     * @param player
     * @param itemStack
     */
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		 if (player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null 
				 && player.getCurrentArmor(1) != null)
	        {
	            ItemStack chest = player.getCurrentArmor(3);
	            ItemStack legs = player.getCurrentArmor(2);
	            ItemStack boots = player.getCurrentArmor(1);

	            if (chest.getItem() == SterlingAndBlackCore.sterlingSteelChest 
	            	&& legs.getItem() == SterlingAndBlackCore.sterlingSteelLegs 
	            	&& boots.getItem() == SterlingAndBlackCore.sterlingSteelBoots)
	            {
	                player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 40, 0));
	            }
	        }
		 
	       if (player.getCurrentArmor(4) != null && player.getCurrentArmor(3) != null 
	        		&& player.getCurrentArmor(2) != null)
	        {
	            ItemStack helmet = player.getCurrentArmor(4);
	            ItemStack chest = player.getCurrentArmor(3);
	            ItemStack legs = player.getCurrentArmor(2);

	            if (helmet.getItem() == SterlingAndBlackCore.sterlingSteelHelm 
	            		&& chest.getItem() == SterlingAndBlackCore.sterlingSteelChest 
	            		&& legs.getItem() == SterlingAndBlackCore.sterlingSteelLegs)
	            {
	                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40, 0));
	            }
	        }

	       if (player.getCurrentArmor(4) != null && player.getCurrentArmor(3) != null 
	        		&& player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null)
	        {
	            ItemStack helmet = player.getCurrentArmor(4);
	            ItemStack chest = player.getCurrentArmor(3);
	            ItemStack legs = player.getCurrentArmor(2);
	            ItemStack boots = player.getCurrentArmor(1);

	            if (helmet.getItem() == SterlingAndBlackCore.blackSilverHelm 
	            		&& chest.getItem() == SterlingAndBlackCore.blackSilverChest 
	            		&& legs.getItem() == SterlingAndBlackCore.blackSilverLegs 
	            		&& boots.getItem() == SterlingAndBlackCore.blackSilverBoots)
	            {
	                player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 40, 0));
	            }
	        }

	} // end onArmorTick

	
} // end class SimpleArmorWithEffect
