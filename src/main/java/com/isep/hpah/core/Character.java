package com.isep.hpah.core;
import lombok.*;



//@AllArgsConstructor

public abstract class Character{
    private static final int DODGE_CHANCE = 20;
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
        int Health = (int) (Math.random() * 21) + 500 ;
        return Health;
    }
    public String attack(Character Enemy) {

        return null;
    }
    public void takeDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
        System.out.println(this.getName() + " prend " + damage + " points de dégâts !");
        if (this.getHealth() <= 0) {
            this.setAlive(false);
            System.out.println(this.getName() + " est mort !");
        }
    }

    protected int getDodgeChance() {
        return DODGE_CHANCE;
    }
}



