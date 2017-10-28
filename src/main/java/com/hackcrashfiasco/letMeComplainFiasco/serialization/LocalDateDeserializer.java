package com.hackcrashfiasco.letMeComplainFiasco.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    public LocalDateDeserializer(){
        this(null);
    }

    public LocalDateDeserializer(JavaType valueType) {
        super(valueType);
    }

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.UK);

        return LocalDate.parse(p.getText(),df);
    }
}
