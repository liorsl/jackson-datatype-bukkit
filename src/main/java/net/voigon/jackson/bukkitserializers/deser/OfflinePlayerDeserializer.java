package net.voigon.jackson.bukkitserializers.deser;

import java.io.IOException;
import java.util.UUID;

import net.voigon.jackson.bukkitserializers.BukkitModule;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.bukkit.Server;

public class OfflinePlayerDeserializer extends StdDeserializer<OfflinePlayer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6572656477019323030L;

	final Server
			server;

	protected OfflinePlayerDeserializer(BukkitModule module) {
		super(OfflinePlayer.class);

		this.server = module.getServer();
	}

	@Override
	public OfflinePlayer deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		
		return server.getOfflinePlayer(arg0.readValueAs(UUID.class));
	}

}
