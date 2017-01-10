package com.ksubaka.moviequery.retrievers;

import com.ksubaka.moviequery.exceptions.ProductionRetrieverException;
import com.ksubaka.moviequery.model.Production;

import java.util.List;

public interface ProductionRetriever {
    List<Production> retrieve(String name) throws ProductionRetrieverException;
}
