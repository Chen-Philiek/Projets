package com.isep.hpah.core;

public class Spell extends AbstractSpell {

    public Spell(String name, int power) {
        super(name, power);
    }

    @Override
    public void effect(Character character) {
        System.out.println("Le sort " + getName() + " est lancé sur " + character.getName() + " et lui inflige " + getPower() + " points de dégâts !");
        character.takeDamage(getPower());
    }
}
