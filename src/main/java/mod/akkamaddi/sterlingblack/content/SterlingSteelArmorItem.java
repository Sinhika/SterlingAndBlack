package mod.akkamaddi.sterlingblack.content;

import java.util.List;

import com.google.common.collect.ImmutableList;

import mod.alexndr.simplecorelib.api.helpers.ArmorUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SterlingSteelArmorItem extends ArmorItem
{
    private static final ImmutableList<EquipmentSlot> jump_list = 
            ImmutableList.of(EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET);
    private static final ImmutableList<EquipmentSlot> move_list = 
            ImmutableList.of(EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.HEAD);
    
    protected static int jumpBoostFactor = 0;
    protected static int moveSpeedFactor = 0;
    
    public SterlingSteelArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder)
    {
        super(materialIn, slot, builder);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(Component.translatable("sterlingblack.sterlingsteel_armor.info"));
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player)
    {
        super.onArmorTick(stack, world, player);
        
        if (ArmorUtils.isPlayerWearingPartialSet(player, getMaterial(), jump_list ))
        {
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 2, jumpBoostFactor, false, false));
        }
        if (ArmorUtils.isPlayerWearingPartialSet(player, getMaterial(), move_list ))
        {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2, moveSpeedFactor, false, false));
        }
    } // onArmorTick()

    
} // end class
