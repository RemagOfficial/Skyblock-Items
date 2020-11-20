package net.mcreator.skyblockitems.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.skyblockitems.SkyblockitemsModVariables;
import net.mcreator.skyblockitems.SkyblockitemsModElements;

import java.util.Map;
import java.util.HashMap;

@SkyblockitemsModElements.ModElement.Tag
public class VoidWorldResetVarProcedure extends SkyblockitemsModElements.ModElement {
	public VoidWorldResetVarProcedure(SkyblockitemsModElements instance) {
		super(instance, 154);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure VoidWorldResetVar!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		SkyblockitemsModVariables.MapVariables.get(world).VoidWorld = (double) 0;
		SkyblockitemsModVariables.MapVariables.get(world).syncData(world);
	}

	@SubscribeEvent
	public void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", entity.getPosX());
		dependencies.put("y", entity.getPosY());
		dependencies.put("z", entity.getPosZ());
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
