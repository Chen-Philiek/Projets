package com.isep.hpah.core;
import lombok.*;



//@AllArgsConstructor

public abstract class Character{
    private static final int DODGE_CHANCE = 20;
    @Getter @Setter private String name;
    @Getter @Setter private int damage;
    @Getter @Setter private int health;
    @Getter @Setter private boolean alive;




/*
    if (house == "Pousouffle"){
        System.out.println("Les potions sont plus efficaces ! ");
    }
    if (house == "serpentard"){
        System.out.println("Les sorts sont plus efficaces maintenant !");
    }
    if (house == "Gryffondor"){
        System.out.println("Tu es maintenant plus résistant aux dégâts !);
    }
    if (house == "Serdaigle"){
        System.out.println("Tu as plus de précision !");
    }

 */


    protected int getDodgeChance() {
        return DODGE_CHANCE;
    }
}



