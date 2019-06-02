package net.voigon.jackson.bukkitserializers.deser;

import java.io.IOException;

import org.bukkit.entity.Player;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.voigon.jackson.bukkitserializers.deser.key.PlayerKeyDeserializer;

public class PlayerDeserializer extends StdDeserializer<Player> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8600330377467101307L;

	private PlayerKeyDeserializer
			keyDeserializer = new PlayerKeyDeserializer();
	
	protected PlayerDeserializer() {
		super(Player.class);
		
	}

	@Override
	public Player deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		return keyDeserializer.deserializeKey(p.getText(), ctxt);
	}

}
