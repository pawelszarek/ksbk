package com.ksubaka.moviequery.retrievers;

import com.ksubaka.moviequery.exceptions.MovieRetrieverException;
import com.ksubaka.moviequery.model.ApiType;
import com.ksubaka.moviequery.retrievers.omdb.OmdbMovieRetriever;

public class MovieRetrieverFactory {
    public MovieRetriever getProperRetriever(ApiType apiType) throws MovieRetrieverException {
        switch (apiType) {
            case OMDB:
                return new OmdbMovieRetriever();
            case POROMENOS:
                return new PoromenosMovieRetriever();
        }
        throw new MovieRetrieverException("Unsupported API");
    }
}
