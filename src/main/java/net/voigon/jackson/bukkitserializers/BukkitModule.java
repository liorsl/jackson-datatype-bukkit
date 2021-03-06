package net.voigon.jackson.bukkitserializers;

import lombok.Getter;
import net.voigon.jackson.bukkitserializers.internal.CraftTypeResolver;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import com.fasterxml.jackson.databind.module.SimpleModule;

import net.voigon.jackson.bukkitserializers.deser.BukkitDeserializer;
import net.voigon.jackson.bukkitserializers.deser.BukkitDeserializers;
import net.voigon.jackson.bukkitserializers.deser.key.BukkitKeyDeserializers;
import net.voigon.jackson.bukkitserializers.ser.BukkitSerializer;
import net.voigon.jackson.bukkitserializers.ser.BukkitSerializers;
import net.voigon.jackson.bukkitserializers.ser.key.BukkitKeySerializers;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BukkitModule extends SimpleModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = -691716720754398590L;

	@Getter
	final Server
			server;

	/**
	 * Construct a new instance of BukkitModule with specified Bukkit's server instance.
	 *
	 * @param server server instance to use with the module
	 */
	public BukkitModule(Server server) {
		this.server = server;

		CraftTypeResolver resolver = new CraftTypeResolver();
		resolver.addMapping(World.class, "CraftWorld");
		resolver.addMapping(Player.class, "entity.CraftPlayer");
		resolver.addMapping(OfflinePlayer.class, "CraftOfflinePlayer");
		resolver.addMapping(Chunk.class, "CraftChunk");
		resolver.addMapping(Block.class, "block.CraftBlock");
		setAbstractTypes(resolver);

		setDeserializers(new BukkitDeserializers(this));
		setSerializers(new BukkitSerializers(this));

		setKeyDeserializers(new BukkitKeyDeserializers(this));
		setKeySerializers(new BukkitKeySerializers(this));

		registerWithBukkit(Location.class);
		registerWithBukkit(ItemStack.class);

	}

	/**
	 * Constructs a new BukkitModule instance, using Server from Bukkit#getServer.
	 *
	 */
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
