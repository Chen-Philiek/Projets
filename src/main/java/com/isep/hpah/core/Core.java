package com.isep.hpah.core;

public class Core {
    private String name;

    public Core(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getPower() {
        return (int) (Math.random() * 20) + 1;
    }


}
