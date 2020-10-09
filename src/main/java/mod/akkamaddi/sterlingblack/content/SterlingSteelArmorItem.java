package mod.akkamaddi.sterlingblack.content;

import java.util.List;

import com.google.common.collect.ImmutableList;

import mod.akkamaddi.sterlingblack.ModUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SterlingSteelArmorItem extends ArmorItem
{
    private static final ImmutableList<EquipmentSlotType> jump_list = 
            ImmutableList.of(EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET);
    private static final ImmutableList<EquipmentSlotType> move_list = 
            ImmutableList.of(EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.HEAD);
    
    protected static int jumpBoostFactor = 1;
    protected static int moveSpeedFactor = 1;
    
    public SterlingSteelArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder)
    {
        super(materialIn, slot, builder);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("sterlingblack.sterlingsteel_armor.info"));
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
    {
        super.onArmorTick(stack, world, player);
        
        if (ModUtil.isPlayerWearingPartialSet(player, getArmorMaterial(), jump_list ))
        {
            player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 2, jumpBoostFactor, false, false));
        }
        if (ModUtil.isPlayerWearingPartialSet(player, getArmorMaterial(), move_list ))
        {
            player.addPotionEffect(new EffectInstance(Effects.SPEED, 2, moveSpeedFactor, false, false));
        }
    } // onArmorTick()

    
} // end class
