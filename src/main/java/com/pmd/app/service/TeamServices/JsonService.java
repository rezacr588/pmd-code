package com.pmd.app.service.TeamServices;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JsonService {

  private final ObjectMapper mapper;

  public JsonService(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  public String convertToJson(Object object) {
    try {
      return mapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return "";
    }
  }
}