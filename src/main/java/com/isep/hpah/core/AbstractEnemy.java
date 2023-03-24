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

    public void enemyturn(Wizard wizard){
        if (this.getHealth() > 0){
            int damage1 = this.getDamage();
            System.out.println("C'est au tour du " + this.getName() + "!");
            System.out.println("Le " + this.getName() + " vous attaque et vous inflige : " + damage1 + " de dégâts");
            wizard.takeDamage(damage1);
        }

    }

    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println("Le " + this.getName() + " prend " + damage + " points de dégâts !");
        System.out.println("-----------------------------------------");
        System.out.println("Le " + this.getName() + " n'a plus que : " + health + " points de vies !" );
        System.out.println("-----------------------------------------");
        if (this.health <= 0) {
            this.setAlive(false);
            System.out.println("Le "+ this.getName() + " est mort !");


        }
    }

}
