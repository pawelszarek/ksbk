package com.ksubaka.moviequery.retrievers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

import java.io.IOException;

public abstract class AbstractProductionRetriever implements ProductionRetriever {
    public AbstractProductionRetriever() {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public <T>T retrieveResponseBody(String URL, Class<T> type, RouteParameter... parameters) throws UnirestException {
        GetRequest getRequest = Unirest.get(URL);
        setRequestRouteParameters(getRequest, parameters);
        HttpResponse<T> httpSearchResponse = getRequest.asObject(type);
        return httpSearchResponse.getBody();
    }

    private void setRequestRouteParameters(GetRequest request, RouteParameter[] parameters) {
        for (RouteParameter parameter : parameters) {
            request.routeParam(parameter.getName(), parameter.getValue());
        }
    }

}
