package com.ksubaka.moviequery.retrievers.poromenos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class PoromenosResponse {

    @JsonProperty
    private List<Show> shows;

    public List<Show> getShows() {
        return shows;
    }
}
