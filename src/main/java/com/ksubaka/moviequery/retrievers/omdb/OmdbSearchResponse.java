package com.ksubaka.moviequery.retrievers.omdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class OmdbSearchResponse {

    @JsonProperty("Search")
    private List<SearchResult> searchResults;

    public List<SearchResult> getSearchResults() {
        return searchResults;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SearchResult {

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

}
