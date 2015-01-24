package akkamaddi.plugins.sterlingandblack;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alexndr.SimpleOres.api.content.SimpleBlock;

public class BlackStorageBlock extends SimpleBlock
{
    /**
     * The main constructor for the blocks.
     *
     * @param material = The material of the block. This sets what tools are effective against it, the sounds it makes, etc.
     */
    public BlackStorageBlock(Material material, String mod)
    {
        super(material);
        modId(mod);
        setHardness(12.0F);
        setResistance(26.0F);
        setStepSound(Block.soundTypeMetal);
        setBlockName("blockBlackSilver");
        setCreativeTab(SterlingAndBlack.tabAkkamaddiSterling);
        setAsBeaconBase(true);
    }
}
