package com.isep.hpah.core;

import java.util.List;


public class Wizard extends Character {
    private Pet pet;
    private Wand wand;
    private House house;
    private List<Spell> knownSpells;
    private List<Potion> potions;

    public Wizard(String name, House house, int health, int damage, Wand wand) {
        super(name, health, damage);
        this.pet = null; // par défaut, le sorcier n'a pas d'animal de compagnie
        this.wand = wand;
        this.house = house;
        this.knownSpells = null; // par défaut, le sorcier ne connaît aucun sort
        this.potions = null; // par défaut, le sorcier n'a aucune potion
    }

    public void castSpell(Spell spell, Character character) {
        if (knownSpells != null && knownSpells.contains(spell)) {
            System.out.println(getName() + " lance le sort " + spell.getName() + " sur " + character.getName() + ".");
            spell.effect(character);
        } else {
            System.out.println(getName() + " ne connaît pas le sort " + spell.getName() + " !");
        }
    }

    public void defend() {
        System.out.println(getName() + " se prépare à encaisser les attaques !");
    }
    public Wand getWand(){
        return wand;
    }
    public House getHouse(){
        return house;
    }
    public void setHouse(House house) {
        this.house = house;
    }
    public int getDamage() {
        int damage = super.getDamage();
        if (wand != null) {
            damage += wand.getPower();
        }
        return damage;
    }
}
