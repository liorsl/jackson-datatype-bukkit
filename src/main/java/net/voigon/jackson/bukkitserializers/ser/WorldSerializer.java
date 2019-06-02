package net.voigon.jackson.bukkitserializers.ser;

import java.io.IOException;

import org.bukkit.World;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class WorldSerializer extends StdSerializer<World> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3802302242810155818L;

	protected WorldSerializer() {
		super(World.class);

	}

	@Override
	public void serialize(World arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException {
		arg1.writeString(arg0.getName());

	}

}
