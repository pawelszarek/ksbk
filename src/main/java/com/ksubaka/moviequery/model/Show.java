package com.ksubaka.moviequery.model;

public class Show implements Production {
    private final String name;
    private final String year;

    public Show(String name, String year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String print() {
        return name + " " + year;
    }
}
