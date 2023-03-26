package com.isep.hpah.core;
import lombok.*;



//@AllArgsConstructor
@Getter @Setter
public abstract class Character {
    public int dogdeChance;
    private String name;

    private int damage;

    private int health;

    private boolean alive;




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


    /*public static int dodgeChance() {
        return  (int) (Math.random() * 101);

    }

     */
}



