package mod.akkamaddi.sterlingblack.content;

import java.util.List;

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
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class BlackSilverArmorItem extends ArmorItem
{
    protected static int mining_boost = 1;
    
    public BlackSilverArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder)
    {
        super(materialIn, slot, builder);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
    {
        super.onArmorTick(stack, world, player);
        if (ModUtil.isPlayerWearingFullSet(player, getArmorMaterial()))
        {
            player.addPotionEffect(new EffectInstance(Effects.HASTE, 2, mining_boost, false, false));
        }
    } // end onArmorTick()

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("sterlingblack.blacksilver_armor.info").applyTextStyle(TextFormatting.GREEN));
    }

    
} // end class
