
package net.mcreator.skyblockitems.command;

import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.Entity;
import net.minecraft.command.Commands;
import net.minecraft.command.CommandSource;

import net.mcreator.skyblockitems.procedures.IslandGUIProcedure;
import net.mcreator.skyblockitems.SkyblockitemsModElements;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.arguments.StringArgumentType;

@SkyblockitemsModElements.ModElement.Tag
public class IsCommand extends SkyblockitemsModElements.ModElement {
	public IsCommand(SkyblockitemsModElements instance) {
		super(instance, 138);
	}

	@Override
	public void serverLoad(FMLServerStartingEvent event) {
		event.getCommandDispatcher().register(customCommand());
	}

	private LiteralArgumentBuilder<CommandSource> customCommand() {
		return LiteralArgumentBuilder.<CommandSource>literal("is").requires(s -> s.hasPermissionLevel(4))
				.then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(this::execute)).executes(this::execute);
	}

	private int execute(CommandContext<CommandSource> ctx) {
		ServerWorld world = ctx.getSource().getWorld();
		double x = ctx.getSource().getPos().getX();
		double y = ctx.getSource().getPos().getY();
		double z = ctx.getSource().getPos().getZ();
		Entity entity = ctx.getSource().getEntity();
		if (entity == null)
			entity = FakePlayerFactory.getMinecraft(world);
		HashMap<String, String> cmdparams = new HashMap<>();
		int[] index = {-1};
		Arrays.stream(ctx.getInput().split("\\s+")).forEach(param -> {
			if (index[0] >= 0)
				cmdparams.put(Integer.toString(index[0]), param);
			index[0]++;
		});
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			IslandGUIProcedure.executeProcedure($_dependencies);
		}
		return 0;
	}
}
