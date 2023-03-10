package com.isep.hpah.core;

public class ForbiddenSpell extends AbstractSpell {

    private int damage;
    private String effect;

    public ForbiddenSpell(String name, int levelRequired, int damage, String effect) {
        super(name, levelRequired);
        this.damage = damage;
        this.effect = effect;
    }

    public int getDamage() {
        return damage;
    }

    public String getEffect() {
        return effect;
    }

    @Override
    public void effect(Character character) {
        System.out.println("Vous ne pouvez pas utiliser ce sortilège interdit !");
    }
}