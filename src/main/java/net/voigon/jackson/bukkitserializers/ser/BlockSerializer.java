package net.voigon.jackson.bukkitserializers.ser;

import java.io.IOException;

import org.bukkit.block.Block;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class BlockSerializer extends StdSerializer<Block> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7945332488907762679L;

	protected BlockSerializer() {
		super(Block.class);

	}

	@Override
	public void serialize(Block arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException {
		arg1.writeObject(arg0.getLocation());
		/*arg1.writeStartObject();
		arg1.writeNumberField("x", arg0.getX());
		arg1.writeNumberField("y", arg0.getY());
		arg1.writeNumberField("z", arg0.getZ());
		arg1.writeStringField("world", arg0.getWorld().getName());
		arg1.writeEndObject(); */
		
		
	}

}
