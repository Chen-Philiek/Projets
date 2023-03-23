package com.isep.hpah.core;

import lombok.*;
import java.util.List;

public class Wizard extends Character{
    @Getter @Setter private Pet pet;
    @Getter @Setter private Wand wand;
    @Getter @Setter  private House house;
    @Getter @Setter private List<Potion> potions;
    @Getter @Setter private List<Spell> knownSpells;
    @Getter @Setter private int health;
    @Getter @Setter private int max_health;


    public static int randomHealth(){
        System.out.println("Vous avez : " + health() + " points de vies");
        return health();
    }
    private static int health() {
        int health = 500 ;
        return health;
    }

    private static int max_health(){
        int max_health = 500;
        return max_health;
    }

    public static int MaxHealth(){
        System.out.println("Vous avez un au maximum " + max_health() + " au début de la partie");
        return max_health();
    }







    public void learnSpell(String spellName) {
        Spell.knownSpells.add(spellName);
    }


    public void takeDamage(Wizard wizard, int damage1) {
        wizard.setHealth(getHealth() - damage1);

        System.out.println(wizard.getName() + " prend " + damage1 + " points de dégâts !");
        System.out.println("-----------------------------------------------");
        System.out.println("|      Il vous reste :" + getHealth() + " points de vie !     |");
        System.out.println("-----------------------------------------------");

        if (getHealth() <= 0) {
            wizard.setAlive(false);
            System.out.println(wizard.getName() + " est mort !");

        }
    }

    public void Healing(Wizard wizard, int heal1) {
        wizard.setHealth(getHealth() + heal1);
        if (getHealth() > 500) {
            wizard.setHealth(getHealth() -(getHealth()- max_health()));
            System.out.println("Vous avez " +  getHealth() + " points de vies");
        } else {

            System.out.println(wizard.getName() + " régénère " + heal1 + " points de vies !");
            System.out.println("------------------------------------------------------");
            System.out.println("|      Vous avez maintenant :" + getHealth() + " points de vie !     |");
            System.out.println("------------------------------------------------------");
        }
    }

}







