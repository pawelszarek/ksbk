package com.ksubaka.moviequery.retrievers.poromenos;

import com.ksubaka.moviequery.model.Production;
import com.ksubaka.moviequery.retrievers.RouteParameter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class PoromenosProductionRetrieverTest {

    private PoromenosProductionRetriever productionRetriever;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);

    @Before
    public void setUp() {
        productionRetriever = spy(new PoromenosProductionRetriever());
    }

    @Test
    public void testPoromenosProductionRetriever_nothingFound() throws Exception {
        doReturn(null).when(productionRetriever).retrieveResponseBody(any(String.class), eq(PoromenosResponse.class), any(RouteParameter.class));
        List<Production> result = productionRetriever.retrieve("Mario");
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testPoromenosProductionRetriever_noParameter() throws Exception {
        doReturn(null).when(productionRetriever).retrieveResponseBody(any(String.class), eq(PoromenosResponse.class), any(RouteParameter.class));
        List<Production> result = productionRetriever.retrieve(null);
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testPoromenosProductionRetriever_singleResponseFound() throws Exception {
        List<Show> shows = new ArrayList<>();
        shows.add(new Show("Mario", "1987"));
        PoromenosResponse poromenosResponse = new PoromenosResponse(shows);
        doReturn(poromenosResponse).when(productionRetriever).retrieveResponseBody(any(String.class), eq(PoromenosResponse.class), any(RouteParameter.class));
        List<Production> result = productionRetriever.retrieve("Mario");
        Assert.assertFalse(result.isEmpty());
        Assert.assertEquals(result.size(), 1);
        Assert.assertTrue(result.get(0) instanceof com.ksubaka.moviequery.model.Show);
    }
}
