package com.fran.ejemplojdbc3.adaptadores;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LocalDateAdapter implements JsonSerializer<LocalDate> {
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");

	@Override
	public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
		//return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE));
		//return new JsonPrimitive(src.toString());
		//return new JsonPrimitive(src.format(DateTimeFormatter.BASIC_ISO_DATE));
		return new JsonPrimitive(formatter.format(src));  // En fecha española
		//return new JsonPrimitive(src.toEpochDay());  // Imprimir la fecha como número
	}

}
