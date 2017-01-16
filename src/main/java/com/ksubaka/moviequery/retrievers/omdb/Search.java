package com.ksubaka.moviequery.retrievers.omdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class Search {
    private String title;
    private String year;

    @JsonCreator
    Search(@JsonProperty("Title") String title, @JsonProperty("Year") String year) {
        this.title = title;
        this.year = year;
    }

    String getTitle() {
        return title;
    }

    String getYear() {
        return year;
    }

}