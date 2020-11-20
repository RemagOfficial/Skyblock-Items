package net.mcreator.skyblockitems.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameRules;
import net.minecraft.entity.Entity;

import net.mcreator.skyblockitems.SkyblockitemsModElements;

import java.util.Map;

@SkyblockitemsModElements.ModElement.Tag
public class FallStopperItemInInventoryTickProcedure extends SkyblockitemsModElements.ModElement {
	public FallStopperItemInInventoryTickProcedure(SkyblockitemsModElements instance) {
		super(instance, 155);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure FallStopperItemInInventoryTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure FallStopperItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getWorld().getGameRules().getBoolean(GameRules.KEEP_INVENTORY)) == (true))) {
			entity.setMotion((entity.getMotion().getX()), 0, (entity.getMotion().getZ()));
		} else {
			world.getWorld().getGameRules().get(GameRules.KEEP_INVENTORY).set((true), world.getWorld().getServer());
			entity.setMotion((entity.getMotion().getX()), 0, (entity.getMotion().getZ()));
		}
	}
}
