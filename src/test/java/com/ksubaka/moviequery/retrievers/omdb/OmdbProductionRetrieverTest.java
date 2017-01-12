package com.ksubaka.moviequery.retrievers.omdb;

import com.ksubaka.moviequery.exceptions.ProductionRetrieverException;
import com.ksubaka.moviequery.model.Production;
import com.ksubaka.moviequery.retrievers.RouteParameter;
import com.ksubaka.moviequery.retrievers.poromenos.PoromenosProductionRetriever;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class OmdbProductionRetrieverTest {

    private OmdbProductionRetriever productionRetriever;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);

    @Before
    public void setUp() {
        productionRetriever = spy(new OmdbProductionRetriever());
    }

    @Test
    public void testOmdbProductionRetriever_nothingFound() throws Exception {
        doReturn(null).when(productionRetriever).retrieveResponseBody(any(String.class), eq(OmdbSearchResponse.class), any(RouteParameter.class));
        List<Production> result = productionRetriever.retrieve("Batman");
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testPoromenosProductionRetriever_noParameter() throws Exception {
        doReturn(null).when(productionRetriever).retrieveResponseBody(any(String.class), eq(OmdbSearchResponse.class), any(RouteParameter.class));
        List<Production> result = productionRetriever.retrieve(null);
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testPoromenosProductionRetriever_singleResponseFound() throws Exception {
        List<Search> searches = new ArrayList<>();
        searches.add(new Search("Batman Returns", "1989"));
        OmdbSearchResponse searchResponse = new OmdbSearchResponse(searches);
        doReturn(searchResponse).when(productionRetriever).retrieveResponseBody(any(String.class), eq(OmdbSearchResponse.class), any(RouteParameter.class));

        OmdbDetailedResponse detailedResponse = new OmdbDetailedResponse("Batman Returns", "1989", "Tim Burton");
        doReturn(detailedResponse).when(productionRetriever).retrieveResponseBody(any(String.class), eq(OmdbDetailedResponse.class), any(RouteParameter.class), any(RouteParameter.class));
        List<Production> result = productionRetriever.retrieve("Batman");
        Assert.assertFalse(result.isEmpty());
        Assert.assertEquals(result.size(), 1);
        Assert.assertTrue(result.get(0) instanceof com.ksubaka.moviequery.model.Movie);
    }

    @Test(expected = ProductionRetrieverException.class)
    public void testPoromenosProductionRetriever_singleResponseFound_thereIsNoDetailedInformation() throws Exception {
        List<Search> searches = new ArrayList<>();
        searches.add(new Search("Batman Returns", "1989"));
        OmdbSearchResponse searchResponse = new OmdbSearchResponse(searches);
        doReturn(searchResponse).when(productionRetriever).retrieveResponseBody(any(String.class), eq(OmdbSearchResponse.class), any(RouteParameter.class));

        doReturn(null).when(productionRetriever).retrieveResponseBody(any(String.class), eq(OmdbDetailedResponse.class), any(RouteParameter.class), any(RouteParameter.class));
        productionRetriever.retrieve("Batman");
    }
}
