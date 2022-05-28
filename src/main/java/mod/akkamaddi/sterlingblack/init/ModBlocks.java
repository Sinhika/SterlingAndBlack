package mod.akkamaddi.sterlingblack.init;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import mod.akkamaddi.sterlingblack.content.SterlingSteelBlock;
import mod.alexndr.simplecorelib.api.helpers.LightUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Holds a list of all our {@link Block}s.
 * Suppliers that create Blocks are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Block Registry Event is fired by Forge and it is time for the mod to
 * register its Blocks, our Blocks are created and registered by the DeferredRegister.
 * The Block Registry Event will always be called before the Item registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo
 */
public final class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = 
           DeferredRegister.create(ForgeRegistries.BLOCKS, SterlingAndBlack.MODID);

    // Metal Blocks
    public static final RegistryObject<SterlingSteelBlock> sterling_steel_block = BLOCKS.register("sterling_steel_block",
            () -> new SterlingSteelBlock(Block.Properties.of(Material.METAL)
                    .strength(7.0F, 12.0F)
                    .lightLevel(LightUtils.setFixedLight(SterlingSteelBlock.sterlingSteelLightLevel)).requiresCorrectToolForDrops()));
                    //.harvestTool(ToolType.PICKAXE).harvestLevel(0)));
    public static final RegistryObject<Block> black_silver_block = BLOCKS.register("black_silver_block",
            () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK)
                    .strength(12.0F, 26.0F).requiresCorrectToolForDrops()));
                    //.harvestTool(ToolType.PICKAXE).harvestLevel(0)));

}  // end class ModBlocks
