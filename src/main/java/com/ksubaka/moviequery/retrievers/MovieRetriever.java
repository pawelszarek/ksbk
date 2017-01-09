package com.ksubaka.moviequery.retrievers;

import com.ksubaka.moviequery.model.Movie;

import java.util.List;

public interface MovieRetriever {
    List<Movie> retrieve(String name);
}
