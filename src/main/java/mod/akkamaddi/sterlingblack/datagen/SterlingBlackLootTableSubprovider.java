package mod.akkamaddi.sterlingblack.datagen;

import mod.akkamaddi.sterlingblack.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.SimpleBlockLootSubProvider;

public class SterlingBlackLootTableSubprovider extends SimpleBlockLootSubProvider
{

	@Override
	protected void generate() {
		dropSelf(ModBlocks.sterling_steel_block.get());
		dropSelf(ModBlocks.black_silver_block.get());
	}

} // end class
