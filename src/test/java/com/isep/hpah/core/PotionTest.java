package com.isep.hpah.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PotionTest {

    @Test
    void listPotion() {
        // Exécution de la méthode ListPotion()
        Potion potion = Potion.ListPotion(new Wizard());

        // Vérification que la liste de potions du sorcier contient la potion retournée
        assertTrue(new Wizard().getPotions().contains(potion));
    }

    @Test
    void getHealAmount() {
        // Création de potions de test
        Potion potion1 = new Potion("Baume de Fierabras", "Brulure et cicacitre");
        Potion potion2 = new Potion("Brise-Lame", "Blessure magique");
        Potion potion3 = new Potion("Potion de Dittany ", "Blessure mineure");

        // Vérification des valeurs de guérison des potions
        assertEquals(100.0, potion1.getHealAmount());
        assertEquals(75.0, potion2.getHealAmount());
        assertEquals(55.0, potion3.getHealAmount());
    }

    @Test
    void getName() {
        // Création de potion de test
        Potion potion = new Potion("Baume de Fierabras", "Brulure et cicacitre");

        // Vérification du nom de la potion
        assertEquals("Baume de Fierabras", potion.getName());
    }

    @Test
    void getDescription() {
        // Création de potion de test
        Potion potion = new Potion("Baume de Fierabras", "Brulure et cicacitre");

        // Vérification de la description de la potion
        assertEquals("Brulure et cicacitre", potion.getDescription());
    }

    @Test
    void setName() {
        // Création de potion de test
        Potion potion = new Potion();

        // Définition du nom de la potion
        potion.setName("Baume de Fierabras");

        // Vérification du nom de la potion
        assertEquals("Baume de Fierabras", potion.getName());
    }

    @Test
    void setDescription() {
        // Création de potion de test
        Potion potion = new Potion();

        // Définition de la description de la potion
        potion.setDescription("Brulure et cicacitre");

        // Vérification de la description de la potion
        assertEquals("Brulure et cicacitre", potion.getDescription());
    }
}
