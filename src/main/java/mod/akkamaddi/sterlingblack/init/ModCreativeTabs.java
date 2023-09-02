package mod.akkamaddi.sterlingblack.init;

import mod.akkamaddi.sterlingblack.SterlingAndBlack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class ModCreativeTabs
{

//    public static final CreativeModeTab MOD_ITEM_GROUP = 
//            new ModTabGroup(SterlingAndBlack.MODID, () -> new ItemStack(ModItems.black_silver_ingot.get()));

	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SterlingAndBlack.MODID);
	
	public static final RegistryObject<CreativeModeTab> STERLINGBLACK_TAB = CREATIVE_MODE_TABS.register("sterlingblack_tab",
			() -> CreativeModeTab.builder()
				.title(Component.translatable("item_group." + SterlingAndBlack.MODID + ".tab"))
				.icon(() -> new ItemStack(ModItems.black_silver_ingot.get()))
				.displayItems((parameters, output) -> {
					output.acceptAll(ModBlocks.BLOCKS.getEntries().stream()
										.map(RegistryObject::get)
										.map(b -> (new ItemStack(b.asItem())))
										.toList()
										);
					output.acceptAll(ModItems.ITEMS.getEntries().stream()
							.map(RegistryObject::get)
							.map(b -> (new ItemStack(b)))
							.toList()
							);
				}).build());

}  // end class ModTabGroup
