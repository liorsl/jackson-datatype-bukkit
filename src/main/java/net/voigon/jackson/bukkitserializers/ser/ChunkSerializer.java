package net.voigon.jackson.bukkitserializers.ser;

import java.io.IOException;

import org.bukkit.Chunk;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ChunkSerializer extends StdSerializer<Chunk> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5214621672418684212L;

	protected ChunkSerializer() {
		super(Chunk.class);

	}

	@Override
	public void serialize(Chunk arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException {
		arg1.writeStartObject();
		arg1.writeNumberField("x", arg0.getX());
		arg1.writeNumberField("z", arg0.getZ());
		arg1.writeObjectField("world", arg0.getWorld());
		
	}

}
