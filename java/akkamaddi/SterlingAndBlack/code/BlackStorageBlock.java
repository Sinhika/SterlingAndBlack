package akkamaddi.SterlingAndBlack.code;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlackStorageBlock extends Block
{
    private String modName;
    /**
     * The main constructor for the blocks.
     *
     * @param material = The material of the block. This sets what tools are effective against it, the sounds it makes, etc.
     */
    public BlackStorageBlock(Material material, String mod)
    {
        super(material);
        this.modName = mod;
        setHardness(12.0F);
        setResistance(26.0F);
        setStepSound(Block.soundTypeMetal);
        setBlockName("blockBlackSilver");
        setCreativeTab(SterlingAndBlackCore.tabAkkamaddiSterling);
    }

    /**
     * Sets the texture for the block.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(modName + ":" + (this.getUnlocalizedName().substring(5)));
    }
}
