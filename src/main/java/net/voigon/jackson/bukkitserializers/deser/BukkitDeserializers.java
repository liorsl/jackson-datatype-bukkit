package net.voigon.jackson.bukkitserializers.deser;

import net.md_5.bungee.api.chat.*;
import net.voigon.jackson.bukkitserializers.BukkitModule;
import net.voigon.jackson.bukkitserializers.internal.CraftTypeResolver;
import net.voigon.jackson.bukkitserializers.internal.NMSUtils;
import net.voigon.jackson.bukkitserializers.ser.NamespacedKeySerializer;
import org.bukkit.Chunk;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.type.ClassKey;

public class BukkitDeserializers extends SimpleDeserializers {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1046766209568867036L;

	public BukkitDeserializers(BukkitModule module) {
		addDeserializer(World.class, new WorldDeserializer(module));
		addDeserializer(Block.class, new BlockDeserializer());
		addDeserializer(Chunk.class, new ChunkDeserializer());
		addDeserializer(OfflinePlayer.class, new OfflinePlayerDeserializer(module));
		addDeserializer(PotionEffectType.class, new PotionEffectTypeDeserializer());
		addDeserializer(Enchantment.class, new EnchantmentDeserializer());
		addDeserializer(Player.class, new PlayerDeserializer(module));

		try {
			// Make sure the class exists
			Class.forName("org.bukkit.NamespacedKey");
			addDeserializer(NamespacedKey.class, new NamespacedKeyDeserializer());
		} catch (Exception e) {}

		BaseComponentDeserializer md5ChatComponent = new BaseComponentDeserializer();

		try {
			// Make sure the class exists
			Class.forName("net.md_5.bungee.api.chat.BaseComponent");
			addDeserializer(BaseComponent[].class, md5ChatComponent);
			addDeserializer(BaseComponent.class, md5ChatComponent.new SingleBaseComponentDeserializer());
		} catch (Exception e) {}

		try {
			// Make sure the class exists
			Class.forName("net.md_5.bungee.api.chat.TextComponent");
			addDeserializer(TextComponent[].class, md5ChatComponent.new GenericComponentCaster(TextComponent[].class));
			addDeserializer(TextComponent.class, md5ChatComponent.new SingleGenericComponentCaster(TextComponent.class));
		} catch (Exception e) {}

		try {
			// Make sure the class exists
			Class.forName("net.md_5.bungee.api.chat.KeybindComponent");
			addDeserializer(KeybindComponent[].class, md5ChatComponent.new GenericComponentCaster(KeybindComponent[].class));
			addDeserializer(KeybindComponent.class, md5ChatComponent.new SingleGenericComponentCaster(KeybindComponent.class));
		} catch (Exception e) {}

		try {
			// Make sure the class exists
			Class.forName("net.md_5.bungee.api.chat.SelectorComponent");
			addDeserializer(SelectorComponent[].class, md5ChatComponent.new GenericComponentCaster(SelectorComponent[].class));
			addDeserializer(SelectorComponent.class, md5ChatComponent.new SingleGenericComponentCaster(SelectorComponent.class));
		} catch (Exception e) {}

		try {
			// Make sure the class exists
			Class.forName("net.md_5.bungee.api.chat.ScoreComponent");
			addDeserializer(ScoreComponent[].class, md5ChatComponent.new GenericComponentCaster(ScoreComponent[].class));
			addDeserializer(ScoreComponent.class, md5ChatComponent.new SingleGenericComponentCaster(ScoreComponent.class));
		} catch (Exception e) {}

		try {
			// Make sure the class exists
			Class.forName("net.md_5.bungee.api.chat.TranslatableComponent");
			addDeserializer(TranslatableComponent[].class, md5ChatComponent.new GenericComponentCaster(TranslatableComponent[].class));
			addDeserializer(TranslatableComponent.class, md5ChatComponent.new SingleGenericComponentCaster(TranslatableComponent.class));
		} catch (Exception e) {}


	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public JsonDeserializer<?> findBeanDeserializer(JavaType type, DeserializationConfig config,
			BeanDescription beanDesc) throws JsonMappingException {
		return (type.isTypeOrSubTypeOf(ConfigurationSerializable.class) && _classMappings.containsKey(new ClassKey(type.getRawClass()))) ?
				new BukkitDeserializer(type.getRawClass()) : super.findBeanDeserializer(type, config, beanDesc);
	}
	
}
