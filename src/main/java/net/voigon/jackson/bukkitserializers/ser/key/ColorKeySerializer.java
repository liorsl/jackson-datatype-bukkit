package net.voigon.jackson.bukkitserializers.ser.key;

import java.io.IOException;

import org.bukkit.Color;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ColorKeySerializer extends JsonSerializer<Color> {

	@Override
	public void serialize(Color value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeNumber(value.asRGB());
		
	}

	@Override
	public Class<Color> handledType() {
		return Color.class;
	}
}
