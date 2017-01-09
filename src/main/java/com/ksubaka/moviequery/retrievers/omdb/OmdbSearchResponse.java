package com.ksubaka.moviequery.retrievers.omdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class OmdbSearchResponse {

    @JsonProperty("Search")
    private List<Search> searchList;

    public List<Search> getSearchList() {
        return searchList;
    }



}
