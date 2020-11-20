package net.mcreator.skyblockitems.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.Entity;

import net.mcreator.skyblockitems.SkyblockitemsModElements;

import java.util.Map;

@SkyblockitemsModElements.ModElement.Tag
public class TinymagmablockEntityWalksOnTheBlockProcedure extends SkyblockitemsModElements.ModElement {
	public TinymagmablockEntityWalksOnTheBlockProcedure(SkyblockitemsModElements instance) {
		super(instance, 67);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure TinymagmablockEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure TinymagmablockEntityWalksOnTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity.isSneaking())) {
			world.addParticle(ParticleTypes.SMOKE, (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()), 0, 1, 0);
		} else {
			for (int index0 = 0; index0 < (int) (9999); index0++) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
			}
		}
	}
}
