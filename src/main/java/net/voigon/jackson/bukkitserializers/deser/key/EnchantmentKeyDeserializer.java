package net.voigon.jackson.bukkitserializers.deser.key;

import java.io.IOException;

import org.bukkit.enchantments.Enchantment;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

public class EnchantmentKeyDeserializer extends KeyDeserializer {
	
	private NamespacedKeyKeyDeserializer
			namespacedDeserializer = new NamespacedKeyKeyDeserializer();
	
	@Override
	public Enchantment deserializeKey(String key, DeserializationContext ctxt) throws IOException {
		return Enchantment.getByKey(namespacedDeserializer.deserializeKey(key, ctxt));
	}

}