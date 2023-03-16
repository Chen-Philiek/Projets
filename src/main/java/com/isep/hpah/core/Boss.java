package com.isep.hpah.core;

public class Boss extends AbstractEnemy {
    private BossLevel type;

    public Boss(String name, int damage, int health, BossLevel type) {
        super(name, damage, health);
        this.type = type;
    }




    @Override
    public String toString() {
        return "Boss [type=" + type + ", name=" + getName() + ", damage=" + getDamage() + ", health=" + getHealth() + "]";
    }
}
