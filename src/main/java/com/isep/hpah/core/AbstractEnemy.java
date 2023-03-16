package com.isep.hpah.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public abstract class AbstractEnemy extends Character {
    @Getter @Setter private int damage;
    @Getter @Setter private int health;

    public AbstractEnemy(String name, int damage, int health) {
        this.setName(name);
        this.damage = damage;
        this.health = health;
        this.setAlive(true);
    }

    public String attack(Character target) {
        int damage = this.damage;
        target.setHealth(target.getHealth() - damage);
        System.out.println(this.getName() + " attaque " + target.getName() + " et lui inflige " + damage + " points de dégâts !");
        if (target.getHealth() <= 0) {
            target.setAlive(false);
            System.out.println(target.getName() + " est mort !");
        }
        return null;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(this.getName() + " prend " + damage + " points de dégâts !");
        if (this.health <= 0) {
            this.setAlive(false);
            System.out.println(this.getName() + " est mort !");
        }
    }
}
