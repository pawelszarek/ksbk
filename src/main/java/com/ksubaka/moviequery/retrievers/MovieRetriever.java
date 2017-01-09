package com.ksubaka.moviequery.retrievers;

import com.ksubaka.moviequery.exceptions.MovieRetrieverException;
import com.ksubaka.moviequery.model.Movie;
import com.ksubaka.moviequery.model.Production;

import java.util.List;

public interface MovieRetriever {
    List<Production> retrieve(String name) throws MovieRetrieverException;
}
