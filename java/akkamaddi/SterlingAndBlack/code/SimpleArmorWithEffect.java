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
     * Called to tick armor in the armor slot.
     * Alloying silver into Sterling Steel enhances its natural magic, and the armor is innately enchanted. Wearing the 
     * Sterling Steel helmet, chest plate, and leggings together grants the magical (potion) ability Speed 1, which gives 
     * a small boost to movement speed. Wearing the Sterling Steel chest plate, leggings, and boots together grants the 
     * ability Jump 1, which increases jump height by half a block. This allows you to scale wood and stone fences. 
     * (The particle effects from the potion effects can be decreased in the game's display settings.)
     * 
     * Black Silver armor is similarly retains natural magic. A full set of Black Silver armor grants the temporary 
     * enchantment of Dig Speed 1.
     *
     * @param world
     * @param player
     * @param itemStack
     */
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		// Sterling Steel chest plate, leggings, and boots together grants the ability Jump 1
		 if (player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null 
				 && player.getCurrentArmor(1) != null)
	        {
	            ItemStack chest = player.getCurrentArmor(1);
	            ItemStack legs = player.getCurrentArmor(2);
	            ItemStack boots = player.getCurrentArmor(3);

	            if ((chest.getItem().getUnlocalizedName() == 
	            		SterlingAndBlackCore.sterlingSteelChest.getUnlocalizedName()) 
	            	&& (legs.getItem().getUnlocalizedName() == SterlingAndBlackCore.sterlingSteelLegs.getUnlocalizedName()) 
	            	&& boots.getItem().getUnlocalizedName() == SterlingAndBlackCore.sterlingSteelBoots.getUnlocalizedName())
	            {
	                player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 40, 0));
	            }
	        }
		 
		 // Sterling Steel helmet, chest plate, and leggings together grants the magical (potion) ability Speed 1
	       if (player.getCurrentArmor(0) != null && player.getCurrentArmor(1) != null 
	        		&& player.getCurrentArmor(2) != null)
	        {
	            ItemStack helmet = player.getCurrentArmor(0);
	            ItemStack chest = player.getCurrentArmor(1);
	            ItemStack legs = player.getCurrentArmor(2);

	            if (helmet.getItem() == SterlingAndBlackCore.sterlingSteelHelm 
	            		&& chest.getItem() == SterlingAndBlackCore.sterlingSteelChest 
	            		&& legs.getItem() == SterlingAndBlackCore.sterlingSteelLegs)
	            {
	                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40, 0));
	            }
	        }

	       // full set of Black Silver armor grants the temporary enchantment of Dig Speed 1
	       if (player.getCurrentArmor(0) != null && player.getCurrentArmor(3) != null 
	        		&& player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null)
	        {
	            ItemStack helmet = player.getCurrentArmor(0);
	            ItemStack chest = player.getCurrentArmor(1);
	            ItemStack legs = player.getCurrentArmor(2);
	            ItemStack boots = player.getCurrentArmor(3);

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
