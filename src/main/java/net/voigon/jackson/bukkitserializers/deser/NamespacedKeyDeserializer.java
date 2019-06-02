package net.voigon.jackson.bukkitserializers.deser;

import java.io.IOException;

import org.bukkit.NamespacedKey;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.voigon.jackson.bukkitserializers.deser.key.NamespacedKeyKeyDeserializer;

public class NamespacedKeyDeserializer extends StdDeserializer<NamespacedKey> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5421147430210414451L;

	private NamespacedKeyKeyDeserializer
			keyDeserializer = new NamespacedKeyKeyDeserializer();
	
	protected NamespacedKeyDeserializer() {
		super(NamespacedKey.class);

	}

	@Override
	public NamespacedKey deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return (NamespacedKey) keyDeserializer.deserializeKey(p.getText(), ctxt);
	}
	
}
