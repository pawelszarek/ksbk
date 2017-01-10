package com.ksubaka.moviequery.retrievers;

import com.ksubaka.moviequery.model.ApiType;
import static org.hamcrest.CoreMatchers.instanceOf;

import com.ksubaka.moviequery.retrievers.omdb.OmdbProductionRetriever;
import org.junit.Assert;
import org.junit.Test;

public class ProductionRetrieverFactoryTest {
    @Test
    public void testFactory() throws Exception {
        ProductionRetrieverFactory factory = new ProductionRetrieverFactory();
        ProductionRetriever retriever = factory.getProperRetriever(ApiType.OMDB);
        Assert.assertNotNull(retriever);
        Assert.assertThat(retriever, instanceOf(OmdbProductionRetriever.class));
    }
}
