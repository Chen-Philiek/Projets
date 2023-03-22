package com.isep.hpah.core;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Getter;




public enum PotionList {
    Powerup("Potion de force","Potion de force"),
    Speedup("Potion de vitesse", "Potion de vitesse"),
    Defenseup("Potion de défense", "Potion de défense");

    private final String description;
    @Getter
    private final String name;

    PotionList(String description, String name) {
        this.description = description;
        this.name = name;
    }



    public String getDescription() {
        return description;
    }


    }

