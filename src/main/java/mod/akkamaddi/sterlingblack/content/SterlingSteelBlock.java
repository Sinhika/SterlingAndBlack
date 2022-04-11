package mod.akkamaddi.sterlingblack.content;

import java.util.Random;

import mod.akkamaddi.sterlingblack.config.SterlingBlackConfig;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SterlingSteelBlock extends Block
{
    public static final int sterlingSteelLightLevel = (int) (0.8F * 15.0F);
    
    public SterlingSteelBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand)
    {
        if (worldIn.isClientSide && SterlingBlackConfig.makeMeSparkle)
        {
            super.animateTick(stateIn, worldIn, pos, rand);
            float f1 = (float)pos.getX() - 0.5F;
            float f2 = (float)pos.getY() - 0.5F;
            float f3 = (float)pos.getZ() - 0.5F;
            float f4 = rand.nextFloat() * 2.0f;
            float f5 = rand.nextFloat() * 2.0f;
            float f6 = rand.nextFloat() * 2.0f;
            worldIn.addParticle(ParticleTypes.INSTANT_EFFECT, (double)(f1 + f4), (double)(f2 + f5) , (double)(f3 + f6), 0.0D, 0.0D, 0.0D);
        }
    } // end animateTick()

    
} // end class
