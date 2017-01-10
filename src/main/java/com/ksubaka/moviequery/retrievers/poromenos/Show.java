package com.ksubaka.moviequery.retrievers.poromenos;

import com.fasterxml.jackson.annotation.JsonProperty;

class Show {
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
