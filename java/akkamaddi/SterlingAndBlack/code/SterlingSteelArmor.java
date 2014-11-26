package akkamaddi.SterlingAndBlack.code;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import akkamaddi.akkamaddiCore.api.SimpleArmorWithEffect;

public class SterlingSteelArmor extends SimpleArmorWithEffect {

	public SterlingSteelArmor(ArmorMaterial armormaterial, int renderer,
			int slotnumber) 
	{
		super(armormaterial, renderer, slotnumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player,
						    ItemStack itemStack) 
	{
		ItemStack [] armorbits = new ItemStack[4];
		SimpleArmorWithEffect.getArmorPieces(player, armorbits);
		for (int i=0; i < 4; i++) {
			if (armorbits[i] == null) return;
		}
		if (armorbits[ARMOR_TYPE.CHEST.ordinal()].getItem() == SterlingAndBlackCore.sterlingSteelChest
				&& armorbits[ARMOR_TYPE.LEGS.ordinal()].getItem() == SterlingAndBlackCore.sterlingSteelLegs
				&& armorbits[ARMOR_TYPE.BOOTS.ordinal()].getItem() == SterlingAndBlackCore.sterlingSteelBoots) 
		{
            player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 40, 0));
		}		
		if (armorbits[ARMOR_TYPE.HELM.ordinal()].getItem() == SterlingAndBlackCore.sterlingSteelHelm
				&& armorbits[ARMOR_TYPE.CHEST.ordinal()].getItem() == SterlingAndBlackCore.sterlingSteelChest
				&& armorbits[ARMOR_TYPE.LEGS.ordinal()].getItem() == SterlingAndBlackCore.sterlingSteelLegs) 
		{
            player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40, 0));
		}		
	} // end onArmorTick()

} // end class SterlingSteelArmor
