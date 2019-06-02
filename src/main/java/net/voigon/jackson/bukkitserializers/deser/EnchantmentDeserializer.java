package net.voigon.jackson.bukkitserializers.deser;

import java.io.IOException;

import org.bukkit.enchantments.Enchantment;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.voigon.jackson.bukkitserializers.deser.key.EnchantmentKeyDeserializer;

public class EnchantmentDeserializer extends StdDeserializer<Enchantment> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1230742596754987801L;

	private EnchantmentKeyDeserializer
			keyDeserializer = new EnchantmentKeyDeserializer();
	
	protected EnchantmentDeserializer() {
		super(Enchantment.class);

	}

	@Override
	public Enchantment deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return keyDeserializer.deserializeKey(p.getText(), ctxt);
	}

}
