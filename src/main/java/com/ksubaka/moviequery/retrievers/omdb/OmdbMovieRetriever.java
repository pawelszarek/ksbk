package com.ksubaka.moviequery.retrievers.omdb;

import com.ksubaka.moviequery.model.Movie;
import com.ksubaka.moviequery.retrievers.AbstractMovieRetriever;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.ArrayList;
import java.util.List;

public class OmdbMovieRetriever extends AbstractMovieRetriever {
    private static final String URI = "http://omdbapi.com/?s={movie}&r=json";

    public List<Movie> retrieve(String name) {
        try {


            HttpResponse<OmdbSearchResponse> httpResponse = Unirest
                    .get(URI)
                    .routeParam("movie", name)
                    .asObject(OmdbSearchResponse.class);

            List<Movie> movies = new ArrayList<>();


        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }
}
