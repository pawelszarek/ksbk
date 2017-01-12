package com.ksubaka.moviequery.retrievers.poromenos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Show {

    @JsonCreator
    Show(@JsonProperty("name") String name, @JsonProperty("year") String year) {
        this.name = name;
        this.year = year;
    }

    @JsonProperty
    private String name;

    @JsonProperty
    private String year;


    String getName() {
        return name;
    }

    String getYear() {
        return year;
    }
}
