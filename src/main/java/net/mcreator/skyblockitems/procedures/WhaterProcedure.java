package net.mcreator.skyblockitems.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.skyblockitems.SkyblockitemsModElements;

import java.util.Map;

@SkyblockitemsModElements.ModElement.Tag
public class WhaterProcedure extends SkyblockitemsModElements.ModElement {
	public WhaterProcedure(SkyblockitemsModElements instance) {
		super(instance, 137);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Whater!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"fill ~ ~ ~ ~5 ~4 ~5 minecraft:glass");
			}
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
