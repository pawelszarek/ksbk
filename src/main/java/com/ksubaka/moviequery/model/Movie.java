package com.ksubaka.moviequery.model;

public class Movie {
    private final String title;
    private final String year;
    private final String director;

    public Movie(String title, String year, String director) {
        this.title = title;
        this.year = year;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }
}
