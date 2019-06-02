package net.voigon.jackson.bukkitserializers.deser.key;

import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

public class PlayerKeyDeserializer extends KeyDeserializer {

	@SuppressWarnings("deprecation")
	@Override
	public Player deserializeKey(String key, DeserializationContext ctxt) throws IOException {
		try {
			return Bukkit.getPlayer(UUID.fromString(key));
		} catch (IllegalArgumentException e) {
			return Bukkit.getPlayer(key);
		}
	}

}
