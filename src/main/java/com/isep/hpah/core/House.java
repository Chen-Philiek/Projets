package com.isep.hpah.core;
import java.util.Random;
public enum House {
    GRYFFINDOR,
    HUFFLEPUFF,
    RAVENCLAW,
    SLYTHERIN;

    private static final Random ran = new Random();

    public static House randomHouse(){
        House[] houses = values();
        House HouseName = houses[ran.nextInt(houses.length)];
        System.out.println("Votre maison est : " + HouseName);
        return HouseName;
    }


}
