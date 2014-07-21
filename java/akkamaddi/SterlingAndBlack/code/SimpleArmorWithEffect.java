package akkamaddi.SterlingAndBlack.code;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
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
        ItemStack chest = null, legs = null, boots = null, helm = null;
        
        // search armor list for the different pieces.
        for (int i=0; i < 4; i++) {
        	if ( player.getCurrentArmor(i) == null) {
        		continue;
        	}
        	ItemArmor armorPiece = (ItemArmor) player.getCurrentArmor(i).getItem();
        	if (armorPiece.armorType == 0 ) {
        		helm = player.getCurrentArmor(i);
        	} 
        	else if (armorPiece.armorType == 1) {
        		chest = player.getCurrentArmor(i);
        	}
        	else if (armorPiece.armorType == 2 ) {
        		legs = player.getCurrentArmor(i);
        	}
        	else if (armorPiece.armorType == 3) {
        		boots = player.getCurrentArmor(i);
        	}
        } // end-for
        
		// Sterling Steel chest plate, leggings, and boots together grants the ability Jump 1
		 if (boots != null && legs != null && chest != null)
	        {

	            if ((chest.getItem() == SterlingAndBlackCore.sterlingSteelChest) 
	            	&& (legs.getItem() == SterlingAndBlackCore.sterlingSteelLegs) 
	            	&& (boots.getItem() == SterlingAndBlackCore.sterlingSteelBoots))
	            {
	                player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 40, 0));
	            }
	        }
		 
		 // Sterling Steel helmet, chest plate, and leggings together grants the magical (potion) ability Speed 1
	       if (helm != null && chest != null && legs != null)
	        {
	            if ( (helm.getItem() == SterlingAndBlackCore.sterlingSteelHelm)
	            		&& (chest.getItem() == SterlingAndBlackCore.sterlingSteelChest) 
	            		&& (legs.getItem() == SterlingAndBlackCore.sterlingSteelLegs))
	            {
	                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40, 0));
	            }
	        }

	       // full set of Black Silver armor grants the temporary enchantment of Dig Speed 1
	       if (helm != null && chest != null && legs != null && boots != null)
	        {

	            if (helm.getItem() == SterlingAndBlackCore.blackSilverHelm 
	            		&& chest.getItem() == SterlingAndBlackCore.blackSilverChest 
	            		&& legs.getItem() == SterlingAndBlackCore.blackSilverLegs 
	            		&& boots.getItem() == SterlingAndBlackCore.blackSilverBoots)
	            {
	                player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 40, 0));
	            }
	        }
	} // end onArmorTick

	
} // end class SimpleArmorWithEffect
