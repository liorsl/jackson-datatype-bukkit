package net.voigon.jackson.bukkitserializers.ser;

import net.voigon.jackson.bukkitserializers.BukkitModule;
import net.voigon.jackson.bukkitserializers.internal.CraftTypeResolver;
import net.voigon.jackson.bukkitserializers.internal.NMSUtils;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.type.ClassKey;

public class BukkitSerializers extends SimpleSerializers {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8614884790302634085L;

	public BukkitSerializers(BukkitModule module) {
		addSerializer(new WorldSerializer());
		addSerializer(new BlockSerializer());
		addSerializer(new ChunkSerializer());
		addSerializer(new OfflinePlayerSerializer());
		addSerializer(new PlayerSerializer());

		addSerializer(new PotionEffectTypeSerializer());
		addSerializer(new EnchantmentSerializer());

		try {
			// Make sure the class exists
			Class.forName("org.bukkit.NamespacedKey");
			addSerializer(new NamespacedKeySerializer());
		} catch (Exception e) {}

		BaseComponentSerializer md5_component = new BaseComponentSerializer();
		addSerializer(md5_component);
		addSerializer(md5_component.new SingleBaseComponentSerializer());

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JsonSerializer<?> findSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc) {
		return (type.isTypeOrSubTypeOf(ConfigurationSerializable.class) 
				&& !_classMappings.containsKey(new ClassKey(type.getRawClass()))) ? 
						new BukkitSerializer(type.getRawClass(), null) : super.findSerializer(config, type, beanDesc);
	}
	
}
