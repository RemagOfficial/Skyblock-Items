package net.mcreator.skyblockitems.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.skyblockitems.SkyblockitemsModVariables;
import net.mcreator.skyblockitems.SkyblockitemsModElements;

import java.util.Map;
import java.util.HashMap;

@SkyblockitemsModElements.ModElement.Tag
public class VoidWorldButtonClickProcedure extends SkyblockitemsModElements.ModElement {
	public VoidWorldButtonClickProcedure(SkyblockitemsModElements instance) {
		super(instance, 153);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure VoidWorldButtonClick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure VoidWorldButtonClick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		SkyblockitemsModVariables.MapVariables.get(world).VoidWorld = (double) 1;
		SkyblockitemsModVariables.MapVariables.get(world).syncData(world);
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			$_dependencies.put("world", world);
			FallStopperGiverProcedure.executeProcedure($_dependencies);
		}
	}
}
