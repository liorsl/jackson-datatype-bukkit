package net.voigon.jackson.bukkitserializers.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.ComponentSerializer;

import java.io.IOException;
import java.util.Map;

public class BaseComponentSerializer extends StdSerializer<BaseComponent[]> {

    BaseComponentSerializer() {
        super(BaseComponent[].class);

    }

    @Override
    public void serialize(BaseComponent[] baseComponents, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(((ObjectMapper)serializerProvider.getGenerator().getCodec()).readValue(ComponentSerializer.toString(baseComponents), Map.class));
    }

    class SingleBaseComponentSerializer extends StdSerializer<BaseComponent> {

        public SingleBaseComponentSerializer() {
            super(BaseComponent.class);
        }

        @Override
        public void serialize(BaseComponent baseComponent, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            BaseComponentSerializer.this.serialize(new BaseComponent[] {baseComponent}, jsonGenerator, serializerProvider);

        }
    }

}
