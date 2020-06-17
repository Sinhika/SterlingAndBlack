package akkamaddi.plugins.sterlingandblack;

import akkamaddi.api.core.SimpleArmorWithEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class SterlingSteelArmor extends SimpleArmorWithEffect 
{

	public SterlingSteelArmor(ArmorMaterial armormaterial, int slotnumber) 
	{
		super(armormaterial,slotnumber);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player,
						    ItemStack itemStack) 
	{
		ItemStack [] armorbits = new ItemStack[4];
		SimpleArmorWithEffect.getArmorPieces(player, armorbits);
		Item [] armorItem = new Item[4];
		for (int i=0; i < 4; i++) {
			if (armorbits[i] == null) {
				armorItem[i] = null;
			}
			else {
				armorItem[i] = armorbits[i].getItem();
			}
		}
		if (armorItem[ARMOR_TYPE.CHEST.ordinal()] == Content.sterlingSteelChest
				&& armorItem[ARMOR_TYPE.LEGS.ordinal()] == Content.sterlingSteelLegs
				&& armorItem[ARMOR_TYPE.BOOTS.ordinal()] == Content.sterlingSteelBoots) 
		{
            player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 40, 0));
		}		
		if (armorItem[ARMOR_TYPE.HELM.ordinal()] == Content.sterlingSteelHelm
				&& armorItem[ARMOR_TYPE.CHEST.ordinal()] == Content.sterlingSteelChest
				&& armorItem[ARMOR_TYPE.LEGS.ordinal()] == Content.sterlingSteelLegs) 
		{
            player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40, 0));
		}		
	} // end onArmorTick()

} // end class SterlingSteelArmor