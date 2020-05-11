package net.voigon.jackson.bukkitserializers.ser.key;

import java.io.IOException;

import org.bukkit.Chunk;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ChunkKeySerializer extends JsonSerializer<Chunk> {
	
	protected ChunkKeySerializer() {
	}
	
	@Override
	public void serialize(Chunk value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeFieldName(value.getWorld().getName() + "," + value.getX() + "," + value.getZ());
		
	}

	@Override
	public Class<Chunk> handledType() {
		return Chunk.class;
	}
}
