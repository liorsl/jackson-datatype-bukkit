package net.voigon.jackson.bukkitserializers.deser.key;

import java.io.IOException;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import net.voigon.jackson.bukkitserializers.BukkitModule;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class PlayerKeyDeserializer extends KeyDeserializer {

	final BukkitModule
			module;

	@SuppressWarnings("deprecation")
	@Override
	public Player deserializeKey(String key, DeserializationContext ctxt) throws IOException {
		try {
			return module.getServer().getPlayer(UUID.fromString(key));
		} catch (IllegalArgumentException e) {
			return Bukkit.getPlayer(key);
		}
	}

}
