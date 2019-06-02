package net.voigon.jackson.bukkitserializers.ser;

import java.io.IOException;

import org.bukkit.NamespacedKey;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class NamespacedKeySerializer extends StdSerializer<NamespacedKey> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6935605258382232936L;

	protected NamespacedKeySerializer() {
		super(NamespacedKey.class);
		
	}

	@Override
	public void serialize(NamespacedKey value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(value.toString());
		
	}

}
