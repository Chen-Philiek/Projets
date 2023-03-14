package com.isep.hpah.core;

public enum PotionList {
    Powerup("Potion de force"),
    Speedup("Potion de vitesse"),
    Defenseup("Potion de défense");

    private final String description;

    PotionList(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    }

