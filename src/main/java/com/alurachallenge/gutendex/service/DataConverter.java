package com.alurachallenge.gutendex.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IDataConverter {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T fromJson(String json, Class<T> toClass) {
        try {
            return objectMapper.readValue(json, toClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
