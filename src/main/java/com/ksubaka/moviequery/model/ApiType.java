package com.ksubaka.moviequery.model;

public enum ApiType {
    OMDB("omdb"),
    POROMENOS("poromenos");

    private final String text;

    ApiType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }

    public static ApiType getEnum(String name) {
        for (ApiType v : values()) {
            if (v.toString().equalsIgnoreCase(name)) {
                return v;
            }
        }
        throw new IllegalArgumentException();
    }
}
