package com.romance.engine.model;

public class Location {
    private final String name;
    private final String category;
    private final double rating;

    public Location(String name, String category, double rating) {
        this.name = name;
        this.category = category;
        this.rating = rating;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getRating() { return rating; }
}