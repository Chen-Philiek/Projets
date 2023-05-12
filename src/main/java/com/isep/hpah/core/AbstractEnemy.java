package com.isep.hpah.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public abstract class AbstractEnemy extends Character {
     private int damage;
     private int health;


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

    public void voldturn(Wizard wizard){
        if (this.getHealth() > 0){
            int damageavada = 500;
            System.out.println("C'est au tour de " + this.getName() + "!");
            System.out.println("Le boss " + this.getName() + " vous attaque avec Avada kadavra et vous inflige : " + damageavada + " de dégâts");
            wizard.takeDamageAv(damageavada);
        }
    }

    public void takeDamage(Wizard wizard ,int damage) {
        if (wizard.getHouse()== House.SLYTHERIN){
            this.health -= (damage+10);
        }else{
            this.health -= damage;
        }
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
