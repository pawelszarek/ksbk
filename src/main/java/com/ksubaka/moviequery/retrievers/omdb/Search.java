package com.ksubaka.moviequery.retrievers.omdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Search {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;


    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

}