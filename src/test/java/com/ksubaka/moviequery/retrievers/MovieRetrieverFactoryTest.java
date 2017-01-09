package com.ksubaka.moviequery.retrievers;

import com.ksubaka.moviequery.model.ApiType;
import static org.hamcrest.CoreMatchers.instanceOf;

import com.ksubaka.moviequery.retrievers.omdb.OmdbMovieRetrieverTest;
import org.junit.Assert;
import org.junit.Test;

public class MovieRetrieverFactoryTest {
    @Test
    public void testFactory() throws Exception {
        MovieRetrieverFactory factory = new MovieRetrieverFactory();
        MovieRetriever retriever = factory.getProperRetriever(ApiType.OMDB);
        Assert.assertNotNull(retriever);
        Assert.assertThat(retriever, instanceOf(OmdbMovieRetrieverTest.class));
    }
}
