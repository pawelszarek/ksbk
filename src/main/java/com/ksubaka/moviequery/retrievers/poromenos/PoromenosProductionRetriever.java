package com.ksubaka.moviequery.retrievers.poromenos;

import com.ksubaka.moviequery.exceptions.ProductionRetrieverException;
import com.ksubaka.moviequery.model.Production;
import com.ksubaka.moviequery.model.Show;
import com.ksubaka.moviequery.retrievers.AbstractProductionRetriever;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.ArrayList;
import java.util.List;

public class PoromenosProductionRetriever extends AbstractProductionRetriever {
    private static final String SEARCH_URL = "http://imdbapi.poromenos.org/json/?name={name}";

    public List<Production> retrieve(String name) throws ProductionRetrieverException {
        List<Production> series = new ArrayList<>();
        try {
            HttpResponse<PoromenosResponse> httpSearchResponse = Unirest
                    .get(SEARCH_URL)
                    .routeParam("name", name)
                    .asObject(PoromenosResponse.class);
            if (httpSearchResponse.getBody() != null && httpSearchResponse.getBody().getShows() != null) {
                for (com.ksubaka.moviequery.retrievers.poromenos.Show show : httpSearchResponse.getBody().getShows()) {
                    series.add(new Show(show.getName(), show.getYear()));
                }
            }
        } catch (UnirestException e) {
            throw new ProductionRetrieverException(e.getMessage());
        }
        return series;
    }
}
