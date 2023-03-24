package com.isep.hpah.core;
import java.util.Random;
public enum House {
    GRYFFINDOR,
    HUFFLEPUFF,
    RAVENCLAW,
    SLYTHERIN;

    private static final Random ran = new Random();

    public static House randomHouse(Wizard wizard){
        House[] houses = values();
        House HouseName = houses[ran.nextInt(houses.length)];
        System.out.println("Votre maison est : " + HouseName);
        if (HouseName.name() == "HUFFLEPUFF"){
            System.out.println("Les potions sont plus efficaces ! ");
        }
        if (HouseName.name() == "SLYTHERIN"){
            System.out.println("Les sorts sont plus efficaces maintenant !");

        }
        if (HouseName.name() == "GRYFFINDOR"){
            System.out.println("Tu es maintenant plus résistant aux dégâts !");

        }
        if (HouseName.name() == "RAVENCLAW"){
            System.out.println("Tu as plus de précision !");
        }
        return HouseName;
    }


    public static House getHouse(Wizard wizard) {
        return House.randomHouse(wizard);
    }

}
