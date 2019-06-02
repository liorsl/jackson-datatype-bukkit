package net.voigon.jackson.bukkitserializers.deser;

import java.io.IOException;

import net.voigon.jackson.bukkitserializers.BukkitModule;
import org.bukkit.Location;
import org.bukkit.block.Block;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class BlockDeserializer extends StdDeserializer<Block> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8819227717966522387L;

	protected BlockDeserializer() {
		super(Block.class);

	}

	@Override
	public Block deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException, JsonProcessingException {
		return arg0.getCodec().readValue(arg0, Location.class).getBlock();
		/*ObjectMapper objectMapper = (ObjectMapper) arg0.getCodec();
		TreeNode node = arg0.getCodec().readTree(arg0);
		
		World world = objectMapper.reader().treeToValue(node.get("world"), World.class);
		int x = ((IntNode) node.get("x")).numberValue().intValue();
		int y = ((IntNode) node.get("y")).numberValue().intValue();
		int z = ((IntNode) node.get("z")).numberValue().intValue();

		return world.getBlockAt(new Location(world, x, y, z)); */
	}

}
