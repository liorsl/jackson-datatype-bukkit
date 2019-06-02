package net.voigon.jackson.bukkitserializers.ser.key;

import com.fasterxml.jackson.databind.module.SimpleSerializers;
import net.voigon.jackson.bukkitserializers.BukkitModule;

public class BukkitKeySerializers extends SimpleSerializers {

	/**
	 * 
	 */
	private static final long serialVersionUID = -894322032401482319L;

	public BukkitKeySerializers(BukkitModule module) {
		addSerializer(new ChunkKeySerializer());
		addSerializer(new ColorKeySerializer());
	}
}
