package net.mcreator.skyblockitems.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.skyblockitems.item.BoneMealChunkItem;
import net.mcreator.skyblockitems.SkyblockitemsModVariables;
import net.mcreator.skyblockitems.SkyblockitemsModElements;

import java.util.Map;
import java.util.HashMap;

@SkyblockitemsModElements.ModElement.Tag
public class TimerProcedure extends SkyblockitemsModElements.ModElement {
	public TimerProcedure(SkyblockitemsModElements instance) {
		super(instance, 144);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Timer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Timer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		SkyblockitemsModVariables.MapVariables.get(world).timesec = (double) ((SkyblockitemsModVariables.MapVariables.get(world).timesec) + 0.05);
		SkyblockitemsModVariables.MapVariables.get(world).syncData(world);
		if ((((SkyblockitemsModVariables.MapVariables.get(world).timesec) >= 1) && (entity.isSneaking()))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(BoneMealChunkItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			SkyblockitemsModVariables.MapVariables.get(world).timesec = (double) 0;
			SkyblockitemsModVariables.MapVariables.get(world).syncData(world);
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
