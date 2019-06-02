package net.voigon.jackson.bukkitserializers.deser.key;

import org.bukkit.Chunk;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import com.fasterxml.jackson.databind.module.SimpleKeyDeserializers;

public class BukkitKeyDeserializers extends SimpleKeyDeserializers {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3769460905734264919L;

	public BukkitKeyDeserializers() {
		addDeserializer(Chunk.class, new ChunkKeyDeserializer());
		addDeserializer(PotionEffectType.class, new PotionEffectTypeKeyDeserializer());
		addDeserializer(NamespacedKey.class, new NamespacedKeyKeyDeserializer());
		addDeserializer(OfflinePlayer.class, new OfflinePlayerKeyDeserializer());
		addDeserializer(Enchantment.class, new EnchantmentKeyDeserializer());
		addDeserializer(Color.class, new ColorKeyDeserializer());
		addDeserializer(Player.class, new PlayerKeyDeserializer());
		
	}
}
