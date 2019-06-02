package net.voigon.jackson.bukkitserializers.ser;

import java.io.IOException;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class InventorySerializer extends StdSerializer<Inventory> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2187870792256660431L;

	protected InventorySerializer() {
		super(Inventory.class);

	}

	@Override
	public void serialize(Inventory value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeObjectField("type", value.getType());
		gen.writeNumberField("size", value.getSize());

		String title = value.getTitle();
		if (title != null && !title.isEmpty()) 
			gen.writeStringField("title", title);
		
		int maxStackSize = value.getMaxStackSize();
		if (maxStackSize != 64)
			gen.writeNumberField("maxStackSize", maxStackSize);
		
		gen.writeObjectField("content", value.getContents());
		gen.writeEndObject();
		
	}

}
