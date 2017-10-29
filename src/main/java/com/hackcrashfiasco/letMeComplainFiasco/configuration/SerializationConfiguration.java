package com.hackcrashfiasco.letMeComplainFiasco.configuration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.hackcrashfiasco.letMeComplainFiasco.serialization.LocalDateDeserializer;
import com.hackcrashfiasco.letMeComplainFiasco.serialization.LocalDateSerializer;
import com.hackcrashfiasco.letMeComplainFiasco.serialization.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class SerializationConfiguration {


    @Autowired
    public SerializationConfiguration(ObjectMapper objectMapper){
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        objectMapper.registerModule(module);

    }

}
