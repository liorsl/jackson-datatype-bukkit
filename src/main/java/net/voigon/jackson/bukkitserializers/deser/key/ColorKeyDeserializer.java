package net.voigon.jackson.bukkitserializers.deser.key;

import java.io.IOException;

import org.bukkit.Color;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

public class ColorKeyDeserializer extends KeyDeserializer {

	@Override
	public Color deserializeKey(String key, DeserializationContext ctxt) throws IOException {
		return Color.fromRGB(Integer.valueOf(key));
	}

}
