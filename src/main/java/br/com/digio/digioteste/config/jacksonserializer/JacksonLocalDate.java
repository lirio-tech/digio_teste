package br.com.digio.digioteste.config.jacksonserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@JsonDeserialize(using = JacksonCustomSerializer.CustomLocalDateDeserializer.class)
@JsonSerialize(using = JacksonCustomSerializer.CustomLocalDateSerializer.class)
public @interface JacksonLocalDate {

}
