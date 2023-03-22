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
    public static void Tota(){
        Wizard.randomHealth();
    }


    public static int randomHealth(){
        System.out.println("Vous avez : " + health() + " points de vies");
        return health();
    }
    private static int health() {
        int health = 500 ;
        return health;
    }









    public void learnSpell(String spellName) {
        Spell.knownSpells.add(spellName);
    }


    public void takeDamage(Wizard wizard, int damage1) {
        wizard.setHealth(getHealth() - damage1);

        System.out.println(wizard.getName() + " prend " + damage1 + " points de dégâts !");
        System.out.println("Il vous reste :" + getHealth() + " points de vie !");
        if (getHealth() <= 0) {
            wizard.setAlive(false);
            System.out.println(wizard.getName() + " est mort !");

        }
    }


}







