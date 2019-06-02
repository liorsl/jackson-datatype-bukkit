package net.voigon.jackson.bukkitserializers.deser;

import java.io.IOException;

import org.bukkit.potion.PotionEffectType;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class PotionEffectTypeDeserializer extends StdDeserializer<PotionEffectType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7163781580020853846L;

	
	protected PotionEffectTypeDeserializer() {
		super(PotionEffectType.class);

	}

	@Override
	public PotionEffectType deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return PotionEffectType.getByName(p.getText());
	}

}
