package com.ksubaka.moviequery.retrievers.omdb;

import com.ksubaka.moviequery.exceptions.ProductionRetrieverException;
import com.ksubaka.moviequery.model.Movie;
import com.ksubaka.moviequery.model.Production;
import com.ksubaka.moviequery.retrievers.AbstractProductionRetriever;
import com.ksubaka.moviequery.retrievers.RouteParameter;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.ArrayList;
import java.util.List;

public class OmdbProductionRetriever extends AbstractProductionRetriever {
    private static final String GENERAL_SEARCH_URL = "http://omdbapi.com/?s={movie}&r=json&type=movie";
    private static final String DETAILED_SEARCH_URL = "http://omdbapi.com/?t={title}&y={year}&r=json";

    public List<Production> retrieve(String name) throws ProductionRetrieverException {
        List<Production> movies = new ArrayList<>();
        try {
            OmdbSearchResponse searchResponse = retrieveResponseBody(GENERAL_SEARCH_URL, OmdbSearchResponse.class, new RouteParameter("movie", name));
            if (searchResponse != null && searchResponse.getSearchList() != null) {
                for (Search search : searchResponse.getSearchList()) {
                    OmdbDetailedResponse detailedResponse = retrieveResponseBody(DETAILED_SEARCH_URL, OmdbDetailedResponse.class,
                            new RouteParameter("title", search.getTitle()), new RouteParameter("year", search.getYear()));
                    if (detailedResponse == null) {
                        throw new ProductionRetrieverException("Error accessing data. Contact OMDB/IMDB");
                    }
                    movies.add(new Movie(detailedResponse.getTitle(), detailedResponse.getYear(), detailedResponse.getDirector()));
                }
            }
        } catch (UnirestException e) {
            throw new ProductionRetrieverException(e.getMessage());
        }
        return movies;
    }
}
