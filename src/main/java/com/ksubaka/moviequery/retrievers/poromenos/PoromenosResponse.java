package com.ksubaka.moviequery.retrievers.poromenos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class PoromenosResponse {
    private List<Show> shows;

    @JsonCreator
    PoromenosResponse (@JsonProperty("shows") List<Show> shows) {
        this.shows = shows;
    }

    List<Show> getShows() {
        return shows;
    }
}
