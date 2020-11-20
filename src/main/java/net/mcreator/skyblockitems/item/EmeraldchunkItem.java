
package net.mcreator.skyblockitems.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.skyblockitems.itemgroup.SkyblockitemsItemGroup;
import net.mcreator.skyblockitems.SkyblockitemsModElements;

@SkyblockitemsModElements.ModElement.Tag
public class EmeraldchunkItem extends SkyblockitemsModElements.ModElement {
	@ObjectHolder("skyblockitems:emeraldchunk")
	public static final Item block = null;
	public EmeraldchunkItem(SkyblockitemsModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SkyblockitemsItemGroup.tab).maxStackSize(63).rarity(Rarity.COMMON));
			setRegistryName("emeraldchunk");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
