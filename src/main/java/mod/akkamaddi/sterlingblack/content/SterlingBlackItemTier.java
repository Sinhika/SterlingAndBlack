package mod.akkamaddi.sterlingblack.content;

import java.util.function.Supplier;

import mod.akkamaddi.sterlingblack.init.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

public enum SterlingBlackItemTier implements IItemTier
{
   STERLING_STEEL(3, 660, 10.0F, 2.0F, 26, ()->{ return Ingredient.fromItems( ModItems.sterling_steel_ingot.get()); }),
   BLACK_SILVER(5, 3460, 16.0F, 6.0F, 22, ()->{ return Ingredient.fromItems( ModItems.black_silver_ingot.get()); });

   private final int harvestLevel;
   private final int maxUses;
   private final float efficiency;
   private final float attackDamage;
   private final int enchantability;
   private final LazyLoadBase<Ingredient> repairMaterial;

   private SterlingBlackItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn,
                    Supplier<Ingredient> repairMaterialIn)
   {
      this.harvestLevel = harvestLevelIn;
      this.maxUses = maxUsesIn;
      this.efficiency = efficiencyIn;
      this.attackDamage = attackDamageIn;
      this.enchantability = enchantabilityIn;
      this.repairMaterial = new LazyLoadBase<>(repairMaterialIn);
   }

   @Override
   public int getMaxUses() {
      return this.maxUses;
   }

   @Override
   public float getEfficiency() {
      return this.efficiency;
   }

   @Override
   public float getAttackDamage() {
      return this.attackDamage;
   }

   @Override
   public int getHarvestLevel() {
      return this.harvestLevel;
   }

   @Override
   public int getEnchantability() {
      return this.enchantability;
   }

   @Override
   public Ingredient getRepairMaterial() {
      return this.repairMaterial.getValue();
   }
}  // end class SimpleOresItemTier
