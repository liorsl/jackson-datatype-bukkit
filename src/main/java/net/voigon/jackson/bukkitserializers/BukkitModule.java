package net.voigon.jackson.bukkitserializers;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import com.fasterxml.jackson.databind.module.SimpleModule;

import net.voigon.jackson.bukkitserializers.deser.BukkitDeserializer;
import net.voigon.jackson.bukkitserializers.deser.BukkitDeserializers;
import net.voigon.jackson.bukkitserializers.deser.key.BukkitKeyDeserializers;
import net.voigon.jackson.bukkitserializers.ser.BukkitSerializer;
import net.voigon.jackson.bukkitserializers.ser.BukkitSerializers;
import net.voigon.jackson.bukkitserializers.ser.key.BukkitKeySerializers;

public class BukkitModule extends SimpleModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = -691716720754398590L;

	@Getter
	final Server
			server;

	public BukkitModule(Server server) {
		this.server = server;

		setDeserializers(new BukkitDeserializers(this));
		setSerializers(new BukkitSerializers(this));

		setKeyDeserializers(new BukkitKeyDeserializers(this));
		setKeySerializers(new BukkitKeySerializers(this));
		
	}

	public BukkitModule() {
		this(Bukkit.getServer());

	}
	
	/**
	 * Register a serializer and deserializer for specified type using Bukkit's serialization API.
	 * @param clazz the type of the clazz that should be added
	 * @return this instance of BukkitModule
	 */
	public <T extends ConfigurationSerializable> BukkitModule registerWithBukkit(Class<T> clazz) {
		_checkNotNull(clazz, "Class");
		
		addSerializer(new BukkitSerializer<>(clazz, null));
		addDeserializer(clazz, new BukkitDeserializer<>(clazz));
		return this;
	}
	
}
