package com.alurachallenge.gutendex.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBook(
        @JsonAlias("title")
        String title,

        @JsonAlias("authors")
        List<DataAuthor> dataAuthors,

        @JsonAlias("translators")
        List<DataAuthor> translators,

        @JsonAlias("languages")
        List<String> languages,

        @JsonAlias("download_count")
        Double downloadCount
) {
}
