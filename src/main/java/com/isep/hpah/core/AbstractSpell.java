package com.isep.hpah.core;


public abstract class AbstractSpell {

    private String name;
    private int power;

    public AbstractSpell(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public abstract void effect(Character character);
}
