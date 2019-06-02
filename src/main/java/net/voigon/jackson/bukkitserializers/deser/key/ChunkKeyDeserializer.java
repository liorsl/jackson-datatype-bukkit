package net.voigon.jackson.bukkitserializers.deser.key;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

public class ChunkKeyDeserializer extends KeyDeserializer {

	protected ChunkKeyDeserializer() {}
	
	@Override
	public Chunk deserializeKey(String key, DeserializationContext ctxt) throws IOException {
		String split[] = key.split(",");		
		return Bukkit.getWorld(split[0]).getChunkAt(Integer.valueOf(split[1]), Integer.valueOf(split[2]));
	}

}