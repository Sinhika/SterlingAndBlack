package mod.akkamaddi.sterlingblack.content;

import java.util.List;

import mod.alexndr.simplecorelib.api.helpers.ArmorUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class BlackSilverArmorItem extends ArmorItem
{
    protected static int mining_boost = 0;
    
    public BlackSilverArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder)
    {
        super(materialIn, slot, builder);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player)
    {
        super.onArmorTick(stack, world, player);
        if (ArmorUtils.isPlayerWearingFullSet(player, getMaterial()))
        {
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2, mining_boost, false, false));
        }
    } // end onArmorTick()

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslatableComponent("sterlingblack.blacksilver_armor.info"));
    }

    
} // end class
