package net.voigon.jackson.bukkitserializers.deser;

import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class OfflinePlayerDeserializer extends StdDeserializer<OfflinePlayer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6572656477019323030L;

	protected OfflinePlayerDeserializer() {
		super(OfflinePlayer.class);

	}

	@Override
	public OfflinePlayer deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		
		return Bukkit.getOfflinePlayer(arg0.readValueAs(UUID.class));
	}

}
