package com.ksubaka.moviequery.retrievers.omdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class OmdbDetailedResponse {
    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Director")
    private String director;

    @JsonCreator
    public OmdbDetailedResponse(@JsonProperty("Title") String title, @JsonProperty("Year") String year, @JsonProperty("Director") String director) {
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
