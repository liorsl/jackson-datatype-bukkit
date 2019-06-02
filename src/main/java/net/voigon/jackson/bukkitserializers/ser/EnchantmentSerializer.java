package net.voigon.jackson.bukkitserializers.ser;

import java.io.IOException;

import org.bukkit.enchantments.Enchantment;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class EnchantmentSerializer extends StdSerializer<Enchantment> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9110432595438806293L;

	protected EnchantmentSerializer() {
		super(Enchantment.class);
		
	}

	@Override
	public void serialize(Enchantment value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeObject(value.getKey());
		
	}

}
