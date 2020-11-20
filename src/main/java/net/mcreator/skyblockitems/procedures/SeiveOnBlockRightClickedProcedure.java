package net.mcreator.skyblockitems.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.skyblockitems.item.PebbleItem;
import net.mcreator.skyblockitems.item.IronchunkItem;
import net.mcreator.skyblockitems.item.DiamondchunkItem;
import net.mcreator.skyblockitems.block.SandModBlock;
import net.mcreator.skyblockitems.block.GravelModBlock;
import net.mcreator.skyblockitems.block.DirtModBlock;
import net.mcreator.skyblockitems.SkyblockitemsModElements;

import java.util.Map;

@SkyblockitemsModElements.ModElement.Tag
public class SeiveOnBlockRightClickedProcedure extends SkyblockitemsModElements.ModElement {
	public SeiveOnBlockRightClickedProcedure(SkyblockitemsModElements instance) {
		super(instance, 113);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SeiveOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((new ItemStack(DirtModBlock.block, (int) (1))
				.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
			if ((Math.random() < 0.25)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(PebbleItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(DirtModBlock.block, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
			}
		} else if ((new ItemStack(GravelModBlock.block, (int) (1))
				.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
			if ((Math.random() < 0.1)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(IronchunkItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(GravelModBlock.block, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
			} else if ((Math.random() < 0.008)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(DiamondchunkItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(GravelModBlock.block, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
			} else if ((Math.random() < 0.89)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(GravelModBlock.block, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
			}
		} else if ((new ItemStack(SandModBlock.block, (int) (1))
				.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
			if ((Math.random() < 0.5)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(IronchunkItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(SandModBlock.block, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
			} else {
				if ((Math.random() < 0.5)) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(SandModBlock.block, (int) (1));
						((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
					}
				}
			}
		}
	}
}
