package com.ksubaka.moviequery.retrievers.poromenos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Show {
    private String name;
    private String year;

    @JsonCreator
    Show(@JsonProperty("name") String name, @JsonProperty("year") String year) {
        this.name = name;
        this.year = year;
    }

    String getName() {
        return name;
    }

    String getYear() {
        return year;
    }
}
