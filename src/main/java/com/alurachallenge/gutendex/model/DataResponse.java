package com.alurachallenge.gutendex.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataResponse(
        @JsonAlias("results")
        List<DataBook> dataBookList
) {
}
