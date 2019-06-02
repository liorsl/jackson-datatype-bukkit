package net.voigon.jackson.bukkitserializers.ser;

import java.io.IOException;

import org.bukkit.entity.Player;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class PlayerSerializer extends StdSerializer<Player> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4449935385759187169L;

	protected PlayerSerializer() {
		super(Player.class);

	}

	@Override
	public void serialize(Player value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeObject(value.getUniqueId());
		
	}

}
