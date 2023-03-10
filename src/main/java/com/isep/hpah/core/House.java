package com.isep.hpah.core;

public class House {
    public static final House GRYFFINDOR = new House("Gryffindor");
    public static final House HUFFLEPUFF = new House("hufflepuff");
    public static final House RAVENCLAW = new House("ravenclaw");
    public static final House SLYTHERIN = new House("Slytherin");

    private String name;

    public House(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
