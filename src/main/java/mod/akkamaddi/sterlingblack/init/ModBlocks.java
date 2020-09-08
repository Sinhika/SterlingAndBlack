package mod.akkamaddi.sterlingblack.init;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import mod.alexndr.simpleores.api.content.SimpleMetalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

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
    public static final RegistryObject<SimpleMetalBlock> sterling_steel_block = BLOCKS.register("sterling_steel_block",
            () -> new SimpleMetalBlock(Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(7.0F, 12.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0)));
    public static final RegistryObject<SimpleMetalBlock> black_silver_block = BLOCKS.register("black_silver_block",
            () -> new SimpleMetalBlock(Block.Properties.create(Material.IRON, MaterialColor.BLACK)
                    .hardnessAndResistance(12.0F, 26.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0)));

}  // end class ModBlocks
