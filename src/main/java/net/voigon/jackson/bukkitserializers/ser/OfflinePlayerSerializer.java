package net.voigon.jackson.bukkitserializers.ser;

import java.io.IOException;

import org.bukkit.OfflinePlayer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class OfflinePlayerSerializer extends StdSerializer<OfflinePlayer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1223259305768814145L;

	protected OfflinePlayerSerializer() {
		super(OfflinePlayer.class);

	}

	@Override
	public void serialize(OfflinePlayer arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException {
		arg1.writeObject(arg0.getUniqueId());
		
	}

}
