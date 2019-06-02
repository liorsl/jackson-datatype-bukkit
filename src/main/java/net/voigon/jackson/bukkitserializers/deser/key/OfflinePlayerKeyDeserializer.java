package net.voigon.jackson.bukkitserializers.deser.key;

import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

public class OfflinePlayerKeyDeserializer extends KeyDeserializer {

	@SuppressWarnings("deprecation")
	@Override
	public OfflinePlayer deserializeKey(String key, DeserializationContext ctxt) throws IOException {
		try {
			// Trying to use UUID
			return Bukkit.getOfflinePlayer(UUID.fromString(key));
		} catch (IllegalArgumentException e) {
			// Fallback to name
			return Bukkit.getOfflinePlayer(key);
		}
	}

}
