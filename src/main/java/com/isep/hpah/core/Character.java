package com.isep.hpah.core;
import lombok.*;



//@AllArgsConstructor

public abstract class Character{
    private static final int DODGE_CHANCE = 20;
    @Getter @Setter private String name;
    @Getter @Setter private int damage;
    @Getter @Setter private int health;
    @Getter @Setter private boolean alive;





    public String attack(Character Enemy) {

        return null;
    }


    protected int getDodgeChance() {
        return DODGE_CHANCE;
    }
}



