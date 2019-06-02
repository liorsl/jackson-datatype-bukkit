package net.voigon.jackson.bukkitserializers.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.ComponentSerializer;

import java.io.IOException;

public class BaseComponentDeserializer extends StdDeserializer<BaseComponent[]> {

    BaseComponentDeserializer() {
        super(BaseComponent[].class);
    }

    @Override
    public BaseComponent[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return ComponentSerializer.parse(jsonParser.getValueAsString());
    }

    class SingleBaseComponentDeserializer extends StdDeserializer<BaseComponent> {

        public SingleBaseComponentDeserializer() {
            super(BaseComponent.class);
        }

        @Override
        public BaseComponent deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return BaseComponentDeserializer.this.deserialize(jsonParser, deserializationContext)[0];
        }


    }
    class GenericComponentCaster<T extends BaseComponent> extends StdDeserializer<T[]> {

        protected GenericComponentCaster(Class<T[]> type) {
            super(type);
        }

        @Override
        public T[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return (T[]) BaseComponentDeserializer.this.deserialize(jsonParser, deserializationContext);
        }

    }

    class SingleGenericComponentCaster<T extends BaseComponent> extends StdDeserializer<T> {

        protected SingleGenericComponentCaster(Class<T> type) {
            super(type);
        }

        @Override
        public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return (T) BaseComponentDeserializer.this.deserialize(jsonParser, deserializationContext)[0];
        }

    }

}
