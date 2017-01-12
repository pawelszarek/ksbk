package com.ksubaka.moviequery.retrievers.omdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class OmdbSearchResponse {

    @JsonProperty("Search")
    private List<Search> searchList;

    @JsonCreator
    public OmdbSearchResponse(@JsonProperty("Search") List<Search> searchList) {
        this.searchList = searchList;
    }

    List<Search> getSearchList() {
        return searchList;
    }
}
