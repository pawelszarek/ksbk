package com.ksubaka.moviequery.retrievers;

public class RouteParameter {
    private final String name;
    private final String value;

    public RouteParameter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    String getName() {
        return name;
    }

    String getValue() {
        return value;
    }
}
