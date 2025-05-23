package com.alurachallenge.gutendex.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DataAuthor(
        @JsonAlias("name")
        String name,

        @JsonAlias("birth_year")
        String birthYear,

        @JsonAlias("death_year")
        String deathYear
) {

}
