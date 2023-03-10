package com.isep.hpah.core;

public class Boss extends AbstractEnemy {

    private int bonusDamage;

    public Boss(String name, int health, int damage, int bonusDamage) {
        super(name, health, damage);
        this.bonusDamage = bonusDamage;
    }

    @Override
    public void attack(Character character) {
        System.out.println("Le boss " + getName() + " attaque " + character.getName() + " et lui inflige " + (getDamage() + bonusDamage) + " points de dégâts !");
        character.takeDamage(getDamage() + bonusDamage);
    }
}
