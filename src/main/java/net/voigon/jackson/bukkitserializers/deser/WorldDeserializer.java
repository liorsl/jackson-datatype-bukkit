package net.voigon.jackson.bukkitserializers.deser;

import java.io.IOException;

import net.voigon.jackson.bukkitserializers.BukkitModule;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.World;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class WorldDeserializer extends StdDeserializer<World> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2307971027356822139L;

	final Server
			server;

	protected WorldDeserializer(BukkitModule module) {
		super(World.class);

		this.server = module.getServer();
	}

	@Override
	public World deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException, JsonProcessingException {
		return server.getWorld(arg0.readValueAs(String.class));
	}

}
