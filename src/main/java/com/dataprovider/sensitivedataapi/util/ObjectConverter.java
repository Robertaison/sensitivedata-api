package com.dataprovider.sensitivedataapi.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ObjectConverter {

  private final ObjectMapper mapper;

  public <T> T toObject(String json, Class<T> clazz) {
    try {
      return mapper.readValue(json, clazz);
    } catch (IOException e) {
      throw new IllegalArgumentException("Cannot convert "
          + json + " to object type " + clazz.getSimpleName(), e);
    }
  }
}
