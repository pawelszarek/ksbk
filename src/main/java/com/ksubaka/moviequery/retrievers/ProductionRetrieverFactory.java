package com.ksubaka.moviequery.retrievers;

import com.ksubaka.moviequery.exceptions.ProductionRetrieverException;
import com.ksubaka.moviequery.model.ApiType;
import com.ksubaka.moviequery.retrievers.omdb.OmdbProductionRetriever;
import com.ksubaka.moviequery.retrievers.poromenos.PoromenosProductionRetriever;

public class ProductionRetrieverFactory {
    public ProductionRetriever getProperRetriever(ApiType apiType) throws ProductionRetrieverException {
        switch (apiType) {
            case OMDB:
                return new OmdbProductionRetriever();
            case POROMENOS:
                return new PoromenosProductionRetriever();
        }
        throw new ProductionRetrieverException("Unsupported API");
    }
}
