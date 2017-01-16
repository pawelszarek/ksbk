package com.ksubaka.moviequery.retrievers.omdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class OmdbSearchResponse {
    private List<Search> searchList;

    @JsonCreator
    OmdbSearchResponse(@JsonProperty("Search") List<Search> searchList) {
        this.searchList = searchList;
    }

    List<Search> getSearchList() {
        return searchList;
    }
}
