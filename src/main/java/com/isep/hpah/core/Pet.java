package com.isep.hpah.core;
import java.util.Random;

public enum Pet {
    OWL,
    CAT,
    TOAD,
    RAT;

    private static final Random ran = new Random();

    public static Pet randomPet(){
        Pet[] pets = values();
        Pet PetName = pets[ran.nextInt(pets.length)];
        System.out.println("Votre animal est : " + PetName);
        return PetName;
    }
}
