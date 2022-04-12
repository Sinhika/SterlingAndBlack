package mod.akkamaddi.sterlingblack.datagen;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import mod.alexndr.simplecorelib.datagen.MiningBlockTags;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTags extends MiningBlockTags
{

    public ModBlockTags(DataGenerator gen, ExistingFileHelper existingFileHelper)
    {
        super(gen, SterlingAndBlack.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        // TODO Auto-generated method stub
        super.addTags();
    }

    @Override
    protected void registerMiningTags()
    {
        // TODO Auto-generated method stub

    }

    
} // end class
