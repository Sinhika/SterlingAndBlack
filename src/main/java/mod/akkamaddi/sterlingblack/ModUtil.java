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
     * @param[in] slot_list list of slots required.
     * @return boolean
     */
    public static boolean isPlayerWearingPartialSet(PlayerEntity player, 
                                                    @Nonnull IArmorMaterial material, 
                                                    @Nonnull Iterable<EquipmentSlotType> slot_list)
    {
        List<ItemStack> armorList = (List<ItemStack>) player.getArmorInventoryList();
        for (EquipmentSlotType slot: slot_list)
        {
            ArmorItem piece = (ArmorItem) armorList.get(slot.getIndex()).getItem();
            IArmorMaterial pieceMaterial = piece.getArmorMaterial();
            if (pieceMaterial != material) {
                return false;
            }
        }
        return true;
    } // end ()
    
    /**
     * Is player wearing a full set of the same armor material?
     * @return boolean
     */
    public static boolean isPlayerWearingFullSet(PlayerEntity player, @Nonnull IArmorMaterial material)
    {
        Iterable<ItemStack> armorList = player.getArmorInventoryList();
        for (ItemStack stack : armorList)
        {
            if (stack.isEmpty()) { return false; }
            if (! (stack.getItem() instanceof ArmorItem)) { return false; }
            ArmorItem piece = (ArmorItem) stack.getItem();
            IArmorMaterial pieceMaterial = piece.getArmorMaterial();
            if (pieceMaterial != material) {
                return false;
            }
        } // end-for
        return true;
    } // end isPlayerWearingFullSet()
} // end class ModUtil
