package net.voigon.jackson.bukkitserializers.deser.key;

import java.io.IOException;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import net.voigon.jackson.bukkitserializers.BukkitModule;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class OfflinePlayerKeyDeserializer extends KeyDeserializer {

	final BukkitModule
			module;

	@SuppressWarnings("deprecation")
	@Override
	public OfflinePlayer deserializeKey(String key, DeserializationContext ctxt) throws IOException {
		try {
			// Trying to use UUID
			return module.getServer().getOfflinePlayer(UUID.fromString(key));
		} catch (IllegalArgumentException e) {
			// Fallback to name
			return module.getServer().getOfflinePlayer(key);
		}
	}

}
