
package net.mcreator.skyblockitems.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.skyblockitems.item.CrookItem;
import net.mcreator.skyblockitems.SkyblockitemsModElements;

@SkyblockitemsModElements.ModElement.Tag
public class SkyblockitemsItemGroup extends SkyblockitemsModElements.ModElement {
	public SkyblockitemsItemGroup(SkyblockitemsModElements instance) {
		super(instance, 54);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabskyblockitems") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CrookItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
