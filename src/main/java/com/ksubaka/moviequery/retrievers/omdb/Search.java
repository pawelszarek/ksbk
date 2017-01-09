package com.ksubaka.moviequery.retrievers.omdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class Search {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;


    String getTitle() {
        return title;
    }

    String getYear() {
        return year;
    }

}