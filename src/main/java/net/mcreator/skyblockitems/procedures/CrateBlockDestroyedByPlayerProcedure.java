package net.mcreator.skyblockitems.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.skyblockitems.item.TinyslimeItem;
import net.mcreator.skyblockitems.item.TinymagmaItem;
import net.mcreator.skyblockitems.item.ShammerItem;
import net.mcreator.skyblockitems.item.QuartzchunkItem;
import net.mcreator.skyblockitems.item.LapischunkItem;
import net.mcreator.skyblockitems.item.EmeraldchunkItem;
import net.mcreator.skyblockitems.item.DiamondchunkItem;
import net.mcreator.skyblockitems.SkyblockitemsModElements;

import java.util.Map;

@SkyblockitemsModElements.ModElement.Tag
public class CrateBlockDestroyedByPlayerProcedure extends SkyblockitemsModElements.ModElement {
	public CrateBlockDestroyedByPlayerProcedure(SkyblockitemsModElements instance) {
		super(instance, 93);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CrateBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure CrateBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure CrateBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure CrateBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure CrateBlockDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((new ItemStack(ShammerItem.block, (int) (1))
				.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
			if ((Math.random() < 0.1)) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(DiamondchunkItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else {
				if ((Math.random() < 0.1)) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(LapischunkItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				} else {
					if ((Math.random() < 0.1)) {
						if (!world.getWorld().isRemote) {
							ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(QuartzchunkItem.block, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					} else {
						if ((Math.random() < 0.1)) {
							if (!world.getWorld().isRemote) {
								ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z,
										new ItemStack(EmeraldchunkItem.block, (int) (1)));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						} else {
							if ((Math.random() < 0.1)) {
								if (!world.getWorld().isRemote) {
									ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z,
											new ItemStack(TinyslimeItem.block, (int) (1)));
									entityToSpawn.setPickupDelay((int) 10);
									world.addEntity(entityToSpawn);
								}
							} else {
								if ((Math.random() < 0.1)) {
									if (!world.getWorld().isRemote) {
										ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z,
												new ItemStack(TinymagmaItem.block, (int) (1)));
										entityToSpawn.setPickupDelay((int) 10);
										world.addEntity(entityToSpawn);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
