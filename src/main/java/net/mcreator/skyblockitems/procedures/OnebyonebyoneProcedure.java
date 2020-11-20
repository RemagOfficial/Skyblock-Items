package net.mcreator.skyblockitems.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.skyblockitems.SkyblockitemsModElements;

import java.util.Map;

@SkyblockitemsModElements.ModElement.Tag
public class OnebyonebyoneProcedure extends SkyblockitemsModElements.ModElement {
	public OnebyonebyoneProcedure(SkyblockitemsModElements instance) {
		super(instance, 135);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Onebyonebyone!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"fill ~ ~ ~ ~ ~ ~ minecraft:dirt");
			}
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
