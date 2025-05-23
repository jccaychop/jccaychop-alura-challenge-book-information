package com.alurachallenge.gutendex.service;

public interface IDataConverter {
    <T> T fromJson(String json, Class<T> clase);
}
