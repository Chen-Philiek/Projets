package com.isep.hpah.core;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @Test
    void randomPet() {
        // Création d'une liste contenant tous les animaux possibles
        List<Pet> allPets = Arrays.asList(Pet.OWL, Pet.CAT, Pet.TOAD, Pet.RAT);

        // Exécution de la méthode randomPet()
        Pet pet = Pet.randomPet();

        // Vérification que l'animal obtenu fait partie des animaux possibles
        assertTrue(allPets.contains(pet));
    }

    @Test
    void values() {
        // Vérification des valeurs de l'énumération Pet
        assertArrayEquals(new Pet[]{Pet.OWL, Pet.CAT, Pet.TOAD, Pet.RAT}, Pet.values());
    }

    @Test
    void valueOf() {
        // Récupération d'un animal en utilisant la méthode valueOf()
        Pet pet = Pet.valueOf("CAT");

        // Vérification que l'animal obtenu est égal à l'animal CAT
        assertEquals(Pet.CAT, pet);
    }
}
