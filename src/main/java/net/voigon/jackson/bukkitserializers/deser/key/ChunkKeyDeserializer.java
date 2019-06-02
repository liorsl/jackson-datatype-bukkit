package net.voigon.jackson.bukkitserializers.deser.key;

import java.io.IOException;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import net.voigon.jackson.bukkitserializers.BukkitModule;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class ChunkKeyDeserializer extends KeyDeserializer {

	final BukkitModule
			module;

	@Override
	public Chunk deserializeKey(String key, DeserializationContext ctxt) throws IOException {
		String split[] = key.split(",");		
		return module.getServer().getWorld(split[0]).getChunkAt(Integer.valueOf(split[1]), Integer.valueOf(split[2]));
	}

}