package net.voigon.jackson.bukkitserializers.deser.key;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

public class NamespacedKeyKeyDeserializer extends KeyDeserializer {

	@SuppressWarnings("deprecation")
	@Override
	public NamespacedKey deserializeKey(String key, DeserializationContext ctxt) throws IOException {
		String string[] = key.split(":");
		if (string[0].equalsIgnoreCase(NamespacedKey.MINECRAFT))
			return NamespacedKey.minecraft(string[1]);
		else if (string[0].equalsIgnoreCase(NamespacedKey.BUKKIT))
			return new NamespacedKey(NamespacedKey.BUKKIT, string[1]);
		
		return new NamespacedKey(Bukkit.getPluginManager().getPlugin(string[0]), string[1]);
	}

}
