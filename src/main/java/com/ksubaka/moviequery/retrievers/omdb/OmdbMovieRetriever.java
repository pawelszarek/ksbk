package com.ksubaka.moviequery.retrievers.omdb;

import com.ksubaka.moviequery.exceptions.MovieRetrieverException;
import com.ksubaka.moviequery.model.Movie;
import com.ksubaka.moviequery.model.Production;
import com.ksubaka.moviequery.retrievers.AbstractMovieRetriever;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.ArrayList;
import java.util.List;

public class OmdbMovieRetriever extends AbstractMovieRetriever {
    private static final String GENERAL_SEARCH_URL = "http://omdbapi.com/?s={movie}&r=json&type=movie";
    private static final String DETAILED_SEARCH_URL = "http://omdbapi.com/?t={title}&y={year}&r=json";

    public List<Production> retrieve(String name) throws MovieRetrieverException {
        List<Production> movies = new ArrayList<>();
        try {
            HttpResponse<OmdbSearchResponse> httpSearchResponse = Unirest
                    .get(GENERAL_SEARCH_URL)
                    .routeParam("movie", name)
                    .asObject(OmdbSearchResponse.class);
            for (Search search : httpSearchResponse.getBody().getSearchList()) {
                HttpResponse<OmdbDetailedResponse> httpDetailedResponse = Unirest
                        .get(DETAILED_SEARCH_URL)
                        .routeParam("title", search.getTitle())
                        .routeParam("year", search.getYear())
                        .asObject(OmdbDetailedResponse.class);
                movies.add(new Movie(httpDetailedResponse.getBody().getTitle(), httpDetailedResponse.getBody().getYear(), httpDetailedResponse.getBody().getDirector()));
            }

        } catch (UnirestException e) {
            throw new MovieRetrieverException(e.getMessage());
        }
        return movies;
    }
}
