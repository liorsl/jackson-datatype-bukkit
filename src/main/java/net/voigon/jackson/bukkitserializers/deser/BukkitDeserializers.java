package net.voigon.jackson.bukkitserializers.deser;

import net.md_5.bungee.api.chat.*;
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
	
	public BukkitDeserializers() {
		addDeserializer(World.class, new WorldDeserializer());
		addDeserializer(Block.class, new BlockDeserializer());
		addDeserializer(Chunk.class, new ChunkDeserializer());
		addDeserializer(OfflinePlayer.class, new OfflinePlayerDeserializer());
		addDeserializer(PotionEffectType.class, new PotionEffectTypeDeserializer());
		addDeserializer(NamespacedKey.class, new NamespacedKeyDeserializer());
		addDeserializer(Enchantment.class, new EnchantmentDeserializer());
		addDeserializer(Player.class, new PlayerDeserializer());

		BaseComponentDeserializer md5ChatComponent = new BaseComponentDeserializer();
		addDeserializer(BaseComponent[].class, md5ChatComponent);
		addDeserializer(BaseComponent.class, md5ChatComponent.new SingleBaseComponentDeserializer());
		addDeserializer(TextComponent[].class, md5ChatComponent.new GenericComponentCaster(TextComponent[].class));
		addDeserializer(TextComponent.class, md5ChatComponent.new SingleGenericComponentCaster(TextComponent.class));
		addDeserializer(KeybindComponent[].class, md5ChatComponent.new GenericComponentCaster(KeybindComponent[].class));
		addDeserializer(KeybindComponent.class, md5ChatComponent.new SingleGenericComponentCaster(KeybindComponent.class));
		addDeserializer(SelectorComponent[].class, md5ChatComponent.new GenericComponentCaster(SelectorComponent[].class));
		addDeserializer(SelectorComponent.class, md5ChatComponent.new SingleGenericComponentCaster(SelectorComponent.class));
		addDeserializer(ScoreComponent[].class, md5ChatComponent.new GenericComponentCaster(ScoreComponent[].class));
		addDeserializer(ScoreComponent.class, md5ChatComponent.new SingleGenericComponentCaster(ScoreComponent.class));
		addDeserializer(TranslatableComponent[].class, md5ChatComponent.new GenericComponentCaster(TranslatableComponent[].class));
		addDeserializer(TranslatableComponent.class, md5ChatComponent.new SingleGenericComponentCaster(TranslatableComponent.class));


	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public JsonDeserializer<?> findBeanDeserializer(JavaType type, DeserializationConfig config,
			BeanDescription beanDesc) throws JsonMappingException {
		return (type.isTypeOrSubTypeOf(ConfigurationSerializable.class) && _classMappings.containsKey(new ClassKey(type.getRawClass()))) ?
				new BukkitDeserializer(type.getRawClass()) : super.findBeanDeserializer(type, config, beanDesc);
	}
	
}
