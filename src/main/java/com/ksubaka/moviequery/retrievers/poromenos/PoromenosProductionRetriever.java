package com.ksubaka.moviequery.retrievers.poromenos;

import com.ksubaka.moviequery.exceptions.ProductionRetrieverException;
import com.ksubaka.moviequery.model.Production;
import com.ksubaka.moviequery.model.Show;
import com.ksubaka.moviequery.retrievers.AbstractProductionRetriever;
import com.ksubaka.moviequery.retrievers.RouteParameter;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.ArrayList;
import java.util.List;

public class PoromenosProductionRetriever extends AbstractProductionRetriever {
    private final static String SEARCH_URL = "http://imdbapi.poromenos.org/json/?name={name}";

    public List<Production> retrieve(String name) throws ProductionRetrieverException {
        List<Production> series = new ArrayList<>();
        try {
            PoromenosResponse response = retrieveResponseBody(SEARCH_URL, PoromenosResponse.class, new RouteParameter("name", name));
            if (response != null && response.getShows() != null) {
                for (com.ksubaka.moviequery.retrievers.poromenos.Show show : response.getShows()) {
                    series.add(new Show(show.getName(), show.getYear()));
                }
            }
        } catch (UnirestException e) {
            throw new ProductionRetrieverException(e.getMessage());
        }
        return series;
    }
}
