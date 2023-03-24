package com.isep.hpah.core;



public class Boss extends AbstractEnemy {
    private BossLevel typeboss;


    public Boss(String name, int damage, int health, BossLevel typeboss) {
        super(name, damage, health);
        this.typeboss = typeboss;

    }
    public static Boss createBasilik(){
        Boss Basilik = new Boss("Basilic", 25,55,BossLevel.BASILIC);
        return Basilik;
    }
    public static  Boss createVoledemort(){
        Boss Voledemort = new Boss("Voledemort",30, 60, BossLevel.VOLEDEMORT);
        return Voledemort;
    }
    public static Boss createDétraqueurs(){
        Boss Détraqueurs = new Boss("Détraqueurs", 25,55,BossLevel.DETRAQUEURS);
        return Détraqueurs;
    }



    @Override
    public String toString() {
        return "Boss [type=" + typeboss + ", name=" + getName() + ", damage=" + getDamage() + ", health=" + getHealth() + "]";
    }
}
