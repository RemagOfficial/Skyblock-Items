package net.mcreator.skyblockitems.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.skyblockitems.item.FallStopperItem;
import net.mcreator.skyblockitems.SkyblockitemsModVariables;
import net.mcreator.skyblockitems.SkyblockitemsModElements;

import java.util.Map;

@SkyblockitemsModElements.ModElement.Tag
public class FallStopperGiverProcedure extends SkyblockitemsModElements.ModElement {
	public FallStopperGiverProcedure(SkyblockitemsModElements instance) {
		super(instance, 156);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure FallStopperGiver!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure FallStopperGiver!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((SkyblockitemsModVariables.MapVariables.get(world).VoidWorld) == 1)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(FallStopperItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
