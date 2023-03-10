package com.isep.hpah.core;


public abstract class AbstractEnemy {
    protected String name;
    protected int health;
    protected int damage;

    public AbstractEnemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public abstract void attack(Character character);

    protected void dealDamage(Character character) {
        character.takeDamage(damage);
    }
}
