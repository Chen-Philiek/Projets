package com.isep.hpah.core;
import lombok.*;

//@AllArgsConstructor

public abstract class Character{
    @Getter @Setter private String name;
    @Getter @Setter private int damage;
    @Getter @Setter private int Health;
    @Getter @Setter private boolean alive;



    public static void Tota(){
        Character.randomDamage();
        Character.randomHealth();
    }
    public static int randomDamage(){
        System.out.println("Votre attaque est de : " + Damage());
        return 0;
    }
    private static int Damage() {
        int damage = (int) (Math.random() * 21) + 10 ;
        return damage;
    }
    public static int randomHealth(){
        System.out.println("Vous avez : " + Health() + " points de vies");
        return 0;
    }
    private static int Health() {
        int Health = (int) (Math.random() * 21) + 100 ;
        return Health;
    }
}
