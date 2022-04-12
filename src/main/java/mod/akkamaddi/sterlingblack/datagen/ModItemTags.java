package mod.akkamaddi.sterlingblack.datagen;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import mod.alexndr.simplecorelib.datagen.MiningItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends MiningItemTags
{

    public ModItemTags(DataGenerator gen, ExistingFileHelper existingFileHelper)
    {
        super(gen, new ModBlockTags(gen, existingFileHelper), SterlingAndBlack.MODID, existingFileHelper);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void addTags()
    {
        // TODO Auto-generated method stub
        super.addTags();
    }

    
} // new class
