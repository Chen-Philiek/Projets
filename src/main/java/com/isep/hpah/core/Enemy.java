package com.isep.hpah.core;

public class Enemy extends AbstractEnemy {

    public Enemy(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void attack(Character character) {
        System.out.println("L'ennemi " + getName() + " attaque " + character.getName() + " et lui inflige " + getDamage() + " points de dégâts !");
        character.takeDamage(getDamage());
    }
}
