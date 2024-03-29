package mod.akkamaddi.sterlingblack.content;

import java.util.function.Supplier;

import mod.akkamaddi.sterlingblack.init.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.util.Lazy;

public enum SterlingBlackArmorMaterial implements ArmorMaterial
{
    STERLING_STEEL ("sterlingblack:sterling_steel", 18, new int [] { 3, 5, 6, 3}, 28, SoundEvents.ARMOR_EQUIP_IRON, 1.0F,
            ()-> { return Ingredient.of(ModItems.sterling_steel_ingot.get());}, 0.0F),
    
    BLACK_SILVER ("sterlingblack:black_silver", 48, new int [] { 5, 7, 9, 5}, 11, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F,
            ()-> { return Ingredient.of(ModItems.black_silver_ingot.get());}, 0.0F );

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Lazy<Ingredient> repairMaterial;
    private final float knockbackResist;

    private SterlingBlackArmorMaterial(String nameIn, int maxDamageIn, int[] drAmtArray,
                                    int enchantabilityIn, SoundEvent soundIn,
                                    float toughnessIn,
                                    Supplier<Ingredient> repairMatIn, float knockbackIn)
    {
        name = nameIn;
        maxDamageFactor = maxDamageIn;
        damageReductionAmountArray = drAmtArray;
        enchantability = enchantabilityIn;
        soundEvent = soundIn;
        toughness = toughnessIn;
        repairMaterial = Lazy.of(repairMatIn);
        knockbackResist = knockbackIn;
    } // end ctor()

    @Override
    public int getDurabilityForType(Type pType) {
        return MAX_DAMAGE_ARRAY[pType.getSlot().getIndex()] * this.maxDamageFactor;
    }

    @Override
	public int getDefenseForType(Type pType) {
        return this.damageReductionAmountArray[pType.getSlot().getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance()
    {
        return this.knockbackResist;
    }

}  // end class SimpleOresArmorMaterial
