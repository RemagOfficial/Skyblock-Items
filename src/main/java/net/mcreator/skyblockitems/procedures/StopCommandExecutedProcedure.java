package net.mcreator.skyblockitems.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.skyblockitems.SkyblockitemsModElements;

import java.util.Map;

@SkyblockitemsModElements.ModElement.Tag
public class StopCommandExecutedProcedure extends SkyblockitemsModElements.ModElement {
	public StopCommandExecutedProcedure(SkyblockitemsModElements instance) {
		super(instance, 101);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure StopCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("skyblockitems:skyblockitemsadv")))
						.isDone()
				: false)) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"advancement revoke @p from skyblockitems:skyblockitemsadv");
				}
			}
		}
	}
}
