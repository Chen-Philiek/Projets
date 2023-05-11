package com.isep.hpah.core;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    void randomHouse() {
        // Création d'une liste contenant toutes les maisons possibles
        List<House> allHouses = Arrays.asList(House.GRYFFINDOR, House.HUFFLEPUFF, House.RAVENCLAW, House.SLYTHERIN);

        // Exécution de la méthode randomHouse()
        House house = House.randomHouse(new Wizard());

        // Vérification que la maison obtenue fait partie des maisons possibles
        assertTrue(allHouses.contains(house));
    }

    @Test
    void getHouse() {
        // Création d'un sorcier
        Wizard wizard = new Wizard();

        // Exécution de la méthode getHouse()
        House house = House.getHouse(wizard);

        // Vérification que la maison obtenue est égale à celle retournée par randomHouse()
        assertEquals(house, House.randomHouse(wizard));
    }

    @Test
    void values() {
        // Vérification des valeurs de l'énumération House
        assertArrayEquals(new House[]{House.GRYFFINDOR, House.HUFFLEPUFF, House.RAVENCLAW, House.SLYTHERIN}, House.values());
    }

    @Test
    void valueOf() {
        // Récupération d'une maison en utilisant la méthode valueOf()
        House house = House.valueOf("GRYFFINDOR");

        // Vérification que la maison obtenue est égale à la maison GRYFFINDOR
        assertEquals(House.GRYFFINDOR, house);
    }
}
