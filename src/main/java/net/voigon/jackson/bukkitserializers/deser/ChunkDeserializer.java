package net.voigon.jackson.bukkitserializers.deser;

import java.io.IOException;

import org.bukkit.Chunk;
import org.bukkit.World;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

public class ChunkDeserializer extends StdDeserializer<Chunk>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1962324026642478902L;
		
	protected ChunkDeserializer() {
		super(Chunk.class);
				
	}

	@Override
	public Chunk deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException, JsonProcessingException {
		TreeNode node = arg0.getCodec().readTree(arg0);

		World world = ((ObjectMapper) arg0.getCodec()).reader().treeToValue(node.get("world"), World.class);
		int x = ((IntNode) node.get("x")).numberValue().intValue();
		int z = ((IntNode) node.get("z")).numberValue().intValue();
		
		return world.getChunkAt(x, z);
	}
	
}
