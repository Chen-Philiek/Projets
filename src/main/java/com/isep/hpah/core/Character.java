package com.isep.hpah.core;

import lombok.*;

@Getter @Setter
public class Character {

    private String name;
    private int health;
    private boolean alive;
    private int damage;

    public Character(String name, int healthPoints, int damage ) {
        this.name = name;
        this.health= healthPoints;
        this.damage = damage;
    }



    public int getHealth() {

        return (int) (Math.random() * 20) +1;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void attack(Character target) {
        System.out.println(this.name + " attacks " + target.getName() + "!");
        int damage = 10; // TODO: implement actual damage calculation
        target.setHealth(target.getHealth() - damage);
        System.out.println(target.getName() + " takes " + damage + " damage.");
    }
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " est mort !");
            alive = false;
        } else {
            System.out.println(name + " a subi " + damage + " points de dégâts et il lui reste " + health + " points de vie.");
        }
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
