package com.ksubaka.moviequery.model;

public class Movie implements Production {
    private final String title;
    private final String year;
    private final String director;

    public Movie(String title, String year, String director) {
        this.title = title;
        this.year = year;
        this.director = director;
    }

    @Override
    public String print() {
        return title + " " + year + " " + director;
    }
}
