
package net.mcreator.skyblockitems.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.skyblockitems.procedures.CrookBlockDestroyedWithToolProcedure;
import net.mcreator.skyblockitems.itemgroup.SkyblockitemsItemGroup;
import net.mcreator.skyblockitems.SkyblockitemsModElements;

import java.util.Map;
import java.util.HashMap;

import com.google.common.collect.Multimap;

@SkyblockitemsModElements.ModElement.Tag
public class CrookItem extends SkyblockitemsModElements.ModElement {
	@ObjectHolder("skyblockitems:crook")
	public static final Item block = null;
	public CrookItem(SkyblockitemsModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {
			@Override
			public boolean onBlockDestroyed(ItemStack itemstack, World world, BlockState bl, BlockPos pos, LivingEntity entity) {
				boolean retval = super.onBlockDestroyed(itemstack, world, bl, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					CrookBlockDestroyedWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("crook"));
	}
	private static class ItemToolCustom extends Item {
		protected ItemToolCustom() {
			super(new Item.Properties().group(SkyblockitemsItemGroup.tab).maxDamage(256));
		}

		@Override
		public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
			if (blockstate.getBlock() == Blocks.OAK_LEAVES.getDefaultState().getBlock())
				return 100f;
			if (blockstate.getBlock() == Blocks.OAK_LEAVES.getDefaultState().getBlock())
				return 100f;
			if (blockstate.getBlock() == Blocks.SPRUCE_LEAVES.getDefaultState().getBlock())
				return 100f;
			if (blockstate.getBlock() == Blocks.BIRCH_LEAVES.getDefaultState().getBlock())
				return 100f;
			if (blockstate.getBlock() == Blocks.JUNGLE_LEAVES.getDefaultState().getBlock())
				return 100f;
			if (blockstate.getBlock() == Blocks.ACACIA_LEAVES.getDefaultState().getBlock())
				return 100f;
			if (blockstate.getBlock() == Blocks.ACACIA_LEAVES.getDefaultState().getBlock())
				return 100f;
			if (blockstate.getBlock() == Blocks.DARK_OAK_LEAVES.getDefaultState().getBlock())
				return 100f;
			return 1;
		}

		@Override
		public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
			stack.damageItem(1, entityLiving, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			return true;
		}

		@Override
		public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
			stack.damageItem(2, attacker, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			return true;
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
			Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
			if (equipmentSlot == EquipmentSlotType.MAINHAND) {
				multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
						new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", -2f, AttributeModifier.Operation.ADDITION));
				multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
						new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", -3, AttributeModifier.Operation.ADDITION));
			}
			return multimap;
		}
	}
}
