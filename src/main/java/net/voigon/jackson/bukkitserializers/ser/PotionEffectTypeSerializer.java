package net.voigon.jackson.bukkitserializers.ser;

import java.io.IOException;

import org.bukkit.potion.PotionEffectType;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class PotionEffectTypeSerializer extends StdSerializer<PotionEffectType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9058475412554899315L;

	protected PotionEffectTypeSerializer() {
		super(PotionEffectType.class);

	}

	@Override
	public void serialize(PotionEffectType value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(value.getName());
		
	}

}
