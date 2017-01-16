package com.ksubaka.moviequery.retrievers.omdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class OmdbDetailedResponse {
    private String title;
    private String year;
    private String director;

    @JsonCreator
    OmdbDetailedResponse(@JsonProperty("Title") String title, @JsonProperty("Year") String year, @JsonProperty("Director") String director) {
        this.title = title;
        this.year = year;
        this.director = director;
    }

    String getTitle() {
        return title;
    }

    String getYear() {
        return year;
    }

    String getDirector() {
        return director;
    }
}
