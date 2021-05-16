package mod.akkamaddi.sterlingblack;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

import java.util.List;

import javax.annotation.Nonnull;

/**
 * Assorted common utility code
 *
 */
public final class ModUtil
{

    /**
     * Is player wearing a partial set of the same armor material?
     * TODO: remove this when a new version of SimpleCoreLib with ArmorUtils.isPlayerWearingPartialSet() is released.
     * 
     * @param[in] slot_list list of slots required.
     * @return boolean
     */
    @Deprecated
    public static boolean isPlayerWearingPartialSet(PlayerEntity player, @Nonnull IArmorMaterial material,
            @Nonnull Iterable<EquipmentSlotType> slot_list)
    {
        List<ItemStack> armorList = (List<ItemStack>) player.getArmorSlots();
        for (EquipmentSlotType slot : slot_list)
        {
            ItemStack stack = armorList.get(slot.getIndex());
            if (stack.isEmpty()) { return false; }
            if (!(stack.getItem() instanceof ArmorItem)) { return false; }
            ArmorItem piece = (ArmorItem) stack.getItem();
            IArmorMaterial pieceMaterial = piece.getMaterial();
            if (pieceMaterial != material)
            {
                return false;
            }
        }
        return true;
    } // end ()

} // end class ModUtil
