package com.ksubaka.moviequery.retrievers.omdb;

import com.ksubaka.moviequery.model.ApiType;
import com.ksubaka.moviequery.model.Movie;
import com.ksubaka.moviequery.retrievers.MovieRetriever;
import com.ksubaka.moviequery.retrievers.MovieRetrieverFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class OmdbMovieRetrieverTest {
    @Test
    public void testOmdbMovieRetriever() throws Exception {
        MovieRetrieverFactory factory = new MovieRetrieverFactory();
        MovieRetriever retriever = factory.getProperRetriever(ApiType.OMDB);
        List<Movie> movies = retriever.retrieve("Indiana Jones");
        Assert.assertNotNull(movies);
    }
}
