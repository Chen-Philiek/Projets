package com.isep.hpah.core;

public class Enemy extends AbstractEnemy {
    private EnemyType type;

    public Enemy(String name, int damage, int health, EnemyType type) {
        super(name, damage, health);
        this.type = type;
    }




    @Override
    public String toString() {
        return "Enemy [type=" + type + ", name=" + getName() + ", damage=" + getDamage() + ", health=" + getHealth() + "]";
    }
}
