package net.voigon.jackson.bukkitserializers.deser.key;

import java.io.IOException;

import org.bukkit.potion.PotionEffectType;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

public class PotionEffectTypeKeyDeserializer extends KeyDeserializer {

	@Override
	public PotionEffectType deserializeKey(String key, DeserializationContext ctxt) throws IOException {
		return PotionEffectType.getByName(key);
	}

}
