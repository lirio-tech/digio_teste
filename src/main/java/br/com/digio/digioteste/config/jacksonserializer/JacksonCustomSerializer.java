package br.com.digio.digioteste.config.jacksonserializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JacksonCustomSerializer {

    private static final String DATE_FORMTAER_YYYY_MM_DD = "yyyyMMdd";

    public static class CustomLocalDateDeserializer extends StdDeserializer<LocalDate> {

        public CustomLocalDateDeserializer() {
            this(null);
        }
        public CustomLocalDateDeserializer(Class<?> vc) {
            super(vc);
        }
        @Override
        public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return LocalDate.parse(jsonParser.readValueAs(String.class), DateTimeFormatter.ofPattern(DATE_FORMTAER_YYYY_MM_DD));
        }
    }

    public static class CustomLocalDateSerializer extends StdSerializer<LocalDate> {
        protected CustomLocalDateSerializer() {
            this(null);
        }
        protected CustomLocalDateSerializer(Class<LocalDate> t) {
            super(t);
        }
        @Override
        public void serialize(LocalDate value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(value.format(DateTimeFormatter.ofPattern(DATE_FORMTAER_YYYY_MM_DD)));
        }
    }

}
